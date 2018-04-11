package hoang.phuong.server.dao;

import hoang.phuong.server.model.Lopsv;

import java.util.List;

public interface LopsvDAO {
    boolean save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    List<Lopsv> list();

    boolean update(Lopsv lopsv);

    boolean delete(String maLop);
}
