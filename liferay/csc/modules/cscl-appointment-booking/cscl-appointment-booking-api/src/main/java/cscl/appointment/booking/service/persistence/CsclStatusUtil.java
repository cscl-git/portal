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

package cscl.appointment.booking.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.model.CsclStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl status service. This utility wraps <code>cscl.appointment.booking.service.persistence.impl.CsclStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclStatusPersistence
 * @generated
 */
@ProviderType
public class CsclStatusUtil {

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
	public static void clearCache(CsclStatus csclStatus) {
		getPersistence().clearCache(csclStatus);
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
	public static Map<Serializable, CsclStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclStatus update(CsclStatus csclStatus) {
		return getPersistence().update(csclStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclStatus update(
		CsclStatus csclStatus, ServiceContext serviceContext) {

		return getPersistence().update(csclStatus, serviceContext);
	}

	/**
	 * Returns all the cscl statuses where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl statuses
	 */
	public static List<CsclStatus> findByisActive(Boolean isActive) {
		return getPersistence().findByisActive(isActive);
	}

	/**
	 * Returns a range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @return the range of matching cscl statuses
	 */
	public static List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end) {

		return getPersistence().findByisActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl statuses
	 */
	@Deprecated
	public static List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl statuses
	 */
	public static List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclStatus> orderByComparator) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl status
	 * @throws NoSuchCsclStatusException if a matching cscl status could not be found
	 */
	public static CsclStatus findByisActive_First(
			Boolean isActive, OrderByComparator<CsclStatus> orderByComparator)
		throws cscl.appointment.booking.exception.NoSuchCsclStatusException {

		return getPersistence().findByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl status, or <code>null</code> if a matching cscl status could not be found
	 */
	public static CsclStatus fetchByisActive_First(
		Boolean isActive, OrderByComparator<CsclStatus> orderByComparator) {

		return getPersistence().fetchByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl status
	 * @throws NoSuchCsclStatusException if a matching cscl status could not be found
	 */
	public static CsclStatus findByisActive_Last(
			Boolean isActive, OrderByComparator<CsclStatus> orderByComparator)
		throws cscl.appointment.booking.exception.NoSuchCsclStatusException {

		return getPersistence().findByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl status, or <code>null</code> if a matching cscl status could not be found
	 */
	public static CsclStatus fetchByisActive_Last(
		Boolean isActive, OrderByComparator<CsclStatus> orderByComparator) {

		return getPersistence().fetchByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the cscl statuses before and after the current cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl status
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl status
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public static CsclStatus[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclStatus> orderByComparator)
		throws cscl.appointment.booking.exception.NoSuchCsclStatusException {

		return getPersistence().findByisActive_PrevAndNext(
			id_, isActive, orderByComparator);
	}

	/**
	 * Removes all the cscl statuses where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByisActive(Boolean isActive) {
		getPersistence().removeByisActive(isActive);
	}

	/**
	 * Returns the number of cscl statuses where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl statuses
	 */
	public static int countByisActive(Boolean isActive) {
		return getPersistence().countByisActive(isActive);
	}

	/**
	 * Caches the cscl status in the entity cache if it is enabled.
	 *
	 * @param csclStatus the cscl status
	 */
	public static void cacheResult(CsclStatus csclStatus) {
		getPersistence().cacheResult(csclStatus);
	}

	/**
	 * Caches the cscl statuses in the entity cache if it is enabled.
	 *
	 * @param csclStatuses the cscl statuses
	 */
	public static void cacheResult(List<CsclStatus> csclStatuses) {
		getPersistence().cacheResult(csclStatuses);
	}

	/**
	 * Creates a new cscl status with the primary key. Does not add the cscl status to the database.
	 *
	 * @param id_ the primary key for the new cscl status
	 * @return the new cscl status
	 */
	public static CsclStatus create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status that was removed
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public static CsclStatus remove(long id_)
		throws cscl.appointment.booking.exception.NoSuchCsclStatusException {

		return getPersistence().remove(id_);
	}

	public static CsclStatus updateImpl(CsclStatus csclStatus) {
		return getPersistence().updateImpl(csclStatus);
	}

	/**
	 * Returns the cscl status with the primary key or throws a <code>NoSuchCsclStatusException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public static CsclStatus findByPrimaryKey(long id_)
		throws cscl.appointment.booking.exception.NoSuchCsclStatusException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status, or <code>null</code> if a cscl status with the primary key could not be found
	 */
	public static CsclStatus fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl statuses.
	 *
	 * @return the cscl statuses
	 */
	public static List<CsclStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @return the range of cscl statuses
	 */
	public static List<CsclStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl statuses
	 */
	@Deprecated
	public static List<CsclStatus> findAll(
		int start, int end, OrderByComparator<CsclStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl statuses
	 */
	public static List<CsclStatus> findAll(
		int start, int end, OrderByComparator<CsclStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl statuses.
	 *
	 * @return the number of cscl statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclStatusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CsclStatusPersistence, CsclStatusPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclStatusPersistence.class);

		ServiceTracker<CsclStatusPersistence, CsclStatusPersistence>
			serviceTracker =
				new ServiceTracker
					<CsclStatusPersistence, CsclStatusPersistence>(
						bundle.getBundleContext(), CsclStatusPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}