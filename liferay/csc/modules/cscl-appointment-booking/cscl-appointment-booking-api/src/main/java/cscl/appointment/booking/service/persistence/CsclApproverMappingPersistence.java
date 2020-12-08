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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import cscl.appointment.booking.exception.NoSuchCsclApproverMappingException;
import cscl.appointment.booking.model.CsclApproverMapping;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl approver mapping service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMappingUtil
 * @generated
 */
@ProviderType
public interface CsclApproverMappingPersistence
	extends BasePersistence<CsclApproverMapping> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclApproverMappingUtil} to access the cscl approver mapping persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the matching cscl approver mappings
	 */
	public java.util.List<CsclApproverMapping> findByassignedTo(
		long assignedTo);

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
	public java.util.List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end);

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
	public java.util.List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclApproverMapping> findByassignedTo(
		long assignedTo, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping findByassignedTo_First(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Returns the first cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping fetchByassignedTo_First(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping findByassignedTo_Last(
			long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Returns the last cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping fetchByassignedTo_Last(
		long assignedTo,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where assignedTo = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param assignedTo the assigned to
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public CsclApproverMapping[] findByassignedTo_PrevAndNext(
			long id_, long assignedTo,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Removes all the cscl approver mappings where assignedTo = &#63; from the database.
	 *
	 * @param assignedTo the assigned to
	 */
	public void removeByassignedTo(long assignedTo);

	/**
	 * Returns the number of cscl approver mappings where assignedTo = &#63;.
	 *
	 * @param assignedTo the assigned to
	 * @return the number of matching cscl approver mappings
	 */
	public int countByassignedTo(long assignedTo);

	/**
	 * Returns all the cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl approver mappings
	 */
	public java.util.List<CsclApproverMapping> findByappointeeId(int appointee);

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
	public java.util.List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end);

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
	public java.util.List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclApproverMapping> findByappointeeId(
		int appointee, int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping findByappointeeId_First(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Returns the first cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping fetchByappointeeId_First(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping findByappointeeId_Last(
			int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Returns the last cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver mapping, or <code>null</code> if a matching cscl approver mapping could not be found
	 */
	public CsclApproverMapping fetchByappointeeId_Last(
		int appointee,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Returns the cscl approver mappings before and after the current cscl approver mapping in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver mapping
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public CsclApproverMapping[] findByappointeeId_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclApproverMapping> orderByComparator)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Removes all the cscl approver mappings where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public void removeByappointeeId(int appointee);

	/**
	 * Returns the number of cscl approver mappings where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl approver mappings
	 */
	public int countByappointeeId(int appointee);

	/**
	 * Caches the cscl approver mapping in the entity cache if it is enabled.
	 *
	 * @param csclApproverMapping the cscl approver mapping
	 */
	public void cacheResult(CsclApproverMapping csclApproverMapping);

	/**
	 * Caches the cscl approver mappings in the entity cache if it is enabled.
	 *
	 * @param csclApproverMappings the cscl approver mappings
	 */
	public void cacheResult(
		java.util.List<CsclApproverMapping> csclApproverMappings);

	/**
	 * Creates a new cscl approver mapping with the primary key. Does not add the cscl approver mapping to the database.
	 *
	 * @param id_ the primary key for the new cscl approver mapping
	 * @return the new cscl approver mapping
	 */
	public CsclApproverMapping create(long id_);

	/**
	 * Removes the cscl approver mapping with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping that was removed
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public CsclApproverMapping remove(long id_)
		throws NoSuchCsclApproverMappingException;

	public CsclApproverMapping updateImpl(
		CsclApproverMapping csclApproverMapping);

	/**
	 * Returns the cscl approver mapping with the primary key or throws a <code>NoSuchCsclApproverMappingException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping
	 * @throws NoSuchCsclApproverMappingException if a cscl approver mapping with the primary key could not be found
	 */
	public CsclApproverMapping findByPrimaryKey(long id_)
		throws NoSuchCsclApproverMappingException;

	/**
	 * Returns the cscl approver mapping with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver mapping
	 * @return the cscl approver mapping, or <code>null</code> if a cscl approver mapping with the primary key could not be found
	 */
	public CsclApproverMapping fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl approver mappings.
	 *
	 * @return the cscl approver mappings
	 */
	public java.util.List<CsclApproverMapping> findAll();

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
	public java.util.List<CsclApproverMapping> findAll(int start, int end);

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
	public java.util.List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclApproverMapping> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMapping> orderByComparator);

	/**
	 * Removes all the cscl approver mappings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl approver mappings.
	 *
	 * @return the number of cscl approver mappings
	 */
	public int countAll();

}