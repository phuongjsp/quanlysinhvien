package hoang.phuong.server.dao;

import hoang.phuong.server.model.Lopsv;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LopsvDAOImpl extends AbstractDAO<Integer, Lopsv> implements LopsvDAO {
    @Override
    public int save(Lopsv lopsv) {
        saveDAO(lopsv);
        return lopsv.getId();
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
    public void update(Lopsv lopsv) {
        Lopsv lopsv2 = getByMaLop(lopsv.getMaLop());
        lopsv2.setTenLop(lopsv.getTenLop());
        getSession().flush();
    }

    @Override
    public void delete(String maLop) {
        deleteDAO(getByMaLop(maLop));
    }
}
