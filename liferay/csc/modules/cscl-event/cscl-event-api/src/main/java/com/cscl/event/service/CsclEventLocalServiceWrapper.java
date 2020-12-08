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

package com.cscl.event.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link CsclEventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CsclEventLocalService
 * @generated
 */
@ProviderType
public class CsclEventLocalServiceWrapper
	implements CsclEventLocalService, ServiceWrapper<CsclEventLocalService> {

	public CsclEventLocalServiceWrapper(
		CsclEventLocalService csclEventLocalService) {

		_csclEventLocalService = csclEventLocalService;
	}

	/**
	 * Adds the cscl event to the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclEvent the cscl event
	 * @return the cscl event that was added
	 */
	@Override
	public com.cscl.event.model.CsclEvent addCsclEvent(
		com.cscl.event.model.CsclEvent csclEvent) {

		return _csclEventLocalService.addCsclEvent(csclEvent);
	}

	/**
	 * Creates a new cscl event with the primary key. Does not add the cscl event to the database.
	 *
	 * @param eventId the primary key for the new cscl event
	 * @return the new cscl event
	 */
	@Override
	public com.cscl.event.model.CsclEvent createCsclEvent(long eventId) {
		return _csclEventLocalService.createCsclEvent(eventId);
	}

	/**
	 * Deletes the cscl event from the database. Also notifies the appropriate model listeners.
	 *
	 * @param csclEvent the cscl event
	 * @return the cscl event that was removed
	 */
	@Override
	public com.cscl.event.model.CsclEvent deleteCsclEvent(
		com.cscl.event.model.CsclEvent csclEvent) {

		return _csclEventLocalService.deleteCsclEvent(csclEvent);
	}

	/**
	 * Deletes the cscl event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event that was removed
	 * @throws PortalException if a cscl event with the primary key could not be found
	 */
	@Override
	public com.cscl.event.model.CsclEvent deleteCsclEvent(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclEventLocalService.deleteCsclEvent(eventId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclEventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _csclEventLocalService.dynamicQuery();
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

		return _csclEventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.event.model.impl.CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclEventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.event.model.impl.CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _csclEventLocalService.dynamicQuery(
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

		return _csclEventLocalService.dynamicQueryCount(dynamicQuery);
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

		return _csclEventLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.event.model.CsclEvent fetchCsclEvent(long eventId) {
		return _csclEventLocalService.fetchCsclEvent(eventId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _csclEventLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the cscl event with the primary key.
	 *
	 * @param eventId the primary key of the cscl event
	 * @return the cscl event
	 * @throws PortalException if a cscl event with the primary key could not be found
	 */
	@Override
	public com.cscl.event.model.CsclEvent getCsclEvent(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclEventLocalService.getCsclEvent(eventId);
	}

	/**
	 * Returns a range of all the cscl events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.event.model.impl.CsclEventModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl events
	 * @param end the upper bound of the range of cscl events (not inclusive)
	 * @return the range of cscl events
	 */
	@Override
	public java.util.List<com.cscl.event.model.CsclEvent> getCsclEvents(
		int start, int end) {

		return _csclEventLocalService.getCsclEvents(start, end);
	}

	/**
	 * Returns the number of cscl events.
	 *
	 * @return the number of cscl events
	 */
	@Override
	public int getCsclEventsCount() {
		return _csclEventLocalService.getCsclEventsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _csclEventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _csclEventLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _csclEventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the cscl event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param csclEvent the cscl event
	 * @return the cscl event that was updated
	 */
	@Override
	public com.cscl.event.model.CsclEvent updateCsclEvent(
		com.cscl.event.model.CsclEvent csclEvent) {

		return _csclEventLocalService.updateCsclEvent(csclEvent);
	}

	@Override
	public CsclEventLocalService getWrappedService() {
		return _csclEventLocalService;
	}

	@Override
	public void setWrappedService(CsclEventLocalService csclEventLocalService) {
		_csclEventLocalService = csclEventLocalService;
	}

	private CsclEventLocalService _csclEventLocalService;

}