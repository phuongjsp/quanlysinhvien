package hoang.phuong.server.dao;

import hoang.phuong.server.model.Nganhdaotao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NganhDaoTaoDAOImpl extends AbstractDAO<Integer, Nganhdaotao> implements NganhDaoTaoDAO {
    @Override
    public boolean save(Nganhdaotao nganhDaoTao) {
        if(getByMaNganhdaotao(nganhDaoTao.getMaNganh())==null){
            saveDAO(nganhDaoTao);
            return true;
        }
        return false;
    }

    @Override
    public Nganhdaotao getByID(int id) {
        return getByKey(id);
    }

    @Override
    public Nganhdaotao getByMaNganhdaotao(String maNganhdaotao) {
        return (Nganhdaotao) createEntityCriteria().add(Restrictions.eq("maNganh", maNganhdaotao)).uniqueResult();
    }

    @Override
    public List<Nganhdaotao> list() {
        return listDAO();
    }

    @Override
    public boolean update(Nganhdaotao nganhdaotao) {
        if(getByID(nganhdaotao.getId())!=null){
            Nganhdaotao nganhdaotao2 = getByID(nganhdaotao.getId());
            nganhdaotao2.setMaNganh(nganhdaotao.getMaNganh());
            nganhdaotao2.setTenNganh(nganhdaotao.getTenNganh());
            nganhdaotao2.setKhoa(nganhdaotao.getKhoa());
            nganhdaotao2.setGhiChu(nganhdaotao.getGhiChu());
            getSession().flush();
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String maNganhdaotao) {
       if(getByMaNganhdaotao(maNganhdaotao)!=null){
           deleteDAO(getByMaNganhdaotao(maNganhdaotao));
           return true;
       }
       return false;
    }
}
