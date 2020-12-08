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
 * Provides a wrapper for {@link CsclAgeFilterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclAgeFilterLocalService
 * @generated
 */
@ProviderType
public class CsclAgeFilterLocalServiceWrapper
	implements CsclAgeFilterLocalService,
			   ServiceWrapper<CsclAgeFilterLocalService> {

	public CsclAgeFilterLocalServiceWrapper(
		CsclAgeFilterLocalService csclAgeFilterLocalService) {

		_csclAgeFilterLocalService = csclAgeFilterLocalService;
	}

	/**
	 * Adds the cscl age filter to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAgeFilter the cscl age filter
	 * @return the cscl age filter that was added
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter addCsclAgeFilter(
		com.cscl.polls.model.CsclAgeFilter csclAgeFilter) {

		return _csclAgeFilterLocalService.addCsclAgeFilter(csclAgeFilter);
	}

	/**
	 * Creates a new cscl age filter with the primary key. Does not add the cscl age filter to the database.
	 *
	 * @param id_ the primary key for the new cscl age filter
	 * @return the new cscl age filter
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter createCsclAgeFilter(long id_) {
		return _csclAgeFilterLocalService.createCsclAgeFilter(id_);
	}

	/**
	 * Deletes the cscl age filter from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclAgeFilter the cscl age filter
	 * @return the cscl age filter that was removed
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter deleteCsclAgeFilter(
		com.cscl.polls.model.CsclAgeFilter csclAgeFilter) {

		return _csclAgeFilterLocalService.deleteCsclAgeFilter(csclAgeFilter);
	}

	/**
	 * Deletes the cscl age filter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter that was removed
	 * @throws PortalException if a cscl age filter with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter deleteCsclAgeFilter(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAgeFilterLocalService.deleteCsclAgeFilter(id_);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAgeFilterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclAgeFilterLocalService.dynamicQuery();
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

		return _csclAgeFilterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclAgeFilterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclAgeFilterLocalService.dynamicQuery(
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

		return _csclAgeFilterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclAgeFilterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.polls.model.CsclAgeFilter fetchCsclAgeFilter(long id_) {
		return _csclAgeFilterLocalService.fetchCsclAgeFilter(id_);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclAgeFilterLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclAgeFilter>
		getActiveFiltersAge() {

		return _csclAgeFilterLocalService.getActiveFiltersAge();
	}

	/**
	 * Returns the cscl age filter with the primary key.
	 *
	 * @param id_ the primary key of the cscl age filter
	 * @return the cscl age filter
	 * @throws PortalException if a cscl age filter with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter getCsclAgeFilter(long id_)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAgeFilterLocalService.getCsclAgeFilter(id_);
	}

	/**
	 * Returns a range of all the cscl age filters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclAgeFilterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl age filters
	 * @param end the upper bound of the range of cscl age filters (not inclusive)
	 * @return the range of cscl age filters
	 */
	@Override
	public java.util.List<com.cscl.polls.model.CsclAgeFilter> getCsclAgeFilters(
		int start, int end) {

		return _csclAgeFilterLocalService.getCsclAgeFilters(start, end);
	}

	/**
	 * Returns the number of cscl age filters.
	 *
	 * @return the number of cscl age filters
	 */
	@Override
	public int getCsclAgeFiltersCount() {
		return _csclAgeFilterLocalService.getCsclAgeFiltersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclAgeFilterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclAgeFilterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclAgeFilterLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl age filter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclAgeFilter the cscl age filter
	 * @return the cscl age filter that was updated
	 */
	@Override
	public com.cscl.polls.model.CsclAgeFilter updateCsclAgeFilter(
		com.cscl.polls.model.CsclAgeFilter csclAgeFilter) {

		return _csclAgeFilterLocalService.updateCsclAgeFilter(csclAgeFilter);
	}

	@Override
	public CsclAgeFilterLocalService getWrappedService() {
		return _csclAgeFilterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclAgeFilterLocalService csclAgeFilterLocalService) {

		_csclAgeFilterLocalService = csclAgeFilterLocalService;
	}

	private CsclAgeFilterLocalService _csclAgeFilterLocalService;

}