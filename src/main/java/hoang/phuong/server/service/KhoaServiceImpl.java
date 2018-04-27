package hoang.phuong.server.service;

import hoang.phuong.server.dao.KhoaDAO;
import hoang.phuong.server.model.Khoa;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class KhoaServiceImpl implements KhoaService {
    private KhoaDAO khoaDAO;

    @Inject
    public KhoaServiceImpl(KhoaDAO khoaDAO) {
        this.khoaDAO = khoaDAO;
    }

    @Transactional
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

    @Transactional
    @Override
    public void update(Khoa khoa) {
        khoaDAO.update(khoa);
    }

    @Transactional
    @Override
    public void delete(int id) {
        khoaDAO.delete(id);
    }
}
