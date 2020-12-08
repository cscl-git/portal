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

package com.cscl.polls.service.persistence.impl;

import com.cscl.polls.exception.NoSuchChoiceException;
import com.cscl.polls.model.CsclPollsChoice;
import com.cscl.polls.model.impl.CsclPollsChoiceImpl;
import com.cscl.polls.model.impl.CsclPollsChoiceModelImpl;
import com.cscl.polls.service.persistence.CsclPollsChoicePersistence;
import com.cscl.polls.service.persistence.impl.constants.CsclPollsPersistenceConstants;

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
 * The persistence implementation for the cscl polls choice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclPollsChoicePersistence.class)
@ProviderType
public class CsclPollsChoicePersistenceImpl
	extends BasePersistenceImpl<CsclPollsChoice>
	implements CsclPollsChoicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclPollsChoiceUtil</code> to access the cscl polls choice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclPollsChoiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CsclPollsChoicePersistenceImpl() {
		setModelClass(CsclPollsChoice.class);

		setModelImplClass(CsclPollsChoiceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl polls choice in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoice the cscl polls choice
	 */
	@Override
	public void cacheResult(CsclPollsChoice csclPollsChoice) {
		entityCache.putResult(
			entityCacheEnabled, CsclPollsChoiceImpl.class,
			csclPollsChoice.getPrimaryKey(), csclPollsChoice);

		csclPollsChoice.resetOriginalValues();
	}

	/**
	 * Caches the cscl polls choices in the entity cache if it is enabled.
	 *
	 * @param csclPollsChoices the cscl polls choices
	 */
	@Override
	public void cacheResult(List<CsclPollsChoice> csclPollsChoices) {
		for (CsclPollsChoice csclPollsChoice : csclPollsChoices) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclPollsChoiceImpl.class,
					csclPollsChoice.getPrimaryKey()) == null) {

				cacheResult(csclPollsChoice);
			}
			else {
				csclPollsChoice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl polls choices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclPollsChoiceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl polls choice.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclPollsChoice csclPollsChoice) {
		entityCache.removeResult(
			entityCacheEnabled, CsclPollsChoiceImpl.class,
			csclPollsChoice.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclPollsChoice> csclPollsChoices) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclPollsChoice csclPollsChoice : csclPollsChoices) {
			entityCache.removeResult(
				entityCacheEnabled, CsclPollsChoiceImpl.class,
				csclPollsChoice.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl polls choice with the primary key. Does not add the cscl polls choice to the database.
	 *
	 * @param choiceId the primary key for the new cscl polls choice
	 * @return the new cscl polls choice
	 */
	@Override
	public CsclPollsChoice create(long choiceId) {
		CsclPollsChoice csclPollsChoice = new CsclPollsChoiceImpl();

		csclPollsChoice.setNew(true);
		csclPollsChoice.setPrimaryKey(choiceId);

		return csclPollsChoice;
	}

	/**
	 * Removes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public CsclPollsChoice remove(long choiceId) throws NoSuchChoiceException {
		return remove((Serializable)choiceId);
	}

	/**
	 * Removes the cscl polls choice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl polls choice
	 * @return the cscl polls choice that was removed
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public CsclPollsChoice remove(Serializable primaryKey)
		throws NoSuchChoiceException {

		Session session = null;

		try {
			session = openSession();

			CsclPollsChoice csclPollsChoice = (CsclPollsChoice)session.get(
				CsclPollsChoiceImpl.class, primaryKey);

			if (csclPollsChoice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChoiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclPollsChoice);
		}
		catch (NoSuchChoiceException nsee) {
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
	protected CsclPollsChoice removeImpl(CsclPollsChoice csclPollsChoice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclPollsChoice)) {
				csclPollsChoice = (CsclPollsChoice)session.get(
					CsclPollsChoiceImpl.class,
					csclPollsChoice.getPrimaryKeyObj());
			}

			if (csclPollsChoice != null) {
				session.delete(csclPollsChoice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclPollsChoice != null) {
			clearCache(csclPollsChoice);
		}

		return csclPollsChoice;
	}

	@Override
	public CsclPollsChoice updateImpl(CsclPollsChoice csclPollsChoice) {
		boolean isNew = csclPollsChoice.isNew();

		Session session = null;

		try {
			session = openSession();

			if (csclPollsChoice.isNew()) {
				session.save(csclPollsChoice);

				csclPollsChoice.setNew(false);
			}
			else {
				csclPollsChoice = (CsclPollsChoice)session.merge(
					csclPollsChoice);
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
			entityCacheEnabled, CsclPollsChoiceImpl.class,
			csclPollsChoice.getPrimaryKey(), csclPollsChoice, false);

		csclPollsChoice.resetOriginalValues();

		return csclPollsChoice;
	}

	/**
	 * Returns the cscl polls choice with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public CsclPollsChoice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChoiceException {

		CsclPollsChoice csclPollsChoice = fetchByPrimaryKey(primaryKey);

		if (csclPollsChoice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChoiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclPollsChoice;
	}

	/**
	 * Returns the cscl polls choice with the primary key or throws a <code>NoSuchChoiceException</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice
	 * @throws NoSuchChoiceException if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public CsclPollsChoice findByPrimaryKey(long choiceId)
		throws NoSuchChoiceException {

		return findByPrimaryKey((Serializable)choiceId);
	}

	/**
	 * Returns the cscl polls choice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param choiceId the primary key of the cscl polls choice
	 * @return the cscl polls choice, or <code>null</code> if a cscl polls choice with the primary key could not be found
	 */
	@Override
	public CsclPollsChoice fetchByPrimaryKey(long choiceId) {
		return fetchByPrimaryKey((Serializable)choiceId);
	}

	/**
	 * Returns all the cscl polls choices.
	 *
	 * @return the cscl polls choices
	 */
	@Override
	public List<CsclPollsChoice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @return the range of cscl polls choices
	 */
	@Override
	public List<CsclPollsChoice> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl polls choices
	 */
	@Deprecated
	@Override
	public List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls choices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsChoiceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls choices
	 * @param end the upper bound of the range of cscl polls choices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl polls choices
	 */
	@Override
	public List<CsclPollsChoice> findAll(
		int start, int end,
		OrderByComparator<CsclPollsChoice> orderByComparator) {

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

		List<CsclPollsChoice> list =
			(List<CsclPollsChoice>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLPOLLSCHOICE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLPOLLSCHOICE;

				if (pagination) {
					sql = sql.concat(CsclPollsChoiceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclPollsChoice>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsChoice>)QueryUtil.list(
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
	 * Removes all the cscl polls choices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclPollsChoice csclPollsChoice : findAll()) {
			remove(csclPollsChoice);
		}
	}

	/**
	 * Returns the number of cscl polls choices.
	 *
	 * @return the number of cscl polls choices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLPOLLSCHOICE);

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
		return "choiceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLPOLLSCHOICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclPollsChoiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl polls choice persistence.
	 */
	@Activate
	public void activate() {
		CsclPollsChoiceModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclPollsChoiceModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsChoiceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsChoiceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclPollsChoiceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.cscl.polls.model.CsclPollsChoice"),
			true);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CsclPollsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_CSCLPOLLSCHOICE =
		"SELECT csclPollsChoice FROM CsclPollsChoice csclPollsChoice";

	private static final String _SQL_COUNT_CSCLPOLLSCHOICE =
		"SELECT COUNT(csclPollsChoice) FROM CsclPollsChoice csclPollsChoice";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclPollsChoice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclPollsChoice exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclPollsChoicePersistenceImpl.class);

	static {
		try {
			Class.forName(CsclPollsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}