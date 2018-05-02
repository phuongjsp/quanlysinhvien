package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.ThongtinthemDAO;
import hoang.phuong.server.model.Thongtinthem;
import hoang.phuong.server.service.ThongtinthemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional
public class ThongtinthemServiceImpl implements ThongtinthemService {

    private ThongtinthemDAO thongtinthemDAO;

    @Inject
    public ThongtinthemServiceImpl(ThongtinthemDAO thongtinthemDAO) {
        this.thongtinthemDAO = thongtinthemDAO;
    }

    @Transactional
    @Override
    public Thongtinthem save(Thongtinthem thongtinthem) {
        return thongtinthemDAO.save(thongtinthem);
    }

    @Override
    public Thongtinthem getByID(int id) {
        return thongtinthemDAO.getByID(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Thongtinthem> list() {
        return thongtinthemDAO.list();
    }

    @Override
    public List<Thongtinthem> listByIDSv(int idSv) {
        return thongtinthemDAO.listByIDSv(idSv);
    }

    @Transactional
    @Override
    public boolean update(Thongtinthem thongtinthem) {
        return thongtinthemDAO.update(thongtinthem);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return thongtinthemDAO.delete(id);
    }
}
