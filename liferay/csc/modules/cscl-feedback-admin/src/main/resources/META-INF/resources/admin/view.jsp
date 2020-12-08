<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.cscl.feedback.admin.util.comparator.CustomComapatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.cscl.feedback.model.Feedback"%>
<%@page import="com.cscl.feedback.service.FeedbackLocalServiceUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ include file="../init.jsp" %>

<%
String orderByCol = ParamUtil.getString(request, "orderByCol","createDate"); 
String orderByType = ParamUtil.getString(request, "orderByType","desc");
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

List<Feedback> tempTenderList = FeedbackLocalServiceUtil.getFeedbacks(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<Feedback> feedbackList = new ArrayList<Feedback>(tempTenderList);
if(Validator.isNotNull(feedbackList)){
    OrderByComparator comparator = CustomComapatorUtil.getOrderByComparator(orderByCol, orderByType);
    ListUtil.sort(feedbackList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/admin/view.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);		

%>

<p>
	<b><liferay-ui:message key="all-feedback" /></b>
</p>

<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
 
<liferay-ui:search-container-results >
    <%
    results = feedbackList;			    
	total = feedbackList.size();
	searchContainer.setTotal(results.size());
	pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
 
    <liferay-ui:search-container-row
        className="com.cscl.feedback.model.Feedback"
        modelVar="feedback" keyProperty="feedbackId">
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text orderable="true" name="name" orderableProperty="name">
        	<%=feedback.getName() %>
        </liferay-ui:search-container-column-text>
        
        <liferay-ui:search-container-column-text orderable="true" name="email" orderableProperty="email">
        	<%=feedback.getEmail() %>
        </liferay-ui:search-container-column-text>
        
        <liferay-ui:search-container-column-text orderable="true" name="mobile" orderableProperty="mobile">
        	<%=feedback.getMobile() %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "comments") %>">
        	<%=StringUtil.shorten(feedback.getComments(), 200) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "create-date") %>" orderable="true" orderableProperty="createDate">
        	<%=DateUtil.getDate(feedback.getCreateDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

<style>
.taglib-search-iterator-page-iterator-top{
	display: none;
}
</style>