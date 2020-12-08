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

package com.cscl.search.service.persistence.impl;

import com.cscl.search.exception.NoSuchCsclSearchException;
import com.cscl.search.model.CsclSearch;
import com.cscl.search.model.impl.CsclSearchImpl;
import com.cscl.search.model.impl.CsclSearchModelImpl;
import com.cscl.search.service.persistence.CsclSearchPersistence;
import com.cscl.search.service.persistence.impl.constants.SearchPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

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
 * The persistence implementation for the cscl search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclSearchPersistence.class)
@ProviderType
public class CsclSearchPersistenceImpl
	extends BasePersistenceImpl<CsclSearch> implements CsclSearchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclSearchUtil</code> to access the cscl search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclSearchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByKeywords;
	private FinderPath _finderPathWithPaginationCountByKeywords;

	/**
	 * Returns all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the matching cscl searchs
	 */
	@Override
	public List<CsclSearch> findByKeywords(int status, String keywords) {
		return findByKeywords(
			status, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of matching cscl searchs
	 */
	@Override
	public List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end) {

		return findByKeywords(status, keywords, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByKeywords(int,String, int, int, OrderByComparator)}
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl searchs
	 */
	@Deprecated
	@Override
	public List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache) {

		return findByKeywords(status, keywords, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl searchs
	 */
	@Override
	public List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator) {

		keywords = Objects.toString(keywords, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByKeywords;
		finderArgs = new Object[] {
			status, keywords, start, end, orderByComparator
		};

		List<CsclSearch> list = (List<CsclSearch>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclSearch csclSearch : list) {
				if ((status != csclSearch.getStatus()) ||
					!StringUtil.wildcardMatches(
						csclSearch.getKeywords(), keywords, '_', '%', '\\',
						false)) {

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

			query.append(_SQL_SELECT_CSCLSEARCH_WHERE);

			query.append(_FINDER_COLUMN_KEYWORDS_STATUS_2);

			boolean bindKeywords = false;

			if (keywords.isEmpty()) {
				query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_3);
			}
			else {
				bindKeywords = true;

				query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclSearchModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindKeywords) {
					qPos.add(StringUtil.toLowerCase(keywords));
				}

				if (!pagination) {
					list = (List<CsclSearch>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclSearch>)QueryUtil.list(
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
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	@Override
	public CsclSearch findByKeywords_First(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException {

		CsclSearch csclSearch = fetchByKeywords_First(
			status, keywords, orderByComparator);

		if (csclSearch != null) {
			return csclSearch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", keywords=");
		msg.append(keywords);

		msg.append("}");

		throw new NoSuchCsclSearchException(msg.toString());
	}

	/**
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	@Override
	public CsclSearch fetchByKeywords_First(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator) {

		List<CsclSearch> list = findByKeywords(
			status, keywords, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	@Override
	public CsclSearch findByKeywords_Last(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException {

		CsclSearch csclSearch = fetchByKeywords_Last(
			status, keywords, orderByComparator);

		if (csclSearch != null) {
			return csclSearch;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", keywords=");
		msg.append(keywords);

		msg.append("}");

		throw new NoSuchCsclSearchException(msg.toString());
	}

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	@Override
	public CsclSearch fetchByKeywords_Last(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator) {

		int count = countByKeywords(status, keywords);

		if (count == 0) {
			return null;
		}

		List<CsclSearch> list = findByKeywords(
			status, keywords, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl searchs before and after the current cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param id the primary key of the current cscl search
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch[] findByKeywords_PrevAndNext(
			long id, int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException {

		keywords = Objects.toString(keywords, "");

		CsclSearch csclSearch = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			CsclSearch[] array = new CsclSearchImpl[3];

			array[0] = getByKeywords_PrevAndNext(
				session, csclSearch, status, keywords, orderByComparator, true);

			array[1] = csclSearch;

			array[2] = getByKeywords_PrevAndNext(
				session, csclSearch, status, keywords, orderByComparator,
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

	protected CsclSearch getByKeywords_PrevAndNext(
		Session session, CsclSearch csclSearch, int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_CSCLSEARCH_WHERE);

		query.append(_FINDER_COLUMN_KEYWORDS_STATUS_2);

		boolean bindKeywords = false;

		if (keywords.isEmpty()) {
			query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_3);
		}
		else {
			bindKeywords = true;

			query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_2);
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
			query.append(CsclSearchModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (bindKeywords) {
			qPos.add(StringUtil.toLowerCase(keywords));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(csclSearch)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclSearch> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl searchs where status = &#63; and keywords LIKE &#63; from the database.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 */
	@Override
	public void removeByKeywords(int status, String keywords) {
		for (CsclSearch csclSearch :
				findByKeywords(
					status, keywords, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclSearch);
		}
	}

	/**
	 * Returns the number of cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the number of matching cscl searchs
	 */
	@Override
	public int countByKeywords(int status, String keywords) {
		keywords = Objects.toString(keywords, "");

		FinderPath finderPath = _finderPathWithPaginationCountByKeywords;

		Object[] finderArgs = new Object[] {status, keywords};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLSEARCH_WHERE);

			query.append(_FINDER_COLUMN_KEYWORDS_STATUS_2);

			boolean bindKeywords = false;

			if (keywords.isEmpty()) {
				query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_3);
			}
			else {
				bindKeywords = true;

				query.append(_FINDER_COLUMN_KEYWORDS_KEYWORDS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (bindKeywords) {
					qPos.add(StringUtil.toLowerCase(keywords));
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

	private static final String _FINDER_COLUMN_KEYWORDS_STATUS_2 =
		"csclSearch.status = ? AND ";

	private static final String _FINDER_COLUMN_KEYWORDS_KEYWORDS_2 =
		"lower(csclSearch.keywords) LIKE ?";

	private static final String _FINDER_COLUMN_KEYWORDS_KEYWORDS_3 =
		"(csclSearch.keywords IS NULL OR csclSearch.keywords LIKE '')";

	public CsclSearchPersistenceImpl() {
		setModelClass(CsclSearch.class);

		setModelImplClass(CsclSearchImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl search in the entity cache if it is enabled.
	 *
	 * @param csclSearch the cscl search
	 */
	@Override
	public void cacheResult(CsclSearch csclSearch) {
		entityCache.putResult(
			entityCacheEnabled, CsclSearchImpl.class,
			csclSearch.getPrimaryKey(), csclSearch);

		csclSearch.resetOriginalValues();
	}

	/**
	 * Caches the cscl searchs in the entity cache if it is enabled.
	 *
	 * @param csclSearchs the cscl searchs
	 */
	@Override
	public void cacheResult(List<CsclSearch> csclSearchs) {
		for (CsclSearch csclSearch : csclSearchs) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclSearchImpl.class,
					csclSearch.getPrimaryKey()) == null) {

				cacheResult(csclSearch);
			}
			else {
				csclSearch.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl searchs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclSearchImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl search.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclSearch csclSearch) {
		entityCache.removeResult(
			entityCacheEnabled, CsclSearchImpl.class,
			csclSearch.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclSearch> csclSearchs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclSearch csclSearch : csclSearchs) {
			entityCache.removeResult(
				entityCacheEnabled, CsclSearchImpl.class,
				csclSearch.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl search with the primary key. Does not add the cscl search to the database.
	 *
	 * @param id the primary key for the new cscl search
	 * @return the new cscl search
	 */
	@Override
	public CsclSearch create(long id) {
		CsclSearch csclSearch = new CsclSearchImpl();

		csclSearch.setNew(true);
		csclSearch.setPrimaryKey(id);

		return csclSearch;
	}

	/**
	 * Removes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch remove(long id) throws NoSuchCsclSearchException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch remove(Serializable primaryKey)
		throws NoSuchCsclSearchException {

		Session session = null;

		try {
			session = openSession();

			CsclSearch csclSearch = (CsclSearch)session.get(
				CsclSearchImpl.class, primaryKey);

			if (csclSearch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCsclSearchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclSearch);
		}
		catch (NoSuchCsclSearchException nsee) {
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
	protected CsclSearch removeImpl(CsclSearch csclSearch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclSearch)) {
				csclSearch = (CsclSearch)session.get(
					CsclSearchImpl.class, csclSearch.getPrimaryKeyObj());
			}

			if (csclSearch != null) {
				session.delete(csclSearch);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclSearch != null) {
			clearCache(csclSearch);
		}

		return csclSearch;
	}

	@Override
	public CsclSearch updateImpl(CsclSearch csclSearch) {
		boolean isNew = csclSearch.isNew();

		if (!(csclSearch instanceof CsclSearchModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclSearch.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(csclSearch);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclSearch proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclSearch implementation " +
					csclSearch.getClass());
		}

		CsclSearchModelImpl csclSearchModelImpl =
			(CsclSearchModelImpl)csclSearch;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (csclSearch.getCreateDate() == null)) {
			if (serviceContext == null) {
				csclSearch.setCreateDate(now);
			}
			else {
				csclSearch.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!csclSearchModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				csclSearch.setModifiedDate(now);
			}
			else {
				csclSearch.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (csclSearch.isNew()) {
				session.save(csclSearch);

				csclSearch.setNew(false);
			}
			else {
				csclSearch = (CsclSearch)session.merge(csclSearch);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, CsclSearchImpl.class,
			csclSearch.getPrimaryKey(), csclSearch, false);

		csclSearch.resetOriginalValues();

		return csclSearch;
	}

	/**
	 * Returns the cscl search with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl search
	 * @return the cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCsclSearchException {

		CsclSearch csclSearch = fetchByPrimaryKey(primaryKey);

		if (csclSearch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCsclSearchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclSearch;
	}

	/**
	 * Returns the cscl search with the primary key or throws a <code>NoSuchCsclSearchException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch findByPrimaryKey(long id)
		throws NoSuchCsclSearchException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cscl search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search, or <code>null</code> if a cscl search with the primary key could not be found
	 */
	@Override
	public CsclSearch fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the cscl searchs.
	 *
	 * @return the cscl searchs
	 */
	@Override
	public List<CsclSearch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of cscl searchs
	 */
	@Override
	public List<CsclSearch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl searchs
	 */
	@Deprecated
	@Override
	public List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl searchs
	 */
	@Override
	public List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator) {

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

		List<CsclSearch> list = (List<CsclSearch>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLSEARCH);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLSEARCH;

				if (pagination) {
					sql = sql.concat(CsclSearchModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclSearch>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclSearch>)QueryUtil.list(
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
	 * Removes all the cscl searchs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclSearch csclSearch : findAll()) {
			remove(csclSearch);
		}
	}

	/**
	 * Returns the number of cscl searchs.
	 *
	 * @return the number of cscl searchs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLSEARCH);

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
		return _SQL_SELECT_CSCLSEARCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclSearchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl search persistence.
	 */
	@Activate
	public void activate() {
		CsclSearchModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclSearchModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByKeywords = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclSearchImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByKeywords",
			new String[] {
				Integer.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByKeywords = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByKeywords",
			new String[] {Integer.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclSearchImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = SearchPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.search.model.CsclSearch"),
			true);
	}

	@Override
	@Reference(
		target = SearchPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = SearchPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLSEARCH =
		"SELECT csclSearch FROM CsclSearch csclSearch";

	private static final String _SQL_SELECT_CSCLSEARCH_WHERE =
		"SELECT csclSearch FROM CsclSearch csclSearch WHERE ";

	private static final String _SQL_COUNT_CSCLSEARCH =
		"SELECT COUNT(csclSearch) FROM CsclSearch csclSearch";

	private static final String _SQL_COUNT_CSCLSEARCH_WHERE =
		"SELECT COUNT(csclSearch) FROM CsclSearch csclSearch WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclSearch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclSearch exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclSearch exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclSearchPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	static {
		try {
			Class.forName(SearchPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}