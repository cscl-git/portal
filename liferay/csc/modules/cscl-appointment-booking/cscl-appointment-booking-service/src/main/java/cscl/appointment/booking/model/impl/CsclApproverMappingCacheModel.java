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

import cscl.appointment.booking.model.CsclApproverMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclApproverMapping in entity cache.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclApproverMappingCacheModel
	implements CacheModel<CsclApproverMapping>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclApproverMappingCacheModel)) {
			return false;
		}

		CsclApproverMappingCacheModel csclApproverMappingCacheModel =
			(CsclApproverMappingCacheModel)obj;

		if (id_ == csclApproverMappingCacheModel.id_) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", appointee=");
		sb.append(appointee);
		sb.append(", approver=");
		sb.append(approver);
		sb.append(", assignedTo=");
		sb.append(assignedTo);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclApproverMapping toEntityModel() {
		CsclApproverMappingImpl csclApproverMappingImpl =
			new CsclApproverMappingImpl();

		csclApproverMappingImpl.setId_(id_);
		csclApproverMappingImpl.setAppointee(appointee);

		if (approver == null) {
			csclApproverMappingImpl.setApprover("");
		}
		else {
			csclApproverMappingImpl.setApprover(approver);
		}

		csclApproverMappingImpl.setAssignedTo(assignedTo);

		if (createdDate == Long.MIN_VALUE) {
			csclApproverMappingImpl.setCreatedDate(null);
		}
		else {
			csclApproverMappingImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclApproverMappingImpl.setModifiedDate(null);
		}
		else {
			csclApproverMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		csclApproverMappingImpl.resetOriginalValues();

		return csclApproverMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();

		appointee = objectInput.readInt();
		approver = objectInput.readUTF();

		assignedTo = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id_);

		objectOutput.writeInt(appointee);

		if (approver == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(approver);
		}

		objectOutput.writeLong(assignedTo);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id_;
	public int appointee;
	public String approver;
	public long assignedTo;
	public long createdDate;
	public long modifiedDate;

}