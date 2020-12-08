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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclApproverMapping}.
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMapping
 * @generated
 */
@ProviderType
public class CsclApproverMappingWrapper
	extends BaseModelWrapper<CsclApproverMapping>
	implements CsclApproverMapping, ModelWrapper<CsclApproverMapping> {

	public CsclApproverMappingWrapper(CsclApproverMapping csclApproverMapping) {
		super(csclApproverMapping);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("appointee", getAppointee());
		attributes.put("approver", getApprover());
		attributes.put("assignedTo", getAssignedTo());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id_ = (Long)attributes.get("id_");

		if (id_ != null) {
			setId_(id_);
		}

		Integer appointee = (Integer)attributes.get("appointee");

		if (appointee != null) {
			setAppointee(appointee);
		}

		String approver = (String)attributes.get("approver");

		if (approver != null) {
			setApprover(approver);
		}

		Long assignedTo = (Long)attributes.get("assignedTo");

		if (assignedTo != null) {
			setAssignedTo(assignedTo);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the appointee of this cscl approver mapping.
	 *
	 * @return the appointee of this cscl approver mapping
	 */
	@Override
	public int getAppointee() {
		return model.getAppointee();
	}

	/**
	 * Returns the approver of this cscl approver mapping.
	 *
	 * @return the approver of this cscl approver mapping
	 */
	@Override
	public String getApprover() {
		return model.getApprover();
	}

	/**
	 * Returns the assigned to of this cscl approver mapping.
	 *
	 * @return the assigned to of this cscl approver mapping
	 */
	@Override
	public long getAssignedTo() {
		return model.getAssignedTo();
	}

	/**
	 * Returns the created date of this cscl approver mapping.
	 *
	 * @return the created date of this cscl approver mapping
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the id_ of this cscl approver mapping.
	 *
	 * @return the id_ of this cscl approver mapping
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the modified date of this cscl approver mapping.
	 *
	 * @return the modified date of this cscl approver mapping
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cscl approver mapping.
	 *
	 * @return the primary key of this cscl approver mapping
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
	 * Sets the appointee of this cscl approver mapping.
	 *
	 * @param appointee the appointee of this cscl approver mapping
	 */
	@Override
	public void setAppointee(int appointee) {
		model.setAppointee(appointee);
	}

	/**
	 * Sets the approver of this cscl approver mapping.
	 *
	 * @param approver the approver of this cscl approver mapping
	 */
	@Override
	public void setApprover(String approver) {
		model.setApprover(approver);
	}

	/**
	 * Sets the assigned to of this cscl approver mapping.
	 *
	 * @param assignedTo the assigned to of this cscl approver mapping
	 */
	@Override
	public void setAssignedTo(long assignedTo) {
		model.setAssignedTo(assignedTo);
	}

	/**
	 * Sets the created date of this cscl approver mapping.
	 *
	 * @param createdDate the created date of this cscl approver mapping
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the id_ of this cscl approver mapping.
	 *
	 * @param id_ the id_ of this cscl approver mapping
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the modified date of this cscl approver mapping.
	 *
	 * @param modifiedDate the modified date of this cscl approver mapping
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cscl approver mapping.
	 *
	 * @param primaryKey the primary key of this cscl approver mapping
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CsclApproverMappingWrapper wrap(
		CsclApproverMapping csclApproverMapping) {

		return new CsclApproverMappingWrapper(csclApproverMapping);
	}

}