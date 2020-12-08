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

package com.cscl.search.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.cscl.search.service.http.CsclSearchServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclSearchSoap implements Serializable {

	public static CsclSearchSoap toSoapModel(CsclSearch model) {
		CsclSearchSoap soapModel = new CsclSearchSoap();

		soapModel.setId(model.getId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setKeywords(model.getKeywords());
		soapModel.setLink(model.getLink());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setUpdatedById(model.getUpdatedById());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CsclSearchSoap[] toSoapModels(CsclSearch[] models) {
		CsclSearchSoap[] soapModels = new CsclSearchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclSearchSoap[][] toSoapModels(CsclSearch[][] models) {
		CsclSearchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CsclSearchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclSearchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclSearchSoap[] toSoapModels(List<CsclSearch> models) {
		List<CsclSearchSoap> soapModels = new ArrayList<CsclSearchSoap>(
			models.size());

		for (CsclSearch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclSearchSoap[soapModels.size()]);
	}

	public CsclSearchSoap() {
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

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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

	private long _id;
	private String _name;
	private String _description;
	private String _keywords;
	private String _link;
	private int _status;
	private long _createdById;
	private long _updatedById;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}