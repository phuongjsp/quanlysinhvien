package hoang.phuong.server.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "khenthuong")
public class Khenthuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "idSv", nullable = false)
    private int idSv;
    @Basic
    @Column(name = "lyDo", nullable = true, length = 255)
    private String lyDo;
    @Basic
    @Column(name = "ngay", nullable = true)
    private Date ngay;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idSv", referencedColumnName = "id", insertable = false, updatable = false)
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

    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }


    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }


    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Khenthuong that = (Khenthuong) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (lyDo != null ? !lyDo.equals(that.lyDo) : that.lyDo != null) return false;
        if (ngay != null ? !ngay.equals(that.ngay) : that.ngay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (lyDo != null ? lyDo.hashCode() : 0);
        result = 31 * result + (ngay != null ? ngay.hashCode() : 0);
        return result;
    }
}
