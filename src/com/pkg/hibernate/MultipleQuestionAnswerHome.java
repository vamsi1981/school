package com.pkg.hibernate;

// Generated 24 Oct, 2013 5:01:50 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class MultipleQuestionAnswer.
 * @see com.pkg.hibernate.MultipleQuestionAnswer
 * @author Hibernate Tools
 */
public class MultipleQuestionAnswerHome {

	private static final Log log = LogFactory
			.getLog(MultipleQuestionAnswerHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext()
					.lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(MultipleQuestionAnswer transientInstance) {
		log.debug("persisting MultipleQuestionAnswer instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(MultipleQuestionAnswer instance) {
		log.debug("attaching dirty MultipleQuestionAnswer instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MultipleQuestionAnswer instance) {
		log.debug("attaching clean MultipleQuestionAnswer instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(MultipleQuestionAnswer persistentInstance) {
		log.debug("deleting MultipleQuestionAnswer instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MultipleQuestionAnswer merge(MultipleQuestionAnswer detachedInstance) {
		log.debug("merging MultipleQuestionAnswer instance");
		try {
			MultipleQuestionAnswer result = (MultipleQuestionAnswer) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MultipleQuestionAnswer findById(java.lang.String id) {
		log.debug("getting MultipleQuestionAnswer instance with id: " + id);
		try {
			MultipleQuestionAnswer instance = (MultipleQuestionAnswer) sessionFactory
					.getCurrentSession().get(
							"com.pkg.hibernate.MultipleQuestionAnswer", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MultipleQuestionAnswer instance) {
		log.debug("finding MultipleQuestionAnswer instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pkg.hibernate.MultipleQuestionAnswer")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
