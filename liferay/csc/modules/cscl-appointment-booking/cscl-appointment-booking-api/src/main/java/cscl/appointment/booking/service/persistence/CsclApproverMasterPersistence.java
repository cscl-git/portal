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

import cscl.appointment.booking.exception.NoSuchCsclApproverMasterException;
import cscl.appointment.booking.model.CsclApproverMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl approver master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclApproverMasterUtil
 * @generated
 */
@ProviderType
public interface CsclApproverMasterPersistence
	extends BasePersistence<CsclApproverMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclApproverMasterUtil} to access the cscl approver master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findByisActive(Boolean isActive);

	/**
	 * Returns a range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @return the range of matching cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end);

	/**
	 * Returns an ordered range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl approver masters
	 */
	@Deprecated
	public java.util.List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl approver masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator);

	/**
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	public CsclApproverMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException;

	/**
	 * Returns the first cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	public CsclApproverMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator);

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a matching cscl approver master could not be found
	 */
	public CsclApproverMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException;

	/**
	 * Returns the last cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl approver master, or <code>null</code> if a matching cscl approver master could not be found
	 */
	public CsclApproverMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclApproverMaster> orderByComparator);

	/**
	 * Returns the cscl approver masters before and after the current cscl approver master in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl approver master
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public CsclApproverMaster[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclApproverMaster> orderByComparator)
		throws NoSuchCsclApproverMasterException;

	/**
	 * Removes all the cscl approver masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByisActive(Boolean isActive);

	/**
	 * Returns the number of cscl approver masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl approver masters
	 */
	public int countByisActive(Boolean isActive);

	/**
	 * Caches the cscl approver master in the entity cache if it is enabled.
	 *
	 * @param csclApproverMaster the cscl approver master
	 */
	public void cacheResult(CsclApproverMaster csclApproverMaster);

	/**
	 * Caches the cscl approver masters in the entity cache if it is enabled.
	 *
	 * @param csclApproverMasters the cscl approver masters
	 */
	public void cacheResult(
		java.util.List<CsclApproverMaster> csclApproverMasters);

	/**
	 * Creates a new cscl approver master with the primary key. Does not add the cscl approver master to the database.
	 *
	 * @param id_ the primary key for the new cscl approver master
	 * @return the new cscl approver master
	 */
	public CsclApproverMaster create(long id_);

	/**
	 * Removes the cscl approver master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master that was removed
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public CsclApproverMaster remove(long id_)
		throws NoSuchCsclApproverMasterException;

	public CsclApproverMaster updateImpl(CsclApproverMaster csclApproverMaster);

	/**
	 * Returns the cscl approver master with the primary key or throws a <code>NoSuchCsclApproverMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master
	 * @throws NoSuchCsclApproverMasterException if a cscl approver master with the primary key could not be found
	 */
	public CsclApproverMaster findByPrimaryKey(long id_)
		throws NoSuchCsclApproverMasterException;

	/**
	 * Returns the cscl approver master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl approver master
	 * @return the cscl approver master, or <code>null</code> if a cscl approver master with the primary key could not be found
	 */
	public CsclApproverMaster fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl approver masters.
	 *
	 * @return the cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findAll();

	/**
	 * Returns a range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @return the range of cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl approver masters
	 */
	@Deprecated
	public java.util.List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl approver masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclApproverMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl approver masters
	 * @param end the upper bound of the range of cscl approver masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl approver masters
	 */
	public java.util.List<CsclApproverMaster> findAll(
		int start, int end,
		OrderByComparator<CsclApproverMaster> orderByComparator);

	/**
	 * Removes all the cscl approver masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl approver masters.
	 *
	 * @return the number of cscl approver masters
	 */
	public int countAll();

}