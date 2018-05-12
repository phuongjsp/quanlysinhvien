package hoang.phuong.server.service;

import hoang.phuong.server.model.Svcovb;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface SvCoVbService {
    Svcovb save(Svcovb svcovb);

    Svcovb getById(int id);

    List<Svcovb> list();

    List<Svcovb> listByIdSv(int idSv);

    List<Svcovb> listByLoaiVB(int idLoaiVb);

    List<Svcovb> listbyIdSvAndLoaiVb(int idSv, int idLoaiVb);

    boolean update(Svcovb svcovb);

    boolean delete(int id);
}
