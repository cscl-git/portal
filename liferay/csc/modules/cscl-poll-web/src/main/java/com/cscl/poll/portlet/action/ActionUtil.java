package com.cscl.poll.portlet.action;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import com.cscl.poll.constants.PollPortletKeys;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.polls.constants.PollsWebKeys;
import com.liferay.polls.model.PollsQuestion;
import com.liferay.polls.service.PollsQuestionServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

public class ActionUtil {

	public static void getQuestion(HttpServletRequest httpServletRequest)
			throws Exception {

			long questionId = ParamUtil.getLong(httpServletRequest, "questionId");
			long entryId = ParamUtil.getLong(httpServletRequest, "entryId");
			
			BlogsEntry blog = null;
			PollsQuestion question = null;

			if (questionId > 0) {
				question = PollsQuestionServiceUtil.getQuestion(questionId);
				httpServletRequest.setAttribute(PollsWebKeys.POLLS_QUESTION, question);
			}
			if (entryId > 0) {
				blog = BlogsEntryLocalServiceUtil.getBlogsEntry(entryId);
				httpServletRequest.setAttribute(PollPortletKeys.POLL_SCOPE, blog);
			}

		}

		public static void getQuestion(PortletRequest portletRequest)
			throws Exception {

			HttpServletRequest httpServletRequest =
				PortalUtil.getHttpServletRequest(portletRequest);

			getQuestion(httpServletRequest);
		}
}
