package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.KyhocDAO;
import hoang.phuong.server.model.Kyhoc;
import hoang.phuong.server.service.KyhocService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class KyhocServiceImpl implements KyhocService {
    private KyhocDAO kyhocDAO;

    @Inject
    public KyhocServiceImpl(KyhocDAO kyhocDAO) {
        this.kyhocDAO = kyhocDAO;
    }

    @Override
    public Kyhoc save(Kyhoc kyhoc) {
        return kyhocDAO.save(kyhoc);
    }

    @Override
    public Kyhoc update(Kyhoc kyhoc) {
        return kyhocDAO.update(kyhoc);
    }

    @Override
    public Kyhoc getById(int id) {
        return kyhocDAO.getById(id);
    }

    @Override
    public List<Kyhoc> list() {
        return kyhocDAO.list();
    }

    @Override
    public boolean delete(int id) {
        return kyhocDAO.delete(id);
    }

    @Override
    public Kyhoc getBymaKh(String maKh) {
        return kyhocDAO.getBymaKh(maKh);
    }
}
