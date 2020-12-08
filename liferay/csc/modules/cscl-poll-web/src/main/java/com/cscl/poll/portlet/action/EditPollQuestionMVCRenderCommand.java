package com.cscl.poll.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.poll.constants.PollPortletKeys;
import com.liferay.polls.exception.NoSuchQuestionException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;

@Component(
	property = {
		"javax.portlet.name=" + PollPortletKeys.POLL,
		"mvc.command.name=/polls/edit_poll_question"
	},
	service = MVCRenderCommand.class
)
public class EditPollQuestionMVCRenderCommand implements MVCRenderCommand {
	
	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

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

		return "/polls/edit_poll_question.jsp";
	}
}
