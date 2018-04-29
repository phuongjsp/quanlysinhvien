package hoang.phuong.server.service;

import hoang.phuong.server.model.Thongtinthem;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface ThongtinthemService {
    Thongtinthem save(Thongtinthem thongtinthem);

    Thongtinthem getByID(int id);

    List<Thongtinthem> list();

    List<Thongtinthem> listByIDSv(int idSv);

    boolean update(Thongtinthem thongtinthem);

    boolean delete(int id);
}
