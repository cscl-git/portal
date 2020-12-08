package com.cscl.appointment.booking.admin.portlet;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author arnabsahvst
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=cscl",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CsclAppointmentBookingAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/appointmentAdmin/tabs_page.jsp",
		"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclAppointmentBookingAdminPortlet extends MVCPortlet {
}