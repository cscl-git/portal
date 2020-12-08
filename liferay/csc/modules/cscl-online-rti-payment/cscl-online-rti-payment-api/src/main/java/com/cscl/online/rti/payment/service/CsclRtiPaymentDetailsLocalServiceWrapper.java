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

package com.cscl.online.rti.payment.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclRtiPaymentDetailsLocalService}.
 *
 * @author @rnab
 * @see CsclRtiPaymentDetailsLocalService
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsLocalServiceWrapper
	implements CsclRtiPaymentDetailsLocalService,
			   ServiceWrapper<CsclRtiPaymentDetailsLocalService> {

	public CsclRtiPaymentDetailsLocalServiceWrapper(
		CsclRtiPaymentDetailsLocalService csclRtiPaymentDetailsLocalService) {

		_csclRtiPaymentDetailsLocalService = csclRtiPaymentDetailsLocalService;
	}

	/**
	 * Adds the cscl rti payment details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 * @return the cscl rti payment details that was added
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
		addCsclRtiPaymentDetails(
			com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
				csclRtiPaymentDetails) {

		return _csclRtiPaymentDetailsLocalService.addCsclRtiPaymentDetails(
			csclRtiPaymentDetails);
	}

	/**
	 * Creates a new cscl rti payment details with the primary key. Does not add the cscl rti payment details to the database.
	 *
	 * @param id the primary key for the new cscl rti payment details
	 * @return the new cscl rti payment details
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
		createCsclRtiPaymentDetails(long id) {

		return _csclRtiPaymentDetailsLocalService.createCsclRtiPaymentDetails(
			id);
	}

	/**
	 * Deletes the cscl rti payment details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
		deleteCsclRtiPaymentDetails(
			com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
				csclRtiPaymentDetails) {

		return _csclRtiPaymentDetailsLocalService.deleteCsclRtiPaymentDetails(
			csclRtiPaymentDetails);
	}

	/**
	 * Deletes the cscl rti payment details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 * @throws PortalException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
			deleteCsclRtiPaymentDetails(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclRtiPaymentDetailsLocalService.deleteCsclRtiPaymentDetails(
			id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclRtiPaymentDetailsLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclRtiPaymentDetailsLocalService.dynamicQuery();
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

		return _csclRtiPaymentDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.online.rti.payment.model.impl.CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclRtiPaymentDetailsLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.online.rti.payment.model.impl.CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclRtiPaymentDetailsLocalService.dynamicQuery(
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

		return _csclRtiPaymentDetailsLocalService.dynamicQueryCount(
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

		return _csclRtiPaymentDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
		fetchCsclRtiPaymentDetails(long id) {

		return _csclRtiPaymentDetailsLocalService.fetchCsclRtiPaymentDetails(
			id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclRtiPaymentDetailsLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl rti payment details with the primary key.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details
	 * @throws PortalException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
			getCsclRtiPaymentDetails(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclRtiPaymentDetailsLocalService.getCsclRtiPaymentDetails(id);
	}

	/**
	 * Returns a range of all the cscl rti payment detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.online.rti.payment.model.impl.CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl rti payment detailses
	 * @param end the upper bound of the range of cscl rti payment detailses (not inclusive)
	 * @return the range of cscl rti payment detailses
	 */
	@Override
	public java.util.List
		<com.cscl.online.rti.payment.model.CsclRtiPaymentDetails>
			getCsclRtiPaymentDetailses(int start, int end) {

		return _csclRtiPaymentDetailsLocalService.getCsclRtiPaymentDetailses(
			start, end);
	}

	/**
	 * Returns the number of cscl rti payment detailses.
	 *
	 * @return the number of cscl rti payment detailses
	 */
	@Override
	public int getCsclRtiPaymentDetailsesCount() {
		return _csclRtiPaymentDetailsLocalService.
			getCsclRtiPaymentDetailsesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclRtiPaymentDetailsLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclRtiPaymentDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclRtiPaymentDetailsLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the cscl rti payment details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 * @return the cscl rti payment details that was updated
	 */
	@Override
	public com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
		updateCsclRtiPaymentDetails(
			com.cscl.online.rti.payment.model.CsclRtiPaymentDetails
				csclRtiPaymentDetails) {

		return _csclRtiPaymentDetailsLocalService.updateCsclRtiPaymentDetails(
			csclRtiPaymentDetails);
	}

	@Override
	public CsclRtiPaymentDetailsLocalService getWrappedService() {
		return _csclRtiPaymentDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		CsclRtiPaymentDetailsLocalService csclRtiPaymentDetailsLocalService) {

		_csclRtiPaymentDetailsLocalService = csclRtiPaymentDetailsLocalService;
	}

	private CsclRtiPaymentDetailsLocalService
		_csclRtiPaymentDetailsLocalService;

}