package hoang.phuong.server.dao;

import hoang.phuong.server.model.Nganhdaotao;

import java.util.List;

public interface NganhDaoTaoDAO {
    int save(Nganhdaotao nganhDaoTao);

    Nganhdaotao getByID(int id);

    Nganhdaotao getByMaNganhdaotao(String maNganhdaotao);

    List<Nganhdaotao> list();

    void update(Nganhdaotao nganhdaotao);

    void delete(String maNganhdaotao);
}
