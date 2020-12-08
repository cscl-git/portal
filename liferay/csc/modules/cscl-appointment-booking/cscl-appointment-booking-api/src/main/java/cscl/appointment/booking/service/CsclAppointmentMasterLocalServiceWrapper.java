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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclAppointmentMasterLocalService}.
 *
 * @author @rnab
 * @see CsclAppointmentMasterLocalService
 * @generated
 */
@ProviderType
public class CsclAppointmentMasterLocalServiceWrapper
	implements CsclAppointmentMasterLocalService,
			   ServiceWrapper<CsclAppointmentMasterLocalService> {

	public CsclAppointmentMasterLocalServiceWrapper(
		CsclAppointmentMasterLocalService csclAppointmentMasterLocalService) {

		_csclAppointmentMasterLocalService = csclAppointmentMasterLocalService;
	}

	/**
	 * Adds the cscl appointment master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
		addCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return _csclAppointmentMasterLocalService.addCsclAppointmentMaster(
			csclAppointmentMaster);
	}

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
		createCsclAppointmentMaster(long id_) {

		return _csclAppointmentMasterLocalService.createCsclAppointmentMaster(
			id_);
	}

	/**
	 * Deletes the cscl appointment master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
		deleteCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return _csclAppointmentMasterLocalService.deleteCsclAppointmentMaster(
			csclAppointmentMaster);
	}

	/**
	 * Deletes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
			deleteCsclAppointmentMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentMasterLocalService.deleteCsclAppointmentMaster(
			id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclAppointmentMasterLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _csclAppointmentMasterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _csclAppointmentMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _csclAppointmentMasterLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _csclAppointmentMasterLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _csclAppointmentMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
		fetchCsclAppointmentMaster(long id_) {

		return _csclAppointmentMasterLocalService.fetchCsclAppointmentMaster(
			id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclAppointmentMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclAppointmentMaster>
		getAppointmentsWithStatus(int appointee, int status) {

		return _csclAppointmentMasterLocalService.getAppointmentsWithStatus(
			appointee, status);
	}

	/**
	 * Returns the cscl appointment master with the primary key.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws PortalException if a cscl appointment master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
			getCsclAppointmentMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentMasterLocalService.getCsclAppointmentMaster(id_);
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
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclAppointmentMaster>
		getCsclAppointmentMasters(int start, int end) {

		return _csclAppointmentMasterLocalService.getCsclAppointmentMasters(
			start, end);
	}

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	@Override
	public int getCsclAppointmentMastersCount() {
		return _csclAppointmentMasterLocalService.
			getCsclAppointmentMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclAppointmentMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclAppointmentMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointmentMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cscl appointment master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 * @return the cscl appointment master that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointmentMaster
		updateCsclAppointmentMaster(
			cscl.appointment.booking.model.CsclAppointmentMaster
				csclAppointmentMaster) {

		return _csclAppointmentMasterLocalService.updateCsclAppointmentMaster(
			csclAppointmentMaster);
	}

	@Override
	public CsclAppointmentMasterLocalService getWrappedService() {
		return _csclAppointmentMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclAppointmentMasterLocalService csclAppointmentMasterLocalService) {

		_csclAppointmentMasterLocalService = csclAppointmentMasterLocalService;
	}

	private CsclAppointmentMasterLocalService
		_csclAppointmentMasterLocalService;

}