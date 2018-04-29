package hoang.phuong.server.service;

import hoang.phuong.server.dao.DiaChiDAO;
import hoang.phuong.server.model.Diachi;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class DiaChiServiceImpl implements DiaChiService {
    private DiaChiDAO diaChiDAO;

    @Inject
    public DiaChiServiceImpl(DiaChiDAO diaChiDAO) {
        this.diaChiDAO = diaChiDAO;
    }

    @Transactional
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

    @Transactional
    @Override
    public boolean update(Diachi diachi) {
        return diaChiDAO.update(diachi);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return diaChiDAO.delete(id);
    }
}
