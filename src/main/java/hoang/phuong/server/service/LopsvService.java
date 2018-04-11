package hoang.phuong.server.service;

import hoang.phuong.server.model.Lopsv;

import java.util.List;

public interface LopsvService {
    boolean save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    List<Lopsv> list();

    void update(Lopsv lopsv);

    void delete(String maLop);
}
