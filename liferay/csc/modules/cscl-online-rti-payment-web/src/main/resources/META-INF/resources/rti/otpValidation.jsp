<%@ include file="../init.jsp" %>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletSession" %>
 
<%
//CsclRtiPaymentDetails csclRtiPaymentDetails = (CsclRtiPaymentDetails)request.getAttribute(CsclOnlineRtiPaymentWebPortletKeys.CSCLONLINERTIPAYMENTWEB);
//Declarations
//String site_url = "";
String refId = "";
boolean isResult = false;
try{
	isResult = (boolean) renderRequest.getAttribute("isResult");
	refId = (String) renderRequest.getAttribute("refId");
}catch(Exception e){}
/* try{
	site_url = themeDisplay.getPortalURL();
	site_url += "/web/guest/home"; 
}catch(Exception e1){} */
%>
<liferay-ui:success key="success-rti-payment" message="You payment towards RTI has been registered successfully with us" />
<liferay-ui:error key="text-verification-failed" message="Captcha verification has failed" />
<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>"  message="Captcha verification has failed" /> --%>
 
<liferay-portlet:actionURL name="/rti/view" 
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="bookRtiURL">
	<portlet:param name="mvcPath" value="/rti/view.jsp" />
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</liferay-portlet:actionURL>

<portlet:resourceURL id="/rti/captchaValidation" var="captchaValidationURL">
</portlet:resourceURL>


<h2><liferay-ui:message key="rti-payment" /></h2>
<%if(isResult){ %>
	<div class="col-md-12">
		<h4 style="color: green;"><liferay-ui:message key="success-msg" />
		 : <%=refId %></h4>
	</div>
<%} %>
<aui:form cssClass="contact-form" action="<%=bookRtiURL%>" method="post"
 name="fm" onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "checkCaptcha();"%>'>

<%-- <aui:model-context bean="<%=csclRtiPaymentDetails%>" model="<%=CsclRtiPaymentDetails.class%>" /> --%>
	<div class="row">
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6 email-field">
			<aui:input name="email" placeholder="email" label="email" value="" required="true">
				 <aui:validator name="email"/>
				 <aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="mobile" placeholder="mobile" label="mobile" value="" required="true">
				<aui:validator name="rangeLength" errorMessage="valid-mobile">[10,10]</aui:validator>
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="subject" placeholder="subject" label="subject" value="" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="address" placeholder="address" label="address" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="rti-fees" placeholder="rti-fees" label="rti-fees" value="" required="true">
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div>
	</div>
	<%if(!isResult){ %>
		<div class="form-group">
			<div class="col-md-6">
				<portlet:resourceURL id="/rti/captcha" var="captchaURL">
				</portlet:resourceURL>
				<liferay-captcha:captcha url="<%=captchaURL%>" />
			</div>
		</div>
	<%} %>
	<div class="col-md-6">
		<div class="alert alert-danger show" role="alert" id="captchaFailed" style="color:red;">
			<!-- <span class="alert-indicator">
				<svg class="lexicon-icon" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
				</svg>
			</span> -->
			<strong class="lead"><liferay-ui:message key="failed" />:</strong><liferay-ui:message key="captcha-failed" />
		</div>
		<div class="alert alert-success show" role="alert" id="captchaSuccess" style="green;">
			<span class="alert-indicator">
				<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
				</svg>
			</span>
			<strong class="lead"><liferay-ui:message key="success" />:</strong><liferay-ui:message key="captcha-success" />
		</div>
	</div>
	<%if(!isResult){ %>
		<div class="form-group">
			<aui:button type="submit" value="submit"/>
		<%-- <a href="<%= site_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a> --%>
		</div>
	<%}else{ %>
		<div class="form-group">
		<%-- <a href="<%= site_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a> --%>
	</div>
	<%} %>
</aui:form>

<style>
#captchaSuccess{
	display: none;
}
#captchaFailed{
	display: none;
}
</style>
<%--  <aui:script>
	function <portlet:namespace />checkCaptcha() {
		var form = document.getElementById('<portlet:namespace />fm');
		var url="<%=captchaValidationURL.toString() %>";
	 	var captchaText=$("#<portlet:namespace />captchaText").val().trim();
		
		if (form) {
			jQuery.ajax({
			 type: "POST",
			 url:url,
			 async:false,
			 data : {'<portlet:namespace />captchaText':captchaText,},
			 success: function(msg){
			 	if(msg == 'true'){
			 		$("#captchaSuccess").css("display","block");
			 		$("#captchaFailed").css("display","none");
			 		form.submit();
			 	}else{
			 		$("#captchaSuccess").css("display","none");
			 		$("#captchaFailed").css("display","block");
			 	}
			 }
		}); 
			
		}
	}
</aui:script> --%>
