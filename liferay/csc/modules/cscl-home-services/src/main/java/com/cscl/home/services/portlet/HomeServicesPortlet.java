package com.cscl.home.services.portlet;

import com.cscl.home.services.constants.HomeServicesPortletKeys;

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
		"javax.portlet.display-name=HomeServices",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HomeServicesPortletKeys.HOMESERVICES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class HomeServicesPortlet extends MVCPortlet {
}