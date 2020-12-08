package cscl.appointment.booking.web.portlet;

import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;

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
		"javax.portlet.display-name=CsclAppointmentBookingWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/appointment/view.jsp",
		"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclAppointmentBookingWebPortlet extends MVCPortlet {
}