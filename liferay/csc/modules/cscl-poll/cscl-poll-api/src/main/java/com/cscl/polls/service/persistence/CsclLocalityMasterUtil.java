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

import com.cscl.polls.model.CsclLocalityMaster;

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
 * The persistence utility for the cscl locality master service. This utility wraps <code>com.cscl.polls.service.persistence.impl.CsclLocalityMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclLocalityMasterPersistence
 * @generated
 */
@ProviderType
public class CsclLocalityMasterUtil {

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
	public static void clearCache(CsclLocalityMaster csclLocalityMaster) {
		getPersistence().clearCache(csclLocalityMaster);
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
	public static Map<Serializable, CsclLocalityMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclLocalityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclLocalityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclLocalityMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclLocalityMaster update(
		CsclLocalityMaster csclLocalityMaster) {

		return getPersistence().update(csclLocalityMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclLocalityMaster update(
		CsclLocalityMaster csclLocalityMaster, ServiceContext serviceContext) {

		return getPersistence().update(csclLocalityMaster, serviceContext);
	}

	/**
	 * Returns all the cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl locality masters
	 */
	public static List<CsclLocalityMaster> findByisActive(Boolean isActive) {
		return getPersistence().findByisActive(isActive);
	}

	/**
	 * Returns a range of all the cscl locality masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @return the range of matching cscl locality masters
	 */
	public static List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end) {

		return getPersistence().findByisActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl locality masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl locality masters
	 */
	@Deprecated
	public static List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl locality masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl locality masters
	 */
	public static List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	public static CsclLocalityMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclLocalityMasterException {

		return getPersistence().findByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	public static CsclLocalityMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		return getPersistence().fetchByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	public static CsclLocalityMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclLocalityMasterException {

		return getPersistence().findByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	public static CsclLocalityMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		return getPersistence().fetchByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the cscl locality masters before and after the current cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param localityId the primary key of the current cscl locality master
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public static CsclLocalityMaster[] findByisActive_PrevAndNext(
			long localityId, Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchCsclLocalityMasterException {

		return getPersistence().findByisActive_PrevAndNext(
			localityId, isActive, orderByComparator);
	}

	/**
	 * Removes all the cscl locality masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByisActive(Boolean isActive) {
		getPersistence().removeByisActive(isActive);
	}

	/**
	 * Returns the number of cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl locality masters
	 */
	public static int countByisActive(Boolean isActive) {
		return getPersistence().countByisActive(isActive);
	}

	/**
	 * Caches the cscl locality master in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 */
	public static void cacheResult(CsclLocalityMaster csclLocalityMaster) {
		getPersistence().cacheResult(csclLocalityMaster);
	}

	/**
	 * Caches the cscl locality masters in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMasters the cscl locality masters
	 */
	public static void cacheResult(
		List<CsclLocalityMaster> csclLocalityMasters) {

		getPersistence().cacheResult(csclLocalityMasters);
	}

	/**
	 * Creates a new cscl locality master with the primary key. Does not add the cscl locality master to the database.
	 *
	 * @param localityId the primary key for the new cscl locality master
	 * @return the new cscl locality master
	 */
	public static CsclLocalityMaster create(long localityId) {
		return getPersistence().create(localityId);
	}

	/**
	 * Removes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public static CsclLocalityMaster remove(long localityId)
		throws com.cscl.polls.exception.NoSuchCsclLocalityMasterException {

		return getPersistence().remove(localityId);
	}

	public static CsclLocalityMaster updateImpl(
		CsclLocalityMaster csclLocalityMaster) {

		return getPersistence().updateImpl(csclLocalityMaster);
	}

	/**
	 * Returns the cscl locality master with the primary key or throws a <code>NoSuchCsclLocalityMasterException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public static CsclLocalityMaster findByPrimaryKey(long localityId)
		throws com.cscl.polls.exception.NoSuchCsclLocalityMasterException {

		return getPersistence().findByPrimaryKey(localityId);
	}

	/**
	 * Returns the cscl locality master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master, or <code>null</code> if a cscl locality master with the primary key could not be found
	 */
	public static CsclLocalityMaster fetchByPrimaryKey(long localityId) {
		return getPersistence().fetchByPrimaryKey(localityId);
	}

	/**
	 * Returns all the cscl locality masters.
	 *
	 * @return the cscl locality masters
	 */
	public static List<CsclLocalityMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl locality masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @return the range of cscl locality masters
	 */
	public static List<CsclLocalityMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl locality masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl locality masters
	 */
	@Deprecated
	public static List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl locality masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl locality masters
	 */
	public static List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl locality masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl locality masters.
	 *
	 * @return the number of cscl locality masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclLocalityMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclLocalityMasterPersistence, CsclLocalityMasterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclLocalityMasterPersistence.class);

		ServiceTracker
			<CsclLocalityMasterPersistence, CsclLocalityMasterPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclLocalityMasterPersistence,
						 CsclLocalityMasterPersistence>(
							 bundle.getBundleContext(),
							 CsclLocalityMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}