package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "thongtingiadinh")
public class Thongtingiadinh {
    private int id;
    private int idSv;
    private String quanHe;
    private String ten;
    private String sdt;
    private String ngheNghiep;

    //    @ManyToOne(optional = false)
//    @JoinColumn(name = "idSV", referencedColumnName = "id", insertable = false, updatable = false)
//    private Thongtinsinhvien thongtinsinhvien;
//
//    public Thongtinsinhvien getThongtinsinhvien() {
//        return thongtinsinhvien;
//    }
//
//    public void setThongtinsinhvien(Thongtinsinhvien thongtinsinhvien) {
//        this.thongtinsinhvien = thongtinsinhvien;
//    }
    @Id
    @Column(name = "id")
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
    @Column(name = "quanHe")
    public String getQuanHe() {
        return quanHe;
    }

    public void setQuanHe(String quanHe) {
        this.quanHe = quanHe;
    }

    @Basic
    @Column(name = "ten")
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Basic
    @Column(name = "sdt")
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    @Basic
    @Column(name = "ngheNghiep")
    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thongtingiadinh that = (Thongtingiadinh) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (quanHe != null ? !quanHe.equals(that.quanHe) : that.quanHe != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (sdt != null ? !sdt.equals(that.sdt) : that.sdt != null) return false;
        return ngheNghiep != null ? ngheNghiep.equals(that.ngheNghiep) : that.ngheNghiep == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (quanHe != null ? quanHe.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (sdt != null ? sdt.hashCode() : 0);
        result = 31 * result + (ngheNghiep != null ? ngheNghiep.hashCode() : 0);
        return result;
    }
}
