package hoang.phuong.server.service;

import hoang.phuong.server.model.Khoa;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface KhoaService {
    @PreAuthorize(value = "hasRole('ROLE_ADMIN') OR" +
            " @permissionEvaluator.hasPermissionForUser(authentication, #id)")
    Khoa save(Khoa khoa);

    @PreAuthorize("hasRole('ROLE_QTV')")
    Khoa getByID(int id);

    Khoa getByMaKhoa(String maKhoa);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<Khoa> list();

    void update(Khoa khoa);

    void delete(int id);
}
