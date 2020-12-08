<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ include file="../init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.LocalizationUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="javax.portlet.PortletRequest"%>
<%@ page import="java.util.HashMap"%>
<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil"%>
<%@page import="com.cscl.appointment.booking.admin.portlet.util.AppointmentEntryActionDropdownItemsProvider" %>
<%@page import="cscl.appointment.booking.service.CsclStatusLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.model.CsclStatus" %>
<%@page import="cscl.appointment.booking.service.CsclStatusLocalServiceUtil" %>
<%@page import="cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil"%>
<%@page import="cscl.appointment.booking.model.CsclAppointmentMaster"%>
<%@page import="cscl.appointment.booking.model.CsclAppointeeMaster" %>
<%@page import="cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil" %>
<%@page import="com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys"%>

<%
	System.out.println(".......Reporting.........");
	CsclAppointmentMaster appointment = (CsclAppointmentMaster)request.getAttribute(CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN);

	List<CsclAppointmentMaster> appointmentList = new ArrayList<CsclAppointmentMaster>();
	try{
		appointmentList = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMasters(0, CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount());
	}catch(Exception e){
		System.err.println("Error : While getting appointment list w.r.t status");
	}
	List<CsclStatus> statusList = new ArrayList<CsclStatus>();
	List<CsclAppointeeMaster> appointees = new ArrayList<CsclAppointeeMaster>();
	CsclAppointmentMaster appointmentObj = null;
	long appointmentId = ParamUtil.getLong(request, "appointmentId");
	//System.out.println("appointment Id..."+appointmentId);
	try{
		statusList = CsclStatusLocalServiceUtil.getActiveStatuses();
		appointmentObj = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMaster(appointmentId);
	}catch(Exception e){
		System.err.println("Error : While getting Status");
	}
%>
<portlet:resourceURL id="/appointmentAdmin/report" var="exportCSVURL" />
<h2>
	<liferay-ui:message key="search-criteria" />
</h2>

<aui:form cssClass="contact-form" action="<%=addCustomPollAdminURL%>"
	method="post" name="fm">
	<aui:model-context bean="<%=appointment%>" model="<%=CsclAppointmentMaster.class%>" />
	<div class="row">
		<div class="col-md-4">
			<aui:select name="status" label="status">
			<aui:option value="" >Select Status</aui:option>
				<%for(CsclStatus status : statusList){ %>
					<aui:option value="<%=status.getId_() %>" ><%=status.getName() %></aui:option>
				<%} %>
				<aui:validator name="required" ></aui:validator>
			</aui:select>
		</div>
		<div class="col-md-4">
			<aui:input label="preferedDate" name="preferedDate" placeholder="preferedDate" disabled="true"/>
		</div>
		<div class="col-md-4">
			<aui:input label="preferedDate" name="appointedDate" placeholder="appointedDate" disabled="true"/>
		</div>
		<div class="form-group" style="padding: 10px;">
			<aui:button type="submit" value="search" />
		</div>
	</div>
</aui:form>

<div class="row">
	<div class="col-md-12">
		<h3>Report is ready. Please click below button to download</h3>
	</div>
</div>