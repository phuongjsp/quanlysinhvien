package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.ThongtingiadinhDAO;
import hoang.phuong.server.model.Thongtingiadinh;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ThongtingiadinhDAOImpl extends AbstractDAO<Integer, Thongtingiadinh> implements ThongtingiadinhDAO {
    @Inject
    public ThongtingiadinhDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Thongtingiadinh save(Thongtingiadinh thongtingiadinh) {
        try {
            saveDAO(thongtingiadinh);
            return thongtingiadinh;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Thongtingiadinh getByID(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Thongtingiadinh> list() {
        return listDAO();
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public List<Thongtingiadinh> listByIDSv(int idSv) {
        return createEntityCriteria().add(Restrictions.eq("idSv", idSv)).list();
    }

    @Override
    public boolean update(Thongtingiadinh thongtingiadinh) {
        if (getByID(thongtingiadinh.getId()) != null) {
            Thongtingiadinh thongtingiadinh2 = getByID(thongtingiadinh.getId());
            if (thongtingiadinh.getNgheNghiep() != null)
                thongtingiadinh2.setNgheNghiep(thongtingiadinh.getNgheNghiep());
            if (thongtingiadinh.getQuanHe() != null) thongtingiadinh2.setQuanHe(thongtingiadinh.getQuanHe());
            if (thongtingiadinh.getTen() != null) thongtingiadinh2.setTen(thongtingiadinh.getTen());
            if (thongtingiadinh.getSdt() != null) thongtingiadinh2.setSdt(thongtingiadinh.getSdt());
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
