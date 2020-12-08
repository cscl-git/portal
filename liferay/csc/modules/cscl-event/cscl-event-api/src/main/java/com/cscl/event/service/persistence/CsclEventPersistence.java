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

import com.cscl.event.exception.NoSuchCsclEventException;
import com.cscl.event.model.CsclEvent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclEventUtil
 * @generated
 */
@ProviderType
public interface CsclEventPersistence extends BasePersistence<CsclEvent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclEventUtil} to access the cscl event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl events
	 */
	public java.util.List<CsclEvent> findByUuid(String uuid);

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
	public java.util.List<CsclEvent> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public CsclEvent findByUuid_First(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public CsclEvent fetchByUuid_First(
		String uuid, OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public CsclEvent findByUuid_Last(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public CsclEvent fetchByUuid_Last(
		String uuid, OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Returns the cscl events before and after the current cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param eventId the primary key of the current cscl event
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public CsclEvent[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Removes all the cscl events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl events
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the matching cscl events
	 */
	public java.util.List<CsclEvent> findByS_SD(int status, Date startDate);

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
	public java.util.List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end);

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
	public java.util.List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator, boolean useFinderCache);

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
	public java.util.List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Returns the first cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public CsclEvent findByS_SD_First(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Returns the first cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public CsclEvent fetchByS_SD_First(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Returns the last cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	public CsclEvent findByS_SD_Last(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Returns the last cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	public CsclEvent fetchByS_SD_Last(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator);

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
	public CsclEvent[] findByS_SD_PrevAndNext(
			long eventId, int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException;

	/**
	 * Removes all the cscl events where status = &#63; and startDate &gt; &#63; from the database.
	 *
	 * @param status the status
	 * @param startDate the start date
	 */
	public void removeByS_SD(int status, Date startDate);

	/**
	 * Returns the number of cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the number of matching cscl events
	 */
	public int countByS_SD(int status, Date startDate);

	/**
	 * Caches the cscl event in the entity cache if it is enabled.
	 *
	 * @param csclEvent the cscl event
	 */
	public void cacheResult(CsclEvent csclEvent);

	/**
	 * Caches the cscl events in the entity cache if it is enabled.
	 *
	 * @param csclEvents the cscl events
	 */
	public void cacheResult(java.util.List<CsclEvent> csclEvents);

	/**
	 * Creates a new cscl event with the primary key. Does not add the cscl event to the database.
	 *
	 * @param eventId the primary key for the new cscl event
	 * @return the new cscl event
	 */
	public CsclEvent create(long eventId);

	/**
	 * Removes the cscl event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event that was removed
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public CsclEvent remove(long eventId) throws NoSuchCsclEventException;

	public CsclEvent updateImpl(CsclEvent csclEvent);

	/**
	 * Returns the cscl event with the primary key or throws a <code>NoSuchCsclEventException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	public CsclEvent findByPrimaryKey(long eventId)
		throws NoSuchCsclEventException;

	/**
	 * Returns the cscl event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event, or <code>null</code> if a cscl event with the primary key could not be found
	 */
	public CsclEvent fetchByPrimaryKey(long eventId);

	/**
	 * Returns all the cscl events.
	 *
	 * @return the cscl events
	 */
	public java.util.List<CsclEvent> findAll();

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
	public java.util.List<CsclEvent> findAll(int start, int end);

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
	public java.util.List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator);

	/**
	 * Removes all the cscl events from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl events.
	 *
	 * @return the number of cscl events
	 */
	public int countAll();

}