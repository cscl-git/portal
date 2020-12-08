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
 * Provides a wrapper for {@link CsclAppointeeMasterLocalService}.
 *
 * @author @rnab
 * @see CsclAppointeeMasterLocalService
 * @generated
 */
@ProviderType
public class CsclAppointeeMasterLocalServiceWrapper
	implements CsclAppointeeMasterLocalService,
			   ServiceWrapper<CsclAppointeeMasterLocalService> {

	public CsclAppointeeMasterLocalServiceWrapper(
		CsclAppointeeMasterLocalService csclAppointeeMasterLocalService) {

		_csclAppointeeMasterLocalService = csclAppointeeMasterLocalService;
	}

	/**
	 * Adds the cscl appointee master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointeeMaster the cscl appointee master
	 * @return the cscl appointee master that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
		addCsclAppointeeMaster(
			cscl.appointment.booking.model.CsclAppointeeMaster
				csclAppointeeMaster) {

		return _csclAppointeeMasterLocalService.addCsclAppointeeMaster(
			csclAppointeeMaster);
	}

	/**
	 * Creates a new cscl appointee master with the primary key. Does not add the cscl appointee master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointee master
	 * @return the new cscl appointee master
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
		createCsclAppointeeMaster(long id_) {

		return _csclAppointeeMasterLocalService.createCsclAppointeeMaster(id_);
	}

	/**
	 * Deletes the cscl appointee master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointeeMaster the cscl appointee master
	 * @return the cscl appointee master that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
		deleteCsclAppointeeMaster(
			cscl.appointment.booking.model.CsclAppointeeMaster
				csclAppointeeMaster) {

		return _csclAppointeeMasterLocalService.deleteCsclAppointeeMaster(
			csclAppointeeMaster);
	}

	/**
	 * Deletes the cscl appointee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointee master
	 * @return the cscl appointee master that was removed
	 * @throws PortalException if a cscl appointee master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
			deleteCsclAppointeeMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointeeMasterLocalService.deleteCsclAppointeeMaster(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointeeMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclAppointeeMasterLocalService.dynamicQuery();
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

		return _csclAppointeeMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclAppointeeMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclAppointeeMasterLocalService.dynamicQuery(
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

		return _csclAppointeeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclAppointeeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
		fetchCsclAppointeeMaster(long id_) {

		return _csclAppointeeMasterLocalService.fetchCsclAppointeeMaster(id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclAppointeeMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclAppointeeMaster>
		getActiveAppointees() {

		return _csclAppointeeMasterLocalService.getActiveAppointees();
	}

	/**
	 * Returns the cscl appointee master with the primary key.
	 *
	 * @param id_ the primary key of the cscl appointee master
	 * @return the cscl appointee master
	 * @throws PortalException if a cscl appointee master with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
			getCsclAppointeeMaster(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointeeMasterLocalService.getCsclAppointeeMaster(id_);
	}

	/**
	 * Returns a range of all the cscl appointee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @return the range of cscl appointee masters
	 */
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclAppointeeMaster>
		getCsclAppointeeMasters(int start, int end) {

		return _csclAppointeeMasterLocalService.getCsclAppointeeMasters(
			start, end);
	}

	/**
	 * Returns the number of cscl appointee masters.
	 *
	 * @return the number of cscl appointee masters
	 */
	@Override
	public int getCsclAppointeeMastersCount() {
		return _csclAppointeeMasterLocalService.getCsclAppointeeMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclAppointeeMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclAppointeeMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAppointeeMasterLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cscl appointee master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAppointeeMaster the cscl appointee master
	 * @return the cscl appointee master that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclAppointeeMaster
		updateCsclAppointeeMaster(
			cscl.appointment.booking.model.CsclAppointeeMaster
				csclAppointeeMaster) {

		return _csclAppointeeMasterLocalService.updateCsclAppointeeMaster(
			csclAppointeeMaster);
	}

	@Override
	public CsclAppointeeMasterLocalService getWrappedService() {
		return _csclAppointeeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclAppointeeMasterLocalService csclAppointeeMasterLocalService) {

		_csclAppointeeMasterLocalService = csclAppointeeMasterLocalService;
	}

	private CsclAppointeeMasterLocalService _csclAppointeeMasterLocalService;

}