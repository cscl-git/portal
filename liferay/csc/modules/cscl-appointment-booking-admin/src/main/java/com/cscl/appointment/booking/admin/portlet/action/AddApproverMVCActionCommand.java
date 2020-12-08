package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAppointeeMaster;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/add_approver"
		},
		service = MVCActionCommand.class
	)
public class AddApproverMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		boolean isAllowed = false;
		//long appointeeId = ParamUtil.getLong(actionRequest, "appointeeId");
		String name = ParamUtil.getString(actionRequest, "name");
		String designation = ParamUtil.getString(actionRequest, "designation");
		String approverId = ParamUtil.getString(actionRequest, "approver");
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		String userName = "";
		
		if(Validator.isNotNull(name)) {
			if(Validator.isNotNull(designation)) {
				if(Validator.isNotNull(approverId)) {
					isAllowed = true;
				}
			}
		}
		
		//ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
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
				long id = CounterLocalServiceUtil.increment(CsclAppointeeMaster.class.getName()); 
				CsclAppointeeMaster appointee = CsclAppointeeMasterLocalServiceUtil.createCsclAppointeeMaster(id);

				appointee.setName(name);
				appointee.setDesignation(designation);
				appointee.setIsActive(true);
				CsclAppointeeMasterLocalServiceUtil.addCsclAppointeeMaster(appointee);
				
				System.out.println("Appointee added successfully");
				
				long id_ = CounterLocalServiceUtil.increment(CsclApproverMapping.class.getName()); 
				CsclApproverMapping approver = CsclApproverMappingLocalServiceUtil.createCsclApproverMapping(id_);
				
				approver.setAppointee((int)id);
				approver.setCreatedDate(new Date());
				approver.setApprover(userName);
				approver.setAssignedTo(Long.valueOf(approverId));
				
				CsclApproverMappingLocalServiceUtil.addCsclApproverMapping(approver);
				System.out.println("Approver mapped successfully");
				
				actionRequest.setAttribute("isSubmitted", true);
				actionRequest.setAttribute("redirect", redirect);
				SessionMessages.add(actionRequest, "success-add-approver");
				
	            actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/add_approver.jsp");
			}catch(Exception e) {
				e.getMessage();
				SessionErrors.add(actionRequest, e.getClass());
				actionRequest.setAttribute("redirect", redirect);
				actionResponse.getRenderParameters().setValue("mvcPath", "/appointmentAdmin/add_approver.jsp");
			}
		}else {
			SessionErrors.add(actionRequest, "Failed : Adding approver");
			actionRequest.setAttribute("redirect", redirect);
			return;
		}
	}

}
