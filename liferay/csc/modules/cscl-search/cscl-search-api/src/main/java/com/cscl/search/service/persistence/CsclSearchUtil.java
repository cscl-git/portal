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

package com.cscl.search.service.persistence;

import com.cscl.search.model.CsclSearch;

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
 * The persistence utility for the cscl search service. This utility wraps <code>com.cscl.search.service.persistence.impl.CsclSearchPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearchPersistence
 * @generated
 */
@ProviderType
public class CsclSearchUtil {

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
	public static void clearCache(CsclSearch csclSearch) {
		getPersistence().clearCache(csclSearch);
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
	public static Map<Serializable, CsclSearch> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclSearch> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclSearch update(CsclSearch csclSearch) {
		return getPersistence().update(csclSearch);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclSearch update(
		CsclSearch csclSearch, ServiceContext serviceContext) {

		return getPersistence().update(csclSearch, serviceContext);
	}

	/**
	 * Returns all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the matching cscl searchs
	 */
	public static List<CsclSearch> findByKeywords(int status, String keywords) {
		return getPersistence().findByKeywords(status, keywords);
	}

	/**
	 * Returns a range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of matching cscl searchs
	 */
	public static List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end) {

		return getPersistence().findByKeywords(status, keywords, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByKeywords(int,String, int, int, OrderByComparator)}
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl searchs
	 */
	@Deprecated
	public static List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByKeywords(
			status, keywords, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl searchs
	 */
	public static List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator) {

		return getPersistence().findByKeywords(
			status, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	public static CsclSearch findByKeywords_First(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws com.cscl.search.exception.NoSuchCsclSearchException {

		return getPersistence().findByKeywords_First(
			status, keywords, orderByComparator);
	}

	/**
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	public static CsclSearch fetchByKeywords_First(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator) {

		return getPersistence().fetchByKeywords_First(
			status, keywords, orderByComparator);
	}

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	public static CsclSearch findByKeywords_Last(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws com.cscl.search.exception.NoSuchCsclSearchException {

		return getPersistence().findByKeywords_Last(
			status, keywords, orderByComparator);
	}

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	public static CsclSearch fetchByKeywords_Last(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator) {

		return getPersistence().fetchByKeywords_Last(
			status, keywords, orderByComparator);
	}

	/**
	 * Returns the cscl searchs before and after the current cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param id the primary key of the current cscl search
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	public static CsclSearch[] findByKeywords_PrevAndNext(
			long id, int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws com.cscl.search.exception.NoSuchCsclSearchException {

		return getPersistence().findByKeywords_PrevAndNext(
			id, status, keywords, orderByComparator);
	}

	/**
	 * Removes all the cscl searchs where status = &#63; and keywords LIKE &#63; from the database.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 */
	public static void removeByKeywords(int status, String keywords) {
		getPersistence().removeByKeywords(status, keywords);
	}

	/**
	 * Returns the number of cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the number of matching cscl searchs
	 */
	public static int countByKeywords(int status, String keywords) {
		return getPersistence().countByKeywords(status, keywords);
	}

	/**
	 * Caches the cscl search in the entity cache if it is enabled.
	 *
	 * @param csclSearch the cscl search
	 */
	public static void cacheResult(CsclSearch csclSearch) {
		getPersistence().cacheResult(csclSearch);
	}

	/**
	 * Caches the cscl searchs in the entity cache if it is enabled.
	 *
	 * @param csclSearchs the cscl searchs
	 */
	public static void cacheResult(List<CsclSearch> csclSearchs) {
		getPersistence().cacheResult(csclSearchs);
	}

	/**
	 * Creates a new cscl search with the primary key. Does not add the cscl search to the database.
	 *
	 * @param id the primary key for the new cscl search
	 * @return the new cscl search
	 */
	public static CsclSearch create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	public static CsclSearch remove(long id)
		throws com.cscl.search.exception.NoSuchCsclSearchException {

		return getPersistence().remove(id);
	}

	public static CsclSearch updateImpl(CsclSearch csclSearch) {
		return getPersistence().updateImpl(csclSearch);
	}

	/**
	 * Returns the cscl search with the primary key or throws a <code>NoSuchCsclSearchException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	public static CsclSearch findByPrimaryKey(long id)
		throws com.cscl.search.exception.NoSuchCsclSearchException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the cscl search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search, or <code>null</code> if a cscl search with the primary key could not be found
	 */
	public static CsclSearch fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the cscl searchs.
	 *
	 * @return the cscl searchs
	 */
	public static List<CsclSearch> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of cscl searchs
	 */
	public static List<CsclSearch> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl searchs
	 */
	@Deprecated
	public static List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl searchs
	 */
	public static List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl searchs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl searchs.
	 *
	 * @return the number of cscl searchs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclSearchPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CsclSearchPersistence, CsclSearchPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclSearchPersistence.class);

		ServiceTracker<CsclSearchPersistence, CsclSearchPersistence>
			serviceTracker =
				new ServiceTracker
					<CsclSearchPersistence, CsclSearchPersistence>(
						bundle.getBundleContext(), CsclSearchPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}