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

package com.cscl.polls.service.persistence;

import com.cscl.polls.model.CsclAgeFilter;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl age filter service. This utility wraps <code>com.cscl.polls.service.persistence.impl.CsclAgeFilterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclAgeFilterPersistence
 * @generated
 */
@ProviderType
public class CsclAgeFilterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CsclAgeFilter csclAgeFilter) {
		getPersistence().clearCache(csclAgeFilter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CsclAgeFilter> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclAgeFilter> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclAgeFilter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclAgeFilter> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclAgeFilter update(CsclAgeFilter csclAgeFilter) {
		return getPersistence().update(csclAgeFilter);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclAgeFilter update(
		CsclAgeFilter csclAgeFilter, ServiceContext serviceContext) {

		return getPersistence().update(csclAgeFilter, serviceContext);
	}

	/**
	 * Returns all the cscl age filters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl age filters
	 */
	public static List<CsclAgeFilter> findByisActive(Boolean isActive) {
		return getPersistence().findByisActive(isActive);
	}

	/**
	 * Returns a range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @return the range of matching cscl age filters
	 */
	public static List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end) {

		return getPersistence().findByisActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl age filters
	 */
	@Deprecated
	public static List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl age filters
	 */
	public static List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a matching cscl age filter could not be found
	 */
	public static CsclAgeFilter findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclAgeFilterException {

		return getPersistence().findByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl age filter, or <code>null</code> if a matching cscl age filter could not be found
	 */
	public static CsclAgeFilter fetchByisActive_First(
		Boolean isActive, OrderByComparator<CsclAgeFilter> orderByComparator) {

		return getPersistence().fetchByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a matching cscl age filter could not be found
	 */
	public static CsclAgeFilter findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclAgeFilterException {

		return getPersistence().findByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl age filter, or <code>null</code> if a matching cscl age filter could not be found
	 */
	public static CsclAgeFilter fetchByisActive_Last(
		Boolean isActive, OrderByComparator<CsclAgeFilter> orderByComparator) {

		return getPersistence().fetchByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the cscl age filters before and after the current cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl age filter
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public static CsclAgeFilter[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclAgeFilterException {

		return getPersistence().findByisActive_PrevAndNext(
			id_, isActive, orderByComparator);
	}

	/**
	 * Removes all the cscl age filters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByisActive(Boolean isActive) {
		getPersistence().removeByisActive(isActive);
	}

	/**
	 * Returns the number of cscl age filters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl age filters
	 */
	public static int countByisActive(Boolean isActive) {
		return getPersistence().countByisActive(isActive);
	}

	/**
	 * Caches the cscl age filter in the entity cache if it is enabled.
	 *
	 * @param csclAgeFilter the cscl age filter
	 */
	public static void cacheResult(CsclAgeFilter csclAgeFilter) {
		getPersistence().cacheResult(csclAgeFilter);
	}

	/**
	 * Caches the cscl age filters in the entity cache if it is enabled.
	 *
	 * @param csclAgeFilters the cscl age filters
	 */
	public static void cacheResult(List<CsclAgeFilter> csclAgeFilters) {
		getPersistence().cacheResult(csclAgeFilters);
	}

	/**
	 * Creates a new cscl age filter with the primary key. Does not add the cscl age filter to the database.
	 *
	 * @param id_ the primary key for the new cscl age filter
	 * @return the new cscl age filter
	 */
	public static CsclAgeFilter create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl age filter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter that was removed
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public static CsclAgeFilter remove(long id_)
		throws com.cscl.polls.exception.NoSuchCsclAgeFilterException {

		return getPersistence().remove(id_);
	}

	public static CsclAgeFilter updateImpl(CsclAgeFilter csclAgeFilter) {
		return getPersistence().updateImpl(csclAgeFilter);
	}

	/**
	 * Returns the cscl age filter with the primary key or throws a <code>NoSuchCsclAgeFilterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public static CsclAgeFilter findByPrimaryKey(long id_)
		throws com.cscl.polls.exception.NoSuchCsclAgeFilterException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl age filter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter, or <code>null</code> if a cscl age filter with the primary key could not be found
	 */
	public static CsclAgeFilter fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl age filters.
	 *
	 * @return the cscl age filters
	 */
	public static List<CsclAgeFilter> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @return the range of cscl age filters
	 */
	public static List<CsclAgeFilter> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl age filters
	 */
	@Deprecated
	public static List<CsclAgeFilter> findAll(
		int start, int end, OrderByComparator<CsclAgeFilter> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl age filters
	 */
	public static List<CsclAgeFilter> findAll(
		int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl age filters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl age filters.
	 *
	 * @return the number of cscl age filters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclAgeFilterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclAgeFilterPersistence, CsclAgeFilterPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclAgeFilterPersistence.class);

		ServiceTracker<CsclAgeFilterPersistence, CsclAgeFilterPersistence>
			serviceTracker =
				new ServiceTracker
					<CsclAgeFilterPersistence, CsclAgeFilterPersistence>(
						bundle.getBundleContext(),
						CsclAgeFilterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}