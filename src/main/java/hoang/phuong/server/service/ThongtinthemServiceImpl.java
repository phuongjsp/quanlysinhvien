package hoang.phuong.server.service;

import hoang.phuong.server.dao.ThongtinthemDAO;
import hoang.phuong.server.model.Thongtinthem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongtinthemServiceImpl implements ThongtinthemService {

    @Autowired
    private ThongtinthemDAO thongtinthemDAO;

    @Transactional
    @Override
    public int save(Thongtinthem thongtinthem) {
        return thongtinthemDAO.save(thongtinthem);
    }

    @Override
    public Thongtinthem getByID(int id) {
        return thongtinthemDAO.getByID(id);
    }

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
    public void update(Thongtinthem thongtinthem) {
        thongtinthemDAO.update(thongtinthem);
    }

    @Transactional
    @Override
    public void delete(int id) {
        thongtinthemDAO.delete(id);
    }
}
