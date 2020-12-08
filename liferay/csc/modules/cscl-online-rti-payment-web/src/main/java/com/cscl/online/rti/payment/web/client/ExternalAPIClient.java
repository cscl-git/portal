package com.cscl.online.rti.payment.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import com.cscl.online.rti.payment.web.contract.EmailRequestInfo;
import com.cscl.online.rti.payment.web.contract.RequestInfo;
import com.cscl.online.rti.payment.web.contract.SmsRequestInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class ExternalAPIClient {
	
	public static Log _log = LogFactoryUtil.getLog(ExternalAPIClient.class);

	/* DEV URL */
	public static final String ipHostAccessToken = "https://egov-dev.chandigarhsmartcity.in/user/oauth/token";
	public static final String ipHostSendSMS = "https://egov-dev.chandigarhsmartcity.in/notification-service/sms/v1/_send";
	public static final String ipHostSendMail = "https://egov-dev.chandigarhsmartcity.in/notification-service/email/v1/_send";
	
	/* PRODUCTION URL */
	//public static final String ipHostAccessToken = "https://egov.chandigarhsmartcity.in/user/oauth/token";
	//public static final String ipHostSendSMS = "https://egov.chandigarhsmartcity.in/notification-service/sms/v1/_send";
	//public static final String ipHostSendMail = "https://egov.chandigarhsmartcity.in/notification-service/email/v1/_send";
	
	/*public static String generateAdminTokens() {
		final RestTemplate restTemplate = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		header.add("Authorization", "Basic ZWdvdi11c2VyLWNsaWVudDplZ292LXVzZXItc2VjcmV0");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("username", "NOTIFICATIONUSER");
		map.add("scope", "read");
		map.add("password", "123456");
		map.add("grant_type", "password");
		map.add("tenantId", "ch");
		map.add("userType", "SYSTEM");
		org.springframework.http.HttpEntity<MultiValueMap<String, String>> request = new org.springframework.http.HttpEntity(map, header);

		Object response = restTemplate.postForObject(ipHostAccessToken, request, Object.class);
		if (response != null)
			return String.valueOf(((HashMap) response).get("access_token"));
		
		return null;
	}*/
	 
	public static RequestInfo generateRequestInfo(String token) {
		RequestInfo requestInfo = new RequestInfo();
		requestInfo.setApiId("Rainmaker");
		requestInfo.setVer(".01");
		requestInfo.setTs("");
		requestInfo.setAction("_send");
		requestInfo.setDid("1");
		requestInfo.setKey("");
		requestInfo.setMsgId("20170310130900|en_IN");
		requestInfo.setAuthToken(token);
		return requestInfo;
	}
	
	public static String generateAdminToken() throws ClientProtocolException, IOException, JSONException {
		HttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(ipHostAccessToken);
		StringBuffer result = new StringBuffer();
		String accesToken = ""; 
		post.setHeader(HttpHeaders.AUTHORIZATION, "Basic ZWdvdi11c2VyLWNsaWVudDplZ292LXVzZXItc2VjcmV0");
		post.setHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_FORM_URLENCODED_VALUE);

		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("username", "NOTIFICATIONUSER"));
		nameValuePairs.add(new BasicNameValuePair("scope", "read"));
		nameValuePairs.add(new BasicNameValuePair("password", "123456"));
		nameValuePairs.add(new BasicNameValuePair("grant_type", "password"));
		nameValuePairs.add(new BasicNameValuePair("tenantId", "ch"));
		nameValuePairs.add(new BasicNameValuePair("userType", "SYSTEM"));
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
		HttpResponse response = client.execute(post);
		BufferedReader rd = new BufferedReader(	new InputStreamReader(response.getEntity().getContent()));
		
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
	
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(result.toString());
		accesToken = jsonObject.getString("access_token");
		_log.info("Access Token:"+accesToken); 
					
		return accesToken;
		
	}	
	public static String sendSms(SmsRequestInfo smsRequestInfo) {
		HttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(ipHostSendSMS);
		StringBuffer result = new StringBuffer();
		try {
			post.setHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_UTF8_VALUE);
			ObjectMapper mapper = new ObjectMapper();
			StringEntity entity = new StringEntity(mapper.writeValueAsString(smsRequestInfo),ContentType.APPLICATION_JSON);
		    post.setEntity(entity);
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		}catch(Exception e) {
			_log.error("Error in sending sms ",e);
		}
		_log.info("SMS sent output:"+result.toString());
		
		return result.toString();
		
	}
	
	public static String sendMail(EmailRequestInfo emailRequestInfo) {
		HttpClient client = HttpClients.custom().build();
		HttpPost post = new HttpPost(ipHostSendMail);
		StringBuffer result = new StringBuffer();
		try {
			post.setHeader(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_UTF8_VALUE);
			ObjectMapper mapper = new ObjectMapper();
			StringEntity entity = new StringEntity(mapper.writeValueAsString(emailRequestInfo),ContentType.APPLICATION_JSON);
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		}catch(Exception e) {
			_log.error("Error in sending email ",e);
		}
		_log.info("Email sent output:"+result.toString());
		
		return result.toString();
		
	}
			
}
