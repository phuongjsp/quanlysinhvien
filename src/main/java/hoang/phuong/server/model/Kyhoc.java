package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "kyhoc")
public class Kyhoc {
    private int id;
    private String tenKyHoc;
    private String namHoc;
    private String maKh;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TenKyHoc", nullable = false, length = 50)
    public String getTenKyHoc() {
        return tenKyHoc;
    }

    public void setTenKyHoc(String tenKyHoc) {
        this.tenKyHoc = tenKyHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kyhoc kyhoc = (Kyhoc) o;

        if (id != kyhoc.id) return false;
        return tenKyHoc != null ? tenKyHoc.equals(kyhoc.tenKyHoc) : kyhoc.tenKyHoc == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenKyHoc != null ? tenKyHoc.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "namHoc", length = 50)
    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    @Basic
    @Column(name = "maKh", length = 20)
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }
}
