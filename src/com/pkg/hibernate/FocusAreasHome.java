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
 * Home object for domain model class FocusAreas.
 * @see com.pkg.hibernate.FocusAreas
 * @author Hibernate Tools
 */
public class FocusAreasHome {

	private static final Log log = LogFactory.getLog(FocusAreasHome.class);

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

	public void persist(FocusAreas transientInstance) {
		log.debug("persisting FocusAreas instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(FocusAreas instance) {
		log.debug("attaching dirty FocusAreas instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(FocusAreas instance) {
		log.debug("attaching clean FocusAreas instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(FocusAreas persistentInstance) {
		log.debug("deleting FocusAreas instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public FocusAreas merge(FocusAreas detachedInstance) {
		log.debug("merging FocusAreas instance");
		try {
			FocusAreas result = (FocusAreas) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FocusAreas findById(java.lang.String id) {
		log.debug("getting FocusAreas instance with id: " + id);
		try {
			FocusAreas instance = (FocusAreas) sessionFactory
					.getCurrentSession()
					.get("com.pkg.hibernate.FocusAreas", id);
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

	public List findByExample(FocusAreas instance) {
		log.debug("finding FocusAreas instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("com.pkg.hibernate.FocusAreas")
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
