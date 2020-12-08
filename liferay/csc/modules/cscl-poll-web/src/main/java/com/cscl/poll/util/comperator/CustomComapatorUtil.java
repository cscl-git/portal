package com.cscl.poll.util.comperator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

public class CustomComapatorUtil {
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
