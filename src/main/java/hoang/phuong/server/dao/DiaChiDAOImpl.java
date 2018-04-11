package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diachi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiaChiDAOImpl extends AbstractDAO<Integer, Diachi> implements DiaChiDAO {
    @Override
    public int save(Diachi diachi) {
        saveDAO(diachi);
        return diachi.getId();
    }

    @Override
    public Diachi getByID(int id) {
        return getByKey(id);
    }

    @Override
    public List<Diachi> list() {
        return listDAO();
    }

    @Override
    public boolean update(Diachi diachi) {

        if(getByID(diachi.getId())!=null) {
           Diachi diachi2 = getByID(diachi.getId());
           diachi2.setTinh(diachi.getTinh());
           diachi2.setQuanHuyen(diachi.getQuanHuyen());
           diachi2.setXaPhuong(diachi.getXaPhuong());
           diachi2.setThonXom(diachi.getThonXom());
           getSession().flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
       if(getByID(id)!=null) {
           deleteDAO(id);
           return true;
       }
       return false;
    }
}
