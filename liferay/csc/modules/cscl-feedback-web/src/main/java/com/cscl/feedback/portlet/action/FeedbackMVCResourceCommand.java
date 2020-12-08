package com.cscl.feedback.portlet.action;

import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.feedback.constants.FeedbackPortletKeys;
import com.cscl.feedback.model.Feedback;
import com.cscl.feedback.service.FeedbackLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	property = {
		"javax.portlet.name=" + FeedbackPortletKeys.FEEDBACK,
		"mvc.command.name=/feedback/add_feedback"
	},
	service = MVCResourceCommand.class
)
public class FeedbackMVCResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		_log.info("Searching....");
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isAllowed = false;
		String name = ParamUtil.getString(request, "name",StringPool.BLANK);
		String email= ParamUtil.getString(request, "email",StringPool.BLANK);
		String comments= ParamUtil.getString(request, "comments",StringPool.BLANK);
		String mobile= ParamUtil.getString(request, "mobile",StringPool.BLANK);
		
		if(Validator.isNotNull(name)) {
			if(Validator.isNotNull(email)) {
				if(Validator.isNotNull(comments)) {
					isAllowed = true;
				}
			}
		}
		
		if(isAllowed) {
			try {
				long feedbackId = CounterLocalServiceUtil.increment(Feedback.class.getName());
				Feedback feedback = FeedbackLocalServiceUtil.createFeedback(feedbackId);
				feedback.setName(name);
				feedback.setEmail(email);
				feedback.setMobile(mobile);
				feedback.setComments(comments);
				feedback.setCreateDate(new Date());
				feedback.setCreatedById(themeDisplay.getUserId());
				feedback = FeedbackLocalServiceUtil.addFeedback(feedback);
				
				//SessionMessages.add(request, "requestProcessed", "Thanks for your valuable feedback.");
				
				return true;
			}catch(Exception e) {
				_log.error("Error in submit feedback",e);
				return false;
			}
		}else {
			return false;
		}
	}

	public static Log _log = LogFactoryUtil.getLog(FeedbackMVCResourceCommand.class);
}
