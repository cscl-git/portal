<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.expando.kernel.model.ExpandoBridge"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@ include file="/blogs/init.jsp" %>

<liferay-util:dynamic-include key="com.liferay.blogs.web#/blogs/view_entry.jsp#pre" />

<%!
private String getTitle(String title, Locale locale) {
	String val="";
	try{
		//title=HtmlUtil.unescape(title);
		val = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(locale));
	}catch(Exception e){
		
	}
	return val;
}
%>
<%
String redirect = ParamUtil.getString(request, "redirect");
String mvcRenderCommandName = ParamUtil.getString(request, "mvcRenderCommandName");

if (Validator.isNull(redirect)) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("mvcRenderCommandName", "/blogs/view");

	redirect = portletURL.toString();
}

BlogsEntry entry = (BlogsEntry)request.getAttribute(WebKeys.BLOGS_ENTRY);

long entryId = ParamUtil.getLong(request, "entryId", entry.getEntryId());

String entryTitle = getTitle(BlogsEntryUtil.getDisplayTitle(resourceBundle, entry),locale);

AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(BlogsEntry.class.getName(), entry.getEntryId());

AssetEntryServiceUtil.incrementViewCounter(assetEntry);

assetHelper.addLayoutTags(request, AssetTagLocalServiceUtil.getTags(BlogsEntry.class.getName(), entry.getEntryId()));

RatingsEntry ratingsEntry = null;
RatingsStats ratingsStats = RatingsStatsLocalServiceUtil.fetchStats(BlogsEntry.class.getName(), entry.getEntryId());

if (ratingsStats != null) {
	ratingsEntry = RatingsEntryLocalServiceUtil.fetchEntry(themeDisplay.getUserId(), BlogsEntry.class.getName(), entry.getEntryId());
}

if (request.getAttribute(WebKeys.LAYOUT_ASSET_ENTRY) == null) {
	request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntry);
}

request.setAttribute("view_entry_content.jsp-entry", entry);

request.setAttribute("view_entry_content.jsp-assetEntry", assetEntry);

request.setAttribute("view_entry_content.jsp-ratingsEntry", ratingsEntry);
request.setAttribute("view_entry_content.jsp-ratingsStats", ratingsStats);

boolean portletTitleBasedNavigation = GetterUtil.getBoolean(portletConfig.getInitParameter("portlet-title-based-navigation"));

if (portletTitleBasedNavigation) {
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);

	renderResponse.setTitle(entryTitle);
}
renderResponse.setTitle(HtmlUtil.unescape(entryTitle));

Group entryGroup = GroupLocalServiceUtil.getGroup(entry.getGroupId());
boolean isPoll = false;

if(entryGroup.getClassNameId()==ClassNameLocalServiceUtil.getClassNameId(Layout.class.getName())){
	Layout scopeLayout = LayoutLocalServiceUtil.getLayout(entryGroup.getClassPK());
	Group site = GroupLocalServiceUtil.getGroup(scopeLayout.getGroupId());
	
	String pageUrl="";
	
	if(scopeLayout!=null && ("POLLS".equalsIgnoreCase(scopeLayout.getName("en_US")) || "POLL".equalsIgnoreCase(scopeLayout.getName("en_US")))){
		isPoll = true;
	}
}

String displayStyle = BlogsUtil.DISPLAY_STYLE_FULL_CONTENT;
String pollId = "";
if(isPoll){
	ExpandoBridge expando = entry.getExpandoBridge();
	pollId = expando!=null?expando.getAttribute("POLL_ID").toString():"";
	if(Validator.isNotNull(pollId)){
		request.setAttribute("blog-poll-id", pollId);
	}
}
%>

<portlet:actionURL name="/blogs/edit_entry" var="editEntryURL" />

<aui:form action="<%= editEntryURL %>" method="post" name="fm1" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEntry();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="entryId" type="hidden" value="<%= String.valueOf(entryId) %>" />

	<div class="widget-mode-detail" data-analytics-asset-id="<%= String.valueOf(entryId) %>" data-analytics-asset-title="<%= HtmlUtil.escapeAttribute(entryTitle) %>" data-analytics-asset-type="blog">
		<liferay-util:include page="/blogs/view_entry_content_detail.jsp" servletContext="<%= application %>" />
	</div>
