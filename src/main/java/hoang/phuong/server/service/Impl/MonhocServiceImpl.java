package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.MonhocDAO;
import hoang.phuong.server.model.Monhoc;
import hoang.phuong.server.service.MonhocService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class MonhocServiceImpl implements MonhocService {
    private MonhocDAO monhocDAO;

    @Inject
    public MonhocServiceImpl(MonhocDAO monhocDAO) {
        this.monhocDAO = monhocDAO;
    }

    @Override
    public Monhoc save(Monhoc monhoc) {
        return monhocDAO.save(monhoc);
    }

    @Override
    public Monhoc update(Monhoc monhoc) {
        return monhocDAO.update(monhoc);
    }

    @Override
    public Monhoc getById(int id) {
        return monhocDAO.getById(id);
    }

    @Override
    public List<Monhoc> list() {
        return monhocDAO.list();
    }

    @Override
    public boolean delete(int id) {
        return monhocDAO.delete(id);
    }

    @Override
    public Monhoc getbyMaMh(String maMh) {
        return monhocDAO.getbyMaMh(maMh);
    }
}
