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

package com.cscl.tender.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.cscl.tender.service.http.CsclTenderServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclTenderSoap implements Serializable {

	public static CsclTenderSoap toSoapModel(CsclTender model) {
		CsclTenderSoap soapModel = new CsclTenderSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setTenderId(model.getTenderId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setUpdatedById(model.getUpdatedById());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setTenderCategoryId(model.getTenderCategoryId());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setLastApplyDate(model.getLastApplyDate());
		soapModel.setTenderOpeningDate(model.getTenderOpeningDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static CsclTenderSoap[] toSoapModels(CsclTender[] models) {
		CsclTenderSoap[] soapModels = new CsclTenderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclTenderSoap[][] toSoapModels(CsclTender[][] models) {
		CsclTenderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CsclTenderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclTenderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclTenderSoap[] toSoapModels(List<CsclTender> models) {
		List<CsclTenderSoap> soapModels = new ArrayList<CsclTenderSoap>(
			models.size());

		for (CsclTender model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclTenderSoap[soapModels.size()]);
	}

	public CsclTenderSoap() {
	}

	public long getPrimaryKey() {
		return _tenderId;
	}

	public void setPrimaryKey(long pk) {
		setTenderId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getTenderId() {
		return _tenderId;
	}

	public void setTenderId(long tenderId) {
		_tenderId = tenderId;
	}

	public long getCreatedById() {
		return _createdById;
	}

	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	public long getUpdatedById() {
		return _updatedById;
	}

	public void setUpdatedById(long updatedById) {
		_updatedById = updatedById;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getTenderCategoryId() {
		return _tenderCategoryId;
	}

	public void setTenderCategoryId(long tenderCategoryId) {
		_tenderCategoryId = tenderCategoryId;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public Date getLastApplyDate() {
		return _lastApplyDate;
	}

	public void setLastApplyDate(Date lastApplyDate) {
		_lastApplyDate = lastApplyDate;
	}

	public Date getTenderOpeningDate() {
		return _tenderOpeningDate;
	}

	public void setTenderOpeningDate(Date tenderOpeningDate) {
		_tenderOpeningDate = tenderOpeningDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _tenderId;
	private long _createdById;
	private long _updatedById;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private long _tenderCategoryId;
	private Date _publishDate;
	private Date _lastApplyDate;
	private Date _tenderOpeningDate;
	private int _status;

}