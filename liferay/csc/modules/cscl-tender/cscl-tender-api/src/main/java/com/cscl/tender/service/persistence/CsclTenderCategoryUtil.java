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

package com.cscl.tender.service.persistence;

import com.cscl.tender.model.CsclTenderCategory;

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
 * The persistence utility for the cscl tender category service. This utility wraps <code>com.cscl.tender.service.persistence.impl.CsclTenderCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderCategoryPersistence
 * @generated
 */
@ProviderType
public class CsclTenderCategoryUtil {

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
	public static void clearCache(CsclTenderCategory csclTenderCategory) {
		getPersistence().clearCache(csclTenderCategory);
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
	public static Map<Serializable, CsclTenderCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclTenderCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclTenderCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclTenderCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclTenderCategory update(
		CsclTenderCategory csclTenderCategory) {

		return getPersistence().update(csclTenderCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclTenderCategory update(
		CsclTenderCategory csclTenderCategory, ServiceContext serviceContext) {

		return getPersistence().update(csclTenderCategory, serviceContext);
	}

	/**
	 * Caches the cscl tender category in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategory the cscl tender category
	 */
	public static void cacheResult(CsclTenderCategory csclTenderCategory) {
		getPersistence().cacheResult(csclTenderCategory);
	}

	/**
	 * Caches the cscl tender categories in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategories the cscl tender categories
	 */
	public static void cacheResult(
		List<CsclTenderCategory> csclTenderCategories) {

		getPersistence().cacheResult(csclTenderCategories);
	}

	/**
	 * Creates a new cscl tender category with the primary key. Does not add the cscl tender category to the database.
	 *
	 * @param tenderCatId the primary key for the new cscl tender category
	 * @return the new cscl tender category
	 */
	public static CsclTenderCategory create(long tenderCatId) {
		return getPersistence().create(tenderCatId);
	}

	/**
	 * Removes the cscl tender category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category that was removed
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	public static CsclTenderCategory remove(long tenderCatId)
		throws com.cscl.tender.exception.NoSuchCategoryException {

		return getPersistence().remove(tenderCatId);
	}

	public static CsclTenderCategory updateImpl(
		CsclTenderCategory csclTenderCategory) {

		return getPersistence().updateImpl(csclTenderCategory);
	}

	/**
	 * Returns the cscl tender category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	public static CsclTenderCategory findByPrimaryKey(long tenderCatId)
		throws com.cscl.tender.exception.NoSuchCategoryException {

		return getPersistence().findByPrimaryKey(tenderCatId);
	}

	/**
	 * Returns the cscl tender category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category, or <code>null</code> if a cscl tender category with the primary key could not be found
	 */
	public static CsclTenderCategory fetchByPrimaryKey(long tenderCatId) {
		return getPersistence().fetchByPrimaryKey(tenderCatId);
	}

	/**
	 * Returns all the cscl tender categories.
	 *
	 * @return the cscl tender categories
	 */
	public static List<CsclTenderCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @return the range of cscl tender categories
	 */
	public static List<CsclTenderCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl tender categories
	 */
	@Deprecated
	public static List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl tender categories
	 */
	public static List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl tender categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl tender categories.
	 *
	 * @return the number of cscl tender categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclTenderCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclTenderCategoryPersistence, CsclTenderCategoryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclTenderCategoryPersistence.class);

		ServiceTracker
			<CsclTenderCategoryPersistence, CsclTenderCategoryPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclTenderCategoryPersistence,
						 CsclTenderCategoryPersistence>(
							 bundle.getBundleContext(),
							 CsclTenderCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}