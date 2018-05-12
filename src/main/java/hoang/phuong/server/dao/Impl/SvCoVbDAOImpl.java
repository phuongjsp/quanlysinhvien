package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.SvCoVbDAO;
import hoang.phuong.server.model.Svcovb;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class SvCoVbDAOImpl extends AbstractDAO<Integer, Svcovb> implements SvCoVbDAO {
    @Inject
    public SvCoVbDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Svcovb save(Svcovb svcovb) {
        try {
            saveDAO(svcovb);
            return svcovb;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Svcovb getById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Svcovb> list() {
        return listDAO();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Svcovb> listByIdSv(int idSv) {
        return getSession().createQuery("from Svcovb where idSv=:idSv")
                .setParameter("idSv", idSv)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Svcovb> listByLoaiVB(int idLoaiVb) {
        return getSession().createQuery("from Svcovb where loaiVb=:loaiVb")
                .setParameter("loaiVb", idLoaiVb)
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Svcovb> listbyIdSvAndLoaiVb(int idSv, int idLoaiVb) {
        return getSession().createQuery("from Svcovb where idSv=:idSv and loaiVb=:loaiVb")
                .setParameter("idSv", idSv)
                .setParameter("loaiVb", idLoaiVb)
                .getResultList();
    }

    @Override
    public boolean update(Svcovb svcovb) {
        if (getById(svcovb.getId()) != null) {
            Svcovb svcovb2 = getById(svcovb.getId());
            svcovb2.setIdSv(svcovb.getIdSv());
            svcovb2.setLoaiVb(svcovb.getLoaiVb());
            svcovb2.setTenThuocTinh(svcovb.getTenThuocTinh());
            svcovb2.setThuocTinh(svcovb.getThuocTinh());
            getSession().flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (getById(id) != null) return deleteDAO(id);
        return false;
    }
}
