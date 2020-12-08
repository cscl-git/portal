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

import com.cscl.polls.model.CsclPollsChoice;

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
 * The cache model class for representing CsclPollsChoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclPollsChoiceCacheModel
	implements CacheModel<CsclPollsChoice>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclPollsChoiceCacheModel)) {
			return false;
		}

		CsclPollsChoiceCacheModel csclPollsChoiceCacheModel =
			(CsclPollsChoiceCacheModel)obj;

		if (choiceId == csclPollsChoiceCacheModel.choiceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, choiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{choiceId=");
		sb.append(choiceId);
		sb.append(", questionId=");
		sb.append(questionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclPollsChoice toEntityModel() {
		CsclPollsChoiceImpl csclPollsChoiceImpl = new CsclPollsChoiceImpl();

		csclPollsChoiceImpl.setChoiceId(choiceId);
		csclPollsChoiceImpl.setQuestionId(questionId);

		if (name == null) {
			csclPollsChoiceImpl.setName("");
		}
		else {
			csclPollsChoiceImpl.setName(name);
		}

		if (description == null) {
			csclPollsChoiceImpl.setDescription("");
		}
		else {
			csclPollsChoiceImpl.setDescription(description);
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			csclPollsChoiceImpl.setLastPublishDate(null);
		}
		else {
			csclPollsChoiceImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		csclPollsChoiceImpl.resetOriginalValues();

		return csclPollsChoiceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		choiceId = objectInput.readLong();

		questionId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		lastPublishDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(choiceId);

		objectOutput.writeLong(questionId);

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

		objectOutput.writeLong(lastPublishDate);
	}

	public long choiceId;
	public long questionId;
	public String name;
	public String description;
	public long lastPublishDate;

}