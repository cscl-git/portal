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

package com.cscl.polls.service.impl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.service.base.CsclPollsMasterLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

/**
 * The implementation of the cscl polls master local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.cscl.polls.service.CsclPollsMasterLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclPollsMasterLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.cscl.polls.model.CsclPollsMaster",
	service = AopService.class
)
public class CsclPollsMasterLocalServiceImpl
	extends CsclPollsMasterLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.cscl.polls.service.CsclPollsMasterLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.cscl.polls.service.CsclPollsMasterLocalServiceUtil</code>.
	 */
	
	public List<CsclPollsMaster> getPollsByQuestionId(long questionId) {
		return csclPollsMasterPersistence.findBypollId(questionId);
	}
	
	public List<CsclPollsMaster> getPollsByLocalities(long entryId,int locality) {
		return csclPollsMasterPersistence.findBylocality(locality, entryId);
	}

	public List<CsclPollsMaster> getPollsBySex(long entryId,String sex) {
		return csclPollsMasterPersistence.findBysex(sex, entryId);
	}

	public List<CsclPollsMaster> getPollsByAge(long entryId,Date age) {
		return csclPollsMasterPersistence.findByage(age, entryId);
	}
	
	public List<CsclPollsMaster> getPollsByAgeAndSex(long entryId,Date age, String sex) {
		return csclPollsMasterPersistence.findByageAndSex(age, sex, entryId);
	}

	public List<CsclPollsMaster> getPollsByAgeAndLocality(long entryId,Date age, int locality) {
		return csclPollsMasterPersistence.findByageAndLocality(age, locality, entryId);
	}

	public List<CsclPollsMaster> getPollsByLocalityAndSex(long entryId, int locality, String sex) {
		return csclPollsMasterPersistence.findBysexAndLocality(sex, locality, entryId);
	}
	
	public List<CsclPollsMaster> getPollsByLocalityAndSexAndAge(long entryId, int locality, String sex, Date age) {
		return csclPollsMasterPersistence.findByageAndSexAndLocality(age, sex, locality, entryId);
	}
}