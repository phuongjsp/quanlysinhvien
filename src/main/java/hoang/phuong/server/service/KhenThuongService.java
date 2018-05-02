package hoang.phuong.server.service;

import hoang.phuong.server.model.Khenthuong;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Date;
import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface KhenThuongService {
    Khenthuong save(Khenthuong khenthuong);

    Khenthuong getById(int id);

    List<Khenthuong> findAll();

    List<Khenthuong> findByYear(Date stdate, Date eddate);

    List<Khenthuong> findByIdSv(int idSv);

    Khenthuong update(Khenthuong khenthuong);

    boolean delete(int id);
}
