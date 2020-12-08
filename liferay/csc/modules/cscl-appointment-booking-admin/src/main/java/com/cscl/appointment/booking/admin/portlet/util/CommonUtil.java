package com.cscl.appointment.booking.admin.portlet.util;

import java.util.Locale;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;

public class CommonUtil {

	public static String getTextFromXml(String title, Locale locale) {
		String val="";
		try{
			val = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(locale));
		}catch(Exception e){
			
		}
		return val;
	}
	
	public static String getFormattedText(String reason, Locale locale) {
		String val="";
		try{
			String temp = LocalizationUtil.getLocalization(reason, LocaleUtil.toLanguageId(locale));
			if(temp.length() > 45){
	        	val = temp.substring(0,45) + "...";
	        }else{
	        	val = temp;
	        }
		}catch(Exception e){
			
		}
		return val;
	}
}
