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

import com.cscl.polls.model.CsclPollsQuestion;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl polls question service. This utility wraps <code>com.cscl.polls.service.persistence.impl.CsclPollsQuestionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsQuestionPersistence
 * @generated
 */
@ProviderType
public class CsclPollsQuestionUtil {

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
	public static void clearCache(CsclPollsQuestion csclPollsQuestion) {
		getPersistence().clearCache(csclPollsQuestion);
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
	public static Map<Serializable, CsclPollsQuestion> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclPollsQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclPollsQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclPollsQuestion> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclPollsQuestion update(
		CsclPollsQuestion csclPollsQuestion) {

		return getPersistence().update(csclPollsQuestion);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclPollsQuestion update(
		CsclPollsQuestion csclPollsQuestion, ServiceContext serviceContext) {

		return getPersistence().update(csclPollsQuestion, serviceContext);
	}

	/**
	 * Caches the cscl polls question in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestion the cscl polls question
	 */
	public static void cacheResult(CsclPollsQuestion csclPollsQuestion) {
		getPersistence().cacheResult(csclPollsQuestion);
	}

	/**
	 * Caches the cscl polls questions in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestions the cscl polls questions
	 */
	public static void cacheResult(List<CsclPollsQuestion> csclPollsQuestions) {
		getPersistence().cacheResult(csclPollsQuestions);
	}

	/**
	 * Creates a new cscl polls question with the primary key. Does not add the cscl polls question to the database.
	 *
	 * @param questionId the primary key for the new cscl polls question
	 * @return the new cscl polls question
	 */
	public static CsclPollsQuestion create(long questionId) {
		return getPersistence().create(questionId);
	}

	/**
	 * Removes the cscl polls question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question that was removed
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	public static CsclPollsQuestion remove(long questionId)
		throws com.cscl.polls.exception.NoSuchQuestionException {

		return getPersistence().remove(questionId);
	}

	public static CsclPollsQuestion updateImpl(
		CsclPollsQuestion csclPollsQuestion) {

		return getPersistence().updateImpl(csclPollsQuestion);
	}

	/**
	 * Returns the cscl polls question with the primary key or throws a <code>NoSuchQuestionException</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	public static CsclPollsQuestion findByPrimaryKey(long questionId)
		throws com.cscl.polls.exception.NoSuchQuestionException {

		return getPersistence().findByPrimaryKey(questionId);
	}

	/**
	 * Returns the cscl polls question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question, or <code>null</code> if a cscl polls question with the primary key could not be found
	 */
	public static CsclPollsQuestion fetchByPrimaryKey(long questionId) {
		return getPersistence().fetchByPrimaryKey(questionId);
	}

	/**
	 * Returns all the cscl polls questions.
	 *
	 * @return the cscl polls questions
	 */
	public static List<CsclPollsQuestion> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CsclPollsQuestion> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl polls questions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl polls questions.
	 *
	 * @return the number of cscl polls questions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclPollsQuestionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclPollsQuestionPersistence, CsclPollsQuestionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclPollsQuestionPersistence.class);

		ServiceTracker
			<CsclPollsQuestionPersistence, CsclPollsQuestionPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclPollsQuestionPersistence,
						 CsclPollsQuestionPersistence>(
							 bundle.getBundleContext(),
							 CsclPollsQuestionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}