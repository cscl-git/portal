package com.cscl.tender.portlet.display.context;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;

import com.cscl.tender.model.CsclTender;
import com.cscl.tender.portlet.util.TenderUtil;
import com.cscl.tender.service.CsclTenderLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.dao.search.SearchContainerResults;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.TrashHelper;

public class TenderEntriesDisplayContext {

	public TenderEntriesDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		TrashHelper trashHelper) {

		_liferayPortletRequest = liferayPortletRequest;
		_liferayPortletResponse = liferayPortletResponse;
		_trashHelper = trashHelper;

		_portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
			liferayPortletRequest);

		_httpServletRequest = _liferayPortletRequest.getHttpServletRequest();
	}
	
	public SearchContainer getSearchContainer()
		throws PortalException, PortletException {

		PortletURL portletURL = _liferayPortletResponse.createRenderURL();

		portletURL.setParameter("mvcRenderCommandName", "/tender/view");

		SearchContainer<CsclTender> entriesSearchContainer =
			new SearchContainer<>(
				_liferayPortletRequest,
				PortletURLUtil.clone(portletURL, _liferayPortletResponse), null,
				"no-entries-were-found");

		String orderByCol = ParamUtil.getString(
			_httpServletRequest, "orderByCol", "title");

		entriesSearchContainer.setOrderByCol(orderByCol);

		String orderByType = ParamUtil.getString(
			_httpServletRequest, "orderByType", "asc");

		entriesSearchContainer.setOrderByType(orderByType);

		entriesSearchContainer.setOrderByComparator(
			TenderUtil.getOrderByComparator(
				entriesSearchContainer.getOrderByCol(),
				entriesSearchContainer.getOrderByType()));

		entriesSearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(_liferayPortletResponse));

		_populateResults(entriesSearchContainer);

		return entriesSearchContainer;
	}
	
	private void _populateResults(SearchContainer searchContainer)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);


		//long tenderId = ParamUtil.getLong(_httpServletRequest, "tenderId");
		
		SearchContainerResults<CsclTender> searchContainerResults = TenderUtil.getSearchContainerResults(searchContainer);
		searchContainer.setTotal(searchContainerResults.getTotal());
		searchContainer.setResults(searchContainerResults.getResults());
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			TenderEntriesDisplayContext.class);

	private final HttpServletRequest _httpServletRequest;
	private final LiferayPortletRequest _liferayPortletRequest;
	private final LiferayPortletResponse _liferayPortletResponse;
	private final PortalPreferences _portalPreferences;
	private final TrashHelper _trashHelper;
}
