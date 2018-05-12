package hoang.phuong.server.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Transactional
public abstract class AbstractDAO<PK extends Serializable, T> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDAO.class);
    private final Class<T> persistentClass;
    private SessionFactory sessionFactory;

    @Inject
    @SuppressWarnings("unchecked")
    public AbstractDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @SuppressWarnings("unchecked")
//    @Deprecated
    protected List<T> listDAO() {
        Query query = getSession().createQuery("FROM " + persistentClass.getSimpleName());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    protected T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }

    protected T saveDAO(T entity) {
        try {
            getSession().save(entity);
            return entity;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

//    protected void persistDAO(T entity) {
//        getSession().persist(entity);
//    }
//
//    protected void updateDAO(T entity) {
//
//        getSession().update(entity);
//    }


    protected boolean deleteDAO(T entity) {
        try {
            getSession().delete(entity);
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return false;
        }
    }


    protected boolean deleteDAO(PK key) {
        try {
            T entity = getSession().byId(persistentClass).load(key);
            getSession().delete(entity);
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return false;
        }
    }

    @Deprecated
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass, "tt");
    }

}