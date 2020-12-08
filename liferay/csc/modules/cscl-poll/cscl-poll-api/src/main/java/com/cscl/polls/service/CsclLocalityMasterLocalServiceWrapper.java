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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclLocalityMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclLocalityMasterLocalService
 * @generated
 */
@ProviderType
public class CsclLocalityMasterLocalServiceWrapper
	implements CsclLocalityMasterLocalService,
			   ServiceWrapper<CsclLocalityMasterLocalService> {

	public CsclLocalityMasterLocalServiceWrapper(
		CsclLocalityMasterLocalService csclLocalityMasterLocalService) {

		_csclLocalityMasterLocalService = csclLocalityMasterLocalService;
	}

	/**
	 * Adds the cscl locality master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was added
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster addCsclLocalityMaster(
		com.cscl.polls.model.CsclLocalityMaster csclLocalityMaster) {

		return _csclLocalityMasterLocalService.addCsclLocalityMaster(
			csclLocalityMaster);
	}

	/**
	 * Creates a new cscl locality master with the primary key. Does not add the cscl locality master to the database.
	 *
	 * @param localityId the primary key for the new cscl locality master
	 * @return the new cscl locality master
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster createCsclLocalityMaster(
		long localityId) {

		return _csclLocalityMasterLocalService.createCsclLocalityMaster(
			localityId);
	}

	/**
	 * Deletes the cscl locality master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was removed
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster deleteCsclLocalityMaster(
		com.cscl.polls.model.CsclLocalityMaster csclLocalityMaster) {

		return _csclLocalityMasterLocalService.deleteCsclLocalityMaster(
			csclLocalityMaster);
	}

	/**
	 * Deletes the cscl locality master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master that was removed
	 * @throws PortalException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster deleteCsclLocalityMaster(
			long localityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclLocalityMasterLocalService.deleteCsclLocalityMaster(
			localityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclLocalityMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclLocalityMasterLocalService.dynamicQuery();
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

		return _csclLocalityMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclLocalityMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclLocalityMasterLocalService.dynamicQuery(
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

		return _csclLocalityMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclLocalityMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.polls.model.CsclLocalityMaster fetchCsclLocalityMaster(
		long localityId) {

		return _csclLocalityMasterLocalService.fetchCsclLocalityMaster(
			localityId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclLocalityMasterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclLocalityMaster>
		getActiveLocalities() {

		return _csclLocalityMasterLocalService.getActiveLocalities();
	}

	/**
	 * Returns the cscl locality master with the primary key.
	 *
	 * @param localityId the primary key of the cscl locality master
	 * @return the cscl locality master
	 * @throws PortalException if a cscl locality master with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster getCsclLocalityMaster(
			long localityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclLocalityMasterLocalService.getCsclLocalityMaster(
			localityId);
	}

	/**
	 * Returns a range of all the cscl locality masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclLocalityMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl locality masters
	 * @param end the upper bound of the range of cscl locality masters (not inclusive)
	 * @return the range of cscl locality masters
	 */
	@Override
	public java.util.List<com.cscl.polls.model.CsclLocalityMaster>
		getCsclLocalityMasters(int start, int end) {

		return _csclLocalityMasterLocalService.getCsclLocalityMasters(
			start, end);
	}

	/**
	 * Returns the number of cscl locality masters.
	 *
	 * @return the number of cscl locality masters
	 */
	@Override
	public int getCsclLocalityMastersCount() {
		return _csclLocalityMasterLocalService.getCsclLocalityMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclLocalityMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclLocalityMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclLocalityMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl locality master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclLocalityMaster the cscl locality master
	 * @return the cscl locality master that was updated
	 */
	@Override
	public com.cscl.polls.model.CsclLocalityMaster updateCsclLocalityMaster(
		com.cscl.polls.model.CsclLocalityMaster csclLocalityMaster) {

		return _csclLocalityMasterLocalService.updateCsclLocalityMaster(
			csclLocalityMaster);
	}

	@Override
	public CsclLocalityMasterLocalService getWrappedService() {
		return _csclLocalityMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclLocalityMasterLocalService csclLocalityMasterLocalService) {

		_csclLocalityMasterLocalService = csclLocalityMasterLocalService;
	}

	private CsclLocalityMasterLocalService _csclLocalityMasterLocalService;

}