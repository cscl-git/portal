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
 * Provides a wrapper for {@link CsclPollsMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterLocalService
 * @generated
 */
@ProviderType
public class CsclPollsMasterLocalServiceWrapper
	implements CsclPollsMasterLocalService,
			   ServiceWrapper<CsclPollsMasterLocalService> {

	public CsclPollsMasterLocalServiceWrapper(
		CsclPollsMasterLocalService csclPollsMasterLocalService) {

		_csclPollsMasterLocalService = csclPollsMasterLocalService;
	}

	/**
	 * Adds the cscl polls master to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was added
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster addCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return _csclPollsMasterLocalService.addCsclPollsMaster(csclPollsMaster);
	}

	/**
	 * Creates a new cscl polls master with the primary key. Does not add the cscl polls master to the database.
	 *
	 * @param entryId the primary key for the new cscl polls master
	 * @return the new cscl polls master
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster createCsclPollsMaster(
		long entryId) {

		return _csclPollsMasterLocalService.createCsclPollsMaster(entryId);
	}

	/**
	 * Deletes the cscl polls master from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was removed
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster deleteCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return _csclPollsMasterLocalService.deleteCsclPollsMaster(
			csclPollsMaster);
	}

	/**
	 * Deletes the cscl polls master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master that was removed
	 * @throws PortalException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster deleteCsclPollsMaster(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsMasterLocalService.deleteCsclPollsMaster(entryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsMasterLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclPollsMasterLocalService.dynamicQuery();
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

		return _csclPollsMasterLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclPollsMasterLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclPollsMasterLocalService.dynamicQuery(
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

		return _csclPollsMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclPollsMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.polls.model.CsclPollsMaster fetchCsclPollsMaster(
		long entryId) {

		return _csclPollsMasterLocalService.fetchCsclPollsMaster(entryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclPollsMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl polls master with the primary key.
	 *
	 * @param entryId the primary key of the cscl polls master
	 * @return the cscl polls master
	 * @throws PortalException if a cscl polls master with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster getCsclPollsMaster(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsMasterLocalService.getCsclPollsMaster(entryId);
	}

	/**
	 * Returns a range of all the cscl polls masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls masters
	 * @param end the upper bound of the range of cscl polls masters (not inclusive)
	 * @return the range of cscl polls masters
	 */
	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getCsclPollsMasters(int start, int end) {

		return _csclPollsMasterLocalService.getCsclPollsMasters(start, end);
	}

	/**
	 * Returns the number of cscl polls masters.
	 *
	 * @return the number of cscl polls masters
	 */
	@Override
	public int getCsclPollsMastersCount() {
		return _csclPollsMasterLocalService.getCsclPollsMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclPollsMasterLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclPollsMasterLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsMasterLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster> getPollsByAge(
		long entryId, java.util.Date age) {

		return _csclPollsMasterLocalService.getPollsByAge(entryId, age);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByAgeAndLocality(
			long entryId, java.util.Date age, int locality) {

		return _csclPollsMasterLocalService.getPollsByAgeAndLocality(
			entryId, age, locality);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByAgeAndSex(long entryId, java.util.Date age, String sex) {

		return _csclPollsMasterLocalService.getPollsByAgeAndSex(
			entryId, age, sex);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalities(long entryId, int locality) {

		return _csclPollsMasterLocalService.getPollsByLocalities(
			entryId, locality);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalityAndSex(long entryId, int locality, String sex) {

		return _csclPollsMasterLocalService.getPollsByLocalityAndSex(
			entryId, locality, sex);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByLocalityAndSexAndAge(
			long entryId, int locality, String sex, java.util.Date age) {

		return _csclPollsMasterLocalService.getPollsByLocalityAndSexAndAge(
			entryId, locality, sex, age);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster>
		getPollsByQuestionId(long questionId) {

		return _csclPollsMasterLocalService.getPollsByQuestionId(questionId);
	}

	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsMaster> getPollsBySex(
		long entryId, String sex) {

		return _csclPollsMasterLocalService.getPollsBySex(entryId, sex);
	}

	/**
	 * Updates the cscl polls master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsMaster the cscl polls master
	 * @return the cscl polls master that was updated
	 */
	@Override
	public com.cscl.polls.model.CsclPollsMaster updateCsclPollsMaster(
		com.cscl.polls.model.CsclPollsMaster csclPollsMaster) {

		return _csclPollsMasterLocalService.updateCsclPollsMaster(
			csclPollsMaster);
	}

	@Override
	public CsclPollsMasterLocalService getWrappedService() {
		return _csclPollsMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CsclPollsMasterLocalService csclPollsMasterLocalService) {

		_csclPollsMasterLocalService = csclPollsMasterLocalService;
	}

	private CsclPollsMasterLocalService _csclPollsMasterLocalService;

}