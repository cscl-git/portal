<%@page import="com.cscl.polls.service.persistence.CsclPollsQuestionUtil"%>
<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="com.cscl.poll.constants.PollPortletKeys"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.blogs.model.BlogsEntry"%>
<%@page import="com.cscl.poll.portlet.action.EditPollQuestionMVCActionCommand"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.cscl.polls.model.CsclPollsQuestion"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.polls.exception.QuestionTitleException"%>
<%@page import="com.liferay.polls.exception.QuestionExpirationDateException"%>
<%@page import="com.liferay.polls.exception.QuestionDescriptionException"%>
<%@page import="com.liferay.polls.exception.QuestionChoiceException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.polls.service.PollsChoiceLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsChoice"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.polls.constants.PollsWebKeys"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ include file="../init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

BlogsEntry blogsEntry = (BlogsEntry)request.getAttribute(PollPortletKeys.POLL_SCOPE);

long entryId = BeanParamUtil.getLong(blogsEntry, request, "entryId");

boolean neverExpire = ParamUtil.getBoolean(request, "neverExpire", true);

String choicesAction = ParamUtil.getString(request, "choicesAction", StringPool.BLANK);

int choiceName = ParamUtil.getInteger(request, "choiceName");

boolean showHeader = ParamUtil.getBoolean(request, "showHeader", true);

CsclPollsQuestion pollQuestion = null;

List<PollsChoice> choices = new ArrayList<>();

long questionId=0;
PollsQuestion question = null;

if(entryId > 0){
	String pollId = blogsEntry.getExpandoBridge().getAttribute("POLL_ID").toString();
	if(Validator.isNotNull(pollId)){
		questionId = Long.parseLong(pollId);
		question = PollsQuestionLocalServiceUtil.getPollsQuestion(questionId);
		
		pollQuestion = CsclPollsQuestionUtil.create(1);
		//BeanUtils.copyProperties(pollQuestion, question);
		pollQuestion.setTitleMap(question.getTitleMap());
		pollQuestion.setQuestionMap(question.getDescriptionMap());
		pollQuestion.setDescriptionMap(LocalizationUtil.getLocalizationMap(blogsEntry.getContent()));
		
		if (question != null) {
			choices = PollsChoiceLocalServiceUtil.getChoices(questionId);
		
			if (question.getExpirationDate() != null) {
				neverExpire = false;
			}
		}
	}
}

int choicesCount = ParamUtil.getInteger(request, "choicesCount", choices.size());

if (choicesCount < 2) {
	choicesCount = 2;
}

boolean addChoice = false;
boolean deleteChoice = false;

if (StringUtil.equals(choicesAction, "addChoice")) {
	addChoice = true;
}
else if (StringUtil.equals(choicesAction, "deleteChoice")) {
	deleteChoice = true;
}

if (showHeader) {
	renderResponse.setTitle(question == null ? LanguageUtil.get(request, "new-poll") : question.getTitle(locale));
}

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);
%>

