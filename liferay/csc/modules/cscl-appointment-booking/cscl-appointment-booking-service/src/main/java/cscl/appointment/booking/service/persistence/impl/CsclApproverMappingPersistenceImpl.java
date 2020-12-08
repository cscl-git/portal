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

package cscl.appointment.booking.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import cscl.appointment.booking.exception.NoSuchCsclApproverMappingException;
import cscl.appointment.booking.model.CsclApproverMapping;
import cscl.appointment.booking.model.impl.CsclApproverMappingImpl;
import cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl;
import cscl.appointment.booking.service.persistence.CsclApproverMappingPersistence;
import cscl.appointment.booking.service.persistence.impl.constants.CsclAppointmentBookingPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl approver mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclApproverMappingPersistence.class)
@ProviderType
public class CsclApproverMappingPersistenceImpl
	extends BasePersistenceImpl<CsclApproverMapping>
	implements CsclApproverMappingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclApproverMappingUtil</code> to access the cscl approver mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclApproverMappingImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByassignedTo;
	private FinderPath _finderPathWithoutPaginationFindByassignedTo;
	private FinderPath _finderPathCountByassignedTo;

	/**
	 * Returns all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByassignedTo(long assignedTo) {
		return findByassignedTo(
			assignedTo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end) {

		return findByassignedTo(assignedTo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByassignedTo(long, int, int, OrderByComparator)}
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Deprecated
	@Override
	public List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return findByassignedTo(assignedTo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByassignedTo;
			finderArgs = new Object[] {assignedTo};
		}
		else {
			finderPath = _finderPathWithPaginationFindByassignedTo;
			finderArgs = new Object[] {
				assignedTo, start, end, orderByComparator
			};
		}

		List<CsclApproverMapping> list =
			(List<CsclApproverMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclApproverMapping csclApproverMapping : list) {
				if ((assignedTo != csclApproverMapping.getAssignedTo())) {
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

			query.append(_SQL_SELECT_CSCLAPPROVERMAPPING_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNEDTO_ASSIGNEDTO_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclApproverMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assignedTo);

				if (!pagination) {
					list = (List<CsclApproverMapping>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclApproverMapping>)QueryUtil.list(
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
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping findByassignedTo_First(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = fetchByassignedTo_First(
			assignedTo, orderByComparator);

		if (csclApproverMapping != null) {
			return csclApproverMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignedTo=");
		msg.append(assignedTo);

		msg.append("}");

		throw new NoSuchCsclApproverMappingException(msg.toString());
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping fetchByassignedTo_First(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		List<CsclApproverMapping> list = findByassignedTo(
			assignedTo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping findByassignedTo_Last(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = fetchByassignedTo_Last(
			assignedTo, orderByComparator);

		if (csclApproverMapping != null) {
			return csclApproverMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("assignedTo=");
		msg.append(assignedTo);

		msg.append("}");

		throw new NoSuchCsclApproverMappingException(msg.toString());
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping fetchByassignedTo_Last(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		int count = countByassignedTo(assignedTo);

		if (count == 0) {
			return null;
		}

		List<CsclApproverMapping> list = findByassignedTo(
			assignedTo, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping[] findByassignedTo_PrevAndNext(
			long id_, long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclApproverMapping[] array = new CsclApproverMappingImpl[3];

			array[0] = getByassignedTo_PrevAndNext(
				session, csclApproverMapping, assignedTo, orderByComparator,
				true);

			array[1] = csclApproverMapping;

			array[2] = getByassignedTo_PrevAndNext(
				session, csclApproverMapping, assignedTo, orderByComparator,
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

	protected CsclApproverMapping getByassignedTo_PrevAndNext(
		Session session, CsclApproverMapping csclApproverMapping,
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSCLAPPROVERMAPPING_WHERE);

		query.append(_FINDER_COLUMN_ASSIGNEDTO_ASSIGNEDTO_2);

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
			query.append(CsclApproverMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(assignedTo);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclApproverMapping)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclApproverMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl approver mappings where assignedTo = &#63; from the database.
	 *
	 * @param assignedTo the assigned to
	 */
	@Override
	public void removeByassignedTo(long assignedTo) {
		for (CsclApproverMapping csclApproverMapping :
				findByassignedTo(
					assignedTo, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclApproverMapping);
		}
	}

	/**
	 * Returns the number of cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the number of matching cscl approver mappings
	 */
	@Override
	public int countByassignedTo(long assignedTo) {
		FinderPath finderPath = _finderPathCountByassignedTo;

		Object[] finderArgs = new Object[] {assignedTo};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLAPPROVERMAPPING_WHERE);

			query.append(_FINDER_COLUMN_ASSIGNEDTO_ASSIGNEDTO_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(assignedTo);

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

	private static final String _FINDER_COLUMN_ASSIGNEDTO_ASSIGNEDTO_2 =
		"csclApproverMapping.assignedTo = ?";

	private FinderPath _finderPathWithPaginationFindByappointeeId;
	private FinderPath _finderPathWithoutPaginationFindByappointeeId;
	private FinderPath _finderPathCountByappointeeId;

	/**
	 * Returns all the cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByappointeeId(int appointee) {
		return findByappointeeId(
			appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end) {

		return findByappointeeId(appointee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointeeId(int, int, int, OrderByComparator)}
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Deprecated
	@Override
	public List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return findByappointeeId(appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByappointeeId;
			finderArgs = new Object[] {appointee};
		}
		else {
			finderPath = _finderPathWithPaginationFindByappointeeId;
			finderArgs = new Object[] {
				appointee, start, end, orderByComparator
			};
		}

		List<CsclApproverMapping> list =
			(List<CsclApproverMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclApproverMapping csclApproverMapping : list) {
				if ((appointee != csclApproverMapping.getAppointee())) {
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

			query.append(_SQL_SELECT_CSCLAPPROVERMAPPING_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclApproverMappingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appointee);

				if (!pagination) {
					list = (List<CsclApproverMapping>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclApproverMapping>)QueryUtil.list(
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
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping findByappointeeId_First(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = fetchByappointeeId_First(
			appointee, orderByComparator);

		if (csclApproverMapping != null) {
			return csclApproverMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclApproverMappingException(msg.toString());
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping fetchByappointeeId_First(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		List<CsclApproverMapping> list = findByappointeeId(
			appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping findByappointeeId_Last(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = fetchByappointeeId_Last(
			appointee, orderByComparator);

		if (csclApproverMapping != null) {
			return csclApproverMapping;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclApproverMappingException(msg.toString());
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	@Override
	public CsclApproverMapping fetchByappointeeId_Last(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		int count = countByappointeeId(appointee);

		if (count == 0) {
			return null;
		}

		List<CsclApproverMapping> list = findByappointeeId(
			appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping[] findByappointeeId_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclApproverMapping[] array = new CsclApproverMappingImpl[3];

			array[0] = getByappointeeId_PrevAndNext(
				session, csclApproverMapping, appointee, orderByComparator,
				true);

			array[1] = csclApproverMapping;

			array[2] = getByappointeeId_PrevAndNext(
				session, csclApproverMapping, appointee, orderByComparator,
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

	protected CsclApproverMapping getByappointeeId_PrevAndNext(
		Session session, CsclApproverMapping csclApproverMapping, int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSCLAPPROVERMAPPING_WHERE);

		query.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEE_2);

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
			query.append(CsclApproverMappingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(appointee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclApproverMapping)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclApproverMapping> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl approver mappings where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointeeId(int appointee) {
		for (CsclApproverMapping csclApproverMapping :
				findByappointeeId(
					appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclApproverMapping);
		}
	}

	/**
	 * Returns the number of cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl approver mappings
	 */
	@Override
	public int countByappointeeId(int appointee) {
		FinderPath finderPath = _finderPathCountByappointeeId;

		Object[] finderArgs = new Object[] {appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLAPPROVERMAPPING_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEEID_APPOINTEE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appointee);

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

	private static final String _FINDER_COLUMN_APPOINTEEID_APPOINTEE_2 =
		"csclApproverMapping.appointee = ?";

	public CsclApproverMappingPersistenceImpl() {
		setModelClass(CsclApproverMapping.class);

		setModelImplClass(CsclApproverMappingImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl approver mapping in the entity cache if it is enabled.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 */
	@Override
	public void cacheResult(CsclApproverMapping csclApproverMapping) {
		entityCache.putResult(
			entityCacheEnabled, CsclApproverMappingImpl.class,
			csclApproverMapping.getPrimaryKey(), csclApproverMapping);

		csclApproverMapping.resetOriginalValues();
	}

	/**
	 * Caches the cscl approver mappings in the entity cache if it is enabled.
	 *
	 * @param csclApproverMappings the cscl approver mappings
	 */
	@Override
	public void cacheResult(List<CsclApproverMapping> csclApproverMappings) {
		for (CsclApproverMapping csclApproverMapping : csclApproverMappings) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclApproverMappingImpl.class,
					csclApproverMapping.getPrimaryKey()) == null) {

				cacheResult(csclApproverMapping);
			}
			else {
				csclApproverMapping.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl approver mappings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclApproverMappingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl approver mapping.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclApproverMapping csclApproverMapping) {
		entityCache.removeResult(
			entityCacheEnabled, CsclApproverMappingImpl.class,
			csclApproverMapping.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclApproverMapping> csclApproverMappings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclApproverMapping csclApproverMapping : csclApproverMappings) {
			entityCache.removeResult(
				entityCacheEnabled, CsclApproverMappingImpl.class,
				csclApproverMapping.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl approver mapping with the primary key. Does not add the cscl approver mapping to the database.
	 *
	 * @param id_ the primary key for the new cscl approver mapping
	 * @return the new cscl approver mapping
	 */
	@Override
	public CsclApproverMapping create(long id_) {
		CsclApproverMapping csclApproverMapping = new CsclApproverMappingImpl();

		csclApproverMapping.setNew(true);
		csclApproverMapping.setPrimaryKey(id_);

		return csclApproverMapping;
	}

	/**
	 * Removes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping remove(long id_)
		throws NoSuchCsclApproverMappingException {

		return remove((Serializable)id_);
	}

	/**
	 * Removes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping remove(Serializable primaryKey)
		throws NoSuchCsclApproverMappingException {

		Session session = null;

		try {
			session = openSession();

			CsclApproverMapping csclApproverMapping =
				(CsclApproverMapping)session.get(
					CsclApproverMappingImpl.class, primaryKey);

			if (csclApproverMapping == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclApproverMappingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclApproverMapping);
		}
		catch (NoSuchCsclApproverMappingException nsee) {
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
	protected CsclApproverMapping removeImpl(
		CsclApproverMapping csclApproverMapping) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclApproverMapping)) {
				csclApproverMapping = (CsclApproverMapping)session.get(
					CsclApproverMappingImpl.class,
					csclApproverMapping.getPrimaryKeyObj());
			}

			if (csclApproverMapping != null) {
				session.delete(csclApproverMapping);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclApproverMapping != null) {
			clearCache(csclApproverMapping);
		}

		return csclApproverMapping;
	}

	@Override
	public CsclApproverMapping updateImpl(
		CsclApproverMapping csclApproverMapping) {

		boolean isNew = csclApproverMapping.isNew();

		if (!(csclApproverMapping instanceof CsclApproverMappingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclApproverMapping.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclApproverMapping);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclApproverMapping proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclApproverMapping implementation " +
					csclApproverMapping.getClass());
		}

		CsclApproverMappingModelImpl csclApproverMappingModelImpl =
			(CsclApproverMappingModelImpl)csclApproverMapping;

		Session session = null;

		try {
			session = openSession();

			if (csclApproverMapping.isNew()) {
				session.save(csclApproverMapping);

				csclApproverMapping.setNew(false);
			}
			else {
				csclApproverMapping = (CsclApproverMapping)session.merge(
					csclApproverMapping);
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
			Object[] args = new Object[] {
				csclApproverMappingModelImpl.getAssignedTo()
			};

			finderCache.removeResult(_finderPathCountByassignedTo, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByassignedTo, args);

			args = new Object[] {csclApproverMappingModelImpl.getAppointee()};

			finderCache.removeResult(_finderPathCountByappointeeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclApproverMappingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByassignedTo.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclApproverMappingModelImpl.getOriginalAssignedTo()
				};

				finderCache.removeResult(_finderPathCountByassignedTo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByassignedTo, args);

				args = new Object[] {
					csclApproverMappingModelImpl.getAssignedTo()
				};

				finderCache.removeResult(_finderPathCountByassignedTo, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByassignedTo, args);
			}

			if ((csclApproverMappingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclApproverMappingModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointeeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeId, args);

				args = new Object[] {
					csclApproverMappingModelImpl.getAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointeeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclApproverMappingImpl.class,
			csclApproverMapping.getPrimaryKey(), csclApproverMapping, false);

		csclApproverMapping.resetOriginalValues();

		return csclApproverMapping;
	}

	/**
	 * Returns the cscl approver mapping with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclApproverMappingException {

		CsclApproverMapping csclApproverMapping = fetchByPrimaryKey(primaryKey);

		if (csclApproverMapping == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclApproverMappingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclApproverMapping;
	}

	/**
	 * Returns the cscl approver mapping with the primary key or throws a <code>NoSuchCsclApproverMappingException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping findByPrimaryKey(long id_)
		throws NoSuchCsclApproverMappingException {

		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the cscl approver mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping, or <code>null</code> if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public CsclApproverMapping fetchByPrimaryKey(long id_) {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the cscl approver mappings.
	 *
	 * @return the cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl approver mappings
	 */
	@Deprecated
	@Override
	public List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl approver mappings
	 */
	@Override
	public List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

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

		List<CsclApproverMapping> list =
			(List<CsclApproverMapping>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLAPPROVERMAPPING);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPROVERMAPPING;

				if (pagination) {
					sql = sql.concat(
						CsclApproverMappingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclApproverMapping>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclApproverMapping>)QueryUtil.list(
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
	 * Removes all the cscl approver mappings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclApproverMapping csclApproverMapping : findAll()) {
			remove(csclApproverMapping);
		}
	}

	/**
	 * Returns the number of cscl approver mappings.
	 *
	 * @return the number of cscl approver mappings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLAPPROVERMAPPING);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLAPPROVERMAPPING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclApproverMappingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl approver mapping persistence.
	 */
	@Activate
	public void activate() {
		CsclApproverMappingModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclApproverMappingModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByassignedTo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByassignedTo",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByassignedTo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByassignedTo",
			new String[] {Long.class.getName()},
			CsclApproverMappingModelImpl.ASSIGNEDTO_COLUMN_BITMASK);

		_finderPathCountByassignedTo = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByassignedTo",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointeeId",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMappingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointeeId",
			new String[] {Integer.class.getName()},
			CsclApproverMappingModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointeeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointeeId",
			new String[] {Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclApproverMappingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.cscl.appointment.booking.model.CsclApproverMapping"),
			true);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclAppointmentBookingPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLAPPROVERMAPPING =
		"SELECT csclApproverMapping FROM CsclApproverMapping csclApproverMapping";

	private static final String _SQL_SELECT_CSCLAPPROVERMAPPING_WHERE =
		"SELECT csclApproverMapping FROM CsclApproverMapping csclApproverMapping WHERE ";

	private static final String _SQL_COUNT_CSCLAPPROVERMAPPING =
		"SELECT COUNT(csclApproverMapping) FROM CsclApproverMapping csclApproverMapping";

	private static final String _SQL_COUNT_CSCLAPPROVERMAPPING_WHERE =
		"SELECT COUNT(csclApproverMapping) FROM CsclApproverMapping csclApproverMapping WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclApproverMapping.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclApproverMapping exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclApproverMapping exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclApproverMappingPersistenceImpl.class);

	static {
		try {
			Class.forName(
				CsclAppointmentBookingPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}