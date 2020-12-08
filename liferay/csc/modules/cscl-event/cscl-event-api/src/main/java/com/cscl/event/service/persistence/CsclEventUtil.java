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

package com.cscl.event.service.persistence;

import com.cscl.event.model.CsclEvent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl event service. This utility wraps <code>com.cscl.event.service.persistence.impl.CsclEventPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclEventPersistence
 * @generated
 */
@ProviderType
public class CsclEventUtil {

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
	public static void clearCache(CsclEvent csclEvent) {
		getPersistence().clearCache(csclEvent);
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
	public static Map<Serializable, CsclEvent> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclEvent> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclEvent update(CsclEvent csclEvent) {
		return getPersistence().update(csclEvent);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclEvent update(
		CsclEvent csclEvent, ServiceContext serviceContext) {

		return getPersistence().update(csclEvent, serviceContext);
	}

	/**
	 * Returns all the cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl events
	 */
	public static List<CsclEvent> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the cscl events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @return the range of matching cscl events
	 */
	public static List<CsclEvent> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl events
	 */
	@Deprecated
	public static List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl events where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl events
	 */
	public static List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public static CsclEvent findByUuid_First(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public static CsclEvent fetchByUuid_First(
		String uuid, OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public static CsclEvent findByUuid_Last(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public static CsclEvent fetchByUuid_Last(
		String uuid, OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the cscl events before and after the current cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param eventId the primary key of the current cscl event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public static CsclEvent[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByUuid_PrevAndNext(
			eventId, uuid, orderByComparator);
	}

	/**
	 * Removes all the cscl events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl events
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the matching cscl events
	 */
	public static List<CsclEvent> findByS_SD(int status, Date startDate) {
		return getPersistence().findByS_SD(status, startDate);
	}

	/**
	 * Returns a range of all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @return the range of matching cscl events
	 */
	public static List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end) {

		return getPersistence().findByS_SD(status, startDate, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByS_SD(int,Date, int, int, OrderByComparator)}
	 * @param status the status
	 * @param startDate the start date
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl events
	 */
	@Deprecated
	public static List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_SD(
			status, startDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl events
	 */
	public static List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().findByS_SD(
			status, startDate, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public static CsclEvent findByS_SD_First(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByS_SD_First(
			status, startDate, orderByComparator);
	}

	/**
	 * Returns the first cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public static CsclEvent fetchByS_SD_First(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().fetchByS_SD_First(
			status, startDate, orderByComparator);
	}

	/**
	 * Returns the last cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public static CsclEvent findByS_SD_Last(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByS_SD_Last(
			status, startDate, orderByComparator);
	}

	/**
	 * Returns the last cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public static CsclEvent fetchByS_SD_Last(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().fetchByS_SD_Last(
			status, startDate, orderByComparator);
	}

	/**
	 * Returns the cscl events before and after the current cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param eventId the primary key of the current cscl event
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public static CsclEvent[] findByS_SD_PrevAndNext(
			long eventId, int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByS_SD_PrevAndNext(
			eventId, status, startDate, orderByComparator);
	}

	/**
	 * Removes all the cscl events where status = &#63; and startDate &gt; &#63; from the database.
	 *
	 * @param status the status
	 * @param startDate the start date
	 */
	public static void removeByS_SD(int status, Date startDate) {
		getPersistence().removeByS_SD(status, startDate);
	}

	/**
	 * Returns the number of cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the number of matching cscl events
	 */
	public static int countByS_SD(int status, Date startDate) {
		return getPersistence().countByS_SD(status, startDate);
	}

	/**
	 * Caches the cscl event in the entity cache if it is enabled.
	 *
	 * @param csclEvent the cscl event
	 */
	public static void cacheResult(CsclEvent csclEvent) {
		getPersistence().cacheResult(csclEvent);
	}

	/**
	 * Caches the cscl events in the entity cache if it is enabled.
	 *
	 * @param csclEvents the cscl events
	 */
	public static void cacheResult(List<CsclEvent> csclEvents) {
		getPersistence().cacheResult(csclEvents);
	}

	/**
	 * Creates a new cscl event with the primary key. Does not add the cscl event to the database.
	 *
	 * @param eventId the primary key for the new cscl event
	 * @return the new cscl event
	 */
	public static CsclEvent create(long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	 * Removes the cscl event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event that was removed
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public static CsclEvent remove(long eventId)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().remove(eventId);
	}

	public static CsclEvent updateImpl(CsclEvent csclEvent) {
		return getPersistence().updateImpl(csclEvent);
	}

	/**
	 * Returns the cscl event with the primary key or throws a <code>NoSuchCsclEventException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public static CsclEvent findByPrimaryKey(long eventId)
		throws com.cscl.event.exception.NoSuchCsclEventException {

		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	 * Returns the cscl event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event, or <code>null</code> if a cscl event with the primary key could not be found
	 */
	public static CsclEvent fetchByPrimaryKey(long eventId) {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	/**
	 * Returns all the cscl events.
	 *
	 * @return the cscl events
	 */
	public static List<CsclEvent> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @return the range of cscl events
	 */
	public static List<CsclEvent> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl events
	 */
	@Deprecated
	public static List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl events
	 */
	public static List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl events from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl events.
	 *
	 * @return the number of cscl events
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclEventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CsclEventPersistence, CsclEventPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclEventPersistence.class);

		ServiceTracker<CsclEventPersistence, CsclEventPersistence>
			serviceTracker =
				new ServiceTracker<CsclEventPersistence, CsclEventPersistence>(
					bundle.getBundleContext(), CsclEventPersistence.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}