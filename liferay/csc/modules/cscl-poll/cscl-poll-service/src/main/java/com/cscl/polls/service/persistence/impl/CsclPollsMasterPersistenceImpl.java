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

import com.cscl.polls.exception.NoSuchMasterException;
import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.model.impl.CsclPollsMasterImpl;
import com.cscl.polls.model.impl.CsclPollsMasterModelImpl;
import com.cscl.polls.service.persistence.CsclPollsMasterPersistence;
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

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the cscl polls master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclPollsMasterPersistence.class)
@ProviderType
public class CsclPollsMasterPersistenceImpl
	extends BasePersistenceImpl<CsclPollsMaster>
	implements CsclPollsMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclPollsMasterUtil</code> to access the cscl polls master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclPollsMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindBypollId;
	private FinderPath _finderPathWithoutPaginationFindBypollId;
	private FinderPath _finderPathCountBypollId;

	/**
	 * Returns all the cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBypollId(long questionId) {
		return findBypollId(
			questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end) {

		return findBypollId(questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBypollId(long, int, int, OrderByComparator)}
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findBypollId(questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBypollId;
			finderArgs = new Object[] {questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBypollId;
			finderArgs = new Object[] {
				questionId, start, end, orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if ((questionId != csclPollsMaster.getQuestionId())) {
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

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			query.append(_FINDER_COLUMN_POLLID_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBypollId_First(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBypollId_First(
			questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBypollId_First(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findBypollId(
			questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBypollId_Last(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBypollId_Last(
			questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBypollId_Last(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countBypollId(questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findBypollId(
			questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findBypollId_PrevAndNext(
			long entryId, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getBypollId_PrevAndNext(
				session, csclPollsMaster, questionId, orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getBypollId_PrevAndNext(
				session, csclPollsMaster, questionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CsclPollsMaster getBypollId_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		query.append(_FINDER_COLUMN_POLLID_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	@Override
	public void removeBypollId(long questionId) {
		for (CsclPollsMaster csclPollsMaster :
				findBypollId(
					questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countBypollId(long questionId) {
		FinderPath finderPath = _finderPathCountBypollId;

		Object[] finderArgs = new Object[] {questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			query.append(_FINDER_COLUMN_POLLID_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_POLLID_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindBysex;
	private FinderPath _finderPathWithoutPaginationFindBysex;
	private FinderPath _finderPathCountBysex;

	/**
	 * Returns all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysex(String sex, long questionId) {
		return findBysex(
			sex, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end) {

		return findBysex(sex, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBysex(String,long, int, int, OrderByComparator)}
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findBysex(sex, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		sex = Objects.toString(sex, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBysex;
			finderArgs = new Object[] {sex, questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBysex;
			finderArgs = new Object[] {
				sex, questionId, start, end, orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!sex.equals(csclPollsMaster.getSex()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

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

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_SEX_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_SEX_SEX_2);
			}

			query.append(_FINDER_COLUMN_SEX_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBysex_First(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBysex_First(
			sex, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sex=");
		msg.append(sex);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBysex_First(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findBysex(
			sex, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBysex_Last(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBysex_Last(
			sex, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sex=");
		msg.append(sex);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBysex_Last(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countBysex(sex, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findBysex(
			sex, questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findBysex_PrevAndNext(
			long entryId, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		sex = Objects.toString(sex, "");

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getBysex_PrevAndNext(
				session, csclPollsMaster, sex, questionId, orderByComparator,
				true);

			array[1] = csclPollsMaster;

			array[2] = getBysex_PrevAndNext(
				session, csclPollsMaster, sex, questionId, orderByComparator,
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

	protected CsclPollsMaster getBysex_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, String sex,
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindSex = false;

		if (sex.isEmpty()) {
			query.append(_FINDER_COLUMN_SEX_SEX_3);
		}
		else {
			bindSex = true;

			query.append(_FINDER_COLUMN_SEX_SEX_2);
		}

		query.append(_FINDER_COLUMN_SEX_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSex) {
			qPos.add(sex);
		}

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	@Override
	public void removeBysex(String sex, long questionId) {
		for (CsclPollsMaster csclPollsMaster :
				findBysex(
					sex, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countBysex(String sex, long questionId) {
		sex = Objects.toString(sex, "");

		FinderPath finderPath = _finderPathCountBysex;

		Object[] finderArgs = new Object[] {sex, questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_SEX_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_SEX_SEX_2);
			}

			query.append(_FINDER_COLUMN_SEX_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_SEX_SEX_2 =
		"csclPollsMaster.sex = ? AND ";

	private static final String _FINDER_COLUMN_SEX_SEX_3 =
		"(csclPollsMaster.sex IS NULL OR csclPollsMaster.sex = '') AND ";

	private static final String _FINDER_COLUMN_SEX_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindBylocality;
	private FinderPath _finderPathWithoutPaginationFindBylocality;
	private FinderPath _finderPathCountBylocality;

	/**
	 * Returns all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBylocality(int locality, long questionId) {
		return findBylocality(
			locality, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end) {

		return findBylocality(locality, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBylocality(int,long, int, int, OrderByComparator)}
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findBylocality(
			locality, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBylocality;
			finderArgs = new Object[] {locality, questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBylocality;
			finderArgs = new Object[] {
				locality, questionId, start, end, orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if ((locality != csclPollsMaster.getLocality()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

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

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			query.append(_FINDER_COLUMN_LOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_LOCALITY_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locality);

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBylocality_First(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBylocality_First(
			locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBylocality_First(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findBylocality(
			locality, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBylocality_Last(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBylocality_Last(
			locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBylocality_Last(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countBylocality(locality, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findBylocality(
			locality, questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findBylocality_PrevAndNext(
			long entryId, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getBylocality_PrevAndNext(
				session, csclPollsMaster, locality, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getBylocality_PrevAndNext(
				session, csclPollsMaster, locality, questionId,
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

	protected CsclPollsMaster getBylocality_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, int locality,
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		query.append(_FINDER_COLUMN_LOCALITY_LOCALITY_2);

		query.append(_FINDER_COLUMN_LOCALITY_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(locality);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	@Override
	public void removeBylocality(int locality, long questionId) {
		for (CsclPollsMaster csclPollsMaster :
				findBylocality(
					locality, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countBylocality(int locality, long questionId) {
		FinderPath finderPath = _finderPathCountBylocality;

		Object[] finderArgs = new Object[] {locality, questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			query.append(_FINDER_COLUMN_LOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_LOCALITY_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(locality);

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_LOCALITY_LOCALITY_2 =
		"csclPollsMaster.locality = ? AND ";

	private static final String _FINDER_COLUMN_LOCALITY_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindByage;
	private FinderPath _finderPathWithoutPaginationFindByage;
	private FinderPath _finderPathCountByage;

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByage(Date birthDate, long questionId) {
		return findByage(
			birthDate, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end) {

		return findByage(birthDate, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByage(Date,long, int, int, OrderByComparator)}
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findByage(birthDate, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByage;
			finderArgs = new Object[] {_getTime(birthDate), questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByage;
			finderArgs = new Object[] {
				_getTime(birthDate), questionId, start, end, orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!Objects.equals(
						birthDate, csclPollsMaster.getBirthDate()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

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

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGE_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGE_BIRTHDATE_2);
			}

			query.append(_FINDER_COLUMN_AGE_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByage_First(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByage_First(
			birthDate, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByage_First(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findByage(
			birthDate, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByage_Last(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByage_Last(
			birthDate, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByage_Last(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countByage(birthDate, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findByage(
			birthDate, questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findByage_PrevAndNext(
			long entryId, Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getByage_PrevAndNext(
				session, csclPollsMaster, birthDate, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getByage_PrevAndNext(
				session, csclPollsMaster, birthDate, questionId,
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

	protected CsclPollsMaster getByage_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, Date birthDate,
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator,
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

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindBirthDate = false;

		if (birthDate == null) {
			query.append(_FINDER_COLUMN_AGE_BIRTHDATE_1);
		}
		else {
			bindBirthDate = true;

			query.append(_FINDER_COLUMN_AGE_BIRTHDATE_2);
		}

		query.append(_FINDER_COLUMN_AGE_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBirthDate) {
			qPos.add(new Timestamp(birthDate.getTime()));
		}

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 */
	@Override
	public void removeByage(Date birthDate, long questionId) {
		for (CsclPollsMaster csclPollsMaster :
				findByage(
					birthDate, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countByage(Date birthDate, long questionId) {
		FinderPath finderPath = _finderPathCountByage;

		Object[] finderArgs = new Object[] {_getTime(birthDate), questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGE_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGE_BIRTHDATE_2);
			}

			query.append(_FINDER_COLUMN_AGE_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_AGE_BIRTHDATE_1 =
		"csclPollsMaster.birthDate IS NULL AND ";

	private static final String _FINDER_COLUMN_AGE_BIRTHDATE_2 =
		"csclPollsMaster.birthDate = ? AND ";

	private static final String _FINDER_COLUMN_AGE_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindByageAndSex;
	private FinderPath _finderPathWithoutPaginationFindByageAndSex;
	private FinderPath _finderPathCountByageAndSex;

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId) {

		return findByageAndSex(
			birthDate, sex, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end) {

		return findByageAndSex(birthDate, sex, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByageAndSex(Date,String,long, int, int, OrderByComparator)}
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findByageAndSex(
			birthDate, sex, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		sex = Objects.toString(sex, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByageAndSex;
			finderArgs = new Object[] {_getTime(birthDate), sex, questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByageAndSex;
			finderArgs = new Object[] {
				_getTime(birthDate), sex, questionId, start, end,
				orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!Objects.equals(
						birthDate, csclPollsMaster.getBirthDate()) ||
					!sex.equals(csclPollsMaster.getSex()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_2);
			}

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_AGEANDSEX_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_AGEANDSEX_SEX_2);
			}

			query.append(_FINDER_COLUMN_AGEANDSEX_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndSex_First(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndSex_First(
			birthDate, sex, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", sex=");
		msg.append(sex);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndSex_First(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findByageAndSex(
			birthDate, sex, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndSex_Last(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndSex_Last(
			birthDate, sex, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", sex=");
		msg.append(sex);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndSex_Last(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countByageAndSex(birthDate, sex, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findByageAndSex(
			birthDate, sex, questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findByageAndSex_PrevAndNext(
			long entryId, Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		sex = Objects.toString(sex, "");

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getByageAndSex_PrevAndNext(
				session, csclPollsMaster, birthDate, sex, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getByageAndSex_PrevAndNext(
				session, csclPollsMaster, birthDate, sex, questionId,
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

	protected CsclPollsMaster getByageAndSex_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, Date birthDate,
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindBirthDate = false;

		if (birthDate == null) {
			query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_1);
		}
		else {
			bindBirthDate = true;

			query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_2);
		}

		boolean bindSex = false;

		if (sex.isEmpty()) {
			query.append(_FINDER_COLUMN_AGEANDSEX_SEX_3);
		}
		else {
			bindSex = true;

			query.append(_FINDER_COLUMN_AGEANDSEX_SEX_2);
		}

		query.append(_FINDER_COLUMN_AGEANDSEX_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBirthDate) {
			qPos.add(new Timestamp(birthDate.getTime()));
		}

		if (bindSex) {
			qPos.add(sex);
		}

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	@Override
	public void removeByageAndSex(Date birthDate, String sex, long questionId) {
		for (CsclPollsMaster csclPollsMaster :
				findByageAndSex(
					birthDate, sex, questionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countByageAndSex(Date birthDate, String sex, long questionId) {
		sex = Objects.toString(sex, "");

		FinderPath finderPath = _finderPathCountByageAndSex;

		Object[] finderArgs = new Object[] {
			_getTime(birthDate), sex, questionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDSEX_BIRTHDATE_2);
			}

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_AGEANDSEX_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_AGEANDSEX_SEX_2);
			}

			query.append(_FINDER_COLUMN_AGEANDSEX_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_AGEANDSEX_BIRTHDATE_1 =
		"csclPollsMaster.birthDate IS NULL AND ";

	private static final String _FINDER_COLUMN_AGEANDSEX_BIRTHDATE_2 =
		"csclPollsMaster.birthDate = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDSEX_SEX_2 =
		"csclPollsMaster.sex = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDSEX_SEX_3 =
		"(csclPollsMaster.sex IS NULL OR csclPollsMaster.sex = '') AND ";

	private static final String _FINDER_COLUMN_AGEANDSEX_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindByageAndLocality;
	private FinderPath _finderPathWithoutPaginationFindByageAndLocality;
	private FinderPath _finderPathCountByageAndLocality;

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId) {

		return findByageAndLocality(
			birthDate, locality, questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end) {

		return findByageAndLocality(
			birthDate, locality, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByageAndLocality(Date,int,long, int, int, OrderByComparator)}
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findByageAndLocality(
			birthDate, locality, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByageAndLocality;
			finderArgs = new Object[] {
				_getTime(birthDate), locality, questionId
			};
		}
		else {
			finderPath = _finderPathWithPaginationFindByageAndLocality;
			finderArgs = new Object[] {
				_getTime(birthDate), locality, questionId, start, end,
				orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!Objects.equals(
						birthDate, csclPollsMaster.getBirthDate()) ||
					(locality != csclPollsMaster.getLocality()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_2);
			}

			query.append(_FINDER_COLUMN_AGEANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_AGEANDLOCALITY_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				qPos.add(locality);

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndLocality_First(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndLocality_First(
			birthDate, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndLocality_First(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findByageAndLocality(
			birthDate, locality, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndLocality_Last(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndLocality_Last(
			birthDate, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndLocality_Last(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countByageAndLocality(birthDate, locality, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findByageAndLocality(
			birthDate, locality, questionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findByageAndLocality_PrevAndNext(
			long entryId, Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getByageAndLocality_PrevAndNext(
				session, csclPollsMaster, birthDate, locality, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getByageAndLocality_PrevAndNext(
				session, csclPollsMaster, birthDate, locality, questionId,
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

	protected CsclPollsMaster getByageAndLocality_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, Date birthDate,
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindBirthDate = false;

		if (birthDate == null) {
			query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_1);
		}
		else {
			bindBirthDate = true;

			query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_2);
		}

		query.append(_FINDER_COLUMN_AGEANDLOCALITY_LOCALITY_2);

		query.append(_FINDER_COLUMN_AGEANDLOCALITY_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBirthDate) {
			qPos.add(new Timestamp(birthDate.getTime()));
		}

		qPos.add(locality);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	@Override
	public void removeByageAndLocality(
		Date birthDate, int locality, long questionId) {

		for (CsclPollsMaster csclPollsMaster :
				findByageAndLocality(
					birthDate, locality, questionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countByageAndLocality(
		Date birthDate, int locality, long questionId) {

		FinderPath finderPath = _finderPathCountByageAndLocality;

		Object[] finderArgs = new Object[] {
			_getTime(birthDate), locality, questionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_2);
			}

			query.append(_FINDER_COLUMN_AGEANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_AGEANDLOCALITY_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				qPos.add(locality);

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_1 =
		"csclPollsMaster.birthDate IS NULL AND ";

	private static final String _FINDER_COLUMN_AGEANDLOCALITY_BIRTHDATE_2 =
		"csclPollsMaster.birthDate = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDLOCALITY_LOCALITY_2 =
		"csclPollsMaster.locality = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDLOCALITY_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindBysexAndLocality;
	private FinderPath _finderPathWithoutPaginationFindBysexAndLocality;
	private FinderPath _finderPathCountBysexAndLocality;

	/**
	 * Returns all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId) {

		return findBysexAndLocality(
			sex, locality, questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end) {

		return findBysexAndLocality(
			sex, locality, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBysexAndLocality(String,int,long, int, int, OrderByComparator)}
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findBysexAndLocality(
			sex, locality, questionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		sex = Objects.toString(sex, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBysexAndLocality;
			finderArgs = new Object[] {sex, locality, questionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBysexAndLocality;
			finderArgs = new Object[] {
				sex, locality, questionId, start, end, orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!sex.equals(csclPollsMaster.getSex()) ||
					(locality != csclPollsMaster.getLocality()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_2);
			}

			query.append(_FINDER_COLUMN_SEXANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_SEXANDLOCALITY_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(locality);

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBysexAndLocality_First(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBysexAndLocality_First(
			sex, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sex=");
		msg.append(sex);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBysexAndLocality_First(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findBysexAndLocality(
			sex, locality, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findBysexAndLocality_Last(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchBysexAndLocality_Last(
			sex, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("sex=");
		msg.append(sex);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchBysexAndLocality_Last(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countBysexAndLocality(sex, locality, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findBysexAndLocality(
			sex, locality, questionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findBysexAndLocality_PrevAndNext(
			long entryId, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		sex = Objects.toString(sex, "");

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getBysexAndLocality_PrevAndNext(
				session, csclPollsMaster, sex, locality, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getBysexAndLocality_PrevAndNext(
				session, csclPollsMaster, sex, locality, questionId,
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

	protected CsclPollsMaster getBysexAndLocality_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, String sex,
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindSex = false;

		if (sex.isEmpty()) {
			query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_3);
		}
		else {
			bindSex = true;

			query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_2);
		}

		query.append(_FINDER_COLUMN_SEXANDLOCALITY_LOCALITY_2);

		query.append(_FINDER_COLUMN_SEXANDLOCALITY_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindSex) {
			qPos.add(sex);
		}

		qPos.add(locality);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	@Override
	public void removeBysexAndLocality(
		String sex, int locality, long questionId) {

		for (CsclPollsMaster csclPollsMaster :
				findBysexAndLocality(
					sex, locality, questionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countBysexAndLocality(
		String sex, int locality, long questionId) {

		sex = Objects.toString(sex, "");

		FinderPath finderPath = _finderPathCountBysexAndLocality;

		Object[] finderArgs = new Object[] {sex, locality, questionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_SEXANDLOCALITY_SEX_2);
			}

			query.append(_FINDER_COLUMN_SEXANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_SEXANDLOCALITY_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(locality);

				qPos.add(questionId);

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

	private static final String _FINDER_COLUMN_SEXANDLOCALITY_SEX_2 =
		"csclPollsMaster.sex = ? AND ";

	private static final String _FINDER_COLUMN_SEXANDLOCALITY_SEX_3 =
		"(csclPollsMaster.sex IS NULL OR csclPollsMaster.sex = '') AND ";

	private static final String _FINDER_COLUMN_SEXANDLOCALITY_LOCALITY_2 =
		"csclPollsMaster.locality = ? AND ";

	private static final String _FINDER_COLUMN_SEXANDLOCALITY_QUESTIONID_2 =
		"csclPollsMaster.questionId = ?";

	private FinderPath _finderPathWithPaginationFindByageAndSexAndLocality;
	private FinderPath _finderPathWithoutPaginationFindByageAndSexAndLocality;
	private FinderPath _finderPathCountByageAndSexAndLocality;

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		return findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end) {

		return findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByageAndSexAndLocality(Date,String,int,long, int, int, OrderByComparator)}
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator) {

		sex = Objects.toString(sex, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByageAndSexAndLocality;
			finderArgs = new Object[] {
				_getTime(birthDate), sex, locality, questionId
			};
		}
		else {
			finderPath = _finderPathWithPaginationFindByageAndSexAndLocality;
			finderArgs = new Object[] {
				_getTime(birthDate), sex, locality, questionId, start, end,
				orderByComparator
			};
		}

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CsclPollsMaster csclPollsMaster : list) {
				if (!Objects.equals(
						birthDate, csclPollsMaster.getBirthDate()) ||
					!sex.equals(csclPollsMaster.getSex()) ||
					(locality != csclPollsMaster.getLocality()) ||
					(questionId != csclPollsMaster.getQuestionId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_2);
			}

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_2);
			}

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_QUESTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(locality);

				qPos.add(questionId);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndSexAndLocality_First(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndSexAndLocality_First(
			birthDate, sex, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", sex=");
		msg.append(sex);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndSexAndLocality_First(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		List<CsclPollsMaster> list = findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster findByageAndSexAndLocality_Last(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByageAndSexAndLocality_Last(
			birthDate, sex, locality, questionId, orderByComparator);

		if (csclPollsMaster != null) {
			return csclPollsMaster;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("birthDate=");
		msg.append(birthDate);

		msg.append(", sex=");
		msg.append(sex);

		msg.append(", locality=");
		msg.append(locality);

		msg.append(", questionId=");
		msg.append(questionId);

		msg.append("}");

		throw new NoSuchMasterException(msg.toString());
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	@Override
	public CsclPollsMaster fetchByageAndSexAndLocality_Last(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		int count = countByageAndSexAndLocality(
			birthDate, sex, locality, questionId);

		if (count == 0) {
			return null;
		}

		List<CsclPollsMaster> list = findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster[] findByageAndSexAndLocality_PrevAndNext(
			long entryId, Date birthDate, String sex, int locality,
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException {

		sex = Objects.toString(sex, "");

		CsclPollsMaster csclPollsMaster = findByPrimaryKey(entryId);

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster[] array = new CsclPollsMasterImpl[3];

			array[0] = getByageAndSexAndLocality_PrevAndNext(
				session, csclPollsMaster, birthDate, sex, locality, questionId,
				orderByComparator, true);

			array[1] = csclPollsMaster;

			array[2] = getByageAndSexAndLocality_PrevAndNext(
				session, csclPollsMaster, birthDate, sex, locality, questionId,
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

	protected CsclPollsMaster getByageAndSexAndLocality_PrevAndNext(
		Session session, CsclPollsMaster csclPollsMaster, Date birthDate,
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(6);
		}

		query.append(_SQL_SELECT_CSCLPOLLSMASTER_WHERE);

		boolean bindBirthDate = false;

		if (birthDate == null) {
			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_1);
		}
		else {
			bindBirthDate = true;

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_2);
		}

		boolean bindSex = false;

		if (sex.isEmpty()) {
			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_3);
		}
		else {
			bindSex = true;

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_2);
		}

		query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_LOCALITY_2);

		query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_QUESTIONID_2);

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
			query.append(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBirthDate) {
			qPos.add(new Timestamp(birthDate.getTime()));
		}

		if (bindSex) {
			qPos.add(sex);
		}

		qPos.add(locality);

		qPos.add(questionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						csclPollsMaster)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<CsclPollsMaster> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	@Override
	public void removeByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		for (CsclPollsMaster csclPollsMaster :
				findByageAndSexAndLocality(
					birthDate, sex, locality, questionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	@Override
	public int countByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		sex = Objects.toString(sex, "");

		FinderPath finderPath = _finderPathCountByageAndSexAndLocality;

		Object[] finderArgs = new Object[] {
			_getTime(birthDate), sex, locality, questionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CSCLPOLLSMASTER_WHERE);

			boolean bindBirthDate = false;

			if (birthDate == null) {
				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_1);
			}
			else {
				bindBirthDate = true;

				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_2);
			}

			boolean bindSex = false;

			if (sex.isEmpty()) {
				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_3);
			}
			else {
				bindSex = true;

				query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_2);
			}

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_LOCALITY_2);

			query.append(_FINDER_COLUMN_AGEANDSEXANDLOCALITY_QUESTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBirthDate) {
					qPos.add(new Timestamp(birthDate.getTime()));
				}

				if (bindSex) {
					qPos.add(sex);
				}

				qPos.add(locality);

				qPos.add(questionId);

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

	private static final String
		_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_1 =
			"csclPollsMaster.birthDate IS NULL AND ";

	private static final String
		_FINDER_COLUMN_AGEANDSEXANDLOCALITY_BIRTHDATE_2 =
			"csclPollsMaster.birthDate = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_2 =
		"csclPollsMaster.sex = ? AND ";

	private static final String _FINDER_COLUMN_AGEANDSEXANDLOCALITY_SEX_3 =
		"(csclPollsMaster.sex IS NULL OR csclPollsMaster.sex = '') AND ";

	private static final String _FINDER_COLUMN_AGEANDSEXANDLOCALITY_LOCALITY_2 =
		"csclPollsMaster.locality = ? AND ";

	private static final String
		_FINDER_COLUMN_AGEANDSEXANDLOCALITY_QUESTIONID_2 =
			"csclPollsMaster.questionId = ?";

	public CsclPollsMasterPersistenceImpl() {
		setModelClass(CsclPollsMaster.class);

		setModelImplClass(CsclPollsMasterImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl polls master in the entity cache if it is enabled.
	 *
	 * @param csclPollsMaster the cscl polls master
	 */
	@Override
	public void cacheResult(CsclPollsMaster csclPollsMaster) {
		entityCache.putResult(
			entityCacheEnabled, CsclPollsMasterImpl.class,
			csclPollsMaster.getPrimaryKey(), csclPollsMaster);

		csclPollsMaster.resetOriginalValues();
	}

	/**
	 * Caches the cscl polls masters in the entity cache if it is enabled.
	 *
	 * @param csclPollsMasters the cscl polls masters
	 */
	@Override
	public void cacheResult(List<CsclPollsMaster> csclPollsMasters) {
		for (CsclPollsMaster csclPollsMaster : csclPollsMasters) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclPollsMasterImpl.class,
					csclPollsMaster.getPrimaryKey()) == null) {

				cacheResult(csclPollsMaster);
			}
			else {
				csclPollsMaster.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl polls masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclPollsMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl polls master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclPollsMaster csclPollsMaster) {
		entityCache.removeResult(
			entityCacheEnabled, CsclPollsMasterImpl.class,
			csclPollsMaster.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclPollsMaster> csclPollsMasters) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclPollsMaster csclPollsMaster : csclPollsMasters) {
			entityCache.removeResult(
				entityCacheEnabled, CsclPollsMasterImpl.class,
				csclPollsMaster.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl polls master with the primary key. Does not add the cscl polls master to the database.
	 *
	 * @param entryId the primary key for the new cscl polls master
	 * @return the new cscl polls master
	 */
	@Override
	public CsclPollsMaster create(long entryId) {
		CsclPollsMaster csclPollsMaster = new CsclPollsMasterImpl();

		csclPollsMaster.setNew(true);
		csclPollsMaster.setPrimaryKey(entryId);

		return csclPollsMaster;
	}

	/**
	 * Removes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster remove(long entryId) throws NoSuchMasterException {
		return remove((Serializable)entryId);
	}

	/**
	 * Removes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster remove(Serializable primaryKey)
		throws NoSuchMasterException {

		Session session = null;

		try {
			session = openSession();

			CsclPollsMaster csclPollsMaster = (CsclPollsMaster)session.get(
				CsclPollsMasterImpl.class, primaryKey);

			if (csclPollsMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclPollsMaster);
		}
		catch (NoSuchMasterException nsee) {
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
	protected CsclPollsMaster removeImpl(CsclPollsMaster csclPollsMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclPollsMaster)) {
				csclPollsMaster = (CsclPollsMaster)session.get(
					CsclPollsMasterImpl.class,
					csclPollsMaster.getPrimaryKeyObj());
			}

			if (csclPollsMaster != null) {
				session.delete(csclPollsMaster);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclPollsMaster != null) {
			clearCache(csclPollsMaster);
		}

		return csclPollsMaster;
	}

	@Override
	public CsclPollsMaster updateImpl(CsclPollsMaster csclPollsMaster) {
		boolean isNew = csclPollsMaster.isNew();

		if (!(csclPollsMaster instanceof CsclPollsMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(csclPollsMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					csclPollsMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in csclPollsMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CsclPollsMaster implementation " +
					csclPollsMaster.getClass());
		}

		CsclPollsMasterModelImpl csclPollsMasterModelImpl =
			(CsclPollsMasterModelImpl)csclPollsMaster;

		Session session = null;

		try {
			session = openSession();

			if (csclPollsMaster.isNew()) {
				session.save(csclPollsMaster);

				csclPollsMaster.setNew(false);
			}
			else {
				csclPollsMaster = (CsclPollsMaster)session.merge(
					csclPollsMaster);
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
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountBypollId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBypollId, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getSex(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountBysex, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBysex, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getLocality(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountBylocality, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBylocality, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getBirthDate(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountByage, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByage, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getBirthDate(),
				csclPollsMasterModelImpl.getSex(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountByageAndSex, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByageAndSex, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getBirthDate(),
				csclPollsMasterModelImpl.getLocality(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountByageAndLocality, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByageAndLocality, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getSex(),
				csclPollsMasterModelImpl.getLocality(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(_finderPathCountBysexAndLocality, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBysexAndLocality, args);

			args = new Object[] {
				csclPollsMasterModelImpl.getBirthDate(),
				csclPollsMasterModelImpl.getSex(),
				csclPollsMasterModelImpl.getLocality(),
				csclPollsMasterModelImpl.getQuestionId()
			};

			finderCache.removeResult(
				_finderPathCountByageAndSexAndLocality, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByageAndSexAndLocality, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBypollId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountBypollId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypollId, args);

				args = new Object[] {csclPollsMasterModelImpl.getQuestionId()};

				finderCache.removeResult(_finderPathCountBypollId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBypollId, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBysex.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalSex(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountBysex, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBysex, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getSex(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(_finderPathCountBysex, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBysex, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBylocality.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalLocality(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountBylocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBylocality, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getLocality(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(_finderPathCountBylocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBylocality, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByage.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalBirthDate(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountByage, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByage, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getBirthDate(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(_finderPathCountByage, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByage, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByageAndSex.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalBirthDate(),
					csclPollsMasterModelImpl.getOriginalSex(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(_finderPathCountByageAndSex, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndSex, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getBirthDate(),
					csclPollsMasterModelImpl.getSex(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(_finderPathCountByageAndSex, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndSex, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByageAndLocality.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalBirthDate(),
					csclPollsMasterModelImpl.getOriginalLocality(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountByageAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndLocality, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getBirthDate(),
					csclPollsMasterModelImpl.getLocality(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountByageAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndLocality, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBysexAndLocality.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalSex(),
					csclPollsMasterModelImpl.getOriginalLocality(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountBysexAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBysexAndLocality, args);

				args = new Object[] {
					csclPollsMasterModelImpl.getSex(),
					csclPollsMasterModelImpl.getLocality(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountBysexAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBysexAndLocality, args);
			}

			if ((csclPollsMasterModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByageAndSexAndLocality.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					csclPollsMasterModelImpl.getOriginalBirthDate(),
					csclPollsMasterModelImpl.getOriginalSex(),
					csclPollsMasterModelImpl.getOriginalLocality(),
					csclPollsMasterModelImpl.getOriginalQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountByageAndSexAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndSexAndLocality,
					args);

				args = new Object[] {
					csclPollsMasterModelImpl.getBirthDate(),
					csclPollsMasterModelImpl.getSex(),
					csclPollsMasterModelImpl.getLocality(),
					csclPollsMasterModelImpl.getQuestionId()
				};

				finderCache.removeResult(
					_finderPathCountByageAndSexAndLocality, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByageAndSexAndLocality,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, CsclPollsMasterImpl.class,
			csclPollsMaster.getPrimaryKey(), csclPollsMaster, false);

		csclPollsMaster.resetOriginalValues();

		return csclPollsMaster;
	}

	/**
	 * Returns the cscl polls master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterException {

		CsclPollsMaster csclPollsMaster = fetchByPrimaryKey(primaryKey);

		if (csclPollsMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclPollsMaster;
	}

	/**
	 * Returns the cscl polls master with the primary key or throws a <code>NoSuchMasterException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster findByPrimaryKey(long entryId)
		throws NoSuchMasterException {

		return findByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns the cscl polls master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master, or <code>null</code> if a cscl polls master with the primary key could not be found
	 */
	@Override
	public CsclPollsMaster fetchByPrimaryKey(long entryId) {
		return fetchByPrimaryKey((Serializable)entryId);
	}

	/**
	 * Returns all the cscl polls masters.
	 *
	 * @return the cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl polls masters
	 */
	@Deprecated
	@Override
	public List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl polls masters
	 */
	@Override
	public List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

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

		List<CsclPollsMaster> list =
			(List<CsclPollsMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLPOLLSMASTER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLPOLLSMASTER;

				if (pagination) {
					sql = sql.concat(CsclPollsMasterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclPollsMaster>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsMaster>)QueryUtil.list(
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
	 * Removes all the cscl polls masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclPollsMaster csclPollsMaster : findAll()) {
			remove(csclPollsMaster);
		}
	}

	/**
	 * Returns the number of cscl polls masters.
	 *
	 * @return the number of cscl polls masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLPOLLSMASTER);

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
		return "entryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLPOLLSMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclPollsMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl polls master persistence.
	 */
	@Activate
	public void activate() {
		CsclPollsMasterModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclPollsMasterModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindBypollId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBypollId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBypollId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBypollId",
			new String[] {Long.class.getName()},
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountBypollId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBypollId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBysex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysex",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBysex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysex",
			new String[] {String.class.getName(), Long.class.getName()},
			CsclPollsMasterModelImpl.SEX_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountBysex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysex",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindBylocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBylocality",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBylocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBylocality",
			new String[] {Integer.class.getName(), Long.class.getName()},
			CsclPollsMasterModelImpl.LOCALITY_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountBylocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBylocality",
			new String[] {Integer.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByage = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByage",
			new String[] {
				Date.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByage = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByage",
			new String[] {Date.class.getName(), Long.class.getName()},
			CsclPollsMasterModelImpl.BIRTHDATE_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByage = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByage",
			new String[] {Date.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByageAndSex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByageAndSex",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByageAndSex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByageAndSex",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			},
			CsclPollsMasterModelImpl.BIRTHDATE_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.SEX_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByageAndSex = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByageAndSex",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByageAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByageAndLocality",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByageAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByageAndLocality",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			CsclPollsMasterModelImpl.BIRTHDATE_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.LOCALITY_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByageAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByageAndLocality",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindBysexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBysexAndLocality",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBysexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBysexAndLocality",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			CsclPollsMasterModelImpl.SEX_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.LOCALITY_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountBysexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBysexAndLocality",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

		_finderPathWithPaginationFindByageAndSexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByageAndSexAndLocality",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByageAndSexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsMasterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByageAndSexAndLocality",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Long.class.getName()
			},
			CsclPollsMasterModelImpl.BIRTHDATE_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.SEX_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.LOCALITY_COLUMN_BITMASK |
			CsclPollsMasterModelImpl.QUESTIONID_COLUMN_BITMASK);

		_finderPathCountByageAndSexAndLocality = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByageAndSexAndLocality",
			new String[] {
				Date.class.getName(), String.class.getName(),
				Integer.class.getName(), Long.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclPollsMasterImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.cscl.polls.model.CsclPollsMaster"),
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_CSCLPOLLSMASTER =
		"SELECT csclPollsMaster FROM CsclPollsMaster csclPollsMaster";

	private static final String _SQL_SELECT_CSCLPOLLSMASTER_WHERE =
		"SELECT csclPollsMaster FROM CsclPollsMaster csclPollsMaster WHERE ";

	private static final String _SQL_COUNT_CSCLPOLLSMASTER =
		"SELECT COUNT(csclPollsMaster) FROM CsclPollsMaster csclPollsMaster";

	private static final String _SQL_COUNT_CSCLPOLLSMASTER_WHERE =
		"SELECT COUNT(csclPollsMaster) FROM CsclPollsMaster csclPollsMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclPollsMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclPollsMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CsclPollsMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclPollsMasterPersistenceImpl.class);

	static {
		try {
			Class.forName(CsclPollsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}