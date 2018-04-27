package hoang.phuong.server.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

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
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    protected List<T> listDAO() {
        return createEntityCriteria().list();
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

    @Deprecated
    @SuppressWarnings("unchecked")
    protected List<T> listOrderByDAO(List<Map<String, Object>> mapOrder, int min, int max) {
        Criteria criteria = createEntityCriteria();
        if (!mapOrder.isEmpty()) mapOrder.forEach((map) -> {
            if (map.get("diachi") != null) {
                criteria.createAlias("tt.diachiBy" + map.get("diachi"), "diachi");
            }
            if (map.get("tinh") != null) {
                criteria.add(Restrictions.eq("diachi.tinh", map.get("tinh").toString()));
                if (map.get("quanHuyen") != null) {
                    criteria.add(Restrictions.eq("diachi.quanHuyen", map.get("quanHuyen").toString()));
                    if (map.get("xaPhuong") != null) {
                        criteria.add(Restrictions.eq("diachi.xaPhuong", map.get("xaPhuong").toString()));
                        if (map.get("thonXom") != null) {
                            criteria.add(Restrictions.eq("diachi.thonXom", map.get("thonXom").toString()));
                        }
                    }
                }
            }
            if (map.get("order") != null) {
                if (map.get("order").equals("asc"))
                    criteria.addOrder(Order.asc("tt." + map.get("property").toString()));
                if (map.get("order").equals("desc"))
                    criteria.addOrder(Order.desc("tt." + map.get("property").toString()));
            }
            if (map.get("type") != null) {
                if (map.get("type").equals("eq"))
                    criteria.add(Restrictions.eq("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("like"))
                    criteria.add(Restrictions.like("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("in"))
                    criteria.add(Restrictions.in("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("between"))
                    criteria.add(Restrictions.between("tt." + map.get("property").toString(), java.sql.Date.valueOf(map.get("valuelow").toString()), java.sql.Date.valueOf(map.get("valuehight").toString())));
            }
        });
        if(min!=max)criteria.setFirstResult(min).setMaxResults(max);
        return criteria.list();
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