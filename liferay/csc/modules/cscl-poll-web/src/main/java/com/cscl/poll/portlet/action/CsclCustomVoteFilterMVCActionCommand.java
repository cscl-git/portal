package com.cscl.poll.portlet.action;

import com.cscl.poll.constants.PollPortletKeys;
import com.cscl.polls.model.CsclAgeFilter;
import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.service.CsclAgeFilterLocalServiceUtil;
import com.cscl.polls.service.CsclPollsMasterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;



@Component(
		property = {
			"javax.portlet.name=" + PollPortletKeys.POLL,
			"mvc.command.name=/polls/custom_poll_search",
			"javax.portlet.init-param.add-process-action-success-action=false"
		},
		service = MVCActionCommand.class
	)

public class CsclCustomVoteFilterMVCActionCommand extends BaseMVCActionCommand{

	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		//boolean isAllowed = false;
		long questionId = ParamUtil.getLong(actionRequest, "questionId");
		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		String age = ParamUtil.getString(actionRequest, "age");
		String sex = ParamUtil.getString(actionRequest, "sex");
		int locality = ParamUtil.getInteger(actionRequest, "locality");
		
		Date bDate = null;// = new SimpleDateFormat("dd/MM/yyyy").parse(age);
		try {
			bDate = new SimpleDateFormat("dd/MM/yyyy").parse(age);
		}catch(Exception e) {
			
		}
		List<CsclPollsMaster> resultMat = new ArrayList<CsclPollsMaster>();
		String generatedQuery = "";
		String type = "";
		if(questionId != 0) {
			if(!age.equalsIgnoreCase("0")) {// _log.info("age 1");
				List<String> agePattern = agePatternConverter(age);
				if(!sex.equalsIgnoreCase("0")) {  _log.info("age 1 sex 1");
					if(locality != 0) {  //_log.info("age 1 sex 1 locality 1");
						type = "all";
						try {
					 		generatedQuery = generateQuery(agePattern, type, sex,locality, questionId);
					 		resultMat = executeQuery(generatedQuery);
					 	}catch(Exception e) {
					 		_log.error("Error: While generating sql");
					 	}
					}else { 
						//_log.info("age 1 sex 1 locality 0");
						type = "sex";
						try {
					 		generatedQuery = generateQuery(agePattern, type, sex,locality, questionId);
					 		resultMat = executeQuery(generatedQuery);
					 	}catch(Exception e) {
					 		_log.error("Error: While generating sql");
					 	}
					}
					
				}else {  //_log.info("age 1 sex 0");
					if(locality != 0) { // _log.info("age 1 sex 0 locality 1");
						type = "locality";
						try {
					 		generatedQuery = generateQuery(agePattern, type, sex,locality, questionId);
					 		resultMat = executeQuery(generatedQuery);
					 	}catch(Exception e) {
					 		_log.error("Error: While generating sql");
					 	}
					}else {
						//_log.info("age 1 sex 0 locality 0");
					 	//_log.info(" only age");
					 	type = "age";
					 	try {
					 		generatedQuery = generateQuery(agePattern, type, sex,locality, questionId);
					 		resultMat = executeQuery(generatedQuery);
					 	}catch(Exception e) {
					 		_log.error("Error: While generating sql");
					 	}
					}
				}
			}else { //age 0
				if(!sex.equalsIgnoreCase("0")) {  //_log.info("age 0 sex 1 locality 0");// && locality == 0
					if(locality != 0) {// _log.info("age 0 sex 1 locality 1");
						resultMat = CsclPollsMasterLocalServiceUtil.getPollsByLocalityAndSex(questionId, locality, sex);
					}else { // _log.info("age 0 sex 1 locality 0");
						//Only sex
						resultMat = CsclPollsMasterLocalServiceUtil.getPollsBySex(questionId, sex); //Done
					}
				}else {  //_log.info("age 0 sex 0");
					if(locality != 0) { _log.info("age 0 sex 0 locality 1");
						// only locality
						resultMat = CsclPollsMasterLocalServiceUtil.getPollsByLocalities(questionId, locality); //DOne
					}else { // _log.info("age 0 sex 0 locality 0");
						return;
					}
				}
			}
		}else {
			return;
		}
		/*
		 * try { List<CsclPollsMaster> x = ageFilter(age); _log.info(x);
		 * }catch(Exception e) {
		 * _log.error("Error While calling List<CsclPollsMaster> ageFilter"); }
		 */
		  
