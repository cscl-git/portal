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

import com.cscl.tender.model.CsclTenderCategory;

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
 * The cache model class for representing CsclTenderCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CsclTenderCategoryCacheModel
	implements CacheModel<CsclTenderCategory>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclTenderCategoryCacheModel)) {
			return false;
		}

		CsclTenderCategoryCacheModel csclTenderCategoryCacheModel =
			(CsclTenderCategoryCacheModel)obj;

		if (tenderCatId == csclTenderCategoryCacheModel.tenderCatId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tenderCatId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{tenderCatId=");
		sb.append(tenderCatId);
		sb.append(", createdById=");
		sb.append(createdById);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", category=");
		sb.append(category);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CsclTenderCategory toEntityModel() {
		CsclTenderCategoryImpl csclTenderCategoryImpl =
			new CsclTenderCategoryImpl();

		csclTenderCategoryImpl.setTenderCatId(tenderCatId);
		csclTenderCategoryImpl.setCreatedById(createdById);

		if (createDate == Long.MIN_VALUE) {
			csclTenderCategoryImpl.setCreateDate(null);
		}
		else {
			csclTenderCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (category == null) {
			csclTenderCategoryImpl.setCategory("");
		}
		else {
			csclTenderCategoryImpl.setCategory(category);
		}

		csclTenderCategoryImpl.resetOriginalValues();

		return csclTenderCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tenderCatId = objectInput.readLong();

		createdById = objectInput.readLong();
		createDate = objectInput.readLong();
		category = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tenderCatId);

		objectOutput.writeLong(createdById);
		objectOutput.writeLong(createDate);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}
	}

	public long tenderCatId;
	public long createdById;
	public long createDate;
	public String category;

}