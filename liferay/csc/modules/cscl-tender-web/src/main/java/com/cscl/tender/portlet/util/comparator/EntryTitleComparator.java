package com.cscl.tender.portlet.util.comparator;

import com.cscl.tender.model.CsclTender;
import com.liferay.portal.kernel.util.OrderByComparator;

public class EntryTitleComparator  extends OrderByComparator<CsclTender> {
	public static final String ORDER_BY_ASC = "CsclTender.title ASC";

	public static final String ORDER_BY_DESC = "CsclTender.title DESC";

	public static final String[] ORDER_BY_FIELDS = {"title"};

	public EntryTitleComparator() {
		this(false);
	}

	public EntryTitleComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(CsclTender entry1, CsclTender entry2) {
		String title1 = entry1.getTitle();
		String title2 = entry2.getTitle();

		int value = title1.compareTo(title2);

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
