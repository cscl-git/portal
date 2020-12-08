package com.cscl.feedback.portlet;

import com.cscl.feedback.constants.FeedbackPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author tonmoyt983
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=cscl",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Feedback",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/feedback/add_feedback.jsp",
		"javax.portlet.name=" + FeedbackPortletKeys.FEEDBACK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FeedbackPortlet extends MVCPortlet {
}