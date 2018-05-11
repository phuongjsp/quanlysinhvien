package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "thongtinthem")
public class Thongtinthem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idSv;
    private String tenThongTin;
    private String thongTin;
    @ManyToOne(optional = false)
    @JoinColumn(name = "idSV", referencedColumnName = "id", insertable = false, updatable = false)
    private Thongtinsinhvien thongtinsinhvien;

    public Thongtinsinhvien getThongtinsinhvien() {
        return thongtinsinhvien;
    }

    public void setThongtinsinhvien(Thongtinsinhvien thongtinsinhvien) {
        this.thongtinsinhvien = thongtinsinhvien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "idSV")
    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    @Basic
    @Column(name = "tenThongTin")
    public String getTenThongTin() {
        return tenThongTin;
    }

    public void setTenThongTin(String tenThongTin) {
        this.tenThongTin = tenThongTin;
    }

    @Basic
    @Column(name = "thongTin")
    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thongtinthem that = (Thongtinthem) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (tenThongTin != null ? !tenThongTin.equals(that.tenThongTin) : that.tenThongTin != null) return false;
        if (thongTin != null ? !thongTin.equals(that.thongTin) : that.thongTin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (tenThongTin != null ? tenThongTin.hashCode() : 0);
        result = 31 * result + (thongTin != null ? thongTin.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Thongtinthem{" +
                "id=" + id +
                ", idSv=" + idSv +
                ", tenThongTin='" + tenThongTin + '\'' +
                ", thongTin='" + thongTin + '\'' +
                ", thongtinsinhvien=" + thongtinsinhvien +
                '}';
    }
}
