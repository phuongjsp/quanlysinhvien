package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.KhenThuongDAO;
import hoang.phuong.server.model.Khenthuong;
import hoang.phuong.server.service.KhenThuongService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class KhenThuongServiceImpl implements KhenThuongService {
    private final KhenThuongDAO khenThuongDAO;

    public KhenThuongServiceImpl(KhenThuongDAO khenThuongDAO) {
        this.khenThuongDAO = khenThuongDAO;
    }

    @Override
    public Khenthuong save(Khenthuong khenthuong) {
        return khenThuongDAO.save(khenthuong);
    }

    @Override
    public Khenthuong getById(int id) {
        return khenThuongDAO.getById(id);
    }

    @Override
    public List<Khenthuong> findAll() {
        return khenThuongDAO.findAll();
    }

    @Override
    public List<Khenthuong> findByYear(Date stdate, Date eddate) {
        return khenThuongDAO.findByYear(stdate, eddate);
    }

    @Override
    public List<Khenthuong> findByIdSv(int idSv) {
        return khenThuongDAO.findByIdSv(idSv);
    }

    @Override
    public Khenthuong update(Khenthuong khenthuong) {
        return khenThuongDAO.update(khenthuong);
    }

    @Override
    public boolean delete(int id) {
        return khenThuongDAO.delete(id);
    }
}
