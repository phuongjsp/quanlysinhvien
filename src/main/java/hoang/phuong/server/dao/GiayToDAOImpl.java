package hoang.phuong.server.dao;

import hoang.phuong.server.model.Giayto;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiayToDAOImpl extends AbstractDAO<Integer, Giayto> implements GiayToDAO {
    @Override
    public Giayto getById(int id) {
        return getByKey(id);
    }

    @Override
    public Giayto getBymaGT(String maGT) {
        try {
            Giayto giayto = (Giayto) createEntityCriteria().add(Restrictions.eq("maGiayTo", maGT)).uniqueResult();
            return giayto;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Giayto save(Giayto giayto) {
        try {
            saveDAO(giayto);
            return giayto;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public boolean Update(Giayto giayto) {
        try {
            Giayto giayto2 = getById(giayto.getId());
            giayto2.setTenGiayTo(giayto.getTenGiayTo());
            giayto2.setMaGiayTo(giayto.getMaGiayTo());
            getSession().flush();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public boolean delete(int id) {
        try {
            deleteDAO(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<Giayto> list() {
        return listDAO();
    }
}
