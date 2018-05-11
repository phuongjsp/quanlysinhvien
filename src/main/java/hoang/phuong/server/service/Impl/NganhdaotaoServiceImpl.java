package hoang.phuong.server.service.Impl;

import hoang.phuong.server.dao.NganhDaoTaoDAO;
import hoang.phuong.server.model.Nganhdaotao;
import hoang.phuong.server.service.NganhdaotaoService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class NganhdaotaoServiceImpl implements NganhdaotaoService {
    private NganhDaoTaoDAO nganhDaoTaoDAO;

    @Inject
    public NganhdaotaoServiceImpl(NganhDaoTaoDAO nganhDaoTaoDAO) {
        this.nganhDaoTaoDAO = nganhDaoTaoDAO;
    }

    @Override
    public Nganhdaotao save(Nganhdaotao nganhDaoTao) {
        return nganhDaoTaoDAO.save(nganhDaoTao);
    }

    @Override
    public Nganhdaotao getByID(int id) {
        return nganhDaoTaoDAO.getByID(id);
    }

    @Override
    public Nganhdaotao getByMaNganhdaotao(String maNganhdaotao) {
        return nganhDaoTaoDAO.getByMaNganhdaotao(maNganhdaotao);
    }

    @Override
    public List<Nganhdaotao> list() {
        return nganhDaoTaoDAO.list();
    }

    @Override
    public boolean update(Nganhdaotao nganhdaotao) {
        return nganhDaoTaoDAO.update(nganhdaotao);
    }

    @Override
    public boolean delete(String maNganhdaotao) {
        return nganhDaoTaoDAO.delete(maNganhdaotao);
    }
}
