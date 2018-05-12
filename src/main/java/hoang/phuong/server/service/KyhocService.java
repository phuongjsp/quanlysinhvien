package hoang.phuong.server.service;

import hoang.phuong.server.model.Kyhoc;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface KyhocService {
    Kyhoc save(Kyhoc kyhoc);

    Kyhoc update(Kyhoc kyhoc);

    Kyhoc getById(int id);

    List<Kyhoc> list();

    boolean delete(int id);

    Kyhoc getBymaKh(String maKh);
}
