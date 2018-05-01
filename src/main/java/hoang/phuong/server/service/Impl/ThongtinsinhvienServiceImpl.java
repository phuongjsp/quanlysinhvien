package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.ThongtinsinhvienDAO;
import hoang.phuong.server.model.Dinhchisinhvien;
import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.DinhchiSinhVienService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ThongtinsinhvienServiceImpl implements ThongtinsinhvienService {
    private ThongtinsinhvienDAO thongtinsinhvienDAO;
    private DinhchiSinhVienService dinhchiSinhVienService;
    @Inject
    public ThongtinsinhvienServiceImpl(ThongtinsinhvienDAO thongtinsinhvienDAO, DinhchiSinhVienService dinhchiSinhVienService) {
        this.thongtinsinhvienDAO = thongtinsinhvienDAO;
        this.dinhchiSinhVienService = dinhchiSinhVienService;
    }

    @Override
    public Thongtinsinhvien getByMaSV(String maSV) {
        return thongtinsinhvienDAO.getByMaSV(maSV);
    }

    @Override
    public Thongtinsinhvien getById(int ID) {
        return thongtinsinhvienDAO.getById(ID);
    }


    @Transactional
    @Override
    public Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienDAO.save(thongtinsinhvien);
    }

    @Transactional
    @Override
    public boolean update(Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienDAO.update(thongtinsinhvien);
    }

    @Transactional
    @Override
    public boolean delete(String maSv) {
        return thongtinsinhvienDAO.delete(maSv);
    }



    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {
        List<Thongtinsinhvien> thongtinsinhvienList = thongtinsinhvienDAO.listOrderBy(mapOrder, min, max);
        List<Dinhchisinhvien> dinhchisinhvienList = dinhchiSinhVienService.findAll();
        List<Thongtinsinhvien> listBiDinhChi = new ArrayList<>();
        thongtinsinhvienList.forEach(thongtinsinhvien -> {
            dinhchisinhvienList.forEach(dinhchisinhvien -> {
                if (dinhchisinhvien.getIdSv() == thongtinsinhvien.getId() && dinhchisinhvien.getDenNgay().before(new Date())) {
                    listBiDinhChi.add(thongtinsinhvien);
                }
            });
        });
        listBiDinhChi.forEach(thongtinsinhvien -> {
            thongtinsinhvienList.remove(thongtinsinhvien);
        });
        return thongtinsinhvienList;
    }
}
