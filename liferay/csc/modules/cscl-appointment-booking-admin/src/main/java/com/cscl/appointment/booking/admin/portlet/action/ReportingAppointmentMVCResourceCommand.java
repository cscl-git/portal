package com.cscl.appointment.booking.admin.portlet.action;

import com.cscl.appointment.booking.admin.constants.CsclAppointmentBookingAdminPortletKeys;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

/*import org.apache.poi.ss.appointmentmodel.IndexedColors;
import org.apache.poi.ss.appointmentmodel.Row;
import org.apache.poi.xssf.appointmentmodel.XSSFCellStyle;
import org.apache.poi.xssf.appointmentmodel.XSSFFont;
import org.apache.poi.xssf.appointmentmodel.XSSFSheet;
import org.apache.poi.xssf.appointmentmodel.XSSFWorkbook;*/

import org.osgi.service.component.annotations.Component;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.service.CsclAppointeeMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;
import cscl.appointment.booking.service.CsclApproverMappingLocalServiceUtil;
import cscl.appointment.booking.service.CsclStatusLocalServiceUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclAppointmentBookingAdminPortletKeys.CSCLAPPOINTMENTBOOKINGADMIN,
			"mvc.command.name=/appointmentAdmin/report"
		},
		service = MVCResourceCommand.class
	)

public class ReportingAppointmentMVCResourceCommand implements MVCResourceCommand {

	public static String[] columnNames = { "Name", "Mobile", "E-Mail","Address", "Reason for Appointment", "Status", "Appointee", "Date", "Time" };
	public static final String CSV_SEPARATOR = ",";
	
	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response) throws PortletException {
		String userId = ParamUtil.getString(request, "userId");
		String appointmentStatus = ParamUtil.getString(request, "status");
		
		List<CsclAppointmentMaster> appointmentList = new ArrayList<CsclAppointmentMaster>();
		List<CsclApproverMapping> approvers = new ArrayList<CsclApproverMapping>();
		List<Integer> appointees = new ArrayList<Integer>();
		//String approverName = "";
		if(Validator.isNotNull(userId) && Validator.isNotNull(appointmentStatus)) {
			try{
				approvers = CsclApproverMappingLocalServiceUtil.findByassignedTo(Long.valueOf(userId));
				if(Validator.isNotNull(approvers)){
					//approverName = approvers.get(0).getApprover();
					for(CsclApproverMapping approver : approvers){
						appointees.add(approver.getAppointee());
					}
				}
			}catch(Exception e){
				System.err.println("Error: While getting approvers..");
			}
			try{
				int stats = Integer.parseInt(appointmentStatus);
				for(int appointe : appointees){
					List<CsclAppointmentMaster> tempAppointmentList = new ArrayList<CsclAppointmentMaster>();
					tempAppointmentList = CsclAppointmentMasterLocalServiceUtil.getAppointmentsWithStatus(appointe, stats);
					appointmentList.addAll(tempAppointmentList);
				}
			}catch(Exception e){
				System.err.println("Error : While getting appointment List");
			}
		}else {
			appointmentList = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMasters(0, CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount());
		}
		
		StringBundler sb = new StringBundler();
		for (String columnName : columnNames) {
		sb.append(getCSVFormattedValue(columnName));
		sb.append(CSV_SEPARATOR);
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);
		//List<CsclAppointmentMaster> appointmentList = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMasters(0, CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount());
		String status = "";
		String appointee = "";
		for (CsclAppointmentMaster appointment : appointmentList) {
			try {
			status = CsclStatusLocalServiceUtil.getCsclStatus(appointment.getStatus()).getName();
			appointee = CsclAppointeeMasterLocalServiceUtil.getCsclAppointeeMaster(appointment.getAppointee()).getName();
			}catch(Exception e) {
				System.err.println("Error : While getting status & appointee");
			}
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getName())));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getMobile())));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getEmail())));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getAddress())));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getReason())));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(status));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(appointee));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedDate(appointment.getPreferedDate()));
		sb.append(CSV_SEPARATOR);
		sb.append(getCSVFormattedValue(String.valueOf(appointment.getPreferedTime())));
		sb.append(CSV_SEPARATOR);
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);
		}
	    Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(date);  
	    
		String fileName = strDate+"_"+status+"_Appointments.csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;
		try {
			PortletResponseUtil.sendFile(request, response,	fileName, bytes, contentType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE,
		StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}
	
	protected String getCSVFormattedDate(Date preferedDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = formatter.format(preferedDate);  
	    
		return strDate;
	}

}
