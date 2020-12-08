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
 * Provides a wrapper for {@link CsclStatusLocalService}.
 *
 * @author @rnab
 * @see CsclStatusLocalService
 * @generated
 */
@ProviderType
public class CsclStatusLocalServiceWrapper
	implements CsclStatusLocalService, ServiceWrapper<CsclStatusLocalService> {

	public CsclStatusLocalServiceWrapper(
		CsclStatusLocalService csclStatusLocalService) {

		_csclStatusLocalService = csclStatusLocalService;
	}

	/**
	 * Adds the cscl status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus addCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return _csclStatusLocalService.addCsclStatus(csclStatus);
	}

	/**
	 * Creates a new cscl status with the primary key. Does not add the cscl status to the database.
	 *
	 * @param id_ the primary key for the new cscl status
	 * @return the new cscl status
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus createCsclStatus(
		long id_) {

		return _csclStatusLocalService.createCsclStatus(id_);
	}

	/**
	 * Deletes the cscl status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus deleteCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return _csclStatusLocalService.deleteCsclStatus(csclStatus);
	}

	/**
	 * Deletes the cscl status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status that was removed
	 * @throws PortalException if a cscl status with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus deleteCsclStatus(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclStatusLocalService.deleteCsclStatus(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclStatusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclStatusLocalService.dynamicQuery();
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

		return _csclStatusLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _csclStatusLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _csclStatusLocalService.dynamicQuery(
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

		return _csclStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclStatus fetchCsclStatus(long id_) {
		return _csclStatusLocalService.fetchCsclStatus(id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclStatus>
		getActiveStatuses() {

		return _csclStatusLocalService.getActiveStatuses();
	}

	/**
	 * Returns the cscl status with the primary key.
	 *
	 * @param id_ the primary key of the cscl status
	 * @return the cscl status
	 * @throws PortalException if a cscl status with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus getCsclStatus(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclStatusLocalService.getCsclStatus(id_);
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
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclStatus>
		getCsclStatuses(int start, int end) {

		return _csclStatusLocalService.getCsclStatuses(start, end);
	}

	/**
	 * Returns the number of cscl statuses.
	 *
	 * @return the number of cscl statuses
	 */
	@Override
	public int getCsclStatusesCount() {
		return _csclStatusLocalService.getCsclStatusesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclStatusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclStatusLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclStatus the cscl status
	 * @return the cscl status that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclStatus updateCsclStatus(
		cscl.appointment.booking.model.CsclStatus csclStatus) {

		return _csclStatusLocalService.updateCsclStatus(csclStatus);
	}

	@Override
	public CsclStatusLocalService getWrappedService() {
		return _csclStatusLocalService;
	}

	@Override
	public void setWrappedService(
		CsclStatusLocalService csclStatusLocalService) {

		_csclStatusLocalService = csclStatusLocalService;
	}

	private CsclStatusLocalService _csclStatusLocalService;

}