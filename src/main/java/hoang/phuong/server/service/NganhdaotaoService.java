package hoang.phuong.server.service;

import hoang.phuong.server.model.Nganhdaotao;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface NganhdaotaoService {
    Nganhdaotao save(Nganhdaotao nganhDaoTao);

    Nganhdaotao getByID(int id);

    Nganhdaotao getByMaNganhdaotao(String maNganhdaotao);

    List<Nganhdaotao> list();

    boolean update(Nganhdaotao nganhdaotao);

    boolean delete(String maNganhdaotao);
}