		actionRequest.setAttribute("res", resultMat);
		actionRequest.setAttribute("entryId", entryId);
		actionRequest.setAttribute("isFilter", true);
		actionResponse.setRenderParameter("mvcPath", "/polls/custom_poll_search.jsp");
	}
	
	//From Date and toDate from Pattern
	public static List<String> agePatternConverter(String pattern){
		List<String> res = new ArrayList<String>();
		String patternTxt = "";
		try {
			CsclAgeFilter ageFilterObj = CsclAgeFilterLocalServiceUtil.getCsclAgeFilter(Long.valueOf(pattern));
			patternTxt = ageFilterObj.getName();
		}catch(Exception e) {
			_log.error("Error: While getting age filter");
		}
		String[] values = patternTxt.split("-");
		String fromDate = null;
		String toDate = null;
		try {
			Calendar now = Calendar.getInstance();
			int x = Integer.parseInt(values[0]);
		    now.add(Calendar.YEAR,-x);
		    Date dt =  now.getTime();
			fromDate= String.valueOf(dt);
		}catch(Exception e) {
			_log.error("Error...While converting date");
		}
		try {
			Calendar now = Calendar.getInstance();
			int x = Integer.parseInt(values[1]);
		    now.add(Calendar.YEAR,-x);
		    Date dt =  now.getTime();
			toDate = String.valueOf(dt);
		}catch(Exception e) {
			_log.error("Error...While converting date");
		}
		res.add(fromDate);
		res.add(toDate);
		return res;
	}
	
	public static String generateQuery(List<String> pattern, String type, String sex, long locality , long questionId){
		boolean flag = false;
		if(Validator.isNotNull(pattern)){
			flag = true;
		}
		StringBuffer sql = new StringBuffer();
		if(flag){
			if(type.equalsIgnoreCase("sex")) {
				sql.append("SELECT * FROM cscl_polls_master WHERE DATE(birthDate) BETWEEN '"+pattern.get(1)+"' AND '"+pattern.get(0)+"' AND sex ='"+sex+"' AND questionId = '"+questionId+"' ");
			}else if(type.equalsIgnoreCase("locality")) {
				sql.append("SELECT * FROM cscl_polls_master WHERE DATE(birthDate) BETWEEN '"+pattern.get(1)+"' AND '"+pattern.get(0)+"' AND locality ='"+locality+"' AND questionId = '"+questionId+"' ");
			}else if(type.equalsIgnoreCase("all")) {
				sql.append("SELECT * FROM cscl_polls_master WHERE DATE(birthDate) BETWEEN '"+pattern.get(1)+"' AND '"+pattern.get(0)+"' AND locality ='"+locality+"' AND sex ='"+sex+"' AND questionId = '"+questionId+"' ");
			}else {
				sql.append("SELECT * FROM cscl_polls_master WHERE DATE(birthDate) BETWEEN '"+pattern.get(1)+"' AND '"+pattern.get(0)+"' AND questionId = '"+questionId+"' ");
			}
		}
		return sql.toString();
	}
	
	public static List<CsclPollsMaster> executeQuery(String sql) {
		List<CsclPollsMaster> polls = new ArrayList<CsclPollsMaster>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		long entryId = 0;
		try {
			conn = DataAccess.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());	
			while (rs.next()) {
			  entryId = rs.getLong("entryId");//GetterUtil.getLong(rs.getLong("entryId"));
			  CsclPollsMaster poll = null; 
			  try{ 
				  poll = CsclPollsMasterLocalServiceUtil.getCsclPollsMaster(entryId);
				  polls.add(poll); 
			  }catch(Exception e){
				  _log.error("Error: While getting Pass w.r.t refId.."+e);
			  }
			}
			rs.close();
		}catch(Exception e){
		     e.printStackTrace();
		}
		return polls;
	}

	public static Log _log = LogFactoryUtil.getLog(CsclCustomVoteFilterMVCActionCommand.class);
}
