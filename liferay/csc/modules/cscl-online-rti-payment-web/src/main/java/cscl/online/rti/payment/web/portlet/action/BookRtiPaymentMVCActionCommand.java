package cscl.online.rti.payment.web.portlet.action;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.cscl.online.rti.payment.web.client.ExternalAPIClient;
import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.cscl.online.rti.payment.web.contract.EmailRequest;
import com.cscl.online.rti.payment.web.contract.EmailRequestInfo;
import com.cscl.online.rti.payment.web.contract.RequestInfo;
import com.cscl.online.rti.payment.web.contract.SmsRequest;
import com.cscl.online.rti.payment.web.contract.SmsRequestInfo;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
		"mvc.command.name=/rti/view" }, service = MVCActionCommand.class)
public class BookRtiPaymentMVCActionCommand extends BaseMVCActionCommand {
	
	public static Log _log = LogFactoryUtil.getLog(BookRtiPaymentMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		boolean isAllowed = false;
		String name = ParamUtil.getString(actionRequest, "applicantName");
		String email = ParamUtil.getString(actionRequest, "applicantEmail");
		String mobile = ParamUtil.getString(actionRequest, "applicantMobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int rtiFees = 0;//ParamUtil.getInteger(actionRequest, "rtiFeeAmount");
		String subject = ParamUtil.getString(actionRequest, "rtiSubject");

		if (Validator.isNotNull(name)) {
			if (Validator.isNotNull(email)) {
				if (Validator.isNotNull(mobile)) {
					if (Validator.isNotNull(address)) {
						if (Validator.isNotNull(rtiFees)) {
							if (Validator.isNotNull(subject)) {
								isAllowed = true;
							}
						}
					}
				}
			}
		}

		if (isAllowed) {
			String refId = "RTI-";
			Date today = new Date();
			int year = 0;
			int month = 0;
			int day = 0;
			try {
				int total = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailsesCount()+1;
				year = today.getYear();
				year += 1900;
				month = today.getMonth();
				day = today.getDay();
				String days = "";
				String months = "";
				
				if (day < 10) {
					days = new DecimalFormat("00").format(day);
				}else {
					days = String.valueOf(day);
				}
				if (month < 10) {
					months = new DecimalFormat("00").format(month);
				}else {
					months = String.valueOf(month);
				}
				refId += year + "-" + months + "-" + days + "-";
				if (total > 999999) {
					refId += total;// if 6 digit exceeds
				} else {
					refId += String.format("%06d", total);// 6 digit sequestial number
				}
				_log.info("refId: " + refId);
			} catch (Exception e) {
				_log.error("Error in generate refId ",e);
			}
			
			try {
				long id = CounterLocalServiceUtil.increment(CsclRtiPaymentDetails.class.getName());
				CsclRtiPaymentDetails rti = CsclRtiPaymentDetailsLocalServiceUtil.createCsclRtiPaymentDetails(id);
				rti.setApplicantName(name);
				rti.setApplicantEmail(email);
				rti.setApplicantMobile(mobile);
				rti.setAddress(address);
				rti.setRefId(refId);
				rti.setRtiSubject(subject);
				rti.setRtiFeeAmount(rtiFees);
				
				String otp = generateOTP();
				String token = ExternalAPIClient.generateAdminToken();
				
				//Send SMS		
				ExternalAPIClient.sendSms(prepareSMSRequest(name, mobile, token, otp));
				
				//Send Email									
				ExternalAPIClient.sendMail(prepareEmailRequest(name, email, token, otp));
				
				actionRequest.setAttribute("refId", refId);				
				actionRequest.setAttribute("rtiObject", rti);
				actionRequest.setAttribute("isSubmitted", false);
				actionRequest.setAttribute("isResult", true);
				
				HttpSession httpSession = PortalUtil.getHttpServletRequest(actionRequest).getSession();
				httpSession.setAttribute("OTP", otp);
				httpSession.setAttribute("otpGenarationTime", System.currentTimeMillis());
				
				SessionMessages.add(actionRequest, "otp-sent-successful");
				actionResponse.getRenderParameters().setValue("mvcPath", "/rti/otpValidation.jsp");
			} catch (Exception e) {
				_log.error("Error in RTI payment ",e);
				SessionErrors.add(actionRequest, e.getClass());
				actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
			}
		} else {
			SessionErrors.add(actionRequest, "Please provide all mandatory field values");
			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
			return;
		}
	}

	private SmsRequestInfo prepareSMSRequest(String applicantName, String mobile, String token, String otp) {
		RequestInfo requestInfo = ExternalAPIClient.generateRequestInfo(token);
		SmsRequest smsRequest = new SmsRequest();
		smsRequest.setMobileNumber(mobile);
		smsRequest.setMessage(getOtpSMSText(applicantName, otp));
		
		SmsRequestInfo smsRequestInfo = new SmsRequestInfo();
		smsRequestInfo.setRequestInfo(requestInfo);
		smsRequestInfo.setSmsRequest(smsRequest);
		return smsRequestInfo;
	}
	
	private String getOtpSMSText(String applicantName, String otp) {
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ");
		sb.append(applicantName);
		sb.append(", ");
		sb.append(otp);
		sb.append(" is your one time password (OTP). ");					
		sb.append("Please enter the otp to validate the payment request.");
		return sb.toString();
	}

	private EmailRequestInfo prepareEmailRequest(String applicantName, String email, String token, String otp) {
		RequestInfo requestInfo = ExternalAPIClient.generateRequestInfo(token);
		EmailRequest emailRequest = new EmailRequest();
		emailRequest.setBody(getOtpEmailText(applicantName, otp));
		emailRequest.setEmail(email);
		emailRequest.setSubject("RTI Payment Request OTP");
		emailRequest.setHtml(true);
							
		EmailRequestInfo emailRequestInfo = new EmailRequestInfo();
		emailRequestInfo.setRequestInfo(requestInfo);
		emailRequestInfo.setEmailRequest(emailRequest);
		return emailRequestInfo;
	}
	
	private String getOtpEmailText(String applicantName, String otp) {
		StringBuilder sb = new StringBuilder();
		sb.append("<div>Dear ");
		sb.append(applicantName);
		sb.append(",</div>");
		sb.append("<br/><div>");
		sb.append(otp);
		sb.append("  is your one time password (OTP). ");					
		sb.append("Please enter the otp to validate the payment.</div>");
		sb.append("<br/>");
		sb.append("<br/><div>Thanks & Regards</div>");
		sb.append("<div>Support Team</div>");
		sb.append("<div>Chandigarh Smart City Limited</div>");
		return sb.toString();
	}

	public static String generateOTP() {
		Random rnd = new Random();
		int n = 100000 + rnd.nextInt(900000);
		return String.valueOf(n);
	}
}
