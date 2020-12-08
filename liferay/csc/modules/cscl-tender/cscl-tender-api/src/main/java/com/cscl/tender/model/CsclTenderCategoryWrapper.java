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
 * This class is a wrapper for {@link CsclTenderCategory}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclTenderCategory
 * @generated
 */
@ProviderType
public class CsclTenderCategoryWrapper
	extends BaseModelWrapper<CsclTenderCategory>
	implements CsclTenderCategory, ModelWrapper<CsclTenderCategory> {

	public CsclTenderCategoryWrapper(CsclTenderCategory csclTenderCategory) {
		super(csclTenderCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tenderCatId", getTenderCatId());
		attributes.put("createdById", getCreatedById());
		attributes.put("createDate", getCreateDate());
		attributes.put("category", getCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tenderCatId = (Long)attributes.get("tenderCatId");

		if (tenderCatId != null) {
			setTenderCatId(tenderCatId);
		}

		Long createdById = (Long)attributes.get("createdById");

		if (createdById != null) {
			setCreatedById(createdById);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the category of this cscl tender category.
	 *
	 * @return the category of this cscl tender category
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the localized category of this cscl tender category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized category of this cscl tender category
	 */
	@Override
	public String getCategory(java.util.Locale locale) {
		return model.getCategory(locale);
	}

	/**
	 * Returns the localized category of this cscl tender category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized category of this cscl tender category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getCategory(java.util.Locale locale, boolean useDefault) {
		return model.getCategory(locale, useDefault);
	}

	/**
	 * Returns the localized category of this cscl tender category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized category of this cscl tender category
	 */
	@Override
	public String getCategory(String languageId) {
		return model.getCategory(languageId);
	}

	/**
	 * Returns the localized category of this cscl tender category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized category of this cscl tender category
	 */
	@Override
	public String getCategory(String languageId, boolean useDefault) {
		return model.getCategory(languageId, useDefault);
	}

	@Override
	public String getCategoryCurrentLanguageId() {
		return model.getCategoryCurrentLanguageId();
	}

	@Override
	public String getCategoryCurrentValue() {
		return model.getCategoryCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized categories of this cscl tender category.
	 *
	 * @return the locales and localized categories of this cscl tender category
	 */
	@Override
	public Map<java.util.Locale, String> getCategoryMap() {
		return model.getCategoryMap();
	}

	/**
	 * Returns the create date of this cscl tender category.
	 *
	 * @return the create date of this cscl tender category
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the created by ID of this cscl tender category.
	 *
	 * @return the created by ID of this cscl tender category
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
	 * Returns the primary key of this cscl tender category.
	 *
	 * @return the primary key of this cscl tender category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this cscl tender category.
	 *
	 * @return the status of this cscl tender category
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tender cat ID of this cscl tender category.
	 *
	 * @return the tender cat ID of this cscl tender category
	 */
	@Override
	public long getTenderCatId() {
		return model.getTenderCatId();
	}

	/**
	 * Returns the trash entry created when this cscl tender category was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this cscl tender category.
	 *
	 * @return the trash entry created when this cscl tender category was moved to the Recycle Bin
	 */
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTrashEntry();
	}

	/**
	 * Returns the class primary key of the trash entry for this cscl tender category.
	 *
	 * @return the class primary key of the trash entry for this cscl tender category
	 */
	@Override
	public long getTrashEntryClassPK() {
		return model.getTrashEntryClassPK();
	}

	/**
	 * Returns the trash handler for this cscl tender category.
	 *
	 * @return the trash handler for this cscl tender category
	 * @deprecated As of Judson (7.1.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return model.getTrashHandler();
	}

	/**
	 * Returns <code>true</code> if this cscl tender category is in the Recycle Bin.
	 *
	 * @return <code>true</code> if this cscl tender category is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrash() {
		return model.isInTrash();
	}

	/**
	 * Returns <code>true</code> if the parent of this cscl tender category is in the Recycle Bin.
	 *
	 * @return <code>true</code> if the parent of this cscl tender category is in the Recycle Bin; <code>false</code> otherwise
	 */
	@Override
	public boolean isInTrashContainer() {
		return model.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return model.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return model.isInTrashImplicitly();
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
	 * Sets the category of this cscl tender category.
	 *
	 * @param category the category of this cscl tender category
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the localized category of this cscl tender category in the language.
	 *
	 * @param category the localized category of this cscl tender category
	 * @param locale the locale of the language
	 */
	@Override
	public void setCategory(String category, java.util.Locale locale) {
		model.setCategory(category, locale);
	}

	/**
	 * Sets the localized category of this cscl tender category in the language, and sets the default locale.
	 *
	 * @param category the localized category of this cscl tender category
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCategory(
		String category, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setCategory(category, locale, defaultLocale);
	}

	@Override
	public void setCategoryCurrentLanguageId(String languageId) {
		model.setCategoryCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized categories of this cscl tender category from the map of locales and localized categories.
	 *
	 * @param categoryMap the locales and localized categories of this cscl tender category
	 */
	@Override
	public void setCategoryMap(Map<java.util.Locale, String> categoryMap) {
		model.setCategoryMap(categoryMap);
	}

	/**
	 * Sets the localized categories of this cscl tender category from the map of locales and localized categories, and sets the default locale.
	 *
	 * @param categoryMap the locales and localized categories of this cscl tender category
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setCategoryMap(
		Map<java.util.Locale, String> categoryMap,
		java.util.Locale defaultLocale) {

		model.setCategoryMap(categoryMap, defaultLocale);
	}

	/**
	 * Sets the create date of this cscl tender category.
	 *
	 * @param createDate the create date of this cscl tender category
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the created by ID of this cscl tender category.
	 *
	 * @param createdById the created by ID of this cscl tender category
	 */
	@Override
	public void setCreatedById(long createdById) {
		model.setCreatedById(createdById);
	}

	/**
	 * Sets the primary key of this cscl tender category.
	 *
	 * @param primaryKey the primary key of this cscl tender category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tender cat ID of this cscl tender category.
	 *
	 * @param tenderCatId the tender cat ID of this cscl tender category
	 */
	@Override
	public void setTenderCatId(long tenderCatId) {
		model.setTenderCatId(tenderCatId);
	}

	@Override
	protected CsclTenderCategoryWrapper wrap(
		CsclTenderCategory csclTenderCategory) {

		return new CsclTenderCategoryWrapper(csclTenderCategory);
	}

}