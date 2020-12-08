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

import cscl.appointment.booking.model.CsclApproverMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclApproverMaster in entity cache.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclApproverMasterCacheModel
	implements CacheModel<CsclApproverMaster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclApproverMasterCacheModel)) {
			return false;
		}

		CsclApproverMasterCacheModel csclApproverMasterCacheModel =
			(CsclApproverMasterCacheModel)obj;

		if (id_ == csclApproverMasterCacheModel.id_) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", name=");
		sb.append(name);
		sb.append(", appointee=");
		sb.append(appointee);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclApproverMaster toEntityModel() {
		CsclApproverMasterImpl csclApproverMasterImpl =
			new CsclApproverMasterImpl();

		csclApproverMasterImpl.setId_(id_);

		if (name == null) {
			csclApproverMasterImpl.setName("");
		}
		else {
			csclApproverMasterImpl.setName(name);
		}

		if (appointee == null) {
			csclApproverMasterImpl.setAppointee("");
		}
		else {
			csclApproverMasterImpl.setAppointee(appointee);
		}

		csclApproverMasterImpl.setUserId(userId);
		csclApproverMasterImpl.setIsActive(isActive);

		csclApproverMasterImpl.resetOriginalValues();

		return csclApproverMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		name = objectInput.readUTF();
		appointee = objectInput.readUTF();

		userId = objectInput.readLong();

		isActive = objectInput.readBoolean();
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

		if (appointee == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appointee);
		}

		objectOutput.writeLong(userId);

		objectOutput.writeBoolean(isActive);
	}

	public long id_;
	public String name;
	public String appointee;
	public long userId;
	public boolean isActive;

}