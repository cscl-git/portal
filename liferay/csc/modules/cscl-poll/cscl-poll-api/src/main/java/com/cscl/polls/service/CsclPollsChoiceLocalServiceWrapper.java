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
 * Provides a wrapper for {@link CsclPollsChoiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsChoiceLocalService
 * @generated
 */
@ProviderType
public class CsclPollsChoiceLocalServiceWrapper
	implements CsclPollsChoiceLocalService,
			   ServiceWrapper<CsclPollsChoiceLocalService> {

	public CsclPollsChoiceLocalServiceWrapper(
		CsclPollsChoiceLocalService csclPollsChoiceLocalService) {

		_csclPollsChoiceLocalService = csclPollsChoiceLocalService;
	}

	/**
	 * Adds the cscl polls choice to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was added
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice addCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return _csclPollsChoiceLocalService.addCsclPollsChoice(csclPollsChoice);
	}

	/**
	 * Creates a new cscl polls choice with the primary key. Does not add the cscl polls choice to the database.
	 *
	 * @param choiceId the primary key for the new cscl polls choice
	 * @return the new cscl polls choice
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice createCsclPollsChoice(
		long choiceId) {

		return _csclPollsChoiceLocalService.createCsclPollsChoice(choiceId);
	}

	/**
	 * Deletes the cscl polls choice from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was removed
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice deleteCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return _csclPollsChoiceLocalService.deleteCsclPollsChoice(
			csclPollsChoice);
	}

	/**
	 * Deletes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws PortalException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice deleteCsclPollsChoice(
			long choiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsChoiceLocalService.deleteCsclPollsChoice(choiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsChoiceLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclPollsChoiceLocalService.dynamicQuery();
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

		return _csclPollsChoiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclPollsChoiceLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclPollsChoiceLocalService.dynamicQuery(
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

		return _csclPollsChoiceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclPollsChoiceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.polls.model.CsclPollsChoice fetchCsclPollsChoice(
		long choiceId) {

		return _csclPollsChoiceLocalService.fetchCsclPollsChoice(choiceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclPollsChoiceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl polls choice with the primary key.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws PortalException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice getCsclPollsChoice(
			long choiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsChoiceLocalService.getCsclPollsChoice(choiceId);
	}

	/**
	 * Returns a range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.polls.model.impl.CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @return the range of cscl polls choices
	 */
	@Override
	public java.util.List<com.cscl.polls.model.CsclPollsChoice>
		getCsclPollsChoices(int start, int end) {

		return _csclPollsChoiceLocalService.getCsclPollsChoices(start, end);
	}

	/**
	 * Returns the number of cscl polls choices.
	 *
	 * @return the number of cscl polls choices
	 */
	@Override
	public int getCsclPollsChoicesCount() {
		return _csclPollsChoiceLocalService.getCsclPollsChoicesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclPollsChoiceLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclPollsChoiceLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclPollsChoiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl polls choice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 * @return the cscl polls choice that was updated
	 */
	@Override
	public com.cscl.polls.model.CsclPollsChoice updateCsclPollsChoice(
		com.cscl.polls.model.CsclPollsChoice csclPollsChoice) {

		return _csclPollsChoiceLocalService.updateCsclPollsChoice(
			csclPollsChoice);
	}

	@Override
	public CsclPollsChoiceLocalService getWrappedService() {
		return _csclPollsChoiceLocalService;
	}

	@Override
	public void setWrappedService(
		CsclPollsChoiceLocalService csclPollsChoiceLocalService) {

		_csclPollsChoiceLocalService = csclPollsChoiceLocalService;
	}

	private CsclPollsChoiceLocalService _csclPollsChoiceLocalService;

}