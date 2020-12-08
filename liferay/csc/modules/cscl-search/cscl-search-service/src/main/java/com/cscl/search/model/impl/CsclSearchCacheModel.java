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

package com.cscl.search.model.impl;

import com.cscl.search.model.CsclSearch;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing CsclSearch in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclSearchCacheModel
	implements CacheModel<CsclSearch>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclSearchCacheModel)) {
			return false;
		}

		CsclSearchCacheModel csclSearchCacheModel = (CsclSearchCacheModel)obj;

		if (id == csclSearchCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", keywords=");
		sb.append(keywords);
		sb.append(", link=");
		sb.append(link);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append(", updatedById=");
		sb.append(updatedById);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclSearch toEntityModel() {
		CsclSearchImpl csclSearchImpl = new CsclSearchImpl();

		csclSearchImpl.setId(id);

		if (name == null) {
			csclSearchImpl.setName("");
		}
		else {
			csclSearchImpl.setName(name);
		}

		if (description == null) {
			csclSearchImpl.setDescription("");
		}
		else {
			csclSearchImpl.setDescription(description);
		}

		if (keywords == null) {
			csclSearchImpl.setKeywords("");
		}
		else {
			csclSearchImpl.setKeywords(keywords);
		}

		if (link == null) {
			csclSearchImpl.setLink("");
		}
		else {
			csclSearchImpl.setLink(link);
		}

		csclSearchImpl.setStatus(status);
		csclSearchImpl.setCreatedById(createdById);
		csclSearchImpl.setUpdatedById(updatedById);

		if (userName == null) {
			csclSearchImpl.setUserName("");
		}
		else {
			csclSearchImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			csclSearchImpl.setCreateDate(null);
		}
		else {
			csclSearchImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclSearchImpl.setModifiedDate(null);
		}
		else {
			csclSearchImpl.setModifiedDate(new Date(modifiedDate));
		}

		csclSearchImpl.resetOriginalValues();

		return csclSearchImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		keywords = objectInput.readUTF();
		link = objectInput.readUTF();

		status = objectInput.readInt();

		createdById = objectInput.readLong();

		updatedById = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (keywords == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(keywords);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(createdById);

		objectOutput.writeLong(updatedById);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long id;
	public String name;
	public String description;
	public String keywords;
	public String link;
	public int status;
	public long createdById;
	public long updatedById;
	public String userName;
	public long createDate;
	public long modifiedDate;

}