package hoang.phuong.server.dao;

import hoang.phuong.server.model.Vanbang;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VanBangDAOImpl extends AbstractDAO<Integer,Vanbang> implements VanBangDAO {
    @Override
    public int save(Vanbang vanbang) {
        saveDAO(vanbang);
        return vanbang.getId();
    }

    @Override
    public Vanbang getbyId(int id) {
        return getByKey(id);
    }

    @Override
    public Vanbang getByMaVB(String maVB) {
        return (Vanbang) createEntityCriteria().add(Restrictions.eq("maVanBang",maVB)).uniqueResult();
    }

    @Override
    public List<Vanbang> list() {
        return listDAO();
    }

    @Override
    public void update(Vanbang vanbang) {
Vanbang vanbang2 = getbyId(vanbang.getId());
        vanbang2.setTenVanBang(vanbang.getTenVanBang());
        getSession().flush();
    }

    @Override
    public void delete(int id) {
    deleteDAO(id);
    }
}
