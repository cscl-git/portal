<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="javax.portlet.ResourceURL"%>
<%@ include file="../init.jsp" %>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaTextException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException"%>
<%@page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@page import="java.io.OutputStream" %>
<%@page import="javax.portlet.PortletSession" %>
<%@page import="com.cscl.online.rti.payment.model.CsclRtiPaymentDetails" %>
<%@page import="com.cscl.online.rti.payment.web.constants.CsclOnlineRtiPaymentWebPortletKeys" %>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@page import="com.cscl.online.rti.payment.web.client.ExternalAPIClient" %>

<%
CsclRtiPaymentDetails csclRtiPaymentDetails = null;
//Declarations
String site_url = "";
String refId = "";
boolean isResult = false;
boolean isSubmitted = false;
CsclRtiPaymentDetails rtiObject = null;
String otp = "";
LiferayPortletURL otpValidationURL = null;
try{
	otpValidationURL=PortletURLFactoryUtil.create(renderRequest, themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), "2");
	otpValidationURL.setCacheability(ResourceURL.PAGE);
	otpValidationURL.setResourceID("/rti/otpValidation");
	otpValidationURL.setLifecycle("2");
	otpValidationURL.setWindowState(WindowState.NORMAL);
	otpValidationURL.setPortletMode(PortletMode.VIEW);
	
	isResult = (boolean) renderRequest.getAttribute("isResult");
	isSubmitted = (boolean) renderRequest.getAttribute("isSubmitted");
	refId = (String) renderRequest.getAttribute("refId");
	otp = (String) renderRequest.getAttribute("OTP");
	csclRtiPaymentDetails = (CsclRtiPaymentDetails) renderRequest.getAttribute("rtiObject");
}catch(Exception e){
	System.out.println("Error:"+e);
}
try{
	site_url = themeDisplay.getPortalURL();
	site_url += "/web/guest/home"; 
}catch(Exception e1){}
%>
<liferay-ui:success key="success-rti-payment" message="You payment towards RTI has been registered successfully with us" />
<liferay-ui:success key="otp-sent-successful" message="OTP has been sent to your number" />
<liferay-ui:error key="text-verification-failed" message="Captcha verification has failed" />
<%-- <liferay-ui:error exception="<%= CaptchaTextException.class %>"  message="Captcha verification has failed" /> --%>
 
<liferay-portlet:actionURL name="/rti/view" 
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="bookRtiURL">
	<portlet:param name="mvcPath" value="/rti/view.jsp" />
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</liferay-portlet:actionURL>
<liferay-portlet:actionURL name="/rti/submit" 
	refererPlid="<%=themeDisplay.getRefererPlid()%>" var="submitRtiURL">
	<portlet:param name="mvcPath" value="/rti/view.jsp" />
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</liferay-portlet:actionURL>

<portlet:resourceURL id="/rti/captchaValidation" var="captchaValidationURL">
</portlet:resourceURL>
<portlet:resourceURL id="/rti/otpValidation" var="otpValidationURL1">
</portlet:resourceURL>

