package hoang.phuong.server.service;

import hoang.phuong.server.model.Vanbang;

import java.util.List;

public interface VanBangService {
    Vanbang save(Vanbang vanbang);
    Vanbang getbyId(int id);
    Vanbang getByMaVB(String maVB);
    List<Vanbang> list();

    boolean update(Vanbang vanbang);

    boolean delete(int id);
}
