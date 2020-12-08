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
 * Provides the local service utility for CsclAppointmentMaster. This utility wraps
 * <code>cscl.appointment.booking.service.impl.CsclAppointmentMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @rnab
 * @see CsclAppointmentMasterLocalService
 * @generated
 */
@ProviderType
public class CsclAppointmentMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cscl.appointment.booking.service.impl.CsclAppointmentMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl appointment master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was added
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
		addCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return getService().addCsclAppointmentMaster(csclAppointmentMaster);
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
		createCsclAppointmentMaster(long id_) {

		return getService().createCsclAppointmentMaster(id_);
	}

	/**
	 * Deletes the cscl appointment master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was removed
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
		deleteCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return getService().deleteCsclAppointmentMaster(csclAppointmentMaster);
	}

	/**
	 * Deletes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
			deleteCsclAppointmentMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclAppointmentMaster(id_);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cscl.appointment.booking.model.CsclAppointmentMaster
		fetchCsclAppointmentMaster(long id_) {

		return getService().fetchCsclAppointmentMaster(id_);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<cscl.appointment.booking.model.CsclAppointmentMaster>
			getAppointmentsWithStatus(int appointee, int status) {

		return getService().getAppointmentsWithStatus(appointee, status);
	}

	/**
	 * Returns the cscl appointment master with the primary key.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
			getCsclAppointmentMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclAppointmentMaster(id_);
	}

	/**
	 * Returns a range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of cscl appointment masters
	 */
	public static java.util.List
		<cscl.appointment.booking.model.CsclAppointmentMaster>
			getCsclAppointmentMasters(int start, int end) {

		return getService().getCsclAppointmentMasters(start, end);
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	public static int getCsclAppointmentMastersCount() {
		return getService().getCsclAppointmentMastersCount();
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
	 * Updates the cscl appointment master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was updated
	 */
	public static cscl.appointment.booking.model.CsclAppointmentMaster
		updateCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return getService().updateCsclAppointmentMaster(csclAppointmentMaster);
	}

	public static CsclAppointmentMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclAppointmentMasterLocalService, CsclAppointmentMasterLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclAppointmentMasterLocalService.class);

		ServiceTracker
			<CsclAppointmentMasterLocalService,
			 CsclAppointmentMasterLocalService> serviceTracker =
				new ServiceTracker
					<CsclAppointmentMasterLocalService,
					 CsclAppointmentMasterLocalService>(
						 bundle.getBundleContext(),
						 CsclAppointmentMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}