package com.cscl.online.rti.payment.web.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SmsRequestInfo {
	
	@JsonProperty("RequestInfo")
	private RequestInfo requestInfo;
	private SmsRequest smsRequest;
	
	public RequestInfo getRequestInfo() {
		return requestInfo;
	}
	public void setRequestInfo(RequestInfo requestInfo) {
		this.requestInfo = requestInfo;
	}
	public SmsRequest getSmsRequest() {
		return smsRequest;
	}
	public void setSmsRequest(SmsRequest smsRequest) {
		this.smsRequest = smsRequest;
	}
	
}
