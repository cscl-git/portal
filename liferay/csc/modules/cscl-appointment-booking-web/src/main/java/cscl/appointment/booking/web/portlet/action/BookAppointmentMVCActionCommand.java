package cscl.appointment.booking.web.portlet.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.Captcha;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaSettings;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;
import com.liferay.portal.kernel.util.Validator;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
			"mvc.command.name=/appointment/view"
		},
		service = MVCActionCommand.class
	)

public class BookAppointmentMVCActionCommand  extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		boolean isAllowed = false;
		
		String name = ParamUtil.getString(actionRequest, "name");
		String email = ParamUtil.getString(actionRequest, "email");
		String mobile = ParamUtil.getString(actionRequest, "mobile");
		String address = ParamUtil.getString(actionRequest, "address");
		int appointee = ParamUtil.getInteger(actionRequest, "appointee");
		String preferedDate = ParamUtil.getString(actionRequest, "preferedDate");
		String preferedDateTime = ParamUtil.getString(actionRequest, "preferedDateTime");
		
		String reason = ParamUtil.getString(actionRequest, "reason");
		
		if(Validator.isNotNull(name)) {
			if(Validator.isNotNull(email)) {
				if(Validator.isNotNull(mobile)) {
					if(Validator.isNotNull(address)) {
						if(Validator.isNotNull(appointee)) {
							if(Validator.isNotNull(preferedDate)) {
								if(Validator.isNotNull(reason)) {
									isAllowed = true;
								}
							}
						}	
					}	
				}	
			}
		}
		
		if(isAllowed) {
			//if(isCaptchaVerified) {
				Date dateAppointment = new Date();
				long approverId = 0;
				String refId = "";
				int status = 0;//Pending
				Date today = new Date();
				int year = 0;
				try {
					int total = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount()+1;
					year=today.getYear();
					year += 1900;
					if(total > 99999) {
						refId = year+""+total;// if 5 digit exceeds
					}else {
						refId = year+""+String.format("%05d", total);// 5 digit sequestial number
					}
					
					dateAppointment=new SimpleDateFormat("dd/MM/yyyy").parse(preferedDate);//yyyy-MM-dd
				}catch(Exception e) {
					dateAppointment = new Date();
					System.err.println("Error : While converting date"+e);
				}
				
				try {
					long id = CounterLocalServiceUtil.increment(CsclAppointmentMaster.class.getName());
					
					//_csclPollsMaster.
					CsclAppointmentMaster appointment = CsclAppointmentMasterLocalServiceUtil.createCsclAppointmentMaster(id);
					appointment.setName(name);
					appointment.setEmail(email);
					appointment.setMobile(mobile);
					appointment.setPreferedDate(dateAppointment);
					appointment.setPreferedTime(preferedDateTime);
					appointment.setAddress(address);
					appointment.setReason(reason);
					appointment.setAppointee(appointee);
					appointment.setApprover(approverId);
					appointment.setStatus(status);
					appointment.setRefId(refId);
					appointment.setCreatedDate(today);
					CsclAppointmentMasterLocalServiceUtil.addCsclAppointmentMaster(appointment);
					
					actionRequest.setAttribute("refId", refId);
					actionRequest.setAttribute("isResult", true);
					SessionMessages.add(actionRequest, "success-booking-appointment");
					
		            actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
				}catch(Exception e) {
					e.getMessage();
					SessionErrors.add(actionRequest, e.getClass());
					actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
				}
			/*}else {
				System.out.println("Inside else...");
				actionRequest.setAttribute("isResult", false);
				actionResponse.setRenderParameter("mvcPath", "/appointment/view.jsp");
			}*/
		}else {
			//System.err.println(".......Failed Booking Appointment..............");
			SessionErrors.add(actionRequest, "Please provide all mandatory field values");
			actionResponse.getRenderParameters().setValue("mvcPath", "/appointment/view.jsp");
			return;
		}
	}

}
