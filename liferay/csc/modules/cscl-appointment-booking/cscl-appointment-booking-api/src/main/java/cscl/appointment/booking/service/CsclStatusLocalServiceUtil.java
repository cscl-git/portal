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

package cscl.appointment.booking.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CsclStatus. This utility wraps
 * <code>cscl.appointment.booking.service.impl.CsclStatusLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @rnab
 * @see CsclStatusLocalService
 * @generated
 */
@ProviderType
public class CsclStatusLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cscl.appointment.booking.service.impl.CsclStatusLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was added
	 */
	public static cscl.appointment.booking.model.CsclStatus addCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return getService().addCsclStatus(csclStatus);
	}

	/**
	 * Creates a new cscl status with the primary key. Does not add the cscl status to the database.
	 *
	 * @param id_ the primary key for the new cscl status
	 * @return the new cscl status
	 */
	public static cscl.appointment.booking.model.CsclStatus createCsclStatus(
		long id_) {

		return getService().createCsclStatus(id_);
	}

	/**
	 * Deletes the cscl status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was removed
	 */
	public static cscl.appointment.booking.model.CsclStatus deleteCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return getService().deleteCsclStatus(csclStatus);
	}

	/**
	 * Deletes the cscl status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status that was removed
	 * @throws PortalException if a cscl status with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclStatus deleteCsclStatus(
			long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclStatus(id_);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cscl.appointment.booking.model.CsclStatus fetchCsclStatus(
		long id_) {

		return getService().fetchCsclStatus(id_);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<cscl.appointment.booking.model.CsclStatus>
		getActiveStatuses() {

		return getService().getActiveStatuses();
	}

	/**
	 * Returns the cscl status with the primary key.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status
	 * @throws PortalException if a cscl status with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclStatus getCsclStatus(
			long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclStatus(id_);
	}

	/**
	 * Returns a range of all the cscl statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl statuses
	 * @param end the upper bound of the range of cscl statuses (not inclusive)
	 * @return the range of cscl statuses
	 */
	public static java.util.List<cscl.appointment.booking.model.CsclStatus>
		getCsclStatuses(int start, int end) {

		return getService().getCsclStatuses(start, end);
	}

	/**
	 * Returns the number of cscl statuses.
	 *
	 * @return the number of cscl statuses
	 */
	public static int getCsclStatusesCount() {
		return getService().getCsclStatusesCount();
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
	 * Updates the cscl status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was updated
	 */
	public static cscl.appointment.booking.model.CsclStatus updateCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return getService().updateCsclStatus(csclStatus);
	}

	public static CsclStatusLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclStatusLocalService, CsclStatusLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CsclStatusLocalService.class);

		ServiceTracker<CsclStatusLocalService, CsclStatusLocalService>
			serviceTracker =
				new ServiceTracker
					<CsclStatusLocalService, CsclStatusLocalService>(
						bundle.getBundleContext(), CsclStatusLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}