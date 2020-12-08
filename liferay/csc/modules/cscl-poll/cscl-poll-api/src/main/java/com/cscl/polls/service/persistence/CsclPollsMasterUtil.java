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

package com.cscl.polls.service.persistence;

import com.cscl.polls.model.CsclPollsMaster;

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
 * The persistence utility for the cscl polls master service. This utility wraps <code>com.cscl.polls.service.persistence.impl.CsclPollsMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterPersistence
 * @generated
 */
@ProviderType
public class CsclPollsMasterUtil {

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
	public static void clearCache(CsclPollsMaster csclPollsMaster) {
		getPersistence().clearCache(csclPollsMaster);
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
	public static Map<Serializable, CsclPollsMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclPollsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclPollsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclPollsMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclPollsMaster update(CsclPollsMaster csclPollsMaster) {
		return getPersistence().update(csclPollsMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclPollsMaster update(
		CsclPollsMaster csclPollsMaster, ServiceContext serviceContext) {

		return getPersistence().update(csclPollsMaster, serviceContext);
	}

	/**
	 * Returns all the cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findBypollId(long questionId) {
		return getPersistence().findBypollId(questionId);
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
	public static List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end) {

		return getPersistence().findBypollId(questionId, start, end);
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
	public static List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBypollId(
			questionId, start, end, orderByComparator, useFinderCache);
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
	public static List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findBypollId(
			questionId, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster findBypollId_First(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBypollId_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBypollId_First(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBypollId_First(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster findBypollId_Last(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBypollId_Last(
			questionId, orderByComparator);
	}

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBypollId_Last(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBypollId_Last(
			questionId, orderByComparator);
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
	public static CsclPollsMaster[] findBypollId_PrevAndNext(
			long entryId, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBypollId_PrevAndNext(
			entryId, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	public static void removeBypollId(long questionId) {
		getPersistence().removeBypollId(questionId);
	}

	/**
	 * Returns the number of cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countBypollId(long questionId) {
		return getPersistence().countBypollId(questionId);
	}

	/**
	 * Returns all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findBysex(String sex, long questionId) {
		return getPersistence().findBysex(sex, questionId);
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
	public static List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end) {

		return getPersistence().findBysex(sex, questionId, start, end);
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
	public static List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysex(
			sex, questionId, start, end, orderByComparator, useFinderCache);
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
	public static List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findBysex(
			sex, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findBysex_First(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysex_First(
			sex, questionId, orderByComparator);
	}

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBysex_First(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBysex_First(
			sex, questionId, orderByComparator);
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
	public static CsclPollsMaster findBysex_Last(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysex_Last(
			sex, questionId, orderByComparator);
	}

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBysex_Last(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBysex_Last(
			sex, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findBysex_PrevAndNext(
			long entryId, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysex_PrevAndNext(
			entryId, sex, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	public static void removeBysex(String sex, long questionId) {
		getPersistence().removeBysex(sex, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countBysex(String sex, long questionId) {
		return getPersistence().countBysex(sex, questionId);
	}

	/**
	 * Returns all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findBylocality(
		int locality, long questionId) {

		return getPersistence().findBylocality(locality, questionId);
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
	public static List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end) {

		return getPersistence().findBylocality(
			locality, questionId, start, end);
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
	public static List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBylocality(
			locality, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findBylocality(
			locality, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findBylocality_First(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBylocality_First(
			locality, questionId, orderByComparator);
	}

	/**
	 * Returns the first cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBylocality_First(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBylocality_First(
			locality, questionId, orderByComparator);
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
	public static CsclPollsMaster findBylocality_Last(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBylocality_Last(
			locality, questionId, orderByComparator);
	}

	/**
	 * Returns the last cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchBylocality_Last(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBylocality_Last(
			locality, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findBylocality_PrevAndNext(
			long entryId, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBylocality_PrevAndNext(
			entryId, locality, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public static void removeBylocality(int locality, long questionId) {
		getPersistence().removeBylocality(locality, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countBylocality(int locality, long questionId) {
		return getPersistence().countBylocality(locality, questionId);
	}

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findByage(
		Date birthDate, long questionId) {

		return getPersistence().findByage(birthDate, questionId);
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
	public static List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end) {

		return getPersistence().findByage(birthDate, questionId, start, end);
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
	public static List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByage(
			birthDate, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findByage(
			birthDate, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findByage_First(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByage_First(
			birthDate, questionId, orderByComparator);
	}

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchByage_First(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByage_First(
			birthDate, questionId, orderByComparator);
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
	public static CsclPollsMaster findByage_Last(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByage_Last(
			birthDate, questionId, orderByComparator);
	}

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public static CsclPollsMaster fetchByage_Last(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByage_Last(
			birthDate, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findByage_PrevAndNext(
			long entryId, Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByage_PrevAndNext(
			entryId, birthDate, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 */
	public static void removeByage(Date birthDate, long questionId) {
		getPersistence().removeByage(birthDate, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countByage(Date birthDate, long questionId) {
		return getPersistence().countByage(birthDate, questionId);
	}

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId) {

		return getPersistence().findByageAndSex(birthDate, sex, questionId);
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
	public static List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end) {

		return getPersistence().findByageAndSex(
			birthDate, sex, questionId, start, end);
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
	public static List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByageAndSex(
			birthDate, sex, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findByageAndSex(
			birthDate, sex, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findByageAndSex_First(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSex_First(
			birthDate, sex, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndSex_First(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndSex_First(
			birthDate, sex, questionId, orderByComparator);
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
	public static CsclPollsMaster findByageAndSex_Last(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSex_Last(
			birthDate, sex, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndSex_Last(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndSex_Last(
			birthDate, sex, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findByageAndSex_PrevAndNext(
			long entryId, Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSex_PrevAndNext(
			entryId, birthDate, sex, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	public static void removeByageAndSex(
		Date birthDate, String sex, long questionId) {

		getPersistence().removeByageAndSex(birthDate, sex, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countByageAndSex(
		Date birthDate, String sex, long questionId) {

		return getPersistence().countByageAndSex(birthDate, sex, questionId);
	}

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId) {

		return getPersistence().findByageAndLocality(
			birthDate, locality, questionId);
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
	public static List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end) {

		return getPersistence().findByageAndLocality(
			birthDate, locality, questionId, start, end);
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
	public static List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByageAndLocality(
			birthDate, locality, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findByageAndLocality(
			birthDate, locality, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findByageAndLocality_First(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndLocality_First(
			birthDate, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndLocality_First(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndLocality_First(
			birthDate, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster findByageAndLocality_Last(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndLocality_Last(
			birthDate, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndLocality_Last(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndLocality_Last(
			birthDate, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findByageAndLocality_PrevAndNext(
			long entryId, Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndLocality_PrevAndNext(
			entryId, birthDate, locality, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public static void removeByageAndLocality(
		Date birthDate, int locality, long questionId) {

		getPersistence().removeByageAndLocality(
			birthDate, locality, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countByageAndLocality(
		Date birthDate, int locality, long questionId) {

		return getPersistence().countByageAndLocality(
			birthDate, locality, questionId);
	}

	/**
	 * Returns all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId) {

		return getPersistence().findBysexAndLocality(sex, locality, questionId);
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
	public static List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end) {

		return getPersistence().findBysexAndLocality(
			sex, locality, questionId, start, end);
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
	public static List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBysexAndLocality(
			sex, locality, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findBysexAndLocality(
			sex, locality, questionId, start, end, orderByComparator);
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
	public static CsclPollsMaster findBysexAndLocality_First(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysexAndLocality_First(
			sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchBysexAndLocality_First(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBysexAndLocality_First(
			sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster findBysexAndLocality_Last(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysexAndLocality_Last(
			sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchBysexAndLocality_Last(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchBysexAndLocality_Last(
			sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findBysexAndLocality_PrevAndNext(
			long entryId, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findBysexAndLocality_PrevAndNext(
			entryId, sex, locality, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public static void removeBysexAndLocality(
		String sex, int locality, long questionId) {

		getPersistence().removeBysexAndLocality(sex, locality, questionId);
	}

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public static int countBysexAndLocality(
		String sex, int locality, long questionId) {

		return getPersistence().countBysexAndLocality(
			sex, locality, questionId);
	}

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public static List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		return getPersistence().findByageAndSexAndLocality(
			birthDate, sex, locality, questionId);
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
	public static List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end) {

		return getPersistence().findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, start, end);
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
	public static List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, start, end, orderByComparator,
			useFinderCache);
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
	public static List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findByageAndSexAndLocality(
			birthDate, sex, locality, questionId, start, end,
			orderByComparator);
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
	public static CsclPollsMaster findByageAndSexAndLocality_First(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSexAndLocality_First(
			birthDate, sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndSexAndLocality_First(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndSexAndLocality_First(
			birthDate, sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster findByageAndSexAndLocality_Last(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSexAndLocality_Last(
			birthDate, sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster fetchByageAndSexAndLocality_Last(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().fetchByageAndSexAndLocality_Last(
			birthDate, sex, locality, questionId, orderByComparator);
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
	public static CsclPollsMaster[] findByageAndSexAndLocality_PrevAndNext(
			long entryId, Date birthDate, String sex, int locality,
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByageAndSexAndLocality_PrevAndNext(
			entryId, birthDate, sex, locality, questionId, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public static void removeByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		getPersistence().removeByageAndSexAndLocality(
			birthDate, sex, locality, questionId);
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
	public static int countByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId) {

		return getPersistence().countByageAndSexAndLocality(
			birthDate, sex, locality, questionId);
	}

	/**
	 * Caches the cscl polls master in the entity cache if it is enabled.
	 *
	 * @param csclPollsMaster the cscl polls master
	 */
	public static void cacheResult(CsclPollsMaster csclPollsMaster) {
		getPersistence().cacheResult(csclPollsMaster);
	}

	/**
	 * Caches the cscl polls masters in the entity cache if it is enabled.
	 *
	 * @param csclPollsMasters the cscl polls masters
	 */
	public static void cacheResult(List<CsclPollsMaster> csclPollsMasters) {
		getPersistence().cacheResult(csclPollsMasters);
	}

	/**
	 * Creates a new cscl polls master with the primary key. Does not add the cscl polls master to the database.
	 *
	 * @param entryId the primary key for the new cscl polls master
	 * @return the new cscl polls master
	 */
	public static CsclPollsMaster create(long entryId) {
		return getPersistence().create(entryId);
	}

	/**
	 * Removes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	public static CsclPollsMaster remove(long entryId)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().remove(entryId);
	}

	public static CsclPollsMaster updateImpl(CsclPollsMaster csclPollsMaster) {
		return getPersistence().updateImpl(csclPollsMaster);
	}

	/**
	 * Returns the cscl polls master with the primary key or throws a <code>NoSuchMasterException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	public static CsclPollsMaster findByPrimaryKey(long entryId)
		throws com.cscl.polls.exception.NoSuchMasterException {

		return getPersistence().findByPrimaryKey(entryId);
	}

	/**
	 * Returns the cscl polls master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master, or <code>null</code> if a cscl polls master with the primary key could not be found
	 */
	public static CsclPollsMaster fetchByPrimaryKey(long entryId) {
		return getPersistence().fetchByPrimaryKey(entryId);
	}

	/**
	 * Returns all the cscl polls masters.
	 *
	 * @return the cscl polls masters
	 */
	public static List<CsclPollsMaster> findAll() {
		return getPersistence().findAll();
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
	public static List<CsclPollsMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl polls masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl polls masters.
	 *
	 * @return the number of cscl polls masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclPollsMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclPollsMasterPersistence, CsclPollsMasterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclPollsMasterPersistence.class);

		ServiceTracker<CsclPollsMasterPersistence, CsclPollsMasterPersistence>
			serviceTracker =
				new ServiceTracker
					<CsclPollsMasterPersistence, CsclPollsMasterPersistence>(
						bundle.getBundleContext(),
						CsclPollsMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}