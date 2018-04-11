package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinthem;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThongtinthemDAOImpl extends AbstractDAO<Integer, Thongtinthem> implements ThongtinthemDAO {
    @Override
    public void save(Thongtinthem thongtinthem) {
        saveDAO(thongtinthem);
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
    public boolean update(Thongtinthem thongtinthem) {
        if(getByID(thongtinthem.getId())!=null){
            Thongtinthem thongtinthem2 = getByID(thongtinthem.getId());
            thongtinthem2.setTenThongTin(thongtinthem.getTenThongTin());
            thongtinthem2.setThongTin(thongtinthem.getThongTin());
            getSession().flush();
            return true;
        }return false;
    }

    @Override
    public boolean delete(int id) {
      if(getByID(id)!=null){
          deleteDAO(id);
          return true;
      }return false;
    }
}
