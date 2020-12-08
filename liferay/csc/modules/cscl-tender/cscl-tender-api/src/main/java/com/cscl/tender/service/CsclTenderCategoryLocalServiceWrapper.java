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

package com.cscl.tender.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclTenderCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderCategoryLocalService
 * @generated
 */
@ProviderType
public class CsclTenderCategoryLocalServiceWrapper
	implements CsclTenderCategoryLocalService,
			   ServiceWrapper<CsclTenderCategoryLocalService> {

	public CsclTenderCategoryLocalServiceWrapper(
		CsclTenderCategoryLocalService csclTenderCategoryLocalService) {

		_csclTenderCategoryLocalService = csclTenderCategoryLocalService;
	}

	/**
	 * Adds the cscl tender category to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclTenderCategory the cscl tender category
	 * @return the cscl tender category that was added
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory addCsclTenderCategory(
		com.cscl.tender.model.CsclTenderCategory csclTenderCategory) {

		return _csclTenderCategoryLocalService.addCsclTenderCategory(
			csclTenderCategory);
	}

	/**
	 * Creates a new cscl tender category with the primary key. Does not add the cscl tender category to the database.
	 *
	 * @param tenderCatId the primary key for the new cscl tender category
	 * @return the new cscl tender category
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory createCsclTenderCategory(
		long tenderCatId) {

		return _csclTenderCategoryLocalService.createCsclTenderCategory(
			tenderCatId);
	}

	/**
	 * Deletes the cscl tender category from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclTenderCategory the cscl tender category
	 * @return the cscl tender category that was removed
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory deleteCsclTenderCategory(
		com.cscl.tender.model.CsclTenderCategory csclTenderCategory) {

		return _csclTenderCategoryLocalService.deleteCsclTenderCategory(
			csclTenderCategory);
	}

	/**
	 * Deletes the cscl tender category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category that was removed
	 * @throws PortalException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory deleteCsclTenderCategory(
			long tenderCatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderCategoryLocalService.deleteCsclTenderCategory(
			tenderCatId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclTenderCategoryLocalService.dynamicQuery();
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

		return _csclTenderCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclTenderCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclTenderCategoryLocalService.dynamicQuery(
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

		return _csclTenderCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclTenderCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.tender.model.CsclTenderCategory fetchCsclTenderCategory(
		long tenderCatId) {

		return _csclTenderCategoryLocalService.fetchCsclTenderCategory(
			tenderCatId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclTenderCategoryLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @return the range of cscl tender categories
	 */
	@Override
	public java.util.List<com.cscl.tender.model.CsclTenderCategory>
		getCsclTenderCategories(int start, int end) {

		return _csclTenderCategoryLocalService.getCsclTenderCategories(
			start, end);
	}

	/**
	 * Returns the number of cscl tender categories.
	 *
	 * @return the number of cscl tender categories
	 */
	@Override
	public int getCsclTenderCategoriesCount() {
		return _csclTenderCategoryLocalService.getCsclTenderCategoriesCount();
	}

	/**
	 * Returns the cscl tender category with the primary key.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category
	 * @throws PortalException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory getCsclTenderCategory(
			long tenderCatId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderCategoryLocalService.getCsclTenderCategory(
			tenderCatId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclTenderCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclTenderCategoryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl tender category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclTenderCategory the cscl tender category
	 * @return the cscl tender category that was updated
	 */
	@Override
	public com.cscl.tender.model.CsclTenderCategory updateCsclTenderCategory(
		com.cscl.tender.model.CsclTenderCategory csclTenderCategory) {

		return _csclTenderCategoryLocalService.updateCsclTenderCategory(
			csclTenderCategory);
	}

	@Override
	public CsclTenderCategoryLocalService getWrappedService() {
		return _csclTenderCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		CsclTenderCategoryLocalService csclTenderCategoryLocalService) {

		_csclTenderCategoryLocalService = csclTenderCategoryLocalService;
	}

	private CsclTenderCategoryLocalService _csclTenderCategoryLocalService;

}