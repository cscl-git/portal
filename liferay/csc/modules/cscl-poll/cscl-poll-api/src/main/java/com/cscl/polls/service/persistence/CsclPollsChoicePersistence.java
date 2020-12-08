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

import com.cscl.polls.exception.NoSuchChoiceException;
import com.cscl.polls.model.CsclPollsChoice;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl polls choice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsChoiceUtil
 * @generated
 */
@ProviderType
public interface CsclPollsChoicePersistence
	extends BasePersistence<CsclPollsChoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclPollsChoiceUtil} to access the cscl polls choice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cscl polls choice in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 */
	public void cacheResult(CsclPollsChoice csclPollsChoice);

	/**
	 * Caches the cscl polls choices in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoices the cscl polls choices
	 */
	public void cacheResult(java.util.List<CsclPollsChoice> csclPollsChoices);

	/**
	 * Creates a new cscl polls choice with the primary key. Does not add the cscl polls choice to the database.
	 *
	 * @param choiceId the primary key for the new cscl polls choice
	 * @return the new cscl polls choice
	 */
	public CsclPollsChoice create(long choiceId);

	/**
	 * Removes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	public CsclPollsChoice remove(long choiceId) throws NoSuchChoiceException;

	public CsclPollsChoice updateImpl(CsclPollsChoice csclPollsChoice);

	/**
	 * Returns the cscl polls choice with the primary key or throws a <code>NoSuchChoiceException</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	public CsclPollsChoice findByPrimaryKey(long choiceId)
		throws NoSuchChoiceException;

	/**
	 * Returns the cscl polls choice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice, or <code>null</code> if a cscl polls choice with the primary key could not be found
	 */
	public CsclPollsChoice fetchByPrimaryKey(long choiceId);

	/**
	 * Returns all the cscl polls choices.
	 *
	 * @return the cscl polls choices
	 */
	public java.util.List<CsclPollsChoice> findAll();

	/**
	 * Returns a range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @return the range of cscl polls choices
	 */
	public java.util.List<CsclPollsChoice> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl polls choices
	 */
	@Deprecated
	public java.util.List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl polls choices
	 */
	public java.util.List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator);

	/**
	 * Removes all the cscl polls choices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl polls choices.
	 *
	 * @return the number of cscl polls choices
	 */
	public int countAll();

}