package hoang.phuong.server.dao;

import hoang.phuong.server.model.Svcovb;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SvCoVbDAOImpl extends AbstractDAO<Integer,Svcovb> implements SvCoVbDAO {
    @Override
    public void save(Svcovb svcovb) {
        saveDAO(svcovb);
    }

    @Override
    public Svcovb getById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Svcovb> list() {
        return listDAO();
    }

    @Override
    public List<Svcovb> listByIdSv(int idSv) {
        return createEntityCriteria()
                .add(Restrictions.eq("idSv",idSv)).list();
    }

    @Override
    public List<Svcovb> listByLoaiVB(int idLoaiVb) {
        return createEntityCriteria()
                .add(Restrictions.eq("loaiVb",idLoaiVb))
                .list();
    }

    @Override
    public List<Svcovb> listbyIdSvAndLoaiVb(int idSv, int idLoaiVb) {
        return createEntityCriteria()
                .add(Restrictions.eq("idSv",idSv))
                .add(Restrictions.eq("loaiVb",idLoaiVb))
                .list();
    }

    @Override
    public boolean update(Svcovb svcovb) {
if(getById(svcovb.getId())!=null){
    Svcovb svcovb2 = getById(svcovb.getId());
    svcovb2.setIdSv(svcovb.getIdSv());
    svcovb2.setLoaiVb(svcovb.getLoaiVb());
    svcovb2.setTenThuocTinh(svcovb.getTenThuocTinh());
    svcovb2.setThuocTinh(svcovb.getThuocTinh());
    getSession().flush();
    return true;
}return false;
    }

    @Override
    public boolean delete(int id) {
if(getById(id)!=null){
    deleteDAO(id);
    return true;
}return false;
    }
}
