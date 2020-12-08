package com.cscl.online.rti.payment.admin.portlet.action;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.online.rti.payment.admin.constants.CsclOnlineRtiPaymentAdminPortletKeys;
import com.cscl.online.rti.payment.admin.portlet.util.RTIPaymentAdminUtil;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;


@Component(
		property = {
			"javax.portlet.name=" +  CsclOnlineRtiPaymentAdminPortletKeys.CSCLONLINERTIPAYMENTADMIN,
			"mvc.command.name=/rtiAdmin/report"
		},
		service = MVCResourceCommand.class
	)

public class ReportingRtiMVCResourceCommand implements MVCResourceCommand {

	public static Log _log = LogFactoryUtil.getLog(ReportingRtiMVCResourceCommand.class);
	
	public static String[] columnNames = { "Reference Id","Applicant Name", "Applicant Mobile", "Applicant Email","Address", "RTI Subject", "Created Date"};
	public static final String CSV_SEPARATOR = ",";
	
	
	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response)
			throws PortletException {
		
		String fromDate = ParamUtil.getString(request, "fromDate");
		String toDate =  ParamUtil.getString(request, "toDate");
		_log.info("fromDate:"+fromDate+", toDate:"+toDate);
		
		try {
			List<CsclRtiPaymentDetails> rtiList = RTIPaymentAdminUtil.search(fromDate, toDate);
			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			StringBundler sb = new StringBundler();
			for (String columnName : columnNames) {
				sb.append(getCSVFormattedValue(columnName));
				sb.append(CSV_SEPARATOR);
			}
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
			if(Validator.isNotNull(rtiList)) {
				for (CsclRtiPaymentDetails item : rtiList) {
					sb.append(getCSVFormattedValue(String.valueOf(item.getRefId())));
					sb.append(CSV_SEPARATOR);
					sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantName())));
					sb.append(CSV_SEPARATOR);
					sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantMobile())));
					sb.append(CSV_SEPARATOR);
					sb.append(getCSVFormattedValue(String.valueOf(item.getApplicantEmail())));
					sb.append(CSV_SEPARATOR);
					sb.append(getCSVFormattedValue(String.valueOf(item.getAddress())));
					sb.append(CSV_SEPARATOR);
					sb.append(getCSVFormattedValue(String.valueOf(item.getRtiSubject())));
					sb.append(CSV_SEPARATOR);
					sb.append(df.format(item.getCreatedDate()));
					sb.append(CSV_SEPARATOR);
					sb.setIndex(sb.index() - 1);
					sb.append(CharPool.NEW_LINE);
				}
			}
		    Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		    String strDate = formatter.format(date);  
		    
			String fileName = strDate+"_RTI_Payments.csv";
			byte[] bytes = sb.toString().getBytes();
			String contentType = ContentTypes.APPLICATION_TEXT;
			try {
				PortletResponseUtil.sendFile(request, response,	fileName, bytes, contentType);
			} catch (IOException e) {
				_log.error("Error in generating excel",e);
			}
		}catch(Exception e) {
			_log.error("Error in generating excel",e);
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
}
