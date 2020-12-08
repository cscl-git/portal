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

package com.cscl.polls.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CsclPollsChoice. This utility wraps
 * <code>com.cscl.polls.service.impl.CsclPollsChoiceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsChoiceLocalService
 * @generated
 */
@ProviderType
public class CsclPollsChoiceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.cscl.polls.service.impl.CsclPollsChoiceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl polls choice to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was added
	 */
	public static com.cscl.polls.model.CsclPollsChoice addCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return getService().addCsclPollsChoice(csclPollsChoice);
	}

	/**
	 * Creates a new cscl polls choice with the primary key. Does not add the cscl polls choice to the database.
	 *
	 * @param choiceId the primary key for the new cscl polls choice
	 * @return the new cscl polls choice
	 */
	public static com.cscl.polls.model.CsclPollsChoice createCsclPollsChoice(
		long choiceId) {

		return getService().createCsclPollsChoice(choiceId);
	}

	/**
	 * Deletes the cscl polls choice from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was removed
	 */
	public static com.cscl.polls.model.CsclPollsChoice deleteCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return getService().deleteCsclPollsChoice(csclPollsChoice);
	}

	/**
	 * Deletes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws PortalException if a cscl polls choice with the primary key could not be found
	 */
	public static com.cscl.polls.model.CsclPollsChoice deleteCsclPollsChoice(
			long choiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclPollsChoice(choiceId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.cscl.polls.model.CsclPollsChoice fetchCsclPollsChoice(
		long choiceId) {

		return getService().fetchCsclPollsChoice(choiceId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl polls choice with the primary key.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws PortalException if a cscl polls choice with the primary key could not be found
	 */
	public static com.cscl.polls.model.CsclPollsChoice getCsclPollsChoice(
			long choiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclPollsChoice(choiceId);
	}

	/**
	 * Returns a range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @return the range of cscl polls choices
	 */
	public static java.util.List<com.cscl.polls.model.CsclPollsChoice>
		getCsclPollsChoices(int start, int end) {

		return getService().getCsclPollsChoices(start, end);
	}

	/**
	 * Returns the number of cscl polls choices.
	 *
	 * @return the number of cscl polls choices
	 */
	public static int getCsclPollsChoicesCount() {
		return getService().getCsclPollsChoicesCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl polls choice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was updated
	 */
	public static com.cscl.polls.model.CsclPollsChoice updateCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return getService().updateCsclPollsChoice(csclPollsChoice);
	}

	public static CsclPollsChoiceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclPollsChoiceLocalService, CsclPollsChoiceLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclPollsChoiceLocalService.class);

		ServiceTracker<CsclPollsChoiceLocalService, CsclPollsChoiceLocalService>
			serviceTracker =
				new ServiceTracker
					<CsclPollsChoiceLocalService, CsclPollsChoiceLocalService>(
						bundle.getBundleContext(),
						CsclPollsChoiceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}