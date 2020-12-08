<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="cscl.custom.poll.web.constants.CsclCustomPollWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="cscl.custom.poll.web.portlet.CsclCustomPollWebPortlet"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>
<%@page import="com.cscl.polls.service.CsclLocalityMasterLocalServiceUtil" %>
<%@page import="com.cscl.polls.model.CsclLocalityMaster" %>
<%@page import="com.cscl.polls.model.CsclPollsMaster" %>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%-- <%@page import="com.liferay.portal.kernel.util.PortalUtil" %> --%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.polls.service.PollsChoiceLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsChoice"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="java.net.URLDecoder" %>
<%

CsclPollsMaster csclPollMaster = (CsclPollsMaster)request.getAttribute("CsclPollsMaster");
boolean isFilter = false;
String backURL = ParamUtil.getString(request, "backURL");
String site_url = themeDisplay.getPortalURL();
site_url += "/web/guest/polls"; 

String home_url = themeDisplay.getURLHome();

HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
String myArticleId = httpReq.getParameter("questionId");
String myChoiceId = httpReq.getParameter("choiceId");
String redirect = httpReq.getParameter("redirect");
String redirect_url = "";
long questionId = 0;
long choiceId = 0;
String name = "";
String email = "";

try{
	isFilter = GetterUtil.getBoolean(renderRequest.getAttribute("isFilter"));
}catch(Exception e){
	System.err.println("Error : While getting isFilter");
}
try{
	if(Validator.isNotNull(redirect)){
		redirect_url = URLDecoder.decode(redirect , "UTF-8");
	}else{
		redirect_url = ParamUtil.getString(request, "redirect");
	}
}catch(Exception e){
	System.err.println("Error : While getting redirect Url");
}
try{
	if(Validator.isNotNull(myArticleId)){
		questionId = Long.valueOf(myArticleId); 
		choiceId = Long.valueOf(myChoiceId);
	}else{
		questionId = Long.valueOf(ParamUtil.getString(request, "questionId")); 
	}
}catch(Exception e){
	System.err.println("Error : While getting question Id");
}

String ques = "";
PollsQuestion question = null;
List<PollsChoice> choices = new ArrayList<PollsChoice>();
int totalVote = 0;
int votePer = 0;
try {
	question = PollsQuestionLocalServiceUtil.getPollsQuestion(questionId);
	ques = question.getDescription(locale);
	totalVote = question.getVotesCount();
	List<PollsChoice> tempChoices = question.getChoices();
	if(Validator.isNotNull(tempChoices)){
		choices = tempChoices.stream()
				.sorted(Comparator.comparingInt(PollsChoice::getVotesCount).reversed())
				.collect(Collectors.toList());
	}
} catch (Exception ex) {
	System.err.println("error2..................." + ex);
}
List<CsclLocalityMaster> locality = new ArrayList<CsclLocalityMaster>();
try{
	locality = CsclLocalityMasterLocalServiceUtil.getCsclLocalityMasters(0,  CsclLocalityMasterLocalServiceUtil.getCsclLocalityMastersCount());
}catch(Exception e1){
	System.err.println("Error came while getting localities");
}
try{
	if(themeDisplay.isSignedIn()){
		name = themeDisplay.getUser().getFullName();
		email = themeDisplay.getUser().getEmailAddress();
	}
}catch(Exception e1){
	System.err.println("Error came while getting localities");
}

%>
<liferay-ui:success key="success-poll-submit" message="You have successfully voted for this poll" />
<liferay-ui:error key="text-verification-failed" message="Captcha verification has failed" />
<liferay-ui:error key="question-choice-null" message="You have to select and option previous page" />
<h4>Poll Question : <%=ques%></h4>
<hr>

<liferay-portlet:actionURL name="/customPoll/view" 
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="addCustomPollURL">
	<portlet:param name="mvcPath" value="/customPoll/view.jsp" />
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:actionURL>

