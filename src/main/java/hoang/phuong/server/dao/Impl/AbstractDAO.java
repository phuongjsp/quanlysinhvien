package hoang.phuong.server.dao.Impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO<PK extends Serializable, T> {

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

    //    @SuppressWarnings("unchecked")
//    @Deprecated
    protected List<T> listDAO() {
        Query query = getSession().createQuery("FROM " + persistentClass.getSimpleName());
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    protected T getByKey(PK key) {
        return getSession().get(persistentClass, key);
    }

    protected void saveDAO(T entity) {

            getSession().save(entity);
    }

//    protected void persistDAO(T entity) {
//        getSession().persist(entity);
//    }
//
//    protected void updateDAO(T entity) {
//
//        getSession().update(entity);
//    }


    protected void deleteDAO(T entity) {
        getSession().delete(entity);
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    protected List<T> listLimit(int min, int max) {
        Criteria criteria = createEntityCriteria();
        return criteria.setFirstResult(min).setMaxResults(max).list();
    }


    protected void deleteDAO(PK key) {
        T entity = getSession().byId(persistentClass).load(key);
        getSession().delete(entity);
    }

    @Deprecated
    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass, "tt");
    }

}