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

import com.cscl.online.rti.payment.exception.NoSuchDetailsException;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the cscl rti payment details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @see CsclRtiPaymentDetailsUtil
 * @generated
 */
@ProviderType
public interface CsclRtiPaymentDetailsPersistence
	extends BasePersistence<CsclRtiPaymentDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CsclRtiPaymentDetailsUtil} to access the cscl rti payment details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the cscl rti payment details in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 */
	public void cacheResult(CsclRtiPaymentDetails csclRtiPaymentDetails);

	/**
	 * Caches the cscl rti payment detailses in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetailses the cscl rti payment detailses
	 */
	public void cacheResult(
		java.util.List<CsclRtiPaymentDetails> csclRtiPaymentDetailses);

	/**
	 * Creates a new cscl rti payment details with the primary key. Does not add the cscl rti payment details to the database.
	 *
	 * @param id the primary key for the new cscl rti payment details
	 * @return the new cscl rti payment details
	 */
	public CsclRtiPaymentDetails create(long id);

	/**
	 * Removes the cscl rti payment details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	public CsclRtiPaymentDetails remove(long id) throws NoSuchDetailsException;

	public CsclRtiPaymentDetails updateImpl(
		CsclRtiPaymentDetails csclRtiPaymentDetails);

	/**
	 * Returns the cscl rti payment details with the primary key or throws a <code>NoSuchDetailsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	public CsclRtiPaymentDetails findByPrimaryKey(long id)
		throws NoSuchDetailsException;

	/**
	 * Returns the cscl rti payment details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details, or <code>null</code> if a cscl rti payment details with the primary key could not be found
	 */
	public CsclRtiPaymentDetails fetchByPrimaryKey(long id);

	/**
	 * Returns all the cscl rti payment detailses.
	 *
	 * @return the cscl rti payment detailses
	 */
	public java.util.List<CsclRtiPaymentDetails> findAll();

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
	public java.util.List<CsclRtiPaymentDetails> findAll(int start, int end);

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
	public java.util.List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator);

	/**
	 * Removes all the cscl rti payment detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of cscl rti payment detailses.
	 *
	 * @return the number of cscl rti payment detailses
	 */
	public int countAll();

}