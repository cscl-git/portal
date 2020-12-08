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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link CsclPollsChoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsChoice
 * @generated
 */
@ProviderType
public class CsclPollsChoiceWrapper
	extends BaseModelWrapper<CsclPollsChoice>
	implements CsclPollsChoice, ModelWrapper<CsclPollsChoice> {

	public CsclPollsChoiceWrapper(CsclPollsChoice csclPollsChoice) {
		super(csclPollsChoice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("choiceId", getChoiceId());
		attributes.put("questionId", getQuestionId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("lastPublishDate", getLastPublishDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long choiceId = (Long)attributes.get("choiceId");

		if (choiceId != null) {
			setChoiceId(choiceId);
		}

		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the choice ID of this cscl polls choice.
	 *
	 * @return the choice ID of this cscl polls choice
	 */
	@Override
	public long getChoiceId() {
		return model.getChoiceId();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this cscl polls choice.
	 *
	 * @return the description of this cscl polls choice
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this cscl polls choice in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this cscl polls choice
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this cscl polls choice in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl polls choice. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this cscl polls choice in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this cscl polls choice
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this cscl polls choice in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl polls choice
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
	 * Returns a map of the locales and localized descriptions of this cscl polls choice.
	 *
	 * @return the locales and localized descriptions of this cscl polls choice
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the last publish date of this cscl polls choice.
	 *
	 * @return the last publish date of this cscl polls choice
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the name of this cscl polls choice.
	 *
	 * @return the name of this cscl polls choice
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this cscl polls choice.
	 *
	 * @return the primary key of this cscl polls choice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question ID of this cscl polls choice.
	 *
	 * @return the question ID of this cscl polls choice
	 */
	@Override
	public long getQuestionId() {
		return model.getQuestionId();
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
	 * Sets the choice ID of this cscl polls choice.
	 *
	 * @param choiceId the choice ID of this cscl polls choice
	 */
	@Override
	public void setChoiceId(long choiceId) {
		model.setChoiceId(choiceId);
	}

	/**
	 * Sets the description of this cscl polls choice.
	 *
	 * @param description the description of this cscl polls choice
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this cscl polls choice in the language.
	 *
	 * @param description the localized description of this cscl polls choice
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this cscl polls choice in the language, and sets the default locale.
	 *
	 * @param description the localized description of this cscl polls choice
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
	 * Sets the localized descriptions of this cscl polls choice from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl polls choice
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this cscl polls choice from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl polls choice
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the last publish date of this cscl polls choice.
	 *
	 * @param lastPublishDate the last publish date of this cscl polls choice
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the name of this cscl polls choice.
	 *
	 * @param name the name of this cscl polls choice
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this cscl polls choice.
	 *
	 * @param primaryKey the primary key of this cscl polls choice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question ID of this cscl polls choice.
	 *
	 * @param questionId the question ID of this cscl polls choice
	 */
	@Override
	public void setQuestionId(long questionId) {
		model.setQuestionId(questionId);
	}

	@Override
	protected CsclPollsChoiceWrapper wrap(CsclPollsChoice csclPollsChoice) {
		return new CsclPollsChoiceWrapper(csclPollsChoice);
	}

}