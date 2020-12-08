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

package com.cscl.online.rti.payment.service.persistence.impl;

import com.cscl.online.rti.payment.exception.NoSuchDetailsException;
import com.cscl.online.rti.payment.model.CsclRtiPaymentDetails;
import com.cscl.online.rti.payment.model.impl.CsclRtiPaymentDetailsImpl;
import com.cscl.online.rti.payment.model.impl.CsclRtiPaymentDetailsModelImpl;
import com.cscl.online.rti.payment.service.persistence.CsclRtiPaymentDetailsPersistence;
import com.cscl.online.rti.payment.service.persistence.impl.constants.CsclRtiPaymentPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl rti payment details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author @rnab
 * @generated
 */
@Component(service = CsclRtiPaymentDetailsPersistence.class)
@ProviderType
public class CsclRtiPaymentDetailsPersistenceImpl
	extends BasePersistenceImpl<CsclRtiPaymentDetails>
	implements CsclRtiPaymentDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclRtiPaymentDetailsUtil</code> to access the cscl rti payment details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclRtiPaymentDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CsclRtiPaymentDetailsPersistenceImpl() {
		setModelClass(CsclRtiPaymentDetails.class);

		setModelImplClass(CsclRtiPaymentDetailsImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the cscl rti payment details in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetails the cscl rti payment details
	 */
	@Override
	public void cacheResult(CsclRtiPaymentDetails csclRtiPaymentDetails) {
		entityCache.putResult(
			entityCacheEnabled, CsclRtiPaymentDetailsImpl.class,
			csclRtiPaymentDetails.getPrimaryKey(), csclRtiPaymentDetails);

		csclRtiPaymentDetails.resetOriginalValues();
	}

	/**
	 * Caches the cscl rti payment detailses in the entity cache if it is enabled.
	 *
	 * @param csclRtiPaymentDetailses the cscl rti payment detailses
	 */
	@Override
	public void cacheResult(
		List<CsclRtiPaymentDetails> csclRtiPaymentDetailses) {

		for (CsclRtiPaymentDetails csclRtiPaymentDetails :
				csclRtiPaymentDetailses) {

			if (entityCache.getResult(
					entityCacheEnabled, CsclRtiPaymentDetailsImpl.class,
					csclRtiPaymentDetails.getPrimaryKey()) == null) {

				cacheResult(csclRtiPaymentDetails);
			}
			else {
				csclRtiPaymentDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl rti payment detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclRtiPaymentDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl rti payment details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclRtiPaymentDetails csclRtiPaymentDetails) {
		entityCache.removeResult(
			entityCacheEnabled, CsclRtiPaymentDetailsImpl.class,
			csclRtiPaymentDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CsclRtiPaymentDetails> csclRtiPaymentDetailses) {

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclRtiPaymentDetails csclRtiPaymentDetails :
				csclRtiPaymentDetailses) {

			entityCache.removeResult(
				entityCacheEnabled, CsclRtiPaymentDetailsImpl.class,
				csclRtiPaymentDetails.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl rti payment details with the primary key. Does not add the cscl rti payment details to the database.
	 *
	 * @param id the primary key for the new cscl rti payment details
	 * @return the new cscl rti payment details
	 */
	@Override
	public CsclRtiPaymentDetails create(long id) {
		CsclRtiPaymentDetails csclRtiPaymentDetails =
			new CsclRtiPaymentDetailsImpl();

		csclRtiPaymentDetails.setNew(true);
		csclRtiPaymentDetails.setPrimaryKey(id);

		return csclRtiPaymentDetails;
	}

	/**
	 * Removes the cscl rti payment details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public CsclRtiPaymentDetails remove(long id) throws NoSuchDetailsException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the cscl rti payment details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl rti payment details
	 * @return the cscl rti payment details that was removed
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public CsclRtiPaymentDetails remove(Serializable primaryKey)
		throws NoSuchDetailsException {

		Session session = null;

		try {
			session = openSession();

			CsclRtiPaymentDetails csclRtiPaymentDetails =
				(CsclRtiPaymentDetails)session.get(
					CsclRtiPaymentDetailsImpl.class, primaryKey);

			if (csclRtiPaymentDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclRtiPaymentDetails);
		}
		catch (NoSuchDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CsclRtiPaymentDetails removeImpl(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclRtiPaymentDetails)) {
				csclRtiPaymentDetails = (CsclRtiPaymentDetails)session.get(
					CsclRtiPaymentDetailsImpl.class,
					csclRtiPaymentDetails.getPrimaryKeyObj());
			}

			if (csclRtiPaymentDetails != null) {
				session.delete(csclRtiPaymentDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclRtiPaymentDetails != null) {
			clearCache(csclRtiPaymentDetails);
		}

		return csclRtiPaymentDetails;
	}

	@Override
	public CsclRtiPaymentDetails updateImpl(
		CsclRtiPaymentDetails csclRtiPaymentDetails) {

		boolean isNew = csclRtiPaymentDetails.isNew();

		Session session = null;

		try {
			session = openSession();

			if (csclRtiPaymentDetails.isNew()) {
				session.save(csclRtiPaymentDetails);

				csclRtiPaymentDetails.setNew(false);
			}
			else {
				csclRtiPaymentDetails = (CsclRtiPaymentDetails)session.merge(
					csclRtiPaymentDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, CsclRtiPaymentDetailsImpl.class,
			csclRtiPaymentDetails.getPrimaryKey(), csclRtiPaymentDetails,
			false);

		csclRtiPaymentDetails.resetOriginalValues();

		return csclRtiPaymentDetails;
	}

	/**
	 * Returns the cscl rti payment details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl rti payment details
	 * @return the cscl rti payment details
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public CsclRtiPaymentDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDetailsException {

		CsclRtiPaymentDetails csclRtiPaymentDetails = fetchByPrimaryKey(
			primaryKey);

		if (csclRtiPaymentDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclRtiPaymentDetails;
	}

	/**
	 * Returns the cscl rti payment details with the primary key or throws a <code>NoSuchDetailsException</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details
	 * @throws NoSuchDetailsException if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public CsclRtiPaymentDetails findByPrimaryKey(long id)
		throws NoSuchDetailsException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the cscl rti payment details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the cscl rti payment details
	 * @return the cscl rti payment details, or <code>null</code> if a cscl rti payment details with the primary key could not be found
	 */
	@Override
	public CsclRtiPaymentDetails fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the cscl rti payment detailses.
	 *
	 * @return the cscl rti payment detailses
	 */
	@Override
	public List<CsclRtiPaymentDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CsclRtiPaymentDetails> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<CsclRtiPaymentDetails> findAll(
		int start, int end,
		OrderByComparator<CsclRtiPaymentDetails> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CsclRtiPaymentDetails> list =
			(List<CsclRtiPaymentDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLRTIPAYMENTDETAILS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLRTIPAYMENTDETAILS;

				if (pagination) {
					sql = sql.concat(
						CsclRtiPaymentDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclRtiPaymentDetails>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclRtiPaymentDetails>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cscl rti payment detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclRtiPaymentDetails csclRtiPaymentDetails : findAll()) {
			remove(csclRtiPaymentDetails);
		}
	}

	/**
	 * Returns the number of cscl rti payment detailses.
	 *
	 * @return the number of cscl rti payment detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLRTIPAYMENTDETAILS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLRTIPAYMENTDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclRtiPaymentDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl rti payment details persistence.
	 */
	@Activate
	public void activate() {
		CsclRtiPaymentDetailsModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		CsclRtiPaymentDetailsModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclRtiPaymentDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclRtiPaymentDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclRtiPaymentDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclRtiPaymentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.online.rti.payment.model.CsclRtiPaymentDetails"),
			true);
	}

	@Override
	@Reference(
		target = CsclRtiPaymentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclRtiPaymentPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CSCLRTIPAYMENTDETAILS =
		"SELECT csclRtiPaymentDetails FROM CsclRtiPaymentDetails csclRtiPaymentDetails";

	private static final String _SQL_COUNT_CSCLRTIPAYMENTDETAILS =
		"SELECT COUNT(csclRtiPaymentDetails) FROM CsclRtiPaymentDetails csclRtiPaymentDetails";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"csclRtiPaymentDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclRtiPaymentDetails exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclRtiPaymentDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	static {
		try {
			Class.forName(CsclRtiPaymentPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}