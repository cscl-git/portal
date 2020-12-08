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

package com.cscl.event.service.persistence.impl;

import com.cscl.event.exception.NoSuchCsclEventException;
import com.cscl.event.model.CsclEvent;
import com.cscl.event.model.impl.CsclEventImpl;
import com.cscl.event.model.impl.CsclEventModelImpl;
import com.cscl.event.service.persistence.CsclEventPersistence;
import com.cscl.event.service.persistence.impl.constants.EventPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclEventPersistence.class)
@ProviderType
public class CsclEventPersistenceImpl
	extends BasePersistenceImpl<CsclEvent> implements CsclEventPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclEventUtil</code> to access the cscl event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclEventImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl events
	 */
	@Override
	public List<CsclEvent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclEvent> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
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
	@Override
	public List<CsclEvent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CsclEvent> list = (List<CsclEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclEvent csclEvent : list) {
				if (!uuid.equals(csclEvent.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CSCLEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent findByUuid_First(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = fetchByUuid_First(uuid, orderByComparator);

		if (csclEvent != null) {
			return csclEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCsclEventException(msg.toString());
	}

	/**
	 * Returns the first cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent fetchByUuid_First(
		String uuid, OrderByComparator<CsclEvent> orderByComparator) {

		List<CsclEvent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event
	 * @throws NoSuchCsclEventException if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent findByUuid_Last(
			String uuid, OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = fetchByUuid_Last(uuid, orderByComparator);

		if (csclEvent != null) {
			return csclEvent;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCsclEventException(msg.toString());
	}

	/**
	 * Returns the last cscl event in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent fetchByUuid_Last(
		String uuid, OrderByComparator<CsclEvent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CsclEvent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclEvent[] findByUuid_PrevAndNext(
			long eventId, String uuid,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		uuid = Objects.toString(uuid, "");

		CsclEvent csclEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsclEvent[] array = new CsclEventImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, csclEvent, uuid, orderByComparator, true);

			array[1] = csclEvent;

			array[2] = getByUuid_PrevAndNext(
				session, csclEvent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclEvent getByUuid_PrevAndNext(
		Session session, CsclEvent csclEvent, String uuid,
		OrderByComparator<CsclEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSCLEVENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CsclEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(csclEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl events where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CsclEvent csclEvent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclEvent);
		}
	}

	/**
	 * Returns the number of cscl events where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl events
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLEVENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"csclEvent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(csclEvent.uuid IS NULL OR csclEvent.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByS_SD;
	private FinderPath _finderPathWithPaginationCountByS_SD;

	/**
	 * Returns all the cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the matching cscl events
	 */
	@Override
	public List<CsclEvent> findByS_SD(int status, Date startDate) {
		return findByS_SD(
			status, startDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end) {

		return findByS_SD(status, startDate, start, end, null);
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
	@Override
	public List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return findByS_SD(status, startDate, start, end, orderByComparator);
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
	@Override
	public List<CsclEvent> findByS_SD(
		int status, Date startDate, int start, int end,
		OrderByComparator<CsclEvent> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByS_SD;
		finderArgs = new Object[] {
			status, _getTime(startDate), start, end, orderByComparator
		};

		List<CsclEvent> list = (List<CsclEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclEvent csclEvent : list) {
				if ((status != csclEvent.getStatus()) ||
					(startDate.getTime() >=
						csclEvent.getStartDate().getTime())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CSCLEVENT_WHERE);

			query.append(_FINDER_COLUMN_S_SD_STATUS_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_S_SD_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_S_SD_STARTDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclEventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				if (!pagination) {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public CsclEvent findByS_SD_First(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = fetchByS_SD_First(
			status, startDate, orderByComparator);

		if (csclEvent != null) {
			return csclEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append("}");

		throw new NoSuchCsclEventException(msg.toString());
	}

	/**
	 * Returns the first cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent fetchByS_SD_First(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator) {

		List<CsclEvent> list = findByS_SD(
			status, startDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclEvent findByS_SD_Last(
			int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = fetchByS_SD_Last(
			status, startDate, orderByComparator);

		if (csclEvent != null) {
			return csclEvent;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", startDate=");
		msg.append(startDate);

		msg.append("}");

		throw new NoSuchCsclEventException(msg.toString());
	}

	/**
	 * Returns the last cscl event in the ordered set where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl event, or <code>null</code> if a matching cscl event could not be found
	 */
	@Override
	public CsclEvent fetchByS_SD_Last(
		int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator) {

		int count = countByS_SD(status, startDate);

		if (count == 0) {
			return null;
		}

		List<CsclEvent> list = findByS_SD(
			status, startDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclEvent[] findByS_SD_PrevAndNext(
			long eventId, int status, Date startDate,
			OrderByComparator<CsclEvent> orderByComparator)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			CsclEvent[] array = new CsclEventImpl[3];

			array[0] = getByS_SD_PrevAndNext(
				session, csclEvent, status, startDate, orderByComparator, true);

			array[1] = csclEvent;

			array[2] = getByS_SD_PrevAndNext(
				session, csclEvent, status, startDate, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclEvent getByS_SD_PrevAndNext(
		Session session, CsclEvent csclEvent, int status, Date startDate,
		OrderByComparator<CsclEvent> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CSCLEVENT_WHERE);

		query.append(_FINDER_COLUMN_S_SD_STATUS_2);

		boolean bindStartDate = false;

		if (startDate == null) {
			query.append(_FINDER_COLUMN_S_SD_STARTDATE_1);
		}
		else {
			bindStartDate = true;

			query.append(_FINDER_COLUMN_S_SD_STARTDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CsclEventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (bindStartDate) {
			qPos.add(new Timestamp(startDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(csclEvent)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclEvent> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl events where status = &#63; and startDate &gt; &#63; from the database.
	 *
	 * @param status the status
	 * @param startDate the start date
	 */
	@Override
	public void removeByS_SD(int status, Date startDate) {
		for (CsclEvent csclEvent :
				findByS_SD(
					status, startDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclEvent);
		}
	}

	/**
	 * Returns the number of cscl events where status = &#63; and startDate &gt; &#63;.
	 *
	 * @param status the status
	 * @param startDate the start date
	 * @return the number of matching cscl events
	 */
	@Override
	public int countByS_SD(int status, Date startDate) {
		FinderPath finderPath = _finderPathWithPaginationCountByS_SD;

		Object[] finderArgs = new Object[] {status, _getTime(startDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLEVENT_WHERE);

			query.append(_FINDER_COLUMN_S_SD_STATUS_2);

			boolean bindStartDate = false;

			if (startDate == null) {
				query.append(_FINDER_COLUMN_S_SD_STARTDATE_1);
			}
			else {
				bindStartDate = true;

				query.append(_FINDER_COLUMN_S_SD_STARTDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindStartDate) {
					qPos.add(new Timestamp(startDate.getTime()));
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_S_SD_STATUS_2 =
		"csclEvent.status = ? AND ";

	private static final String _FINDER_COLUMN_S_SD_STARTDATE_1 =
		"csclEvent.startDate IS NULL";

	private static final String _FINDER_COLUMN_S_SD_STARTDATE_2 =
		"csclEvent.startDate > ?";

	public CsclEventPersistenceImpl() {
		setModelClass(CsclEvent.class);

		setModelImplClass(CsclEventImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl event in the entity cache if it is enabled.
	 *
	 * @param csclEvent the cscl event
	 */
	@Override
	public void cacheResult(CsclEvent csclEvent) {
		entityCache.putResult(
			entityCacheEnabled, CsclEventImpl.class, csclEvent.getPrimaryKey(),
			csclEvent);

		csclEvent.resetOriginalValues();
	}

	/**
	 * Caches the cscl events in the entity cache if it is enabled.
	 *
	 * @param csclEvents the cscl events
	 */
	@Override
	public void cacheResult(List<CsclEvent> csclEvents) {
		for (CsclEvent csclEvent : csclEvents) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclEventImpl.class,
					csclEvent.getPrimaryKey()) == null) {

				cacheResult(csclEvent);
			}
			else {
				csclEvent.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl events.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclEventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl event.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclEvent csclEvent) {
		entityCache.removeResult(
			entityCacheEnabled, CsclEventImpl.class, csclEvent.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclEvent> csclEvents) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclEvent csclEvent : csclEvents) {
			entityCache.removeResult(
				entityCacheEnabled, CsclEventImpl.class,
				csclEvent.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl event with the primary key. Does not add the cscl event to the database.
	 *
	 * @param eventId the primary key for the new cscl event
	 * @return the new cscl event
	 */
	@Override
	public CsclEvent create(long eventId) {
		CsclEvent csclEvent = new CsclEventImpl();

		csclEvent.setNew(true);
		csclEvent.setPrimaryKey(eventId);

		String uuid = PortalUUIDUtil.generate();

		csclEvent.setUuid(uuid);

		return csclEvent;
	}

	/**
	 * Removes the cscl event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event that was removed
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	@Override
	public CsclEvent remove(long eventId) throws NoSuchCsclEventException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the cscl event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl event
	 * @return the cscl event that was removed
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	@Override
	public CsclEvent remove(Serializable primaryKey)
		throws NoSuchCsclEventException {

		Session session = null;

		try {
			session = openSession();

			CsclEvent csclEvent = (CsclEvent)session.get(
				CsclEventImpl.class, primaryKey);

			if (csclEvent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclEventException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclEvent);
		}
		catch (NoSuchCsclEventException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CsclEvent removeImpl(CsclEvent csclEvent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclEvent)) {
				csclEvent = (CsclEvent)session.get(
					CsclEventImpl.class, csclEvent.getPrimaryKeyObj());
			}

			if (csclEvent != null) {
				session.delete(csclEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclEvent != null) {
			clearCache(csclEvent);
		}

		return csclEvent;
	}

	@Override
	public CsclEvent updateImpl(CsclEvent csclEvent) {
		boolean isNew = csclEvent.isNew();

		if (!(csclEvent instanceof CsclEventModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclEvent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(csclEvent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclEvent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclEvent implementation " +
					csclEvent.getClass());
		}

		CsclEventModelImpl csclEventModelImpl = (CsclEventModelImpl)csclEvent;

		if (Validator.isNull(csclEvent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			csclEvent.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (csclEvent.getCreateDate() == null)) {
			if (serviceContext == null) {
				csclEvent.setCreateDate(now);
			}
			else {
				csclEvent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!csclEventModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				csclEvent.setModifiedDate(now);
			}
			else {
				csclEvent.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (csclEvent.isNew()) {
				session.save(csclEvent);

				csclEvent.setNew(false);
			}
			else {
				csclEvent = (CsclEvent)session.merge(csclEvent);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {csclEventModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclEventModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclEventModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {csclEventModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclEventImpl.class, csclEvent.getPrimaryKey(),
			csclEvent, false);

		csclEvent.resetOriginalValues();

		return csclEvent;
	}

	/**
	 * Returns the cscl event with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl event
	 * @return the cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	@Override
	public CsclEvent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclEventException {

		CsclEvent csclEvent = fetchByPrimaryKey(primaryKey);

		if (csclEvent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclEventException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclEvent;
	}

	/**
	 * Returns the cscl event with the primary key or throws a <code>NoSuchCsclEventException</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event
	 * @throws NoSuchCsclEventException if a cscl event with the primary key could not be found
	 */
	@Override
	public CsclEvent findByPrimaryKey(long eventId)
		throws NoSuchCsclEventException {

		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the cscl event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event, or <code>null</code> if a cscl event with the primary key could not be found
	 */
	@Override
	public CsclEvent fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns all the cscl events.
	 *
	 * @return the cscl events
	 */
	@Override
	public List<CsclEvent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclEvent> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<CsclEvent> findAll(
		int start, int end, OrderByComparator<CsclEvent> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CsclEvent> list = (List<CsclEvent>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLEVENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLEVENT;

				if (pagination) {
					sql = sql.concat(CsclEventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclEvent>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cscl events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclEvent csclEvent : findAll()) {
			remove(csclEvent);
		}
	}

	/**
	 * Returns the number of cscl events.
	 *
	 * @return the number of cscl events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLEVENT);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "eventId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLEVENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclEventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl event persistence.
	 */
	@Activate
	public void activate() {
		CsclEventModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclEventModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CsclEventModelImpl.UUID_COLUMN_BITMASK |
			CsclEventModelImpl.STARTDATE_COLUMN_BITMASK |
			CsclEventModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByS_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclEventImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_SD",
			new String[] {
				Integer.class.getName(), Date.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByS_SD = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByS_SD",
			new String[] {Integer.class.getName(), Date.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclEventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = EventPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.event.model.CsclEvent"),
			true);
	}

	@Override
	@Reference(
		target = EventPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = EventPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CSCLEVENT =
		"SELECT csclEvent FROM CsclEvent csclEvent";

	private static final String _SQL_SELECT_CSCLEVENT_WHERE =
		"SELECT csclEvent FROM CsclEvent csclEvent WHERE ";

	private static final String _SQL_COUNT_CSCLEVENT =
		"SELECT COUNT(csclEvent) FROM CsclEvent csclEvent";

	private static final String _SQL_COUNT_CSCLEVENT_WHERE =
		"SELECT COUNT(csclEvent) FROM CsclEvent csclEvent WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclEvent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclEvent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclEvent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclEventPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(EventPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}