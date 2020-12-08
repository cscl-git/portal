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

import cscl.appointment.booking.exception.NoSuchCsclAppointeeMasterException;
import cscl.appointment.booking.model.CsclAppointeeMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl appointee master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclAppointeeMasterUtil
 * @generated
 */
@ProviderType
public interface CsclAppointeeMasterPersistence
	extends BasePersistence<CsclAppointeeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclAppointeeMasterUtil} to access the cscl appointee master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl appointee masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the matching cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findByisActive(Boolean isActive);

	/**
	 * Returns a range of all the cscl appointee masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @return the range of matching cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findByisActive(
		Boolean isActive, int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointee masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByisActive(Boolean, int, int, OrderByComparator)}
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointee masters
	 */
	@Deprecated
	public java.util.List<CsclAppointeeMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAppointeeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointee masters where isActive = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param isActive the is active
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findByisActive(
		Boolean isActive, int start, int end,
		OrderByComparator<CsclAppointeeMaster> orderByComparator);

	/**
	 * Returns the first cscl appointee master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointee master
	 * @throws NoSuchCsclAppointeeMasterException if a matching cscl appointee master could not be found
	 */
	public CsclAppointeeMaster findByisActive_First(
			Boolean isActive,
			OrderByComparator<CsclAppointeeMaster> orderByComparator)
		throws NoSuchCsclAppointeeMasterException;

	/**
	 * Returns the first cscl appointee master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointee master, or <code>null</code> if a matching cscl appointee master could not be found
	 */
	public CsclAppointeeMaster fetchByisActive_First(
		Boolean isActive,
		OrderByComparator<CsclAppointeeMaster> orderByComparator);

	/**
	 * Returns the last cscl appointee master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointee master
	 * @throws NoSuchCsclAppointeeMasterException if a matching cscl appointee master could not be found
	 */
	public CsclAppointeeMaster findByisActive_Last(
			Boolean isActive,
			OrderByComparator<CsclAppointeeMaster> orderByComparator)
		throws NoSuchCsclAppointeeMasterException;

	/**
	 * Returns the last cscl appointee master in the ordered set where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointee master, or <code>null</code> if a matching cscl appointee master could not be found
	 */
	public CsclAppointeeMaster fetchByisActive_Last(
		Boolean isActive,
		OrderByComparator<CsclAppointeeMaster> orderByComparator);

	/**
	 * Returns the cscl appointee masters before and after the current cscl appointee master in the ordered set where isActive = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointee master
	 * @param isActive the is active
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointee master
	 * @throws NoSuchCsclAppointeeMasterException if a cscl appointee master with the primary key could not be found
	 */
	public CsclAppointeeMaster[] findByisActive_PrevAndNext(
			long id_, Boolean isActive,
			OrderByComparator<CsclAppointeeMaster> orderByComparator)
		throws NoSuchCsclAppointeeMasterException;

	/**
	 * Removes all the cscl appointee masters where isActive = &#63; from the database.
	 *
	 * @param isActive the is active
	 */
	public void removeByisActive(Boolean isActive);

	/**
	 * Returns the number of cscl appointee masters where isActive = &#63;.
	 *
	 * @param isActive the is active
	 * @return the number of matching cscl appointee masters
	 */
	public int countByisActive(Boolean isActive);

	/**
	 * Caches the cscl appointee master in the entity cache if it is enabled.
	 *
	 * @param csclAppointeeMaster the cscl appointee master
	 */
	public void cacheResult(CsclAppointeeMaster csclAppointeeMaster);

	/**
	 * Caches the cscl appointee masters in the entity cache if it is enabled.
	 *
	 * @param csclAppointeeMasters the cscl appointee masters
	 */
	public void cacheResult(
		java.util.List<CsclAppointeeMaster> csclAppointeeMasters);

	/**
	 * Creates a new cscl appointee master with the primary key. Does not add the cscl appointee master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointee master
	 * @return the new cscl appointee master
	 */
	public CsclAppointeeMaster create(long id_);

	/**
	 * Removes the cscl appointee master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointee master
	 * @return the cscl appointee master that was removed
	 * @throws NoSuchCsclAppointeeMasterException if a cscl appointee master with the primary key could not be found
	 */
	public CsclAppointeeMaster remove(long id_)
		throws NoSuchCsclAppointeeMasterException;

	public CsclAppointeeMaster updateImpl(
		CsclAppointeeMaster csclAppointeeMaster);

	/**
	 * Returns the cscl appointee master with the primary key or throws a <code>NoSuchCsclAppointeeMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointee master
	 * @return the cscl appointee master
	 * @throws NoSuchCsclAppointeeMasterException if a cscl appointee master with the primary key could not be found
	 */
	public CsclAppointeeMaster findByPrimaryKey(long id_)
		throws NoSuchCsclAppointeeMasterException;

	/**
	 * Returns the cscl appointee master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointee master
	 * @return the cscl appointee master, or <code>null</code> if a cscl appointee master with the primary key could not be found
	 */
	public CsclAppointeeMaster fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl appointee masters.
	 *
	 * @return the cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findAll();

	/**
	 * Returns a range of all the cscl appointee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @return the range of cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointee masters
	 */
	@Deprecated
	public java.util.List<CsclAppointeeMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointeeMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointee masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointeeMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointee masters
	 * @param end the upper bound of the range of cscl appointee masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointee masters
	 */
	public java.util.List<CsclAppointeeMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointeeMaster> orderByComparator);

	/**
	 * Removes all the cscl appointee masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl appointee masters.
	 *
	 * @return the number of cscl appointee masters
	 */
	public int countAll();

}