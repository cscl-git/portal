<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@ include file="../init.jsp" %>

<%@page import="com.liferay.portal.kernel.model.User" %>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>
<%@page import="cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclApproverMapping" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
CsclApproverMapping appointment = (CsclApproverMapping)request.getAttribute(CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN);

String roleName = "AppointmentBookingUser";
List<User> approvers = new ArrayList<User>();
try{
	long roleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), roleName).getRoleId();
	approvers = UserLocalServiceUtil.getRoleUsers(roleId);
}catch(Exception e){
	System.err.println("Error : While getting user Roles..");
}
boolean isSubmitted = ParamUtil.getBoolean(request, "isSubmitted", false);
boolean isEdit = ParamUtil.getBoolean(request, "isEdit");
String appointeeId = ParamUtil.getString(request, "appointeeId","");
%>
<liferay-ui:success key="success-add-approver" message="Approver has been mapped successfully" />
<liferay-ui:error key="no-user" message="Couldn't find any user with the given mail id." />

<liferay-portlet:actionURL name="/appointmentAdmin/add_approver" refererPlid="<%=themeDisplay.getRefererPlid()%>" var="addApproverURL">
	<portlet:param name="mvcPath" value="/appointmentAdmin/add_approver.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%=addApproverURL%>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />

	<aui:model-context bean="<%=appointment%>" model="<%=CsclAppointeeMaster.class%>" />
	<div class="row">
		<div class="col-md-12" style="margin-bottom: 1rem;">
			<h4><liferay-ui:message key="appointee-details" /></h4>
			<hr>
		</div>
		<div class="col-md-6">
			<aui:input name="name" placeholder="name" label="name" value=""/>
		</div>
		<div class="col-md-6">
			<aui:input name="designation" placeholder="designation" label="designation" value="">
			</aui:input>
		</div>
		<div class="col-md-6">
			<aui:select name="approver" label="approver" required="true">
			<aui:option value="" >Select Approver</aui:option>
				<%for(User approver : approvers){ %>
					<aui:option value="<%=approver.getUserId() %>" ><%=approver.getFullName() %></aui:option>
				<%} %>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
	</div>
	<aui:button-row>
	<%if(isSubmitted){ %>
		<a href="<%=redirect%>"><aui:button type="cancel" /></a>
	<%}else{ %>
		<aui:button type="submit" />
		<a href="<%=redirect%>"><aui:button type="cancel" /></a>
	<%} %>
	</aui:button-row>
</aui:form>