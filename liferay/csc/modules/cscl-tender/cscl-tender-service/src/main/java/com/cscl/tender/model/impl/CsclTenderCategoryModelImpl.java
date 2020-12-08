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
import com.cscl.tender.model.CsclTenderCategoryModel;
import com.cscl.tender.model.CsclTenderCategorySoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the CsclTenderCategory service. Represents a row in the &quot;cscl_tender_category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CsclTenderCategoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CsclTenderCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderCategoryImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CsclTenderCategoryModelImpl
	extends BaseModelImpl<CsclTenderCategory>
	implements CsclTenderCategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cscl tender category model instance should use the <code>CsclTenderCategory</code> interface instead.
	 */
	public static final String TABLE_NAME = "cscl_tender_category";

	public static final Object[][] TABLE_COLUMNS = {
		{"tenderCatId", Types.BIGINT}, {"createdById", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"category", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("tenderCatId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createdById", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("category", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table cscl_tender_category (tenderCatId LONG not null primary key,createdById LONG,createDate DATE null,category STRING null)";

	public static final String TABLE_SQL_DROP =
		"drop table cscl_tender_category";

	public static final String ORDER_BY_JPQL =
		" ORDER BY csclTenderCategory.category ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY cscl_tender_category.category ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CsclTenderCategory toModel(CsclTenderCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CsclTenderCategory model = new CsclTenderCategoryImpl();

		model.setTenderCatId(soapModel.getTenderCatId());
		model.setCreatedById(soapModel.getCreatedById());
		model.setCreateDate(soapModel.getCreateDate());
		model.setCategory(soapModel.getCategory());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CsclTenderCategory> toModels(
		CsclTenderCategorySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CsclTenderCategory> models = new ArrayList<CsclTenderCategory>(
			soapModels.length);

		for (CsclTenderCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public CsclTenderCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _tenderCatId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTenderCatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _tenderCatId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CsclTenderCategory.class;
	}

	@Override
	public String getModelClassName() {
		return CsclTenderCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CsclTenderCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CsclTenderCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTenderCategory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CsclTenderCategory)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CsclTenderCategory, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CsclTenderCategory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CsclTenderCategory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CsclTenderCategory, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CsclTenderCategory, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CsclTenderCategory>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CsclTenderCategory.class.getClassLoader(), CsclTenderCategory.class,
			ModelWrapper.class);

		try {
			Constructor<CsclTenderCategory> constructor =
				(Constructor<CsclTenderCategory>)proxyClass.getConstructor(
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

	private static final Map<String, Function<CsclTenderCategory, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CsclTenderCategory, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CsclTenderCategory, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<CsclTenderCategory, Object>>();
		Map<String, BiConsumer<CsclTenderCategory, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CsclTenderCategory, ?>>();

		attributeGetterFunctions.put(
			"tenderCatId", CsclTenderCategory::getTenderCatId);
		attributeSetterBiConsumers.put(
			"tenderCatId",
			(BiConsumer<CsclTenderCategory, Long>)
				CsclTenderCategory::setTenderCatId);
		attributeGetterFunctions.put(
			"createdById", CsclTenderCategory::getCreatedById);
		attributeSetterBiConsumers.put(
			"createdById",
			(BiConsumer<CsclTenderCategory, Long>)
				CsclTenderCategory::setCreatedById);
		attributeGetterFunctions.put(
			"createDate", CsclTenderCategory::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<CsclTenderCategory, Date>)
				CsclTenderCategory::setCreateDate);
		attributeGetterFunctions.put(
			"category", CsclTenderCategory::getCategory);
		attributeSetterBiConsumers.put(
			"category",
			(BiConsumer<CsclTenderCategory, String>)
				CsclTenderCategory::setCategory);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTenderCatId() {
		return _tenderCatId;
	}

	@Override
	public void setTenderCatId(long tenderCatId) {
		_tenderCatId = tenderCatId;
	}

	@JSON
	@Override
	public long getCreatedById() {
		return _createdById;
	}

	@Override
	public void setCreatedById(long createdById) {
		_createdById = createdById;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getCategory() {
		if (_category == null) {
			return "";
		}
		else {
			return _category;
		}
	}

	@Override
	public String getCategory(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCategory(languageId);
	}

	@Override
	public String getCategory(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getCategory(languageId, useDefault);
	}

	@Override
	public String getCategory(String languageId) {
		return LocalizationUtil.getLocalization(getCategory(), languageId);
	}

	@Override
	public String getCategory(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getCategory(), languageId, useDefault);
	}

	@Override
	public String getCategoryCurrentLanguageId() {
		return _categoryCurrentLanguageId;
	}

	@JSON
	@Override
	public String getCategoryCurrentValue() {
		Locale locale = getLocale(_categoryCurrentLanguageId);

		return getCategory(locale);
	}

	@Override
	public Map<Locale, String> getCategoryMap() {
		return LocalizationUtil.getLocalizationMap(getCategory());
	}

	@Override
	public void setCategory(String category) {
		_category = category;
	}

	@Override
	public void setCategory(String category, Locale locale) {
		setCategory(category, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setCategory(
		String category, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(category)) {
			setCategory(
				LocalizationUtil.updateLocalization(
					getCategory(), "Category", category, languageId,
					defaultLanguageId));
		}
		else {
			setCategory(
				LocalizationUtil.removeLocalization(
					getCategory(), "Category", languageId));
		}
	}

	@Override
	public void setCategoryCurrentLanguageId(String languageId) {
		_categoryCurrentLanguageId = languageId;
	}

	@Override
	public void setCategoryMap(Map<Locale, String> categoryMap) {
		setCategoryMap(categoryMap, LocaleUtil.getDefault());
	}

	@Override
	public void setCategoryMap(
		Map<Locale, String> categoryMap, Locale defaultLocale) {

		if (categoryMap == null) {
			return;
		}

		setCategory(
			LocalizationUtil.updateLocalization(
				categoryMap, getCategory(), "Category",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	@Override
	public int getStatus() {
		return 0;
	}

	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws PortalException {

		if (!isInTrash()) {
			return null;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return trashEntry;
		}

		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if (Validator.isNotNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			ContainerModel containerModel = null;

			try {
				containerModel = trashHandler.getParentContainerModel(this);
			}
			catch (NoSuchModelException nsme) {
				return null;
			}

			while (containerModel != null) {
				if (containerModel instanceof TrashedModel) {
					TrashedModel trashedModel = (TrashedModel)containerModel;

					return trashedModel.getTrashEntry();
				}

				trashHandler =
					com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
						getTrashHandler(
							trashHandler.getContainerModelClassName(
								containerModel.getContainerModelId()));

				if (trashHandler == null) {
					return null;
				}

				containerModel = trashHandler.getContainerModel(
					containerModel.getParentContainerModelId());
			}
		}

		return null;
	}

	@Override
	public long getTrashEntryClassPK() {
		return getPrimaryKey();
	}

	/**
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil.
			getTrashHandler(getModelClassName());
	}

	@Override
	public boolean isInTrash() {
		if (getStatus() == WorkflowConstants.STATUS_IN_TRASH) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInTrashContainer() {
		com.liferay.portal.kernel.trash.TrashHandler trashHandler =
			getTrashHandler();

		if ((trashHandler == null) ||
			Validator.isNull(
				trashHandler.getContainerModelClassName(getPrimaryKey()))) {

			return false;
		}

		try {
			ContainerModel containerModel =
				trashHandler.getParentContainerModel(this);

			if (containerModel == null) {
				return false;
			}

			if (containerModel instanceof TrashedModel) {
				return ((TrashedModel)containerModel).isInTrash();
			}
		}
		catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean isInTrashExplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isInTrashImplicitly() {
		if (!isInTrash()) {
			return false;
		}

		com.liferay.trash.kernel.model.TrashEntry trashEntry =
			com.liferay.trash.kernel.service.TrashEntryLocalServiceUtil.
				fetchEntry(getModelClassName(), getTrashEntryClassPK());

		if (trashEntry != null) {
			return false;
		}

		return true;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, CsclTenderCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> categoryMap = getCategoryMap();

		for (Map.Entry<Locale, String> entry : categoryMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getCategory();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			CsclTenderCategory.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String category = getCategory(defaultLocale);

		if (Validator.isNull(category)) {
			setCategory(getCategory(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setCategory(
				getCategory(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CsclTenderCategory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CsclTenderCategory>
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
		CsclTenderCategoryImpl csclTenderCategoryImpl =
			new CsclTenderCategoryImpl();

		csclTenderCategoryImpl.setTenderCatId(getTenderCatId());
		csclTenderCategoryImpl.setCreatedById(getCreatedById());
		csclTenderCategoryImpl.setCreateDate(getCreateDate());
		csclTenderCategoryImpl.setCategory(getCategory());

		csclTenderCategoryImpl.resetOriginalValues();

		return csclTenderCategoryImpl;
	}

	@Override
	public int compareTo(CsclTenderCategory csclTenderCategory) {
		int value = 0;

		value = getCategory().compareTo(csclTenderCategory.getCategory());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CsclTenderCategory)) {
			return false;
		}

		CsclTenderCategory csclTenderCategory = (CsclTenderCategory)obj;

		long primaryKey = csclTenderCategory.getPrimaryKey();

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
	public CacheModel<CsclTenderCategory> toCacheModel() {
		CsclTenderCategoryCacheModel csclTenderCategoryCacheModel =
			new CsclTenderCategoryCacheModel();

		csclTenderCategoryCacheModel.tenderCatId = getTenderCatId();

		csclTenderCategoryCacheModel.createdById = getCreatedById();

		Date createDate = getCreateDate();

		if (createDate != null) {
			csclTenderCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			csclTenderCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		csclTenderCategoryCacheModel.category = getCategory();

		String category = csclTenderCategoryCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			csclTenderCategoryCacheModel.category = null;
		}

		return csclTenderCategoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CsclTenderCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CsclTenderCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTenderCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CsclTenderCategory)this));
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
		Map<String, Function<CsclTenderCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CsclTenderCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CsclTenderCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CsclTenderCategory)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CsclTenderCategory>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _tenderCatId;
	private long _createdById;
	private Date _createDate;
	private String _category;
	private String _categoryCurrentLanguageId;
	private CsclTenderCategory _escapedModel;

}