<%if(!isFilter){ %>
<h2><liferay-ui:message key="user-details" /></h2>

<aui:form cssClass="contact-form" action="<%=addCustomPollURL%>" method="post" name="fm">
<%-- onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "saveFeedback();"%>' --%>

<aui:model-context bean="<%=csclPollMaster%>" model="<%=CsclPollsMaster.class%>" />
<aui:input name="redirect" type="hidden" value="<%=redirect_url%>" />
<aui:input name="questionId" type="hidden" value="<%= questionId %>" />
<aui:input name="choiceId" type="hidden" value="<%= choiceId %>" />
	<div class="row">
		<%-- <div class="col-md-12">
			<h5>Poll Question : <%=ques%></h5>
		</div> --%>
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="<%=name %>"/>
		</div>
		<div class="col-md-6 email-field">
			<aui:input name="email" placeholder="email" label="email" value="<%=email %>">
				 <aui:validator name="email"/>
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="mobile" value="">
				<aui:validator name="rangeLength" errorMessage="valid-mobile">[10,10]</aui:validator>
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input label="dateOfBirth" name="birthDate" required="true" placeholder="age">
				<aui:validator name="required" />
			</aui:input>
        
		</div>
		<div class="col-md-6">
			<aui:select name="sex" label="gender" required="true">
				<aui:option value="" >Select Gender</aui:option>
				<aui:option value="male" >Male</aui:option>
				<aui:option value="female" >Female</aui:option>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
		<div class="col-md-6 name-field">
			<aui:select name="locality" label="locality" required="true">
			<aui:option value="" >Select Locality</aui:option>
				<%for(CsclLocalityMaster area : locality){ %>
					<aui:option value="<%=area.getLocalityId() %>" ><%=area.getName() %></aui:option>
				<%} %>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
	</div>
	<%-- <div class="form-group">
			<portlet:resourceURL var="captchaURL">
			</portlet:resourceURL>
			<liferay-ui:captcha url="<%=captchaURL%>" />
	</div> --%>
	<div class="form-group">
		<aui:button type="submit" value="submit"/>
		<a href="<%= redirect_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a>
	</div>
</aui:form>

<% }else{ %>

<h5>Total Votes: <%=totalVote%></h5>
<hr>

<div class="row">
	<div class="col-md-12" style="border: 1px solid black;padding-top: 1rem; display: flex; padding-bottom: 1rem;padding-left: 0;padding-right: 0;border: 1px solid #ccc;border-radius: 10px;margin: 10px 20px;max-width: 96%;">
		<div class="col-md-6">
			<%
				String barCss="high-color";
	    		int count=0;
				for (PollsChoice choice : choices) {
					int vote = choice.getVotesCount();
					String choiceDesc = "";
					try {
						choiceDesc = choice.getDescription(locale);
						votePer = (vote * 100) / totalVote;
					} catch (Exception e) {
						System.err.println("Error.." + e);
					}
					
					if(count == 0){
						barCss="high-color";
					}else if(count == choices.size()-1){
						barCss="low-color";
					}else{
						barCss="inter-color"+count;
					}
			%>
			<div class="poll-result">
				<a class="btn btn-sm poll-bar <%=barCss %>" style="width: <%=votePer %>%;min-width: fit-content;">
			   		<%=choiceDesc%><%=vote>0?" ("+vote+")":""%>
			   	</a>
				<span> <%=votePer%> % </span><br/>      
			</div>	
			
			<%
				count++;
				}
			%>
		</div>
	</div>
</div>
<div class="form-group" style="top: 1em;">
	<a href="<%= redirect_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a>
</div>
<%}%>

<style type="text/css">

.poll-result a.poll-bar{
	max-width:88%;
}

a.btn.btn-default.btn-sm.btn-succes {
    color: #fff !important;
    background-color: #5cb85c;
    border-color: #4cae4c;
	margin: 5px 0;
    width: 60%;
    padding: 5px 10px;
    line-height: 1.5;
}

.btn-warnin {
    color: #fff !important;
    background-color: #f0ad4e;
    border-color: #eea236;
	margin: 5px 0;
    width: 51%;
    padding: 5px 10px;
    line-height: 1.5;
}

.btn-dange {
    color: #fff !important;
    background-color: #d9534f;
    border-color: #d43f3a;
	margin: 5px 0;
    width: 39%;
    padding: 5px 10px;
    line-height: 1.5;
}

.panel-primary {
    border-color: #428bca;
}
.panel {
    background-color: #FFF;
    border-style: solid;
    border-width: 1px 1px 1px 1px;
    border-radius: 5px;
    margin-bottom: 1rem;
    word-wrap: break-word;
}
.panel-heading {
    color: #fff;
    background-color: #428bca;
    border-color: #428bca;
	padding: 10px 15px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
	position: relative;
}
.panel-title {
    margin-top: 0;
    margin-bottom: 0;
    font-size: 16px;
    color: inherit;
	font-weight: 600;
}
.panel-body {
    padding: 15px;
}
.poll-bar {
    color: #fff !important;
	margin: 5px 0;
    padding: 5px 10px;
    line-height: 1.5;
}

.high-color{
	background-color: #5cb85c;
}
.low-color{
	background-color: #d9534f;
}
.inter-color1{
	background-color: #5bc0de;
}
.inter-color2{
	background-color: #f0ad4e;
}
.inter-color3{
	background-color: #e86a8d;
}
.inter-color4{
	background-color: #6a8be8;
}
</style>