<h2><liferay-ui:message key="rti-payment" /></h2>
<%if(isSubmitted){ %>
<div class="row">
	<div class="col-md-9">
		<h4 style="color: green;margin-top:1em;"><liferay-ui:message key="success-msg" />
		 : <%=refId %></h4>
		 <h4 style="color: green;margin-top:1em;margin-bottom:1em;"><liferay-ui:message key="qr-pay-msg" /></h4>
		 <a href="<%= site_url%>"><aui:button type="button" value="back" style="color: #FFF;background-color: #0B5FFF;border-color: #0B5FFF;box-shadow: none;"/></a>
	</div>
	<div class="col-md-3">
		 <img src="https://www.chandigarhsmartcity.in/documents/20123/257692/QR.png/a9f08b9b-1f9d-89f7-5429-7e590668daad?t=1596639198844" alt="QR"/>
	</div>
</div>
<%}else{ %>
<%if(isResult){ %>
<h2><liferay-ui:message key="otp-sent-msg" /></h2>
<aui:form cssClass="contact-form" action="<%=submitRtiURL%>" method="post" name="fm1">
<div class="row">
	<%-- <aui:input name="rtiObject" type="hidden" value="<%=rtiObject%>" /> --%>
	<aui:input name="refId" type="hidden" value="<%=refId%>" />
	
	<aui:input name="applicantName" type="hidden" value="<%=csclRtiPaymentDetails.getApplicantName()%>"/>
	<aui:input name="applicantEmail" type="hidden" value="<%=csclRtiPaymentDetails.getApplicantEmail()%>"/>
	<aui:input name="applicantMobile" type="hidden" value="<%=csclRtiPaymentDetails.getApplicantMobile()%>"/>
	<aui:input name="rtiSubject" type="hidden" value="<%=csclRtiPaymentDetails.getRtiSubject()%>"/>
	<aui:input name="address" type="hidden" value="<%=csclRtiPaymentDetails.getAddress()%>"/>
	<aui:input name="rtiFeeAmount" type="hidden" value="<%=csclRtiPaymentDetails.getRtiFeeAmount()%>"/>
	<aui:input name="id" type="hidden" value="<%=csclRtiPaymentDetails.getId()%>"/>
	
	<div class="col-md-3">
		<aui:input name="otpText" placeholder="otp" label="otp" value="" required="true">
			<aui:validator name="required" />
		</aui:input>
	</div>
	<div class="col-md-12">
		<aui:button value="verify" type="button" onClick="<%=renderResponse.getNamespace() + "checkOTP();"%>"/>
	</div>
	<div class="col-md-6" style="margin-top:2em;">
		<div class="alert alert-danger show" role="alert" id="otpFailed" style="color:red;">
			<strong class="lead"><liferay-ui:message key="failed" />:</strong><liferay-ui:message key="otp-failed" />
		</div>
		<div class="alert alert-success show" role="alert" id="otpSuccess" style="green;">
			<span class="alert-indicator">
				<svg class="lexicon-icon lexicon-icon-check-circle-full" focusable="false" role="presentation" viewBox="0 0 512 512">
					<path class="lexicon-icon-outline" d="M484.1,139.7c-54.4,62.6-167,190-203.8,233c-5.9,6.8-14.6,11.2-24.3,11.2c-8.8,0-16.8-3.6-22.6-9.4c-45.3-45.3-50.7-50.7-96-96c-5.8-5.8-9.4-13.8-9.4-22.6c0-17.7,14.3-32,32-32c8.8,0,16.8,3.6,22.6,9.4c35.6,35.6,46.6,46.6,71.6,71.6c47-54.8,150.9-171.7,192.5-219.7C399.8,32.9,331.8,0,256,0C114.6,0,0,114.6,0,256s114.6,256,256,256s256-114.6,256-256C512,214.1,501.9,174.6,484.1,139.7z"></path>
				</svg>
			</span>
			<strong class="lead"><liferay-ui:message key="success" />:</strong><liferay-ui:message key="otp-success" />
		</div>
	</div>
</div>
</aui:form>
<%}else{ %>
<aui:form cssClass="contact-form" action="<%=bookRtiURL%>" method="post" name="fm"
onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "checkCaptcha();"%>'>
 <%-- onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "checkCaptcha();"%>' --%>
<aui:model-context bean="<%=csclRtiPaymentDetails%>" model="<%=CsclRtiPaymentDetails.class%>" />
	<div class="row">
		<div class="col-md-6 name-field">
			<aui:input name="applicantName" placeholder="name" label="name" value="" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6 email-field">
			<aui:input name="applicantEmail" placeholder="email" label="email" value="" required="true">
				 <aui:validator name="email"/>
				 <aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="applicantMobile" placeholder="mobile" label="mobile" value="" required="true">
				<aui:validator name="rangeLength" errorMessage="valid-mobile">[10,10]</aui:validator>
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="rtiSubject" placeholder="subject" label="subject" value="" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:input name="address" placeholder="address" label="address" required="true">
				<aui:validator name="required" />
			</aui:input>
		</div>
		<%-- <div class="col-md-6">
			<aui:input name="rtiFeeAmount" placeholder="rti-fees" label="rti-fees" value="" required="true">
				<aui:validator name="digits" ></aui:validator>
			</aui:input>
		</div> --%>
	</div>
	<div class="form-group">
			<div class="col-md-6">
				<portlet:resourceURL id="/rti/captcha" var="captchaURL">
				</portlet:resourceURL>
				<liferay-captcha:captcha url="<%=captchaURL%>" />
			</div>
		</div>
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
	<div class="form-group">
		<aui:button value="proceed" type="submit"/>
	</div>
</aui:form>
<%}
}
%>
<style>
#captchaSuccess{
	display: none;
}
#captchaFailed{
	display: none;
}
#otpSuccess{
	display: none;
}
#otpFailed{
	display: none;
}
</style>

 <aui:script>
	function <portlet:namespace />checkOTP() {
		var form = document.getElementById('<portlet:namespace />fm1');
		var url="<%=otpValidationURL.toString() %>";
		url= url+"&p_p_cacheability=cacheLevelPage&p_p_lifecycle=2";
	 	var otpText=$("#<portlet:namespace />otpText").val().trim();
		
		if (form) {
			jQuery.ajax({
				 type: "POST",
				 url:url,
				 async:false,
				 data : {'<portlet:namespace />otpText':otpText},
				 success: function(msg){
				 	if(msg == 'true'){
				 		$("#otpSuccess").css("display","none");
				 		$("#otpFailed").css("display","none");
				 		form.submit();
				 	}else{
				 		$("#otpSuccess").css("display","none");
				 		$("#otpFailed").css("display","block");
				 	}
				 }
		     });
		}
		return false;
	}
	
	function <portlet:namespace />checkCaptcha() {
		var form = document.getElementById('<portlet:namespace />fm');
		var url="<%=captchaValidationURL.toString() %>";
	 	var captchaText=$("#<portlet:namespace />captchaText").val().trim();
		console.log(captchaText);
		console.log("url:"+url);
		if (form) {
			jQuery.ajax({
			 type: "POST",
			 url:url,
			 async:false,
			 data : {'<portlet:namespace />captchaText':captchaText},
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
</aui:script>