 <%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.cscl.appointment.booking.admin.portlet.util.comparator.CustomComparatorUtil"%>
<%@page import="com.cscl.appointment.booking.admin.portlet.util.CommonUtil" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.*"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster"%>
<%@page import="com.cscl.appointment.booking.admin.portlet.util.AppointmentEntryActionDropdownItemsProvider" %>
<%@page import="cscl.appointment.booking.service.CsclStatusLocalServiceUtil" %>
<%@page import="java.util.ResourceBundle" %>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %>

<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster"%>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclApproverMapping" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>

<%-- <%@ include file="/init.jsp" %> --%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath" value="appointmentAdmin"/>
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</portlet:renderURL>
<%
List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
try{
	approvers = CsclApproverMappingLocalServiceUtil.getCsclApproverMappings(0, CsclApproverMappingLocalServiceUtil.getCsclApproverMappingsCount());
	System.out.println("Approvers..");
}catch(Exception e){
	System.err.println("Error: While getting approvers..");
}

/* String orderByCol = ParamUtil.getString(request, "orderByCol","id_");
String orderByType = ParamUtil.getString(request, "orderByType","desc"); */
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
/* if(Validator.isNotNull(approvers)){
	OrderByComparator comparator = CustomComparatorUtil.getOrderByComparator(orderByCol, orderByType);
	ListUtil.sort(approvers, comparator);
}
 */
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/appointmentAdmin/manage_appointee_mapper.jsp");
/* iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType); 
*/
long userId = themeDisplay.getUserId();
if(approvers.size()>0){
%>
<portlet:renderURL var="addApproverURL">
	<portlet:param name="mvcRenderCommandName" value="/appointmentAdmin/add_approver_render" />
	<portlet:param name="redirect" value="<%=currentUrl %>" />
</portlet:renderURL>

<b><liferay-ui:message key="list-appointee"/></b>

<span style="float:right;"><a href="<%=addApproverURL%>"><aui:button type="add"/></a></span>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>">
 
<liferay-ui:search-container-results >
    <%
	    results = approvers;			    
		total = approvers.size();
		searchContainer.setTotal(results.size());
		pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
	    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
    <liferay-ui:search-container-row
        className="cscl.appointment.booking.model.CsclApproverMapping"
        modelVar="approver" keyProperty="id_">
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
		 <liferay-ui:search-container-column-text name="approver">
        	<%=CommonUtil.getTextFromXml(approver.getApprover(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="email">
        	<%=CommonUtil.getFormattedText(UserLocalServiceUtil.getUser(approver.getAssignedTo()).getEmailAddress(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="appointee">
        	<%=CommonUtil.getFormattedText(CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(approver.getAppointee()).getName(), locale) %>
        </liferay-ui:search-container-column-text>
         <liferay-ui:search-container-column-text name="appointeeDesignation">
        	<%=CommonUtil.getFormattedText(CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(approver.getAppointee()).getDesignation(), locale) %>
        </liferay-ui:search-container-column-text>
       <%--  <liferay-ui:search-container-column-text name="action">
			<% 
			AppointmentEntryActionDropdownItemsProvider appointmentEntryActionDropdownItemsProvider = 
				new AppointmentEntryActionDropdownItemsProvider(approver, renderRequest, 
						renderResponse, permissionChecker);
			%>
			<clay:dropdown-actions
				dropdownItems="<%= appointmentEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
			/>
		</liferay-ui:search-container-column-text> --%>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
<%}else{ %>
<b><liferay-ui:message key="no-appointee"/></b>
<%} %>
