package hoang.phuong.server.dao.Impl;

import hoang.phuong.server.dao.ThongtinsinhvienDAO;
import hoang.phuong.server.model.Thongtinsinhvien;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Repository
public class ThongtinsinhvienDAOImpl extends AbstractDAO<Integer, Thongtinsinhvien> implements ThongtinsinhvienDAO {
    @Inject
    public ThongtinsinhvienDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Deprecated
    @Override
    public Thongtinsinhvien getByMaSV(String maSV) {
        return (Thongtinsinhvien) createEntityCriteria().add(Restrictions.eq("maSv", maSV)).uniqueResult();
    }

    @Override
    public Thongtinsinhvien getById(int ID) {
        return getByKey(ID);
    }


    @Deprecated
    @Override
    public Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien) {
        if (getByMaSV(thongtinsinhvien.getMaSv()) == null) {
            saveDAO(thongtinsinhvien);
            return thongtinsinhvien;
        }
        return null;
    }

    @Override
    public boolean update(Thongtinsinhvien thongtinsinhvien) {
        try {
            Thongtinsinhvien thongtinsinhvien2 = getById(thongtinsinhvien.getId());
            if (thongtinsinhvien.getMaSv() != null && !thongtinsinhvien.getMaSv().equals(thongtinsinhvien2.getMaSv()))
                thongtinsinhvien2.setMaSv(thongtinsinhvien.getMaSv());
            if (thongtinsinhvien.getNgayVaoHoc() != null)
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
            if (thongtinsinhvien.getHoKhauThuongChu() != null)
                thongtinsinhvien2.setHoKhauThuongChu(thongtinsinhvien.getHoKhauThuongChu());
            getSession().flush();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Deprecated
    @Override
    public boolean delete(String maSv) {
        try {
            deleteDAO(getByMaSV(maSv));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Integer getIdByMaSv(String maSv) {
        return (Integer) getSession()
                .createQuery("select id from Thongtinsinhvien where maSv=:maSv")
                .setParameter("maSv", maSv).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<String> checkMaSv(String maSv) {
        return getSession().createQuery("select maSv from Thongtinsinhvien where maSv like :maSv")
                .setParameter("maSv", "%" + maSv + "%")
                .getResultList();
    }

    @Override
    public String getMaSvById(int id) {
        return (String) getSession().createQuery("select maSv from Thongtinsinhvien where id=:id").setParameter("id", id)
                .uniqueResult();
    }

    @Deprecated
    @SuppressWarnings("unchecked")
    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, List<Integer> idSvDinhChi, boolean dinhChi, int min, int max) {
        Criteria criteria = createEntityCriteria();
        if (!mapOrder.isEmpty()) mapOrder.forEach((map) -> {
            if (map.get("diachi") != null) {
                criteria.createAlias("tt.diachiBy" + map.get("diachi"), "diachi");
            }
            if (map.get("tinh") != null) {
                criteria.add(Restrictions.eq("diachi.tinh", map.get("tinh").toString()));
                if (map.get("quanHuyen") != null) {
                    criteria.add(Restrictions.eq("diachi.quanHuyen", map.get("quanHuyen").toString()));
                    if (map.get("xaPhuong") != null) {
                        criteria.add(Restrictions.eq("diachi.xaPhuong", map.get("xaPhuong").toString()));
                        if (map.get("thonXom") != null) {
                            criteria.add(Restrictions.eq("diachi.thonXom", map.get("thonXom").toString()));
                        }
                    }
                }
            }
            if (map.get("order") != null) {
                if (map.get("order").equals("asc"))
                    criteria.addOrder(Order.asc("tt." + map.get("property").toString()));
                if (map.get("order").equals("desc"))
                    criteria.addOrder(Order.desc("tt." + map.get("property").toString()));
            }
            if (map.get("type") != null) {
                if (map.get("type").equals("eq"))
                    criteria.add(Restrictions.eq("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("like"))
                    criteria.add(Restrictions.like("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("in"))
                    criteria.add(Restrictions.in("tt." + map.get("property").toString(), map.get("value")));
                if (map.get("type").equals("between"))
                    criteria.add(Restrictions.between("tt." + map.get("property").toString(), java.sql.Date.valueOf(map.get("valuelow").toString()), java.sql.Date.valueOf(map.get("valuehight").toString())));
            }
        });
        if (dinhChi) {
            if (!idSvDinhChi.isEmpty()) criteria.add(Restrictions.in("id", idSvDinhChi));
        } else {
            if (!idSvDinhChi.isEmpty()) criteria.add(Restrictions.not(Restrictions.in("id", idSvDinhChi)));
        }
        if (min != max) criteria.setFirstResult(min).setMaxResults(max);
        return criteria.list();
    }
}
