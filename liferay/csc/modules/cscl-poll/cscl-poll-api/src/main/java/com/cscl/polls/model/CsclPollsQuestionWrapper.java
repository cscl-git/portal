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
 * This class is a wrapper for {@link CsclPollsQuestion}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsQuestion
 * @generated
 */
@ProviderType
public class CsclPollsQuestionWrapper
	extends BaseModelWrapper<CsclPollsQuestion>
	implements CsclPollsQuestion, ModelWrapper<CsclPollsQuestion> {

	public CsclPollsQuestionWrapper(CsclPollsQuestion csclPollsQuestion) {
		super(csclPollsQuestion);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("questionId", getQuestionId());
		attributes.put("title", getTitle());
		attributes.put("question", getQuestion());
		attributes.put("description", getDescription());
		attributes.put("expirationDate", getExpirationDate());
		attributes.put("lastPublishDate", getLastPublishDate());
		attributes.put("lastVoteDate", getLastVoteDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long questionId = (Long)attributes.get("questionId");

		if (questionId != null) {
			setQuestionId(questionId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String question = (String)attributes.get("question");

		if (question != null) {
			setQuestion(question);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date expirationDate = (Date)attributes.get("expirationDate");

		if (expirationDate != null) {
			setExpirationDate(expirationDate);
		}

		Date lastPublishDate = (Date)attributes.get("lastPublishDate");

		if (lastPublishDate != null) {
			setLastPublishDate(lastPublishDate);
		}

		Date lastVoteDate = (Date)attributes.get("lastVoteDate");

		if (lastVoteDate != null) {
			setLastVoteDate(lastVoteDate);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the description of this cscl polls question.
	 *
	 * @return the description of this cscl polls question
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the localized description of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this cscl polls question
	 */
	@Override
	public String getDescription(java.util.Locale locale) {
		return model.getDescription(locale);
	}

	/**
	 * Returns the localized description of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl polls question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getDescription(java.util.Locale locale, boolean useDefault) {
		return model.getDescription(locale, useDefault);
	}

	/**
	 * Returns the localized description of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this cscl polls question
	 */
	@Override
	public String getDescription(String languageId) {
		return model.getDescription(languageId);
	}

	/**
	 * Returns the localized description of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this cscl polls question
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
	 * Returns a map of the locales and localized descriptions of this cscl polls question.
	 *
	 * @return the locales and localized descriptions of this cscl polls question
	 */
	@Override
	public Map<java.util.Locale, String> getDescriptionMap() {
		return model.getDescriptionMap();
	}

	/**
	 * Returns the expiration date of this cscl polls question.
	 *
	 * @return the expiration date of this cscl polls question
	 */
	@Override
	public Date getExpirationDate() {
		return model.getExpirationDate();
	}

	/**
	 * Returns the last publish date of this cscl polls question.
	 *
	 * @return the last publish date of this cscl polls question
	 */
	@Override
	public Date getLastPublishDate() {
		return model.getLastPublishDate();
	}

	/**
	 * Returns the last vote date of this cscl polls question.
	 *
	 * @return the last vote date of this cscl polls question
	 */
	@Override
	public Date getLastVoteDate() {
		return model.getLastVoteDate();
	}

	/**
	 * Returns the primary key of this cscl polls question.
	 *
	 * @return the primary key of this cscl polls question
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the question of this cscl polls question.
	 *
	 * @return the question of this cscl polls question
	 */
	@Override
	public String getQuestion() {
		return model.getQuestion();
	}

	/**
	 * Returns the localized question of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized question of this cscl polls question
	 */
	@Override
	public String getQuestion(java.util.Locale locale) {
		return model.getQuestion(locale);
	}

	/**
	 * Returns the localized question of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this cscl polls question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getQuestion(java.util.Locale locale, boolean useDefault) {
		return model.getQuestion(locale, useDefault);
	}

	/**
	 * Returns the localized question of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized question of this cscl polls question
	 */
	@Override
	public String getQuestion(String languageId) {
		return model.getQuestion(languageId);
	}

	/**
	 * Returns the localized question of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized question of this cscl polls question
	 */
	@Override
	public String getQuestion(String languageId, boolean useDefault) {
		return model.getQuestion(languageId, useDefault);
	}

	@Override
	public String getQuestionCurrentLanguageId() {
		return model.getQuestionCurrentLanguageId();
	}

	@Override
	public String getQuestionCurrentValue() {
		return model.getQuestionCurrentValue();
	}

	/**
	 * Returns the question ID of this cscl polls question.
	 *
	 * @return the question ID of this cscl polls question
	 */
	@Override
	public long getQuestionId() {
		return model.getQuestionId();
	}

	/**
	 * Returns a map of the locales and localized questions of this cscl polls question.
	 *
	 * @return the locales and localized questions of this cscl polls question
	 */
	@Override
	public Map<java.util.Locale, String> getQuestionMap() {
		return model.getQuestionMap();
	}

	/**
	 * Returns the title of this cscl polls question.
	 *
	 * @return the title of this cscl polls question
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this cscl polls question
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this cscl polls question. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this cscl polls question in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this cscl polls question
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this cscl polls question in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this cscl polls question
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
	 * Returns a map of the locales and localized titles of this cscl polls question.
	 *
	 * @return the locales and localized titles of this cscl polls question
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
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
	 * Sets the description of this cscl polls question.
	 *
	 * @param description the description of this cscl polls question
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the localized description of this cscl polls question in the language.
	 *
	 * @param description the localized description of this cscl polls question
	 * @param locale the locale of the language
	 */
	@Override
	public void setDescription(String description, java.util.Locale locale) {
		model.setDescription(description, locale);
	}

	/**
	 * Sets the localized description of this cscl polls question in the language, and sets the default locale.
	 *
	 * @param description the localized description of this cscl polls question
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
	 * Sets the localized descriptions of this cscl polls question from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl polls question
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap) {

		model.setDescriptionMap(descriptionMap);
	}

	/**
	 * Sets the localized descriptions of this cscl polls question from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this cscl polls question
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, String> descriptionMap,
		java.util.Locale defaultLocale) {

		model.setDescriptionMap(descriptionMap, defaultLocale);
	}

	/**
	 * Sets the expiration date of this cscl polls question.
	 *
	 * @param expirationDate the expiration date of this cscl polls question
	 */
	@Override
	public void setExpirationDate(Date expirationDate) {
		model.setExpirationDate(expirationDate);
	}

	/**
	 * Sets the last publish date of this cscl polls question.
	 *
	 * @param lastPublishDate the last publish date of this cscl polls question
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		model.setLastPublishDate(lastPublishDate);
	}

	/**
	 * Sets the last vote date of this cscl polls question.
	 *
	 * @param lastVoteDate the last vote date of this cscl polls question
	 */
	@Override
	public void setLastVoteDate(Date lastVoteDate) {
		model.setLastVoteDate(lastVoteDate);
	}

	/**
	 * Sets the primary key of this cscl polls question.
	 *
	 * @param primaryKey the primary key of this cscl polls question
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the question of this cscl polls question.
	 *
	 * @param question the question of this cscl polls question
	 */
	@Override
	public void setQuestion(String question) {
		model.setQuestion(question);
	}

	/**
	 * Sets the localized question of this cscl polls question in the language.
	 *
	 * @param question the localized question of this cscl polls question
	 * @param locale the locale of the language
	 */
	@Override
	public void setQuestion(String question, java.util.Locale locale) {
		model.setQuestion(question, locale);
	}

	/**
	 * Sets the localized question of this cscl polls question in the language, and sets the default locale.
	 *
	 * @param question the localized question of this cscl polls question
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setQuestion(
		String question, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setQuestion(question, locale, defaultLocale);
	}

	@Override
	public void setQuestionCurrentLanguageId(String languageId) {
		model.setQuestionCurrentLanguageId(languageId);
	}

	/**
	 * Sets the question ID of this cscl polls question.
	 *
	 * @param questionId the question ID of this cscl polls question
	 */
	@Override
	public void setQuestionId(long questionId) {
		model.setQuestionId(questionId);
	}

	/**
	 * Sets the localized questions of this cscl polls question from the map of locales and localized questions.
	 *
	 * @param questionMap the locales and localized questions of this cscl polls question
	 */
	@Override
	public void setQuestionMap(Map<java.util.Locale, String> questionMap) {
		model.setQuestionMap(questionMap);
	}

	/**
	 * Sets the localized questions of this cscl polls question from the map of locales and localized questions, and sets the default locale.
	 *
	 * @param questionMap the locales and localized questions of this cscl polls question
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setQuestionMap(
		Map<java.util.Locale, String> questionMap,
		java.util.Locale defaultLocale) {

		model.setQuestionMap(questionMap, defaultLocale);
	}

	/**
	 * Sets the title of this cscl polls question.
	 *
	 * @param title the title of this cscl polls question
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this cscl polls question in the language.
	 *
	 * @param title the localized title of this cscl polls question
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this cscl polls question in the language, and sets the default locale.
	 *
	 * @param title the localized title of this cscl polls question
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
	 * Sets the localized titles of this cscl polls question from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this cscl polls question
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this cscl polls question from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this cscl polls question
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	@Override
	protected CsclPollsQuestionWrapper wrap(
		CsclPollsQuestion csclPollsQuestion) {

		return new CsclPollsQuestionWrapper(csclPollsQuestion);
	}

}