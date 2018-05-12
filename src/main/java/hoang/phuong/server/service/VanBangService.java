package hoang.phuong.server.service;

import hoang.phuong.server.model.Vanbang;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface VanBangService {
    Vanbang save(Vanbang vanbang);

    Vanbang getbyId(int id);

    Vanbang getByMaVB(String maVB);

    List<Vanbang> list();

    boolean update(Vanbang vanbang);

    boolean delete(int id);
}
