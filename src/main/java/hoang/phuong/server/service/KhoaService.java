package hoang.phuong.server.service;

import hoang.phuong.server.model.Khoa;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface KhoaService {

    Khoa save(Khoa khoa);

    Khoa getByID(int id);

    Khoa getByMaKhoa(String maKhoa);

    List<Khoa> list();

    boolean update(Khoa khoa);

    boolean delete(int id);
}
