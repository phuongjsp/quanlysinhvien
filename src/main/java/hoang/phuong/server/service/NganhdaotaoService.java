package hoang.phuong.server.service;

import hoang.phuong.server.model.Nganhdaotao;

import java.util.List;

public interface NganhdaotaoService {
    boolean save(Nganhdaotao nganhDaoTao);

    Nganhdaotao getByID(int id);

    Nganhdaotao getByMaNganhdaotao(String maNganhdaotao);

    List<Nganhdaotao> list();

    void update(Nganhdaotao nganhdaotao);

    void delete(String maNganhdaotao);
}
