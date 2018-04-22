package hoang.phuong.server.dao;

import hoang.phuong.server.model.Nganhdaotao;

import java.util.List;

public interface NganhDaoTaoDAO {
    Nganhdaotao save(Nganhdaotao nganhDaoTao);

    Nganhdaotao getByID(int id);

    Nganhdaotao getByMaNganhdaotao(String maNganhdaotao);

    List<Nganhdaotao> list();

    boolean update(Nganhdaotao nganhdaotao);

    boolean delete(String maNganhdaotao);
}
