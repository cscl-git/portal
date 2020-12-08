package cscl.online.rti.payment.web.portlet.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(property = { "javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
"mvc.command.name=/rti/otpValidation" }, service = MVCResourceCommand.class)

public class OtpValidationMVCResourceCommand implements MVCResourceCommand {

	public static Log _log = LogFactoryUtil.getLog(OtpValidationMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		String otpText = ParamUtil.getString(resourceRequest, "otpText", StringPool.BLANK);
		boolean isOtpVerified = false;
		try {
			HttpSession httpSession = PortalUtil.getHttpServletRequest(resourceRequest).getSession();
			String otp = GetterUtil.getString(httpSession.getAttribute("OTP"), StringPool.BLANK);
			long otpGenarationTime = GetterUtil.getLong(httpSession.getAttribute("otpGenarationTime"));
			long currentTime = System.currentTimeMillis();
			long timeDiffInMin = (currentTime - otpGenarationTime)/(1000*60);
			_log.info("User OTP: "+ otpText+",System OTP: "+otp +" ,otpGenarationTime: "+otpGenarationTime+", timeDiffInMin:"+timeDiffInMin);
			
			if(timeDiffInMin > 10) {
				isOtpVerified = false;
				_log.info("OTP expired.");
			}else if(otpText.equalsIgnoreCase(otp)) {
				_log.info("OTP verified successfully.");
				isOtpVerified = true;
				httpSession.setAttribute("OTP", otp);
				httpSession.setAttribute("otpGenarationTime", System.currentTimeMillis());
			}else {
				_log.info("OTP mismatched.");
			}
		} catch (Exception e) {
			_log.error("OTP verification failed",e);
		}
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
			writer.print(isOtpVerified);
			writer.flush();
			resourceResponse.reset();
			resourceResponse.resetBuffer();
		} catch (IOException e) {
			_log.error("OTP write failed",e);
		}
		
		return isOtpVerified;
	}

}
