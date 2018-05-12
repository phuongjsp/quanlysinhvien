package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.GiaoVienDAO;
import hoang.phuong.server.model.Giaovien;
import hoang.phuong.server.service.GiaoVienService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class GiaoVienServiceImpl implements GiaoVienService {
    private GiaoVienDAO giaoVienDAO;

    @Inject
    public GiaoVienServiceImpl(GiaoVienDAO giaoVienDAO) {
        this.giaoVienDAO = giaoVienDAO;
    }

    @Override
    public Giaovien save(Giaovien giaovien) {
        return giaoVienDAO.save(giaovien);
    }

    @Override
    public Giaovien update(Giaovien giaovien) {
        return giaoVienDAO.update(giaovien);
    }

    @Override
    public boolean delete(int id) {
        return giaoVienDAO.delete(id);
    }

    @Override
    public Giaovien getById(int id) {
        return giaoVienDAO.getById(id);
    }

    @Override
    public Giaovien getBymaGv(String maGv) {
        return giaoVienDAO.getBymaGv(maGv);
    }

    @Override
    public List<Giaovien> list() {
        return giaoVienDAO.list();
    }
}
