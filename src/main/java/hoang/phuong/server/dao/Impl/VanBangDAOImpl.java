package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.VanBangDAO;
import hoang.phuong.server.model.Vanbang;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
@Repository
public class VanBangDAOImpl extends AbstractDAO<Integer,Vanbang> implements VanBangDAO {
    @Inject
    public VanBangDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Vanbang save(Vanbang vanbang) {
        if (getByMaVB(vanbang.getMaVanBang()) == null) {
            saveDAO(vanbang);
            return vanbang;
        }
        return null;
    }

    @Override
    public Vanbang getbyId(int id) {
        return getByKey(id);
    }

    @Deprecated
    @Override
    public Vanbang getByMaVB(String maVB) {
        return (Vanbang) createEntityCriteria().add(Restrictions.eq("maVanBang",maVB)).uniqueResult();
    }

    @Override
    public List<Vanbang> list() {
        return listDAO();
    }

    @Override
    public boolean update(Vanbang vanbang) {
if(getbyId(vanbang.getId())!=null){
            Vanbang vanbang2 = getbyId(vanbang.getId());
            vanbang2.setMaVanBang(vanbang.getMaVanBang());
            vanbang2.setTenVanBang(vanbang.getTenVanBang());
            getSession().flush();
            return true;
        }return false;
    }

    @Override
    public boolean delete(int id) {
   if(getbyId(id)!=null){
       deleteDAO(id);
       return true;
   }return false;
    }
}
