package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.KhenThuongDAO;
import hoang.phuong.server.model.Khenthuong;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class KhenThuongDAOImpl extends AbstractDAO<Integer, Khenthuong> implements KhenThuongDAO {
    public KhenThuongDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Khenthuong save(Khenthuong khenthuong) {
        saveDAO(khenthuong);
        return khenthuong;
    }

    @Override
    public Khenthuong getById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Khenthuong> findAll() {
        return listDAO();
    }

    @Override
    public List<Khenthuong> findByIdSv(int idSv) {
        return getSession().createQuery("from Khenthuong where idSv=:idSv").setParameter("idSv", idSv).getResultList();
    }

    @Override
    public List<Khenthuong> findByYear(Date stdate, Date eddate) {
        return getSession().createQuery("from Khenthuong where ngay between :stdate and :endate")
                .setParameter("stdate", stdate)
                .setParameter("endate", eddate)
                .getResultList();
    }

    @Override
    public Khenthuong update(Khenthuong khenthuong) {
        try {
            Khenthuong khenthuong1 = getById(khenthuong.getId());
            if (khenthuong.getLyDo() != null) khenthuong1.setLyDo(khenthuong.getLyDo());
            if (khenthuong.getNgay() != null) khenthuong1.setNgay(khenthuong.getNgay());
            getSession().flush();
            return khenthuong1;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        return delete(id);
    }
}
