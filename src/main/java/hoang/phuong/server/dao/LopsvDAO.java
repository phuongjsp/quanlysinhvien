package hoang.phuong.server.dao;

import hoang.phuong.server.model.Lopsv;

import java.util.List;

public interface LopsvDAO {
    Lopsv save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    Lopsv getbyId(int id);

    List<Lopsv> list();

    boolean update(Lopsv lopsv);

    boolean delete(String maLop);
}
