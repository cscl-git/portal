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

package com.cscl.feedback.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link FeedbackLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackLocalService
 * @generated
 */
@ProviderType
public class FeedbackLocalServiceWrapper
	implements FeedbackLocalService, ServiceWrapper<FeedbackLocalService> {

	public FeedbackLocalServiceWrapper(
		FeedbackLocalService feedbackLocalService) {

		_feedbackLocalService = feedbackLocalService;
	}

	/**
	 * Adds the feedback to the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was added
	 */
	@Override
	public com.cscl.feedback.model.Feedback addFeedback(
		com.cscl.feedback.model.Feedback feedback) {

		return _feedbackLocalService.addFeedback(feedback);
	}

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	@Override
	public com.cscl.feedback.model.Feedback createFeedback(long feedbackId) {
		return _feedbackLocalService.createFeedback(feedbackId);
	}

	/**
	 * Deletes the feedback from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was removed
	 */
	@Override
	public com.cscl.feedback.model.Feedback deleteFeedback(
		com.cscl.feedback.model.Feedback feedback) {

		return _feedbackLocalService.deleteFeedback(feedback);
	}

	/**
	 * Deletes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws PortalException if a feedback with the primary key could not be found
	 */
	@Override
	public com.cscl.feedback.model.Feedback deleteFeedback(long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _feedbackLocalService.deleteFeedback(feedbackId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _feedbackLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _feedbackLocalService.dynamicQuery();
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

		return _feedbackLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.feedback.model.impl.FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _feedbackLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.feedback.model.impl.FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _feedbackLocalService.dynamicQuery(
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

		return _feedbackLocalService.dynamicQueryCount(dynamicQuery);
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

		return _feedbackLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.cscl.feedback.model.Feedback fetchFeedback(long feedbackId) {
		return _feedbackLocalService.fetchFeedback(feedbackId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _feedbackLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the feedback with the primary key.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws PortalException if a feedback with the primary key could not be found
	 */
	@Override
	public com.cscl.feedback.model.Feedback getFeedback(long feedbackId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _feedbackLocalService.getFeedback(feedbackId);
	}

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.cscl.feedback.model.impl.FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 */
	@Override
	public java.util.List<com.cscl.feedback.model.Feedback> getFeedbacks(
		int start, int end) {

		return _feedbackLocalService.getFeedbacks(start, end);
	}

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
	 */
	@Override
	public int getFeedbacksCount() {
		return _feedbackLocalService.getFeedbacksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _feedbackLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _feedbackLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _feedbackLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the feedback in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param feedback the feedback
	 * @return the feedback that was updated
	 */
	@Override
	public com.cscl.feedback.model.Feedback updateFeedback(
		com.cscl.feedback.model.Feedback feedback) {

		return _feedbackLocalService.updateFeedback(feedback);
	}

	@Override
	public FeedbackLocalService getWrappedService() {
		return _feedbackLocalService;
	}

	@Override
	public void setWrappedService(FeedbackLocalService feedbackLocalService) {
		_feedbackLocalService = feedbackLocalService;
	}

	private FeedbackLocalService _feedbackLocalService;

}