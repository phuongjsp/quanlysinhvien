package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtingiadinh;

import java.util.List;

public interface ThongtingiadinhDAO {
    int save(Thongtingiadinh thongtingiadinh);

    Thongtingiadinh getByID(int id);

    List<Thongtingiadinh> list();

    List<Thongtingiadinh> listByIDSv(int idSv);

    void update(Thongtingiadinh thongtingiadinh);

    void delete(int id);
}
