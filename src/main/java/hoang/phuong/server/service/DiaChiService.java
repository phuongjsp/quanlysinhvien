package hoang.phuong.server.service;

import hoang.phuong.server.model.Diachi;

import java.util.List;
import java.util.Map;

public interface DiaChiService {
    Diachi save(Diachi diachi);

    Diachi getByID(int id);

    List<Diachi> list();
    List<Diachi> listByProperties(Map<String,String> map);
    void update(Diachi diachi);

    void delete(int id);
}
