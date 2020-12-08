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

import cscl.appointment.booking.model.CsclApproverMaster;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl approver master service. This utility wraps <code>cscl.appointment.booking.service.persistence.impl.CsclApproverMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMasterPersistence
 * @generated
 */
@ProviderType
public class CsclApproverMasterUtil {

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
	public static void clearCache(CsclApproverMaster csclApproverMaster) {
		getPersistence().clearCache(csclApproverMaster);
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
	public static Map<Serializable, CsclApproverMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclApproverMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclApproverMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclApproverMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclApproverMaster update(
		CsclApproverMaster csclApproverMaster) {

		return getPersistence().update(csclApproverMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclApproverMaster update(
		CsclApproverMaster csclApproverMaster, ServiceContext serviceContext) {

		return getPersistence().update(csclApproverMaster, serviceContext);
	}

	/**
	 * Returns all the cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl approver masters
	 */
	public static List<CsclApproverMaster> findByisActive(Boolean isActive) {
		return getPersistence().findByisActive(isActive);
	}

	/**
	 * Returns a range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @return the range of matching cscl approver masters
	 */
	public static List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end) {

		return getPersistence().findByisActive(isActive, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver masters
	 */
	@Deprecated
	public static List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver masters
	 */
	public static List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		return getPersistence().findByisActive(
			isActive, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	public static CsclApproverMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMasterException {

		return getPersistence().findByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	public static CsclApproverMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		return getPersistence().fetchByisActive_First(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	public static CsclApproverMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMasterException {

		return getPersistence().findByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	public static CsclApproverMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		return getPersistence().fetchByisActive_Last(
			isActive, orderByComparator);
	}

	/**
	 * Returns the cscl approver masters before and after the current cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver master
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public static CsclApproverMaster[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMasterException {

		return getPersistence().findByisActive_PrevAndNext(
			id_, isActive, orderByComparator);
	}

	/**
	 * Removes all the cscl approver masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public static void removeByisActive(Boolean isActive) {
		getPersistence().removeByisActive(isActive);
	}

	/**
	 * Returns the number of cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl approver masters
	 */
	public static int countByisActive(Boolean isActive) {
		return getPersistence().countByisActive(isActive);
	}

	/**
	 * Caches the cscl approver master in the entity cache if it is enabled.
	 *
	 * @param csclApproverMaster the cscl approver master
	 */
	public static void cacheResult(CsclApproverMaster csclApproverMaster) {
		getPersistence().cacheResult(csclApproverMaster);
	}

	/**
	 * Caches the cscl approver masters in the entity cache if it is enabled.
	 *
	 * @param csclApproverMasters the cscl approver masters
	 */
	public static void cacheResult(
		List<CsclApproverMaster> csclApproverMasters) {

		getPersistence().cacheResult(csclApproverMasters);
	}

	/**
	 * Creates a new cscl approver master with the primary key. Does not add the cscl approver master to the database.
	 *
	 * @param id_ the primary key for the new cscl approver master
	 * @return the new cscl approver master
	 */
	public static CsclApproverMaster create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public static CsclApproverMaster remove(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMasterException {

		return getPersistence().remove(id_);
	}

	public static CsclApproverMaster updateImpl(
		CsclApproverMaster csclApproverMaster) {

		return getPersistence().updateImpl(csclApproverMaster);
	}

	/**
	 * Returns the cscl approver master with the primary key or throws a <code>NoSuchCsclApproverMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public static CsclApproverMaster findByPrimaryKey(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMasterException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl approver master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master, or <code>null</code> if a cscl approver master with the primary key could not be found
	 */
	public static CsclApproverMaster fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl approver masters.
	 *
	 * @return the cscl approver masters
	 */
	public static List<CsclApproverMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @return the range of cscl approver masters
	 */
	public static List<CsclApproverMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl approver masters
	 */
	@Deprecated
	public static List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl approver masters
	 */
	public static List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl approver masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl approver masters.
	 *
	 * @return the number of cscl approver masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclApproverMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclApproverMasterPersistence, CsclApproverMasterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclApproverMasterPersistence.class);

		ServiceTracker
			<CsclApproverMasterPersistence, CsclApproverMasterPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclApproverMasterPersistence,
						 CsclApproverMasterPersistence>(
							 bundle.getBundleContext(),
							 CsclApproverMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}