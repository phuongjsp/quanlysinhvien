package hoang.phuong.server.service;

import hoang.phuong.server.dao.ThongtingiadinhDAO;
import hoang.phuong.server.model.Thongtingiadinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ThongtingiadinhServiceImpl implements ThongtingiadinhService {

    @Autowired
    private ThongtingiadinhDAO thongtingiadinhDAO;

    @Transactional
    @Override
    public Thongtingiadinh save(Thongtingiadinh thongtingiadinh) {
        return thongtingiadinhDAO.save(thongtingiadinh);
    }

    @Override
    public Thongtingiadinh getByID(int id) {
        return thongtingiadinhDAO.getByID(id);
    }

    @Override
    public List<Thongtingiadinh> list() {
        return thongtingiadinhDAO.list();
    }

    @Override
    public List<Thongtingiadinh> listByIDSv(int idSv) {
        return thongtingiadinhDAO.listByIDSv(idSv);
    }

    @Transactional
    @Override
    public boolean update(Thongtingiadinh thongtingiadinh) {
        return thongtingiadinhDAO.update(thongtingiadinh);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        return thongtingiadinhDAO.delete(id);
    }
}
