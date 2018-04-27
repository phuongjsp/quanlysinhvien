package hoang.phuong.server.service;

import hoang.phuong.server.model.Thongtinsinhvien;

import java.util.List;
import java.util.Map;

public interface ThongtinsinhvienService {
    Thongtinsinhvien getByMaSV(String maSV);

    Thongtinsinhvien getById(int ID);


    Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien);

    void update(Thongtinsinhvien thongtinsinhvien);

    void delete(String maSv);

    List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max);
}
