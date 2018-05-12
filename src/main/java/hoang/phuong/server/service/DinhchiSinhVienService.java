package hoang.phuong.server.service;

import hoang.phuong.server.model.Dinhchisinhvien;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")
public interface DinhchiSinhVienService {
    Dinhchisinhvien save(Dinhchisinhvien dinhchisinhvien);

    List<Dinhchisinhvien> findAll();

    List<Dinhchisinhvien> listConDinhChi();

    Dinhchisinhvien getOne(int id);

    Dinhchisinhvien update(Dinhchisinhvien dinhchisinhvien);

    boolean delete(int id);
}
