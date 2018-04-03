package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinthem;

import java.util.List;

public interface ThongtinthemDAO {
    int save(Thongtinthem thongtinthem);

    Thongtinthem getByID(int id);

    List<Thongtinthem> list();

    List<Thongtinthem> listByIDSv(int idSv);

    void update(Thongtinthem thongtinthem);

    void delete(int id);
}
