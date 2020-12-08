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
 * This class is a wrapper for {@link CsclAppointmentMaster}.
 * </p>
 *
 * @author @rnab
 * @see CsclAppointmentMaster
 * @generated
 */
@ProviderType
public class CsclAppointmentMasterWrapper
	extends BaseModelWrapper<CsclAppointmentMaster>
	implements CsclAppointmentMaster, ModelWrapper<CsclAppointmentMaster> {

	public CsclAppointmentMasterWrapper(
		CsclAppointmentMaster csclAppointmentMaster) {

		super(csclAppointmentMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id_", getId_());
		attributes.put("name", getName());
		attributes.put("email", getEmail());
		attributes.put("mobile", getMobile());
		attributes.put("address", getAddress());
		attributes.put("appointee", getAppointee());
		attributes.put("preferedDate", getPreferedDate());
		attributes.put("preferedTime", getPreferedTime());
		attributes.put("reason", getReason());
		attributes.put("refId", getRefId());
		attributes.put("approver", getApprover());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("appointedDate", getAppointedDate());
		attributes.put("appointedTime", getAppointedTime());
		attributes.put("comment", getComment());

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

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Integer appointee = (Integer)attributes.get("appointee");

		if (appointee != null) {
			setAppointee(appointee);
		}

		Date preferedDate = (Date)attributes.get("preferedDate");

		if (preferedDate != null) {
			setPreferedDate(preferedDate);
		}

		String preferedTime = (String)attributes.get("preferedTime");

		if (preferedTime != null) {
			setPreferedTime(preferedTime);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String refId = (String)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
		}

		Long approver = (Long)attributes.get("approver");

		if (approver != null) {
			setApprover(approver);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date appointedDate = (Date)attributes.get("appointedDate");

		if (appointedDate != null) {
			setAppointedDate(appointedDate);
		}

		String appointedTime = (String)attributes.get("appointedTime");

		if (appointedTime != null) {
			setAppointedTime(appointedTime);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}
	}

	/**
	 * Returns the address of this cscl appointment master.
	 *
	 * @return the address of this cscl appointment master
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the appointed date of this cscl appointment master.
	 *
	 * @return the appointed date of this cscl appointment master
	 */
	@Override
	public Date getAppointedDate() {
		return model.getAppointedDate();
	}

	/**
	 * Returns the appointed time of this cscl appointment master.
	 *
	 * @return the appointed time of this cscl appointment master
	 */
	@Override
	public String getAppointedTime() {
		return model.getAppointedTime();
	}

	/**
	 * Returns the appointee of this cscl appointment master.
	 *
	 * @return the appointee of this cscl appointment master
	 */
	@Override
	public int getAppointee() {
		return model.getAppointee();
	}

	/**
	 * Returns the approver of this cscl appointment master.
	 *
	 * @return the approver of this cscl appointment master
	 */
	@Override
	public long getApprover() {
		return model.getApprover();
	}

	/**
	 * Returns the comment of this cscl appointment master.
	 *
	 * @return the comment of this cscl appointment master
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the created date of this cscl appointment master.
	 *
	 * @return the created date of this cscl appointment master
	 */
	@Override
	public Date getCreatedDate() {
		return model.getCreatedDate();
	}

	/**
	 * Returns the email of this cscl appointment master.
	 *
	 * @return the email of this cscl appointment master
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the id_ of this cscl appointment master.
	 *
	 * @return the id_ of this cscl appointment master
	 */
	@Override
	public long getId_() {
		return model.getId_();
	}

	/**
	 * Returns the mobile of this cscl appointment master.
	 *
	 * @return the mobile of this cscl appointment master
	 */
	@Override
	public String getMobile() {
		return model.getMobile();
	}

	/**
	 * Returns the modified date of this cscl appointment master.
	 *
	 * @return the modified date of this cscl appointment master
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this cscl appointment master.
	 *
	 * @return the name of this cscl appointment master
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the prefered date of this cscl appointment master.
	 *
	 * @return the prefered date of this cscl appointment master
	 */
	@Override
	public Date getPreferedDate() {
		return model.getPreferedDate();
	}

	/**
	 * Returns the prefered time of this cscl appointment master.
	 *
	 * @return the prefered time of this cscl appointment master
	 */
	@Override
	public String getPreferedTime() {
		return model.getPreferedTime();
	}

	/**
	 * Returns the primary key of this cscl appointment master.
	 *
	 * @return the primary key of this cscl appointment master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this cscl appointment master.
	 *
	 * @return the reason of this cscl appointment master
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the ref ID of this cscl appointment master.
	 *
	 * @return the ref ID of this cscl appointment master
	 */
	@Override
	public String getRefId() {
		return model.getRefId();
	}

	/**
	 * Returns the status of this cscl appointment master.
	 *
	 * @return the status of this cscl appointment master
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this cscl appointment master.
	 *
	 * @param address the address of this cscl appointment master
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the appointed date of this cscl appointment master.
	 *
	 * @param appointedDate the appointed date of this cscl appointment master
	 */
	@Override
	public void setAppointedDate(Date appointedDate) {
		model.setAppointedDate(appointedDate);
	}

	/**
	 * Sets the appointed time of this cscl appointment master.
	 *
	 * @param appointedTime the appointed time of this cscl appointment master
	 */
	@Override
	public void setAppointedTime(String appointedTime) {
		model.setAppointedTime(appointedTime);
	}

	/**
	 * Sets the appointee of this cscl appointment master.
	 *
	 * @param appointee the appointee of this cscl appointment master
	 */
	@Override
	public void setAppointee(int appointee) {
		model.setAppointee(appointee);
	}

	/**
	 * Sets the approver of this cscl appointment master.
	 *
	 * @param approver the approver of this cscl appointment master
	 */
	@Override
	public void setApprover(long approver) {
		model.setApprover(approver);
	}

	/**
	 * Sets the comment of this cscl appointment master.
	 *
	 * @param comment the comment of this cscl appointment master
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the created date of this cscl appointment master.
	 *
	 * @param createdDate the created date of this cscl appointment master
	 */
	@Override
	public void setCreatedDate(Date createdDate) {
		model.setCreatedDate(createdDate);
	}

	/**
	 * Sets the email of this cscl appointment master.
	 *
	 * @param email the email of this cscl appointment master
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the id_ of this cscl appointment master.
	 *
	 * @param id_ the id_ of this cscl appointment master
	 */
	@Override
	public void setId_(long id_) {
		model.setId_(id_);
	}

	/**
	 * Sets the mobile of this cscl appointment master.
	 *
	 * @param mobile the mobile of this cscl appointment master
	 */
	@Override
	public void setMobile(String mobile) {
		model.setMobile(mobile);
	}

	/**
	 * Sets the modified date of this cscl appointment master.
	 *
	 * @param modifiedDate the modified date of this cscl appointment master
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this cscl appointment master.
	 *
	 * @param name the name of this cscl appointment master
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the prefered date of this cscl appointment master.
	 *
	 * @param preferedDate the prefered date of this cscl appointment master
	 */
	@Override
	public void setPreferedDate(Date preferedDate) {
		model.setPreferedDate(preferedDate);
	}

	/**
	 * Sets the prefered time of this cscl appointment master.
	 *
	 * @param preferedTime the prefered time of this cscl appointment master
	 */
	@Override
	public void setPreferedTime(String preferedTime) {
		model.setPreferedTime(preferedTime);
	}

	/**
	 * Sets the primary key of this cscl appointment master.
	 *
	 * @param primaryKey the primary key of this cscl appointment master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this cscl appointment master.
	 *
	 * @param reason the reason of this cscl appointment master
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the ref ID of this cscl appointment master.
	 *
	 * @param refId the ref ID of this cscl appointment master
	 */
	@Override
	public void setRefId(String refId) {
		model.setRefId(refId);
	}

	/**
	 * Sets the status of this cscl appointment master.
	 *
	 * @param status the status of this cscl appointment master
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected CsclAppointmentMasterWrapper wrap(
		CsclAppointmentMaster csclAppointmentMaster) {

		return new CsclAppointmentMasterWrapper(csclAppointmentMaster);
	}

}