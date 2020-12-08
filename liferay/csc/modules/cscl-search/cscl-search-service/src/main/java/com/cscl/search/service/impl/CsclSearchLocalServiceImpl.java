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

package com.cscl.search.service.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.cscl.search.model.CsclSearch;
import com.cscl.search.service.CsclSearchLocalServiceUtil;
import com.cscl.search.service.base.CsclSearchLocalServiceBaseImpl;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

/**
 * The implementation of the cscl search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.cscl.search.service.CsclSearchLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CsclSearchLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.cscl.search.model.CsclSearch",
	service = AopService.class
)
public class CsclSearchLocalServiceImpl extends CsclSearchLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.cscl.search.service.CsclSearchLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.cscl.search.service.CsclSearchLocalServiceUtil</code>.
	 */
	public List<CsclSearch> fetchSearchResultByKeyword(int status, String keywords){
		return this.csclSearchPersistence.findByKeywords(status, keywords);
	}
	public List<CsclSearch> findByKeyword(int status, String keywords){
		DynamicQuery dynamicQuery = CsclSearchLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.ilike("keywords", StringPool.PERCENT + keywords+ StringPool.PERCENT);
		criterion = RestrictionsFactoryUtil.and(criterion , RestrictionsFactoryUtil.eq("status", status));
		dynamicQuery.add(criterion); 
		List<CsclSearch> searchList = CsclSearchLocalServiceUtil.dynamicQuery(dynamicQuery);
		return searchList;
	}
}