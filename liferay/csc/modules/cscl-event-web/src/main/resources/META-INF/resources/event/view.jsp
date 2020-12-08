<%@page import="com.cscl.event.service.CsclEventLocalServiceUtil"%>
<%@page import="com.cscl.event.model.CsclEvent"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>


<portlet:renderURL var="editURL" windowState="normal">
	<portlet:param name="mvcPath" value="/event/edit_event.jsp"/>
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</portlet:renderURL>

<p>
	<b><liferay-ui:message key="add.event"/></b>
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

List<CsclEvent> tempEventList = CsclEventLocalServiceUtil.getCsclEvents(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<CsclEvent> eventList = new ArrayList<CsclEvent>(tempEventList);
if(Validator.isNotNull(eventList)){
    OrderByComparator comparator = CustomComapatorUtil.getOrderByComparator(orderByCol, orderByType);
    ListUtil.sort(eventList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/event/view.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);		

%>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
 
<liferay-ui:search-container-results >
    <%
    results = eventList;			    
	total = eventList.size();
	searchContainer.setTotal(results.size());
	pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
 
    <liferay-ui:search-container-row
        className="com.cscl.event.model.CsclEvent"
        modelVar="event" keyProperty="eventId">
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text orderable="true" name="title" orderableProperty="title">
        	<%=CommonUtil.getTextFromXml(event.getTitle(), locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "description") %>">
        	<%=StringUtil.shorten( HtmlUtil.render(CommonUtil.getTextFromXml(event.getDescription(), locale)), 200) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "category") %>">
        	<%
        		if(event.getEventCategoryId() != 0){
        			CsclEventCategory category = CsclEventCategoryLocalServiceUtil.getCsclEventCategory(event.getEventCategoryId());
        			if(null != category){
        				out.print(CommonUtil.getTextFromXml(category.getCategory(), locale));
        			}
        		}
        	%>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "publish-date") %>" orderable="true" orderableProperty="publishDate">
        	<%=DateUtil.getDate(event.getPublishDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "last-apply-date") %>" orderable="true" orderableProperty="lastApplyDate">
        	<%=DateUtil.getDate(event.getLastApplyDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "event-opening-date") %>" orderable="true" orderableProperty="eventOpeningDate">
			<%=DateUtil.getDate(event.getEventOpeningDate(), "dd-MM-yyyy HH:mm a", locale) %>        
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "status") %>">
        	<%=event.getStatus() == 1?LanguageUtil.get(locale, "active"):LanguageUtil.get(locale, "inactive")%>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text>

			<%
			EventEntryActionDropdownItemsProvider eventEntryActionDropdownItemsProvider = new EventEntryActionDropdownItemsProvider(event, renderRequest, renderResponse, permissionChecker, resourceBundle);
			%>

			<clay:dropdown-actions
				dropdownItems="<%= eventEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
			/>
		</liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
