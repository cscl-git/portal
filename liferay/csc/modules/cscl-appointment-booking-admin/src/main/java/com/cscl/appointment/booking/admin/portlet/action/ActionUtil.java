package com.cscl.appointment.booking.admin.portlet.action;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

public class ActionUtil {

	public static void getAppointment(HttpServletRequest httpServletRequest)
		throws Exception {

		long appointmentId = ParamUtil.getLong(httpServletRequest, "appointmentId");

		CsclAppointmentMaster appointment = null;

		if (appointmentId > 0) {
			appointment = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMaster(appointmentId);
		}

		httpServletRequest.setAttribute(CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN, appointment);
	}

	public static void getAppointment(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(portletRequest);

		getAppointment(httpServletRequest);
	}
}

