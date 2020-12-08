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

import com.cscl.polls.model.CsclPollsChoice;

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
 * The persistence utility for the cscl polls choice service. This utility wraps <code>com.cscl.polls.service.persistence.impl.CsclPollsChoicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsChoicePersistence
 * @generated
 */
@ProviderType
public class CsclPollsChoiceUtil {

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
	public static void clearCache(CsclPollsChoice csclPollsChoice) {
		getPersistence().clearCache(csclPollsChoice);
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
	public static Map<Serializable, CsclPollsChoice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclPollsChoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclPollsChoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclPollsChoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclPollsChoice update(CsclPollsChoice csclPollsChoice) {
		return getPersistence().update(csclPollsChoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclPollsChoice update(
		CsclPollsChoice csclPollsChoice, ServiceContext serviceContext) {

		return getPersistence().update(csclPollsChoice, serviceContext);
	}

	/**
	 * Caches the cscl polls choice in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 */
	public static void cacheResult(CsclPollsChoice csclPollsChoice) {
		getPersistence().cacheResult(csclPollsChoice);
	}

	/**
	 * Caches the cscl polls choices in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoices the cscl polls choices
	 */
	public static void cacheResult(List<CsclPollsChoice> csclPollsChoices) {
		getPersistence().cacheResult(csclPollsChoices);
	}

	/**
	 * Creates a new cscl polls choice with the primary key. Does not add the cscl polls choice to the database.
	 *
	 * @param choiceId the primary key for the new cscl polls choice
	 * @return the new cscl polls choice
	 */
	public static CsclPollsChoice create(long choiceId) {
		return getPersistence().create(choiceId);
	}

	/**
	 * Removes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	public static CsclPollsChoice remove(long choiceId)
		throws com.cscl.polls.exception.NoSuchChoiceException {

		return getPersistence().remove(choiceId);
	}

	public static CsclPollsChoice updateImpl(CsclPollsChoice csclPollsChoice) {
		return getPersistence().updateImpl(csclPollsChoice);
	}

	/**
	 * Returns the cscl polls choice with the primary key or throws a <code>NoSuchChoiceException</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	public static CsclPollsChoice findByPrimaryKey(long choiceId)
		throws com.cscl.polls.exception.NoSuchChoiceException {

		return getPersistence().findByPrimaryKey(choiceId);
	}

	/**
	 * Returns the cscl polls choice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice, or <code>null</code> if a cscl polls choice with the primary key could not be found
	 */
	public static CsclPollsChoice fetchByPrimaryKey(long choiceId) {
		return getPersistence().fetchByPrimaryKey(choiceId);
	}

	/**
	 * Returns all the cscl polls choices.
	 *
	 * @return the cscl polls choices
	 */
	public static List<CsclPollsChoice> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CsclPollsChoice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

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
	public static List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl polls choices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl polls choices.
	 *
	 * @return the number of cscl polls choices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclPollsChoicePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclPollsChoicePersistence, CsclPollsChoicePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclPollsChoicePersistence.class);

		ServiceTracker<CsclPollsChoicePersistence, CsclPollsChoicePersistence>
			serviceTracker =
				new ServiceTracker
					<CsclPollsChoicePersistence, CsclPollsChoicePersistence>(
						bundle.getBundleContext(),
						CsclPollsChoicePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}