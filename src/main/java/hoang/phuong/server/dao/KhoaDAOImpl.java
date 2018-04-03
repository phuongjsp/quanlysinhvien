package hoang.phuong.server.dao;

import hoang.phuong.server.model.Khoa;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KhoaDAOImpl extends AbstractDAO<Integer, Khoa> implements KhoaDAO {
    @Override
    public int save(Khoa khoa) {
        saveDAO(khoa);
        return khoa.getId();
    }

    @Override
    public Khoa getByID(int id) {
        return getByKey(id);
    }

    @Override
    public Khoa getByMaKhoa(String maKhoa) {
        return (Khoa) createEntityCriteria().add(Restrictions.eq("maKhoa", maKhoa)).uniqueResult();
    }

    @Override
    public List<Khoa> list() {
        return listDAO();
    }

    @Override
    public void update(Khoa khoa) {
        Khoa khoa2 = getByID(khoa.getId());
        khoa2.setMaKhoa(khoa.getMaKhoa());
        khoa2.setTenKhoa(khoa.getTenKhoa());
        khoa2.setNamHoc(khoa.getNamHoc());
        khoa2.setGhiChu(khoa.getGhiChu());
        getSession().flush();
    }

    @Override
    public void delete(int id) {
        deleteDAO(id);
    }
}
