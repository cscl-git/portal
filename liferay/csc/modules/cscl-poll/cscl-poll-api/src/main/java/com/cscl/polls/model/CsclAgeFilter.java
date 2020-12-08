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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CsclAgeFilter service. Represents a row in the &quot;cscl_age_filter&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CsclAgeFilterModel
 * @generated
 */
@ImplementationClassName("com.cscl.polls.model.impl.CsclAgeFilterImpl")
@ProviderType
public interface CsclAgeFilter extends CsclAgeFilterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.cscl.polls.model.impl.CsclAgeFilterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CsclAgeFilter, Long> ID__ACCESSOR =
		new Accessor<CsclAgeFilter, Long>() {

			@Override
			public Long get(CsclAgeFilter csclAgeFilter) {
				return csclAgeFilter.getId_();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CsclAgeFilter> getTypeClass() {
				return CsclAgeFilter.class;
			}

		};

}