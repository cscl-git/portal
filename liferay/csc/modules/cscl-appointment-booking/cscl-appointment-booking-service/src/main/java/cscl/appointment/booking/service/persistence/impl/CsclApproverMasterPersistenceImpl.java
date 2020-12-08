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

import cscl.appointment.booking.exception.NoSuchCsclApproverMasterException;
import cscl.appointment.booking.model.CsclApproverMaster;
import cscl.appointment.booking.model.impl.CsclApproverMasterImpl;
import cscl.appointment.booking.model.impl.CsclApproverMasterModelImpl;
import cscl.appointment.booking.service.persistence.CsclApproverMasterPersistence;
import cscl.appointment.booking.service.persistence.impl.constants.CsclAppointmentBookingPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl approver master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclApproverMasterPersistence.class)
@ProviderType
public class CsclApproverMasterPersistenceImpl
	extends BasePersistenceImpl<CsclApproverMaster>
	implements CsclApproverMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclApproverMasterUtil</code> to access the cscl approver master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclApproverMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByisActive;
	private FinderPath _finderPathWithoutPaginationFindByisActive;
	private FinderPath _finderPathCountByisActive;

	/**
	 * Returns all the cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl approver masters
	 */
	@Override
	public List<CsclApproverMaster> findByisActive(Boolean isActive) {
		return findByisActive(
			isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end) {

		return findByisActive(isActive, start, end, null);
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
	@Override
	public List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache) {

		return findByisActive(isActive, start, end, orderByComparator);
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
	@Override
	public List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByisActive;
			finderArgs = new Object[] {isActive};
		}
		else {
			finderPath = _finderPathWithPaginationFindByisActive;
			finderArgs = new Object[] {isActive, start, end, orderByComparator};
		}

		List<CsclApproverMaster> list =
			(List<CsclApproverMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclApproverMaster csclApproverMaster : list) {
				if (!Objects.equals(
						isActive, csclApproverMaster.getIsActive())) {

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

			query.append(_SQL_SELECT_CSCLAPPROVERMASTER_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclApproverMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive.booleanValue());

				if (!pagination) {
					list = (List<CsclApproverMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclApproverMaster>)QueryUtil.list(
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
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	@Override
	public CsclApproverMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException {

		CsclApproverMaster csclApproverMaster = fetchByisActive_First(
			isActive, orderByComparator);

		if (csclApproverMaster != null) {
			return csclApproverMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append("}");

		throw new NoSuchCsclApproverMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	@Override
	public CsclApproverMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		List<CsclApproverMaster> list = findByisActive(
			isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	@Override
	public CsclApproverMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException {

		CsclApproverMaster csclApproverMaster = fetchByisActive_Last(
			isActive, orderByComparator);

		if (csclApproverMaster != null) {
			return csclApproverMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append("}");

		throw new NoSuchCsclApproverMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	@Override
	public CsclApproverMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

		int count = countByisActive(isActive);

		if (count == 0) {
			return null;
		}

		List<CsclApproverMaster> list = findByisActive(
			isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclApproverMaster[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException {

		CsclApproverMaster csclApproverMaster = findByPrimaryKey(id_);

		Session session = null;

		try {
			session = openSession();

			CsclApproverMaster[] array = new CsclApproverMasterImpl[3];

			array[0] = getByisActive_PrevAndNext(
				session, csclApproverMaster, isActive, orderByComparator, true);

			array[1] = csclApproverMaster;

			array[2] = getByisActive_PrevAndNext(
				session, csclApproverMaster, isActive, orderByComparator,
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

	protected CsclApproverMaster getByisActive_PrevAndNext(
		Session session, CsclApproverMaster csclApproverMaster,
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLAPPROVERMASTER_WHERE);

		query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

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
			query.append(CsclApproverMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(isActive.booleanValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclApproverMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclApproverMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl approver masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	@Override
	public void removeByisActive(Boolean isActive) {
		for (CsclApproverMaster csclApproverMaster :
				findByisActive(
					isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclApproverMaster);
		}
	}

	/**
	 * Returns the number of cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl approver masters
	 */
	@Override
	public int countByisActive(Boolean isActive) {
		FinderPath finderPath = _finderPathCountByisActive;

		Object[] finderArgs = new Object[] {isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLAPPROVERMASTER_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive.booleanValue());

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

	private static final String _FINDER_COLUMN_ISACTIVE_ISACTIVE_2 =
		"csclApproverMaster.isActive = ?";

	public CsclApproverMasterPersistenceImpl() {
		setModelClass(CsclApproverMaster.class);

		setModelImplClass(CsclApproverMasterImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl approver master in the entity cache if it is enabled.
	 *
	 * @param csclApproverMaster the cscl approver master
	 */
	@Override
	public void cacheResult(CsclApproverMaster csclApproverMaster) {
		entityCache.putResult(
			entityCacheEnabled, CsclApproverMasterImpl.class,
			csclApproverMaster.getPrimaryKey(), csclApproverMaster);

		csclApproverMaster.resetOriginalValues();
	}

	/**
	 * Caches the cscl approver masters in the entity cache if it is enabled.
	 *
	 * @param csclApproverMasters the cscl approver masters
	 */
	@Override
	public void cacheResult(List<CsclApproverMaster> csclApproverMasters) {
		for (CsclApproverMaster csclApproverMaster : csclApproverMasters) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclApproverMasterImpl.class,
					csclApproverMaster.getPrimaryKey()) == null) {

				cacheResult(csclApproverMaster);
			}
			else {
				csclApproverMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl approver masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclApproverMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl approver master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclApproverMaster csclApproverMaster) {
		entityCache.removeResult(
			entityCacheEnabled, CsclApproverMasterImpl.class,
			csclApproverMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclApproverMaster> csclApproverMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclApproverMaster csclApproverMaster : csclApproverMasters) {
			entityCache.removeResult(
				entityCacheEnabled, CsclApproverMasterImpl.class,
				csclApproverMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl approver master with the primary key. Does not add the cscl approver master to the database.
	 *
	 * @param id_ the primary key for the new cscl approver master
	 * @return the new cscl approver master
	 */
	@Override
	public CsclApproverMaster create(long id_) {
		CsclApproverMaster csclApproverMaster = new CsclApproverMasterImpl();

		csclApproverMaster.setNew(true);
		csclApproverMaster.setPrimaryKey(id_);

		return csclApproverMaster;
	}

	/**
	 * Removes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public CsclApproverMaster remove(long id_)
		throws NoSuchCsclApproverMasterException {

		return remove((Serializable)id_);
	}

	/**
	 * Removes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public CsclApproverMaster remove(Serializable primaryKey)
		throws NoSuchCsclApproverMasterException {

		Session session = null;

		try {
			session = openSession();

			CsclApproverMaster csclApproverMaster =
				(CsclApproverMaster)session.get(
					CsclApproverMasterImpl.class, primaryKey);

			if (csclApproverMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclApproverMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclApproverMaster);
		}
		catch (NoSuchCsclApproverMasterException nsee) {
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
	protected CsclApproverMaster removeImpl(
		CsclApproverMaster csclApproverMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclApproverMaster)) {
				csclApproverMaster = (CsclApproverMaster)session.get(
					CsclApproverMasterImpl.class,
					csclApproverMaster.getPrimaryKeyObj());
			}

			if (csclApproverMaster != null) {
				session.delete(csclApproverMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclApproverMaster != null) {
			clearCache(csclApproverMaster);
		}

		return csclApproverMaster;
	}

	@Override
	public CsclApproverMaster updateImpl(
		CsclApproverMaster csclApproverMaster) {

		boolean isNew = csclApproverMaster.isNew();

		if (!(csclApproverMaster instanceof CsclApproverMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclApproverMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclApproverMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclApproverMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclApproverMaster implementation " +
					csclApproverMaster.getClass());
		}

		CsclApproverMasterModelImpl csclApproverMasterModelImpl =
			(CsclApproverMasterModelImpl)csclApproverMaster;

		Session session = null;

		try {
			session = openSession();

			if (csclApproverMaster.isNew()) {
				session.save(csclApproverMaster);

				csclApproverMaster.setNew(false);
			}
			else {
				csclApproverMaster = (CsclApproverMaster)session.merge(
					csclApproverMaster);
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
				csclApproverMasterModelImpl.getIsActive()
			};

			finderCache.removeResult(_finderPathCountByisActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByisActive, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclApproverMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByisActive.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclApproverMasterModelImpl.getOriginalIsActive()
				};

				finderCache.removeResult(_finderPathCountByisActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByisActive, args);

				args = new Object[] {csclApproverMasterModelImpl.getIsActive()};

				finderCache.removeResult(_finderPathCountByisActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByisActive, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclApproverMasterImpl.class,
			csclApproverMaster.getPrimaryKey(), csclApproverMaster, false);

		csclApproverMaster.resetOriginalValues();

		return csclApproverMaster;
	}

	/**
	 * Returns the cscl approver master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public CsclApproverMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclApproverMasterException {

		CsclApproverMaster csclApproverMaster = fetchByPrimaryKey(primaryKey);

		if (csclApproverMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclApproverMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclApproverMaster;
	}

	/**
	 * Returns the cscl approver master with the primary key or throws a <code>NoSuchCsclApproverMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public CsclApproverMaster findByPrimaryKey(long id_)
		throws NoSuchCsclApproverMasterException {

		return findByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns the cscl approver master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master, or <code>null</code> if a cscl approver master with the primary key could not be found
	 */
	@Override
	public CsclApproverMaster fetchByPrimaryKey(long id_) {
		return fetchByPrimaryKey((Serializable)id_);
	}

	/**
	 * Returns all the cscl approver masters.
	 *
	 * @return the cscl approver masters
	 */
	@Override
	public List<CsclApproverMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclApproverMaster> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator) {

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

		List<CsclApproverMaster> list =
			(List<CsclApproverMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLAPPROVERMASTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLAPPROVERMASTER;

				if (pagination) {
					sql = sql.concat(CsclApproverMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclApproverMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclApproverMaster>)QueryUtil.list(
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
	 * Removes all the cscl approver masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclApproverMaster csclApproverMaster : findAll()) {
			remove(csclApproverMaster);
		}
	}

	/**
	 * Returns the number of cscl approver masters.
	 *
	 * @return the number of cscl approver masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLAPPROVERMASTER);

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
		return _SQL_SELECT_CSCLAPPROVERMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclApproverMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl approver master persistence.
	 */
	@Activate
	public void activate() {
		CsclApproverMasterModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclApproverMasterModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclApproverMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisActive",
			new String[] {Boolean.class.getName()},
			CsclApproverMasterModelImpl.ISACTIVE_COLUMN_BITMASK);

		_finderPathCountByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisActive",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclApproverMasterImpl.class.getName());
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
				"value.object.column.bitmask.enabled.cscl.appointment.booking.model.CsclApproverMaster"),
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

	private static final String _SQL_SELECT_CSCLAPPROVERMASTER =
		"SELECT csclApproverMaster FROM CsclApproverMaster csclApproverMaster";

	private static final String _SQL_SELECT_CSCLAPPROVERMASTER_WHERE =
		"SELECT csclApproverMaster FROM CsclApproverMaster csclApproverMaster WHERE ";

	private static final String _SQL_COUNT_CSCLAPPROVERMASTER =
		"SELECT COUNT(csclApproverMaster) FROM CsclApproverMaster csclApproverMaster";

	private static final String _SQL_COUNT_CSCLAPPROVERMASTER_WHERE =
		"SELECT COUNT(csclApproverMaster) FROM CsclApproverMaster csclApproverMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclApproverMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclApproverMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclApproverMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclApproverMasterPersistenceImpl.class);

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