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
 * Provides a wrapper for {@link CsclApproverMappingLocalService}.
 *
 * @author @rnab
 * @see CsclApproverMappingLocalService
 * @generated
 */
@ProviderType
public class CsclApproverMappingLocalServiceWrapper
	implements CsclApproverMappingLocalService,
			   ServiceWrapper<CsclApproverMappingLocalService> {

	public CsclApproverMappingLocalServiceWrapper(
		CsclApproverMappingLocalService csclApproverMappingLocalService) {

		_csclApproverMappingLocalService = csclApproverMappingLocalService;
	}

	/**
	 * Adds the cscl approver mapping to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was added
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
		addCsclApproverMapping(
			cscl.appointment.booking.model.CsclApproverMapping
				csclApproverMapping) {

		return _csclApproverMappingLocalService.addCsclApproverMapping(
			csclApproverMapping);
	}

	/**
	 * Creates a new cscl approver mapping with the primary key. Does not add the cscl approver mapping to the database.
	 *
	 * @param id_ the primary key for the new cscl approver mapping
	 * @return the new cscl approver mapping
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
		createCsclApproverMapping(long id_) {

		return _csclApproverMappingLocalService.createCsclApproverMapping(id_);
	}

	/**
	 * Deletes the cscl approver mapping from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
		deleteCsclApproverMapping(
			cscl.appointment.booking.model.CsclApproverMapping
				csclApproverMapping) {

		return _csclApproverMappingLocalService.deleteCsclApproverMapping(
			csclApproverMapping);
	}

	/**
	 * Deletes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws PortalException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
			deleteCsclApproverMapping(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMappingLocalService.deleteCsclApproverMapping(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMappingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclApproverMappingLocalService.dynamicQuery();
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

		return _csclApproverMappingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclApproverMappingLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclApproverMappingLocalService.dynamicQuery(
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

		return _csclApproverMappingLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclApproverMappingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
		fetchCsclApproverMapping(long id_) {

		return _csclApproverMappingLocalService.fetchCsclApproverMapping(id_);
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclApproverMapping>
		findByAppointeeId(int appointeeId) {

		return _csclApproverMappingLocalService.findByAppointeeId(appointeeId);
	}

	@Override
	public java.util.List<cscl.appointment.booking.model.CsclApproverMapping>
		findByassignedTo(long assignedTo) {

		return _csclApproverMappingLocalService.findByassignedTo(assignedTo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclApproverMappingLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl approver mapping with the primary key.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws PortalException if a cscl approver mapping with the primary key could not be found
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
			getCsclApproverMapping(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMappingLocalService.getCsclApproverMapping(id_);
	}

	/**
	 * Returns a range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>cscl.appointment.booking.model.impl.CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of cscl approver mappings
	 */
	@Override
	public java.util.List<cscl.appointment.booking.model.CsclApproverMapping>
		getCsclApproverMappings(int start, int end) {

		return _csclApproverMappingLocalService.getCsclApproverMappings(
			start, end);
	}

	/**
	 * Returns the number of cscl approver mappings.
	 *
	 * @return the number of cscl approver mappings
	 */
	@Override
	public int getCsclApproverMappingsCount() {
		return _csclApproverMappingLocalService.getCsclApproverMappingsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclApproverMappingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclApproverMappingLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclApproverMappingLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cscl approver mapping in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 * @return the cscl approver mapping that was updated
	 */
	@Override
	public cscl.appointment.booking.model.CsclApproverMapping
		updateCsclApproverMapping(
			cscl.appointment.booking.model.CsclApproverMapping
				csclApproverMapping) {

		return _csclApproverMappingLocalService.updateCsclApproverMapping(
			csclApproverMapping);
	}

	@Override
	public CsclApproverMappingLocalService getWrappedService() {
		return _csclApproverMappingLocalService;
	}

	@Override
	public void setWrappedService(
		CsclApproverMappingLocalService csclApproverMappingLocalService) {

		_csclApproverMappingLocalService = csclApproverMappingLocalService;
	}

	private CsclApproverMappingLocalService _csclApproverMappingLocalService;

}