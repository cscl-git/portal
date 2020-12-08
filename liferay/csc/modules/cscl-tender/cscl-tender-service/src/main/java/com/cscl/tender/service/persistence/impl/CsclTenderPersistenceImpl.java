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

package com.cscl.tender.service.persistence.impl;

import com.cscl.tender.exception.NoSuchCsclTenderException;
import com.cscl.tender.model.CsclTender;
import com.cscl.tender.model.impl.CsclTenderImpl;
import com.cscl.tender.model.impl.CsclTenderModelImpl;
import com.cscl.tender.service.persistence.CsclTenderPersistence;
import com.cscl.tender.service.persistence.impl.constants.CsclTenderPersistenceConstants;

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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.sanitizer.SanitizerUtil;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the cscl tender service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclTenderPersistence.class)
@ProviderType
public class CsclTenderPersistenceImpl
	extends BasePersistenceImpl<CsclTender> implements CsclTenderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclTenderUtil</code> to access the cscl tender persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclTenderImpl.class.getName();

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
	 * Returns all the cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl tenders
	 */
	@Override
	public List<CsclTender> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclTender> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
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
	@Override
	public List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator) {

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

		List<CsclTender> list = (List<CsclTender>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclTender csclTender : list) {
				if (!uuid.equals(csclTender.getUuid())) {
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

			query.append(_SQL_SELECT_CSCLTENDER_WHERE);

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
				query.append(CsclTenderModelImpl.ORDER_BY_JPQL);
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
					list = (List<CsclTender>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclTender>)QueryUtil.list(
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
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender findByUuid_First(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = fetchByUuid_First(uuid, orderByComparator);

		if (csclTender != null) {
			return csclTender;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCsclTenderException(msg.toString());
	}

	/**
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender fetchByUuid_First(
		String uuid, OrderByComparator<CsclTender> orderByComparator) {

		List<CsclTender> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender findByUuid_Last(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = fetchByUuid_Last(uuid, orderByComparator);

		if (csclTender != null) {
			return csclTender;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchCsclTenderException(msg.toString());
	}

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender fetchByUuid_Last(
		String uuid, OrderByComparator<CsclTender> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CsclTender> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclTender[] findByUuid_PrevAndNext(
			long tenderId, String uuid,
			OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		uuid = Objects.toString(uuid, "");

		CsclTender csclTender = findByPrimaryKey(tenderId);

		Session session = null;

		try {
			session = openSession();

			CsclTender[] array = new CsclTenderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, csclTender, uuid, orderByComparator, true);

			array[1] = csclTender;

			array[2] = getByUuid_PrevAndNext(
				session, csclTender, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclTender getByUuid_PrevAndNext(
		Session session, CsclTender csclTender, String uuid,
		OrderByComparator<CsclTender> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSCLTENDER_WHERE);

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
			query.append(CsclTenderModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(csclTender)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclTender> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl tenders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CsclTender csclTender :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclTender);
		}
	}

	/**
	 * Returns the number of cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl tenders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLTENDER_WHERE);

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
		"csclTender.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(csclTender.uuid IS NULL OR csclTender.uuid = '')";

	private FinderPath _finderPathWithPaginationFindBystatus;
	private FinderPath _finderPathWithoutPaginationFindBystatus;
	private FinderPath _finderPathCountBystatus;

	/**
	 * Returns all the cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching cscl tenders
	 */
	@Override
	public List<CsclTender> findBystatus(int status) {
		return findBystatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclTender> findBystatus(int status, int start, int end) {
		return findBystatus(status, start, end, null);
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
	@Override
	public List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return findBystatus(status, start, end, orderByComparator);
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
	@Override
	public List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBystatus;
			finderArgs = new Object[] {status};
		}
		else {
			finderPath = _finderPathWithPaginationFindBystatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<CsclTender> list = (List<CsclTender>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclTender csclTender : list) {
				if ((status != csclTender.getStatus())) {
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

			query.append(_SQL_SELECT_CSCLTENDER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclTenderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<CsclTender>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclTender>)QueryUtil.list(
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
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender findBystatus_First(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = fetchBystatus_First(status, orderByComparator);

		if (csclTender != null) {
			return csclTender;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchCsclTenderException(msg.toString());
	}

	/**
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender fetchBystatus_First(
		int status, OrderByComparator<CsclTender> orderByComparator) {

		List<CsclTender> list = findBystatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender findBystatus_Last(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = fetchBystatus_Last(status, orderByComparator);

		if (csclTender != null) {
			return csclTender;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchCsclTenderException(msg.toString());
	}

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	@Override
	public CsclTender fetchBystatus_Last(
		int status, OrderByComparator<CsclTender> orderByComparator) {

		int count = countBystatus(status);

		if (count == 0) {
			return null;
		}

		List<CsclTender> list = findBystatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CsclTender[] findBystatus_PrevAndNext(
			long tenderId, int status,
			OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = findByPrimaryKey(tenderId);

		Session session = null;

		try {
			session = openSession();

			CsclTender[] array = new CsclTenderImpl[3];

			array[0] = getBystatus_PrevAndNext(
				session, csclTender, status, orderByComparator, true);

			array[1] = csclTender;

			array[2] = getBystatus_PrevAndNext(
				session, csclTender, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclTender getBystatus_PrevAndNext(
		Session session, CsclTender csclTender, int status,
		OrderByComparator<CsclTender> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CSCLTENDER_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(CsclTenderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(csclTender)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclTender> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl tenders where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeBystatus(int status) {
		for (CsclTender csclTender :
				findBystatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclTender);
		}
	}

	/**
	 * Returns the number of cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching cscl tenders
	 */
	@Override
	public int countBystatus(int status) {
		FinderPath finderPath = _finderPathCountBystatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLTENDER_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"csclTender.status = ?";

	public CsclTenderPersistenceImpl() {
		setModelClass(CsclTender.class);

		setModelImplClass(CsclTenderImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl tender in the entity cache if it is enabled.
	 *
	 * @param csclTender the cscl tender
	 */
	@Override
	public void cacheResult(CsclTender csclTender) {
		entityCache.putResult(
			entityCacheEnabled, CsclTenderImpl.class,
			csclTender.getPrimaryKey(), csclTender);

		csclTender.resetOriginalValues();
	}

	/**
	 * Caches the cscl tenders in the entity cache if it is enabled.
	 *
	 * @param csclTenders the cscl tenders
	 */
	@Override
	public void cacheResult(List<CsclTender> csclTenders) {
		for (CsclTender csclTender : csclTenders) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclTenderImpl.class,
					csclTender.getPrimaryKey()) == null) {

				cacheResult(csclTender);
			}
			else {
				csclTender.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl tenders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclTenderImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl tender.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclTender csclTender) {
		entityCache.removeResult(
			entityCacheEnabled, CsclTenderImpl.class,
			csclTender.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclTender> csclTenders) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclTender csclTender : csclTenders) {
			entityCache.removeResult(
				entityCacheEnabled, CsclTenderImpl.class,
				csclTender.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl tender with the primary key. Does not add the cscl tender to the database.
	 *
	 * @param tenderId the primary key for the new cscl tender
	 * @return the new cscl tender
	 */
	@Override
	public CsclTender create(long tenderId) {
		CsclTender csclTender = new CsclTenderImpl();

		csclTender.setNew(true);
		csclTender.setPrimaryKey(tenderId);

		String uuid = PortalUUIDUtil.generate();

		csclTender.setUuid(uuid);

		return csclTender;
	}

	/**
	 * Removes the cscl tender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender that was removed
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	@Override
	public CsclTender remove(long tenderId) throws NoSuchCsclTenderException {
		return remove((Serializable)tenderId);
	}

	/**
	 * Removes the cscl tender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl tender
	 * @return the cscl tender that was removed
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	@Override
	public CsclTender remove(Serializable primaryKey)
		throws NoSuchCsclTenderException {

		Session session = null;

		try {
			session = openSession();

			CsclTender csclTender = (CsclTender)session.get(
				CsclTenderImpl.class, primaryKey);

			if (csclTender == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclTenderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclTender);
		}
		catch (NoSuchCsclTenderException nsee) {
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
	protected CsclTender removeImpl(CsclTender csclTender) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclTender)) {
				csclTender = (CsclTender)session.get(
					CsclTenderImpl.class, csclTender.getPrimaryKeyObj());
			}

			if (csclTender != null) {
				session.delete(csclTender);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclTender != null) {
			clearCache(csclTender);
		}

		return csclTender;
	}

	@Override
	public CsclTender updateImpl(CsclTender csclTender) {
		boolean isNew = csclTender.isNew();

		if (!(csclTender instanceof CsclTenderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclTender.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(csclTender);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclTender proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclTender implementation " +
					csclTender.getClass());
		}

		CsclTenderModelImpl csclTenderModelImpl =
			(CsclTenderModelImpl)csclTender;

		if (Validator.isNull(csclTender.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			csclTender.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (csclTender.getCreateDate() == null)) {
			if (serviceContext == null) {
				csclTender.setCreateDate(now);
			}
			else {
				csclTender.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!csclTenderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				csclTender.setModifiedDate(now);
			}
			else {
				csclTender.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		long userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

		if (userId > 0) {
			long companyId = 0;

			long groupId = 0;

			long tenderId = 0;

			if (!isNew) {
				tenderId = csclTender.getPrimaryKey();
			}

			try {
				csclTender.setTitle(
					SanitizerUtil.sanitize(
						companyId, groupId, userId, CsclTender.class.getName(),
						tenderId, ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						csclTender.getTitle(), null));

				csclTender.setDescription(
					SanitizerUtil.sanitize(
						companyId, groupId, userId, CsclTender.class.getName(),
						tenderId, ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						csclTender.getDescription(), null));
			}
			catch (SanitizerException se) {
				throw new SystemException(se);
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (csclTender.isNew()) {
				session.save(csclTender);

				csclTender.setNew(false);
			}
			else {
				csclTender = (CsclTender)session.merge(csclTender);
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
			Object[] args = new Object[] {csclTenderModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {csclTenderModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountBystatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBystatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclTenderModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclTenderModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {csclTenderModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((csclTenderModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBystatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclTenderModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountBystatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatus, args);

				args = new Object[] {csclTenderModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountBystatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBystatus, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclTenderImpl.class,
			csclTender.getPrimaryKey(), csclTender, false);

		csclTender.resetOriginalValues();

		return csclTender;
	}

	/**
	 * Returns the cscl tender with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl tender
	 * @return the cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	@Override
	public CsclTender findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclTenderException {

		CsclTender csclTender = fetchByPrimaryKey(primaryKey);

		if (csclTender == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclTenderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclTender;
	}

	/**
	 * Returns the cscl tender with the primary key or throws a <code>NoSuchCsclTenderException</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	@Override
	public CsclTender findByPrimaryKey(long tenderId)
		throws NoSuchCsclTenderException {

		return findByPrimaryKey((Serializable)tenderId);
	}

	/**
	 * Returns the cscl tender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender, or <code>null</code> if a cscl tender with the primary key could not be found
	 */
	@Override
	public CsclTender fetchByPrimaryKey(long tenderId) {
		return fetchByPrimaryKey((Serializable)tenderId);
	}

	/**
	 * Returns all the cscl tenders.
	 *
	 * @return the cscl tenders
	 */
	@Override
	public List<CsclTender> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclTender> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator) {

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

		List<CsclTender> list = (List<CsclTender>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLTENDER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLTENDER;

				if (pagination) {
					sql = sql.concat(CsclTenderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclTender>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclTender>)QueryUtil.list(
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
	 * Removes all the cscl tenders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclTender csclTender : findAll()) {
			remove(csclTender);
		}
	}

	/**
	 * Returns the number of cscl tenders.
	 *
	 * @return the number of cscl tenders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLTENDER);

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
		return "tenderId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLTENDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclTenderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl tender persistence.
	 */
	@Activate
	public void activate() {
		CsclTenderModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclTenderModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			CsclTenderModelImpl.UUID_COLUMN_BITMASK |
			CsclTenderModelImpl.PUBLISHDATE_COLUMN_BITMASK |
			CsclTenderModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindBystatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBystatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBystatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclTenderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBystatus",
			new String[] {Integer.class.getName()},
			CsclTenderModelImpl.STATUS_COLUMN_BITMASK |
			CsclTenderModelImpl.PUBLISHDATE_COLUMN_BITMASK |
			CsclTenderModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountBystatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBystatus",
			new String[] {Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclTenderImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.tender.model.CsclTender"),
			true);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLTENDER =
		"SELECT csclTender FROM CsclTender csclTender";

	private static final String _SQL_SELECT_CSCLTENDER_WHERE =
		"SELECT csclTender FROM CsclTender csclTender WHERE ";

	private static final String _SQL_COUNT_CSCLTENDER =
		"SELECT COUNT(csclTender) FROM CsclTender csclTender";

	private static final String _SQL_COUNT_CSCLTENDER_WHERE =
		"SELECT COUNT(csclTender) FROM CsclTender csclTender WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclTender.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclTender exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclTender exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclTenderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(CsclTenderPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}