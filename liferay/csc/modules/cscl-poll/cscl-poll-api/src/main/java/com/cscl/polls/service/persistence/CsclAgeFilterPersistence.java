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

import com.cscl.polls.exception.NoSuchCsclAgeFilterException;
import com.cscl.polls.model.CsclAgeFilter;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl age filter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclAgeFilterUtil
 * @generated
 */
@ProviderType
public interface CsclAgeFilterPersistence
	extends BasePersistence<CsclAgeFilter> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclAgeFilterUtil} to access the cscl age filter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl age filters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findByisActive(Boolean isActive);

	/**
	 * Returns a range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @return the range of matching cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end);

	/**
	 * Returns an ordered range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl age filters
	 */
	@Deprecated
	public java.util.List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl age filters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAgeFilter> orderByComparator);

	/**
	 * Returns the first cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a matching cscl age filter could not be found
	 */
	public CsclAgeFilter findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws NoSuchCsclAgeFilterException;

	/**
	 * Returns the first cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl age filter, or <code>null</code> if a matching cscl age filter could not be found
	 */
	public CsclAgeFilter fetchByisActive_First(
		Boolean isActive, OrderByComparator<CsclAgeFilter> orderByComparator);

	/**
	 * Returns the last cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a matching cscl age filter could not be found
	 */
	public CsclAgeFilter findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws NoSuchCsclAgeFilterException;

	/**
	 * Returns the last cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl age filter, or <code>null</code> if a matching cscl age filter could not be found
	 */
	public CsclAgeFilter fetchByisActive_Last(
		Boolean isActive, OrderByComparator<CsclAgeFilter> orderByComparator);

	/**
	 * Returns the cscl age filters before and after the current cscl age filter in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl age filter
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public CsclAgeFilter[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclAgeFilter> orderByComparator)
		throws NoSuchCsclAgeFilterException;

	/**
	 * Removes all the cscl age filters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByisActive(Boolean isActive);

	/**
	 * Returns the number of cscl age filters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl age filters
	 */
	public int countByisActive(Boolean isActive);

	/**
	 * Caches the cscl age filter in the entity cache if it is enabled.
	 *
	 * @param csclAgeFilter the cscl age filter
	 */
	public void cacheResult(CsclAgeFilter csclAgeFilter);

	/**
	 * Caches the cscl age filters in the entity cache if it is enabled.
	 *
	 * @param csclAgeFilters the cscl age filters
	 */
	public void cacheResult(java.util.List<CsclAgeFilter> csclAgeFilters);

	/**
	 * Creates a new cscl age filter with the primary key. Does not add the cscl age filter to the database.
	 *
	 * @param id_ the primary key for the new cscl age filter
	 * @return the new cscl age filter
	 */
	public CsclAgeFilter create(long id_);

	/**
	 * Removes the cscl age filter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter that was removed
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public CsclAgeFilter remove(long id_) throws NoSuchCsclAgeFilterException;

	public CsclAgeFilter updateImpl(CsclAgeFilter csclAgeFilter);

	/**
	 * Returns the cscl age filter with the primary key or throws a <code>NoSuchCsclAgeFilterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter
	 * @throws NoSuchCsclAgeFilterException if a cscl age filter with the primary key could not be found
	 */
	public CsclAgeFilter findByPrimaryKey(long id_)
		throws NoSuchCsclAgeFilterException;

	/**
	 * Returns the cscl age filter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter, or <code>null</code> if a cscl age filter with the primary key could not be found
	 */
	public CsclAgeFilter fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl age filters.
	 *
	 * @return the cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findAll();

	/**
	 * Returns a range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @return the range of cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl age filters
	 */
	@Deprecated
	public java.util.List<CsclAgeFilter> findAll(
		int start, int end, OrderByComparator<CsclAgeFilter> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl age filters
	 */
	public java.util.List<CsclAgeFilter> findAll(
		int start, int end, OrderByComparator<CsclAgeFilter> orderByComparator);

	/**
	 * Removes all the cscl age filters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl age filters.
	 *
	 * @return the number of cscl age filters
	 */
	public int countAll();

}