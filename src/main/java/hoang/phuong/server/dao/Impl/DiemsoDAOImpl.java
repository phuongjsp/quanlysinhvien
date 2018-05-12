package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.DiemsoDAO;
import hoang.phuong.server.model.Diemso;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import javax.inject.Inject;
import java.util.List;

@Repository
public class DiemsoDAOImpl extends AbstractDAO<Integer, Diemso> implements DiemsoDAO {
    private static final Logger LOG = LoggerFactory.getLogger(DiemsoDAOImpl.class);

    @Inject
    public DiemsoDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Diemso save(Diemso diemso) {
        return saveDAO(diemso);
    }

    @Override
    public Diemso update(Diemso diemso) {
        try {
            Diemso diemso1 = getbyId(diemso.getId());
            diemso1.setDiem(diemso.getDiem());
            diemso1.setIdKyHoc(diemso.getIdKyHoc());
            diemso1.setIdMonHoc(diemso.getIdMonHoc());
            diemso1.setIdSv(diemso.getIdSv());
            getSession().flush();
            return diemso1;
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Diemso getbyId(int id) {
        return getByKey(id);
    }

    @Override
    public boolean delete(int id) {
        return deleteDAO(id);
    }

    @SuppressWarnings("unchecked")
    @Deprecated
    @Override
    public List<Diemso> listBYMultivalue(MultiValueMap<String, Object> map) {
        Criteria criteria = createEntityCriteria();
        map.forEach((s, objects) -> criteria.add(Restrictions.in(s, objects.toArray())));
        return criteria.list();
    }
}
