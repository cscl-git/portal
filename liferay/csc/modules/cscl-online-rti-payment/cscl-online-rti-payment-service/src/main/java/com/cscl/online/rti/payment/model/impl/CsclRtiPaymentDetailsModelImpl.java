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
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetailsModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

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
 * The base model implementation for the CsclRtiPaymentDetails service. Represents a row in the &quot;cscl_rti_payment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CsclRtiPaymentDetailsModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclRtiPaymentDetailsImpl}.
 * </p>
 *
 * @author @rnab
 * @see CsclRtiPaymentDetailsImpl
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsModelImpl
	extends BaseModelImpl<CsclRtiPaymentDetails>
	implements CsclRtiPaymentDetailsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl rti payment details model instance should use the <code>CsclRtiPaymentDetails</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_rti_payment";

	public static final Object[][] TABLE_COLUMNS = {
		{"id_", Types.BIGINT}, {"applicantName", Types.VARCHAR},
		{"applicantEmail", Types.VARCHAR}, {"applicantMobile", Types.VARCHAR},
		{"address", Types.VARCHAR}, {"rtiSubject", Types.VARCHAR},
		{"rtiFeeAmount", Types.INTEGER}, {"createdDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"refId", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("id_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("applicantName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantEmail", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("applicantMobile", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("address", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rtiSubject", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rtiFeeAmount", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("createdDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("refId", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_rti_payment (id_ LONG not null primary key,applicantName VARCHAR(75) null,applicantEmail VARCHAR(75) null,applicantMobile VARCHAR(75) null,address VARCHAR(75) null,rtiSubject VARCHAR(75) null,rtiFeeAmount INTEGER,createdDate DATE null,modifiedDate DATE null,refId VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table cscl_rti_payment";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclRtiPaymentDetails.id ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_rti_payment.id_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public CsclRtiPaymentDetailsModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclRtiPaymentDetails.class;
	}

	@Override
	public String getModelClassName() {
		return CsclRtiPaymentDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclRtiPaymentDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclRtiPaymentDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclRtiPaymentDetails, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsclRtiPaymentDetails)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclRtiPaymentDetails, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclRtiPaymentDetails, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclRtiPaymentDetails)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclRtiPaymentDetails, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclRtiPaymentDetails, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclRtiPaymentDetails>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclRtiPaymentDetails.class.getClassLoader(),
			CsclRtiPaymentDetails.class, ModelWrapper.class);

		try {
			Constructor<CsclRtiPaymentDetails> constructor =
				(Constructor<CsclRtiPaymentDetails>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CsclRtiPaymentDetails, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclRtiPaymentDetails, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclRtiPaymentDetails, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CsclRtiPaymentDetails, Object>>();
		Map<String, BiConsumer<CsclRtiPaymentDetails, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<CsclRtiPaymentDetails, ?>>();

		attributeGetterFunctions.put("id", CsclRtiPaymentDetails::getId);
		attributeSetterBiConsumers.put(
			"id",
			(BiConsumer<CsclRtiPaymentDetails, Long>)
				CsclRtiPaymentDetails::setId);
		attributeGetterFunctions.put(
			"applicantName", CsclRtiPaymentDetails::getApplicantName);
		attributeSetterBiConsumers.put(
			"applicantName",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setApplicantName);
		attributeGetterFunctions.put(
			"applicantEmail", CsclRtiPaymentDetails::getApplicantEmail);
		attributeSetterBiConsumers.put(
			"applicantEmail",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setApplicantEmail);
		attributeGetterFunctions.put(
			"applicantMobile", CsclRtiPaymentDetails::getApplicantMobile);
		attributeSetterBiConsumers.put(
			"applicantMobile",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setApplicantMobile);
		attributeGetterFunctions.put(
			"address", CsclRtiPaymentDetails::getAddress);
		attributeSetterBiConsumers.put(
			"address",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setAddress);
		attributeGetterFunctions.put(
			"rtiSubject", CsclRtiPaymentDetails::getRtiSubject);
		attributeSetterBiConsumers.put(
			"rtiSubject",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setRtiSubject);
		attributeGetterFunctions.put(
			"rtiFeeAmount", CsclRtiPaymentDetails::getRtiFeeAmount);
		attributeSetterBiConsumers.put(
			"rtiFeeAmount",
			(BiConsumer<CsclRtiPaymentDetails, Integer>)
				CsclRtiPaymentDetails::setRtiFeeAmount);
		attributeGetterFunctions.put(
			"createdDate", CsclRtiPaymentDetails::getCreatedDate);
		attributeSetterBiConsumers.put(
			"createdDate",
			(BiConsumer<CsclRtiPaymentDetails, Date>)
				CsclRtiPaymentDetails::setCreatedDate);
		attributeGetterFunctions.put(
			"modifiedDate", CsclRtiPaymentDetails::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<CsclRtiPaymentDetails, Date>)
				CsclRtiPaymentDetails::setModifiedDate);
		attributeGetterFunctions.put("refId", CsclRtiPaymentDetails::getRefId);
		attributeSetterBiConsumers.put(
			"refId",
			(BiConsumer<CsclRtiPaymentDetails, String>)
				CsclRtiPaymentDetails::setRefId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;
	}

	@Override
	public String getApplicantName() {
		if (_applicantName == null) {
			return "";
		}
		else {
			return _applicantName;
		}
	}

	@Override
	public void setApplicantName(String applicantName) {
		_applicantName = applicantName;
	}

	@Override
	public String getApplicantEmail() {
		if (_applicantEmail == null) {
			return "";
		}
		else {
			return _applicantEmail;
		}
	}

	@Override
	public void setApplicantEmail(String applicantEmail) {
		_applicantEmail = applicantEmail;
	}

	@Override
	public String getApplicantMobile() {
		if (_applicantMobile == null) {
			return "";
		}
		else {
			return _applicantMobile;
		}
	}

	@Override
	public void setApplicantMobile(String applicantMobile) {
		_applicantMobile = applicantMobile;
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
	public String getRtiSubject() {
		if (_rtiSubject == null) {
			return "";
		}
		else {
			return _rtiSubject;
		}
	}

	@Override
	public void setRtiSubject(String rtiSubject) {
		_rtiSubject = rtiSubject;
	}

	@Override
	public int getRtiFeeAmount() {
		return _rtiFeeAmount;
	}

	@Override
	public void setRtiFeeAmount(int rtiFeeAmount) {
		_rtiFeeAmount = rtiFeeAmount;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclRtiPaymentDetails.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CsclRtiPaymentDetails toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclRtiPaymentDetails>
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
		CsclRtiPaymentDetailsImpl csclRtiPaymentDetailsImpl =
			new CsclRtiPaymentDetailsImpl();

		csclRtiPaymentDetailsImpl.setId(getId());
		csclRtiPaymentDetailsImpl.setApplicantName(getApplicantName());
		csclRtiPaymentDetailsImpl.setApplicantEmail(getApplicantEmail());
		csclRtiPaymentDetailsImpl.setApplicantMobile(getApplicantMobile());
		csclRtiPaymentDetailsImpl.setAddress(getAddress());
		csclRtiPaymentDetailsImpl.setRtiSubject(getRtiSubject());
		csclRtiPaymentDetailsImpl.setRtiFeeAmount(getRtiFeeAmount());
		csclRtiPaymentDetailsImpl.setCreatedDate(getCreatedDate());
		csclRtiPaymentDetailsImpl.setModifiedDate(getModifiedDate());
		csclRtiPaymentDetailsImpl.setRefId(getRefId());

		csclRtiPaymentDetailsImpl.resetOriginalValues();

		return csclRtiPaymentDetailsImpl;
	}

	@Override
	public int compareTo(CsclRtiPaymentDetails csclRtiPaymentDetails) {
		long primaryKey = csclRtiPaymentDetails.getPrimaryKey();

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

		if (!(obj instanceof CsclRtiPaymentDetails)) {
			return false;
		}

		CsclRtiPaymentDetails csclRtiPaymentDetails =
			(CsclRtiPaymentDetails)obj;

		long primaryKey = csclRtiPaymentDetails.getPrimaryKey();

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
	}

	@Override
	public CacheModel<CsclRtiPaymentDetails> toCacheModel() {
		CsclRtiPaymentDetailsCacheModel csclRtiPaymentDetailsCacheModel =
			new CsclRtiPaymentDetailsCacheModel();

		csclRtiPaymentDetailsCacheModel.id = getId();

		csclRtiPaymentDetailsCacheModel.applicantName = getApplicantName();

		String applicantName = csclRtiPaymentDetailsCacheModel.applicantName;

		if ((applicantName != null) && (applicantName.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.applicantName = null;
		}

		csclRtiPaymentDetailsCacheModel.applicantEmail = getApplicantEmail();

		String applicantEmail = csclRtiPaymentDetailsCacheModel.applicantEmail;

		if ((applicantEmail != null) && (applicantEmail.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.applicantEmail = null;
		}

		csclRtiPaymentDetailsCacheModel.applicantMobile = getApplicantMobile();

		String applicantMobile =
			csclRtiPaymentDetailsCacheModel.applicantMobile;

		if ((applicantMobile != null) && (applicantMobile.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.applicantMobile = null;
		}

		csclRtiPaymentDetailsCacheModel.address = getAddress();

		String address = csclRtiPaymentDetailsCacheModel.address;

		if ((address != null) && (address.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.address = null;
		}

		csclRtiPaymentDetailsCacheModel.rtiSubject = getRtiSubject();

		String rtiSubject = csclRtiPaymentDetailsCacheModel.rtiSubject;

		if ((rtiSubject != null) && (rtiSubject.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.rtiSubject = null;
		}

		csclRtiPaymentDetailsCacheModel.rtiFeeAmount = getRtiFeeAmount();

		Date createdDate = getCreatedDate();

		if (createdDate != null) {
			csclRtiPaymentDetailsCacheModel.createdDate = createdDate.getTime();
		}
		else {
			csclRtiPaymentDetailsCacheModel.createdDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			csclRtiPaymentDetailsCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			csclRtiPaymentDetailsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		csclRtiPaymentDetailsCacheModel.refId = getRefId();

		String refId = csclRtiPaymentDetailsCacheModel.refId;

		if ((refId != null) && (refId.length() == 0)) {
			csclRtiPaymentDetailsCacheModel.refId = null;
		}

		return csclRtiPaymentDetailsCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclRtiPaymentDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclRtiPaymentDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclRtiPaymentDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((CsclRtiPaymentDetails)this));
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
		Map<String, Function<CsclRtiPaymentDetails, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclRtiPaymentDetails, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclRtiPaymentDetails, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((CsclRtiPaymentDetails)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclRtiPaymentDetails>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _id;
	private String _applicantName;
	private String _applicantEmail;
	private String _applicantMobile;
	private String _address;
	private String _rtiSubject;
	private int _rtiFeeAmount;
	private Date _createdDate;
	private Date _modifiedDate;
	private String _refId;
	private CsclRtiPaymentDetails _escapedModel;

}