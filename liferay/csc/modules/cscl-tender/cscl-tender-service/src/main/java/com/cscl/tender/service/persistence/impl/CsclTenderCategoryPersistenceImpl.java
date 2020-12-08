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

package com.cscl.tender.service.persistence.impl;

import com.cscl.tender.exception.NoSuchCategoryException;
import com.cscl.tender.model.CsclTenderCategory;
import com.cscl.tender.model.impl.CsclTenderCategoryImpl;
import com.cscl.tender.model.impl.CsclTenderCategoryModelImpl;
import com.cscl.tender.service.persistence.CsclTenderCategoryPersistence;
import com.cscl.tender.service.persistence.impl.constants.CsclTenderPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.sanitizer.Sanitizer;
import com.liferay.portal.kernel.sanitizer.SanitizerException;
import com.liferay.portal.kernel.sanitizer.SanitizerUtil;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the cscl tender category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclTenderCategoryPersistence.class)
@ProviderType
public class CsclTenderCategoryPersistenceImpl
	extends BasePersistenceImpl<CsclTenderCategory>
	implements CsclTenderCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclTenderCategoryUtil</code> to access the cscl tender category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclTenderCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CsclTenderCategoryPersistenceImpl() {
		setModelClass(CsclTenderCategory.class);

		setModelImplClass(CsclTenderCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl tender category in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategory the cscl tender category
	 */
	@Override
	public void cacheResult(CsclTenderCategory csclTenderCategory) {
		entityCache.putResult(
			entityCacheEnabled, CsclTenderCategoryImpl.class,
			csclTenderCategory.getPrimaryKey(), csclTenderCategory);

		csclTenderCategory.resetOriginalValues();
	}

	/**
	 * Caches the cscl tender categories in the entity cache if it is enabled.
	 *
	 * @param csclTenderCategories the cscl tender categories
	 */
	@Override
	public void cacheResult(List<CsclTenderCategory> csclTenderCategories) {
		for (CsclTenderCategory csclTenderCategory : csclTenderCategories) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclTenderCategoryImpl.class,
					csclTenderCategory.getPrimaryKey()) == null) {

				cacheResult(csclTenderCategory);
			}
			else {
				csclTenderCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl tender categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclTenderCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl tender category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclTenderCategory csclTenderCategory) {
		entityCache.removeResult(
			entityCacheEnabled, CsclTenderCategoryImpl.class,
			csclTenderCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclTenderCategory> csclTenderCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclTenderCategory csclTenderCategory : csclTenderCategories) {
			entityCache.removeResult(
				entityCacheEnabled, CsclTenderCategoryImpl.class,
				csclTenderCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl tender category with the primary key. Does not add the cscl tender category to the database.
	 *
	 * @param tenderCatId the primary key for the new cscl tender category
	 * @return the new cscl tender category
	 */
	@Override
	public CsclTenderCategory create(long tenderCatId) {
		CsclTenderCategory csclTenderCategory = new CsclTenderCategoryImpl();

		csclTenderCategory.setNew(true);
		csclTenderCategory.setPrimaryKey(tenderCatId);

		return csclTenderCategory;
	}

	/**
	 * Removes the cscl tender category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category that was removed
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public CsclTenderCategory remove(long tenderCatId)
		throws NoSuchCategoryException {

		return remove((Serializable)tenderCatId);
	}

	/**
	 * Removes the cscl tender category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl tender category
	 * @return the cscl tender category that was removed
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public CsclTenderCategory remove(Serializable primaryKey)
		throws NoSuchCategoryException {

		Session session = null;

		try {
			session = openSession();

			CsclTenderCategory csclTenderCategory =
				(CsclTenderCategory)session.get(
					CsclTenderCategoryImpl.class, primaryKey);

			if (csclTenderCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclTenderCategory);
		}
		catch (NoSuchCategoryException nsee) {
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
	protected CsclTenderCategory removeImpl(
		CsclTenderCategory csclTenderCategory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclTenderCategory)) {
				csclTenderCategory = (CsclTenderCategory)session.get(
					CsclTenderCategoryImpl.class,
					csclTenderCategory.getPrimaryKeyObj());
			}

			if (csclTenderCategory != null) {
				session.delete(csclTenderCategory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclTenderCategory != null) {
			clearCache(csclTenderCategory);
		}

		return csclTenderCategory;
	}

	@Override
	public CsclTenderCategory updateImpl(
		CsclTenderCategory csclTenderCategory) {

		boolean isNew = csclTenderCategory.isNew();

		long userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

		if (userId > 0) {
			long companyId = 0;

			long groupId = 0;

			long tenderCatId = 0;

			if (!isNew) {
				tenderCatId = csclTenderCategory.getPrimaryKey();
			}

			try {
				csclTenderCategory.setCategory(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						CsclTenderCategory.class.getName(), tenderCatId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						csclTenderCategory.getCategory(), null));
			}
			catch (SanitizerException se) {
				throw new SystemException(se);
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (csclTenderCategory.isNew()) {
				session.save(csclTenderCategory);

				csclTenderCategory.setNew(false);
			}
			else {
				csclTenderCategory = (CsclTenderCategory)session.merge(
					csclTenderCategory);
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
			entityCacheEnabled, CsclTenderCategoryImpl.class,
			csclTenderCategory.getPrimaryKey(), csclTenderCategory, false);

		csclTenderCategory.resetOriginalValues();

		return csclTenderCategory;
	}

	/**
	 * Returns the cscl tender category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl tender category
	 * @return the cscl tender category
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public CsclTenderCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCategoryException {

		CsclTenderCategory csclTenderCategory = fetchByPrimaryKey(primaryKey);

		if (csclTenderCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclTenderCategory;
	}

	/**
	 * Returns the cscl tender category with the primary key or throws a <code>NoSuchCategoryException</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category
	 * @throws NoSuchCategoryException if a cscl tender category with the primary key could not be found
	 */
	@Override
	public CsclTenderCategory findByPrimaryKey(long tenderCatId)
		throws NoSuchCategoryException {

		return findByPrimaryKey((Serializable)tenderCatId);
	}

	/**
	 * Returns the cscl tender category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tenderCatId the primary key of the cscl tender category
	 * @return the cscl tender category, or <code>null</code> if a cscl tender category with the primary key could not be found
	 */
	@Override
	public CsclTenderCategory fetchByPrimaryKey(long tenderCatId) {
		return fetchByPrimaryKey((Serializable)tenderCatId);
	}

	/**
	 * Returns all the cscl tender categories.
	 *
	 * @return the cscl tender categories
	 */
	@Override
	public List<CsclTenderCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @return the range of cscl tender categories
	 */
	@Override
	public List<CsclTenderCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl tender categories
	 */
	@Deprecated
	@Override
	public List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl tender categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclTenderCategoryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl tender categories
	 * @param end the upper bound of the range of cscl tender categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl tender categories
	 */
	@Override
	public List<CsclTenderCategory> findAll(
		int start, int end,
		OrderByComparator<CsclTenderCategory> orderByComparator) {

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

		List<CsclTenderCategory> list =
			(List<CsclTenderCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLTENDERCATEGORY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLTENDERCATEGORY;

				if (pagination) {
					sql = sql.concat(CsclTenderCategoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclTenderCategory>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclTenderCategory>)QueryUtil.list(
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
	 * Removes all the cscl tender categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclTenderCategory csclTenderCategory : findAll()) {
			remove(csclTenderCategory);
		}
	}

	/**
	 * Returns the number of cscl tender categories.
	 *
	 * @return the number of cscl tender categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLTENDERCATEGORY);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "tenderCatId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLTENDERCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclTenderCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl tender category persistence.
	 */
	@Activate
	public void activate() {
		CsclTenderCategoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclTenderCategoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclTenderCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			CsclTenderCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclTenderCategoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.tender.model.CsclTenderCategory"),
			true);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclTenderPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLTENDERCATEGORY =
		"SELECT csclTenderCategory FROM CsclTenderCategory csclTenderCategory";

	private static final String _SQL_COUNT_CSCLTENDERCATEGORY =
		"SELECT COUNT(csclTenderCategory) FROM CsclTenderCategory csclTenderCategory";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclTenderCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclTenderCategory exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclTenderCategoryPersistenceImpl.class);

	static {
		try {
			Class.forName(CsclTenderPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}