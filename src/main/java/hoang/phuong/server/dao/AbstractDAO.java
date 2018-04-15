package hoang.phuong.server.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

public abstract class AbstractDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;
    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<T> listDAO() {
        return createEntityCriteria().list();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void saveDAO(T entity) {

            getSession().save(entity);
    }

    public void persistDAO(T entity) {
        getSession().persist(entity);
    }

    public void updateDAO(T entity) {

        getSession().update(entity);
    }


    public void deleteDAO(T entity) {
        getSession().delete(entity);
    }

    public List<T> listLimit(int min, int max) {
        Criteria criteria = createEntityCriteria();
        return criteria.setFirstResult(min).setMaxResults(max).list();
    }

    public List<T> listOrderByDAO(List<Map<String, Object>> mapOrder, int min, int max) {
        Criteria criteria = createEntityCriteria();
     if(!mapOrder.isEmpty())   mapOrder.forEach((map) -> {
            if (map.get("order") != null) {
                if (map.get("order").equals("asc")) criteria.addOrder(Order.asc(map.get("property").toString()));
                if (map.get("order").equals("desc")) criteria.addOrder(Order.desc(map.get("property").toString()));
            }
            if (map.get("type") != null) {
                if (map.get("type").equals("eq"))
                    criteria.add(Restrictions.eq(map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("like"))
                    criteria.add(Restrictions.like(map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("in"))
                    criteria.add(Restrictions.in(map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("between"))
                    criteria.add(Restrictions.between(map.get("property").toString(), map.get("valuelow"), map.get("valuehight")));
            }
        });
        if(min!=max)criteria.setFirstResult(min).setMaxResults(max);
        return criteria.list();
    }

    public void deleteDAO(PK key) {
        T entity = getSession().byId(persistentClass).load(key);
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }

}