package hoang.phuong.server.dao;

import hoang.phuong.server.model.Kyhoc;

import java.util.List;

public interface KyhocDAO {
    Kyhoc save(Kyhoc kyhoc);

    Kyhoc update(Kyhoc kyhoc);

    Kyhoc getById(int id);

    Kyhoc getBymaKh(String maKh);

    List<Kyhoc> list();

    boolean delete(int id);
}
