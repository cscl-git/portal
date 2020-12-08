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

package com.cscl.feedback.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Feedback}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Feedback
 * @generated
 */
@ProviderType
public class FeedbackWrapper
	extends BaseModelWrapper<Feedback>
	implements Feedback, ModelWrapper<Feedback> {

	public FeedbackWrapper(Feedback feedback) {
		super(feedback);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("createdById", getCreatedById());
		attributes.put("createDate", getCreateDate());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("mobile", getMobile());
		attributes.put("comments", getComments());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Long createdById = (Long)attributes.get("createdById");

		if (createdById != null) {
			setCreatedById(createdById);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}
	}

	/**
	 * Returns the comments of this feedback.
	 *
	 * @return the comments of this feedback
	 */
	@Override
	public String getComments() {
		return model.getComments();
	}

	/**
	 * Returns the create date of this feedback.
	 *
	 * @return the create date of this feedback
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by ID of this feedback.
	 *
	 * @return the created by ID of this feedback
	 */
	@Override
	public long getCreatedById() {
		return model.getCreatedById();
	}

	/**
	 * Returns the email of this feedback.
	 *
	 * @return the email of this feedback
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the feedback ID of this feedback.
	 *
	 * @return the feedback ID of this feedback
	 */
	@Override
	public long getFeedbackId() {
		return model.getFeedbackId();
	}

	/**
	 * Returns the mobile of this feedback.
	 *
	 * @return the mobile of this feedback
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the name of this feedback.
	 *
	 * @return the name of this feedback
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this feedback.
	 *
	 * @return the primary key of this feedback
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this feedback.
	 *
	 * @return the uuid of this feedback
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the comments of this feedback.
	 *
	 * @param comments the comments of this feedback
	 */
	@Override
	public void setComments(String comments) {
		model.setComments(comments);
	}

	/**
	 * Sets the create date of this feedback.
	 *
	 * @param createDate the create date of this feedback
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by ID of this feedback.
	 *
	 * @param createdById the created by ID of this feedback
	 */
	@Override
	public void setCreatedById(long createdById) {
		model.setCreatedById(createdById);
	}

	/**
	 * Sets the email of this feedback.
	 *
	 * @param email the email of this feedback
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the feedback ID of this feedback.
	 *
	 * @param feedbackId the feedback ID of this feedback
	 */
	@Override
	public void setFeedbackId(long feedbackId) {
		model.setFeedbackId(feedbackId);
	}

	/**
	 * Sets the mobile of this feedback.
	 *
	 * @param mobile the mobile of this feedback
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the name of this feedback.
	 *
	 * @param name the name of this feedback
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this feedback.
	 *
	 * @param primaryKey the primary key of this feedback
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this feedback.
	 *
	 * @param uuid the uuid of this feedback
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected FeedbackWrapper wrap(Feedback feedback) {
		return new FeedbackWrapper(feedback);
	}

}