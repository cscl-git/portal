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

import com.cscl.polls.model.CsclPollsQuestion;

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
 * The cache model class for representing CsclPollsQuestion in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclPollsQuestionCacheModel
	implements CacheModel<CsclPollsQuestion>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclPollsQuestionCacheModel)) {
			return false;
		}

		CsclPollsQuestionCacheModel csclPollsQuestionCacheModel =
			(CsclPollsQuestionCacheModel)obj;

		if (questionId == csclPollsQuestionCacheModel.questionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, questionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{questionId=");
		sb.append(questionId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", question=");
		sb.append(question);
		sb.append(", description=");
		sb.append(description);
		sb.append(", expirationDate=");
		sb.append(expirationDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", lastVoteDate=");
		sb.append(lastVoteDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclPollsQuestion toEntityModel() {
		CsclPollsQuestionImpl csclPollsQuestionImpl =
			new CsclPollsQuestionImpl();

		csclPollsQuestionImpl.setQuestionId(questionId);

		if (title == null) {
			csclPollsQuestionImpl.setTitle("");
		}
		else {
			csclPollsQuestionImpl.setTitle(title);
		}

		if (question == null) {
			csclPollsQuestionImpl.setQuestion("");
		}
		else {
			csclPollsQuestionImpl.setQuestion(question);
		}

		if (description == null) {
			csclPollsQuestionImpl.setDescription("");
		}
		else {
			csclPollsQuestionImpl.setDescription(description);
		}

		if (expirationDate == Long.MIN_VALUE) {
			csclPollsQuestionImpl.setExpirationDate(null);
		}
		else {
			csclPollsQuestionImpl.setExpirationDate(new Date(expirationDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			csclPollsQuestionImpl.setLastPublishDate(null);
		}
		else {
			csclPollsQuestionImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		if (lastVoteDate == Long.MIN_VALUE) {
			csclPollsQuestionImpl.setLastVoteDate(null);
		}
		else {
			csclPollsQuestionImpl.setLastVoteDate(new Date(lastVoteDate));
		}

		csclPollsQuestionImpl.resetOriginalValues();

		return csclPollsQuestionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionId = objectInput.readLong();
		title = objectInput.readUTF();
		question = objectInput.readUTF();
		description = objectInput.readUTF();
		expirationDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();
		lastVoteDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(questionId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (question == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(question);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(expirationDate);
		objectOutput.writeLong(lastPublishDate);
		objectOutput.writeLong(lastVoteDate);
	}

	public long questionId;
	public String title;
	public String question;
	public String description;
	public long expirationDate;
	public long lastPublishDate;
	public long lastVoteDate;

}