package com.cscl.online.rti.payment.admin.portlet.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.service.CsclRtiPaymentDetailsLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class RTIPaymentAdminUtil {

	public static Log _log = LogFactoryUtil.getLog(RTIPaymentAdminUtil.class);
	
	public static List<CsclRtiPaymentDetails> search(String fromDate, String toDate){
		_log.info("fromDate:"+fromDate+", toDate:"+toDate);
		
		List<CsclRtiPaymentDetails> rtiList = new ArrayList<CsclRtiPaymentDetails>();
		if(Validator.isNotNull(fromDate) && Validator.isNotNull(toDate)) {
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT * FROM cscl_rti_payment WHERE DATE(createdDate) BETWEEN '");
			sql.append(fromDate);
			sql.append("' AND '");
			sql.append(toDate);
			sql.append("' order by createdDate desc");
			try{
				rtiList = executeQuery(sql.toString());
			}catch(Exception e){
				_log.error("Error in getting rti payment request data",e);
			}
		}else {
			rtiList = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetailses(-1, -1);
		}
		
		return rtiList;
	}
	
	public static List<CsclRtiPaymentDetails> executeQuery(String sql) {
		List<CsclRtiPaymentDetails> rtis = new ArrayList<CsclRtiPaymentDetails>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		long entryId = 0;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());	
			while (rs.next()) {
			  entryId = rs.getLong("id_");
			  CsclRtiPaymentDetails rti = null; 
			  try{ 
				  rti = CsclRtiPaymentDetailsLocalServiceUtil.getCsclRtiPaymentDetails(entryId);
				  rtis.add(rti); 
			  }catch(Exception e){
				  _log.error("No record found for the rti entry "+entryId,e);
			  }
			}
			rs.close();
		}catch(Exception e){
			 _log.error("Error ",e);
		}
		return rtis;
	}
}
