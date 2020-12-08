<%@page import="com.cscl.feedback.constants.FeedbackPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.cscl.feedback.model.Feedback"%>
<%@ include file="../init.jsp" %>

<%
Feedback feedback = (Feedback)request.getAttribute(FeedbackPortletKeys.FEEDBACK_CLASS);

%>

<portlet:resourceURL id="/feedback/add_feedback" var="addFeedbackURL" />


<h2><liferay-ui:message key="feedback" /></h2>

<div class="alert alert-success fade show" role="alert" id="feedbackSuccess">
	<span class="alert-indicator">
		<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
			<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
		</svg>
	</span>
	<strong class="lead"><liferay-ui:message key="success" />:</strong><liferay-ui:message key="feedback-success" />
</div>

<aui:form cssClass="contact-form" method="post" name="fm" 
	onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "saveFeedback();"%>'>

	<aui:model-context bean="<%=feedback%>" model="<%=Feedback.class%>" />

	<div class="row">
		<div class="col-md-12 name-field">
			<aui:input name="name" placeholder="name" label=""/>
		</div>
		<div class="col-md-6 email-field">
			<aui:input name="email" placeholder="email" label="">
				 <aui:validator name="email"/>
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="">
				<aui:validator name="rangeLength" errorMessage="valid-mobile">[10,10]</aui:validator> 
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div>
		<div class="col-md-12">
			<aui:input name="comments" placeholder="comments-placeholder" 
				label="" showRequiredLabel="false"/>
		</div>
	</div>
	<div class="form-group">
		<aui:button type="submit" value="submit"/>
	</div>
</aui:form>

<style>
#feedbackSuccess{
	display: none;
}
</style>
<aui:script>
	function <portlet:namespace />saveFeedback() {
		var form = document.getElementById('<portlet:namespace />fm');
		var url="<%=addFeedbackURL.toString() %>";
	 	var name=$("#<portlet:namespace />name").val().trim();
		var email=$("#<portlet:namespace />email").val().trim();
		var mobile=$("#<portlet:namespace />mobile").val().trim();
		var comments=$("#<portlet:namespace />comments").val().trim();
		
		if (form) {
			jQuery.ajax({
			 type: "POST",
			 url:url,
			 data : {'<portlet:namespace />name':name,
				 	'<portlet:namespace />email':email,
				 	'<portlet:namespace />mobile':mobile,
				 	'<portlet:namespace />comments':comments,
				 	},
			 success: function(msg){
			 	$("#<portlet:namespace />name").val('');
				$("#<portlet:namespace />email").val('');
				$("#<portlet:namespace />mobile").val('');
				$("#<portlet:namespace />comments").val('');
				$("#feedbackSuccess").css("display","block");
			 }
		}); 
			
		}
	}
</aui:script>