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
<portlet:resourceURL id="/appointmentAdmin/editAppointee" var="getApproversURL">
</portlet:resourceURL>
<%
long userId = themeDisplay.getUserId();

//List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
List<CsclAppointeeMaster> allAppointees = new ArrayList<CsclAppointeeMaster>();
List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
List<Integer> appointees = new ArrayList<Integer>();
String approverName = "";
//getting filtered Data
String appointeeId = ParamUtil.getString(request, "appointeeId","");
//String approverData = ParamUtil.getString(request, "approvers");
String err = ParamUtil.getString(request, "err", "");
boolean isResult = ParamUtil.getBoolean(request, "isResult");
CsclAppointeeMaster appointeeSelected;
String selectedappointeeName = "";
String selectedappointeeDesignation = "";
try{
	if(Validator.isNotNull(appointeeId)){
		appointeeSelected = CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(Long.valueOf(appointeeId));
		selectedappointeeDesignation = appointeeSelected.getDesignation();
		selectedappointeeName = appointeeSelected.getName();
		approvers = CsclApproverMappingLocalServiceUtil.findByassignedTo(Long.valueOf(appointeeId));
	}
}catch(Exception e){
	System.err.println(e.getMessage());
}
//if(appointmentList.size()>0){
//Till here


try{
	allAppointees = CsclAppointeeMasterLocalServiceUtil.getActiveAppointees();
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
List<CsclApproverMapping> appointmentList = new ArrayList<CsclApproverMapping>();
String appointeeName = "";
String appointeeDesignation = "";
try{
	appointmentList = CsclApproverMappingLocalServiceUtil.getCsclApproverMappings(0, CsclApproverMappingLocalServiceUtil.getCsclApproverMappingsCount());
}catch(Exception e){
	System.err.println("Error : While getting appointment List");
}

if(Validator.isNotNull(appointmentList)){
	OrderByComparator comparator = CustomComparatorUtil.getOrderByComparator(orderByCol, orderByType);
	ListUtil.sort(appointmentList, comparator);
}
PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/appointmentAdmin/appointee_mapper.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);

if(appointmentList.size()>0){
	String stringValuedUserId = String.valueOf(userId);
%>
<liferay-portlet:actionURL name="/appointmentAdmin/editAppointee" refererPlid="<%=themeDisplay.getRefererPlid()%>" var="editAppointeeURL">
	<portlet:param name="mvcPath" value="/appointmentAdmin/appointee_mapper.jsp" />
</liferay-portlet:actionURL>
<portlet:renderURL var="addApproverURL">
	<portlet:param name="mvcRenderCommandName" value="/appointmentAdmin/add_approver_render" />
	<portlet:param name="redirect" value="<%= currentUrl %>" />
</portlet:renderURL>
<b><liferay-ui:message key="list-appointment"/></b>
<b style="color:blue"><%=approverName %></b>

<aui:form action="<%=editAppointeeURL%>" cssClass="container-fluid-1280" method="post" name="fm">
	<div class="row">
		<div class="col-md-6">
			<aui:select name="appointee" label="appointment-with" required="true">
			<aui:option value="" >Select Appointee</aui:option>
				<%for(CsclAppointeeMaster appointee : allAppointees){ %>
					<aui:option value="<%=appointee.getId_() %>" ><%=appointee.getName() %> (<%=appointee.getDesignation() %>)</aui:option>
				<%} %>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
		<div class="col-md-6" style="float:right">
			<aui:button type="submit" />
		</div>
	</div>
</aui:form>
<%if(isResult){ %>
	<div class="row">
		<h2>
			<liferay-ui:message key="approintee-details" />
		</h2>	
		<!-- Populated section -->
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="<%=selectedappointeeName %>" id="appointeeName" disabled="true"/>
		</div>
		<div class="col-md-6 name-field">
			<aui:input name="name" placeholder="name" label="name" value="<%=selectedappointeeDesignation %>" id="appointeeDesignation" disabled="true"/>
		</div>
	</div>
	<div id="appointeeRes">
		<h2>
			<liferay-ui:message key="approver-list" />
		</h2>	
		<div class="col-md-6">
			<a href="<%=addApproverURL %>"><aui:button type="add" value="Map Approver"/></a>
		</div>
		<div class="col-md-12">
			<!-- Search container with the list of approvers -->
		<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  >
			<liferay-ui:search-container-results >
			    <%
				    results = approvers;			    
					total = approvers.size();
					searchContainer.setTotal(results.size());
					pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
				    pageContext.setAttribute("total", results.size());
			    %>
			</liferay-ui:search-container-results>
		    <liferay-ui:search-container-row className="cscl.appointment.booking.model.CsclApproverMapping"
		        modelVar="approver" keyProperty="id_">
		        <liferay-ui:search-container-column-text name="#">
					<span class="pull-right"><%=counter++ %></span>
				</liferay-ui:search-container-column-text>
				 <liferay-ui:search-container-column-text name="name">
		        	<%=CommonUtil.getTextFromXml(approver.getApprover(), locale) %>
		        </liferay-ui:search-container-column-text>	
		        <liferay-ui:search-container-column-text name="email">
		        	<%=CommonUtil.getTextFromXml(UserLocalServiceUtil.getUser(approver.getAssignedTo()).getEmailAddress(), locale) %>
		        </liferay-ui:search-container-column-text>
		        <%-- <liferay-ui:search-container-column-text name="action">
					<% 
					AppointmentEntryActionDropdownItemsProvider appointmentEntryActionDropdownItemsProvider = 
						new AppointmentEntryActionDropdownItemsProvider(appointmentMaster, renderRequest, 
								renderResponse, permissionChecker);
					%>
					<clay:dropdown-actions
						dropdownItems="<%= appointmentEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
					/>
				</liferay-ui:search-container-column-text> --%>
		    </liferay-ui:search-container-row>
		</liferay-ui:search-container>
		</div>
	</div>
	<%if(err.equalsIgnoreCase("failed")){ %>
	<div id="appointeeResFailed">
		<b><liferay-ui:message key="no-appointment"/></b>
	</div>
	<%}else if(err.equalsIgnoreCase("appointeeId-empty")){ %>
		
	<%} %>
<%} %>
<%}else{ %>
	<b><liferay-ui:message key="no-details-found"/></b>
<%} %>