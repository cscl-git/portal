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
 * This class is used by SOAP remote services, specifically {@link com.cscl.tender.service.http.CsclTenderCategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclTenderCategorySoap implements Serializable {

	public static CsclTenderCategorySoap toSoapModel(CsclTenderCategory model) {
		CsclTenderCategorySoap soapModel = new CsclTenderCategorySoap();

		soapModel.setTenderCatId(model.getTenderCatId());
		soapModel.setCreatedById(model.getCreatedById());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCategory(model.getCategory());

		return soapModel;
	}

	public static CsclTenderCategorySoap[] toSoapModels(
		CsclTenderCategory[] models) {

		CsclTenderCategorySoap[] soapModels =
			new CsclTenderCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclTenderCategorySoap[][] toSoapModels(
		CsclTenderCategory[][] models) {

		CsclTenderCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclTenderCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclTenderCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclTenderCategorySoap[] toSoapModels(
		List<CsclTenderCategory> models) {

		List<CsclTenderCategorySoap> soapModels =
			new ArrayList<CsclTenderCategorySoap>(models.size());

		for (CsclTenderCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclTenderCategorySoap[soapModels.size()]);
	}

	public CsclTenderCategorySoap() {
	}

	public long getPrimaryKey() {
		return _tenderCatId;
	}

	public void setPrimaryKey(long pk) {
		setTenderCatId(pk);
	}

	public long getTenderCatId() {
		return _tenderCatId;
	}

	public void setTenderCatId(long tenderCatId) {
		_tenderCatId = tenderCatId;
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

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	private long _tenderCatId;
	private long _createdById;
	private Date _createDate;
	private String _category;

}