package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.DiaChiDAO;
import hoang.phuong.server.model.Diachi;
import hoang.phuong.server.service.DiaChiService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
public class DiaChiServiceImpl implements DiaChiService {
    private DiaChiDAO diaChiDAO;

    @Inject
    public DiaChiServiceImpl(DiaChiDAO diaChiDAO) {
        this.diaChiDAO = diaChiDAO;
    }

    @Override
    public Diachi save(Diachi diachi) {
        return diaChiDAO.save(diachi);
    }

    @Override
    public Diachi getByID(int id) {
        return diaChiDAO.getByID(id);
    }

    @Override
    public List<Diachi> list() {
        return diaChiDAO.list();
    }

    @Override
    public List<Diachi> listByProperties(Map<String, String> map) {
        return diaChiDAO.listByProperties(map);
    }

    @Override
    public boolean update(Diachi diachi) {
        return diaChiDAO.update(diachi);
    }

    @Override
    public boolean delete(int id) {
        return diaChiDAO.delete(id);
    }
}
