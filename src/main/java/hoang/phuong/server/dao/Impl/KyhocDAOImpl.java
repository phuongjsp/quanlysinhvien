package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.KyhocDAO;
import hoang.phuong.server.model.Kyhoc;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class KyhocDAOImpl extends AbstractDAO<Integer, Kyhoc> implements KyhocDAO {
    private static final Logger LOG = LoggerFactory.getLogger(KyhocDAOImpl.class);

    @Inject
    public KyhocDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Kyhoc save(Kyhoc kyhoc) {
        return saveDAO(kyhoc);
    }

    @Override
    public Kyhoc update(Kyhoc kyhoc) {
        try {
            Kyhoc kyhoc1 = getById(kyhoc.getId());
            if (kyhoc.getTenKyHoc() != null) kyhoc1.setTenKyHoc(kyhoc.getTenKyHoc());
            if (kyhoc.getNamHoc() != null) kyhoc1.setNamHoc(kyhoc.getNamHoc());
            if (kyhoc.getMaKh() != null && getBymaKh(kyhoc.getMaKh()) == null) kyhoc1.setMaKh(kyhoc.getMaKh());
            getSession().flush();
            return kyhoc1;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Kyhoc getById(int id) {
        return getByKey(id);
    }

    @Override
    public Kyhoc getBymaKh(String maKh) {
        return (Kyhoc) getSession().createQuery("from Kyhoc where maKh=:maKh")
                .setParameter("maKh", maKh).uniqueResult();
    }

    @Override
    public List<Kyhoc> list() {
        return listDAO();
    }

    @Override
    public boolean delete(int id) {
        return deleteDAO(id);
    }
}
