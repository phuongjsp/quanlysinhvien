package hoang.phuong.server.dao;

import hoang.phuong.server.model.Khenthuong;

import java.util.Date;
import java.util.List;

public interface KhenThuongDAO {
    Khenthuong save(Khenthuong khenthuong);

    Khenthuong getById(int id);

    List<Khenthuong> findAll();

    List<Khenthuong> findByIdSv(int idSv);

    List<Khenthuong> findByYear(Date stdate, Date eddate);

    Khenthuong update(Khenthuong khenthuong);

    boolean delete(int id);
}
