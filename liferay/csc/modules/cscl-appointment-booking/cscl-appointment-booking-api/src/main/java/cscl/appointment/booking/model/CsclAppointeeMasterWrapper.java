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

package cscl.appointment.booking.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclAppointeeMaster}.
 * </p>
 *
 * @author @rnab
 * @see CsclAppointeeMaster
 * @generated
 */
@ProviderType
public class CsclAppointeeMasterWrapper
	extends BaseModelWrapper<CsclAppointeeMaster>
	implements CsclAppointeeMaster, ModelWrapper<CsclAppointeeMaster> {

	public CsclAppointeeMasterWrapper(CsclAppointeeMaster csclAppointeeMaster) {
		super(csclAppointeeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("name", getName());
		attributes.put("designation", getDesignation());
		attributes.put("isActive", getIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	 * Returns the designation of this cscl appointee master.
	 *
	 * @return the designation of this cscl appointee master
	 */
	@Override
	public String getDesignation() {
		return model.getDesignation();
	}

	/**
	 * Returns the id_ of this cscl appointee master.
	 *
	 * @return the id_ of this cscl appointee master
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the is active of this cscl appointee master.
	 *
	 * @return the is active of this cscl appointee master
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the name of this cscl appointee master.
	 *
	 * @return the name of this cscl appointee master
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl appointee master.
	 *
	 * @return the primary key of this cscl appointee master
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
	 * Sets the designation of this cscl appointee master.
	 *
	 * @param designation the designation of this cscl appointee master
	 */
	@Override
	public void setDesignation(String designation) {
		model.setDesignation(designation);
	}

	/**
	 * Sets the id_ of this cscl appointee master.
	 *
	 * @param id_ the id_ of this cscl appointee master
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the is active of this cscl appointee master.
	 *
	 * @param isActive the is active of this cscl appointee master
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the name of this cscl appointee master.
	 *
	 * @param name the name of this cscl appointee master
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl appointee master.
	 *
	 * @param primaryKey the primary key of this cscl appointee master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CsclAppointeeMasterWrapper wrap(
		CsclAppointeeMaster csclAppointeeMaster) {

		return new CsclAppointeeMasterWrapper(csclAppointeeMaster);
	}

}