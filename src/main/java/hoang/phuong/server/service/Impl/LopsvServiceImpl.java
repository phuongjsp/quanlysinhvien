package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.LopsvDAO;
import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class LopsvServiceImpl implements LopsvService {
    private LopsvDAO lopsvDAO;

    @Inject
    public LopsvServiceImpl(LopsvDAO lopsvDAO) {
        this.lopsvDAO = lopsvDAO;
    }

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
    public Lopsv getbyId(int id) {
        return lopsvDAO.getbyId(id);
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
