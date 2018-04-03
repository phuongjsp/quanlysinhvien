package hoang.phuong.server.dao;

import hoang.phuong.server.model.Nganhdaotao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NganhDaoTaoDAOImpl extends AbstractDAO<Integer, Nganhdaotao> implements NganhDaoTaoDAO {
    @Override
    public int save(Nganhdaotao nganhDaoTao) {
        saveDAO(nganhDaoTao);
        return nganhDaoTao.getId();
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
    public void update(Nganhdaotao nganhdaotao) {
        Nganhdaotao nganhdaotao2 = getByMaNganhdaotao(nganhdaotao.getMaNganh());
        nganhdaotao2.setTenNganh(nganhdaotao.getTenNganh());
        nganhdaotao2.setKhoa(nganhdaotao.getKhoa());
        nganhdaotao2.setGhiChu(nganhdaotao.getGhiChu());
        getSession().flush();
    }

    @Override
    public void delete(String maNganhdaotao) {
        deleteDAO(getByMaNganhdaotao(maNganhdaotao));
    }
}
