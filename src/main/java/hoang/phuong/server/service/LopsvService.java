package hoang.phuong.server.service;

import hoang.phuong.server.model.Lopsv;

import java.util.List;

public interface LopsvService {
    Lopsv save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    List<Lopsv> list();

    boolean update(Lopsv lopsv);

    boolean delete(String maLop);
}
