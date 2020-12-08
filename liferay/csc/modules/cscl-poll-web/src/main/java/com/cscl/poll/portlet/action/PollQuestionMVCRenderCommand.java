package com.cscl.poll.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.poll.constants.PollPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

@Component(
	property = {
		"javax.portlet.name=" + PollPortletKeys.POLL,
		"mvc.command.name=/polls/view"
	},
	service = MVCRenderCommand.class
)
public class PollQuestionMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		return "/polls/view.jsp";
	}
}
