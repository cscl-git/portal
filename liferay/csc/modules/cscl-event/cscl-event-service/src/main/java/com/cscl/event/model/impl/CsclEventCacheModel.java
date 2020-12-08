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

package com.cscl.event.model.impl;

import com.cscl.event.model.CsclEvent;

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
 * The cache model class for representing CsclEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclEventCacheModel
	implements CacheModel<CsclEvent>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclEventCacheModel)) {
			return false;
		}

		CsclEventCacheModel csclEventCacheModel = (CsclEventCacheModel)obj;

		if (eventId == csclEventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
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
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclEvent toEntityModel() {
		CsclEventImpl csclEventImpl = new CsclEventImpl();

		if (uuid == null) {
			csclEventImpl.setUuid("");
		}
		else {
			csclEventImpl.setUuid(uuid);
		}

		csclEventImpl.setEventId(eventId);
		csclEventImpl.setCreatedById(createdById);
		csclEventImpl.setUpdatedById(updatedById);

		if (userName == null) {
			csclEventImpl.setUserName("");
		}
		else {
			csclEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			csclEventImpl.setCreateDate(null);
		}
		else {
			csclEventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclEventImpl.setModifiedDate(null);
		}
		else {
			csclEventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			csclEventImpl.setTitle("");
		}
		else {
			csclEventImpl.setTitle(title);
		}

		if (description == null) {
			csclEventImpl.setDescription("");
		}
		else {
			csclEventImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			csclEventImpl.setStartDate(null);
		}
		else {
			csclEventImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			csclEventImpl.setEndDate(null);
		}
		else {
			csclEventImpl.setEndDate(new Date(endDate));
		}

		csclEventImpl.setStatus(status);

		csclEventImpl.resetOriginalValues();

		return csclEventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();

		createdById = objectInput.readLong();

		updatedById = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

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

		objectOutput.writeLong(eventId);

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

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long eventId;
	public long createdById;
	public long updatedById;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long startDate;
	public long endDate;
	public int status;

}