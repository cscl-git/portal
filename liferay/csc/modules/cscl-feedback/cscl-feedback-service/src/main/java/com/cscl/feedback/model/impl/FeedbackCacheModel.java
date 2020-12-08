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

package com.cscl.feedback.model.impl;

import com.cscl.feedback.model.Feedback;

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
 * The cache model class for representing Feedback in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FeedbackCacheModel
	implements CacheModel<Feedback>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FeedbackCacheModel)) {
			return false;
		}

		FeedbackCacheModel feedbackCacheModel = (FeedbackCacheModel)obj;

		if (feedbackId == feedbackCacheModel.feedbackId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, feedbackId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", feedbackId=");
		sb.append(feedbackId);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		if (uuid == null) {
			feedbackImpl.setUuid("");
		}
		else {
			feedbackImpl.setUuid(uuid);
		}

		feedbackImpl.setFeedbackId(feedbackId);
		feedbackImpl.setCreatedById(createdById);

		if (createDate == Long.MIN_VALUE) {
			feedbackImpl.setCreateDate(null);
		}
		else {
			feedbackImpl.setCreateDate(new Date(createDate));
		}

		if (name == null) {
			feedbackImpl.setName("");
		}
		else {
			feedbackImpl.setName(name);
		}

		if (email == null) {
			feedbackImpl.setEmail("");
		}
		else {
			feedbackImpl.setEmail(email);
		}

		if (mobile == null) {
			feedbackImpl.setMobile("");
		}
		else {
			feedbackImpl.setMobile(mobile);
		}

		if (comments == null) {
			feedbackImpl.setComments("");
		}
		else {
			feedbackImpl.setComments(comments);
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		feedbackId = objectInput.readLong();

		createdById = objectInput.readLong();
		createDate = objectInput.readLong();
		name = objectInput.readUTF();
		email = objectInput.readUTF();
		mobile = objectInput.readUTF();
		comments = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(feedbackId);

		objectOutput.writeLong(createdById);
		objectOutput.writeLong(createDate);

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

		if (comments == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comments);
		}
	}

	public String uuid;
	public long feedbackId;
	public long createdById;
	public long createDate;
	public String name;
	public String email;
	public String mobile;
	public String comments;

}