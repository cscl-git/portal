package com.cscl.appointment.booking.admin.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.model.CsclAppointmentMaster;

public class EntryPreferedDateeComparator extends OrderByComparator<CsclAppointmentMaster> {
	public static final String ORDER_BY_ASC = "CsclAppointmentMaster.preferedDate ASC";

	public static final String ORDER_BY_DESC = "CsclAppointmentMaster.preferedDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"preferedDate"};

	public EntryPreferedDateeComparator() {
		this(false);
	}

	public EntryPreferedDateeComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(CsclAppointmentMaster entry1, CsclAppointmentMaster entry2) {
		String preferedDate1 = entry1.getPreferedDate().toString();
		String preferedDate2 = entry2.getPreferedDate().toString();

		int value = preferedDate1.compareTo(preferedDate2);

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;
}

