package hoang.phuong.server.dao;

import hoang.phuong.server.model.Khoa;

import java.util.List;

public interface KhoaDAO {
    boolean save(Khoa khoa);

    Khoa getByID(int id);

    Khoa getByMaKhoa(String maKhoa);

    List<Khoa> list();

    boolean update(Khoa khoa);

    boolean delete(int id);
}
