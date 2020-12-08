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

import com.cscl.polls.model.CsclAgeFilter;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclAgeFilter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclAgeFilterCacheModel
	implements CacheModel<CsclAgeFilter>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclAgeFilterCacheModel)) {
			return false;
		}

		CsclAgeFilterCacheModel csclAgeFilterCacheModel =
			(CsclAgeFilterCacheModel)obj;

		if (id_ == csclAgeFilterCacheModel.id_) {
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
		sb.append(", value=");
		sb.append(value);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclAgeFilter toEntityModel() {
		CsclAgeFilterImpl csclAgeFilterImpl = new CsclAgeFilterImpl();

		csclAgeFilterImpl.setId_(id_);

		if (name == null) {
			csclAgeFilterImpl.setName("");
		}
		else {
			csclAgeFilterImpl.setName(name);
		}

		if (value == null) {
			csclAgeFilterImpl.setValue("");
		}
		else {
			csclAgeFilterImpl.setValue(value);
		}

		csclAgeFilterImpl.setIsActive(isActive);

		csclAgeFilterImpl.resetOriginalValues();

		return csclAgeFilterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id_ = objectInput.readLong();
		name = objectInput.readUTF();
		value = objectInput.readUTF();

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

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		objectOutput.writeBoolean(isActive);
	}

	public long id_;
	public String name;
	public String value;
	public boolean isActive;

}