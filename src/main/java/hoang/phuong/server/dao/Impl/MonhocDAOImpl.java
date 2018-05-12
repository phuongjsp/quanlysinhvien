package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.MonhocDAO;
import hoang.phuong.server.model.Monhoc;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class MonhocDAOImpl extends AbstractDAO<Integer, Monhoc> implements MonhocDAO {
    private static final Logger LOG = LoggerFactory.getLogger(MonhocDAOImpl.class);

    @Inject
    public MonhocDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Monhoc save(Monhoc monhoc) {
        return saveDAO(monhoc);
    }

    @Override
    public Monhoc update(Monhoc monhoc) {
        try {
            Monhoc monhoc1 = getById(monhoc.getId());
            monhoc1.setTenMonHoc(monhoc.getTenMonHoc());
            getSession().flush();
            return monhoc1;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Monhoc getById(int id) {
        return getByKey(id);
    }

    @Override
    public Monhoc getbyMaMh(String maMh) {
        return (Monhoc) getSession().createQuery("from Monhoc where maMh=:maMh").setParameter("maMh", maMh).uniqueResult();
    }

    @Override
    public List<Monhoc> list() {
        return listDAO();
    }

    @Override
    public boolean delete(int id) {
        return deleteDAO(id);
    }
}
