package hoang.phuong.server.service;

import hoang.phuong.server.dao.DiaChiDAO;
import hoang.phuong.server.model.Diachi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DiaChiServiceImpl implements DiaChiService {
    @Autowired
    private DiaChiDAO diaChiDAO;

    @Transactional
    @Override
    public int save(Diachi diachi) {
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

    @Transactional
    @Override
    public void update(Diachi diachi) {
        diaChiDAO.update(diachi);
    }

    @Transactional
    @Override
    public void delete(int id) {
        diaChiDAO.delete(id);
    }
}
