package com.cscl.tender.portlet.action;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.tender.constants.TenderPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + TenderPortletKeys.TENDER,
			"mvc.command.name=/", "mvc.command.name=/tender/view"
		},
		service = MVCRenderCommand.class
	)
public class TenderViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
		RenderRequest renderRequest, RenderResponse renderResponse) {

		return "/tender/view.jsp";
	}
}
