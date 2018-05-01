package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.DinhchiSinhVienDAO;
import hoang.phuong.server.model.Dinhchisinhvien;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DinhchiSinhVienDAOImpl extends AbstractDAO<Integer, Dinhchisinhvien> implements DinhchiSinhVienDAO {
    public DinhchiSinhVienDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Dinhchisinhvien save(Dinhchisinhvien dinhchisinhvien) {
        saveDAO(dinhchisinhvien);
        return dinhchisinhvien;
    }

    @Deprecated
    @Override
    public List<Dinhchisinhvien> findAll() {
        return listDAO();
    }

    @Override
    public Dinhchisinhvien getOne(int id) {
        return getByKey(id);
    }

    @Override
    public Dinhchisinhvien update(Dinhchisinhvien dinhchisinhvien) {
        Dinhchisinhvien dinhchisinhvien1 = getOne(dinhchisinhvien.getId());
        if (dinhchisinhvien.getLyDo() != null) dinhchisinhvien1.setLyDo(dinhchisinhvien.getLyDo());
        if (dinhchisinhvien.getTuNgay() != null) dinhchisinhvien1.setTuNgay(dinhchisinhvien.getTuNgay());
        if (dinhchisinhvien.getDenNgay() != null) dinhchisinhvien1.setDenNgay(dinhchisinhvien.getDenNgay());
        getSession().flush();
        return dinhchisinhvien1;
    }

    @Override
    public boolean delete(int id) {
        try {
            deleteDAO(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
