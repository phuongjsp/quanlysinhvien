package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.DinhchiSinhVienDAO;
import hoang.phuong.server.model.Dinhchisinhvien;
import hoang.phuong.server.service.DinhchiSinhVienService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class DinhchiSinhVienServiceImpl implements DinhchiSinhVienService {
    private final DinhchiSinhVienDAO dinhchiSinhVienDAO;

    @Inject
    public DinhchiSinhVienServiceImpl(DinhchiSinhVienDAO dinhchiSinhVienDAO) {
        this.dinhchiSinhVienDAO = dinhchiSinhVienDAO;
    }

    @Override
    public Dinhchisinhvien save(Dinhchisinhvien dinhchisinhvien) {
        return dinhchiSinhVienDAO.save(dinhchisinhvien);
    }

    @Override
    public List<Dinhchisinhvien> findAll() {
        return dinhchiSinhVienDAO.findAll();
    }

    @Override
    public List<Dinhchisinhvien> listConDinhChi() {
        return dinhchiSinhVienDAO.listConDinhChi();
    }

    @Override
    public Dinhchisinhvien getOne(int id) {
        return dinhchiSinhVienDAO.getOne(id);
    }

    @Override
    public Dinhchisinhvien update(Dinhchisinhvien dinhchisinhvien) {
        return dinhchiSinhVienDAO.update(dinhchisinhvien);
    }

    @Override
    public boolean delete(int id) {
        return dinhchiSinhVienDAO.delete(id);
    }
}
