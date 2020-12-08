<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cscl.polls.service.CsclPollsMasterLocalServiceUtil"%>
<%@page	import="com.cscl.polls.service.CsclLocalityMasterLocalServiceUtil"%>
<%@page import="com.cscl.polls.service.CsclAgeFilterLocalServiceUtil"%>
<%@page import="com.cscl.polls.model.CsclPollsMaster"%>
<%@page import="com.cscl.polls.model.CsclLocalityMaster"%>
<%@page import="com.cscl.polls.model.CsclAgeFilter"%>

<%@ include file="../init.jsp"%>

<%@page	import="com.cscl.polls.service.persistence.CsclPollsQuestionUtil"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
<%@page	import="com.liferay.polls.exception.QuestionExpirationDateException"%>
<%@page	import="com.liferay.polls.exception.QuestionDescriptionException"%>
<%@page import="com.liferay.polls.exception.QuestionChoiceException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.polls.service.PollsChoiceLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsChoice"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.polls.constants.PollsWebKeys"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="java.util.HashMap"%>

<liferay-portlet:actionURL name="/pollAdmin/view"
	refererPlid="<%=themeDisplay.getRefererPlid()%>"
	var="addCustomPollAdminURL">
	<portlet:param name="mvcPath" value="/pollAdmin/poll_display.jsp" />
</liferay-portlet:actionURL>
<%
	long entryId = ParamUtil.getLong(request, "questionId");//34501;//36607;// 
	PollsQuestion question = null;
	List<PollsChoice> choices = new ArrayList<PollsChoice>();
	String ques = "";
	int totalVote = 0;
	int votePer = 0;
	try {
		question = PollsQuestionLocalServiceUtil.getPollsQuestion(entryId);
		ques = question.getTitle(locale);
		choices = question.getChoices();
		totalVote = question.getVotesCount();
	} catch (Exception ex) {
		System.err.println("error2..................." + ex);
	}

%>
<liferay-ui:success key="success-poll-submit" message="You have successfully voted for this poll" />
<h4>Poll Question : <%=ques%></h4>
<h5>Total Votes: <%=totalVote%></h5>
<hr>

<div class="row">
	<div class="col-md-12" style="border: 1px solid black;padding-top: 1rem; display: flex; padding-bottom: 1rem;padding-left: 0;padding-right: 0;">
		<div class="col-md-6">
			<%
				for (PollsChoice choice : choices) {
					int vote = choice.getVotesCount();
					try {
						votePer = (vote * 100) / totalVote;
					} catch (Exception e) {
						System.err.println("Error.." + e);
					}
			%>
			<strong><%=choice.getDescription(locale)%></strong><span
				class="pull-right"><%=votePer%> % </span>
			<div class="progress progress-danger active">
				<div class="bar" style="width: <%=votePer%>%;background: #0b5fff;"></div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</div>