</aui:form>

<%if(isPoll && (displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || mvcRenderCommandName.equals("/blogs/view_entry"))){ 
	if(Validator.isNotNull(pollId)){
		request.setAttribute("blog-poll-id", pollId);
%>
	<br/>
	<div class="poll">
		<liferay-portlet:runtime portletName="com_liferay_polls_web_portlet_PollsDisplayPortlet_INSTANCE_poll1234" defaultPreferences=""/> 
	</div>
	<div class="clearfix"></div>
<%}
}%>

<div class="container-fluid">
	<c:if test="<%= PropsValues.BLOGS_ENTRY_PREVIOUS_AND_NEXT_NAVIGATION_ENABLED %>">

		<%
		BlogsEntry[] prevAndNext = BlogsEntryServiceUtil.getEntriesPrevAndNext(entryId);

		BlogsEntry previousEntry = prevAndNext[0];
		BlogsEntry nextEntry = prevAndNext[2];
		%>

		<c:if test="<%= (previousEntry != null) || (nextEntry != null) %>">
			<div class="row" style="display:none">
				<div class="col-md-10 col-md-offset-1 entry-navigation">
					<h2><strong><liferay-ui:message key="more-blog-entries" /></strong></h2>

					<div class="row widget-mode-card">

						<%
						request.setAttribute("view_entry_related.jsp-blogs_entry", previousEntry);
						%>

						<liferay-util:include page="/blogs/view_entry_related.jsp" servletContext="<%= application %>" />

						<%
						request.setAttribute("view_entry_related.jsp-blogs_entry", nextEntry);
						%>

						<liferay-util:include page="/blogs/view_entry_related.jsp" servletContext="<%= application %>" />
					</div>
				</div>
			</div>
		</c:if>
	</c:if>

	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<c:if test="<%= blogsPortletInstanceConfiguration.enableComments() %>">

				<%
				Discussion discussion = CommentManagerUtil.getDiscussion(user.getUserId(), scopeGroupId, BlogsEntry.class.getName(), entry.getEntryId(), new ServiceContextFunction(request));
				%>

				<c:if test="<%= discussion != null %>">
					<c:if test="<%= PropsValues.BLOGS_TRACKBACK_ENABLED && entry.isAllowTrackbacks() && Validator.isNotNull(entry.getUrlTitle()) %>">
						<aui:input inlineLabel="left" name="trackbackURL" type="resource" value='<%= PortalUtil.getLayoutFullURL(themeDisplay.getLayout(), themeDisplay, false) + Portal.FRIENDLY_URL_SEPARATOR + "blogs/trackback/" + entry.getUrlTitle() %>' />
					</c:if>

					<liferay-comment:discussion
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						discussion="<%= discussion %>"
						formName="fm2"
						ratingsEnabled="<%= blogsPortletInstanceConfiguration.enableCommentRatings() %>"
						redirect="<%= currentURL %>"
						userId="<%= entry.getUserId() %>"
					/>
				</c:if>
			</c:if>
		</div>
	</div>
</div>

<%
PortalUtil.setPageTitle(BlogsEntryUtil.getDisplayTitle(resourceBundle, entry), request);

String description = entry.getDescription();

if (Validator.isNull(description)) {
	description = HtmlUtil.stripHtml(StringUtil.shorten(entry.getContent(), pageAbstractLength));
}

PortalUtil.setPageDescription(description, request);

List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(BlogsEntry.class.getName(), entry.getEntryId());

PortalUtil.setPageKeywords(ListUtil.toString(assetTags, AssetTag.NAME_ACCESSOR), request);

PortalUtil.addPortletBreadcrumbEntry(request, BlogsEntryUtil.getDisplayTitle(resourceBundle, entry), currentURL);
%>

<liferay-util:dynamic-include key="com.liferay.blogs.web#/blogs/view_entry.jsp#post" />