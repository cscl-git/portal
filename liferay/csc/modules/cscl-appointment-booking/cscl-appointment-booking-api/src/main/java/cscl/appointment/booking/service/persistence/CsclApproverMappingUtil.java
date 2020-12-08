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

package cscl.appointment.booking.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.model.CsclApproverMapping;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the cscl approver mapping service. This utility wraps <code>cscl.appointment.booking.service.persistence.impl.CsclApproverMappingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMappingPersistence
 * @generated
 */
@ProviderType
public class CsclApproverMappingUtil {

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
	public static void clearCache(CsclApproverMapping csclApproverMapping) {
		getPersistence().clearCache(csclApproverMapping);
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
	public static Map<Serializable, CsclApproverMapping> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CsclApproverMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CsclApproverMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CsclApproverMapping> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CsclApproverMapping update(
		CsclApproverMapping csclApproverMapping) {

		return getPersistence().update(csclApproverMapping);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CsclApproverMapping update(
		CsclApproverMapping csclApproverMapping,
		ServiceContext serviceContext) {

		return getPersistence().update(csclApproverMapping, serviceContext);
	}

	/**
	 * Returns all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByassignedTo(long assignedTo) {
		return getPersistence().findByassignedTo(assignedTo);
	}

	/**
	 * Returns a range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end) {

		return getPersistence().findByassignedTo(assignedTo, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByassignedTo(long, int, int, OrderByComparator)}
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Deprecated
	public static List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByassignedTo(
			assignedTo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param assignedTo the assigned to
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().findByassignedTo(
			assignedTo, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping findByassignedTo_First(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByassignedTo_First(
			assignedTo, orderByComparator);
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping fetchByassignedTo_First(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().fetchByassignedTo_First(
			assignedTo, orderByComparator);
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping findByassignedTo_Last(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByassignedTo_Last(
			assignedTo, orderByComparator);
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping fetchByassignedTo_Last(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().fetchByassignedTo_Last(
			assignedTo, orderByComparator);
	}

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public static CsclApproverMapping[] findByassignedTo_PrevAndNext(
			long id_, long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByassignedTo_PrevAndNext(
			id_, assignedTo, orderByComparator);
	}

	/**
	 * Removes all the cscl approver mappings where assignedTo = &#63; from the database.
	 *
	 * @param assignedTo the assigned to
	 */
	public static void removeByassignedTo(long assignedTo) {
		getPersistence().removeByassignedTo(assignedTo);
	}

	/**
	 * Returns the number of cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the number of matching cscl approver mappings
	 */
	public static int countByassignedTo(long assignedTo) {
		return getPersistence().countByassignedTo(assignedTo);
	}

	/**
	 * Returns all the cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByappointeeId(int appointee) {
		return getPersistence().findByappointeeId(appointee);
	}

	/**
	 * Returns a range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end) {

		return getPersistence().findByappointeeId(appointee, start, end);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointeeId(int, int, int, OrderByComparator)}
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver mappings
	 */
	@Deprecated
	public static List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByappointeeId(
			appointee, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver mappings
	 */
	public static List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().findByappointeeId(
			appointee, start, end, orderByComparator);
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping findByappointeeId_First(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByappointeeId_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping fetchByappointeeId_First(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().fetchByappointeeId_First(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping findByappointeeId_Last(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByappointeeId_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public static CsclApproverMapping fetchByappointeeId_Last(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().fetchByappointeeId_Last(
			appointee, orderByComparator);
	}

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public static CsclApproverMapping[] findByappointeeId_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByappointeeId_PrevAndNext(
			id_, appointee, orderByComparator);
	}

	/**
	 * Removes all the cscl approver mappings where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public static void removeByappointeeId(int appointee) {
		getPersistence().removeByappointeeId(appointee);
	}

	/**
	 * Returns the number of cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl approver mappings
	 */
	public static int countByappointeeId(int appointee) {
		return getPersistence().countByappointeeId(appointee);
	}

	/**
	 * Caches the cscl approver mapping in the entity cache if it is enabled.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 */
	public static void cacheResult(CsclApproverMapping csclApproverMapping) {
		getPersistence().cacheResult(csclApproverMapping);
	}

	/**
	 * Caches the cscl approver mappings in the entity cache if it is enabled.
	 *
	 * @param csclApproverMappings the cscl approver mappings
	 */
	public static void cacheResult(
		List<CsclApproverMapping> csclApproverMappings) {

		getPersistence().cacheResult(csclApproverMappings);
	}

	/**
	 * Creates a new cscl approver mapping with the primary key. Does not add the cscl approver mapping to the database.
	 *
	 * @param id_ the primary key for the new cscl approver mapping
	 * @return the new cscl approver mapping
	 */
	public static CsclApproverMapping create(long id_) {
		return getPersistence().create(id_);
	}

	/**
	 * Removes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public static CsclApproverMapping remove(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().remove(id_);
	}

	public static CsclApproverMapping updateImpl(
		CsclApproverMapping csclApproverMapping) {

		return getPersistence().updateImpl(csclApproverMapping);
	}

	/**
	 * Returns the cscl approver mapping with the primary key or throws a <code>NoSuchCsclApproverMappingException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public static CsclApproverMapping findByPrimaryKey(long id_)
		throws cscl.appointment.booking.exception.
			NoSuchCsclApproverMappingException {

		return getPersistence().findByPrimaryKey(id_);
	}

	/**
	 * Returns the cscl approver mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping, or <code>null</code> if a cscl approver mapping with the primary key could not be found
	 */
	public static CsclApproverMapping fetchByPrimaryKey(long id_) {
		return getPersistence().fetchByPrimaryKey(id_);
	}

	/**
	 * Returns all the cscl approver mappings.
	 *
	 * @return the cscl approver mappings
	 */
	public static List<CsclApproverMapping> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @return the range of cscl approver mappings
	 */
	public static List<CsclApproverMapping> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl approver mappings
	 */
	@Deprecated
	public static List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the cscl approver mappings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMappingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver mappings
	 * @param end the upper bound of the range of cscl approver mappings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl approver mappings
	 */
	public static List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the cscl approver mappings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cscl approver mappings.
	 *
	 * @return the number of cscl approver mappings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CsclApproverMappingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CsclApproverMappingPersistence, CsclApproverMappingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CsclApproverMappingPersistence.class);

		ServiceTracker
			<CsclApproverMappingPersistence, CsclApproverMappingPersistence>
				serviceTracker =
					new ServiceTracker
						<CsclApproverMappingPersistence,
						 CsclApproverMappingPersistence>(
							 bundle.getBundleContext(),
							 CsclApproverMappingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}