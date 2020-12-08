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

package com.cscl.online.rti.payment.model.impl;

import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;

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
 * The cache model class for representing CsclRtiPaymentDetails in entity cache.
 *
 * @author @rnab
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsCacheModel
	implements CacheModel<CsclRtiPaymentDetails>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclRtiPaymentDetailsCacheModel)) {
			return false;
		}

		CsclRtiPaymentDetailsCacheModel csclRtiPaymentDetailsCacheModel =
			(CsclRtiPaymentDetailsCacheModel)obj;

		if (id == csclRtiPaymentDetailsCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", applicantName=");
		sb.append(applicantName);
		sb.append(", applicantEmail=");
		sb.append(applicantEmail);
		sb.append(", applicantMobile=");
		sb.append(applicantMobile);
		sb.append(", address=");
		sb.append(address);
		sb.append(", rtiSubject=");
		sb.append(rtiSubject);
		sb.append(", rtiFeeAmount=");
		sb.append(rtiFeeAmount);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", refId=");
		sb.append(refId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclRtiPaymentDetails toEntityModel() {
		CsclRtiPaymentDetailsImpl csclRtiPaymentDetailsImpl =
			new CsclRtiPaymentDetailsImpl();

		csclRtiPaymentDetailsImpl.setId(id);

		if (applicantName == null) {
			csclRtiPaymentDetailsImpl.setApplicantName("");
		}
		else {
			csclRtiPaymentDetailsImpl.setApplicantName(applicantName);
		}

		if (applicantEmail == null) {
			csclRtiPaymentDetailsImpl.setApplicantEmail("");
		}
		else {
			csclRtiPaymentDetailsImpl.setApplicantEmail(applicantEmail);
		}

		if (applicantMobile == null) {
			csclRtiPaymentDetailsImpl.setApplicantMobile("");
		}
		else {
			csclRtiPaymentDetailsImpl.setApplicantMobile(applicantMobile);
		}

		if (address == null) {
			csclRtiPaymentDetailsImpl.setAddress("");
		}
		else {
			csclRtiPaymentDetailsImpl.setAddress(address);
		}

		if (rtiSubject == null) {
			csclRtiPaymentDetailsImpl.setRtiSubject("");
		}
		else {
			csclRtiPaymentDetailsImpl.setRtiSubject(rtiSubject);
		}

		csclRtiPaymentDetailsImpl.setRtiFeeAmount(rtiFeeAmount);

		if (createdDate == Long.MIN_VALUE) {
			csclRtiPaymentDetailsImpl.setCreatedDate(null);
		}
		else {
			csclRtiPaymentDetailsImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			csclRtiPaymentDetailsImpl.setModifiedDate(null);
		}
		else {
			csclRtiPaymentDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (refId == null) {
			csclRtiPaymentDetailsImpl.setRefId("");
		}
		else {
			csclRtiPaymentDetailsImpl.setRefId(refId);
		}

		csclRtiPaymentDetailsImpl.resetOriginalValues();

		return csclRtiPaymentDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		applicantName = objectInput.readUTF();
		applicantEmail = objectInput.readUTF();
		applicantMobile = objectInput.readUTF();
		address = objectInput.readUTF();
		rtiSubject = objectInput.readUTF();

		rtiFeeAmount = objectInput.readInt();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		refId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (applicantName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantName);
		}

		if (applicantEmail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantEmail);
		}

		if (applicantMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(applicantMobile);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (rtiSubject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rtiSubject);
		}

		objectOutput.writeInt(rtiFeeAmount);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);

		if (refId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(refId);
		}
	}

	public long id;
	public String applicantName;
	public String applicantEmail;
	public String applicantMobile;
	public String address;
	public String rtiSubject;
	public int rtiFeeAmount;
	public long createdDate;
	public long modifiedDate;
	public String refId;

}