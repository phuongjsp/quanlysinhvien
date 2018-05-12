package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.SvCoVbDAO;
import hoang.phuong.server.model.Svcovb;
import hoang.phuong.server.service.SvCoVbService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class SvCoVbServiceImpl implements SvCoVbService {
    private SvCoVbDAO svCoVbDAO;

    @Inject
    public SvCoVbServiceImpl(SvCoVbDAO svCoVbDAO) {
        this.svCoVbDAO = svCoVbDAO;
    }

    @Override
    public Svcovb save(Svcovb svcovb) {
        return svCoVbDAO.save(svcovb);
    }

    @Override
    public Svcovb getById(int id) {
        return svCoVbDAO.getById(id);
    }

    @Override
    public List<Svcovb> list() {
        return svCoVbDAO.list();
    }

    @Override
    public List<Svcovb> listByIdSv(int idSv) {
        return svCoVbDAO.listByIdSv(idSv);
    }

    @Override
    public List<Svcovb> listByLoaiVB(int idLoaiVb) {
        return svCoVbDAO.listByLoaiVB(idLoaiVb);
    }

    @Override
    public List<Svcovb> listbyIdSvAndLoaiVb(int idSv, int idLoaiVb) {
        return svCoVbDAO.listbyIdSvAndLoaiVb(idSv, idLoaiVb);
    }

    @Override
    public boolean update(Svcovb svcovb) {
        return svCoVbDAO.update(svcovb);
    }

    @Override
    public boolean delete(int id) {
        return svCoVbDAO.delete(id);
    }
}
