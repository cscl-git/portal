package com.cscl.tender.portlet.util.comparator;

import com.cscl.tender.model.CsclTender;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

public class EntryPublishDateComparator  extends OrderByComparator<CsclTender> {
	public static final String ORDER_BY_ASC =
		"CsclTender.publishDate ASC, CsclTender.tenderId ASC";

	public static final String[] ORDER_BY_CONDITION_FIELDS = {"publishDate"};

	public static final String ORDER_BY_DESC =
		"CsclTender.publishDate DESC, CsclTender.tenderId DESC";

	public static final String[] ORDER_BY_FIELDS = {"publishDate", "tenderId"};

	public EntryPublishDateComparator() {
		this(false);
	}

	public EntryPublishDateComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(CsclTender entry1, CsclTender entry2) {
		int value = DateUtil.compareTo(
			entry1.getPublishDate(), entry2.getPublishDate());

		if (value == 0) {
			if (entry1.getTenderId() < entry2.getTenderId()) {
				value = -1;
			}
			else if (entry1.getTenderId() > entry2.getTenderId()) {
				value = 1;
			}
		}

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
	public String[] getOrderByConditionFields() {
		return ORDER_BY_CONDITION_FIELDS;
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
