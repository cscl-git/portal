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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclPollsMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMaster
 * @generated
 */
@ProviderType
public class CsclPollsMasterWrapper
	extends BaseModelWrapper<CsclPollsMaster>
	implements CsclPollsMaster, ModelWrapper<CsclPollsMaster> {

	public CsclPollsMasterWrapper(CsclPollsMaster csclPollsMaster) {
		super(csclPollsMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("entryId", getEntryId());
		attributes.put("voteId", getVoteId());
		attributes.put("questionId", getQuestionId());
		attributes.put("choiceId", getChoiceId());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("mobile", getMobile());
		attributes.put("birthDate", getBirthDate());
		attributes.put("sex", getSex());
		attributes.put("locality", getLocality());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long entryId = (Long)attributes.get("entryId");

		if (entryId != null) {
			setEntryId(entryId);
		}

		Long voteId = (Long)attributes.get("voteId");

		if (voteId != null) {
			setVoteId(voteId);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		Long choiceId = (Long)attributes.get("choiceId");

		if (choiceId != null) {
			setChoiceId(choiceId);
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

		Date birthDate = (Date)attributes.get("birthDate");

		if (birthDate != null) {
			setBirthDate(birthDate);
		}

		String sex = (String)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		Integer locality = (Integer)attributes.get("locality");

		if (locality != null) {
			setLocality(locality);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the birth date of this cscl polls master.
	 *
	 * @return the birth date of this cscl polls master
	 */
	@Override
	public Date getBirthDate() {
		return model.getBirthDate();
	}

	/**
	 * Returns the choice ID of this cscl polls master.
	 *
	 * @return the choice ID of this cscl polls master
	 */
	@Override
	public long getChoiceId() {
		return model.getChoiceId();
	}

	/**
	 * Returns the created date of this cscl polls master.
	 *
	 * @return the created date of this cscl polls master
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the email of this cscl polls master.
	 *
	 * @return the email of this cscl polls master
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the entry ID of this cscl polls master.
	 *
	 * @return the entry ID of this cscl polls master
	 */
	@Override
	public long getEntryId() {
		return model.getEntryId();
	}

	/**
	 * Returns the locality of this cscl polls master.
	 *
	 * @return the locality of this cscl polls master
	 */
	@Override
	public int getLocality() {
		return model.getLocality();
	}

	/**
	 * Returns the mobile of this cscl polls master.
	 *
	 * @return the mobile of this cscl polls master
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the modified date of this cscl polls master.
	 *
	 * @return the modified date of this cscl polls master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this cscl polls master.
	 *
	 * @return the name of this cscl polls master
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl polls master.
	 *
	 * @return the primary key of this cscl polls master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question ID of this cscl polls master.
	 *
	 * @return the question ID of this cscl polls master
	 */
	@Override
	public long getQuestionId() {
		return model.getQuestionId();
	}

	/**
	 * Returns the sex of this cscl polls master.
	 *
	 * @return the sex of this cscl polls master
	 */
	@Override
	public String getSex() {
		return model.getSex();
	}

	/**
	 * Returns the vote ID of this cscl polls master.
	 *
	 * @return the vote ID of this cscl polls master
	 */
	@Override
	public long getVoteId() {
		return model.getVoteId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birth date of this cscl polls master.
	 *
	 * @param birthDate the birth date of this cscl polls master
	 */
	@Override
	public void setBirthDate(Date birthDate) {
		model.setBirthDate(birthDate);
	}

	/**
	 * Sets the choice ID of this cscl polls master.
	 *
	 * @param choiceId the choice ID of this cscl polls master
	 */
	@Override
	public void setChoiceId(long choiceId) {
		model.setChoiceId(choiceId);
	}

	/**
	 * Sets the created date of this cscl polls master.
	 *
	 * @param createdDate the created date of this cscl polls master
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the email of this cscl polls master.
	 *
	 * @param email the email of this cscl polls master
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the entry ID of this cscl polls master.
	 *
	 * @param entryId the entry ID of this cscl polls master
	 */
	@Override
	public void setEntryId(long entryId) {
		model.setEntryId(entryId);
	}

	/**
	 * Sets the locality of this cscl polls master.
	 *
	 * @param locality the locality of this cscl polls master
	 */
	@Override
	public void setLocality(int locality) {
		model.setLocality(locality);
	}

	/**
	 * Sets the mobile of this cscl polls master.
	 *
	 * @param mobile the mobile of this cscl polls master
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the modified date of this cscl polls master.
	 *
	 * @param modifiedDate the modified date of this cscl polls master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this cscl polls master.
	 *
	 * @param name the name of this cscl polls master
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl polls master.
	 *
	 * @param primaryKey the primary key of this cscl polls master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question ID of this cscl polls master.
	 *
	 * @param questionId the question ID of this cscl polls master
	 */
	@Override
	public void setQuestionId(long questionId) {
		model.setQuestionId(questionId);
	}

	/**
	 * Sets the sex of this cscl polls master.
	 *
	 * @param sex the sex of this cscl polls master
	 */
	@Override
	public void setSex(String sex) {
		model.setSex(sex);
	}

	/**
	 * Sets the vote ID of this cscl polls master.
	 *
	 * @param voteId the vote ID of this cscl polls master
	 */
	@Override
	public void setVoteId(long voteId) {
		model.setVoteId(voteId);
	}

	@Override
	protected CsclPollsMasterWrapper wrap(CsclPollsMaster csclPollsMaster) {
		return new CsclPollsMasterWrapper(csclPollsMaster);
	}

}