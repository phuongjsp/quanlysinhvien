package hoang.phuong.server.service;

import hoang.phuong.server.model.Diachi;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Map;

@PreAuthorize("hasRole('ROLE_USER')")
public interface DiaChiService {
    Diachi save(Diachi diachi);

    Diachi getByID(int id);

    List<Diachi> list();

    List<Diachi> listByProperties(Map<String, String> map);

    boolean update(Diachi diachi);

    boolean delete(int id);
}
