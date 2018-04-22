package hoang.phuong.server.dao;

import hoang.phuong.server.model.Svcovb;

import java.util.List;

public interface SvCoVbDAO {
    Svcovb save(Svcovb svcovb);
    Svcovb getById(int id);
    List<Svcovb> list();
    List<Svcovb> listByIdSv(int idSv);
    List<Svcovb> listByLoaiVB(int idLoaiVb);
    List<Svcovb> listbyIdSvAndLoaiVb(int idSv,int idLoaiVb);
    boolean update(Svcovb svcovb);
    boolean delete(int id);
}
