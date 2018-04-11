package hoang.phuong.server.dao;

import hoang.phuong.server.model.Vanbang;

import java.util.List;

public interface VanBangDAO {
    boolean save(Vanbang vanbang);
    Vanbang getbyId(int id);
    Vanbang getByMaVB(String maVB);
    List<Vanbang> list();
    boolean update(Vanbang vanbang);
    boolean delete(int id);
}
