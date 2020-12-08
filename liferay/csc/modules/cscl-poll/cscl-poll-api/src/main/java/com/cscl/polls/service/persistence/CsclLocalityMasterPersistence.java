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

import com.cscl.polls.exception.NoSuchCsclLocalityMasterException;
import com.cscl.polls.model.CsclLocalityMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl locality master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclLocalityMasterUtil
 * @generated
 */
@ProviderType
public interface CsclLocalityMasterPersistence
	extends BasePersistence<CsclLocalityMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclLocalityMasterUtil} to access the cscl locality master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl locality masters
	 */
	public java.util.List<CsclLocalityMaster> findByisActive(Boolean isActive);

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
	public java.util.List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end);

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
	public java.util.List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclLocalityMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator);

	/**
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	public CsclLocalityMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException;

	/**
	 * Returns the first cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	public CsclLocalityMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator);

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a matching cscl locality master could not be found
	 */
	public CsclLocalityMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException;

	/**
	 * Returns the last cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl locality master, or <code>null</code> if a matching cscl locality master could not be found
	 */
	public CsclLocalityMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclLocalityMaster> orderByComparator);

	/**
	 * Returns the cscl locality masters before and after the current cscl locality master in the ordered set where isActive = &#63;.
	 *
	 * @param localityId the primary key of the current cscl locality master
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public CsclLocalityMaster[] findByisActive_PrevAndNext(
			long localityId, Boolean isActive,
			OrderByComparator<CsclLocalityMaster> orderByComparator)
		throws NoSuchCsclLocalityMasterException;

	/**
	 * Removes all the cscl locality masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByisActive(Boolean isActive);

	/**
	 * Returns the number of cscl locality masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl locality masters
	 */
	public int countByisActive(Boolean isActive);

	/**
	 * Caches the cscl locality master in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 */
	public void cacheResult(CsclLocalityMaster csclLocalityMaster);

	/**
	 * Caches the cscl locality masters in the entity cache if it is enabled.
	 *
	 * @param csclLocalityMasters the cscl locality masters
	 */
	public void cacheResult(
		java.util.List<CsclLocalityMaster> csclLocalityMasters);

	/**
	 * Creates a new cscl locality master with the primary key. Does not add the cscl locality master to the database.
	 *
	 * @param localityId the primary key for the new cscl locality master
	 * @return the new cscl locality master
	 */
	public CsclLocalityMaster create(long localityId);

	/**
	 * Removes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public CsclLocalityMaster remove(long localityId)
		throws NoSuchCsclLocalityMasterException;

	public CsclLocalityMaster updateImpl(CsclLocalityMaster csclLocalityMaster);

	/**
	 * Returns the cscl locality master with the primary key or throws a <code>NoSuchCsclLocalityMasterException</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws NoSuchCsclLocalityMasterException if a cscl locality master with the primary key could not be found
	 */
	public CsclLocalityMaster findByPrimaryKey(long localityId)
		throws NoSuchCsclLocalityMasterException;

	/**
	 * Returns the cscl locality master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master, or <code>null</code> if a cscl locality master with the primary key could not be found
	 */
	public CsclLocalityMaster fetchByPrimaryKey(long localityId);

	/**
	 * Returns all the cscl locality masters.
	 *
	 * @return the cscl locality masters
	 */
	public java.util.List<CsclLocalityMaster> findAll();

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
	public java.util.List<CsclLocalityMaster> findAll(int start, int end);

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
	public java.util.List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclLocalityMaster> findAll(
		int start, int end,
		OrderByComparator<CsclLocalityMaster> orderByComparator);

	/**
	 * Removes all the cscl locality masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl locality masters.
	 *
	 * @return the number of cscl locality masters
	 */
	public int countAll();

}