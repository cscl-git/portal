<%@page import="com.cscl.tender.portlet.util.TenderEntryActionDropdownItemsProvider"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.cscl.tender.model.CsclTenderCategory"%>
<%@page import="com.cscl.tender.service.CsclTenderCategoryLocalServiceUtil"%>
<%@page import="com.cscl.tender.portlet.util.CommonUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.cscl.tender.portlet.util.comparator.CustomComapatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.cscl.tender.service.CsclTenderLocalServiceUtil"%>
<%@page import="com.cscl.tender.model.CsclTender"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>


<portlet:renderURL var="editURL" windowState="normal">
	<portlet:param name="mvcPath" value="/tender/edit_tender.jsp"/>
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</portlet:renderURL>

<p>
	<b><liferay-ui:message key="cscltender.add.tender"/></b>
	<aui:button-row>
		<aui:button href="<%= editURL %>" type="submit" value="Add"/>
	</aui:button-row>
</p>


<%
String orderByCol = ParamUtil.getString(request, "orderByCol","publishDate"); 
String orderByType = ParamUtil.getString(request, "orderByType","asc");
int pageNo=GetterUtil.getInteger(ParamUtil.getString(request,"cur"));
int itemsPerPage=GetterUtil.getInteger(ParamUtil.getString(request,"delta")); 

int startPagination =1;
int endPagination=20;
if(itemsPerPage != 0){
	if(pageNo != 0){
		startPagination=itemsPerPage*(pageNo-1)+1;
		endPagination=pageNo*itemsPerPage;
	}else{
		endPagination = itemsPerPage;
	}
}
int counter=startPagination;

List<CsclTender> tempTenderList = CsclTenderLocalServiceUtil.getCsclTenders(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<CsclTender> tenderList = new ArrayList<CsclTender>(tempTenderList);
if(Validator.isNotNull(tenderList)){
    OrderByComparator comparator = CustomComapatorUtil.getOrderByComparator(orderByCol, orderByType);
    ListUtil.sort(tenderList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/tender/view.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);		

%>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
 
<liferay-ui:search-container-results >
    <%
    results = tenderList;			    
	total = tenderList.size();
	searchContainer.setTotal(results.size());
	pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
 
    <liferay-ui:search-container-row
        className="com.cscl.tender.model.CsclTender"
        modelVar="tender" keyProperty="tenderId">
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text orderable="true" name="title" orderableProperty="title">
        	<%=CommonUtil.getTextFromXml(tender.getTitle(), locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "description") %>">
        	<%=StringUtil.shorten( HtmlUtil.render(CommonUtil.getTextFromXml(tender.getDescription(), locale)), 200) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "category") %>">
        	<%
        		if(tender.getTenderCategoryId() != 0){
        			CsclTenderCategory category = CsclTenderCategoryLocalServiceUtil.getCsclTenderCategory(tender.getTenderCategoryId());
        			if(null != category){
        				out.print(CommonUtil.getTextFromXml(category.getCategory(), locale));
        			}
        		}
        	%>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "publish-date") %>" orderable="true" orderableProperty="publishDate">
        	<%=DateUtil.getDate(tender.getPublishDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "last-apply-date") %>" orderable="true" orderableProperty="lastApplyDate">
        	<%=DateUtil.getDate(tender.getLastApplyDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "tender-opening-date") %>" orderable="true" orderableProperty="tenderOpeningDate">
			<%=DateUtil.getDate(tender.getTenderOpeningDate(), "dd-MM-yyyy HH:mm a", locale) %>        
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "status") %>">
        	<%=tender.getStatus() == 1?LanguageUtil.get(locale, "active"):LanguageUtil.get(locale, "inactive")%>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text>

			<%
			TenderEntryActionDropdownItemsProvider tenderEntryActionDropdownItemsProvider = new TenderEntryActionDropdownItemsProvider(tender, renderRequest, renderResponse, permissionChecker, resourceBundle);
			%>

			<clay:dropdown-actions
				dropdownItems="<%= tenderEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
			/>
		</liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
