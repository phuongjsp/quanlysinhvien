package hoang.phuong.server.dao;

import hoang.phuong.server.model.Lopsv;

import java.util.List;

public interface LopsvDAO {
    int save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    List<Lopsv> list();

    void update(Lopsv lopsv);

    void delete(String maLop);
}
