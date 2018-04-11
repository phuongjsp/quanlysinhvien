package hoang.phuong.server.dao;

import hoang.phuong.server.model.Lopsv;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LopsvDAOImpl extends AbstractDAO<Integer, Lopsv> implements LopsvDAO {
    @Override
    public boolean save(Lopsv lopsv) {
        if(getByMaLop(lopsv.getMaLop())!=null) {
             saveDAO(lopsv);
             return true;
        }
        return false;
    }

    @Override
    public Lopsv getByMaLop(String maLop) {
        return (Lopsv) createEntityCriteria().add(Restrictions.eq("maLop", maLop)).uniqueResult();
    }

    @Override
    public List<Lopsv> list() {
        return listDAO();
    }

    @Override
    public boolean update(Lopsv lopsv) {

        if(getByMaLop(lopsv.getMaLop())!=null){
            Lopsv lopsv2 = getByMaLop(lopsv.getMaLop());
            lopsv2.setTenLop(lopsv.getTenLop());
            getSession().flush();
            return true;
        }return false  ;
    }

    @Override
    public boolean delete(String maLop) {
       if(getByMaLop(maLop)!=null){
           deleteDAO(getByMaLop(maLop));
           return true;
       }return false;
    }
}
