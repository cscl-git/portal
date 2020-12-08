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
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclAgeFilterSoap implements Serializable {

	public static CsclAgeFilterSoap toSoapModel(CsclAgeFilter model) {
		CsclAgeFilterSoap soapModel = new CsclAgeFilterSoap();

		soapModel.setId_(model.getId_());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());
		soapModel.setIsActive(model.getIsActive());

		return soapModel;
	}

	public static CsclAgeFilterSoap[] toSoapModels(CsclAgeFilter[] models) {
		CsclAgeFilterSoap[] soapModels = new CsclAgeFilterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclAgeFilterSoap[][] toSoapModels(CsclAgeFilter[][] models) {
		CsclAgeFilterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CsclAgeFilterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclAgeFilterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclAgeFilterSoap[] toSoapModels(List<CsclAgeFilter> models) {
		List<CsclAgeFilterSoap> soapModels = new ArrayList<CsclAgeFilterSoap>(
			models.size());

		for (CsclAgeFilter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CsclAgeFilterSoap[soapModels.size()]);
	}

	public CsclAgeFilterSoap() {
	}

	public long getPrimaryKey() {
		return _id_;
	}

	public void setPrimaryKey(long pk) {
		setId_(pk);
	}

	public long getId_() {
		return _id_;
	}

	public void setId_(long id_) {
		_id_ = id_;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public Boolean getIsActive() {
		return _isActive;
	}

	public void setIsActive(Boolean isActive) {
		_isActive = isActive;
	}

	private long _id_;
	private String _name;
	private String _value;
	private Boolean _isActive;

}