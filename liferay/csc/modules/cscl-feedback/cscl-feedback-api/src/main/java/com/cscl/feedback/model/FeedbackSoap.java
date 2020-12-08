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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.cscl.feedback.service.http.FeedbackServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FeedbackSoap implements Serializable {

	public static FeedbackSoap toSoapModel(Feedback model) {
		FeedbackSoap soapModel = new FeedbackSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFeedbackId(model.getFeedbackId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobile(model.getMobile());
		soapModel.setComments(model.getComments());

		return soapModel;
	}

	public static FeedbackSoap[] toSoapModels(Feedback[] models) {
		FeedbackSoap[] soapModels = new FeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[][] toSoapModels(Feedback[][] models) {
		FeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FeedbackSoap[] toSoapModels(List<Feedback> models) {
		List<FeedbackSoap> soapModels = new ArrayList<FeedbackSoap>(
			models.size());

		for (Feedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FeedbackSoap[soapModels.size()]);
	}

	public FeedbackSoap() {
	}

	public long getPrimaryKey() {
		return _feedbackId;
	}

	public void setPrimaryKey(long pk) {
		setFeedbackId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFeedbackId() {
		return _feedbackId;
	}

	public void setFeedbackId(long feedbackId) {
		_feedbackId = feedbackId;
	}

	public long getCreatedById() {
		return _createdById;
	}

	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getComments() {
		return _comments;
	}

	public void setComments(String comments) {
		_comments = comments;
	}

	private String _uuid;
	private long _feedbackId;
	private long _createdById;
	private Date _createDate;
	private String _name;
	private String _email;
	private String _mobile;
	private String _comments;

}