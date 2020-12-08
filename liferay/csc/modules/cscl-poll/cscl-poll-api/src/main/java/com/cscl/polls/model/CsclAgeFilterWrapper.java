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
 * This class is a wrapper for {@link CsclAgeFilter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclAgeFilter
 * @generated
 */
@ProviderType
public class CsclAgeFilterWrapper
	extends BaseModelWrapper<CsclAgeFilter>
	implements CsclAgeFilter, ModelWrapper<CsclAgeFilter> {

	public CsclAgeFilterWrapper(CsclAgeFilter csclAgeFilter) {
		super(csclAgeFilter);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("name", getName());
		attributes.put("value", getValue());
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

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	 * Returns the id_ of this cscl age filter.
	 *
	 * @return the id_ of this cscl age filter
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the is active of this cscl age filter.
	 *
	 * @return the is active of this cscl age filter
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the name of this cscl age filter.
	 *
	 * @return the name of this cscl age filter
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl age filter.
	 *
	 * @return the primary key of this cscl age filter
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this cscl age filter.
	 *
	 * @return the value of this cscl age filter
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the id_ of this cscl age filter.
	 *
	 * @param id_ the id_ of this cscl age filter
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the is active of this cscl age filter.
	 *
	 * @param isActive the is active of this cscl age filter
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the name of this cscl age filter.
	 *
	 * @param name the name of this cscl age filter
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl age filter.
	 *
	 * @param primaryKey the primary key of this cscl age filter
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this cscl age filter.
	 *
	 * @param value the value of this cscl age filter
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected CsclAgeFilterWrapper wrap(CsclAgeFilter csclAgeFilter) {
		return new CsclAgeFilterWrapper(csclAgeFilter);
	}

}