package com.cscl.online.rti.payment.admin.portlet;

import com.cscl.online.rti.payment.admin.constants.CsclOnlineRtiPaymentAdminPortletKeys;

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
		"javax.portlet.display-name=CsclOnlineRtiPaymentAdmin",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/rtiAdmin/view.jsp",
		"javax.portlet.name=" + CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CsclOnlineRtiPaymentAdminPortlet extends MVCPortlet {
}