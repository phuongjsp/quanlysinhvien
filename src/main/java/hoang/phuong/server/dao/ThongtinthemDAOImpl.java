package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinthem;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThongtinthemDAOImpl extends AbstractDAO<Integer, Thongtinthem> implements ThongtinthemDAO {
    @Override
    public int save(Thongtinthem thongtinthem) {
        saveDAO(thongtinthem);
        return thongtinthem.getId();
    }

    @Override
    public Thongtinthem getByID(int id) {
        return getByKey(id);
    }

    @Override
    public List<Thongtinthem> list() {
        return createEntityCriteria().list();
    }

    @Override
    public List<Thongtinthem> listByIDSv(int idSv) {
        return createEntityCriteria().add(Restrictions.eq("idSv", idSv)).list();
    }

    @Override
    public void update(Thongtinthem thongtinthem) {
        Thongtinthem thongtinthem2 = getByID(thongtinthem.getId());
        thongtinthem2.setTenThongTin(thongtinthem.getTenThongTin());
        thongtinthem2.setThongTin(thongtinthem.getThongTin());
        getSession().flush();
    }

    @Override
    public void delete(int id) {
        deleteDAO(id);
    }
}
