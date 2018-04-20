package hoang.phuong.server.service;

import hoang.phuong.server.model.Sinhviencogiayto;

import java.util.List;

public interface SinhviencogiaytoService {
    Sinhviencogiayto getbyId(int id);

    Sinhviencogiayto save(Sinhviencogiayto sinhviencogiayto);

    boolean update(Sinhviencogiayto sinhviencogiayto);

    boolean delete(int id);

    List<Sinhviencogiayto> list();

    List<Sinhviencogiayto> listByIdSv(int idSv);
}
