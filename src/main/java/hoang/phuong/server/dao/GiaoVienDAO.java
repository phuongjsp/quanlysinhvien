package hoang.phuong.server.dao;

import hoang.phuong.server.model.Giaovien;

import java.util.List;

public interface GiaoVienDAO {
    Giaovien save(Giaovien giaovien);

    Giaovien update(Giaovien giaovien);

    boolean delete(int id);

    Giaovien getById(int id);

    Giaovien getBymaGv(String maGv);

    List<Giaovien> list();
}
