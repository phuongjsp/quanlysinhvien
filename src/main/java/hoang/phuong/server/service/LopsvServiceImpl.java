package hoang.phuong.server.service;

import hoang.phuong.server.dao.LopsvDAO;
import hoang.phuong.server.model.Lopsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LopsvServiceImpl implements LopsvService {
    @Autowired
    private LopsvDAO lopsvDAO;

    @Transactional
    @Override
    public Lopsv save(Lopsv lopsv) {
        return lopsvDAO.save(lopsv);
    }

    @Override
    public Lopsv getByMaLop(String maLop) {
        return lopsvDAO.getByMaLop(maLop);
    }

    @Override
    public List<Lopsv> list() {
        return lopsvDAO.list();
    }

    @Transactional
    @Override
    public boolean update(Lopsv lopsv) {
        return lopsvDAO.update(lopsv);
    }

    @Transactional
    @Override
    public boolean delete(String maLop) {
        return lopsvDAO.delete(maLop);
    }
}
