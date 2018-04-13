package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diachi;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    public List<Diachi> listByProperties(Map<String, String> map) {
        Criteria criteria = createEntityCriteria();
        map.forEach((k,v)->{
            criteria.add(Restrictions.ilike(k,"%"+v+"%"));
        });

        return criteria.list();
    }

    @Override
    public boolean update(Diachi diachi) {

        if(getByID(diachi.getId())!=null) {
           Diachi diachi2 = getByID(diachi.getId());
          if(diachi.getTinh()!=null) diachi2.setTinh(diachi.getTinh());
            if(diachi.getQuanHuyen()!=null) diachi2.setQuanHuyen(diachi.getQuanHuyen());
            if(diachi.getXaPhuong()!=null)  diachi2.setXaPhuong(diachi.getXaPhuong());
            if(diachi.getThonXom()!=null)  diachi2.setThonXom(diachi.getThonXom());
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
