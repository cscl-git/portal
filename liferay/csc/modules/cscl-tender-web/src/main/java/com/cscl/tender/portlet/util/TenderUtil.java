package com.cscl.tender.portlet.util;

import java.util.List;

import com.cscl.tender.model.CsclTender;
import com.cscl.tender.portlet.util.comparator.EntryPublishDateComparator;
import com.cscl.tender.portlet.util.comparator.EntryTitleComparator;
import com.cscl.tender.service.CsclTenderLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

public class TenderUtil {

	public static SearchContainerResults<CsclTender> getSearchContainerResults(
			SearchContainer<?> searchContainer)
		throws PortalException {

		List<CsclTender> tenderList = CsclTenderLocalServiceUtil.getCsclTenders(searchContainer.getStart(), searchContainer.getEnd());

		int total = CsclTenderLocalServiceUtil.getCsclTendersCount();

		return new SearchContainerResults<>(tenderList, total);
	}
	
	public static OrderByComparator<CsclTender> getOrderByComparator(
		String orderByCol, String orderByType) {

		boolean orderByAsc = true;

		if (orderByType.equals("desc")) {
			orderByAsc = false;
		}

		OrderByComparator<CsclTender> orderByComparator = null;

		if (orderByCol.equals("publish-date")) {
			orderByComparator = new EntryPublishDateComparator(orderByAsc);
		}
		else {
			orderByComparator = new EntryTitleComparator(orderByAsc);
		}

		return orderByComparator;
	}
}
