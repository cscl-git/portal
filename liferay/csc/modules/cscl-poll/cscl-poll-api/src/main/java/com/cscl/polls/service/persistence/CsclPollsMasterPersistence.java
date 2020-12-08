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

import com.cscl.polls.exception.NoSuchMasterException;
import com.cscl.polls.model.CsclPollsMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl polls master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterUtil
 * @generated
 */
@ProviderType
public interface CsclPollsMasterPersistence
	extends BasePersistence<CsclPollsMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclPollsMasterUtil} to access the cscl polls master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findBypollId(long questionId);

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
	public java.util.List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findBypollId(
		long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBypollId_First(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBypollId_First(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBypollId_Last(
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBypollId_Last(
		long questionId, OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the cscl polls masters before and after the current cscl polls master in the ordered set where questionId = &#63;.
	 *
	 * @param entryId the primary key of the current cscl polls master
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	public CsclPollsMaster[] findBypollId_PrevAndNext(
			long entryId, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where questionId = &#63; from the database.
	 *
	 * @param questionId the question ID
	 */
	public void removeBypollId(long questionId);

	/**
	 * Returns the number of cscl polls masters where questionId = &#63;.
	 *
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countBypollId(long questionId);

	/**
	 * Returns all the cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findBysex(
		String sex, long questionId);

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
	public java.util.List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findBysex(
		String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBysex_First(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBysex_First(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBysex_Last(
			String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBysex_Last(
		String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findBysex_PrevAndNext(
			long entryId, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	public void removeBysex(String sex, long questionId);

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countBysex(String sex, long questionId);

	/**
	 * Returns all the cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findBylocality(
		int locality, long questionId);

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
	public java.util.List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findBylocality(
		int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the first cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBylocality_First(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBylocality_First(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the last cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findBylocality_Last(
			int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBylocality_Last(
		int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findBylocality_PrevAndNext(
			long entryId, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public void removeBylocality(int locality, long questionId);

	/**
	 * Returns the number of cscl polls masters where locality = &#63; and questionId = &#63;.
	 *
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countBylocality(int locality, long questionId);

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findByage(
		Date birthDate, long questionId);

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
	public java.util.List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findByage(
		Date birthDate, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findByage_First(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByage_First(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master
	 * @throws NoSuchMasterException if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster findByage_Last(
			Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByage_Last(
		Date birthDate, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findByage_PrevAndNext(
			long entryId, Date birthDate, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 */
	public void removeByage(Date birthDate, long questionId);

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countByage(Date birthDate, long questionId);

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId);

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
	public java.util.List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findByageAndSex(
		Date birthDate, String sex, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndSex_First(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByageAndSex_First(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndSex_Last(
			Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByageAndSex_Last(
		Date birthDate, String sex, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findByageAndSex_PrevAndNext(
			long entryId, Date birthDate, String sex, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 */
	public void removeByageAndSex(Date birthDate, String sex, long questionId);

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and sex = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countByageAndSex(Date birthDate, String sex, long questionId);

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId);

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
	public java.util.List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findByageAndLocality(
		Date birthDate, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndLocality_First(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByageAndLocality_First(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndLocality_Last(
			Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchByageAndLocality_Last(
		Date birthDate, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findByageAndLocality_PrevAndNext(
			long entryId, Date birthDate, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public void removeByageAndLocality(
		Date birthDate, int locality, long questionId);

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countByageAndLocality(
		Date birthDate, int locality, long questionId);

	/**
	 * Returns all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId);

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
	public java.util.List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end);

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
	public java.util.List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findBysexAndLocality(
		String sex, int locality, long questionId, int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findBysexAndLocality_First(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the first cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBysexAndLocality_First(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findBysexAndLocality_Last(
			String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Returns the last cscl polls master in the ordered set where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl polls master, or <code>null</code> if a matching cscl polls master could not be found
	 */
	public CsclPollsMaster fetchBysexAndLocality_Last(
		String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findBysexAndLocality_PrevAndNext(
			long entryId, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public void removeBysexAndLocality(
		String sex, int locality, long questionId);

	/**
	 * Returns the number of cscl polls masters where sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countBysexAndLocality(String sex, int locality, long questionId);

	/**
	 * Returns all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the matching cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId);

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
	public java.util.List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end);

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
	public java.util.List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId, int start,
		int end, OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndSexAndLocality_First(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

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
	public CsclPollsMaster fetchByageAndSexAndLocality_First(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster findByageAndSexAndLocality_Last(
			Date birthDate, String sex, int locality, long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

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
	public CsclPollsMaster fetchByageAndSexAndLocality_Last(
		Date birthDate, String sex, int locality, long questionId,
		OrderByComparator<CsclPollsMaster> orderByComparator);

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
	public CsclPollsMaster[] findByageAndSexAndLocality_PrevAndNext(
			long entryId, Date birthDate, String sex, int locality,
			long questionId,
			OrderByComparator<CsclPollsMaster> orderByComparator)
		throws NoSuchMasterException;

	/**
	 * Removes all the cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63; from the database.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 */
	public void removeByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId);

	/**
	 * Returns the number of cscl polls masters where birthDate = &#63; and sex = &#63; and locality = &#63; and questionId = &#63;.
	 *
	 * @param birthDate the birth date
	 * @param sex the sex
	 * @param locality the locality
	 * @param questionId the question ID
	 * @return the number of matching cscl polls masters
	 */
	public int countByageAndSexAndLocality(
		Date birthDate, String sex, int locality, long questionId);

	/**
	 * Caches the cscl polls master in the entity cache if it is enabled.
	 *
	 * @param csclPollsMaster the cscl polls master
	 */
	public void cacheResult(CsclPollsMaster csclPollsMaster);

	/**
	 * Caches the cscl polls masters in the entity cache if it is enabled.
	 *
	 * @param csclPollsMasters the cscl polls masters
	 */
	public void cacheResult(java.util.List<CsclPollsMaster> csclPollsMasters);

	/**
	 * Creates a new cscl polls master with the primary key. Does not add the cscl polls master to the database.
	 *
	 * @param entryId the primary key for the new cscl polls master
	 * @return the new cscl polls master
	 */
	public CsclPollsMaster create(long entryId);

	/**
	 * Removes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	public CsclPollsMaster remove(long entryId) throws NoSuchMasterException;

	public CsclPollsMaster updateImpl(CsclPollsMaster csclPollsMaster);

	/**
	 * Returns the cscl polls master with the primary key or throws a <code>NoSuchMasterException</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws NoSuchMasterException if a cscl polls master with the primary key could not be found
	 */
	public CsclPollsMaster findByPrimaryKey(long entryId)
		throws NoSuchMasterException;

	/**
	 * Returns the cscl polls master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master, or <code>null</code> if a cscl polls master with the primary key could not be found
	 */
	public CsclPollsMaster fetchByPrimaryKey(long entryId);

	/**
	 * Returns all the cscl polls masters.
	 *
	 * @return the cscl polls masters
	 */
	public java.util.List<CsclPollsMaster> findAll();

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
	public java.util.List<CsclPollsMaster> findAll(int start, int end);

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
	public java.util.List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclPollsMaster> findAll(
		int start, int end,
		OrderByComparator<CsclPollsMaster> orderByComparator);

	/**
	 * Removes all the cscl polls masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl polls masters.
	 *
	 * @return the number of cscl polls masters
	 */
	public int countAll();

}