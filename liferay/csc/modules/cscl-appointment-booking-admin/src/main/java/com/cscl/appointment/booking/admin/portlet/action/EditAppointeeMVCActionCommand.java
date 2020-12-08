package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/editAppointee"
		},
		service = MVCActionCommand.class
	)

public class EditAppointeeMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		boolean isAllowed = false;
		long appointeeId = ParamUtil.getLong(actionRequest, "appointeeId");
		//String name = ParamUtil.getString(actionRequest, "name");
		//String designation = ParamUtil.getString(actionRequest, "designation");
		String approverId = ParamUtil.getString(actionRequest, "approver");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String userName = "";
		
		if(Validator.isNotNull(appointeeId)) {
			if(Validator.isNotNull(approverId)) {
				isAllowed = true;
			}
		}
		try {
			User user = UserLocalServiceUtil.getUser(Long.valueOf(approverId));
			if(Validator.isNotNull(user)) {
				userName = user.getFullName();
			}
		}catch(Exception e) {
			System.err.println("Error : While getting user Id..");
		}
		if(isAllowed) {
			try {
				CsclApproverMapping approver = CsclApproverMappingLocalServiceUtil.findByAppointeeId((int)appointeeId).get(0);

				approver.setApprover(userName);
				approver.setAssignedTo(Long.valueOf(approverId));
				approver.setCreatedDate(new Date());
				CsclApproverMappingLocalServiceUtil.updateCsclApproverMapping(approver);
				
				System.out.println("Approver updated successfully");
				
				actionRequest.setAttribute("isSubmitted", true);
				actionRequest.setAttribute("redirect", redirect);
				SessionMessages.add(actionRequest, "success-add-approver");
				
	            actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
			}catch(Exception e) {
				e.getMessage();
				SessionErrors.add(actionRequest, e.getClass());
				actionRequest.setAttribute("redirect", redirect);
				actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
			}
		}else {
			SessionErrors.add(actionRequest, "Failed : Adding approver");
			actionRequest.setAttribute("redirect", redirect);
			actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/manage_appointee_mapper.jsp");
		}
	}
}
