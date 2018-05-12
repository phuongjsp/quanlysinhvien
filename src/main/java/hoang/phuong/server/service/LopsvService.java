package hoang.phuong.server.service;

import hoang.phuong.server.model.Lopsv;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface LopsvService {
    Lopsv save(Lopsv lopsv);

    Lopsv getByMaLop(String maLop);

    Lopsv getbyId(int id);

    List<Lopsv> list();

    boolean update(Lopsv lopsv);

    boolean delete(String maLop);
}
