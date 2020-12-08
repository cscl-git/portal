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
<%@ include file="/init.jsp" %>

<portlet:renderURL var="editURL">
	<portlet:param name="mvcPath" value="appointmentAdmin"/>
	<%-- <portlet:param name="redirect" value="<%=currentUrl %>"/> --%>
</portlet:renderURL>

<%
long userId = themeDisplay.getUserId();
List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
List<Integer> appointees = new ArrayList<Integer>();
String approverName = "";
try{
	approvers = CsclApproverMappingLocalServiceUtil.findByassignedTo(userId);
	if(Validator.isNotNull(approvers)){
		approverName = approvers.get(0).getApprover();
		for(CsclApproverMapping approver : approvers){
			appointees.add(approver.getAppointee());
		}
	}
}catch(Exception e){
	System.err.println("Error: While getting approvers..");
}

String orderByCol = ParamUtil.getString(request, "orderByCol","refId");
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
int status = 3;//Rejected
List<CsclAppointmentMaster> appointmentList = new ArrayList<CsclAppointmentMaster>();
String appointeeName = "";
String appointeeDesignation = "";
try{
	for(int appointe : appointees){
		List<CsclAppointmentMaster> tempAppointmentList = new ArrayList<CsclAppointmentMaster>();
		tempAppointmentList = CsclAppointmentMasterLocalServiceUtil.getAppointmentsWithStatus(appointe, status);
		appointmentList.addAll(tempAppointmentList);
	}
}catch(Exception e){
	System.err.println("Error : While getting appointment List");
}
if(Validator.isNotNull(appointmentList)){
	OrderByComparator comparator = CustomComparatorUtil.getOrderByComparator(orderByCol, orderByType);
	ListUtil.sort(appointmentList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/appointmentAdmin/pending_appointments.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);

if(appointmentList.size()>0){
	String stringValuedUserId = String.valueOf(userId);
%>
<portlet:resourceURL id="/appointmentAdmin/report" var="exportCSVURL">
	<portlet:param name="userId" value="<%=stringValuedUserId %>"/>
	<portlet:param name="status" value="2"/>
</portlet:resourceURL>

<b><liferay-ui:message key="list-appointment"/></b>
<b style="color:blue"><%=approverName %></b>

<span style="float:right;"><a href="<%=exportCSVURL%>">Export Data as CSV</a></span>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
 
<liferay-ui:search-container-results >
    <%
	    results = appointmentList;			    
		total = appointmentList.size();
		searchContainer.setTotal(results.size());
		pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
	    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
    <liferay-ui:search-container-row
        className="cscl.appointment.booking.model.CsclAppointmentMaster"
        modelVar="appointmentMaster" keyProperty="id_">
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text orderable="true" name="refId" orderableProperty="refId">
        	<%=CommonUtil.getTextFromXml(appointmentMaster.getRefId(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="name">
        	<%=CommonUtil.getTextFromXml(appointmentMaster.getName(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="mobile">
        	<%=CommonUtil.getTextFromXml(appointmentMaster.getMobile(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="reason">
        	<%=CommonUtil.getFormattedText(appointmentMaster.getReason(), locale) %>
        </liferay-ui:search-container-column-text>
 		<liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "preferedDate") %>" orderable="true" orderableProperty="preferedDate">
        	<%=DateUtil.getDate(appointmentMaster.getPreferedDate(), "dd-MM-yyyy", locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "preferedTime") %>">
        	<%= CommonUtil.getTextFromXml(appointmentMaster.getPreferedTime(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "appointee") %>">
        	<%= CommonUtil.getTextFromXml(CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(appointmentMaster.getAppointee()).getName(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="status">
        	<%=CommonUtil.getTextFromXml(CsclStatusLocalServiceUtil.getCsclStatus(appointmentMaster.getStatus()).getName(), locale) %>
        </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text name="action">
			<% 
			AppointmentEntryActionDropdownItemsProvider appointmentEntryActionDropdownItemsProvider = 
				new AppointmentEntryActionDropdownItemsProvider(appointmentMaster, renderRequest, 
						renderResponse, permissionChecker);
			%>
			<clay:dropdown-actions
				dropdownItems="<%= appointmentEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
			/>
		</liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
<%}else{ %>
<b><liferay-ui:message key="no-appointment"/></b>
<%} %>
