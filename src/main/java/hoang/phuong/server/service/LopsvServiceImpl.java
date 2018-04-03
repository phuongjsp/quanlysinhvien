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
    public int save(Lopsv lopsv) {
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
    public void update(Lopsv lopsv) {
        lopsvDAO.update(lopsv);
    }

    @Transactional
    @Override
    public void delete(String maLop) {
        lopsvDAO.delete(maLop);
    }
}
