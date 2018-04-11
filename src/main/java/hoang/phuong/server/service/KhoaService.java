package hoang.phuong.server.service;

import hoang.phuong.server.model.Khoa;

import java.util.List;

public interface KhoaService {
    boolean save(Khoa khoa);

    Khoa getByID(int id);

    Khoa getByMaKhoa(String maKhoa);

    List<Khoa> list();

    void update(Khoa khoa);

    void delete(int id);
}
