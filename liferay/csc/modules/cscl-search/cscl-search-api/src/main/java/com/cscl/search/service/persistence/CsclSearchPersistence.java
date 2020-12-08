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

package com.cscl.search.service.persistence;

import com.cscl.search.exception.NoSuchCsclSearchException;
import com.cscl.search.model.CsclSearch;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearchUtil
 * @generated
 */
@ProviderType
public interface CsclSearchPersistence extends BasePersistence<CsclSearch> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclSearchUtil} to access the cscl search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the matching cscl searchs
	 */
	public java.util.List<CsclSearch> findByKeywords(
		int status, String keywords);

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
	public java.util.List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end);

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
	public java.util.List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclSearch> findByKeywords(
		int status, String keywords, int start, int end,
		OrderByComparator<CsclSearch> orderByComparator);

	/**
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	public CsclSearch findByKeywords_First(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException;

	/**
	 * Returns the first cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	public CsclSearch fetchByKeywords_First(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator);

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search
	 * @throws NoSuchCsclSearchException if a matching cscl search could not be found
	 */
	public CsclSearch findByKeywords_Last(
			int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException;

	/**
	 * Returns the last cscl search in the ordered set where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl search, or <code>null</code> if a matching cscl search could not be found
	 */
	public CsclSearch fetchByKeywords_Last(
		int status, String keywords,
		OrderByComparator<CsclSearch> orderByComparator);

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
	public CsclSearch[] findByKeywords_PrevAndNext(
			long id, int status, String keywords,
			OrderByComparator<CsclSearch> orderByComparator)
		throws NoSuchCsclSearchException;

	/**
	 * Removes all the cscl searchs where status = &#63; and keywords LIKE &#63; from the database.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 */
	public void removeByKeywords(int status, String keywords);

	/**
	 * Returns the number of cscl searchs where status = &#63; and keywords LIKE &#63;.
	 *
	 * @param status the status
	 * @param keywords the keywords
	 * @return the number of matching cscl searchs
	 */
	public int countByKeywords(int status, String keywords);

	/**
	 * Caches the cscl search in the entity cache if it is enabled.
	 *
	 * @param csclSearch the cscl search
	 */
	public void cacheResult(CsclSearch csclSearch);

	/**
	 * Caches the cscl searchs in the entity cache if it is enabled.
	 *
	 * @param csclSearchs the cscl searchs
	 */
	public void cacheResult(java.util.List<CsclSearch> csclSearchs);

	/**
	 * Creates a new cscl search with the primary key. Does not add the cscl search to the database.
	 *
	 * @param id the primary key for the new cscl search
	 * @return the new cscl search
	 */
	public CsclSearch create(long id);

	/**
	 * Removes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	public CsclSearch remove(long id) throws NoSuchCsclSearchException;

	public CsclSearch updateImpl(CsclSearch csclSearch);

	/**
	 * Returns the cscl search with the primary key or throws a <code>NoSuchCsclSearchException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search
	 * @throws NoSuchCsclSearchException if a cscl search with the primary key could not be found
	 */
	public CsclSearch findByPrimaryKey(long id)
		throws NoSuchCsclSearchException;

	/**
	 * Returns the cscl search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search, or <code>null</code> if a cscl search with the primary key could not be found
	 */
	public CsclSearch fetchByPrimaryKey(long id);

	/**
	 * Returns all the cscl searchs.
	 *
	 * @return the cscl searchs
	 */
	public java.util.List<CsclSearch> findAll();

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
	public java.util.List<CsclSearch> findAll(int start, int end);

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
	public java.util.List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclSearch> findAll(
		int start, int end, OrderByComparator<CsclSearch> orderByComparator);

	/**
	 * Removes all the cscl searchs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl searchs.
	 *
	 * @return the number of cscl searchs
	 */
	public int countAll();

}