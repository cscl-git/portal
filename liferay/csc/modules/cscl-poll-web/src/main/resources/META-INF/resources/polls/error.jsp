<%@page import="com.liferay.polls.exception.NoSuchQuestionException"%>
<%@ include file="/init.jsp" %>

<liferay-ui:error-header />

<liferay-ui:error exception="<%= NoSuchQuestionException.class %>" message="the-question-could-not-be-found" />

<liferay-ui:error-principal />