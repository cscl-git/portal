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

package com.cscl.polls.service.persistence.impl;

import com.cscl.polls.exception.NoSuchCsclLocalityMasterException;
import com.cscl.polls.model.CsclLocalityMaster;
import com.cscl.polls.model.impl.CsclLocalityMasterImpl;
import com.cscl.polls.model.impl.CsclLocalityMasterModelImpl;
import com.cscl.polls.service.persistence.CsclLocalityMasterPersistence;
import com.cscl.polls.service.persistence.impl.constants.CsclPollsPersistenceConstants;

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
 * The persistence implementation for the cscl locality master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclLocalityMasterPersistence.class)
@ProviderType
public class CsclLocalityMasterPersistenceImpl
	extends BasePersistenceImpl<CsclLocalityMaster>
	implements CsclLocalityMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclLocalityMasterUtil</code> to access the cscl locality master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclLocalityMasterImpl.class.getName();

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
	 * Returns all the cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl locality masters
	 */
	@Override
	public List<CsclLocalityMaster> findByisActive(Boolean isActive) {
		return findByisActive(
			isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end) {

		return findByisActive(isActive, start, end, null);
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
	@Override
	public List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache) {

		return findByisActive(isActive, start, end, orderByComparator);
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
	@Override
	public List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

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

		List<CsclLocalityMaster> list =
			(List<CsclLocalityMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclLocalityMaster csclLocalityMaster : list) {
				if (!Objects.equals(
						isActive, csclLocalityMaster.getIsActive())) {

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

			query.append(_SQL_SELECT_CSCLLOCALITYMASTER_WHERE);

			query.append(_FINDER_COLUMN_ISACTIVE_ISACTIVE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclLocalityMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(isActive.booleanValue());

				if (!pagination) {
					list = (List<CsclLocalityMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclLocalityMaster>)QueryUtil.list(
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
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	@Override
	public CsclLocalityMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException {

		CsclLocalityMaster csclLocalityMaster = fetchByisActive_First(
			isActive, orderByComparator);

		if (csclLocalityMaster != null) {
			return csclLocalityMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append("}");

		throw new NoSuchCsclLocalityMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	@Override
	public CsclLocalityMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		List<CsclLocalityMaster> list = findByisActive(
			isActive, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	@Override
	public CsclLocalityMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException {

		CsclLocalityMaster csclLocalityMaster = fetchByisActive_Last(
			isActive, orderByComparator);

		if (csclLocalityMaster != null) {
			return csclLocalityMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("isActive=");
		msg.append(isActive);

		msg.append("}");

		throw new NoSuchCsclLocalityMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	@Override
	public CsclLocalityMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

		int count = countByisActive(isActive);

		if (count == 0) {
			return null;
		}

		List<CsclLocalityMaster> list = findByisActive(
			isActive, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclLocalityMaster[] findByisActive_PrevAndNext(
			long localityId, Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException {

		CsclLocalityMaster csclLocalityMaster = findByPrimaryKey(localityId);

		Session session = null;

		try {
			session = openSession();

			CsclLocalityMaster[] array = new CsclLocalityMasterImpl[3];

			array[0] = getByisActive_PrevAndNext(
				session, csclLocalityMaster, isActive, orderByComparator, true);

			array[1] = csclLocalityMaster;

			array[2] = getByisActive_PrevAndNext(
				session, csclLocalityMaster, isActive, orderByComparator,
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

	protected CsclLocalityMaster getByisActive_PrevAndNext(
		Session session, CsclLocalityMaster csclLocalityMaster,
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLLOCALITYMASTER_WHERE);

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
			query.append(CsclLocalityMasterModelImpl.ORDER_BY_JPQL);
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
						csclLocalityMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclLocalityMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl locality masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	@Override
	public void removeByisActive(Boolean isActive) {
		for (CsclLocalityMaster csclLocalityMaster :
				findByisActive(
					isActive, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclLocalityMaster);
		}
	}

	/**
	 * Returns the number of cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl locality masters
	 */
	@Override
	public int countByisActive(Boolean isActive) {
		FinderPath finderPath = _finderPathCountByisActive;

		Object[] finderArgs = new Object[] {isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLLOCALITYMASTER_WHERE);

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
		"csclLocalityMaster.isActive = ?";

	public CsclLocalityMasterPersistenceImpl() {
		setModelClass(CsclLocalityMaster.class);

		setModelImplClass(CsclLocalityMasterImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl locality master in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 */
	@Override
	public void cacheResult(CsclLocalityMaster csclLocalityMaster) {
		entityCache.putResult(
			entityCacheEnabled, CsclLocalityMasterImpl.class,
			csclLocalityMaster.getPrimaryKey(), csclLocalityMaster);

		csclLocalityMaster.resetOriginalValues();
	}

	/**
	 * Caches the cscl locality masters in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMasters the cscl locality masters
	 */
	@Override
	public void cacheResult(List<CsclLocalityMaster> csclLocalityMasters) {
		for (CsclLocalityMaster csclLocalityMaster : csclLocalityMasters) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclLocalityMasterImpl.class,
					csclLocalityMaster.getPrimaryKey()) == null) {

				cacheResult(csclLocalityMaster);
			}
			else {
				csclLocalityMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl locality masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclLocalityMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl locality master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclLocalityMaster csclLocalityMaster) {
		entityCache.removeResult(
			entityCacheEnabled, CsclLocalityMasterImpl.class,
			csclLocalityMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclLocalityMaster> csclLocalityMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclLocalityMaster csclLocalityMaster : csclLocalityMasters) {
			entityCache.removeResult(
				entityCacheEnabled, CsclLocalityMasterImpl.class,
				csclLocalityMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl locality master with the primary key. Does not add the cscl locality master to the database.
	 *
	 * @param localityId the primary key for the new cscl locality master
	 * @return the new cscl locality master
	 */
	@Override
	public CsclLocalityMaster create(long localityId) {
		CsclLocalityMaster csclLocalityMaster = new CsclLocalityMasterImpl();

		csclLocalityMaster.setNew(true);
		csclLocalityMaster.setPrimaryKey(localityId);

		return csclLocalityMaster;
	}

	/**
	 * Removes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster remove(long localityId)
		throws NoSuchCsclLocalityMasterException {

		return remove((Serializable)localityId);
	}

	/**
	 * Removes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster remove(Serializable primaryKey)
		throws NoSuchCsclLocalityMasterException {

		Session session = null;

		try {
			session = openSession();

			CsclLocalityMaster csclLocalityMaster =
				(CsclLocalityMaster)session.get(
					CsclLocalityMasterImpl.class, primaryKey);

			if (csclLocalityMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclLocalityMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclLocalityMaster);
		}
		catch (NoSuchCsclLocalityMasterException nsee) {
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
	protected CsclLocalityMaster removeImpl(
		CsclLocalityMaster csclLocalityMaster) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclLocalityMaster)) {
				csclLocalityMaster = (CsclLocalityMaster)session.get(
					CsclLocalityMasterImpl.class,
					csclLocalityMaster.getPrimaryKeyObj());
			}

			if (csclLocalityMaster != null) {
				session.delete(csclLocalityMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclLocalityMaster != null) {
			clearCache(csclLocalityMaster);
		}

		return csclLocalityMaster;
	}

	@Override
	public CsclLocalityMaster updateImpl(
		CsclLocalityMaster csclLocalityMaster) {

		boolean isNew = csclLocalityMaster.isNew();

		if (!(csclLocalityMaster instanceof CsclLocalityMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclLocalityMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclLocalityMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclLocalityMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclLocalityMaster implementation " +
					csclLocalityMaster.getClass());
		}

		CsclLocalityMasterModelImpl csclLocalityMasterModelImpl =
			(CsclLocalityMasterModelImpl)csclLocalityMaster;

		Session session = null;

		try {
			session = openSession();

			if (csclLocalityMaster.isNew()) {
				session.save(csclLocalityMaster);

				csclLocalityMaster.setNew(false);
			}
			else {
				csclLocalityMaster = (CsclLocalityMaster)session.merge(
					csclLocalityMaster);
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
				csclLocalityMasterModelImpl.getIsActive()
			};

			finderCache.removeResult(_finderPathCountByisActive, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByisActive, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclLocalityMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByisActive.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclLocalityMasterModelImpl.getOriginalIsActive()
				};

				finderCache.removeResult(_finderPathCountByisActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByisActive, args);

				args = new Object[] {csclLocalityMasterModelImpl.getIsActive()};

				finderCache.removeResult(_finderPathCountByisActive, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByisActive, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclLocalityMasterImpl.class,
			csclLocalityMaster.getPrimaryKey(), csclLocalityMaster, false);

		csclLocalityMaster.resetOriginalValues();

		return csclLocalityMaster;
	}

	/**
	 * Returns the cscl locality master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclLocalityMasterException {

		CsclLocalityMaster csclLocalityMaster = fetchByPrimaryKey(primaryKey);

		if (csclLocalityMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclLocalityMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclLocalityMaster;
	}

	/**
	 * Returns the cscl locality master with the primary key or throws a <code>NoSuchCsclLocalityMasterException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster findByPrimaryKey(long localityId)
		throws NoSuchCsclLocalityMasterException {

		return findByPrimaryKey((Serializable)localityId);
	}

	/**
	 * Returns the cscl locality master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master, or <code>null</code> if a cscl locality master with the primary key could not be found
	 */
	@Override
	public CsclLocalityMaster fetchByPrimaryKey(long localityId) {
		return fetchByPrimaryKey((Serializable)localityId);
	}

	/**
	 * Returns all the cscl locality masters.
	 *
	 * @return the cscl locality masters
	 */
	@Override
	public List<CsclLocalityMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclLocalityMaster> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator) {

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

		List<CsclLocalityMaster> list =
			(List<CsclLocalityMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLLOCALITYMASTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLLOCALITYMASTER;

				if (pagination) {
					sql = sql.concat(CsclLocalityMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclLocalityMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclLocalityMaster>)QueryUtil.list(
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
	 * Removes all the cscl locality masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclLocalityMaster csclLocalityMaster : findAll()) {
			remove(csclLocalityMaster);
		}
	}

	/**
	 * Returns the number of cscl locality masters.
	 *
	 * @return the number of cscl locality masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLLOCALITYMASTER);

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
		return "localityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLLOCALITYMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclLocalityMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl locality master persistence.
	 */
	@Activate
	public void activate() {
		CsclLocalityMasterModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclLocalityMasterModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclLocalityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclLocalityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclLocalityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByisActive",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclLocalityMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByisActive",
			new String[] {Boolean.class.getName()},
			CsclLocalityMasterModelImpl.ISACTIVE_COLUMN_BITMASK);

		_finderPathCountByisActive = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByisActive",
			new String[] {Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclLocalityMasterImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.polls.model.CsclLocalityMaster"),
			true);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLLOCALITYMASTER =
		"SELECT csclLocalityMaster FROM CsclLocalityMaster csclLocalityMaster";

	private static final String _SQL_SELECT_CSCLLOCALITYMASTER_WHERE =
		"SELECT csclLocalityMaster FROM CsclLocalityMaster csclLocalityMaster WHERE ";

	private static final String _SQL_COUNT_CSCLLOCALITYMASTER =
		"SELECT COUNT(csclLocalityMaster) FROM CsclLocalityMaster csclLocalityMaster";

	private static final String _SQL_COUNT_CSCLLOCALITYMASTER_WHERE =
		"SELECT COUNT(csclLocalityMaster) FROM CsclLocalityMaster csclLocalityMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclLocalityMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclLocalityMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclLocalityMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclLocalityMasterPersistenceImpl.class);

	static {
		try {
			Class.forName(CsclPollsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}