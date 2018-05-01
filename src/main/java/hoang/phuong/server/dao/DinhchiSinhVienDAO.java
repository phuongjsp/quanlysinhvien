package hoang.phuong.server.dao;

import hoang.phuong.server.model.Dinhchisinhvien;

import java.util.List;

public interface DinhchiSinhVienDAO {
    Dinhchisinhvien save(Dinhchisinhvien dinhchisinhvien);

    List<Dinhchisinhvien> findAll();

    Dinhchisinhvien getOne(int id);

    Dinhchisinhvien update(Dinhchisinhvien dinhchisinhvien);

    boolean delete(int id);
}
