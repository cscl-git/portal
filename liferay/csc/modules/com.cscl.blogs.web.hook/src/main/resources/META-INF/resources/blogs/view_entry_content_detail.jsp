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

<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.CharPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil"%>
<%@page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@ include file="/blogs/init.jsp" %>

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

private String getContent(String content, Locale locale) {
	String val="";
	try{
		//content=HtmlUtil.unescape(content);
		val = LocalizationUtil.getLocalization(content, LocaleUtil.toLanguageId(locale));
		
	}catch(Exception e){
		
	}
	return val;
}
%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("view_entry_content.jsp-searchContainer");

BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

String blogTitle=HtmlUtil.escape(getTitle(entry.getTitle(), locale));
long blogPollId = GetterUtil.getLong(request.getAttribute("blog-poll-id"));
if(blogPollId>0){
	PollsQuestion question = PollsQuestionLocalServiceUtil.getPollsQuestion(GetterUtil.getLong(blogPollId));
	if(null != question){
		blogTitle=HtmlUtil.unescape(question.getTitle(locale));
	}
}
%>

<c:choose>
	<c:when test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) && (entry.isVisible() || (entry.getUserId() == user.getUserId()) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE)) %>">
		<portlet:renderURL var="viewEntryURL">
			<portlet:param name="mvcRenderCommandName" value="/blogs/view_entry" />
			<portlet:param name="redirect" value="<%= currentURL %>" />

			<c:choose>
				<c:when test="<%= Validator.isNotNull(entry.getUrlTitle()) %>">
					<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
				</c:when>
				<c:otherwise>
					<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
				</c:otherwise>
			</c:choose>
		</portlet:renderURL>

		<div class="container widget-mode-detail-header">
			<liferay-asset:asset-categories-available
				className="<%= BlogsEntry.class.getName() %>"
				classPK="<%= entry.getEntryId() %>"
			>
				<div class="row">
					<div class="categories col-md-8 mx-auto widget-metadata">
						<liferay-asset:asset-categories-summary
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
							displayStyle="simple-category"
							portletURL="<%= renderResponse.createRenderURL() %>"
						/>
					</div>
				</div>
			</liferay-asset:asset-categories-available>

			<div class="row">
				<div class="col-md-12 mx-auto">
					<div class="autofit-row">
						<div class="autofit-col autofit-col-expand">
							<h3 class="title"><%= blogTitle %></h3>

							<%-- <%
							String subtitle = entry.getSubtitle();
							%>

							<c:if test="<%= Validator.isNotNull(subtitle) %>">
								<h4 class="sub-title"><%= HtmlUtil.escape(subtitle) %></h4>
							</c:if> --%>
						</div>

						<div class="autofit-col visible-interaction">
							<div class="dropdown dropdown-action">
								<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
									<portlet:renderURL var="editEntryURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
										<portlet:param name="mvcRenderCommandName" value="/blogs/edit_entry" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
									</portlet:renderURL>

									<a href="<%= editEntryURL.toString() %>">
										<span class="hide-accessible"><liferay-ui:message key="edit-entry" /></span>

										<clay:icon
											symbol="pencil"
										/>
									</a>
								</c:if>
							</div>
						</div>
					</div>

					<div class="autofit-row widget-metadata">
						<div class="autofit-col inline-item-before">

							<%
							User entryUser = UserLocalServiceUtil.fetchUser(entry.getUserId());

							String entryUserURL = StringPool.BLANK;

							if ((entryUser != null) && !entryUser.isDefaultUser()) {
								entryUserURL = entryUser.getDisplayURL(themeDisplay);
							}
							%>

							<liferay-ui:user-portrait
								cssClass="sticker-lg"
								user="<%= entryUser %>"
							/>
						</div>

						<div class="autofit-col autofit-col-expand">
							<div class="autofit-row">
								<div class="autofit-col autofit-col-expand">
									<div class="text-truncate-inline">
										<span><liferay-ui:message key="posted-by" /></span>&nbsp;
										<span class="post-details"><%= HtmlUtil.escape(entry.getUserName()) %></span>
									</div>

									<div>
										<span><liferay-ui:message key="posted-on" /></span>
										<span class="post-details">
											<%=DateUtil.getDate(entry.getDisplayDate(), "dd-MM-yyyy hh:mm a", locale) %>
											<%-- <liferay-ui:message arguments="<%= LanguageUtil.getTimeDescription(request, System.currentTimeMillis() - entry.getStatusDate().getTime(), true) %>" key="x-ago" translateArguments="<%= false %>" />

											<c:if test="<%= blogsPortletInstanceConfiguration.enableReadingTime() %>">
												- <liferay-reading-time:reading-time displayStyle="descriptive" model="<%= entry %>" />
											</c:if>
	
											<c:if test="<%= blogsPortletInstanceConfiguration.enableViewCount() %>">
	
												<%
												AssetEntry assetEntry = _getAssetEntry(request, entry);
												%>
	
												- <liferay-ui:message arguments="<%= assetEntry.getViewCount() %>" key='<%= (assetEntry.getViewCount() == 1) ? "x-view" : "x-views" %>' />
											</c:if> --%>
										</span>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<%
		String coverImageURL = entry.getCoverImageURL(themeDisplay);
		%>

		<c:if test="<%= Validator.isNotNull(coverImageURL) %>">
			<div class="aspect-ratio aspect-ratio-bg-cover cover-image" style="background-image: url(<%= coverImageURL %>)"></div>
		</c:if>

		<!-- text resume -->

		<div class="container widget-mode-detail-header" id="<portlet:namespace /><%= entry.getEntryId() %>">
			<c:if test="<%= Validator.isNotNull(coverImageURL) %>">

				<%
				String coverImageCaption = entry.getCoverImageCaption();
				%>

				<c:if test="<%= Validator.isNotNull(coverImageCaption) %>">
					<div class="row">
						<div class="col-md-8 mx-auto">
							<div class="cover-image-caption">
								<small><%= entry.getCoverImageCaption() %></small>
							</div>
						</div>
					</div>
				</c:if>
			</c:if>

			<div class="row">
				<div class="col-md-12 mx-auto widget-mode-detail-text">
					<%= getContent(entry.getContent(), locale) %>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 mx-auto widget-mode-detail-text">
					<div class="blog-attachments">

					<%
						List<FileEntry> fileEntries = null;
						try{
							DLFolder folder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, 0, "Bolg Attachments");
							if(folder!=null){
								DLFolder blogfolder = DLFolderLocalServiceUtil.getFolder(scopeGroupId, folder.getFolderId(), entry.getEntryId()+"");
								fileEntries = PortletFileRepositoryUtil.getPortletFileEntries(scopeGroupId, blogfolder.getFolderId());
							}
						}catch(Exception e){
							
						}
						
						if(null != fileEntries && fileEntries.size()>0){ 
							for (FileEntry fileEntry : fileEntries) {
					%>
								<div id="<portlet:namespace />fileEntryIdWrapper<%=fileEntry.getFileEntryId()%>">
							<%
								String rowURL = PortletFileRepositoryUtil.getDownloadPortletFileEntryURL(themeDisplay, fileEntry, "status=" + WorkflowConstants.STATUS_APPROVED);
							%>
		
								<liferay-ui:icon
									iconCssClass="icon-paper-clip"
									label="<%=true%>"
									message='<%=HtmlUtil.escape(fileEntry.getTitle()) + " (" + TextFormatter.formatStorageSize(fileEntry.getSize(), locale) + ")"%>'
									method="get"
									url="<%=rowURL%>"
								/>
							</div>
						<%
							}
						}
						%>
		
					</div>
				</div>
			</div>

			<%-- <liferay-expando:custom-attributes-available
				className="<%= BlogsEntry.class.getName() %>"
			>
				<div class="row">
					<div class="col-md-8 mx-auto widget-mode-detail">
						<liferay-expando:custom-attribute-list
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
							editable="<%= false %>"
							label="<%= true %>"
						/>
					</div>
				</div>
			</liferay-expando:custom-attributes-available> --%>

			<liferay-asset:asset-tags-available
				className="<%= BlogsEntry.class.getName() %>"
				classPK="<%= entry.getEntryId() %>"
			>
				<div class="row">
					<div class="col-md-12 mx-auto widget-mode-detail">
						<div class="entry-tags">
							<liferay-asset:asset-tags-summary
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
								portletURL="<%= renderResponse.createRenderURL() %>"
							/>
						</div>
					</div>
				</div>
			</liferay-asset:asset-tags-available>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-md-12 mx-auto widget-mode-detail">

					<%
					request.setAttribute("entry_toolbar.jsp-entry", entry);
					%>

					<liferay-util:include page="/blogs/entry_toolbar.jsp" servletContext="<%= application %>">
						<liferay-util:param name="showFlags" value="<%= Boolean.TRUE.toString() %>" />
					</liferay-util:include>
				</div>
			</div>

			<c:if test="<%= blogsPortletInstanceConfiguration.enableRelatedAssets() %>">
				<div class="row">
					<div class="col-md-12 mx-auto widget-mode-detail">

						<%
						AssetEntry assetEntry = _getAssetEntry(request, entry);
						%>

						<div class="entry-links">
							<liferay-asset:asset-links
								assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
							/>
						</div>
					</div>
				</div>
			</c:if>
		</div>
	</c:when>
	<c:otherwise>

		<%
		if (searchContainer != null) {
			searchContainer.setTotal(searchContainer.getTotal() - 1);
		}
		%>

	</c:otherwise>
</c:choose>

<%!
private AssetEntry _getAssetEntry(HttpServletRequest request, BlogsEntry entry) throws PortalException, SystemException {
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view_entry_content.jsp-assetEntry");

	if (assetEntry == null) {
		assetEntry = AssetEntryLocalServiceUtil.getEntry(BlogsEntry.class.getName(), entry.getEntryId());

		request.setAttribute("view_entry_content.jsp-assetEntry", assetEntry);
	}

	return assetEntry;
}
%>