package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.GiaoVienDAO;
import hoang.phuong.server.model.Giaovien;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class GiaoVienDAOImpl extends AbstractDAO<Integer, Giaovien> implements GiaoVienDAO {
    private static final Logger LOG = LoggerFactory.getLogger(GiaoVienDAOImpl.class);

    @Inject
    public GiaoVienDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Giaovien save(Giaovien giaovien) {
        return saveDAO(giaovien);

    }

    @Override
    public Giaovien update(Giaovien giaovien) {
        try {
            Giaovien giaovien1 = getById(giaovien.getId());
            if (giaovien.getMaGv() != null) giaovien1.setMaGv(giaovien.getMaGv());
            if (giaovien.getTenGiaoVien() != null) giaovien1.setTenGiaoVien(giaovien.getTenGiaoVien());
            getSession().flush();
            return giaovien;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            deleteDAO(id);
            return true;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Giaovien getById(int id) {
        return getByKey(id);
    }

    @Override
    public Giaovien getBymaGv(String maGv) {
        return (Giaovien) getSession()
                .createQuery("SELECT Giaovien from Giaovien where maGv=:maGv")
                .setParameter("maGv", maGv).uniqueResult();
    }

    @Override
    public List<Giaovien> list() {
        return listDAO();
    }
}
