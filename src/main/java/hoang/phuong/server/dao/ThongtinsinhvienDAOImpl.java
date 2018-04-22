package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinsinhvien;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ThongtinsinhvienDAOImpl extends AbstractDAO<Integer, Thongtinsinhvien> implements ThongtinsinhvienDAO {
    @Override
    public Thongtinsinhvien getByMaSV(String maSV) {
        return (Thongtinsinhvien) createEntityCriteria().add(Restrictions.eq("maSv", maSV)).uniqueResult();
    }

    @Override
    public Thongtinsinhvien getById(int ID) {
        return getByKey(ID);
    }

    @Override
    public List<Thongtinsinhvien> list() {
        return listDAO();
    }

    @Override
    public Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien) {
       if(getByMaSV(thongtinsinhvien.getMaSv())==null){
           saveDAO(thongtinsinhvien);
           return thongtinsinhvien;
       }
        return null;
    }

    @Override
    public void update(Thongtinsinhvien thongtinsinhvien) {
        Thongtinsinhvien thongtinsinhvien2 = getById(thongtinsinhvien.getId());
        if(thongtinsinhvien.getMaSv()!=null && thongtinsinhvien.getMaSv()!=thongtinsinhvien2.getMaSv())
            thongtinsinhvien2.setMaSv(thongtinsinhvien.getMaSv());
        if (thongtinsinhvien.getNgayVaoHoc() != null )
            thongtinsinhvien2.setNgayVaoHoc(thongtinsinhvien.getNgayVaoHoc());
        if (thongtinsinhvien.getTen() != null)
            thongtinsinhvien2.setTen(thongtinsinhvien.getTen());
        if (thongtinsinhvien.getHo() != null)
            thongtinsinhvien2.setHo(thongtinsinhvien.getHo());
        if (thongtinsinhvien.getAnhThe() != null)
            thongtinsinhvien2.setAnhThe(thongtinsinhvien.getAnhThe());
        if (thongtinsinhvien.getDanToc() != null)
            thongtinsinhvien2.setDanToc(thongtinsinhvien.getDanToc());
        if (thongtinsinhvien.getGioiTinh() != null)
            thongtinsinhvien2.setGioiTinh(thongtinsinhvien.getGioiTinh());
        if (thongtinsinhvien.getKhoaHoc() != null)
            thongtinsinhvien2.setKhoaHoc(thongtinsinhvien.getKhoaHoc());
        if (thongtinsinhvien.getLop() != null)
            thongtinsinhvien2.setLop(thongtinsinhvien.getLop());
        if (thongtinsinhvien.getNganhDk() != null)
            thongtinsinhvien2.setNganhDk(thongtinsinhvien.getNganhDk());
        if (thongtinsinhvien.getNgaySinh() != null)
            thongtinsinhvien2.setNgaySinh(thongtinsinhvien.getNgaySinh());
        if (thongtinsinhvien.getNoiSinh() != null)
            thongtinsinhvien2.setNoiSinh(thongtinsinhvien.getNoiSinh());
        if(thongtinsinhvien.getHoKhauThuongChu()!=null)
            thongtinsinhvien2.setHoKhauThuongChu(thongtinsinhvien.getHoKhauThuongChu());
        getSession().flush();
    }

    @Override
    public void delete(String maSv) {
        deleteDAO(getByMaSV(maSv));
    }

    @Override
    public List<Thongtinsinhvien> listLimit(int min, int max) {
        return createEntityCriteria().setFirstResult(min).setMaxResults(max).list();
    }


    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {

        return listOrderByDAO(mapOrder, min, max);
    }
}
