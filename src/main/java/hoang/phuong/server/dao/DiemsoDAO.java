package hoang.phuong.server.dao;

import hoang.phuong.server.model.Diemso;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface DiemsoDAO {
    Diemso save(Diemso diemso);

    Diemso update(Diemso diemso);

    Diemso getbyId(int id);

    boolean delete(int id);

    List<Diemso> listBYMultivalue(MultiValueMap<String, Object> map);
}
