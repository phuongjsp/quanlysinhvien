package hoang.phuong.server.dao;

import hoang.phuong.server.model.Monhoc;

import java.util.List;

public interface MonhocDAO {
    Monhoc save(Monhoc monhoc);

    Monhoc update(Monhoc monhoc);

    Monhoc getById(int id);

    Monhoc getbyMaMh(String maMh);

    List<Monhoc> list();

    boolean delete(int id);
}
