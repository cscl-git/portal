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

package com.cscl.feedback.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link FeedbackService}.
 *
 * @author Brian Wing Shun Chan
 * @see FeedbackService
 * @generated
 */
@ProviderType
public class FeedbackServiceWrapper
	implements FeedbackService, ServiceWrapper<FeedbackService> {

	public FeedbackServiceWrapper(FeedbackService feedbackService) {
		_feedbackService = feedbackService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _feedbackService.getOSGiServiceIdentifier();
	}

	@Override
	public FeedbackService getWrappedService() {
		return _feedbackService;
	}

	@Override
	public void setWrappedService(FeedbackService feedbackService) {
		_feedbackService = feedbackService;
	}

	private FeedbackService _feedbackService;

}