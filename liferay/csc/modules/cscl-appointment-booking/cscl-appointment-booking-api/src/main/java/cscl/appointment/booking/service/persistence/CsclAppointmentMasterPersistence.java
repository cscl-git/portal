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

import cscl.appointment.booking.exception.NoSuchCsclAppointmentMasterException;
import cscl.appointment.booking.model.CsclAppointmentMaster;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl appointment master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclAppointmentMasterUtil
 * @generated
 */
@ProviderType
public interface CsclAppointmentMasterPersistence
	extends BasePersistence<CsclAppointmentMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclAppointmentMasterUtil} to access the cscl appointment master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByapprover(long approver);

	/**
	 * Returns a range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByapprover(long, int, int, OrderByComparator)}
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	public java.util.List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointment masters where approver = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param approver the approver
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByapprover(
		long approver, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByapprover_First(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the first cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByapprover_First(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByapprover_Last(
			long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the last cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByapprover_Last(
		long approver,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where approver = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param approver the approver
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster[] findByapprover_PrevAndNext(
			long id_, long approver,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Removes all the cscl appointment masters where approver = &#63; from the database.
	 *
	 * @param approver the approver
	 */
	public void removeByapprover(long approver);

	/**
	 * Returns the number of cscl appointment masters where approver = &#63;.
	 *
	 * @param approver the approver
	 * @return the number of matching cscl appointment masters
	 */
	public int countByapprover(long approver);

	/**
	 * Returns all the cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointee(int appointee);

	/**
	 * Returns a range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointee(int, int, int, OrderByComparator)}
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	public java.util.List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointment masters where appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointee(
		int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByappointee_First(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the first cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByappointee_First(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByappointee_Last(
			int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the last cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByappointee_Last(
		int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster[] findByappointee_PrevAndNext(
			long id_, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Removes all the cscl appointment masters where appointee = &#63; from the database.
	 *
	 * @param appointee the appointee
	 */
	public void removeByappointee(int appointee);

	/**
	 * Returns the number of cscl appointment masters where appointee = &#63;.
	 *
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	public int countByappointee(int appointee);

	/**
	 * Returns all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee);

	/**
	 * Returns a range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByappointeeAndStatus(int,int, int, int, OrderByComparator)}
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching cscl appointment masters
	 */
	@Deprecated
	public java.util.List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findByappointeeAndStatus(
		int status, int appointee, int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByappointeeAndStatus_First(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the first cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByappointeeAndStatus_First(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster findByappointeeAndStatus_Last(
			int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the last cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cscl appointment master, or <code>null</code> if a matching cscl appointment master could not be found
	 */
	public CsclAppointmentMaster fetchByappointeeAndStatus_Last(
		int status, int appointee,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Returns the cscl appointment masters before and after the current cscl appointment master in the ordered set where status = &#63; and appointee = &#63;.
	 *
	 * @param id_ the primary key of the current cscl appointment master
	 * @param status the status
	 * @param appointee the appointee
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster[] findByappointeeAndStatus_PrevAndNext(
			long id_, int status, int appointee,
			OrderByComparator<CsclAppointmentMaster> orderByComparator)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Removes all the cscl appointment masters where status = &#63; and appointee = &#63; from the database.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 */
	public void removeByappointeeAndStatus(int status, int appointee);

	/**
	 * Returns the number of cscl appointment masters where status = &#63; and appointee = &#63;.
	 *
	 * @param status the status
	 * @param appointee the appointee
	 * @return the number of matching cscl appointment masters
	 */
	public int countByappointeeAndStatus(int status, int appointee);

	/**
	 * Caches the cscl appointment master in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMaster the cscl appointment master
	 */
	public void cacheResult(CsclAppointmentMaster csclAppointmentMaster);

	/**
	 * Caches the cscl appointment masters in the entity cache if it is enabled.
	 *
	 * @param csclAppointmentMasters the cscl appointment masters
	 */
	public void cacheResult(
		java.util.List<CsclAppointmentMaster> csclAppointmentMasters);

	/**
	 * Creates a new cscl appointment master with the primary key. Does not add the cscl appointment master to the database.
	 *
	 * @param id_ the primary key for the new cscl appointment master
	 * @return the new cscl appointment master
	 */
	public CsclAppointmentMaster create(long id_);

	/**
	 * Removes the cscl appointment master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master that was removed
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster remove(long id_)
		throws NoSuchCsclAppointmentMasterException;

	public CsclAppointmentMaster updateImpl(
		CsclAppointmentMaster csclAppointmentMaster);

	/**
	 * Returns the cscl appointment master with the primary key or throws a <code>NoSuchCsclAppointmentMasterException</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master
	 * @throws NoSuchCsclAppointmentMasterException if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster findByPrimaryKey(long id_)
		throws NoSuchCsclAppointmentMasterException;

	/**
	 * Returns the cscl appointment master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_ the primary key of the cscl appointment master
	 * @return the cscl appointment master, or <code>null</code> if a cscl appointment master with the primary key could not be found
	 */
	public CsclAppointmentMaster fetchByPrimaryKey(long id_);

	/**
	 * Returns all the cscl appointment masters.
	 *
	 * @return the cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findAll();

	/**
	 * Returns a range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @return the range of cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl appointment masters
	 */
	@Deprecated
	public java.util.List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the cscl appointment masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclAppointmentMasterModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl appointment masters
	 * @param end the upper bound of the range of cscl appointment masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl appointment masters
	 */
	public java.util.List<CsclAppointmentMaster> findAll(
		int start, int end,
		OrderByComparator<CsclAppointmentMaster> orderByComparator);

	/**
	 * Removes all the cscl appointment masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl appointment masters.
	 *
	 * @return the number of cscl appointment masters
	 */
	public int countAll();

}