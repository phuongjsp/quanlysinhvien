package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
public class Khoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenKhoa;
    private String maKhoa;
    private String namHoc;
    private String ghiChu;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tenKhoa", nullable = false, length = 50)
    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Basic
    @Column(name = "maKhoa", nullable = false, length = 11)
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    @Basic
    @Column(name = "namHoc", nullable = false, length = 50)
    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    @Basic
    @Column(name = "ghiChu", nullable = true, length = -1)
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Khoa khoa = (Khoa) o;

        if (id != null ? !id.equals(khoa.id) : khoa.id != null) return false;
        if (tenKhoa != null ? !tenKhoa.equals(khoa.tenKhoa) : khoa.tenKhoa != null) return false;
        if (maKhoa != null ? !maKhoa.equals(khoa.maKhoa) : khoa.maKhoa != null) return false;
        if (namHoc != null ? !namHoc.equals(khoa.namHoc) : khoa.namHoc != null) return false;
        if (ghiChu != null ? !ghiChu.equals(khoa.ghiChu) : khoa.ghiChu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tenKhoa != null ? tenKhoa.hashCode() : 0);
        result = 31 * result + (maKhoa != null ? maKhoa.hashCode() : 0);
        result = 31 * result + (namHoc != null ? namHoc.hashCode() : 0);
        result = 31 * result + (ghiChu != null ? ghiChu.hashCode() : 0);
        return result;
    }

}
