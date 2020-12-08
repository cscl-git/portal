package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/edit_appointment"
		},
		service = MVCRenderCommand.class
	)

public class EditAppointmentMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ActionUtil.getAppointment(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());

				return "/appointmentAdmin/tabs_page.jsp";
			}

			throw new PortletException(e);
		}

		return "/appointmentAdmin/edit_appointment.jsp";
	}

}
