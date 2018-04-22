package hoang.phuong.server.service;

import hoang.phuong.server.dao.SvCoVbDAO;
import hoang.phuong.server.model.Svcovb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class SvCoVbServiceImpl implements SvCoVbService {
    @Autowired
    private SvCoVbDAO svCoVbDAO;

    @Transactional
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
        return svCoVbDAO.listbyIdSvAndLoaiVb(idSv,idLoaiVb);
    }
    @Transactional
    @Override
    public boolean update(Svcovb svcovb) {
        return svCoVbDAO.update(svcovb);
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        return svCoVbDAO.delete(id);
    }
}
