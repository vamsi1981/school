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
 * Home object for domain model class SubTopics.
 * @see com.pkg.hibernate.SubTopics
 * @author Hibernate Tools
 */
public class SubTopicsHome {

	private static final Log log = LogFactory.getLog(SubTopicsHome.class);

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

	public void persist(SubTopics transientInstance) {
		log.debug("persisting SubTopics instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SubTopics instance) {
		log.debug("attaching dirty SubTopics instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SubTopics instance) {
		log.debug("attaching clean SubTopics instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SubTopics persistentInstance) {
		log.debug("deleting SubTopics instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SubTopics merge(SubTopics detachedInstance) {
		log.debug("merging SubTopics instance");
		try {
			SubTopics result = (SubTopics) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SubTopics findById(java.lang.String id) {
		log.debug("getting SubTopics instance with id: " + id);
		try {
			SubTopics instance = (SubTopics) sessionFactory.getCurrentSession()
					.get("com.pkg.hibernate.SubTopics", id);
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

	public List findByExample(SubTopics instance) {
		log.debug("finding SubTopics instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pkg.hibernate.SubTopics")
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
