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
import com.liferay.portal.kernel.util.SetUtil;

import cscl.appointment.booking.exception.NoSuchCsclAppointmentMasterException;
import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.impl.CsclAppointmentMasterImpl;
import cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl;
import cscl.appointment.booking.service.persistence.CsclAppointmentMasterPersistence;
import cscl.appointment.booking.service.persistence.impl.constants.CsclAppointmentBookingPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl appointment master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclAppointmentMasterPersistence.class)
@ProviderType
public class CsclAppointmentMasterPersistenceImpl
	extends BasePersistenceImpl<CsclAppointmentMaster>
	implements CsclAppointmentMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclAppointmentMasterUtil</code> to access the cscl appointment master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclAppointmentMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByapprover;
	private FinderPath _finderPathWithoutPaginationFindByapprover;
	private FinderPath _finderPathCountByapprover;

	/**
	 * Returns all the cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByapprover(long approver) {
		return findByapprover(
			approver, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end) {

		return findByapprover(approver, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByapprover(long, int, int, OrderByComparator)}
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return findByapprover(approver, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByapprover;
			finderArgs = new Object[] {approver};
		}
		else {
			finderPath = _finderPathWithPaginationFindByapprover;
			finderArgs = new Object[] {approver, start, end, orderByComparator};
		}

		List<CsclAppointmentMaster> list =
			(List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclAppointmentMaster csclAppointmentMaster : list) {
				if ((approver != csclAppointmentMaster.getApprover())) {
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

			query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approver);

				if (!pagination) {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByapprover_First(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByapprover_First(
			approver, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approver=");
		msg.append(approver);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByapprover_First(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByapprover(
			approver, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByapprover_Last(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByapprover_Last(
			approver, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("approver=");
		msg.append(approver);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByapprover_Last(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByapprover(approver);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByapprover(
			approver, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster[] findByapprover_PrevAndNext(
			long id_, long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByapprover_PrevAndNext(
				session, csclAppointmentMaster, approver, orderByComparator,
				true);

			array[1] = csclAppointmentMaster;

			array[2] = getByapprover_PrevAndNext(
				session, csclAppointmentMaster, approver, orderByComparator,
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

	protected CsclAppointmentMaster getByapprover_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		query.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

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
			query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(approver);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where approver = &#63; from the database.
	 *
	 * @param approver the approver
	 */
	@Override
	public void removeByapprover(long approver) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByapprover(
					approver, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByapprover(long approver) {
		FinderPath finderPath = _finderPathCountByapprover;

		Object[] finderArgs = new Object[] {approver};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPROVER_APPROVER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(approver);

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

	private static final String _FINDER_COLUMN_APPROVER_APPROVER_2 =
		"csclAppointmentMaster.approver = ?";

	private FinderPath _finderPathWithPaginationFindByappointee;
	private FinderPath _finderPathWithoutPaginationFindByappointee;
	private FinderPath _finderPathCountByappointee;

	/**
	 * Returns all the cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointee(int appointee) {
		return findByappointee(
			appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end) {

		return findByappointee(appointee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointee(int, int, int, OrderByComparator)}
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return findByappointee(appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByappointee;
			finderArgs = new Object[] {appointee};
		}
		else {
			finderPath = _finderPathWithPaginationFindByappointee;
			finderArgs = new Object[] {
				appointee, start, end, orderByComparator
			};
		}

		List<CsclAppointmentMaster> list =
			(List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclAppointmentMaster csclAppointmentMaster : list) {
				if ((appointee != csclAppointmentMaster.getAppointee())) {
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

			query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(appointee);

				if (!pagination) {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointee_First(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByappointee_First(
			appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointee_First(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByappointee(
			appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointee_Last(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByappointee_Last(
			appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointee_Last(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByappointee(appointee);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByappointee(
			appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster[] findByappointee_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByappointee_PrevAndNext(
				session, csclAppointmentMaster, appointee, orderByComparator,
				true);

			array[1] = csclAppointmentMaster;

			array[2] = getByappointee_PrevAndNext(
				session, csclAppointmentMaster, appointee, orderByComparator,
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

	protected CsclAppointmentMaster getByappointee_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		query.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

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
			query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
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
						csclAppointmentMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointee(int appointee) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByappointee(
					appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByappointee(int appointee) {
		FinderPath finderPath = _finderPathCountByappointee;

		Object[] finderArgs = new Object[] {appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEE_APPOINTEE_2);

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

	private static final String _FINDER_COLUMN_APPOINTEE_APPOINTEE_2 =
		"csclAppointmentMaster.appointee = ?";

	private FinderPath _finderPathWithPaginationFindByappointeeAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByappointeeAndStatus;
	private FinderPath _finderPathCountByappointeeAndStatus;

	/**
	 * Returns all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee) {

		return findByappointeeAndStatus(
			status, appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end) {

		return findByappointeeAndStatus(status, appointee, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointeeAndStatus(int,int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return findByappointeeAndStatus(
			status, appointee, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByappointeeAndStatus;
			finderArgs = new Object[] {status, appointee};
		}
		else {
			finderPath = _finderPathWithPaginationFindByappointeeAndStatus;
			finderArgs = new Object[] {
				status, appointee, start, end, orderByComparator
			};
		}

		List<CsclAppointmentMaster> list =
			(List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclAppointmentMaster csclAppointmentMaster : list) {
				if ((status != csclAppointmentMaster.getStatus()) ||
					(appointee != csclAppointmentMaster.getAppointee())) {

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

			query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

			query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(appointee);

				if (!pagination) {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointeeAndStatus_First(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndStatus_First(
				status, appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointeeAndStatus_First(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		List<CsclAppointmentMaster> list = findByappointeeAndStatus(
			status, appointee, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster findByappointeeAndStatus_Last(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster =
			fetchByappointeeAndStatus_Last(
				status, appointee, orderByComparator);

		if (csclAppointmentMaster != null) {
			return csclAppointmentMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", appointee=");
		msg.append(appointee);

		msg.append("}");

		throw new NoSuchCsclAppointmentMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByappointeeAndStatus_Last(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

		int count = countByappointeeAndStatus(status, appointee);

		if (count == 0) {
			return null;
		}

		List<CsclAppointmentMaster> list = findByappointeeAndStatus(
			status, appointee, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster[] findByappointeeAndStatus_PrevAndNext(
			long id_, int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster[] array = new CsclAppointmentMasterImpl[3];

			array[0] = getByappointeeAndStatus_PrevAndNext(
				session, csclAppointmentMaster, status, appointee,
				orderByComparator, true);

			array[1] = csclAppointmentMaster;

			array[2] = getByappointeeAndStatus_PrevAndNext(
				session, csclAppointmentMaster, status, appointee,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclAppointmentMaster getByappointeeAndStatus_PrevAndNext(
		Session session, CsclAppointmentMaster csclAppointmentMaster,
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE);

		query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

		query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

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
			query.append(CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(appointee);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclAppointmentMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclAppointmentMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl appointment masters where status = &#63; and appointee = &#63; from the database.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 */
	@Override
	public void removeByappointeeAndStatus(int status, int appointee) {
		for (CsclAppointmentMaster csclAppointmentMaster :
				findByappointeeAndStatus(
					status, appointee, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	@Override
	public int countByappointeeAndStatus(int status, int appointee) {
		FinderPath finderPath = _finderPathCountByappointeeAndStatus;

		Object[] finderArgs = new Object[] {status, appointee};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE);

			query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2);

			query.append(_FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_APPOINTEEANDSTATUS_STATUS_2 =
		"csclAppointmentMaster.status = ? AND ";

	private static final String _FINDER_COLUMN_APPOINTEEANDSTATUS_APPOINTEE_2 =
		"csclAppointmentMaster.appointee = ?";

	public CsclAppointmentMasterPersistenceImpl() {
		setModelClass(CsclAppointmentMaster.class);

		setModelImplClass(CsclAppointmentMasterImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl appointment master in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 */
	@Override
	public void cacheResult(CsclAppointmentMaster csclAppointmentMaster) {
		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey(), csclAppointmentMaster);

		csclAppointmentMaster.resetOriginalValues();
	}

	/**
	 * Caches the cscl appointment masters in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMasters the cscl appointment masters
	 */
	@Override
	public void cacheResult(
		List<CsclAppointmentMaster> csclAppointmentMasters) {

		for (CsclAppointmentMaster csclAppointmentMaster :
				csclAppointmentMasters) {

			if (entityCache.getResult(
					entityCacheEnabled, CsclAppointmentMasterImpl.class,
					csclAppointmentMaster.getPrimaryKey()) == null) {

				cacheResult(csclAppointmentMaster);
			}
			else {
				csclAppointmentMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl appointment masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclAppointmentMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl appointment master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclAppointmentMaster csclAppointmentMaster) {
		entityCache.removeResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclAppointmentMaster> csclAppointmentMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclAppointmentMaster csclAppointmentMaster :
				csclAppointmentMasters) {

			entityCache.removeResult(
				entityCacheEnabled, CsclAppointmentMasterImpl.class,
				csclAppointmentMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	@Override
	public CsclAppointmentMaster create(long id_) {
		CsclAppointmentMaster csclAppointmentMaster =
			new CsclAppointmentMasterImpl();

		csclAppointmentMaster.setNew(true);
		csclAppointmentMaster.setPrimaryKey(id_);

		return csclAppointmentMaster;
	}

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster remove(long id_)
		throws NoSuchCsclAppointmentMasterException {

		return remove((Serializable)id_);
	}

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster remove(Serializable primaryKey)
		throws NoSuchCsclAppointmentMasterException {

		Session session = null;

		try {
			session = openSession();

			CsclAppointmentMaster csclAppointmentMaster =
				(CsclAppointmentMaster)session.get(
					CsclAppointmentMasterImpl.class, primaryKey);

			if (csclAppointmentMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclAppointmentMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclAppointmentMaster);
		}
		catch (NoSuchCsclAppointmentMasterException nsee) {
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
	protected CsclAppointmentMaster removeImpl(
		CsclAppointmentMaster csclAppointmentMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclAppointmentMaster)) {
				csclAppointmentMaster = (CsclAppointmentMaster)session.get(
					CsclAppointmentMasterImpl.class,
					csclAppointmentMaster.getPrimaryKeyObj());
			}

			if (csclAppointmentMaster != null) {
				session.delete(csclAppointmentMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclAppointmentMaster != null) {
			clearCache(csclAppointmentMaster);
		}

		return csclAppointmentMaster;
	}

	@Override
	public CsclAppointmentMaster updateImpl(
		CsclAppointmentMaster csclAppointmentMaster) {

		boolean isNew = csclAppointmentMaster.isNew();

		if (!(csclAppointmentMaster instanceof
				CsclAppointmentMasterModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclAppointmentMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclAppointmentMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclAppointmentMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclAppointmentMaster implementation " +
					csclAppointmentMaster.getClass());
		}

		CsclAppointmentMasterModelImpl csclAppointmentMasterModelImpl =
			(CsclAppointmentMasterModelImpl)csclAppointmentMaster;

		Session session = null;

		try {
			session = openSession();

			if (csclAppointmentMaster.isNew()) {
				session.save(csclAppointmentMaster);

				csclAppointmentMaster.setNew(false);
			}
			else {
				csclAppointmentMaster = (CsclAppointmentMaster)session.merge(
					csclAppointmentMaster);
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
				csclAppointmentMasterModelImpl.getApprover()
			};

			finderCache.removeResult(_finderPathCountByapprover, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByapprover, args);

			args = new Object[] {csclAppointmentMasterModelImpl.getAppointee()};

			finderCache.removeResult(_finderPathCountByappointee, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointee, args);

			args = new Object[] {
				csclAppointmentMasterModelImpl.getStatus(),
				csclAppointmentMasterModelImpl.getAppointee()
			};

			finderCache.removeResult(
				_finderPathCountByappointeeAndStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByappointeeAndStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByapprover.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalApprover()
				};

				finderCache.removeResult(_finderPathCountByapprover, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByapprover, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getApprover()
				};

				finderCache.removeResult(_finderPathCountByapprover, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByapprover, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointee.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getAppointee()
				};

				finderCache.removeResult(_finderPathCountByappointee, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointee, args);
			}

			if ((csclAppointmentMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByappointeeAndStatus.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclAppointmentMasterModelImpl.getOriginalStatus(),
					csclAppointmentMasterModelImpl.getOriginalAppointee()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndStatus, args);

				args = new Object[] {
					csclAppointmentMasterModelImpl.getStatus(),
					csclAppointmentMasterModelImpl.getAppointee()
				};

				finderCache.removeResult(
					_finderPathCountByappointeeAndStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByappointeeAndStatus, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclAppointmentMasterImpl.class,
			csclAppointmentMaster.getPrimaryKey(), csclAppointmentMaster,
			false);

		csclAppointmentMaster.resetOriginalValues();

		return csclAppointmentMaster;
	}

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclAppointmentMasterException {

		CsclAppointmentMaster csclAppointmentMaster = fetchByPrimaryKey(
			primaryKey);

		if (csclAppointmentMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclAppointmentMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclAppointmentMaster;
	}

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>NoSuchCsclAppointmentMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster findByPrimaryKey(long id_)
		throws NoSuchCsclAppointmentMasterException {

		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the cscl appointment master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master, or <code>null</code> if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public CsclAppointmentMaster fetchByPrimaryKey(long id_) {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the cscl appointment masters.
	 *
	 * @return the cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointment masters
	 */
	@Deprecated
	@Override
	public List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointment masters
	 */
	@Override
	public List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator) {

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

		List<CsclAppointmentMaster> list =
			(List<CsclAppointmentMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLAPPOINTMENTMASTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPOINTMENTMASTER;

				if (pagination) {
					sql = sql.concat(
						CsclAppointmentMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclAppointmentMaster>)QueryUtil.list(
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
	 * Removes all the cscl appointment masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclAppointmentMaster csclAppointmentMaster : findAll()) {
			remove(csclAppointmentMaster);
		}
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLAPPOINTMENTMASTER);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLAPPOINTMENTMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclAppointmentMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl appointment master persistence.
	 */
	@Activate
	public void activate() {
		CsclAppointmentMasterModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		CsclAppointmentMasterModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByapprover",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByapprover",
			new String[] {Long.class.getName()},
			CsclAppointmentMasterModelImpl.APPROVER_COLUMN_BITMASK);

		_finderPathCountByapprover = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByapprover",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointee",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByappointee",
			new String[] {Integer.class.getName()},
			CsclAppointmentMasterModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointee = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByappointee",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByappointeeAndStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclAppointmentMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByappointeeAndStatus",
			new String[] {Integer.class.getName(), Integer.class.getName()},
			CsclAppointmentMasterModelImpl.STATUS_COLUMN_BITMASK |
			CsclAppointmentMasterModelImpl.APPOINTEE_COLUMN_BITMASK);

		_finderPathCountByappointeeAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByappointeeAndStatus",
			new String[] {Integer.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclAppointmentMasterImpl.class.getName());
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
				"value.object.column.bitmask.enabled.cscl.appointment.booking.model.CsclAppointmentMaster"),
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

	private static final String _SQL_SELECT_CSCLAPPOINTMENTMASTER =
		"SELECT csclAppointmentMaster FROM CsclAppointmentMaster csclAppointmentMaster";

	private static final String _SQL_SELECT_CSCLAPPOINTMENTMASTER_WHERE =
		"SELECT csclAppointmentMaster FROM CsclAppointmentMaster csclAppointmentMaster WHERE ";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTMASTER =
		"SELECT COUNT(csclAppointmentMaster) FROM CsclAppointmentMaster csclAppointmentMaster";

	private static final String _SQL_COUNT_CSCLAPPOINTMENTMASTER_WHERE =
		"SELECT COUNT(csclAppointmentMaster) FROM CsclAppointmentMaster csclAppointmentMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"csclAppointmentMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclAppointmentMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclAppointmentMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclAppointmentMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"comment"});

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