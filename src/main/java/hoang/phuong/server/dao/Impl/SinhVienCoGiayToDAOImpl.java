package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.SinhVienCoGiayToDAO;
import hoang.phuong.server.model.Sinhviencogiayto;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SinhVienCoGiayToDAOImpl extends AbstractDAO<Integer, Sinhviencogiayto> implements SinhVienCoGiayToDAO {

    @Inject
    public SinhVienCoGiayToDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Sinhviencogiayto getbyId(int id) {
        return getByKey(id);
    }

    @Override
    public Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto) {
        try {
            saveDAO(sinhviencogiayto);
            return sinhviencogiayto;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean update(Sinhviencogiayto sinhviencogiayto) {
        try {
            Sinhviencogiayto sinhviencogiayto2 = getbyId(sinhviencogiayto.getId());
            sinhviencogiayto2.setIdSv(sinhviencogiayto.getIdSv());
            sinhviencogiayto2.setIdGiayTo(sinhviencogiayto.getIdGiayTo());
            sinhviencogiayto2.setThongtin(sinhviencogiayto.getThongtin());
            getSession().flush();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            deleteDAO(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Deprecated
    @Override
    public List<Sinhviencogiayto> list() {
        return listDAO();
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    @Override
    public List<Sinhviencogiayto> listByIdSv(int idSv) {
        return createEntityCriteria().add(Restrictions.eq("idSv", idSv)).list();
    }
}
