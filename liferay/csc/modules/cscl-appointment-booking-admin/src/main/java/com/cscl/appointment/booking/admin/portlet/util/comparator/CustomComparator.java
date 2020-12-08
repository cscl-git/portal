package com.cscl.appointment.booking.admin.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.PropertyUtils;

//import org.apache.commons.beanutils.PropertyUtils;

public class CustomComparator extends OrderByComparator {

	/*
	 * @Override public int compare(Object arg0, Object arg1) { // TODO
	 * Auto-generated method stub return 0; }
	 */

	private static final long serialVersionUID = 1L;

	String sortByCol = "";

	public CustomComparator() {

		this(false, "");
	}

	public CustomComparator(boolean asc, String sortByCol) {
		_asc = asc;
		this.sortByCol = sortByCol;
	}

	public int compare(Object obj1, Object obj2) {
		int value = 0;

		try {
			Object value1 = PropertyUtils.getProperty(obj1, sortByCol);
			Object value2 = PropertyUtils.getProperty(obj2, sortByCol);

			if (value1 instanceof String) {
				value = ((String) value1).toLowerCase().compareTo(((String) value2).toLowerCase());
			} else if (value1 instanceof Integer) {
				value = ((Integer) value1).compareTo((Integer) value2);
			} else if (value1 instanceof Long) {
				value = ((Long) value1).compareTo((Long) value2);
			} else if (value1 instanceof Date) {
				if (null != value1 && null != value2) {
					value = ((Date) value1).compareTo((Date) value2);
				}
			} else if (value1 instanceof Double) {
				value = ((Double) value1).compareTo((Double) value2);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (_asc) {
			return value;
		} else {
			return -value;
		}
	}

	public String getOrderBy() {

		if (_asc) {
			return this.sortByCol + " asc";//ASC";

		} else {

			return this.sortByCol + " desc";//DESC";
		}
	}

	private boolean _asc;

}
