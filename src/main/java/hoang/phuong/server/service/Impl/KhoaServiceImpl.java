package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.KhoaDAO;
import hoang.phuong.server.model.Khoa;
import hoang.phuong.server.service.KhoaService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class KhoaServiceImpl implements KhoaService {
    private KhoaDAO khoaDAO;

    @Inject
    public KhoaServiceImpl(KhoaDAO khoaDAO) {
        this.khoaDAO = khoaDAO;
    }

    @Override
    public Khoa save(Khoa khoa) {
        return khoaDAO.save(khoa);
    }

    @Override
    public Khoa getByID(int id) {
        return khoaDAO.getByID(id);
    }

    @Override
    public Khoa getByMaKhoa(String maKhoa) {
        return khoaDAO.getByMaKhoa(maKhoa);
    }

    @Override
    public List<Khoa> list() {
        return khoaDAO.list();
    }

    @Override
    public boolean update(Khoa khoa) {
        return khoaDAO.update(khoa);
    }

    @Override
    public boolean delete(int id) {
        return khoaDAO.delete(id);
    }
}
