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

package com.cscl.search.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearch
 * @generated
 */
@ProviderType
public class CsclSearchWrapper
	extends BaseModelWrapper<CsclSearch>
	implements CsclSearch, ModelWrapper<CsclSearch> {

	public CsclSearchWrapper(CsclSearch csclSearch) {
		super(csclSearch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("keywords", getKeywords());
		attributes.put("link", getLink());
		attributes.put("status", getStatus());
		attributes.put("createdById", getCreatedById());
		attributes.put("updatedById", getUpdatedById());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long createdById = (Long)attributes.get("createdById");

		if (createdById != null) {
			setCreatedById(createdById);
		}

		Long updatedById = (Long)attributes.get("updatedById");

		if (updatedById != null) {
			setUpdatedById(updatedById);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the create date of this cscl search.
	 *
	 * @return the create date of this cscl search
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by ID of this cscl search.
	 *
	 * @return the created by ID of this cscl search
	 */
	@Override
	public long getCreatedById() {
		return model.getCreatedById();
	}

	/**
	 * Returns the description of this cscl search.
	 *
	 * @return the description of this cscl search
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the ID of this cscl search.
	 *
	 * @return the ID of this cscl search
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the keywords of this cscl search.
	 *
	 * @return the keywords of this cscl search
	 */
	@Override
	public String getKeywords() {
		return model.getKeywords();
	}

	/**
	 * Returns the link of this cscl search.
	 *
	 * @return the link of this cscl search
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the modified date of this cscl search.
	 *
	 * @return the modified date of this cscl search
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this cscl search.
	 *
	 * @return the name of this cscl search
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl search.
	 *
	 * @return the primary key of this cscl search
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this cscl search.
	 *
	 * @return the status of this cscl search
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the updated by ID of this cscl search.
	 *
	 * @return the updated by ID of this cscl search
	 */
	@Override
	public long getUpdatedById() {
		return model.getUpdatedById();
	}

	/**
	 * Returns the user name of this cscl search.
	 *
	 * @return the user name of this cscl search
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this cscl search.
	 *
	 * @param createDate the create date of this cscl search
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by ID of this cscl search.
	 *
	 * @param createdById the created by ID of this cscl search
	 */
	@Override
	public void setCreatedById(long createdById) {
		model.setCreatedById(createdById);
	}

	/**
	 * Sets the description of this cscl search.
	 *
	 * @param description the description of this cscl search
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the ID of this cscl search.
	 *
	 * @param id the ID of this cscl search
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the keywords of this cscl search.
	 *
	 * @param keywords the keywords of this cscl search
	 */
	@Override
	public void setKeywords(String keywords) {
		model.setKeywords(keywords);
	}

	/**
	 * Sets the link of this cscl search.
	 *
	 * @param link the link of this cscl search
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the modified date of this cscl search.
	 *
	 * @param modifiedDate the modified date of this cscl search
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this cscl search.
	 *
	 * @param name the name of this cscl search
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl search.
	 *
	 * @param primaryKey the primary key of this cscl search
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this cscl search.
	 *
	 * @param status the status of this cscl search
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the updated by ID of this cscl search.
	 *
	 * @param updatedById the updated by ID of this cscl search
	 */
	@Override
	public void setUpdatedById(long updatedById) {
		model.setUpdatedById(updatedById);
	}

	/**
	 * Sets the user name of this cscl search.
	 *
	 * @param userName the user name of this cscl search
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	@Override
	protected CsclSearchWrapper wrap(CsclSearch csclSearch) {
		return new CsclSearchWrapper(csclSearch);
	}

}