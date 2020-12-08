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

package com.cscl.tender.model.impl;

import com.cscl.tender.model.CsclTender;

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
 * The cache model class for representing CsclTender in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclTenderCacheModel
	implements CacheModel<CsclTender>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclTenderCacheModel)) {
			return false;
		}

		CsclTenderCacheModel csclTenderCacheModel = (CsclTenderCacheModel)obj;

		if (tenderId == csclTenderCacheModel.tenderId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", tenderId=");
		sb.append(tenderId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", tenderCategoryId=");
		sb.append(tenderCategoryId);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", lastApplyDate=");
		sb.append(lastApplyDate);
		sb.append(", tenderOpeningDate=");
		sb.append(tenderOpeningDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclTender toEntityModel() {
		CsclTenderImpl csclTenderImpl = new CsclTenderImpl();

		if (uuid == null) {
			csclTenderImpl.setUuid("");
		}
		else {
			csclTenderImpl.setUuid(uuid);
		}

		csclTenderImpl.setTenderId(tenderId);
		csclTenderImpl.setCreatedById(createdById);
		csclTenderImpl.setUpdatedById(updatedById);

		if (userName == null) {
			csclTenderImpl.setUserName("");
		}
		else {
			csclTenderImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			csclTenderImpl.setCreateDate(null);
		}
		else {
			csclTenderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclTenderImpl.setModifiedDate(null);
		}
		else {
			csclTenderImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			csclTenderImpl.setTitle("");
		}
		else {
			csclTenderImpl.setTitle(title);
		}

		if (description == null) {
			csclTenderImpl.setDescription("");
		}
		else {
			csclTenderImpl.setDescription(description);
		}

		csclTenderImpl.setTenderCategoryId(tenderCategoryId);

		if (publishDate == Long.MIN_VALUE) {
			csclTenderImpl.setPublishDate(null);
		}
		else {
			csclTenderImpl.setPublishDate(new Date(publishDate));
		}

		if (lastApplyDate == Long.MIN_VALUE) {
			csclTenderImpl.setLastApplyDate(null);
		}
		else {
			csclTenderImpl.setLastApplyDate(new Date(lastApplyDate));
		}

		if (tenderOpeningDate == Long.MIN_VALUE) {
			csclTenderImpl.setTenderOpeningDate(null);
		}
		else {
			csclTenderImpl.setTenderOpeningDate(new Date(tenderOpeningDate));
		}

		csclTenderImpl.setStatus(status);

		csclTenderImpl.resetOriginalValues();

		return csclTenderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		tenderId = objectInput.readLong();

		createdById = objectInput.readLong();

		updatedById = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		tenderCategoryId = objectInput.readLong();
		publishDate = objectInput.readLong();
		lastApplyDate = objectInput.readLong();
		tenderOpeningDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(tenderId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(tenderCategoryId);
		objectOutput.writeLong(publishDate);
		objectOutput.writeLong(lastApplyDate);
		objectOutput.writeLong(tenderOpeningDate);

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long tenderId;
	public long createdById;
	public long updatedById;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long tenderCategoryId;
	public long publishDate;
	public long lastApplyDate;
	public long tenderOpeningDate;
	public int status;

}