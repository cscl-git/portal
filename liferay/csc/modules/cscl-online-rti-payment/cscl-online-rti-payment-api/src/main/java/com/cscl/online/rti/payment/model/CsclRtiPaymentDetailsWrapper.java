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

package com.cscl.online.rti.payment.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclRtiPaymentDetails}.
 * </p>
 *
 * @author @rnab
 * @see CsclRtiPaymentDetails
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsWrapper
	extends BaseModelWrapper<CsclRtiPaymentDetails>
	implements CsclRtiPaymentDetails, ModelWrapper<CsclRtiPaymentDetails> {

	public CsclRtiPaymentDetailsWrapper(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		super(csclRtiPaymentDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("applicantName", getApplicantName());
		attributes.put("applicantEmail", getApplicantEmail());
		attributes.put("applicantMobile", getApplicantMobile());
		attributes.put("address", getAddress());
		attributes.put("rtiSubject", getRtiSubject());
		attributes.put("rtiFeeAmount", getRtiFeeAmount());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("refId", getRefId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String applicantName = (String)attributes.get("applicantName");

		if (applicantName != null) {
			setApplicantName(applicantName);
		}

		String applicantEmail = (String)attributes.get("applicantEmail");

		if (applicantEmail != null) {
			setApplicantEmail(applicantEmail);
		}

		String applicantMobile = (String)attributes.get("applicantMobile");

		if (applicantMobile != null) {
			setApplicantMobile(applicantMobile);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String rtiSubject = (String)attributes.get("rtiSubject");

		if (rtiSubject != null) {
			setRtiSubject(rtiSubject);
		}

		Integer rtiFeeAmount = (Integer)attributes.get("rtiFeeAmount");

		if (rtiFeeAmount != null) {
			setRtiFeeAmount(rtiFeeAmount);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String refId = (String)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
		}
	}

	/**
	 * Returns the address of this cscl rti payment details.
	 *
	 * @return the address of this cscl rti payment details
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the applicant email of this cscl rti payment details.
	 *
	 * @return the applicant email of this cscl rti payment details
	 */
	@Override
	public String getApplicantEmail() {
		return model.getApplicantEmail();
	}

	/**
	 * Returns the applicant mobile of this cscl rti payment details.
	 *
	 * @return the applicant mobile of this cscl rti payment details
	 */
	@Override
	public String getApplicantMobile() {
		return model.getApplicantMobile();
	}

	/**
	 * Returns the applicant name of this cscl rti payment details.
	 *
	 * @return the applicant name of this cscl rti payment details
	 */
	@Override
	public String getApplicantName() {
		return model.getApplicantName();
	}

	/**
	 * Returns the created date of this cscl rti payment details.
	 *
	 * @return the created date of this cscl rti payment details
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the ID of this cscl rti payment details.
	 *
	 * @return the ID of this cscl rti payment details
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this cscl rti payment details.
	 *
	 * @return the modified date of this cscl rti payment details
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cscl rti payment details.
	 *
	 * @return the primary key of this cscl rti payment details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref ID of this cscl rti payment details.
	 *
	 * @return the ref ID of this cscl rti payment details
	 */
	@Override
	public String getRefId() {
		return model.getRefId();
	}

	/**
	 * Returns the rti fee amount of this cscl rti payment details.
	 *
	 * @return the rti fee amount of this cscl rti payment details
	 */
	@Override
	public int getRtiFeeAmount() {
		return model.getRtiFeeAmount();
	}

	/**
	 * Returns the rti subject of this cscl rti payment details.
	 *
	 * @return the rti subject of this cscl rti payment details
	 */
	@Override
	public String getRtiSubject() {
		return model.getRtiSubject();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this cscl rti payment details.
	 *
	 * @param address the address of this cscl rti payment details
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the applicant email of this cscl rti payment details.
	 *
	 * @param applicantEmail the applicant email of this cscl rti payment details
	 */
	@Override
	public void setApplicantEmail(String applicantEmail) {
		model.setApplicantEmail(applicantEmail);
	}

	/**
	 * Sets the applicant mobile of this cscl rti payment details.
	 *
	 * @param applicantMobile the applicant mobile of this cscl rti payment details
	 */
	@Override
	public void setApplicantMobile(String applicantMobile) {
		model.setApplicantMobile(applicantMobile);
	}

	/**
	 * Sets the applicant name of this cscl rti payment details.
	 *
	 * @param applicantName the applicant name of this cscl rti payment details
	 */
	@Override
	public void setApplicantName(String applicantName) {
		model.setApplicantName(applicantName);
	}

	/**
	 * Sets the created date of this cscl rti payment details.
	 *
	 * @param createdDate the created date of this cscl rti payment details
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the ID of this cscl rti payment details.
	 *
	 * @param id the ID of this cscl rti payment details
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this cscl rti payment details.
	 *
	 * @param modifiedDate the modified date of this cscl rti payment details
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cscl rti payment details.
	 *
	 * @param primaryKey the primary key of this cscl rti payment details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref ID of this cscl rti payment details.
	 *
	 * @param refId the ref ID of this cscl rti payment details
	 */
	@Override
	public void setRefId(String refId) {
		model.setRefId(refId);
	}

	/**
	 * Sets the rti fee amount of this cscl rti payment details.
	 *
	 * @param rtiFeeAmount the rti fee amount of this cscl rti payment details
	 */
	@Override
	public void setRtiFeeAmount(int rtiFeeAmount) {
		model.setRtiFeeAmount(rtiFeeAmount);
	}

	/**
	 * Sets the rti subject of this cscl rti payment details.
	 *
	 * @param rtiSubject the rti subject of this cscl rti payment details
	 */
	@Override
	public void setRtiSubject(String rtiSubject) {
		model.setRtiSubject(rtiSubject);
	}

	@Override
	protected CsclRtiPaymentDetailsWrapper wrap(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		return new CsclRtiPaymentDetailsWrapper(csclRtiPaymentDetails);
	}

}