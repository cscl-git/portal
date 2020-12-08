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

import com.cscl.polls.exception.NoSuchQuestionException;
import com.cscl.polls.model.CsclPollsQuestion;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl polls question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsQuestionUtil
 * @generated
 */
@ProviderType
public interface CsclPollsQuestionPersistence
	extends BasePersistence<CsclPollsQuestion> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclPollsQuestionUtil} to access the cscl polls question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cscl polls question in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestion the cscl polls question
	 */
	public void cacheResult(CsclPollsQuestion csclPollsQuestion);

	/**
	 * Caches the cscl polls questions in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestions the cscl polls questions
	 */
	public void cacheResult(
		java.util.List<CsclPollsQuestion> csclPollsQuestions);

	/**
	 * Creates a new cscl polls question with the primary key. Does not add the cscl polls question to the database.
	 *
	 * @param questionId the primary key for the new cscl polls question
	 * @return the new cscl polls question
	 */
	public CsclPollsQuestion create(long questionId);

	/**
	 * Removes the cscl polls question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question that was removed
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	public CsclPollsQuestion remove(long questionId)
		throws NoSuchQuestionException;

	public CsclPollsQuestion updateImpl(CsclPollsQuestion csclPollsQuestion);

	/**
	 * Returns the cscl polls question with the primary key or throws a <code>NoSuchQuestionException</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	public CsclPollsQuestion findByPrimaryKey(long questionId)
		throws NoSuchQuestionException;

	/**
	 * Returns the cscl polls question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question, or <code>null</code> if a cscl polls question with the primary key could not be found
	 */
	public CsclPollsQuestion fetchByPrimaryKey(long questionId);

	/**
	 * Returns all the cscl polls questions.
	 *
	 * @return the cscl polls questions
	 */
	public java.util.List<CsclPollsQuestion> findAll();

	/**
	 * Returns a range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @return the range of cscl polls questions
	 */
	public java.util.List<CsclPollsQuestion> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl polls questions
	 */
	@Deprecated
	public java.util.List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl polls questions
	 */
	public java.util.List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator);

	/**
	 * Removes all the cscl polls questions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl polls questions.
	 *
	 * @return the number of cscl polls questions
	 */
	public int countAll();

}