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

package com.cscl.tender.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclTender}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTender
 * @generated
 */
@ProviderType
public class CsclTenderWrapper
	extends BaseModelWrapper<CsclTender>
	implements CsclTender, ModelWrapper<CsclTender> {

	public CsclTenderWrapper(CsclTender csclTender) {
		super(csclTender);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("tenderId", getTenderId());
		attributes.put("createdById", getCreatedById());
		attributes.put("updatedById", getUpdatedById());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("tenderCategoryId", getTenderCategoryId());
		attributes.put("publishDate", getPublishDate());
		attributes.put("lastApplyDate", getLastApplyDate());
		attributes.put("tenderOpeningDate", getTenderOpeningDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long tenderId = (Long)attributes.get("tenderId");

		if (tenderId != null) {
			setTenderId(tenderId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long tenderCategoryId = (Long)attributes.get("tenderCategoryId");

		if (tenderCategoryId != null) {
			setTenderCategoryId(tenderCategoryId);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		Date lastApplyDate = (Date)attributes.get("lastApplyDate");

		if (lastApplyDate != null) {
			setLastApplyDate(lastApplyDate);
		}

		Date tenderOpeningDate = (Date)attributes.get("tenderOpeningDate");

		if (tenderOpeningDate != null) {
			setTenderOpeningDate(tenderOpeningDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the create date of this cscl tender.
	 *
	 * @return the create date of this cscl tender
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by ID of this cscl tender.
	 *
	 * @return the created by ID of this cscl tender
	 */
	@Override
	public long getCreatedById() {
		return model.getCreatedById();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this cscl tender.
	 *
	 * @return the description of this cscl tender
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this cscl tender in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this cscl tender
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this cscl tender in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl tender. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this cscl tender in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this cscl tender
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this cscl tender in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl tender
	 */
	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return model.getDescription(languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return model.getDescriptionCurrentLanguageId();
	}

	@Override
	public String getDescriptionCurrentValue() {
		return model.getDescriptionCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized descriptions of this cscl tender.
	 *
	 * @return the locales and localized descriptions of this cscl tender
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the last apply date of this cscl tender.
	 *
	 * @return the last apply date of this cscl tender
	 */
	@Override
	public Date getLastApplyDate() {
		return model.getLastApplyDate();
	}

	/**
	 * Returns the modified date of this cscl tender.
	 *
	 * @return the modified date of this cscl tender
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this cscl tender.
	 *
	 * @return the primary key of this cscl tender
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publish date of this cscl tender.
	 *
	 * @return the publish date of this cscl tender
	 */
	@Override
	public Date getPublishDate() {
		return model.getPublishDate();
	}

	/**
	 * Returns the status of this cscl tender.
	 *
	 * @return the status of this cscl tender
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tender category ID of this cscl tender.
	 *
	 * @return the tender category ID of this cscl tender
	 */
	@Override
	public long getTenderCategoryId() {
		return model.getTenderCategoryId();
	}

	/**
	 * Returns the tender ID of this cscl tender.
	 *
	 * @return the tender ID of this cscl tender
	 */
	@Override
	public long getTenderId() {
		return model.getTenderId();
	}

	/**
	 * Returns the tender opening date of this cscl tender.
	 *
	 * @return the tender opening date of this cscl tender
	 */
	@Override
	public Date getTenderOpeningDate() {
		return model.getTenderOpeningDate();
	}

	/**
	 * Returns the title of this cscl tender.
	 *
	 * @return the title of this cscl tender
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this cscl tender in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this cscl tender
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this cscl tender in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this cscl tender. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this cscl tender in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this cscl tender
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this cscl tender in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this cscl tender
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this cscl tender.
	 *
	 * @return the locales and localized titles of this cscl tender
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the updated by ID of this cscl tender.
	 *
	 * @return the updated by ID of this cscl tender
	 */
	@Override
	public long getUpdatedById() {
		return model.getUpdatedById();
	}

	/**
	 * Returns the user name of this cscl tender.
	 *
	 * @return the user name of this cscl tender
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this cscl tender.
	 *
	 * @return the uuid of this cscl tender
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the create date of this cscl tender.
	 *
	 * @param createDate the create date of this cscl tender
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by ID of this cscl tender.
	 *
	 * @param createdById the created by ID of this cscl tender
	 */
	@Override
	public void setCreatedById(long createdById) {
		model.setCreatedById(createdById);
	}

	/**
	 * Sets the description of this cscl tender.
	 *
	 * @param description the description of this cscl tender
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this cscl tender in the language.
	 *
	 * @param description the localized description of this cscl tender
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this cscl tender in the language, and sets the default locale.
	 *
	 * @param description the localized description of this cscl tender
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescription(
		String description, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		model.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized descriptions of this cscl tender from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl tender
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this cscl tender from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl tender
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the last apply date of this cscl tender.
	 *
	 * @param lastApplyDate the last apply date of this cscl tender
	 */
	@Override
	public void setLastApplyDate(Date lastApplyDate) {
		model.setLastApplyDate(lastApplyDate);
	}

	/**
	 * Sets the modified date of this cscl tender.
	 *
	 * @param modifiedDate the modified date of this cscl tender
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this cscl tender.
	 *
	 * @param primaryKey the primary key of this cscl tender
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publish date of this cscl tender.
	 *
	 * @param publishDate the publish date of this cscl tender
	 */
	@Override
	public void setPublishDate(Date publishDate) {
		model.setPublishDate(publishDate);
	}

	/**
	 * Sets the status of this cscl tender.
	 *
	 * @param status the status of this cscl tender
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tender category ID of this cscl tender.
	 *
	 * @param tenderCategoryId the tender category ID of this cscl tender
	 */
	@Override
	public void setTenderCategoryId(long tenderCategoryId) {
		model.setTenderCategoryId(tenderCategoryId);
	}

	/**
	 * Sets the tender ID of this cscl tender.
	 *
	 * @param tenderId the tender ID of this cscl tender
	 */
	@Override
	public void setTenderId(long tenderId) {
		model.setTenderId(tenderId);
	}

	/**
	 * Sets the tender opening date of this cscl tender.
	 *
	 * @param tenderOpeningDate the tender opening date of this cscl tender
	 */
	@Override
	public void setTenderOpeningDate(Date tenderOpeningDate) {
		model.setTenderOpeningDate(tenderOpeningDate);
	}

	/**
	 * Sets the title of this cscl tender.
	 *
	 * @param title the title of this cscl tender
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this cscl tender in the language.
	 *
	 * @param title the localized title of this cscl tender
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this cscl tender in the language, and sets the default locale.
	 *
	 * @param title the localized title of this cscl tender
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this cscl tender from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this cscl tender
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this cscl tender from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this cscl tender
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the updated by ID of this cscl tender.
	 *
	 * @param updatedById the updated by ID of this cscl tender
	 */
	@Override
	public void setUpdatedById(long updatedById) {
		model.setUpdatedById(updatedById);
	}

	/**
	 * Sets the user name of this cscl tender.
	 *
	 * @param userName the user name of this cscl tender
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this cscl tender.
	 *
	 * @param uuid the uuid of this cscl tender
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CsclTenderWrapper wrap(CsclTender csclTender) {
		return new CsclTenderWrapper(csclTender);
	}

}