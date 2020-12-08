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

import com.cscl.polls.exception.NoSuchQuestionException;
import com.cscl.polls.model.CsclPollsQuestion;
import com.cscl.polls.model.impl.CsclPollsQuestionImpl;
import com.cscl.polls.model.impl.CsclPollsQuestionModelImpl;
import com.cscl.polls.service.persistence.CsclPollsQuestionPersistence;
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
 * The persistence implementation for the cscl polls question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CsclPollsQuestionPersistence.class)
@ProviderType
public class CsclPollsQuestionPersistenceImpl
	extends BasePersistenceImpl<CsclPollsQuestion>
	implements CsclPollsQuestionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CsclPollsQuestionUtil</code> to access the cscl polls question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CsclPollsQuestionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CsclPollsQuestionPersistenceImpl() {
		setModelClass(CsclPollsQuestion.class);

		setModelImplClass(CsclPollsQuestionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the cscl polls question in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestion the cscl polls question
	 */
	@Override
	public void cacheResult(CsclPollsQuestion csclPollsQuestion) {
		entityCache.putResult(
			entityCacheEnabled, CsclPollsQuestionImpl.class,
			csclPollsQuestion.getPrimaryKey(), csclPollsQuestion);

		csclPollsQuestion.resetOriginalValues();
	}

	/**
	 * Caches the cscl polls questions in the entity cache if it is enabled.
	 *
	 * @param csclPollsQuestions the cscl polls questions
	 */
	@Override
	public void cacheResult(List<CsclPollsQuestion> csclPollsQuestions) {
		for (CsclPollsQuestion csclPollsQuestion : csclPollsQuestions) {
			if (entityCache.getResult(
					entityCacheEnabled, CsclPollsQuestionImpl.class,
					csclPollsQuestion.getPrimaryKey()) == null) {

				cacheResult(csclPollsQuestion);
			}
			else {
				csclPollsQuestion.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cscl polls questions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CsclPollsQuestionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cscl polls question.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CsclPollsQuestion csclPollsQuestion) {
		entityCache.removeResult(
			entityCacheEnabled, CsclPollsQuestionImpl.class,
			csclPollsQuestion.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CsclPollsQuestion> csclPollsQuestions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CsclPollsQuestion csclPollsQuestion : csclPollsQuestions) {
			entityCache.removeResult(
				entityCacheEnabled, CsclPollsQuestionImpl.class,
				csclPollsQuestion.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cscl polls question with the primary key. Does not add the cscl polls question to the database.
	 *
	 * @param questionId the primary key for the new cscl polls question
	 * @return the new cscl polls question
	 */
	@Override
	public CsclPollsQuestion create(long questionId) {
		CsclPollsQuestion csclPollsQuestion = new CsclPollsQuestionImpl();

		csclPollsQuestion.setNew(true);
		csclPollsQuestion.setPrimaryKey(questionId);

		return csclPollsQuestion;
	}

	/**
	 * Removes the cscl polls question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question that was removed
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	@Override
	public CsclPollsQuestion remove(long questionId)
		throws NoSuchQuestionException {

		return remove((Serializable)questionId);
	}

	/**
	 * Removes the cscl polls question with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cscl polls question
	 * @return the cscl polls question that was removed
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	@Override
	public CsclPollsQuestion remove(Serializable primaryKey)
		throws NoSuchQuestionException {

		Session session = null;

		try {
			session = openSession();

			CsclPollsQuestion csclPollsQuestion =
				(CsclPollsQuestion)session.get(
					CsclPollsQuestionImpl.class, primaryKey);

			if (csclPollsQuestion == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuestionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(csclPollsQuestion);
		}
		catch (NoSuchQuestionException nsee) {
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
	protected CsclPollsQuestion removeImpl(
		CsclPollsQuestion csclPollsQuestion) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(csclPollsQuestion)) {
				csclPollsQuestion = (CsclPollsQuestion)session.get(
					CsclPollsQuestionImpl.class,
					csclPollsQuestion.getPrimaryKeyObj());
			}

			if (csclPollsQuestion != null) {
				session.delete(csclPollsQuestion);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (csclPollsQuestion != null) {
			clearCache(csclPollsQuestion);
		}

		return csclPollsQuestion;
	}

	@Override
	public CsclPollsQuestion updateImpl(CsclPollsQuestion csclPollsQuestion) {
		boolean isNew = csclPollsQuestion.isNew();

		long userId = GetterUtil.getLong(PrincipalThreadLocal.getName());

		if (userId > 0) {
			long companyId = 0;

			long groupId = 0;

			long questionId = 0;

			if (!isNew) {
				questionId = csclPollsQuestion.getPrimaryKey();
			}

			try {
				csclPollsQuestion.setTitle(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						CsclPollsQuestion.class.getName(), questionId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						csclPollsQuestion.getTitle(), null));

				csclPollsQuestion.setQuestion(
					SanitizerUtil.sanitize(
						companyId, groupId, userId,
						CsclPollsQuestion.class.getName(), questionId,
						ContentTypes.TEXT_PLAIN, Sanitizer.MODE_ALL,
						csclPollsQuestion.getQuestion(), null));
			}
			catch (SanitizerException se) {
				throw new SystemException(se);
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (csclPollsQuestion.isNew()) {
				session.save(csclPollsQuestion);

				csclPollsQuestion.setNew(false);
			}
			else {
				csclPollsQuestion = (CsclPollsQuestion)session.merge(
					csclPollsQuestion);
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
			entityCacheEnabled, CsclPollsQuestionImpl.class,
			csclPollsQuestion.getPrimaryKey(), csclPollsQuestion, false);

		csclPollsQuestion.resetOriginalValues();

		return csclPollsQuestion;
	}

	/**
	 * Returns the cscl polls question with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cscl polls question
	 * @return the cscl polls question
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	@Override
	public CsclPollsQuestion findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuestionException {

		CsclPollsQuestion csclPollsQuestion = fetchByPrimaryKey(primaryKey);

		if (csclPollsQuestion == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuestionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return csclPollsQuestion;
	}

	/**
	 * Returns the cscl polls question with the primary key or throws a <code>NoSuchQuestionException</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question
	 * @throws NoSuchQuestionException if a cscl polls question with the primary key could not be found
	 */
	@Override
	public CsclPollsQuestion findByPrimaryKey(long questionId)
		throws NoSuchQuestionException {

		return findByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns the cscl polls question with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param questionId the primary key of the cscl polls question
	 * @return the cscl polls question, or <code>null</code> if a cscl polls question with the primary key could not be found
	 */
	@Override
	public CsclPollsQuestion fetchByPrimaryKey(long questionId) {
		return fetchByPrimaryKey((Serializable)questionId);
	}

	/**
	 * Returns all the cscl polls questions.
	 *
	 * @return the cscl polls questions
	 */
	@Override
	public List<CsclPollsQuestion> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @return the range of cscl polls questions
	 */
	@Override
	public List<CsclPollsQuestion> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cscl polls questions
	 */
	@Deprecated
	@Override
	public List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cscl polls questions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>CsclPollsQuestionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of cscl polls questions
	 * @param end the upper bound of the range of cscl polls questions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cscl polls questions
	 */
	@Override
	public List<CsclPollsQuestion> findAll(
		int start, int end,
		OrderByComparator<CsclPollsQuestion> orderByComparator) {

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

		List<CsclPollsQuestion> list =
			(List<CsclPollsQuestion>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CSCLPOLLSQUESTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CSCLPOLLSQUESTION;

				if (pagination) {
					sql = sql.concat(CsclPollsQuestionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CsclPollsQuestion>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CsclPollsQuestion>)QueryUtil.list(
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
	 * Removes all the cscl polls questions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CsclPollsQuestion csclPollsQuestion : findAll()) {
			remove(csclPollsQuestion);
		}
	}

	/**
	 * Returns the number of cscl polls questions.
	 *
	 * @return the number of cscl polls questions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CSCLPOLLSQUESTION);

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
		return "questionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CSCLPOLLSQUESTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CsclPollsQuestionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cscl polls question persistence.
	 */
	@Activate
	public void activate() {
		CsclPollsQuestionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		CsclPollsQuestionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, CsclPollsQuestionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CsclPollsQuestionImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.cscl.polls.model.CsclPollsQuestion"),
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

	private static final String _SQL_SELECT_CSCLPOLLSQUESTION =
		"SELECT csclPollsQuestion FROM CsclPollsQuestion csclPollsQuestion";

	private static final String _SQL_COUNT_CSCLPOLLSQUESTION =
		"SELECT COUNT(csclPollsQuestion) FROM CsclPollsQuestion csclPollsQuestion";

	private static final String _ORDER_BY_ENTITY_ALIAS = "csclPollsQuestion.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CsclPollsQuestion exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CsclPollsQuestionPersistenceImpl.class);

	static {
		try {
			Class.forName(CsclPollsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}