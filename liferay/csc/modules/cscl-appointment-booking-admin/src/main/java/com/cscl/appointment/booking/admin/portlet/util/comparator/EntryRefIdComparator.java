package com.cscl.appointment.booking.admin.portlet.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.model.CsclAppointmentMaster;

public class EntryRefIdComparator extends OrderByComparator<CsclAppointmentMaster> {
	public static final String ORDER_BY_ASC = "CsclAppointmentMaster.refId ASC";

	public static final String ORDER_BY_DESC = "CsclAppointmentMaster.refId DESC";

	public static final String[] ORDER_BY_FIELDS = {"refId"};

	public EntryRefIdComparator() {
		this(false);
	}

	public EntryRefIdComparator(boolean ascending) {
		_ascending = ascending;
	}
	
	@Override
	public int compare(CsclAppointmentMaster entry1, CsclAppointmentMaster entry2) {
		String refId1 = entry1.getRefId();
		String refId2 = entry2.getRefId();

		int value = refId1.compareTo(refId2);

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

