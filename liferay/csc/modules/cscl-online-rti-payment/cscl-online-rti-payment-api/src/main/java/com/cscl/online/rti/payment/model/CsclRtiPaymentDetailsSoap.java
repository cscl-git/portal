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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsSoap implements Serializable {

	public static CsclRtiPaymentDetailsSoap toSoapModel(
		CsclRtiPaymentDetails model) {

		CsclRtiPaymentDetailsSoap soapModel = new CsclRtiPaymentDetailsSoap();

		soapModel.setId(model.getId());
		soapModel.setApplicantName(model.getApplicantName());
		soapModel.setApplicantEmail(model.getApplicantEmail());
		soapModel.setApplicantMobile(model.getApplicantMobile());
		soapModel.setAddress(model.getAddress());
		soapModel.setRtiSubject(model.getRtiSubject());
		soapModel.setRtiFeeAmount(model.getRtiFeeAmount());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRefId(model.getRefId());

		return soapModel;
	}

	public static CsclRtiPaymentDetailsSoap[] toSoapModels(
		CsclRtiPaymentDetails[] models) {

		CsclRtiPaymentDetailsSoap[] soapModels =
			new CsclRtiPaymentDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclRtiPaymentDetailsSoap[][] toSoapModels(
		CsclRtiPaymentDetails[][] models) {

		CsclRtiPaymentDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclRtiPaymentDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclRtiPaymentDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclRtiPaymentDetailsSoap[] toSoapModels(
		List<CsclRtiPaymentDetails> models) {

		List<CsclRtiPaymentDetailsSoap> soapModels =
			new ArrayList<CsclRtiPaymentDetailsSoap>(models.size());

		for (CsclRtiPaymentDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclRtiPaymentDetailsSoap[soapModels.size()]);
	}

	public CsclRtiPaymentDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getApplicantName() {
		return _applicantName;
	}

	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	public String getApplicantEmail() {
		return _applicantEmail;
	}

	public void setApplicantEmail(String applicantEmail) {
		_applicantEmail = applicantEmail;
	}

	public String getApplicantMobile() {
		return _applicantMobile;
	}

	public void setApplicantMobile(String applicantMobile) {
		_applicantMobile = applicantMobile;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getRtiSubject() {
		return _rtiSubject;
	}

	public void setRtiSubject(String rtiSubject) {
		_rtiSubject = rtiSubject;
	}

	public int getRtiFeeAmount() {
		return _rtiFeeAmount;
	}

	public void setRtiFeeAmount(int rtiFeeAmount) {
		_rtiFeeAmount = rtiFeeAmount;
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

	public String getRefId() {
		return _refId;
	}

	public void setRefId(String refId) {
		_refId = refId;
	}

	private long _id;
	private String _applicantName;
	private String _applicantEmail;
	private String _applicantMobile;
	private String _address;
	private String _rtiSubject;
	private int _rtiFeeAmount;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _refId;

}