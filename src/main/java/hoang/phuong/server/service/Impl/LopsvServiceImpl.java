package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.LopsvDAO;
import hoang.phuong.server.model.Lopsv;
import hoang.phuong.server.service.LopsvService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class LopsvServiceImpl implements LopsvService {
    private LopsvDAO lopsvDAO;

    @Inject
    public LopsvServiceImpl(LopsvDAO lopsvDAO) {
        this.lopsvDAO = lopsvDAO;
    }

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

    @Override
    public boolean update(Lopsv lopsv) {
        return lopsvDAO.update(lopsv);
    }

    @Override
    public boolean delete(String maLop) {
        return lopsvDAO.delete(maLop);
    }
}
