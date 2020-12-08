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
public class CsclAppointmentMasterSoap implements Serializable {

	public static CsclAppointmentMasterSoap toSoapModel(
		CsclAppointmentMaster model) {

		CsclAppointmentMasterSoap soapModel = new CsclAppointmentMasterSoap();

		soapModel.setId_(model.getId_());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMobile(model.getMobile());
		soapModel.setAddress(model.getAddress());
		soapModel.setAppointee(model.getAppointee());
		soapModel.setPreferedDate(model.getPreferedDate());
		soapModel.setPreferedTime(model.getPreferedTime());
		soapModel.setReason(model.getReason());
		soapModel.setRefId(model.getRefId());
		soapModel.setApprover(model.getApprover());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setAppointedDate(model.getAppointedDate());
		soapModel.setAppointedTime(model.getAppointedTime());
		soapModel.setComment(model.getComment());

		return soapModel;
	}

	public static CsclAppointmentMasterSoap[] toSoapModels(
		CsclAppointmentMaster[] models) {

		CsclAppointmentMasterSoap[] soapModels =
			new CsclAppointmentMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CsclAppointmentMasterSoap[][] toSoapModels(
		CsclAppointmentMaster[][] models) {

		CsclAppointmentMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new CsclAppointmentMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CsclAppointmentMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CsclAppointmentMasterSoap[] toSoapModels(
		List<CsclAppointmentMaster> models) {

		List<CsclAppointmentMasterSoap> soapModels =
			new ArrayList<CsclAppointmentMasterSoap>(models.size());

		for (CsclAppointmentMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new CsclAppointmentMasterSoap[soapModels.size()]);
	}

	public CsclAppointmentMasterSoap() {
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

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public int getAppointee() {
		return _appointee;
	}

	public void setAppointee(int appointee) {
		_appointee = appointee;
	}

	public Date getPreferedDate() {
		return _preferedDate;
	}

	public void setPreferedDate(Date preferedDate) {
		_preferedDate = preferedDate;
	}

	public String getPreferedTime() {
		return _preferedTime;
	}

	public void setPreferedTime(String preferedTime) {
		_preferedTime = preferedTime;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
	}

	public String getRefId() {
		return _refId;
	}

	public void setRefId(String refId) {
		_refId = refId;
	}

	public long getApprover() {
		return _approver;
	}

	public void setApprover(long approver) {
		_approver = approver;
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

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getAppointedDate() {
		return _appointedDate;
	}

	public void setAppointedDate(Date appointedDate) {
		_appointedDate = appointedDate;
	}

	public String getAppointedTime() {
		return _appointedTime;
	}

	public void setAppointedTime(String appointedTime) {
		_appointedTime = appointedTime;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	private long _id_;
	private String _name;
	private String _email;
	private String _mobile;
	private String _address;
	private int _appointee;
	private Date _preferedDate;
	private String _preferedTime;
	private String _reason;
	private String _refId;
	private long _approver;
	private Date _createdDate;
	private Date _modifiedDate;
	private int _status;
	private Date _appointedDate;
	private String _appointedTime;
	private String _comment;

}