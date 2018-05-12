package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.ThongtinthemDAO;
import hoang.phuong.server.model.Thongtinthem;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class ThongtinthemDAOImpl extends AbstractDAO<Integer, Thongtinthem> implements ThongtinthemDAO {
    @Inject
    public ThongtinthemDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Thongtinthem save(Thongtinthem thongtinthem) {
        try {
            saveDAO(thongtinthem);
            return thongtinthem;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Thongtinthem getByID(int id) {
        return getByKey(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Thongtinthem> list() {
        return listDAO();
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public List<Thongtinthem> listByIDSv(int idSv) {
        return createEntityCriteria().add(Restrictions.eq("idSv", idSv)).list();
    }

    @Override
    public boolean update(Thongtinthem thongtinthem) {
        if (getByID(thongtinthem.getId()) != null) {
            Thongtinthem thongtinthem2 = getByID(thongtinthem.getId());
            thongtinthem2.setTenThongTin(thongtinthem.getTenThongTin());
            thongtinthem2.setThongTin(thongtinthem.getThongTin());
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
