package com.cscl.appointment.booking.admin.portlet.util.comparator;

import com.cscl.appointment.booking.admin.portlet.util.comparator.CustomComparator;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

public class CustomComparatorUtil {
	public static OrderByComparator getOrderByComparator(String orderByCol, String orderByType) {
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
