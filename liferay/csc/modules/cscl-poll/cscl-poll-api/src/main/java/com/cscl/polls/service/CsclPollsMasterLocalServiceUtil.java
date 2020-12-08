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
 * Provides the local service utility for CsclPollsMaster. This utility wraps
 * <code>com.cscl.polls.service.impl.CsclPollsMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterLocalService
 * @generated
 */
@ProviderType
public class CsclPollsMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.cscl.polls.service.impl.CsclPollsMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl polls master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was added
	 */
	public static com.cscl.polls.model.CsclPollsMaster addCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return getService().addCsclPollsMaster(csclPollsMaster);
	}

	/**
	 * Creates a new cscl polls master with the primary key. Does not add the cscl polls master to the database.
	 *
	 * @param entryId the primary key for the new cscl polls master
	 * @return the new cscl polls master
	 */
	public static com.cscl.polls.model.CsclPollsMaster createCsclPollsMaster(
		long entryId) {

		return getService().createCsclPollsMaster(entryId);
	}

	/**
	 * Deletes the cscl polls master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was removed
	 */
	public static com.cscl.polls.model.CsclPollsMaster deleteCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return getService().deleteCsclPollsMaster(csclPollsMaster);
	}

	/**
	 * Deletes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws PortalException if a cscl polls master with the primary key could not be found
	 */
	public static com.cscl.polls.model.CsclPollsMaster deleteCsclPollsMaster(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclPollsMaster(entryId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.cscl.polls.model.CsclPollsMaster fetchCsclPollsMaster(
		long entryId) {

		return getService().fetchCsclPollsMaster(entryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl polls master with the primary key.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws PortalException if a cscl polls master with the primary key could not be found
	 */
	public static com.cscl.polls.model.CsclPollsMaster getCsclPollsMaster(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclPollsMaster(entryId);
	}

	/**
	 * Returns a range of all the cscl polls masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of cscl polls masters
	 */
	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getCsclPollsMasters(int start, int end) {

		return getService().getCsclPollsMasters(start, end);
	}

	/**
	 * Returns the number of cscl polls masters.
	 *
	 * @return the number of cscl polls masters
	 */
	public static int getCsclPollsMastersCount() {
		return getService().getCsclPollsMastersCount();
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

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByAge(long entryId, java.util.Date age) {

		return getService().getPollsByAge(entryId, age);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByAgeAndLocality(
			long entryId, java.util.Date age, int locality) {

		return getService().getPollsByAgeAndLocality(entryId, age, locality);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByAgeAndSex(long entryId, java.util.Date age, String sex) {

		return getService().getPollsByAgeAndSex(entryId, age, sex);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalities(long entryId, int locality) {

		return getService().getPollsByLocalities(entryId, locality);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalityAndSex(long entryId, int locality, String sex) {

		return getService().getPollsByLocalityAndSex(entryId, locality, sex);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalityAndSexAndAge(
			long entryId, int locality, String sex, java.util.Date age) {

		return getService().getPollsByLocalityAndSexAndAge(
			entryId, locality, sex, age);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByQuestionId(long questionId) {

		return getService().getPollsByQuestionId(questionId);
	}

	public static java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsBySex(long entryId, String sex) {

		return getService().getPollsBySex(entryId, sex);
	}

	/**
	 * Updates the cscl polls master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was updated
	 */
	public static com.cscl.polls.model.CsclPollsMaster updateCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return getService().updateCsclPollsMaster(csclPollsMaster);
	}

	public static CsclPollsMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclPollsMasterLocalService, CsclPollsMasterLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclPollsMasterLocalService.class);

		ServiceTracker<CsclPollsMasterLocalService, CsclPollsMasterLocalService>
			serviceTracker =
				new ServiceTracker
					<CsclPollsMasterLocalService, CsclPollsMasterLocalService>(
						bundle.getBundleContext(),
						CsclPollsMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}