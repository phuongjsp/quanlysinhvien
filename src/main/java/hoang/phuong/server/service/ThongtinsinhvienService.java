package hoang.phuong.server.service;

import hoang.phuong.server.model.Thongtinsinhvien;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;
import java.util.Map;

@PreAuthorize("hasRole('ROLE_USER')")
public interface ThongtinsinhvienService {
    Thongtinsinhvien getByMaSV(String maSV);

    Thongtinsinhvien getById(int ID);


    Thongtinsinhvien save(Thongtinsinhvien thongtinsinhvien);

    boolean update(Thongtinsinhvien thongtinsinhvien);

    boolean delete(String maSv);

    List<Thongtinsinhvien> listOrderBy(List<Map<String, Object>> mapOrder, int min, int max);

    List<Thongtinsinhvien> listBiDinhChiOrderBy(List<Map<String, Object>> mapOrder, int min, int max);

    Integer getIdByMaSv(String maSv);

    List<String> checkMaSv(String maSv);

    String getMaSvById(int id);
}
