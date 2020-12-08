package com.cscl.online.rti.payment.admin.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.cscl.online.rti.payment.admin.portlet.util.comparator.CustomComparator;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;

public class CustomComparatorUtil {
	
	public static OrderByComparator<CsclRtiPaymentDetails> getOrderByComparator(String orderByCol, String orderByType) {
		boolean orderByAsc = false;
		if (Validator.isNull(orderByType)) {
			orderByType = "asc";
		}
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		return new CustomComparator(orderByAsc, orderByCol);
	}
}
