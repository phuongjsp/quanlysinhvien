package hoang.phuong.server.service;

import hoang.phuong.server.dao.VanBangDAO;
import hoang.phuong.server.model.Vanbang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class VanBangServiceImpl implements VanBangService {

    @Autowired
    private VanBangDAO vanBangDAO;

    @Transactional
    @Override
    public boolean save(Vanbang vanbang) {
        return vanBangDAO.save(vanbang);
    }

    @Override
    public Vanbang getbyId(int id) {
        return vanBangDAO.getbyId(id);
    }

    @Override
    public Vanbang getByMaVB(String maVB) {
        return vanBangDAO.getByMaVB(maVB);
    }

    @Override
    public List<Vanbang> list() {
        return vanBangDAO.list();
    }
    @Transactional
    @Override
    public void update(Vanbang vanbang) {
        vanBangDAO.update(vanbang);
    }
    @Transactional
    @Override
    public void delete(int id) {
        vanBangDAO.delete(id);
    }
}
