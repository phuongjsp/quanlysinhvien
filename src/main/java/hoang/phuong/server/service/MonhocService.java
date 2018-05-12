package hoang.phuong.server.service;

import hoang.phuong.server.model.Monhoc;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface MonhocService {
    Monhoc save(Monhoc monhoc);

    Monhoc update(Monhoc monhoc);

    Monhoc getById(int id);

    List<Monhoc> list();

    boolean delete(int id);

    Monhoc getbyMaMh(String maMh);
}
