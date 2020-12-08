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

import com.cscl.tender.model.CsclTender;

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
 * The persistence utility for the cscl tender service. This utility wraps <code>com.cscl.tender.service.persistence.impl.CsclTenderPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderPersistence
 * @generated
 */
@ProviderType
public class CsclTenderUtil {

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
	public static void clearCache(CsclTender csclTender) {
		getPersistence().clearCache(csclTender);
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
	public static Map<Serializable, CsclTender> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclTender> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclTender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclTender> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclTender update(CsclTender csclTender) {
		return getPersistence().update(csclTender);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclTender update(
		CsclTender csclTender, ServiceContext serviceContext) {

		return getPersistence().update(csclTender, serviceContext);
	}

	/**
	 * Returns all the cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl tenders
	 */
	public static List<CsclTender> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cscl tenders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @return the range of matching cscl tenders
	 */
	public static List<CsclTender> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl tenders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl tenders
	 */
	@Deprecated
	public static List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl tenders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl tenders
	 */
	public static List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public static CsclTender findByUuid_First(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public static CsclTender fetchByUuid_First(
		String uuid, OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public static CsclTender findByUuid_Last(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public static CsclTender fetchByUuid_Last(
		String uuid, OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cscl tenders before and after the current cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param tenderId the primary key of the current cscl tender
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public static CsclTender[] findByUuid_PrevAndNext(
			long tenderId, String uuid,
			OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findByUuid_PrevAndNext(
			tenderId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cscl tenders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl tenders
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching cscl tenders
	 */
	public static List<CsclTender> findBystatus(int status) {
		return getPersistence().findBystatus(status);
	}

	/**
	 * Returns a range of all the cscl tenders where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @return the range of matching cscl tenders
	 */
	public static List<CsclTender> findBystatus(
		int status, int start, int end) {

		return getPersistence().findBystatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl tenders where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBystatus(int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl tenders
	 */
	@Deprecated
	public static List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBystatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl tenders where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl tenders
	 */
	public static List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().findBystatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public static CsclTender findBystatus_First(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findBystatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public static CsclTender fetchBystatus_First(
		int status, OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().fetchBystatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public static CsclTender findBystatus_Last(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findBystatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public static CsclTender fetchBystatus_Last(
		int status, OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().fetchBystatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the cscl tenders before and after the current cscl tender in the ordered set where status = &#63;.
	 *
	 * @param tenderId the primary key of the current cscl tender
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public static CsclTender[] findBystatus_PrevAndNext(
			long tenderId, int status,
			OrderByComparator<CsclTender> orderByComparator)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findBystatus_PrevAndNext(
			tenderId, status, orderByComparator);
	}

	/**
	 * Removes all the cscl tenders where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeBystatus(int status) {
		getPersistence().removeBystatus(status);
	}

	/**
	 * Returns the number of cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching cscl tenders
	 */
	public static int countBystatus(int status) {
		return getPersistence().countBystatus(status);
	}

	/**
	 * Caches the cscl tender in the entity cache if it is enabled.
	 *
	 * @param csclTender the cscl tender
	 */
	public static void cacheResult(CsclTender csclTender) {
		getPersistence().cacheResult(csclTender);
	}

	/**
	 * Caches the cscl tenders in the entity cache if it is enabled.
	 *
	 * @param csclTenders the cscl tenders
	 */
	public static void cacheResult(List<CsclTender> csclTenders) {
		getPersistence().cacheResult(csclTenders);
	}

	/**
	 * Creates a new cscl tender with the primary key. Does not add the cscl tender to the database.
	 *
	 * @param tenderId the primary key for the new cscl tender
	 * @return the new cscl tender
	 */
	public static CsclTender create(long tenderId) {
		return getPersistence().create(tenderId);
	}

	/**
	 * Removes the cscl tender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender that was removed
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public static CsclTender remove(long tenderId)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().remove(tenderId);
	}

	public static CsclTender updateImpl(CsclTender csclTender) {
		return getPersistence().updateImpl(csclTender);
	}

	/**
	 * Returns the cscl tender with the primary key or throws a <code>NoSuchCsclTenderException</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public static CsclTender findByPrimaryKey(long tenderId)
		throws com.cscl.tender.exception.NoSuchCsclTenderException {

		return getPersistence().findByPrimaryKey(tenderId);
	}

	/**
	 * Returns the cscl tender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender, or <code>null</code> if a cscl tender with the primary key could not be found
	 */
	public static CsclTender fetchByPrimaryKey(long tenderId) {
		return getPersistence().fetchByPrimaryKey(tenderId);
	}

	/**
	 * Returns all the cscl tenders.
	 *
	 * @return the cscl tenders
	 */
	public static List<CsclTender> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl tenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @return the range of cscl tenders
	 */
	public static List<CsclTender> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl tenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl tenders
	 */
	@Deprecated
	public static List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl tenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl tenders
	 */
	public static List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl tenders from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl tenders.
	 *
	 * @return the number of cscl tenders
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclTenderPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CsclTenderPersistence, CsclTenderPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclTenderPersistence.class);

		ServiceTracker<CsclTenderPersistence, CsclTenderPersistence>
			serviceTracker =
				new ServiceTracker
					<CsclTenderPersistence, CsclTenderPersistence>(
						bundle.getBundleContext(), CsclTenderPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}