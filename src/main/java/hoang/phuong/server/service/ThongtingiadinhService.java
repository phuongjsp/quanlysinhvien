package hoang.phuong.server.service;

import hoang.phuong.server.model.Thongtingiadinh;

import java.util.List;

public interface ThongtingiadinhService {
    int save(Thongtingiadinh thongtingiadinh);

    Thongtingiadinh getByID(int id);

    List<Thongtingiadinh> list();

    List<Thongtingiadinh> listByIDSv(int idSv);

    void update(Thongtingiadinh thongtingiadinh);

    void delete(int id);
}
