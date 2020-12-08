package com.cscl.online.rti.payment.web.portlet;

import com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author malay.paul
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=cscl",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CsclOnlineRtiPaymentWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/rti/view.jsp",
		"javax.portlet.name=" + CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclOnlineRtiPaymentWebPortlet extends MVCPortlet {
}