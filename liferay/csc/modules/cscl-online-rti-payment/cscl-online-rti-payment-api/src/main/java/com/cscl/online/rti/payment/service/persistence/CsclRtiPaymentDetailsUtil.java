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

package com.cscl.online.rti.payment.service.persistence;

import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl rti payment details service. This utility wraps <code>com.cscl.online.rti.payment.service.persistence.impl.CsclRtiPaymentDetailsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclRtiPaymentDetailsPersistence
 * @generated
 */
@ProviderType
public class CsclRtiPaymentDetailsUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(CsclRtiPaymentDetails csclRtiPaymentDetails) {
		getPersistence().clearCache(csclRtiPaymentDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, CsclRtiPaymentDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclRtiPaymentDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclRtiPaymentDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclRtiPaymentDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclRtiPaymentDetails update(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		return getPersistence().update(csclRtiPaymentDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclRtiPaymentDetails update(
		CsclRtiPaymentDetails csclRtiPaymentDetails,
		ServiceContext serviceContext) {

		return getPersistence().update(csclRtiPaymentDetails, serviceContext);
	}

	/**
	 * Caches the cscl rti payment details in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 */
	public static void cacheResult(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		getPersistence().cacheResult(csclRtiPaymentDetails);
	}

	/**
	 * Caches the cscl rti payment detailses in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetailses the cscl rti payment detailses
	 */
	public static void cacheResult(
		List<CsclRtiPaymentDetails> csclRtiPaymentDetailses) {

		getPersistence().cacheResult(csclRtiPaymentDetailses);
	}

	/**
	 * Creates a new cscl rti payment details with the primary key. Does not add the cscl rti payment details to the database.
	 *
	 * @param id the primary key for the new cscl rti payment details
	 * @return the new cscl rti payment details
	 */
	public static CsclRtiPaymentDetails create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the cscl rti payment details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	public static CsclRtiPaymentDetails remove(long id)
		throws com.cscl.online.rti.payment.exception.NoSuchDetailsException {

		return getPersistence().remove(id);
	}

	public static CsclRtiPaymentDetails updateImpl(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		return getPersistence().updateImpl(csclRtiPaymentDetails);
	}

	/**
	 * Returns the cscl rti payment details with the primary key or throws a <code>NoSuchDetailsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	public static CsclRtiPaymentDetails findByPrimaryKey(long id)
		throws com.cscl.online.rti.payment.exception.NoSuchDetailsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the cscl rti payment details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details, or <code>null</code> if a cscl rti payment details with the primary key could not be found
	 */
	public static CsclRtiPaymentDetails fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the cscl rti payment detailses.
	 *
	 * @return the cscl rti payment detailses
	 */
	public static List<CsclRtiPaymentDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl rti payment detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl rti payment detailses
	 * @param end the upper bound of the range of cscl rti payment detailses (not inclusive)
	 * @return the range of cscl rti payment detailses
	 */
	public static List<CsclRtiPaymentDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl rti payment detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl rti payment detailses
	 * @param end the upper bound of the range of cscl rti payment detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl rti payment detailses
	 */
	@Deprecated
	public static List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl rti payment detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclRtiPaymentDetailsModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl rti payment detailses
	 * @param end the upper bound of the range of cscl rti payment detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl rti payment detailses
	 */
	public static List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl rti payment detailses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl rti payment detailses.
	 *
	 * @return the number of cscl rti payment detailses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclRtiPaymentDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclRtiPaymentDetailsPersistence, CsclRtiPaymentDetailsPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclRtiPaymentDetailsPersistence.class);

		ServiceTracker
			<CsclRtiPaymentDetailsPersistence, CsclRtiPaymentDetailsPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclRtiPaymentDetailsPersistence,
						 CsclRtiPaymentDetailsPersistence>(
							 bundle.getBundleContext(),
							 CsclRtiPaymentDetailsPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}