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

import com.cscl.tender.exception.NoSuchCategoryException;
import com.cscl.tender.model.CsclTenderCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl tender category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderCategoryUtil
 * @generated
 */
@ProviderType
public interface CsclTenderCategoryPersistence
	extends BasePersistence<CsclTenderCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclTenderCategoryUtil} to access the cscl tender category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cscl tender category in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategory the cscl tender category
	 */
	public void cacheResult(CsclTenderCategory csclTenderCategory);

	/**
	 * Caches the cscl tender categories in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategories the cscl tender categories
	 */
	public void cacheResult(
		java.util.List<CsclTenderCategory> csclTenderCategories);

	/**
	 * Creates a new cscl tender category with the primary key. Does not add the cscl tender category to the database.
	 *
	 * @param tenderCatId the primary key for the new cscl tender category
	 * @return the new cscl tender category
	 */
	public CsclTenderCategory create(long tenderCatId);

	/**
	 * Removes the cscl tender category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category that was removed
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	public CsclTenderCategory remove(long tenderCatId)
		throws NoSuchCategoryException;

	public CsclTenderCategory updateImpl(CsclTenderCategory csclTenderCategory);

	/**
	 * Returns the cscl tender category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	public CsclTenderCategory findByPrimaryKey(long tenderCatId)
		throws NoSuchCategoryException;

	/**
	 * Returns the cscl tender category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category, or <code>null</code> if a cscl tender category with the primary key could not be found
	 */
	public CsclTenderCategory fetchByPrimaryKey(long tenderCatId);

	/**
	 * Returns all the cscl tender categories.
	 *
	 * @return the cscl tender categories
	 */
	public java.util.List<CsclTenderCategory> findAll();

	/**
	 * Returns a range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @return the range of cscl tender categories
	 */
	public java.util.List<CsclTenderCategory> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl tender categories
	 */
	@Deprecated
	public java.util.List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl tender categories
	 */
	public java.util.List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator);

	/**
	 * Removes all the cscl tender categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl tender categories.
	 *
	 * @return the number of cscl tender categories
	 */
	public int countAll();

}