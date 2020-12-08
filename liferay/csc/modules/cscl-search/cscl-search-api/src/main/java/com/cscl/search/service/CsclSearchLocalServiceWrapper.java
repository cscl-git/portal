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

package com.cscl.search.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclSearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearchLocalService
 * @generated
 */
@ProviderType
public class CsclSearchLocalServiceWrapper
	implements CsclSearchLocalService, ServiceWrapper<CsclSearchLocalService> {

	public CsclSearchLocalServiceWrapper(
		CsclSearchLocalService csclSearchLocalService) {

		_csclSearchLocalService = csclSearchLocalService;
	}

	/**
	 * Adds the cscl search to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was added
	 */
	@Override
	public com.cscl.search.model.CsclSearch addCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return _csclSearchLocalService.addCsclSearch(csclSearch);
	}

	/**
	 * Creates a new cscl search with the primary key. Does not add the cscl search to the database.
	 *
	 * @param id the primary key for the new cscl search
	 * @return the new cscl search
	 */
	@Override
	public com.cscl.search.model.CsclSearch createCsclSearch(long id) {
		return _csclSearchLocalService.createCsclSearch(id);
	}

	/**
	 * Deletes the cscl search from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was removed
	 */
	@Override
	public com.cscl.search.model.CsclSearch deleteCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return _csclSearchLocalService.deleteCsclSearch(csclSearch);
	}

	/**
	 * Deletes the cscl search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search that was removed
	 * @throws PortalException if a cscl search with the primary key could not be found
	 */
	@Override
	public com.cscl.search.model.CsclSearch deleteCsclSearch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclSearchLocalService.deleteCsclSearch(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclSearchLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclSearchLocalService.dynamicQuery();
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

		return _csclSearchLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclSearchLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclSearchLocalService.dynamicQuery(
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

		return _csclSearchLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclSearchLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.search.model.CsclSearch fetchCsclSearch(long id) {
		return _csclSearchLocalService.fetchCsclSearch(id);
	}

	@Override
	public java.util.List<com.cscl.search.model.CsclSearch>
		fetchSearchResultByKeyword(int status, String keywords) {

		return _csclSearchLocalService.fetchSearchResultByKeyword(
			status, keywords);
	}

	@Override
	public java.util.List<com.cscl.search.model.CsclSearch> findByKeyword(
		int status, String keywords) {

		return _csclSearchLocalService.findByKeyword(status, keywords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclSearchLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl search with the primary key.
	 *
	 * @param id the primary key of the cscl search
	 * @return the cscl search
	 * @throws PortalException if a cscl search with the primary key could not be found
	 */
	@Override
	public com.cscl.search.model.CsclSearch getCsclSearch(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclSearchLocalService.getCsclSearch(id);
	}

	/**
	 * Returns a range of all the cscl searchs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.search.model.impl.CsclSearchModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl searchs
	 * @param end the upper bound of the range of cscl searchs (not inclusive)
	 * @return the range of cscl searchs
	 */
	@Override
	public java.util.List<com.cscl.search.model.CsclSearch> getCsclSearchs(
		int start, int end) {

		return _csclSearchLocalService.getCsclSearchs(start, end);
	}

	/**
	 * Returns the number of cscl searchs.
	 *
	 * @return the number of cscl searchs
	 */
	@Override
	public int getCsclSearchsCount() {
		return _csclSearchLocalService.getCsclSearchsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclSearchLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclSearchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclSearchLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl search in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclSearch the cscl search
	 * @return the cscl search that was updated
	 */
	@Override
	public com.cscl.search.model.CsclSearch updateCsclSearch(
		com.cscl.search.model.CsclSearch csclSearch) {

		return _csclSearchLocalService.updateCsclSearch(csclSearch);
	}

	@Override
	public CsclSearchLocalService getWrappedService() {
		return _csclSearchLocalService;
	}

	@Override
	public void setWrappedService(
		CsclSearchLocalService csclSearchLocalService) {

		_csclSearchLocalService = csclSearchLocalService;
	}

	private CsclSearchLocalService _csclSearchLocalService;

}