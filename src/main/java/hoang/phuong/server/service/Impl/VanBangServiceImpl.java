package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.VanBangDAO;
import hoang.phuong.server.model.Vanbang;
import hoang.phuong.server.service.VanBangService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class VanBangServiceImpl implements VanBangService {

    private VanBangDAO vanBangDAO;

    @Inject
    public VanBangServiceImpl(VanBangDAO vanBangDAO) {
        this.vanBangDAO = vanBangDAO;
    }

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

    @Override
    public boolean update(Vanbang vanbang) {
        return vanBangDAO.update(vanbang);
    }

    @Override
    public boolean delete(int id) {
        return vanBangDAO.delete(id);
    }
}
