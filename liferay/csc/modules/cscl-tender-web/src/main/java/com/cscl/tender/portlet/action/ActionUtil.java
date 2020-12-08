package com.cscl.tender.portlet.action;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.cscl.tender.constants.TenderPortletKeys;
import com.cscl.tender.model.CsclTender;
import com.cscl.tender.service.CsclTenderLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

public class ActionUtil {

	public static void getTender(HttpServletRequest httpServletRequest)
		throws Exception {

		long tenderId = ParamUtil.getLong(httpServletRequest, "tenderId");

		CsclTender tender = null;

		if (tenderId > 0) {
			tender = CsclTenderLocalServiceUtil.getCsclTender(tenderId);
		}

		httpServletRequest.setAttribute(TenderPortletKeys.TENDER_CLASS, tender);
	}

	public static void getTender(PortletRequest portletRequest)
		throws Exception {

		HttpServletRequest httpServletRequest =
			PortalUtil.getHttpServletRequest(portletRequest);

		getTender(httpServletRequest);
	}
}
