package hoang.phuong.server.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "diemso")
public class Diemso {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idMonHoc;
    private int idKyHoc;
    private int idSv;
    private String loaiDiem;
    private float diem;
    private Timestamp ngayThem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idMonHoc", nullable = false)
    public int getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    @Basic
    @Column(name = "idKyHoc", nullable = false)
    public int getIdKyHoc() {
        return idKyHoc;
    }

    public void setIdKyHoc(int idKyHoc) {
        this.idKyHoc = idKyHoc;
    }

    @Basic
    @Column(name = "idSv", nullable = false)
    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    @Basic
    @Column(name = "loaiDiem", length = 50)
    public String getLoaiDiem() {
        return loaiDiem;
    }

    public void setLoaiDiem(String loaiDiem) {
        this.loaiDiem = loaiDiem;
    }

    @Basic
    @Column(name = "diem", length = 10)
    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    @Basic
    @Column(name = "ngayThem")
    public Timestamp getNgayThem() {
        return ngayThem;
    }

    public void setNgayThem(Timestamp ngayThem) {
        this.ngayThem = ngayThem;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diemso)) return false;

        Diemso diemso = (Diemso) o;

        if (getId() != diemso.getId()) return false;
        if (getIdMonHoc() != diemso.getIdMonHoc()) return false;
        if (getIdKyHoc() != diemso.getIdKyHoc()) return false;
        if (getIdSv() != diemso.getIdSv()) return false;
        if (Float.compare(diemso.getDiem(), getDiem()) != 0) return false;
        return getLoaiDiem() != null ? getLoaiDiem().equals(diemso.getLoaiDiem()) : diemso.getLoaiDiem() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getIdMonHoc();
        result = 31 * result + getIdKyHoc();
        result = 31 * result + getIdSv();
        result = 31 * result + (getLoaiDiem() != null ? getLoaiDiem().hashCode() : 0);
        result = 31 * result + (getDiem() != +0.0f ? Float.floatToIntBits(getDiem()) : 0);
        return result;
    }
}
