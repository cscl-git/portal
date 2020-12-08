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

import com.cscl.polls.model.CsclPollsMaster;

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
 * The cache model class for representing CsclPollsMaster in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclPollsMasterCacheModel
	implements CacheModel<CsclPollsMaster>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclPollsMasterCacheModel)) {
			return false;
		}

		CsclPollsMasterCacheModel csclPollsMasterCacheModel =
			(CsclPollsMasterCacheModel)obj;

		if (entryId == csclPollsMasterCacheModel.entryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, entryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{entryId=");
		sb.append(entryId);
		sb.append(", voteId=");
		sb.append(voteId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", choiceId=");
		sb.append(choiceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", birthDate=");
		sb.append(birthDate);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", locality=");
		sb.append(locality);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclPollsMaster toEntityModel() {
		CsclPollsMasterImpl csclPollsMasterImpl = new CsclPollsMasterImpl();

		csclPollsMasterImpl.setEntryId(entryId);
		csclPollsMasterImpl.setVoteId(voteId);
		csclPollsMasterImpl.setQuestionId(questionId);
		csclPollsMasterImpl.setChoiceId(choiceId);

		if (name == null) {
			csclPollsMasterImpl.setName("");
		}
		else {
			csclPollsMasterImpl.setName(name);
		}

		if (email == null) {
			csclPollsMasterImpl.setEmail("");
		}
		else {
			csclPollsMasterImpl.setEmail(email);
		}

		if (mobile == null) {
			csclPollsMasterImpl.setMobile("");
		}
		else {
			csclPollsMasterImpl.setMobile(mobile);
		}

		if (birthDate == Long.MIN_VALUE) {
			csclPollsMasterImpl.setBirthDate(null);
		}
		else {
			csclPollsMasterImpl.setBirthDate(new Date(birthDate));
		}

		if (sex == null) {
			csclPollsMasterImpl.setSex("");
		}
		else {
			csclPollsMasterImpl.setSex(sex);
		}

		csclPollsMasterImpl.setLocality(locality);

		if (createdDate == Long.MIN_VALUE) {
			csclPollsMasterImpl.setCreatedDate(null);
		}
		else {
			csclPollsMasterImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclPollsMasterImpl.setModifiedDate(null);
		}
		else {
			csclPollsMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		csclPollsMasterImpl.resetOriginalValues();

		return csclPollsMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		entryId = objectInput.readLong();

		voteId = objectInput.readLong();

		questionId = objectInput.readLong();

		choiceId = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		mobile = objectInput.readUTF();
		birthDate = objectInput.readLong();
		sex = objectInput.readUTF();

		locality = objectInput.readInt();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(entryId);

		objectOutput.writeLong(voteId);

		objectOutput.writeLong(questionId);

		objectOutput.writeLong(choiceId);

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

		objectOutput.writeLong(birthDate);

		if (sex == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sex);
		}

		objectOutput.writeInt(locality);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long entryId;
	public long voteId;
	public long questionId;
	public long choiceId;
	public String name;
	public String email;
	public String mobile;
	public long birthDate;
	public String sex;
	public int locality;
	public long createdDate;
	public long modifiedDate;

}