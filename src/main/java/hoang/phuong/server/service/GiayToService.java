package hoang.phuong.server.service;

import hoang.phuong.server.model.Giayto;

import java.util.List;

public interface GiayToService {
    Giayto getById(int id);

    Giayto save(Giayto giayto);

    boolean Update(Giayto giayto);

    boolean delete(int id);

    List<Giayto> list();

    Giayto getBymaGT(String maGT);
}
