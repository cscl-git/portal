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
public class CsclPollsMasterSoap implements Serializable {

	public static CsclPollsMasterSoap toSoapModel(CsclPollsMaster model) {
		CsclPollsMasterSoap soapModel = new CsclPollsMasterSoap();

		soapModel.setEntryId(model.getEntryId());
		soapModel.setVoteId(model.getVoteId());
		soapModel.setQuestionId(model.getQuestionId());
		soapModel.setChoiceId(model.getChoiceId());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobile(model.getMobile());
		soapModel.setBirthDate(model.getBirthDate());
		soapModel.setSex(model.getSex());
		soapModel.setLocality(model.getLocality());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CsclPollsMasterSoap[] toSoapModels(CsclPollsMaster[] models) {
		CsclPollsMasterSoap[] soapModels =
			new CsclPollsMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsMasterSoap[][] toSoapModels(
		CsclPollsMaster[][] models) {

		CsclPollsMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclPollsMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclPollsMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclPollsMasterSoap[] toSoapModels(
		List<CsclPollsMaster> models) {

		List<CsclPollsMasterSoap> soapModels =
			new ArrayList<CsclPollsMasterSoap>(models.size());

		for (CsclPollsMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclPollsMasterSoap[soapModels.size()]);
	}

	public CsclPollsMasterSoap() {
	}

	public long getPrimaryKey() {
		return _entryId;
	}

	public void setPrimaryKey(long pk) {
		setEntryId(pk);
	}

	public long getEntryId() {
		return _entryId;
	}

	public void setEntryId(long entryId) {
		_entryId = entryId;
	}

	public long getVoteId() {
		return _voteId;
	}

	public void setVoteId(long voteId) {
		_voteId = voteId;
	}

	public long getQuestionId() {
		return _questionId;
	}

	public void setQuestionId(long questionId) {
		_questionId = questionId;
	}

	public long getChoiceId() {
		return _choiceId;
	}

	public void setChoiceId(long choiceId) {
		_choiceId = choiceId;
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

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
	}

	public String getSex() {
		return _sex;
	}

	public void setSex(String sex) {
		_sex = sex;
	}

	public int getLocality() {
		return _locality;
	}

	public void setLocality(int locality) {
		_locality = locality;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _entryId;
	private long _voteId;
	private long _questionId;
	private long _choiceId;
	private String _name;
	private String _email;
	private String _mobile;
	private Date _birthDate;
	private String _sex;
	private int _locality;
	private Date _createdDate;
	private Date _modifiedDate;

}