package cscl.appointment.booking.web.portlet.action;

import com.liferay.portal.kernel.captcha.Captcha;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
				"mvc.command.name=/appointment/captcha"
		},
		service = MVCResourceCommand.class
	)

public class CaptchaAppointmentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			return true;
		}catch (Exception e) {
		    System.err.println("Error : While generating captcha.."+e);
		    return false;
		}
	}
	
	 protected boolean isCheckMethodOnProcessAction() {
         return _CHECK_METHOD_ON_PROCESS_ACTION;
     }
    
	 private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}
