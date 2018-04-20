package hoang.phuong.server.dao;

import hoang.phuong.server.model.Giayto;

import java.util.List;

public interface GiayToDAO {
    Giayto getById(int id);

    Giayto getBymaGT(String maGT);

    Giayto save(Giayto giayto);

    boolean Update(Giayto giayto);

    boolean delete(int id);

    List<Giayto> list();
}
