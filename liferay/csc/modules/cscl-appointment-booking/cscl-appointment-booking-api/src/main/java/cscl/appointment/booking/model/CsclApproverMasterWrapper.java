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
 * This class is a wrapper for {@link CsclApproverMaster}.
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMaster
 * @generated
 */
@ProviderType
public class CsclApproverMasterWrapper
	extends BaseModelWrapper<CsclApproverMaster>
	implements CsclApproverMaster, ModelWrapper<CsclApproverMaster> {

	public CsclApproverMasterWrapper(CsclApproverMaster csclApproverMaster) {
		super(csclApproverMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("name", getName());
		attributes.put("appointee", getAppointee());
		attributes.put("userId", getUserId());
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

		String appointee = (String)attributes.get("appointee");

		if (appointee != null) {
			setAppointee(appointee);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	/**
	 * Returns the appointee of this cscl approver master.
	 *
	 * @return the appointee of this cscl approver master
	 */
	@Override
	public String getAppointee() {
		return model.getAppointee();
	}

	/**
	 * Returns the id_ of this cscl approver master.
	 *
	 * @return the id_ of this cscl approver master
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the is active of this cscl approver master.
	 *
	 * @return the is active of this cscl approver master
	 */
	@Override
	public Boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the name of this cscl approver master.
	 *
	 * @return the name of this cscl approver master
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl approver master.
	 *
	 * @return the primary key of this cscl approver master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this cscl approver master.
	 *
	 * @return the user ID of this cscl approver master
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this cscl approver master.
	 *
	 * @return the user uuid of this cscl approver master
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the appointee of this cscl approver master.
	 *
	 * @param appointee the appointee of this cscl approver master
	 */
	@Override
	public void setAppointee(String appointee) {
		model.setAppointee(appointee);
	}

	/**
	 * Sets the id_ of this cscl approver master.
	 *
	 * @param id_ the id_ of this cscl approver master
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the is active of this cscl approver master.
	 *
	 * @param isActive the is active of this cscl approver master
	 */
	@Override
	public void setIsActive(Boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the name of this cscl approver master.
	 *
	 * @param name the name of this cscl approver master
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl approver master.
	 *
	 * @param primaryKey the primary key of this cscl approver master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this cscl approver master.
	 *
	 * @param userId the user ID of this cscl approver master
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this cscl approver master.
	 *
	 * @param userUuid the user uuid of this cscl approver master
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected CsclApproverMasterWrapper wrap(
		CsclApproverMaster csclApproverMaster) {

		return new CsclApproverMasterWrapper(csclApproverMaster);
	}

}