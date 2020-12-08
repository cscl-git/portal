<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.stream.Collector"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cscl.polls.service.CsclPollsMasterLocalServiceUtil"%>
<%@page	import="com.cscl.polls.service.CsclLocalityMasterLocalServiceUtil"%>
<%@page import="com.cscl.polls.service.CsclAgeFilterLocalServiceUtil"%>
<%@page import="com.cscl.polls.model.CsclPollsMaster"%>
<%@page import="com.cscl.polls.model.CsclLocalityMaster"%>
<%@page import="com.cscl.polls.model.CsclAgeFilter"%>
<%@page	import="com.cscl.polls.service.persistence.CsclPollsQuestionUtil"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.cscl.polls.model.CsclPollsQuestion"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.polls.service.PollsChoiceLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsChoice"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.polls.constants.PollsWebKeys"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="java.util.HashMap"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.blogs.service.BlogsEntryServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.blogs.service.BlogsEntryLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.blogs.model.BlogsEntry"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@ include file="../init.jsp"%>

<liferay-portlet:actionURL name="/polls/custom_poll_search"
	refererPlid="<%=themeDisplay.getRefererPlid()%>"
	var="addCustomPollAdminURL">
	<portlet:param name="mvcPath" value="/polls/custom_poll_search.jsp" />
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"/>
</liferay-portlet:actionURL>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL");
	long entryId = Long.valueOf(ParamUtil.getString(request, "entryId"));//34501 //questionId
	boolean isFilter = false;
	List<CsclPollsMaster> resultMat = new ArrayList<CsclPollsMaster>();
	int filterVoteCount = 0;
	try {
		resultMat = (List<CsclPollsMaster>) renderRequest.getAttribute("res");
		isFilter = GetterUtil.getBoolean(renderRequest.getAttribute("isFilter"));
	} catch (Exception e1) {
		System.err.println("Error: While getting respnse Object" + e1.getMessage());
	}
	
	
	String pollId = "";
	try{
		BlogsEntry tempBlogList = BlogsEntryServiceUtil.getEntry(entryId);
		pollId = tempBlogList.getExpandoBridge().getAttribute("POLL_ID").toString();
	}catch(Exception e){
		System.err.println("Error: while getting poll id");
	}
	
	if (Validator.isNotNull(resultMat)) {
		filterVoteCount = resultMat.size();
		isFilter = true;
	} else {
		try {
			resultMat = CsclPollsMasterLocalServiceUtil.getPollsByQuestionId(entryId);
		} catch (Exception e1) {
			System.err.println("Error: While getting details.." + e1.getMessage());
		}
		filterVoteCount = resultMat.size();
	}
	CsclPollsMaster pollMaster = null;
	PollsQuestion question = null;
	List<CsclLocalityMaster> locality = new ArrayList<CsclLocalityMaster>();
	List<CsclAgeFilter> ageFilters = new ArrayList<CsclAgeFilter>();
	
	List<PollsChoice> actualResult = new ArrayList<PollsChoice>();
	List<PollsChoice> filteredResult = new ArrayList<PollsChoice>();
	String ques = "";
	int totalVote = 0;
	int votePer = 0;
	try {
		question = PollsQuestionLocalServiceUtil.getPollsQuestion(Long.parseLong(pollId)); 
		ques = question.getDescription(locale);
		List<PollsChoice> choices = question.getChoices();
		totalVote = question.getVotesCount();
		if(Validator.isNotNull(choices)){
			actualResult = choices.stream()
					.sorted(Comparator.comparingInt(PollsChoice::getVotesCount).reversed())
					.collect(Collectors.toList());
		}
	} catch (Exception e) {
		System.out.println("Error in fetch actual poll response "+e.getMessage());
	}
	try {
		locality = CsclLocalityMasterLocalServiceUtil.getCsclLocalityMasters(0,
				CsclLocalityMasterLocalServiceUtil.getCsclLocalityMastersCount());
		ageFilters = CsclAgeFilterLocalServiceUtil.getActiveFiltersAge();
	} catch (Exception e) {
		System.err.println("Error came while getting localities/ageFilters"+e.getMessage());
	}
	
	//Prepare filter result
	HashMap<Long, Integer> serachMap = new HashMap<Long, Integer>();
	try {
		for (CsclPollsMaster res : resultMat) {
			if (serachMap.containsKey(res.getChoiceId())) {
				serachMap.put(res.getChoiceId(), serachMap.get(res.getChoiceId()) + 1);
			} else {
				serachMap.put(res.getChoiceId(), 1);
			}
		}
		for(PollsChoice choice:actualResult) {
   			if(!serachMap.containsKey(choice.getChoiceId())) {
   				serachMap.put(choice.getChoiceId(), 0);
   			}
   		}
		        
	} catch (Exception e1) {
		System.err.println("Error: While getting details.." + e1.getMessage());
	}
	
	//Sorting
	Map<Long, Integer> filteredMap = serachMap.entrySet().stream().sorted((Map.Entry.<Long, Integer>comparingByValue().reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
%>

<h4><%=ques%></h4>
<h4 style="border-top: 2px solid blue;padding-top: 1rem;">
	<liferay-ui:message key="search-criteria" />
</h4>

<aui:form cssClass="contact-form" action="<%=addCustomPollAdminURL%>" method="post" name="fm">
	<aui:input name="questionId" type="hidden" value="<%=question.getQuestionId()%>" />
	<aui:input name="entryId" type="hidden" value="<%=entryId %>" />
	<div class="row">
		<div class="col-md-4">
			<aui:select name="age" label="">
				<aui:option value="0">Select Age Group</aui:option>
				<%
				if(Validator.isNotNull(ageFilters)) {
					for (CsclAgeFilter age : ageFilters) {
				%>
						<aui:option value="<%=age.getId_()%>"><%=age.getValue()%></aui:option>
				<%
					}
				}
				%>
			</aui:select>
		</div>
		<div class="col-md-4">
			<aui:select name="sex" label="">
				<aui:option value="0">Select Gender</aui:option>
				<aui:option value="male">Male</aui:option>
				<aui:option value="female">Female</aui:option>
			</aui:select>
		</div>
		<div class="col-md-4">
			<aui:select name="locality" label="" id="lcality">
				<aui:option value="0">Select Locality</aui:option>
				<%
				if (Validator.isNotNull(locality)) {
					for (CsclLocalityMaster area : locality) {
				%>
						<aui:option value="<%=area.getLocalityId()%>"><%=area.getName()%></aui:option>
				<%
					}
				}
				%>
			</aui:select>
		</div>
		<div class="form-group" style="padding: 10px;">
			<aui:button type="submit" value="search"/>
		</div>
	</div>
</aui:form>
<!-- New Design -->
<div class="panel panel-primary" style="width:100%; margin:0;padding: 0;" >
    <div class="panel-heading">
	  	<h3 class="panel-title">
	  		View Poll Responce
	    </h3>  
	</div>   
  	<div class="row" style="margin: 0px!important;">  
		<div class="panel-body"  style="margin:0px; width:48%;border-right: 1px dotted #ccc;">
	  		<div id="Main">
	    		<p style="border-bottom: 1px solid #ccc"> Actual Response</p>
	    		<p> Total Votes : <%=totalVote%> </p>
	    <%
	    		String barCss="high-color";
	    		int count=0;
				int vote=0;	  
	    		String choiceDesc = "";
				for(PollsChoice choice : actualResult){
			        choiceDesc = "";
					votePer = 0;
					vote=0;	
					try {
						vote = choice.getVotesCount();
						if(vote > 0){
							votePer = (vote* 100) / totalVote;
						}
						choiceDesc = choice.getDescription(locale);
					} catch (Exception e) {
						System.err.println("Error.." + e);
					}
					
					if(count == 0){
						barCss="high-color";
					}else if(count == actualResult.size()-1){
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
    	
    	<%if(isFilter){ %>
    	<div class="panel-body"  style="margin:0px; width:48%;">
    		<div id="searchRes">
		    	<p style="border-bottom: 1px solid #ccc"> Filtered Result </p>
			    <p> Total Votes : <%=filterVoteCount%> </p>
	 
			 <% 
			 	barCss="high-color";
	    		count=0;
			 	vote=0;
			 	for (Map.Entry<Long, Integer> entry : filteredMap.entrySet()) {
			 		choiceDesc = "";
					votePer = 0;
					vote=0;	
					try {
						PollsChoice choice = PollsChoiceLocalServiceUtil.getChoice(entry.getKey());
						vote = entry.getValue();
						if(vote > 0){
							votePer = (vote * 100) / totalVote;
						}
						choiceDesc = choice.getDescription(locale);
					} catch (Exception e) {
						System.err.println("Unable to fecth choice.." + e);
					}
					
					if(count == 0){
						barCss="high-color";
					}else if(count == actualResult.size()-1){
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
 	<%} %>
 
	</div>  
</div>

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