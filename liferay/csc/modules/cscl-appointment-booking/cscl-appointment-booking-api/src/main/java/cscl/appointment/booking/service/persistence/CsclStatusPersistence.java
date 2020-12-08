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

package cscl.appointment.booking.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.exception.NoSuchCsclStatusException;
import cscl.appointment.booking.model.CsclStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclStatusUtil
 * @generated
 */
@ProviderType
public interface CsclStatusPersistence extends BasePersistence<CsclStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclStatusUtil} to access the cscl status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl statuses where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl statuses
	 */
	public java.util.List<CsclStatus> findByisActive(Boolean isActive);

	/**
	 * Returns a range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @return the range of matching cscl statuses
	 */
	public java.util.List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end);

	/**
	 * Returns an ordered range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl statuses
	 */
	@Deprecated
	public java.util.List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclStatus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl statuses where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl statuses
	 */
	public java.util.List<CsclStatus> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclStatus> orderByComparator);

	/**
	 * Returns the first cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl status
	 * @throws NoSuchCsclStatusException if a matching cscl status could not be found
	 */
	public CsclStatus findByisActive_First(
			Boolean isActive, OrderByComparator<CsclStatus> orderByComparator)
		throws NoSuchCsclStatusException;

	/**
	 * Returns the first cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl status, or <code>null</code> if a matching cscl status could not be found
	 */
	public CsclStatus fetchByisActive_First(
		Boolean isActive, OrderByComparator<CsclStatus> orderByComparator);

	/**
	 * Returns the last cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl status
	 * @throws NoSuchCsclStatusException if a matching cscl status could not be found
	 */
	public CsclStatus findByisActive_Last(
			Boolean isActive, OrderByComparator<CsclStatus> orderByComparator)
		throws NoSuchCsclStatusException;

	/**
	 * Returns the last cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl status, or <code>null</code> if a matching cscl status could not be found
	 */
	public CsclStatus fetchByisActive_Last(
		Boolean isActive, OrderByComparator<CsclStatus> orderByComparator);

	/**
	 * Returns the cscl statuses before and after the current cscl status in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl status
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl status
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public CsclStatus[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclStatus> orderByComparator)
		throws NoSuchCsclStatusException;

	/**
	 * Removes all the cscl statuses where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByisActive(Boolean isActive);

	/**
	 * Returns the number of cscl statuses where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl statuses
	 */
	public int countByisActive(Boolean isActive);

	/**
	 * Caches the cscl status in the entity cache if it is enabled.
	 *
	 * @param csclStatus the cscl status
	 */
	public void cacheResult(CsclStatus csclStatus);

	/**
	 * Caches the cscl statuses in the entity cache if it is enabled.
	 *
	 * @param csclStatuses the cscl statuses
	 */
	public void cacheResult(java.util.List<CsclStatus> csclStatuses);

	/**
	 * Creates a new cscl status with the primary key. Does not add the cscl status to the database.
	 *
	 * @param id_ the primary key for the new cscl status
	 * @return the new cscl status
	 */
	public CsclStatus create(long id_);

	/**
	 * Removes the cscl status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status that was removed
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public CsclStatus remove(long id_) throws NoSuchCsclStatusException;

	public CsclStatus updateImpl(CsclStatus csclStatus);

	/**
	 * Returns the cscl status with the primary key or throws a <code>NoSuchCsclStatusException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status
	 * @throws NoSuchCsclStatusException if a cscl status with the primary key could not be found
	 */
	public CsclStatus findByPrimaryKey(long id_)
		throws NoSuchCsclStatusException;

	/**
	 * Returns the cscl status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status, or <code>null</code> if a cscl status with the primary key could not be found
	 */
	public CsclStatus fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl statuses.
	 *
	 * @return the cscl statuses
	 */
	public java.util.List<CsclStatus> findAll();

	/**
	 * Returns a range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @return the range of cscl statuses
	 */
	public java.util.List<CsclStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl statuses
	 */
	@Deprecated
	public java.util.List<CsclStatus> findAll(
		int start, int end, OrderByComparator<CsclStatus> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl statuses
	 */
	public java.util.List<CsclStatus> findAll(
		int start, int end, OrderByComparator<CsclStatus> orderByComparator);

	/**
	 * Removes all the cscl statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl statuses.
	 *
	 * @return the number of cscl statuses
	 */
	public int countAll();

}