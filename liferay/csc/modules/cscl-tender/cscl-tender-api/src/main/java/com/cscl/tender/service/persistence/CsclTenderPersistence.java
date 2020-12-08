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

package com.cscl.tender.service.persistence;

import com.cscl.tender.exception.NoSuchCsclTenderException;
import com.cscl.tender.model.CsclTender;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl tender service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderUtil
 * @generated
 */
@ProviderType
public interface CsclTenderPersistence extends BasePersistence<CsclTender> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclTenderUtil} to access the cscl tender persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching cscl tenders
	 */
	public java.util.List<CsclTender> findByUuid(String uuid);

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
	public java.util.List<CsclTender> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclTender> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public CsclTender findByUuid_First(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Returns the first cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public CsclTender fetchByUuid_First(
		String uuid, OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public CsclTender findByUuid_Last(
			String uuid, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Returns the last cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public CsclTender fetchByUuid_Last(
		String uuid, OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the cscl tenders before and after the current cscl tender in the ordered set where uuid = &#63;.
	 *
	 * @param tenderId the primary key of the current cscl tender
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public CsclTender[] findByUuid_PrevAndNext(
			long tenderId, String uuid,
			OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Removes all the cscl tenders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of cscl tenders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching cscl tenders
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching cscl tenders
	 */
	public java.util.List<CsclTender> findBystatus(int status);

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
	public java.util.List<CsclTender> findBystatus(
		int status, int start, int end);

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
	public java.util.List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclTender> findBystatus(
		int status, int start, int end,
		OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public CsclTender findBystatus_First(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Returns the first cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public CsclTender fetchBystatus_First(
		int status, OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender
	 * @throws NoSuchCsclTenderException if a matching cscl tender could not be found
	 */
	public CsclTender findBystatus_Last(
			int status, OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Returns the last cscl tender in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl tender, or <code>null</code> if a matching cscl tender could not be found
	 */
	public CsclTender fetchBystatus_Last(
		int status, OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Returns the cscl tenders before and after the current cscl tender in the ordered set where status = &#63;.
	 *
	 * @param tenderId the primary key of the current cscl tender
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public CsclTender[] findBystatus_PrevAndNext(
			long tenderId, int status,
			OrderByComparator<CsclTender> orderByComparator)
		throws NoSuchCsclTenderException;

	/**
	 * Removes all the cscl tenders where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeBystatus(int status);

	/**
	 * Returns the number of cscl tenders where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching cscl tenders
	 */
	public int countBystatus(int status);

	/**
	 * Caches the cscl tender in the entity cache if it is enabled.
	 *
	 * @param csclTender the cscl tender
	 */
	public void cacheResult(CsclTender csclTender);

	/**
	 * Caches the cscl tenders in the entity cache if it is enabled.
	 *
	 * @param csclTenders the cscl tenders
	 */
	public void cacheResult(java.util.List<CsclTender> csclTenders);

	/**
	 * Creates a new cscl tender with the primary key. Does not add the cscl tender to the database.
	 *
	 * @param tenderId the primary key for the new cscl tender
	 * @return the new cscl tender
	 */
	public CsclTender create(long tenderId);

	/**
	 * Removes the cscl tender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender that was removed
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public CsclTender remove(long tenderId) throws NoSuchCsclTenderException;

	public CsclTender updateImpl(CsclTender csclTender);

	/**
	 * Returns the cscl tender with the primary key or throws a <code>NoSuchCsclTenderException</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender
	 * @throws NoSuchCsclTenderException if a cscl tender with the primary key could not be found
	 */
	public CsclTender findByPrimaryKey(long tenderId)
		throws NoSuchCsclTenderException;

	/**
	 * Returns the cscl tender with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender, or <code>null</code> if a cscl tender with the primary key could not be found
	 */
	public CsclTender fetchByPrimaryKey(long tenderId);

	/**
	 * Returns all the cscl tenders.
	 *
	 * @return the cscl tenders
	 */
	public java.util.List<CsclTender> findAll();

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
	public java.util.List<CsclTender> findAll(int start, int end);

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
	public java.util.List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclTender> findAll(
		int start, int end, OrderByComparator<CsclTender> orderByComparator);

	/**
	 * Removes all the cscl tenders from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl tenders.
	 *
	 * @return the number of cscl tenders
	 */
	public int countAll();

}