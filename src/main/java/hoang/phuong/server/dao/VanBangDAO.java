package hoang.phuong.server.dao;

import hoang.phuong.server.model.Vanbang;

import java.util.List;

public interface VanBangDAO {
    int save(Vanbang vanbang);
    Vanbang getbyId(int id);
    Vanbang getByMaVB(String maVB);
    List<Vanbang> list();
    void update(Vanbang vanbang);
    void delete(int id);
}
