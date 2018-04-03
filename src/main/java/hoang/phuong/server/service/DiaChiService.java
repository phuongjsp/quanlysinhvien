package hoang.phuong.server.service;

import hoang.phuong.server.model.Diachi;

import java.util.List;

public interface DiaChiService {
    int save(Diachi diachi);

    Diachi getByID(int id);

    List<Diachi> list();

    void update(Diachi diachi);

    void delete(int id);
}
