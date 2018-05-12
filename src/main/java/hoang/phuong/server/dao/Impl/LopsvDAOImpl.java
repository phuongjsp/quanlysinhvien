package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.LopsvDAO;
import hoang.phuong.server.model.Lopsv;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class LopsvDAOImpl extends AbstractDAO<Integer, Lopsv> implements LopsvDAO {

    @Inject
    public LopsvDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Lopsv save(Lopsv lopsv) {
        if (getByMaLop(lopsv.getMaLop()) == null) {
            saveDAO(lopsv);
            return lopsv;
        }
        return null;
    }

    @Deprecated
    @Override
    public Lopsv getByMaLop(String maLop) {
        return (Lopsv) createEntityCriteria().add(Restrictions.eq("maLop", maLop)).uniqueResult();
    }

    @Override
    public Lopsv getbyId(int id) {
        return getByKey(id);
    }

    @Override
    public List<Lopsv> list() {
        return listDAO();
    }

    @Deprecated
    @Override
    public boolean update(Lopsv lopsv) {

        if (getByMaLop(lopsv.getMaLop()) != null) {
            Lopsv lopsv2 = getByMaLop(lopsv.getMaLop());
            lopsv2.setTenLop(lopsv.getTenLop());
            getSession().flush();
            return true;
        }
        return false;
    }

    @Deprecated
    @Override
    public boolean delete(String maLop) {
        if (getByMaLop(maLop) != null) {
            deleteDAO(getByMaLop(maLop));
            return true;
        }
        return false;
    }
}
