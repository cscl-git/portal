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

package com.cscl.polls.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclPollsChoiceSoap implements Serializable {

	public static CsclPollsChoiceSoap toSoapModel(CsclPollsChoice model) {
		CsclPollsChoiceSoap soapModel = new CsclPollsChoiceSoap();

		soapModel.setChoiceId(model.getChoiceId());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setLastPublishDate(model.getLastPublishDate());

		return soapModel;
	}

	public static CsclPollsChoiceSoap[] toSoapModels(CsclPollsChoice[] models) {
		CsclPollsChoiceSoap[] soapModels =
			new CsclPollsChoiceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsChoiceSoap[][] toSoapModels(
		CsclPollsChoice[][] models) {

		CsclPollsChoiceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclPollsChoiceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclPollsChoiceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsChoiceSoap[] toSoapModels(
		List<CsclPollsChoice> models) {

		List<CsclPollsChoiceSoap> soapModels =
			new ArrayList<CsclPollsChoiceSoap>(models.size());

		for (CsclPollsChoice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclPollsChoiceSoap[soapModels.size()]);
	}

	public CsclPollsChoiceSoap() {
	}

	public long getPrimaryKey() {
		return _choiceId;
	}

	public void setPrimaryKey(long pk) {
		setChoiceId(pk);
	}

	public long getChoiceId() {
		return _choiceId;
	}

	public void setChoiceId(long choiceId) {
		_choiceId = choiceId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	private long _choiceId;
	private long _questionId;
	private String _name;
	private String _description;
	private Date _lastPublishDate;

}