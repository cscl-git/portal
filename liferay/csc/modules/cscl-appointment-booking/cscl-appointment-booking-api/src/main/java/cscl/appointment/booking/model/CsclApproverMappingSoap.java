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

package cscl.appointment.booking.model;

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
public class CsclApproverMappingSoap implements Serializable {

	public static CsclApproverMappingSoap toSoapModel(
		CsclApproverMapping model) {

		CsclApproverMappingSoap soapModel = new CsclApproverMappingSoap();

		soapModel.setId_(model.getId_());
		soapModel.setAppointee(model.getAppointee());
		soapModel.setApprover(model.getApprover());
		soapModel.setAssignedTo(model.getAssignedTo());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CsclApproverMappingSoap[] toSoapModels(
		CsclApproverMapping[] models) {

		CsclApproverMappingSoap[] soapModels =
			new CsclApproverMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclApproverMappingSoap[][] toSoapModels(
		CsclApproverMapping[][] models) {

		CsclApproverMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclApproverMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclApproverMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclApproverMappingSoap[] toSoapModels(
		List<CsclApproverMapping> models) {

		List<CsclApproverMappingSoap> soapModels =
			new ArrayList<CsclApproverMappingSoap>(models.size());

		for (CsclApproverMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclApproverMappingSoap[soapModels.size()]);
	}

	public CsclApproverMappingSoap() {
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

	public int getAppointee() {
		return _appointee;
	}

	public void setAppointee(int appointee) {
		_appointee = appointee;
	}

	public String getApprover() {
		return _approver;
	}

	public void setApprover(String approver) {
		_approver = approver;
	}

	public long getAssignedTo() {
		return _assignedTo;
	}

	public void setAssignedTo(long assignedTo) {
		_assignedTo = assignedTo;
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

	private long _id_;
	private int _appointee;
	private String _approver;
	private long _assignedTo;
	private Date _createdDate;
	private Date _modifiedDate;

}