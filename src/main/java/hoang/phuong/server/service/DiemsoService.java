package hoang.phuong.server.service;

import hoang.phuong.server.model.Diemso;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;

import java.util.List;

@PreAuthorize("hasRole('ROLE_USER')")//TODO How to set role for other teacher
public interface DiemsoService {
    Diemso save(Diemso diemso);

    Diemso update(Diemso diemso);

    Diemso getbyId(int id);

    boolean delete(int id);

    List<Diemso> listBYMultivalue(MultiValueMap<String, Object> map);
}
