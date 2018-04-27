package hoang.phuong.server.service;

import hoang.phuong.server.dao.ThongtinsinhvienDAO;
import hoang.phuong.server.model.Thongtinsinhvien;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class ThongtinsinhvienServiceImpl implements ThongtinsinhvienService {
    private ThongtinsinhvienDAO thongtinsinhvienDAO;

    @Inject
    public ThongtinsinhvienServiceImpl(ThongtinsinhvienDAO thongtinsinhvienDAO) {
        this.thongtinsinhvienDAO = thongtinsinhvienDAO;
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
    public void update(Thongtinsinhvien thongtinsinhvien) {
        thongtinsinhvienDAO.update(thongtinsinhvien);
    }

    @Transactional
    @Override
    public void delete(String maSv) {
        thongtinsinhvienDAO.delete(maSv);
    }



    @Override
    public List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max) {
        return thongtinsinhvienDAO.listOrderBy(mapOrder, min, max);
    }
}
