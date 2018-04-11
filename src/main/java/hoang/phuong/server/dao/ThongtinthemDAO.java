package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinthem;

import java.util.List;

public interface ThongtinthemDAO {
    void save(Thongtinthem thongtinthem);

    Thongtinthem getByID(int id);

    List<Thongtinthem> list();

    List<Thongtinthem> listByIDSv(int idSv);

    boolean update(Thongtinthem thongtinthem);

    boolean delete(int id);
}
