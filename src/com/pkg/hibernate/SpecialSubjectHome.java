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
 * Home object for domain model class SpecialSubject.
 * @see com.pkg.hibernate.SpecialSubject
 * @author Hibernate Tools
 */
public class SpecialSubjectHome {

	private static final Log log = LogFactory.getLog(SpecialSubjectHome.class);

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

	public void persist(SpecialSubject transientInstance) {
		log.debug("persisting SpecialSubject instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SpecialSubject instance) {
		log.debug("attaching dirty SpecialSubject instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SpecialSubject instance) {
		log.debug("attaching clean SpecialSubject instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SpecialSubject persistentInstance) {
		log.debug("deleting SpecialSubject instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SpecialSubject merge(SpecialSubject detachedInstance) {
		log.debug("merging SpecialSubject instance");
		try {
			SpecialSubject result = (SpecialSubject) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SpecialSubject findById(java.lang.String id) {
		log.debug("getting SpecialSubject instance with id: " + id);
		try {
			SpecialSubject instance = (SpecialSubject) sessionFactory
					.getCurrentSession().get(
							"com.pkg.hibernate.SpecialSubject", id);
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

	public List findByExample(SpecialSubject instance) {
		log.debug("finding SpecialSubject instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pkg.hibernate.SpecialSubject")
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
