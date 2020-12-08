package com.cscl.online.rti.payment.admin.portlet.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.admin.constants.CsclOnlineRtiPaymentAdminPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;


@Component(
		property = {
			"javax.portlet.name=" + CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
			"mvc.command.name=/rtiAdmin/rti_search",
			"javax.portlet.init-param.add-process-action-success-action=false"
		},
		service = MVCActionCommand.class
	)
public class CsclRtiSearchFilterMVCActionCommand extends BaseMVCActionCommand{
	
	public static Log _log = LogFactoryUtil.getLog(CsclRtiSearchFilterMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		
		String fromDate = ParamUtil.getString(request, "fromDate");
		String toDate =  ParamUtil.getString(request, "toDate");
		_log.info("fromDate:"+fromDate+", toDate:"+toDate);
		
		request.setAttribute("fromDate", fromDate);
		request.setAttribute("toDate", toDate);
		request.setAttribute("isFilter", true);
		response.getRenderParameters().setValue("mvcPath", "/rtiAdmin/view.jsp");
	}
}
