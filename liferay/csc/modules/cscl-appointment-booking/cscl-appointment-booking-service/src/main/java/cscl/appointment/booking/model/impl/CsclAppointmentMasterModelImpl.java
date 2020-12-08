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

package cscl.appointment.booking.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import cscl.appointment.booking.model.CsclAppointmentMaster;
import cscl.appointment.booking.model.CsclAppointmentMasterModel;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the CsclAppointmentMaster service. Represents a row in the &quot;cscl_appointment_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CsclAppointmentMasterModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclAppointmentMasterImpl}.
 * </p>
 *
 * @author @rnab
 * @see CsclAppointmentMasterImpl
 * @generated
 */
@ProviderType
public class CsclAppointmentMasterModelImpl
	extends BaseModelImpl<CsclAppointmentMaster>
	implements CsclAppointmentMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl appointment master model instance should use the <code>CsclAppointmentMaster</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_appointment_master";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"name", Types.VARCHAR},
		{"email", Types.VARCHAR}, {"mobile", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"appointee", Types.INTEGER},
		{"preferedDate", Types.TIMESTAMP}, {"preferedTime", Types.VARCHAR},
		{"reason", Types.VARCHAR}, {"refId", Types.VARCHAR},
		{"approver", Types.BIGINT}, {"createdDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"status", Types.INTEGER},
		{"appointedDate", Types.TIMESTAMP}, {"appointedTime", Types.VARCHAR},
		{"comment_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("email", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("mobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("appointee", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("preferedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("preferedTime", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("reason", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("refId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("approver", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("appointedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("appointedTime", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("comment_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_appointment_master (id_ LONG not null primary key,name VARCHAR(75) null,email VARCHAR(75) null,mobile VARCHAR(10) null,address VARCHAR(500) null,appointee INTEGER,preferedDate DATE null,preferedTime VARCHAR(75) null,reason VARCHAR(500) null,refId VARCHAR(75) null,approver LONG,createdDate DATE null,modifiedDate DATE null,status INTEGER,appointedDate DATE null,appointedTime VARCHAR(75) null,comment_ VARCHAR(150) null)";

	public static final String TABLE_SQL_DROP =
		"drop table cscl_appointment_master";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclAppointmentMaster.id_ ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_appointment_master.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long APPOINTEE_COLUMN_BITMASK = 1L;

	public static final long APPROVER_COLUMN_BITMASK = 2L;

	public static final long STATUS_COLUMN_BITMASK = 4L;

	public static final long ID__COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CsclAppointmentMasterModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id_;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId_(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id_;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclAppointmentMaster.class;
	}

	@Override
	public String getModelClassName() {
		return CsclAppointmentMaster.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclAppointmentMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclAppointmentMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAppointmentMaster, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsclAppointmentMaster)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclAppointmentMaster, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclAppointmentMaster, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclAppointmentMaster)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclAppointmentMaster, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclAppointmentMaster, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclAppointmentMaster>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclAppointmentMaster.class.getClassLoader(),
			CsclAppointmentMaster.class, ModelWrapper.class);

		try {
			Constructor<CsclAppointmentMaster> constructor =
				(Constructor<CsclAppointmentMaster>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CsclAppointmentMaster, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclAppointmentMaster, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclAppointmentMaster, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CsclAppointmentMaster, Object>>();
		Map<String, BiConsumer<CsclAppointmentMaster, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CsclAppointmentMaster, ?>>();

		attributeGetterFunctions.put("id_", CsclAppointmentMaster::getId_);
		attributeSetterBiConsumers.put(
			"id_",
			(BiConsumer<CsclAppointmentMaster, Long>)
				CsclAppointmentMaster::setId_);
		attributeGetterFunctions.put("name", CsclAppointmentMaster::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setName);
		attributeGetterFunctions.put("email", CsclAppointmentMaster::getEmail);
		attributeSetterBiConsumers.put(
			"email",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setEmail);
		attributeGetterFunctions.put(
			"mobile", CsclAppointmentMaster::getMobile);
		attributeSetterBiConsumers.put(
			"mobile",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setMobile);
		attributeGetterFunctions.put(
			"address", CsclAppointmentMaster::getAddress);
		attributeSetterBiConsumers.put(
			"address",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setAddress);
		attributeGetterFunctions.put(
			"appointee", CsclAppointmentMaster::getAppointee);
		attributeSetterBiConsumers.put(
			"appointee",
			(BiConsumer<CsclAppointmentMaster, Integer>)
				CsclAppointmentMaster::setAppointee);
		attributeGetterFunctions.put(
			"preferedDate", CsclAppointmentMaster::getPreferedDate);
		attributeSetterBiConsumers.put(
			"preferedDate",
			(BiConsumer<CsclAppointmentMaster, Date>)
				CsclAppointmentMaster::setPreferedDate);
		attributeGetterFunctions.put(
			"preferedTime", CsclAppointmentMaster::getPreferedTime);
		attributeSetterBiConsumers.put(
			"preferedTime",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setPreferedTime);
		attributeGetterFunctions.put(
			"reason", CsclAppointmentMaster::getReason);
		attributeSetterBiConsumers.put(
			"reason",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setReason);
		attributeGetterFunctions.put("refId", CsclAppointmentMaster::getRefId);
		attributeSetterBiConsumers.put(
			"refId",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setRefId);
		attributeGetterFunctions.put(
			"approver", CsclAppointmentMaster::getApprover);
		attributeSetterBiConsumers.put(
			"approver",
			(BiConsumer<CsclAppointmentMaster, Long>)
				CsclAppointmentMaster::setApprover);
		attributeGetterFunctions.put(
			"createdDate", CsclAppointmentMaster::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<CsclAppointmentMaster, Date>)
				CsclAppointmentMaster::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedDate", CsclAppointmentMaster::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CsclAppointmentMaster, Date>)
				CsclAppointmentMaster::setModifiedDate);
		attributeGetterFunctions.put(
			"status", CsclAppointmentMaster::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<CsclAppointmentMaster, Integer>)
				CsclAppointmentMaster::setStatus);
		attributeGetterFunctions.put(
			"appointedDate", CsclAppointmentMaster::getAppointedDate);
		attributeSetterBiConsumers.put(
			"appointedDate",
			(BiConsumer<CsclAppointmentMaster, Date>)
				CsclAppointmentMaster::setAppointedDate);
		attributeGetterFunctions.put(
			"appointedTime", CsclAppointmentMaster::getAppointedTime);
		attributeSetterBiConsumers.put(
			"appointedTime",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setAppointedTime);
		attributeGetterFunctions.put(
			"comment", CsclAppointmentMaster::getComment);
		attributeSetterBiConsumers.put(
			"comment",
			(BiConsumer<CsclAppointmentMaster, String>)
				CsclAppointmentMaster::setComment);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId_() {
		return _id_;
	}

	@Override
	public void setId_(long id_) {
		_id_ = id_;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return "";
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getMobile() {
		if (_mobile == null) {
			return "";
		}
		else {
			return _mobile;
		}
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	@Override
	public String getAddress() {
		if (_address == null) {
			return "";
		}
		else {
			return _address;
		}
	}

	@Override
	public void setAddress(String address) {
		_address = address;
	}

	@Override
	public int getAppointee() {
		return _appointee;
	}

	@Override
	public void setAppointee(int appointee) {
		_columnBitmask |= APPOINTEE_COLUMN_BITMASK;

		if (!_setOriginalAppointee) {
			_setOriginalAppointee = true;

			_originalAppointee = _appointee;
		}

		_appointee = appointee;
	}

	public int getOriginalAppointee() {
		return _originalAppointee;
	}

	@Override
	public Date getPreferedDate() {
		return _preferedDate;
	}

	@Override
	public void setPreferedDate(Date preferedDate) {
		_preferedDate = preferedDate;
	}

	@Override
	public String getPreferedTime() {
		if (_preferedTime == null) {
			return "";
		}
		else {
			return _preferedTime;
		}
	}

	@Override
	public void setPreferedTime(String preferedTime) {
		_preferedTime = preferedTime;
	}

	@Override
	public String getReason() {
		if (_reason == null) {
			return "";
		}
		else {
			return _reason;
		}
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;
	}

	@Override
	public String getRefId() {
		if (_refId == null) {
			return "";
		}
		else {
			return _refId;
		}
	}

	@Override
	public void setRefId(String refId) {
		_refId = refId;
	}

	@Override
	public long getApprover() {
		return _approver;
	}

	@Override
	public void setApprover(long approver) {
		_columnBitmask |= APPROVER_COLUMN_BITMASK;

		if (!_setOriginalApprover) {
			_setOriginalApprover = true;

			_originalApprover = _approver;
		}

		_approver = approver;
	}

	public long getOriginalApprover() {
		return _originalApprover;
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public Date getAppointedDate() {
		return _appointedDate;
	}

	@Override
	public void setAppointedDate(Date appointedDate) {
		_appointedDate = appointedDate;
	}

	@Override
	public String getAppointedTime() {
		if (_appointedTime == null) {
			return "";
		}
		else {
			return _appointedTime;
		}
	}

	@Override
	public void setAppointedTime(String appointedTime) {
		_appointedTime = appointedTime;
	}

	@Override
	public String getComment() {
		if (_comment == null) {
			return "";
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclAppointmentMaster.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CsclAppointmentMaster toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclAppointmentMaster>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CsclAppointmentMasterImpl csclAppointmentMasterImpl =
			new CsclAppointmentMasterImpl();

		csclAppointmentMasterImpl.setId_(getId_());
		csclAppointmentMasterImpl.setName(getName());
		csclAppointmentMasterImpl.setEmail(getEmail());
		csclAppointmentMasterImpl.setMobile(getMobile());
		csclAppointmentMasterImpl.setAddress(getAddress());
		csclAppointmentMasterImpl.setAppointee(getAppointee());
		csclAppointmentMasterImpl.setPreferedDate(getPreferedDate());
		csclAppointmentMasterImpl.setPreferedTime(getPreferedTime());
		csclAppointmentMasterImpl.setReason(getReason());
		csclAppointmentMasterImpl.setRefId(getRefId());
		csclAppointmentMasterImpl.setApprover(getApprover());
		csclAppointmentMasterImpl.setCreatedDate(getCreatedDate());
		csclAppointmentMasterImpl.setModifiedDate(getModifiedDate());
		csclAppointmentMasterImpl.setStatus(getStatus());
		csclAppointmentMasterImpl.setAppointedDate(getAppointedDate());
		csclAppointmentMasterImpl.setAppointedTime(getAppointedTime());
		csclAppointmentMasterImpl.setComment(getComment());

		csclAppointmentMasterImpl.resetOriginalValues();

		return csclAppointmentMasterImpl;
	}

	@Override
	public int compareTo(CsclAppointmentMaster csclAppointmentMaster) {
		long primaryKey = csclAppointmentMaster.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclAppointmentMaster)) {
			return false;
		}

		CsclAppointmentMaster csclAppointmentMaster =
			(CsclAppointmentMaster)obj;

		long primaryKey = csclAppointmentMaster.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		CsclAppointmentMasterModelImpl csclAppointmentMasterModelImpl = this;

		csclAppointmentMasterModelImpl._originalAppointee =
			csclAppointmentMasterModelImpl._appointee;

		csclAppointmentMasterModelImpl._setOriginalAppointee = false;

		csclAppointmentMasterModelImpl._originalApprover =
			csclAppointmentMasterModelImpl._approver;

		csclAppointmentMasterModelImpl._setOriginalApprover = false;

		csclAppointmentMasterModelImpl._originalStatus =
			csclAppointmentMasterModelImpl._status;

		csclAppointmentMasterModelImpl._setOriginalStatus = false;

		csclAppointmentMasterModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CsclAppointmentMaster> toCacheModel() {
		CsclAppointmentMasterCacheModel csclAppointmentMasterCacheModel =
			new CsclAppointmentMasterCacheModel();

		csclAppointmentMasterCacheModel.id_ = getId_();

		csclAppointmentMasterCacheModel.name = getName();

		String name = csclAppointmentMasterCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			csclAppointmentMasterCacheModel.name = null;
		}

		csclAppointmentMasterCacheModel.email = getEmail();

		String email = csclAppointmentMasterCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			csclAppointmentMasterCacheModel.email = null;
		}

		csclAppointmentMasterCacheModel.mobile = getMobile();

		String mobile = csclAppointmentMasterCacheModel.mobile;

		if ((mobile != null) && (mobile.length() == 0)) {
			csclAppointmentMasterCacheModel.mobile = null;
		}

		csclAppointmentMasterCacheModel.address = getAddress();

		String address = csclAppointmentMasterCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			csclAppointmentMasterCacheModel.address = null;
		}

		csclAppointmentMasterCacheModel.appointee = getAppointee();

		Date preferedDate = getPreferedDate();

		if (preferedDate != null) {
			csclAppointmentMasterCacheModel.preferedDate =
				preferedDate.getTime();
		}
		else {
			csclAppointmentMasterCacheModel.preferedDate = Long.MIN_VALUE;
		}

		csclAppointmentMasterCacheModel.preferedTime = getPreferedTime();

		String preferedTime = csclAppointmentMasterCacheModel.preferedTime;

		if ((preferedTime != null) && (preferedTime.length() == 0)) {
			csclAppointmentMasterCacheModel.preferedTime = null;
		}

		csclAppointmentMasterCacheModel.reason = getReason();

		String reason = csclAppointmentMasterCacheModel.reason;

		if ((reason != null) && (reason.length() == 0)) {
			csclAppointmentMasterCacheModel.reason = null;
		}

		csclAppointmentMasterCacheModel.refId = getRefId();

		String refId = csclAppointmentMasterCacheModel.refId;

		if ((refId != null) && (refId.length() == 0)) {
			csclAppointmentMasterCacheModel.refId = null;
		}

		csclAppointmentMasterCacheModel.approver = getApprover();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			csclAppointmentMasterCacheModel.createdDate = createdDate.getTime();
		}
		else {
			csclAppointmentMasterCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			csclAppointmentMasterCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			csclAppointmentMasterCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		csclAppointmentMasterCacheModel.status = getStatus();

		Date appointedDate = getAppointedDate();

		if (appointedDate != null) {
			csclAppointmentMasterCacheModel.appointedDate =
				appointedDate.getTime();
		}
		else {
			csclAppointmentMasterCacheModel.appointedDate = Long.MIN_VALUE;
		}

		csclAppointmentMasterCacheModel.appointedTime = getAppointedTime();

		String appointedTime = csclAppointmentMasterCacheModel.appointedTime;

		if ((appointedTime != null) && (appointedTime.length() == 0)) {
			csclAppointmentMasterCacheModel.appointedTime = null;
		}

		csclAppointmentMasterCacheModel.comment = getComment();

		String comment = csclAppointmentMasterCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			csclAppointmentMasterCacheModel.comment = null;
		}

		return csclAppointmentMasterCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclAppointmentMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclAppointmentMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAppointmentMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CsclAppointmentMaster)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CsclAppointmentMaster, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclAppointmentMaster, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclAppointmentMaster, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CsclAppointmentMaster)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclAppointmentMaster>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _id_;
	private String _name;
	private String _email;
	private String _mobile;
	private String _address;
	private int _appointee;
	private int _originalAppointee;
	private boolean _setOriginalAppointee;
	private Date _preferedDate;
	private String _preferedTime;
	private String _reason;
	private String _refId;
	private long _approver;
	private long _originalApprover;
	private boolean _setOriginalApprover;
	private Date _createdDate;
	private Date _modifiedDate;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private Date _appointedDate;
	private String _appointedTime;
	private String _comment;
	private long _columnBitmask;
	private CsclAppointmentMaster _escapedModel;

}