package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.ThongtinsinhvienDAO;
import hoang.phuong.server.model.Dinhchisinhvien;
import hoang.phuong.server.model.Thongtinsinhvien;
import hoang.phuong.server.service.DinhchiSinhVienService;
import hoang.phuong.server.service.ThongtinsinhvienService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
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


    @Override
    public Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienDAO.save(thongtinsinhvien);
    }

    @Override
    public boolean update(Thongtinsinhvien thongtinsinhvien) {
        return thongtinsinhvienDAO.update(thongtinsinhvien);
    }

    @Override
    public boolean delete(String maSv) {
        return thongtinsinhvienDAO.delete(maSv);
    }



    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {
        return getThongtinsinhviens(mapOrder, min, max, false);
    }

    private List<Thongtinsinhvien> getThongtinsinhviens(List<Map<String, Object>> mapOrder, int min, int max, boolean b) {
        List<Dinhchisinhvien> dinhchisinhvienList = dinhchiSinhVienService.listConDinhChi();
        //doto chage to set or linked
        List<Integer> listIdSvbiDinhChi = new ArrayList<>();
        dinhchisinhvienList.forEach((Dinhchisinhvien dinhchisinhvien) -> listIdSvbiDinhChi.add(dinhchisinhvien.getIdSv()));

        return thongtinsinhvienDAO.listOrderBy(mapOrder, listIdSvbiDinhChi, b, min, max);
    }

    @Override
    public List<Thongtinsinhvien> listBiDinhChiOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {
        return getThongtinsinhviens(mapOrder, min, max, true);

    }
}
