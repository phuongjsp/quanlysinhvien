package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtingiadinh;

import java.util.List;

public interface ThongtingiadinhDAO {
    Thongtingiadinh save(Thongtingiadinh thongtingiadinh);

    Thongtingiadinh getByID(int id);

    List<Thongtingiadinh> list();

    List<Thongtingiadinh> listByIDSv(int idSv);

    boolean update(Thongtingiadinh thongtingiadinh);

    boolean delete(int id);
}
