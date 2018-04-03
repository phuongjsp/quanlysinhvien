package hoang.phuong.server.service;

import hoang.phuong.server.dao.NganhDaoTaoDAO;
import hoang.phuong.server.model.Nganhdaotao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class NganhdaotaoServiceImpl implements NganhdaotaoService {
    @Autowired
    private NganhDaoTaoDAO nganhDaoTaoDAO;

    @Transactional
    @Override
    public int save(Nganhdaotao nganhDaoTao) {
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

    @Transactional
    @Override
    public void update(Nganhdaotao nganhdaotao) {
        nganhDaoTaoDAO.update(nganhdaotao);
    }

    @Transactional
    @Override
    public void delete(String maNganhdaotao) {
        nganhDaoTaoDAO.delete(maNganhdaotao);
    }
}
