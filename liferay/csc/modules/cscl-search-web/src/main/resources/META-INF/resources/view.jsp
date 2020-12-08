<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.cscl.search.service.CsclSearchLocalServiceUtil"%>
<%@page import="com.cscl.search.model.CsclSearch"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<%
String keywords =ParamUtil.getString(PortalUtil.getOriginalServletRequest(request), "q", StringPool.BLANK);

DateFormat df = new SimpleDateFormat("MM dd, yyyy hh:mm a");
int totalRecords=0;
List<CsclSearch> searchList = new ArrayList<CsclSearch>();

if(Validator.isNotNull(keywords)){
	searchList = CsclSearchLocalServiceUtil.findByKeyword(WorkflowConstants.ACTION_PUBLISH, keywords);
	if(null != searchList && !searchList.isEmpty()){
		totalRecords = searchList.size();
	}
}

PortletURL iteratorURL = renderResponse.createRenderURL();
%>

<%if(totalRecords >0){ %>
<p class="search-total-label text-default">
	<%= totalRecords %> results for <strong><%= HtmlUtil.escape(keywords) %></strong>
</p>

<%}if(Validator.isNotNull(keywords)){ %>

<liferay-ui:search-container
	id='<%= renderResponse.getNamespace() + "searchContainerTag" %>'
	emptyResultsMessage="<%=LanguageUtil.format(request, "no-results-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) + "</strong>", false) %>"
	delta="5">
	
	<liferay-ui:search-container-results >
	    <%
	    results = searchList;			    
		total = searchList.size();
		searchContainer.setTotal(results.size());
		pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
	    pageContext.setAttribute("total", results.size());
	    %>
	</liferay-ui:search-container-results>
	
	<liferay-ui:search-container-row
		className="com.cscl.search.model.CsclSearch"
		escapedModel="<%= false %>"
		keyProperty="id"
		modelVar="search"
		stringKey="<%= true %>"
	>
	
	<liferay-ui:search-container-column-text>
		<liferay-ui:user-portrait
				userId="<%= search.getCreatedById() %>"
			/>
	</liferay-ui:search-container-column-text>

	<liferay-ui:search-container-column-text
		colspan="<%= 2 %>"
	>
		<h4>
			<a href="<%= search.getLink() %>" target="_blank">
				<strong><%= search.getName() %></strong>
			</a>
		</h4>

		<h6 class="text-default">
			<liferay-ui:message key="written-by" /> <strong><%= search.getUserName() %></strong>
			<liferay-ui:message key="on-date" /> <%= df.format(search.getCreateDate()) %>
		</h6>

		<h6 class="search-document-content text-default">
			<%= search.getDescription() %>
		</h6>

		
	</liferay-ui:search-container-column-text>
	
	</liferay-ui:search-container-row>

	<aui:form useNamespace="<%= false %>">
		<liferay-ui:search-iterator
			displayStyle="descriptive"
			markupView="lexicon"
			type="more"
		/>
	</aui:form>
</liferay-ui:search-container>
<%} %>

<style>
	.taglib-asset-tags-summary a.badge, .taglib-asset-tags-summary a.badge:hover {
		color: #65B6F0;
	}

	.search-total-label {
		margin-top: 35px;
	}

	.search-asset-type-sticker {
		color: #869CAD;
	}

	.search-document-content {
		font-weight: 400;
	}

	.search-result-thumbnail-img {
		height: 44px;
		width: 44px;
	}

	.tabular-list-group .list-group-item-content h6.search-document-tags {
		margin-top: 13px;
	}
</style>