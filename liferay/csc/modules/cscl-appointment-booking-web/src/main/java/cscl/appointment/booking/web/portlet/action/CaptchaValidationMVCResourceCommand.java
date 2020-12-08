package cscl.appointment.booking.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
			"mvc.command.name=/appointment/captchaValidation"
		},
		service = MVCResourceCommand.class
	)

public class CaptchaValidationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		String captchaText = ParamUtil.getString(resourceRequest, "captchaText",StringPool.BLANK);
		boolean isCaptchaVerified = false;
		try{
	            CaptchaUtil.check(resourceRequest);
	            isCaptchaVerified = true;
        }catch(Exception e) {
            System.err.println("CAPTCHA verification failed.");
        }
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		writer.print(isCaptchaVerified);
		writer.flush();
		resourceResponse.reset();
		resourceResponse.resetBuffer();
		return true;
	}

}
