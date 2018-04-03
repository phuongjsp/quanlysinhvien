package hoang.phuong.server.dao;

import hoang.phuong.server.model.Khoa;

import java.util.List;

public interface KhoaDAO {
    int save(Khoa khoa);

    Khoa getByID(int id);

    Khoa getByMaKhoa(String maKhoa);

    List<Khoa> list();

    void update(Khoa khoa);

    void delete(String maKhoa);
}
