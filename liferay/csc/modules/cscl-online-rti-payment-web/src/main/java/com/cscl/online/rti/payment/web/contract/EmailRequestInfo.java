package com.cscl.online.rti.payment.web.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailRequestInfo {
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;
	private EmailRequest emailRequest;
	
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public EmailRequest getEmailRequest() {
		return emailRequest;
	}
	public void setEmailRequest(EmailRequest emailRequest) {
		this.emailRequest = emailRequest;
	}
	
}
