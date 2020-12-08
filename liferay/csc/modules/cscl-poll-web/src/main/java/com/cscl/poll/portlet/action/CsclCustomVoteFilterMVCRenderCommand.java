package com.cscl.poll.portlet.action;

import com.cscl.poll.constants.PollPortletKeys;
import com.liferay.polls.exception.NoSuchQuestionException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
		property = {
			"javax.portlet.name=" + PollPortletKeys.POLL,
			"mvc.command.name=/polls/custom_poll_search"
		},
		service = MVCRenderCommand.class
	)

public class CsclCustomVoteFilterMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		try {
			ActionUtil.getQuestion(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchQuestionException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());

				return "/polls/error.jsp";
			}

			throw new PortletException(e);
		}

		return "/polls/custom_poll_search.jsp";
	}

}
