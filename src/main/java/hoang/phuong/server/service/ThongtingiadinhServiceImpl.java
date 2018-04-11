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
    public void save(Thongtingiadinh thongtingiadinh) {
          thongtingiadinhDAO.save(thongtingiadinh);
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
    public void update(Thongtingiadinh thongtingiadinh) {
        thongtingiadinhDAO.update(thongtingiadinh);
    }

    @Transactional
    @Override
    public void delete(int id) {
        thongtingiadinhDAO.delete(id);
    }
}