<liferay-portlet:actionURL name="/polls/edit_poll_question" refererPlid="<%=themeDisplay.getRefererPlid()%>" var="editQuestionURL">
	<portlet:param name="mvcPath" value="/polls/edit_poll_question.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%=editQuestionURL%>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "saveQuestion();"%>'>
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%=referringPortletResource%>" />
	<aui:input name="questionId" type="hidden" value="<%=questionId%>" />
	<aui:input name="entryId" type="hidden" value="<%=entryId%>" />
	<aui:input name="neverExpire" type="hidden" value="<%=neverExpire%>" />
	<aui:input name="choicesAction" type="hidden" value="" />
	<aui:input name="choicesCount" type="hidden" value="<%=choicesCount%>" />
	<aui:input name="choiceName" type="hidden" value="" />

	<liferay-ui:error exception="<%=QuestionChoiceException.class%>" message="please-enter-valid-choices" />
	<liferay-ui:error exception="<%=QuestionDescriptionException.class%>" message="please-enter-a-valid-description" />
	<liferay-ui:error exception="<%=QuestionExpirationDateException.class%>" message="please-enter-a-valid-expiration-date" />
	<liferay-ui:error exception="<%=QuestionTitleException.class%>" message="please-enter-a-valid-title" />

	<aui:model-context bean="<%=pollQuestion%>" model="<%=CsclPollsQuestion.class%>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input autoFocus="" name="title"/>
			
			<aui:input label="polls-question" name="question"/>

			<aui:input label="polls-description" name="description"/>
			
			<aui:input dateTogglerCheckboxLabel="never-expire" disabled="<%=neverExpire%>" name="expirationDate" />

			<aui:field-wrapper cssClass="form-group input-choices-wrapper" label="choices">

				<%
					for (int i = 1; i <= choicesCount; i++) {
							char c = (char)(96 + i);

							PollsChoice choice = null;

							String paramName = null;

							if (deleteChoice && (i >= choiceName)) {
								paramName = EditPollQuestionMVCActionCommand.CHOICE_DESCRIPTION_PREFIX + ((char)(c + 1));
							}
							else {
								paramName = EditPollQuestionMVCActionCommand.CHOICE_DESCRIPTION_PREFIX + c;
							}

							Map<Locale, String> localeChoiceDescriptionMap = LocalizationUtil.getLocalizationMap(renderRequest, paramName);

							String value = GetterUtil.getString(LocalizationUtil.updateLocalization(localeChoiceDescriptionMap, "", "Description", LocaleUtil.toLanguageId(locale)));

							if ((question != null) && !addChoice && !deleteChoice) {
								choice = (PollsChoice)choices.get(i - 1);

								value = choice.getDescription();
							}
				%>

					<div class="form-group poll-choice-group">
						<aui:input name="<%=EditPollQuestionMVCActionCommand.CHOICE_NAME_PREFIX + c%>" type="hidden" value="<%=c%>" />

						<div class="poll-choice-input">
							<aui:input ignoreRequestValue="<%=true%>" label="<%=c + StringPool.PERIOD%>" localized="<%=true%>" name="<%=EditPollQuestionMVCActionCommand.CHOICE_DESCRIPTION_PREFIX + c%>" type="text" value="<%=value%>" />
						</div>

						<c:if test="<%=choicesCount > 2%>">
							<div class="delete-poll-choice">
								<aui:button cssClass="btn-delete" onClick='<%=renderResponse.getNamespace() + "deletePollChoice(" + i + ");"%>' value="delete" />
							</div>
						</c:if>
					</div>

				<%
					}
				%>

				<div class="button-holder">
					<aui:button cssClass="add-choice" onClick='<%=renderResponse.getNamespace() + "addPollChoice();"%>' value="add-choice" />
				</div>
			</aui:field-wrapper>
		</aui:fieldset>
		<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="attachments">
			<div id="<portlet:namespace />attachments">
				<liferay-util:include page="/polls/attachments.jsp" servletContext="<%= application %>" />
			</div>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%=redirect%>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />addPollChoice() {
		var form = document.getElementById('<portlet:namespace />fm');

		if (form) {
			var choicesAction = form.querySelector('#<portlet:namespace />choicesAction');

			if (choicesAction) {
				choicesAction.setAttribute('value', '<%="addChoice"%>');
			}

			var choicesCount = form.querySelector('#<portlet:namespace />choicesCount');

			if (choicesCount) {
				choicesCount.setAttribute('value', '<%=choicesCount + 1%>');
			}

			var expirationDate = form.querySelector('#<portlet:namespace />fmexpirationDate');
			var neverExpire = form.querySelector('#<portlet:namespace />neverExpire');

			if (expirationDate && neverExpire) {
				neverExpire.setAttribute('value', expirationDate.checked);
			}

			<liferay-portlet:renderURL allowEmptyParam="<%=true%>" var="addPollChoiceURL">
				<liferay-portlet:param name="mvcRenderCommandName" value="/polls/edit_poll_question" />
				<liferay-portlet:param name="<%=EditPollQuestionMVCActionCommand.CHOICE_DESCRIPTION_PREFIX + (char)(96 + choicesCount + 1)%>" value="" />
			</liferay-portlet:renderURL>

			submitForm(form, '<%=addPollChoiceURL%>');
		}
	}

	function <portlet:namespace />deletePollChoice(pollName) {
		var form = document.getElementById('<portlet:namespace />fm');

		if (form) {
			var choicesAction = form.querySelector('#<portlet:namespace />choicesAction');

			if (choicesAction) {
				choicesAction.setAttribute('value', '<%="deleteChoice"%>');
			}

			var choicesCount = form.querySelector('#<portlet:namespace />choicesCount');

			if (choicesCount) {
				choicesCount.setAttribute('value', '<%=choicesCount - 1%>');
			}

			var choiceName = form.querySelector('#<portlet:namespace />choiceName');

			if (choiceName) {
				choiceName.setAttribute('value', pollName);
			}

			var expirationDate = form.querySelector('#<portlet:namespace />fmexpirationDate');
			var neverExpire = form.querySelector('#<portlet:namespace />neverExpire');

			if (expirationDate && neverExpire) {
				neverExpire.setAttribute('value', expirationDate.checked);
			}

			<liferay-portlet:renderURL allowEmptyParam="<%=true%>" var="deletePollChoiceURL">
				<liferay-portlet:param name="mvcRenderCommandName" value="/polls/edit_poll_question" />
				<liferay-portlet:param name="<%=EditPollQuestionMVCActionCommand.CHOICE_DESCRIPTION_PREFIX + (char)(96 + choicesCount - 1)%>" value="" />
			</liferay-portlet:renderURL>

			submitForm(form, '<%= deletePollChoiceURL %>');
		}
	}

	function <portlet:namespace />saveQuestion() {
		var form = document.getElementById('<portlet:namespace />fm');

		if (form) {
			var cmd = form.querySelector('#<portlet:namespace /><%= Constants.CMD %>');

			if (cmd) {
				cmd.setAttribute('value', '<%= (question == null) ? Constants.ADD : Constants.UPDATE %>');
			}

			var expirationDate = form.querySelector('#<portlet:namespace />fmexpirationDate');
			var neverExpire = form.querySelector('#<portlet:namespace />neverExpire');

			if (expirationDate && neverExpire) {
				neverExpire.setAttribute('value', expirationDate.checked);
			}

			submitForm(form);
		}
	}
</aui:script>

<%
if (question != null) {
	PortalUtil.addPortletBreadcrumbEntry(request, question.getTitle(locale), null);
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "edit"), currentURL);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "add-poll"), currentURL);
}
%>