package hoang.phuong.server.service;

import hoang.phuong.server.model.Thongtingiadinh;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface ThongtingiadinhService {
    Thongtingiadinh save(Thongtingiadinh thongtingiadinh);

    Thongtingiadinh getByID(int id);

    List<Thongtingiadinh> list();

    List<Thongtingiadinh> listByIDSv(int idSv);

    boolean update(Thongtingiadinh thongtingiadinh);

    boolean delete(int id);
}
