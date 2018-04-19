package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "giaovien")
public class Giaovien {
    private int id;
    private String maGv;
    private String tenGiaoVien;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "maGV")
    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    @Basic
    @Column(name = "TenGiaoVien")
    public String getTenGiaoVien() {
        return tenGiaoVien;
    }

    public void setTenGiaoVien(String tenGiaoVien) {
        this.tenGiaoVien = tenGiaoVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Giaovien giaovien = (Giaovien) o;

        if (id != giaovien.id) return false;
        if (maGv != null ? !maGv.equals(giaovien.maGv) : giaovien.maGv != null) return false;
        if (tenGiaoVien != null ? !tenGiaoVien.equals(giaovien.tenGiaoVien) : giaovien.tenGiaoVien != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maGv != null ? maGv.hashCode() : 0);
        result = 31 * result + (tenGiaoVien != null ? tenGiaoVien.hashCode() : 0);
        return result;
    }
}
