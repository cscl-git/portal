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

package com.cscl.polls.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclLocalityMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclLocalityMaster
 * @generated
 */
@ProviderType
public class CsclLocalityMasterWrapper
	extends BaseModelWrapper<CsclLocalityMaster>
	implements CsclLocalityMaster, ModelWrapper<CsclLocalityMaster> {

	public CsclLocalityMasterWrapper(CsclLocalityMaster csclLocalityMaster) {
		super(csclLocalityMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localityId", getLocalityId());
		attributes.put("name", getName());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long localityId = (Long)attributes.get("localityId");

		if (localityId != null) {
			setLocalityId(localityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	 * Returns the is active of this cscl locality master.
	 *
	 * @return the is active of this cscl locality master
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the locality ID of this cscl locality master.
	 *
	 * @return the locality ID of this cscl locality master
	 */
	@Override
	public long getLocalityId() {
		return model.getLocalityId();
	}

	/**
	 * Returns the name of this cscl locality master.
	 *
	 * @return the name of this cscl locality master
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl locality master.
	 *
	 * @return the primary key of this cscl locality master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the is active of this cscl locality master.
	 *
	 * @param isActive the is active of this cscl locality master
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the locality ID of this cscl locality master.
	 *
	 * @param localityId the locality ID of this cscl locality master
	 */
	@Override
	public void setLocalityId(long localityId) {
		model.setLocalityId(localityId);
	}

	/**
	 * Sets the name of this cscl locality master.
	 *
	 * @param name the name of this cscl locality master
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl locality master.
	 *
	 * @param primaryKey the primary key of this cscl locality master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CsclLocalityMasterWrapper wrap(
		CsclLocalityMaster csclLocalityMaster) {

		return new CsclLocalityMasterWrapper(csclLocalityMaster);
	}

}