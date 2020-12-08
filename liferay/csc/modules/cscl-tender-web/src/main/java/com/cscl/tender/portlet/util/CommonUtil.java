package com.cscl.tender.portlet.util;

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
}
