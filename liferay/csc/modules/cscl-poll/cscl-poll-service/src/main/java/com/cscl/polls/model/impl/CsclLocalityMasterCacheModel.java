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

package com.cscl.polls.model.impl;

import com.cscl.polls.model.CsclLocalityMaster;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclLocalityMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclLocalityMasterCacheModel
	implements CacheModel<CsclLocalityMaster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclLocalityMasterCacheModel)) {
			return false;
		}

		CsclLocalityMasterCacheModel csclLocalityMasterCacheModel =
			(CsclLocalityMasterCacheModel)obj;

		if (localityId == csclLocalityMasterCacheModel.localityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, localityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{localityId=");
		sb.append(localityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclLocalityMaster toEntityModel() {
		CsclLocalityMasterImpl csclLocalityMasterImpl =
			new CsclLocalityMasterImpl();

		csclLocalityMasterImpl.setLocalityId(localityId);

		if (name == null) {
			csclLocalityMasterImpl.setName("");
		}
		else {
			csclLocalityMasterImpl.setName(name);
		}

		csclLocalityMasterImpl.setIsActive(isActive);

		csclLocalityMasterImpl.resetOriginalValues();

		return csclLocalityMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		localityId = objectInput.readLong();
		name = objectInput.readUTF();

		isActive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(localityId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(isActive);
	}

	public long localityId;
	public String name;
	public boolean isActive;

}