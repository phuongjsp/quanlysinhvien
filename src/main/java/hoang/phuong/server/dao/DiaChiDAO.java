package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diachi;

import java.util.List;
import java.util.Map;

public interface DiaChiDAO {
    int save(Diachi diachi);

    Diachi getByID(int id);

    List<Diachi> list();
    List<Diachi> listByProperties(Map<String,String> map);
    boolean update(Diachi diachi);

    boolean delete(int id);
}
