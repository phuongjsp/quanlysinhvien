package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diachi;

import java.util.List;

public interface DiaChiDAO {
    int save(Diachi diachi);

    Diachi getByID(int id);

    List<Diachi> list();

    boolean update(Diachi diachi);

    boolean delete(int id);
}
