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
 * Provides a wrapper for {@link CsclTenderLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderLocalService
 * @generated
 */
@ProviderType
public class CsclTenderLocalServiceWrapper
	implements CsclTenderLocalService, ServiceWrapper<CsclTenderLocalService> {

	public CsclTenderLocalServiceWrapper(
		CsclTenderLocalService csclTenderLocalService) {

		_csclTenderLocalService = csclTenderLocalService;
	}

	/**
	 * Adds the cscl tender to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclTender the cscl tender
	 * @return the cscl tender that was added
	 */
	@Override
	public com.cscl.tender.model.CsclTender addCsclTender(
		com.cscl.tender.model.CsclTender csclTender) {

		return _csclTenderLocalService.addCsclTender(csclTender);
	}

	/**
	 * Creates a new cscl tender with the primary key. Does not add the cscl tender to the database.
	 *
	 * @param tenderId the primary key for the new cscl tender
	 * @return the new cscl tender
	 */
	@Override
	public com.cscl.tender.model.CsclTender createCsclTender(long tenderId) {
		return _csclTenderLocalService.createCsclTender(tenderId);
	}

	/**
	 * Deletes the cscl tender from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclTender the cscl tender
	 * @return the cscl tender that was removed
	 */
	@Override
	public com.cscl.tender.model.CsclTender deleteCsclTender(
		com.cscl.tender.model.CsclTender csclTender) {

		return _csclTenderLocalService.deleteCsclTender(csclTender);
	}

	/**
	 * Deletes the cscl tender with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender that was removed
	 * @throws PortalException if a cscl tender with the primary key could not be found
	 */
	@Override
	public com.cscl.tender.model.CsclTender deleteCsclTender(long tenderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderLocalService.deleteCsclTender(tenderId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclTenderLocalService.dynamicQuery();
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

		return _csclTenderLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclTenderLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclTenderLocalService.dynamicQuery(
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

		return _csclTenderLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclTenderLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.tender.model.CsclTender fetchCsclTender(long tenderId) {
		return _csclTenderLocalService.fetchCsclTender(tenderId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclTenderLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl tender with the primary key.
	 *
	 * @param tenderId the primary key of the cscl tender
	 * @return the cscl tender
	 * @throws PortalException if a cscl tender with the primary key could not be found
	 */
	@Override
	public com.cscl.tender.model.CsclTender getCsclTender(long tenderId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderLocalService.getCsclTender(tenderId);
	}

	/**
	 * Returns a range of all the cscl tenders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.tender.model.impl.CsclTenderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tenders
	 * @param end the upper bound of the range of cscl tenders (not inclusive)
	 * @return the range of cscl tenders
	 */
	@Override
	public java.util.List<com.cscl.tender.model.CsclTender> getCsclTenders(
		int start, int end) {

		return _csclTenderLocalService.getCsclTenders(start, end);
	}

	/**
	 * Returns the number of cscl tenders.
	 *
	 * @return the number of cscl tenders
	 */
	@Override
	public int getCsclTendersCount() {
		return _csclTenderLocalService.getCsclTendersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclTenderLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclTenderLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclTenderLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.cscl.tender.model.CsclTender> getTendersByStatus(
		int status) {

		return _csclTenderLocalService.getTendersByStatus(status);
	}

	/**
	 * Updates the cscl tender in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclTender the cscl tender
	 * @return the cscl tender that was updated
	 */
	@Override
	public com.cscl.tender.model.CsclTender updateCsclTender(
		com.cscl.tender.model.CsclTender csclTender) {

		return _csclTenderLocalService.updateCsclTender(csclTender);
	}

	@Override
	public CsclTenderLocalService getWrappedService() {
		return _csclTenderLocalService;
	}

	@Override
	public void setWrappedService(
		CsclTenderLocalService csclTenderLocalService) {

		_csclTenderLocalService = csclTenderLocalService;
	}

	private CsclTenderLocalService _csclTenderLocalService;

}