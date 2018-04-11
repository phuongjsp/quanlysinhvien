package hoang.phuong.server.service;

import hoang.phuong.server.model.Vanbang;

import java.util.List;

public interface VanBangService {
    boolean save(Vanbang vanbang);
    Vanbang getbyId(int id);
    Vanbang getByMaVB(String maVB);
    List<Vanbang> list();
    void update(Vanbang vanbang);
    void delete(int id);
}
