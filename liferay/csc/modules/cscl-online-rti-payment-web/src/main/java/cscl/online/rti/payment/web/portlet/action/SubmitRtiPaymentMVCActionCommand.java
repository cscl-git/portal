package cscl.online.rti.payment.web.portlet.action;

import java.util.Date;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.cscl.online.rti.payment.web.client.ExternalAPIClient;
import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.cscl.online.rti.payment.web.contract.EmailRequest;
import com.cscl.online.rti.payment.web.contract.EmailRequestInfo;
import com.cscl.online.rti.payment.web.contract.RequestInfo;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
"mvc.command.name=/rti/submit" }, service = MVCActionCommand.class)
public class SubmitRtiPaymentMVCActionCommand extends BaseMVCActionCommand {

	public static Log _log = LogFactoryUtil.getLog(SubmitRtiPaymentMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String name = ParamUtil.getString(actionRequest, "applicantName");
		String email = ParamUtil.getString(actionRequest, "applicantEmail");
		String mobile = ParamUtil.getString(actionRequest, "applicantMobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int rtiFees = 0;//ParamUtil.getInteger(actionRequest, "rtiFeeAmount");
		String subject = ParamUtil.getString(actionRequest, "rtiSubject");
		String refId = ParamUtil.getString(actionRequest, "refId");
		long id = ParamUtil.getLong(actionRequest, "id");
		
		try {
			CsclRtiPaymentDetails rti = CsclRtiPaymentDetailsLocalServiceUtil.createCsclRtiPaymentDetails(id);
			rti.setApplicantName(name);
			rti.setApplicantEmail(email);
			rti.setApplicantMobile(mobile);
			rti.setAddress(address);
			rti.setRefId(refId);
			rti.setRtiSubject(subject);
			rti.setRtiFeeAmount(rtiFees);
			rti.setCreatedDate(new Date());
			
			CsclRtiPaymentDetailsLocalServiceUtil.addCsclRtiPaymentDetails(rti);
			try {
				String token = ExternalAPIClient.generateAdminToken();
								
				ExternalAPIClient.sendMail(prepareEmailRequest(name, email, refId, token));
			}catch(Exception e) {
				_log.error("Error while sending RTI payment request notification ",e);	
			}

			actionRequest.setAttribute("refId", refId);
			actionRequest.setAttribute("isSubmitted", true);
			actionRequest.setAttribute("isResult", true);
			SessionMessages.add(actionRequest, "success-rti-payment");

			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
		}catch(Exception e) {
			_log.error("Error in RTI paument request submit",e);	
			SessionErrors.add(actionRequest, e.getClass());
			actionRequest.setAttribute("refId", refId);
			actionRequest.setAttribute("isSubmitted", false);
			actionRequest.setAttribute("isResult", false);
			actionResponse.getRenderParameters().setValue("mvcPath", "/rti/view.jsp");
		}
	}

	private EmailRequestInfo prepareEmailRequest(String name, String email, String refId, String token) {
		RequestInfo requestInfo = ExternalAPIClient.generateRequestInfo(token);
		EmailRequest emailRequest = new EmailRequest();
		emailRequest.setBody(getRTIPaymentText(name, refId));
		emailRequest.setEmail(email);
		emailRequest.setSubject("RTI Payment Request Notification");
		emailRequest.setHtml(true);
		
		EmailRequestInfo emailRequestInfo = new EmailRequestInfo();
		emailRequestInfo.setRequestInfo(requestInfo);
		emailRequestInfo.setEmailRequest(emailRequest);
		return emailRequestInfo;
	}

	private String getRTIPaymentText(String name, String refId) {
		StringBuilder sb = new StringBuilder();
		sb.append("<div>Dear "+name+",</div>");
		sb.append("<div>Your RTI payment request is saved with us. Your reference id is "+refId+". Please keep this reference id for any future references.</div>");
		sb.append("<br/>");
		sb.append("<br/><div>Thanks & Regards</div>");
		sb.append("<div>Support Team</div>");
		sb.append("<div>Chandigarh Smart City Limited</div>");
		return sb.toString();
	}
}
