package cscl.online.rti.payment.web.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

@Component(
		property = {
				"javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
				"mvc.command.name=/rti/captcha"
		},
		service = MVCResourceCommand.class
	)

public class CaptchaAppointmentMVCResourceCommand implements MVCResourceCommand {

	public static Log _log = LogFactoryUtil.getLog(CaptchaAppointmentMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			CaptchaUtil.serveImage(resourceRequest, resourceResponse);
			return true;
		}catch (Exception e) {
		    _log.error("Error : While generating captcha.."+e);
		    return false;
		}
	}
	
	 protected boolean isCheckMethodOnProcessAction() {
         return _CHECK_METHOD_ON_PROCESS_ACTION;
     }
    
	 private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}
