package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.DiaChiDAO;
import hoang.phuong.server.model.Diachi;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Repository
public class DiaChiDAOImpl extends AbstractDAO<Integer, Diachi> implements DiaChiDAO {

    @Inject
    public DiaChiDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Diachi save(Diachi diachi) {
        Criteria criteria = createEntityCriteria();
        if (diachi.getTinh() != null)
            criteria.add(Restrictions.eq("tinh", diachi.getTinh()).ignoreCase());
        else
            criteria.add(Restrictions.isNull("tinh"));
        if (diachi.getQuanHuyen() != null)
            criteria.add(Restrictions.eq("quanHuyen", diachi.getQuanHuyen()).ignoreCase());
        else
            criteria.add(Restrictions.isNull("quanHuyen"));
        if (diachi.getXaPhuong() != null)
            criteria.add(Restrictions.eq("xaPhuong", diachi.getXaPhuong()).ignoreCase());
        else
            criteria.add(Restrictions.isNull("xaPhuong"));
        if (diachi.getThonXom() != null)
            criteria.add(Restrictions.eq("thonXom", diachi.getThonXom()).ignoreCase());
        else
            criteria.add(Restrictions.isNull("thonXom"));
        Diachi result = (Diachi) criteria.uniqueResult();
        if (result == null) {
            saveDAO(diachi);
            return diachi;
        } else return result;
    }

    @Override
    public Diachi getByID(int id) {
        return getByKey(id);
    }

    @Deprecated
    @Override
    public List<Diachi> list() {
        return listDAO();
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public List<Diachi> listByProperties(Map<String, String> map) {
        Criteria criteria = createEntityCriteria();
        map.forEach((k, v) -> criteria.add(Restrictions.ilike(k, "%" + v + "%")));

        return criteria.list();
    }

    @Override
    public boolean update(Diachi diachi) {

        if (getByID(diachi.getId()) != null) {
            Diachi diachi2 = getByID(diachi.getId());
            if (diachi.getTinh() != null) diachi2.setTinh(diachi.getTinh());
            if (diachi.getQuanHuyen() != null) diachi2.setQuanHuyen(diachi.getQuanHuyen());
            if (diachi.getXaPhuong() != null) diachi2.setXaPhuong(diachi.getXaPhuong());
            if (diachi.getThonXom() != null) diachi2.setThonXom(diachi.getThonXom());
            getSession().flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (getByID(id) != null) {
            deleteDAO(id);
            return true;
        }
        return false;
    }
}
