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
 * Provides a wrapper for {@link CsclApproverMasterLocalService}.
 *
 * @author @rnab
 * @see CsclApproverMasterLocalService
 * @generated
 */
@ProviderType
public class CsclApproverMasterLocalServiceWrapper
	implements CsclApproverMasterLocalService,
			   ServiceWrapper<CsclApproverMasterLocalService> {

	public CsclApproverMasterLocalServiceWrapper(
		CsclApproverMasterLocalService csclApproverMasterLocalService) {

		_csclApproverMasterLocalService = csclApproverMasterLocalService;
	}

	/**
	 * Adds the cscl approver master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
		addCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return _csclApproverMasterLocalService.addCsclApproverMaster(
			csclApproverMaster);
	}

	/**
	 * Creates a new cscl approver master with the primary key. Does not add the cscl approver master to the database.
	 *
	 * @param id_ the primary key for the new cscl approver master
	 * @return the new cscl approver master
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
		createCsclApproverMaster(long id_) {

		return _csclApproverMasterLocalService.createCsclApproverMaster(id_);
	}

	/**
	 * Deletes the cscl approver master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
		deleteCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return _csclApproverMasterLocalService.deleteCsclApproverMaster(
			csclApproverMaster);
	}

	/**
	 * Deletes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws PortalException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
			deleteCsclApproverMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMasterLocalService.deleteCsclApproverMaster(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclApproverMasterLocalService.dynamicQuery();
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

		return _csclApproverMasterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _csclApproverMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _csclApproverMasterLocalService.dynamicQuery(
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

		return _csclApproverMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclApproverMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
		fetchCsclApproverMaster(long id_) {

		return _csclApproverMasterLocalService.fetchCsclApproverMaster(id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclApproverMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclApproverMaster>
		getActiveApprovers() {

		return _csclApproverMasterLocalService.getActiveApprovers();
	}

	/**
	 * Returns the cscl approver master with the primary key.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws PortalException if a cscl approver master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
			getCsclApproverMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMasterLocalService.getCsclApproverMaster(id_);
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
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclApproverMaster>
		getCsclApproverMasters(int start, int end) {

		return _csclApproverMasterLocalService.getCsclApproverMasters(
			start, end);
	}

	/**
	 * Returns the number of cscl approver masters.
	 *
	 * @return the number of cscl approver masters
	 */
	@Override
	public int getCsclApproverMastersCount() {
		return _csclApproverMasterLocalService.getCsclApproverMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclApproverMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclApproverMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl approver master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMaster the cscl approver master
	 * @return the cscl approver master that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMaster
		updateCsclApproverMaster(
			cscl.appointment.booking.model.CsclApproverMaster
				csclApproverMaster) {

		return _csclApproverMasterLocalService.updateCsclApproverMaster(
			csclApproverMaster);
	}

	@Override
	public CsclApproverMasterLocalService getWrappedService() {
		return _csclApproverMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclApproverMasterLocalService csclApproverMasterLocalService) {

		_csclApproverMasterLocalService = csclApproverMasterLocalService;
	}

	private CsclApproverMasterLocalService _csclApproverMasterLocalService;

}