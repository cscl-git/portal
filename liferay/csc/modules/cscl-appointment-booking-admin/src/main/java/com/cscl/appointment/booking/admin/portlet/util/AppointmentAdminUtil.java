package com.cscl.appointment.booking.admin.portlet.util;

import java.util.List;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.service.CsclAppointmentMasterLocalServiceUtil;

import com.cscl.appointment.booking.admin.portlet.util.comparator.EntryPreferedDateeComparator;
import com.cscl.appointment.booking.admin.portlet.util.comparator.EntryRefIdComparator;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

public class AppointmentAdminUtil {

		public static SearchContainerResults<CsclAppointmentMaster> getSearchContainerResults(
				SearchContainer<?> searchContainer)
			throws PortalException {

			List<CsclAppointmentMaster> appointmentList = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMasters(searchContainer.getStart(), searchContainer.getEnd());

			int total = CsclAppointmentMasterLocalServiceUtil.getCsclAppointmentMastersCount();

			return new SearchContainerResults<>(appointmentList, total);
		}
		
		public static OrderByComparator<CsclAppointmentMaster> getOrderByComparator(
			String orderByCol, String orderByType) {

			boolean orderByAsc = true;

			if (orderByType.equals("desc")) {
				orderByAsc = false;
			}

			OrderByComparator<CsclAppointmentMaster> orderByComparator = null;
			System.out.println("Order By.."+orderByCol);
			if (orderByCol.equalsIgnoreCase("preferedDate")) {
				orderByComparator = new EntryPreferedDateeComparator(orderByAsc);
			}else {
				orderByComparator = new EntryRefIdComparator(orderByAsc);
			}

			return orderByComparator;
		}
	}

