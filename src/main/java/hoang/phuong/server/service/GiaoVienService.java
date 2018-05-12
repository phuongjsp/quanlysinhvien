package hoang.phuong.server.service;

import hoang.phuong.server.model.Giaovien;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface GiaoVienService {
    Giaovien save(Giaovien giaovien);

    Giaovien update(Giaovien giaovien);

    boolean delete(int id);

    Giaovien getById(int id);

    Giaovien getBymaGv(String maGv);

    List<Giaovien> list();
}
