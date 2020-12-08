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

package cscl.appointment.booking.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import cscl.appointment.booking.model.CsclAppointmentMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclAppointmentMaster in entity cache.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclAppointmentMasterCacheModel
	implements CacheModel<CsclAppointmentMaster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclAppointmentMasterCacheModel)) {
			return false;
		}

		CsclAppointmentMasterCacheModel csclAppointmentMasterCacheModel =
			(CsclAppointmentMasterCacheModel)obj;

		if (id_ == csclAppointmentMasterCacheModel.id_) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id_);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", address=");
		sb.append(address);
		sb.append(", appointee=");
		sb.append(appointee);
		sb.append(", preferedDate=");
		sb.append(preferedDate);
		sb.append(", preferedTime=");
		sb.append(preferedTime);
		sb.append(", reason=");
		sb.append(reason);
		sb.append(", refId=");
		sb.append(refId);
		sb.append(", approver=");
		sb.append(approver);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", appointedDate=");
		sb.append(appointedDate);
		sb.append(", appointedTime=");
		sb.append(appointedTime);
		sb.append(", comment=");
		sb.append(comment);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclAppointmentMaster toEntityModel() {
		CsclAppointmentMasterImpl csclAppointmentMasterImpl =
			new CsclAppointmentMasterImpl();

		csclAppointmentMasterImpl.setId_(id_);

		if (name == null) {
			csclAppointmentMasterImpl.setName("");
		}
		else {
			csclAppointmentMasterImpl.setName(name);
		}

		if (email == null) {
			csclAppointmentMasterImpl.setEmail("");
		}
		else {
			csclAppointmentMasterImpl.setEmail(email);
		}

		if (mobile == null) {
			csclAppointmentMasterImpl.setMobile("");
		}
		else {
			csclAppointmentMasterImpl.setMobile(mobile);
		}

		if (address == null) {
			csclAppointmentMasterImpl.setAddress("");
		}
		else {
			csclAppointmentMasterImpl.setAddress(address);
		}

		csclAppointmentMasterImpl.setAppointee(appointee);

		if (preferedDate == Long.MIN_VALUE) {
			csclAppointmentMasterImpl.setPreferedDate(null);
		}
		else {
			csclAppointmentMasterImpl.setPreferedDate(new Date(preferedDate));
		}

		if (preferedTime == null) {
			csclAppointmentMasterImpl.setPreferedTime("");
		}
		else {
			csclAppointmentMasterImpl.setPreferedTime(preferedTime);
		}

		if (reason == null) {
			csclAppointmentMasterImpl.setReason("");
		}
		else {
			csclAppointmentMasterImpl.setReason(reason);
		}

		if (refId == null) {
			csclAppointmentMasterImpl.setRefId("");
		}
		else {
			csclAppointmentMasterImpl.setRefId(refId);
		}

		csclAppointmentMasterImpl.setApprover(approver);

		if (createdDate == Long.MIN_VALUE) {
			csclAppointmentMasterImpl.setCreatedDate(null);
		}
		else {
			csclAppointmentMasterImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclAppointmentMasterImpl.setModifiedDate(null);
		}
		else {
			csclAppointmentMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		csclAppointmentMasterImpl.setStatus(status);

		if (appointedDate == Long.MIN_VALUE) {
			csclAppointmentMasterImpl.setAppointedDate(null);
		}
		else {
			csclAppointmentMasterImpl.setAppointedDate(new Date(appointedDate));
		}

		if (appointedTime == null) {
			csclAppointmentMasterImpl.setAppointedTime("");
		}
		else {
			csclAppointmentMasterImpl.setAppointedTime(appointedTime);
		}

		if (comment == null) {
			csclAppointmentMasterImpl.setComment("");
		}
		else {
			csclAppointmentMasterImpl.setComment(comment);
		}

		csclAppointmentMasterImpl.resetOriginalValues();

		return csclAppointmentMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		mobile = objectInput.readUTF();
		address = objectInput.readUTF();

		appointee = objectInput.readInt();
		preferedDate = objectInput.readLong();
		preferedTime = objectInput.readUTF();
		reason = objectInput.readUTF();
		refId = objectInput.readUTF();

		approver = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();
		appointedDate = objectInput.readLong();
		appointedTime = objectInput.readUTF();
		comment = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (mobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		objectOutput.writeInt(appointee);
		objectOutput.writeLong(preferedDate);

		if (preferedTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(preferedTime);
		}

		if (reason == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reason);
		}

		if (refId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refId);
		}

		objectOutput.writeLong(approver);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);
		objectOutput.writeLong(appointedDate);

		if (appointedTime == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appointedTime);
		}

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}
	}

	public long id_;
	public String name;
	public String email;
	public String mobile;
	public String address;
	public int appointee;
	public long preferedDate;
	public String preferedTime;
	public String reason;
	public String refId;
	public long approver;
	public long createdDate;
	public long modifiedDate;
	public int status;
	public long appointedDate;
	public String appointedTime;
	public String comment;

}