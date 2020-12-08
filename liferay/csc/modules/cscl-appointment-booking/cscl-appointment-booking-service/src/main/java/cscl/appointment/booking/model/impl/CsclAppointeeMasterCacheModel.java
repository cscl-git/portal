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

import cscl.appointment.booking.model.CsclAppointeeMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclAppointeeMaster in entity cache.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclAppointeeMasterCacheModel
	implements CacheModel<CsclAppointeeMaster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclAppointeeMasterCacheModel)) {
			return false;
		}

		CsclAppointeeMasterCacheModel csclAppointeeMasterCacheModel =
			(CsclAppointeeMasterCacheModel)obj;

		if (id_ == csclAppointeeMasterCacheModel.id_) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id_=");
		sb.append(id_);
		sb.append(", name=");
		sb.append(name);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclAppointeeMaster toEntityModel() {
		CsclAppointeeMasterImpl csclAppointeeMasterImpl =
			new CsclAppointeeMasterImpl();

		csclAppointeeMasterImpl.setId_(id_);

		if (name == null) {
			csclAppointeeMasterImpl.setName("");
		}
		else {
			csclAppointeeMasterImpl.setName(name);
		}

		if (designation == null) {
			csclAppointeeMasterImpl.setDesignation("");
		}
		else {
			csclAppointeeMasterImpl.setDesignation(designation);
		}

		csclAppointeeMasterImpl.setIsActive(isActive);

		csclAppointeeMasterImpl.resetOriginalValues();

		return csclAppointeeMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		name = objectInput.readUTF();
		designation = objectInput.readUTF();

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

		if (designation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(designation);
		}

		objectOutput.writeBoolean(isActive);
	}

	public long id_;
	public String name;
	public String designation;
	public boolean isActive;

}