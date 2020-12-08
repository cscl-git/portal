package com.cscl.appointment.booking.admin.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAppointeeMaster;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;


@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/edit_appointment"
		},
		service = MVCActionCommand.class
	)

public class EditAppointmentMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		boolean isAllowed = false;
		int status = ParamUtil.getInteger(actionRequest, "status");
		String comment = ParamUtil.getString(actionRequest, "comment");
		String appointedDate = ParamUtil.getString(actionRequest, "appointedDate");
		String appointedDateTime = ParamUtil.getString(actionRequest, "appointedDateTime");
		long appointmentId = ParamUtil.getLong(actionRequest, "appointmentId");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		if(Validator.isNotNull(status)) {
			if(Validator.isNotNull(comment)) {
				if(Validator.isNotNull(appointedDate)) {
					if(Validator.isNotNull(appointedDateTime)) {
						isAllowed = true;
					}
				}
			}
		}
		Date dateAppointment = null;
		try {
			dateAppointment=new SimpleDateFormat("dd/MM/yyyy").parse(appointedDate);//yyyy-MM-dd
		}catch(Exception e) {
			dateAppointment = new Date();
			System.err.print("Error : While converting date");
		}
		if(isAllowed) {
			try {
				CsclAppointmentMaster appointment = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMaster(appointmentId);

				appointment.setComment(comment);
				appointment.setAppointedDate(dateAppointment);
				appointment.setStatus(status);
				appointment.setAppointedTime(appointedDateTime);
				appointment.setModifiedDate(new Date());
				CsclAppointmentMasterLocalServiceUtil.updateCsclAppointmentMaster(appointment);
				
				actionRequest.setAttribute("isResult", true);
				actionRequest.setAttribute("redirect", redirect);
				SessionMessages.add(actionRequest, "success-booking-appointment");
				
	            actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/tabs_page.jsp");
			}catch(Exception e) {
				e.getMessage();
				SessionErrors.add(actionRequest, e.getClass());
				actionRequest.setAttribute("redirect", redirect);
				actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/edit_appointment.jsp");
			}
		}else {
			SessionErrors.add(actionRequest, "Failed saving appointment");
			actionRequest.setAttribute("redirect", redirect);
			return;
		}
	}

}
