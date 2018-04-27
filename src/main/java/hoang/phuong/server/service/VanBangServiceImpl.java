package hoang.phuong.server.service;

import hoang.phuong.server.dao.VanBangDAO;
import hoang.phuong.server.model.Vanbang;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
@Service
@Transactional(readOnly = true)
public class VanBangServiceImpl implements VanBangService {

    private VanBangDAO vanBangDAO;

    @Inject
    public VanBangServiceImpl(VanBangDAO vanBangDAO) {
        this.vanBangDAO = vanBangDAO;
    }

    @Transactional
    @Override
    public Vanbang save(Vanbang vanbang) {
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
    public boolean update(Vanbang vanbang) {
        return vanBangDAO.update(vanbang);
    }
    @Transactional
    @Override
    public boolean delete(int id) {
        return vanBangDAO.delete(id);
    }
}
