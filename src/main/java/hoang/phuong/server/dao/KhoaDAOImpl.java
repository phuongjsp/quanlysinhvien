package hoang.phuong.server.dao;

import hoang.phuong.server.model.Khoa;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class KhoaDAOImpl extends AbstractDAO<Integer, Khoa> implements KhoaDAO {
    @Inject
    public KhoaDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Khoa save(Khoa khoa) {
        if (getByMaKhoa(khoa.getMaKhoa()) == null) {
            saveDAO(khoa);
            return khoa;
        }
        return null;
    }

    @Override
    public Khoa getByID(int id) {
        return getByKey(id);
    }

    @Deprecated
    @Override
    public Khoa getByMaKhoa(String maKhoa) {
        return (Khoa) createEntityCriteria().add(Restrictions.eq("maKhoa", maKhoa)).uniqueResult();
    }

    @Deprecated
    @Override
    public List<Khoa> list() {
        return listDAO();
    }

    @Override
    public boolean update(Khoa khoa) {
        if(getByID(khoa.getId())!=null){
            Khoa khoa2 = getByID(khoa.getId());
            khoa2.setMaKhoa(khoa.getMaKhoa());
            khoa2.setTenKhoa(khoa.getTenKhoa());
            khoa2.setNamHoc(khoa.getNamHoc());
            khoa2.setGhiChu(khoa.getGhiChu());
            getSession().flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
       if(getByID(id)!=null){
           deleteDAO(id);
           return true;
       }
       return false;
    }
}
