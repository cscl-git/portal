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
 * Provides the local service utility for CsclApproverMaster. This utility wraps
 * <code>cscl.appointment.booking.service.impl.CsclApproverMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author @rnab
 * @see CsclApproverMasterLocalService
 * @generated
 */
@ProviderType
public class CsclApproverMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>cscl.appointment.booking.service.impl.CsclApproverMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cscl approver master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was added
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
		addCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return getService().addCsclApproverMaster(csclApproverMaster);
	}

	/**
	 * Creates a new cscl approver master with the primary key. Does not add the cscl approver master to the database.
	 *
	 * @param id_ the primary key for the new cscl approver master
	 * @return the new cscl approver master
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
		createCsclApproverMaster(long id_) {

		return getService().createCsclApproverMaster(id_);
	}

	/**
	 * Deletes the cscl approver master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was removed
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
		deleteCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return getService().deleteCsclApproverMaster(csclApproverMaster);
	}

	/**
	 * Deletes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws PortalException if a cscl approver master with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
			deleteCsclApproverMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCsclApproverMaster(id_);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static cscl.appointment.booking.model.CsclApproverMaster
		fetchCsclApproverMaster(long id_) {

		return getService().fetchCsclApproverMaster(id_);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<cscl.appointment.booking.model.CsclApproverMaster>
			getActiveApprovers() {

		return getService().getActiveApprovers();
	}

	/**
	 * Returns the cscl approver master with the primary key.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws PortalException if a cscl approver master with the primary key could not be found
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
			getCsclApproverMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCsclApproverMaster(id_);
	}

	/**
	 * Returns a range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @return the range of cscl approver masters
	 */
	public static java.util.List
		<cscl.appointment.booking.model.CsclApproverMaster>
			getCsclApproverMasters(int start, int end) {

		return getService().getCsclApproverMasters(start, end);
	}

	/**
	 * Returns the number of cscl approver masters.
	 *
	 * @return the number of cscl approver masters
	 */
	public static int getCsclApproverMastersCount() {
		return getService().getCsclApproverMastersCount();
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
	 * Updates the cscl approver master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was updated
	 */
	public static cscl.appointment.booking.model.CsclApproverMaster
		updateCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return getService().updateCsclApproverMaster(csclApproverMaster);
	}

	public static CsclApproverMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclApproverMasterLocalService, CsclApproverMasterLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclApproverMasterLocalService.class);

		ServiceTracker
			<CsclApproverMasterLocalService, CsclApproverMasterLocalService>
				serviceTracker =
					new ServiceTracker
						<CsclApproverMasterLocalService,
						 CsclApproverMasterLocalService>(
							 bundle.getBundleContext(),
							 CsclApproverMasterLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}