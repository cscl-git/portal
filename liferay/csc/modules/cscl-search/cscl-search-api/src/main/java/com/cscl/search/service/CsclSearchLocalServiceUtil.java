/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cscl.search.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CsclSearch. This utility wraps
 * <code>com.cscl.search.service.impl.CsclSearchLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearchLocalService
 * @generated
 */
@ProviderType
public class CsclSearchLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.cscl.search.service.impl.CsclSearchLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl search to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was added
	 */
	public static com.cscl.search.model.CsclSearch addCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return getService().addCsclSearch(csclSearch);
	}

	/**
	 * Creates a new cscl search with the primary key. Does not add the cscl search to the database.
	 *
	 * @param id the primary key for the new cscl search
	 * @return the new cscl search
	 */
	public static com.cscl.search.model.CsclSearch createCsclSearch(long id) {
		return getService().createCsclSearch(id);
	}

	/**
	 * Deletes the cscl search from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was removed
	 */
	public static com.cscl.search.model.CsclSearch deleteCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return getService().deleteCsclSearch(csclSearch);
	}

	/**
	 * Deletes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws PortalException if a cscl search with the primary key could not be found
	 */
	public static com.cscl.search.model.CsclSearch deleteCsclSearch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclSearch(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.cscl.search.model.CsclSearch fetchCsclSearch(long id) {
		return getService().fetchCsclSearch(id);
	}

	public static java.util.List<com.cscl.search.model.CsclSearch>
		fetchSearchResultByKeyword(int status, String keywords) {

		return getService().fetchSearchResultByKeyword(status, keywords);
	}

	public static java.util.List<com.cscl.search.model.CsclSearch>
		findByKeyword(int status, String keywords) {

		return getService().findByKeyword(status, keywords);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl search with the primary key.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search
	 * @throws PortalException if a cscl search with the primary key could not be found
	 */
	public static com.cscl.search.model.CsclSearch getCsclSearch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclSearch(id);
	}

	/**
	 * Returns a range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of cscl searchs
	 */
	public static java.util.List<com.cscl.search.model.CsclSearch>
		getCsclSearchs(int start, int end) {

		return getService().getCsclSearchs(start, end);
	}

	/**
	 * Returns the number of cscl searchs.
	 *
	 * @return the number of cscl searchs
	 */
	public static int getCsclSearchsCount() {
		return getService().getCsclSearchsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was updated
	 */
	public static com.cscl.search.model.CsclSearch updateCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return getService().updateCsclSearch(csclSearch);
	}

	public static CsclSearchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclSearchLocalService, CsclSearchLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclSearchLocalService.class);

		ServiceTracker<CsclSearchLocalService, CsclSearchLocalService>
			serviceTracker =
				new ServiceTracker
					<CsclSearchLocalService, CsclSearchLocalService>(
						bundle.getBundleContext(), CsclSearchLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}