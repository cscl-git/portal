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

package com.cscl.feedback.service.persistence;

import com.cscl.feedback.exception.NoSuchFeedbackException;
import com.cscl.feedback.model.Feedback;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the feedback service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackUtil
 * @generated
 */
@ProviderType
public interface FeedbackPersistence extends BasePersistence<Feedback> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FeedbackUtil} to access the feedback persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the feedbacks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching feedbacks
	 */
	public java.util.List<Feedback> findByUuid(String uuid);

	/**
	 * Returns a range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of matching feedbacks
	 */
	public java.util.List<Feedback> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching feedbacks
	 */
	@Deprecated
	public java.util.List<Feedback> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator, boolean useFinderCache);

	/**
	 * Returns an ordered range of all the feedbacks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching feedbacks
	 */
	public java.util.List<Feedback> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Feedback> orderByComparator);

	/**
	 * Returns the first feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	public Feedback findByUuid_First(
			String uuid, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException;

	/**
	 * Returns the first feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	public Feedback fetchByUuid_First(
		String uuid, OrderByComparator<Feedback> orderByComparator);

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback
	 * @throws NoSuchFeedbackException if a matching feedback could not be found
	 */
	public Feedback findByUuid_Last(
			String uuid, OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException;

	/**
	 * Returns the last feedback in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching feedback, or <code>null</code> if a matching feedback could not be found
	 */
	public Feedback fetchByUuid_Last(
		String uuid, OrderByComparator<Feedback> orderByComparator);

	/**
	 * Returns the feedbacks before and after the current feedback in the ordered set where uuid = &#63;.
	 *
	 * @param feedbackId the primary key of the current feedback
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	public Feedback[] findByUuid_PrevAndNext(
			long feedbackId, String uuid,
			OrderByComparator<Feedback> orderByComparator)
		throws NoSuchFeedbackException;

	/**
	 * Removes all the feedbacks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of feedbacks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching feedbacks
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the feedback in the entity cache if it is enabled.
	 *
	 * @param feedback the feedback
	 */
	public void cacheResult(Feedback feedback);

	/**
	 * Caches the feedbacks in the entity cache if it is enabled.
	 *
	 * @param feedbacks the feedbacks
	 */
	public void cacheResult(java.util.List<Feedback> feedbacks);

	/**
	 * Creates a new feedback with the primary key. Does not add the feedback to the database.
	 *
	 * @param feedbackId the primary key for the new feedback
	 * @return the new feedback
	 */
	public Feedback create(long feedbackId);

	/**
	 * Removes the feedback with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback that was removed
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	public Feedback remove(long feedbackId) throws NoSuchFeedbackException;

	public Feedback updateImpl(Feedback feedback);

	/**
	 * Returns the feedback with the primary key or throws a <code>NoSuchFeedbackException</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback
	 * @throws NoSuchFeedbackException if a feedback with the primary key could not be found
	 */
	public Feedback findByPrimaryKey(long feedbackId)
		throws NoSuchFeedbackException;

	/**
	 * Returns the feedback with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param feedbackId the primary key of the feedback
	 * @return the feedback, or <code>null</code> if a feedback with the primary key could not be found
	 */
	public Feedback fetchByPrimaryKey(long feedbackId);

	/**
	 * Returns all the feedbacks.
	 *
	 * @return the feedbacks
	 */
	public java.util.List<Feedback> findAll();

	/**
	 * Returns a range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @return the range of feedbacks
	 */
	public java.util.List<Feedback> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of feedbacks
	 */
	@Deprecated
	public java.util.List<Feedback> findAll(
		int start, int end, OrderByComparator<Feedback> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the feedbacks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>FeedbackModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of feedbacks
	 * @param end the upper bound of the range of feedbacks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of feedbacks
	 */
	public java.util.List<Feedback> findAll(
		int start, int end, OrderByComparator<Feedback> orderByComparator);

	/**
	 * Removes all the feedbacks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of feedbacks.
	 *
	 * @return the number of feedbacks
	 */
	public int countAll();

}