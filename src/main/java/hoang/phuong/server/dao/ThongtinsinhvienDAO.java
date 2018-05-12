package hoang.phuong.server.dao;

import hoang.phuong.server.model.Thongtinsinhvien;

import java.util.List;
import java.util.Map;

public interface ThongtinsinhvienDAO {
    Thongtinsinhvien getByMaSV(String maSV);

    Thongtinsinhvien getById(int ID);

    List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, List<Integer> idSvDinhChi, boolean dinhChi, int min, int max);

    Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien);

    boolean update(Thongtinsinhvien thongtinsinhvien);

    boolean delete(String maSv);

    Integer getIdByMaSv(String maSv);

    List<String> checkMaSv(String maSv);

    String getMaSvById(int id);
}
