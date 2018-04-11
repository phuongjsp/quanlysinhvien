package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtingiadinh;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThongtingiadinhDAOImpl extends AbstractDAO<Integer, Thongtingiadinh> implements ThongtingiadinhDAO {
    @Override
    public void save(Thongtingiadinh thongtingiadinh) {
        saveDAO(thongtingiadinh);
    }

    @Override
    public Thongtingiadinh getByID(int id) {
        return getByKey(id);
    }

    @Override
    public List<Thongtingiadinh> list() {
        return createEntityCriteria().list();
    }

    @Override
    public List<Thongtingiadinh> listByIDSv(int idSv) {
        return createEntityCriteria().add(Restrictions.eq("idSv", idSv)).list();
    }

    @Override
    public boolean update(Thongtingiadinh thongtingiadinh) {
        if(getByID(thongtingiadinh.getId())!=null){
            Thongtingiadinh thongtingiadinh2 = getByID(thongtingiadinh.getId());
            if (thongtingiadinh.getNgheNghiep() != null) thongtingiadinh2.setNgheNghiep(thongtingiadinh.getNgheNghiep());
            if (thongtingiadinh.getQuanHe() != null) thongtingiadinh2.setQuanHe(thongtingiadinh.getQuanHe());
            if (thongtingiadinh.getTen() != null) thongtingiadinh2.setTen(thongtingiadinh.getTen());
            if (thongtingiadinh.getSdt() != null) thongtingiadinh2.setSdt(thongtingiadinh.getSdt());
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
