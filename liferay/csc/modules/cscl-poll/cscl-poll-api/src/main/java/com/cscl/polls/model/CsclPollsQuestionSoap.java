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
public class CsclPollsQuestionSoap implements Serializable {

	public static CsclPollsQuestionSoap toSoapModel(CsclPollsQuestion model) {
		CsclPollsQuestionSoap soapModel = new CsclPollsQuestionSoap();

		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setTitle(model.getTitle());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setDescription(model.getDescription());
		soapModel.setExpirationDate(model.getExpirationDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setLastVoteDate(model.getLastVoteDate());

		return soapModel;
	}

	public static CsclPollsQuestionSoap[] toSoapModels(
		CsclPollsQuestion[] models) {

		CsclPollsQuestionSoap[] soapModels =
			new CsclPollsQuestionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsQuestionSoap[][] toSoapModels(
		CsclPollsQuestion[][] models) {

		CsclPollsQuestionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclPollsQuestionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclPollsQuestionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsQuestionSoap[] toSoapModels(
		List<CsclPollsQuestion> models) {

		List<CsclPollsQuestionSoap> soapModels =
			new ArrayList<CsclPollsQuestionSoap>(models.size());

		for (CsclPollsQuestion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclPollsQuestionSoap[soapModels.size()]);
	}

	public CsclPollsQuestionSoap() {
	}

	public long getPrimaryKey() {
		return _questionId;
	}

	public void setPrimaryKey(long pk) {
		setQuestionId(pk);
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getExpirationDate() {
		return _expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		_expirationDate = expirationDate;
	}

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	public Date getLastVoteDate() {
		return _lastVoteDate;
	}

	public void setLastVoteDate(Date lastVoteDate) {
		_lastVoteDate = lastVoteDate;
	}

	private long _questionId;
	private String _title;
	private String _question;
	private String _description;
	private Date _expirationDate;
	private Date _lastPublishDate;
	private Date _lastVoteDate;

}