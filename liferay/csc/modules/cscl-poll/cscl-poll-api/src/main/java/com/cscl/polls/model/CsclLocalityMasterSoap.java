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
public class CsclLocalityMasterSoap implements Serializable {

	public static CsclLocalityMasterSoap toSoapModel(CsclLocalityMaster model) {
		CsclLocalityMasterSoap soapModel = new CsclLocalityMasterSoap();

		soapModel.setLocalityId(model.getLocalityId());
		soapModel.setName(model.getName());
		soapModel.setIsActive(model.getIsActive());

		return soapModel;
	}

	public static CsclLocalityMasterSoap[] toSoapModels(
		CsclLocalityMaster[] models) {

		CsclLocalityMasterSoap[] soapModels =
			new CsclLocalityMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclLocalityMasterSoap[][] toSoapModels(
		CsclLocalityMaster[][] models) {

		CsclLocalityMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclLocalityMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclLocalityMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclLocalityMasterSoap[] toSoapModels(
		List<CsclLocalityMaster> models) {

		List<CsclLocalityMasterSoap> soapModels =
			new ArrayList<CsclLocalityMasterSoap>(models.size());

		for (CsclLocalityMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclLocalityMasterSoap[soapModels.size()]);
	}

	public CsclLocalityMasterSoap() {
	}

	public long getPrimaryKey() {
		return _localityId;
	}

	public void setPrimaryKey(long pk) {
		setLocalityId(pk);
	}

	public long getLocalityId() {
		return _localityId;
	}

	public void setLocalityId(long localityId) {
		_localityId = localityId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Boolean getIsActive() {
		return _isActive;
	}

	public void setIsActive(Boolean isActive) {
		_isActive = isActive;
	}

	private long _localityId;
	private String _name;
	private Boolean _isActive;

}