package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "thoikhoabieu")
public class Thoikhoabieu {
    private int id;
    private int idMonHoc;
    private int idKyHoc;
    private int idGiaoVien;

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
    @Column(name = "idMonHoc")
    public int getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(int idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    @Basic
    @Column(name = "idKyHoc")
    public int getIdKyHoc() {
        return idKyHoc;
    }

    public void setIdKyHoc(int idKyHoc) {
        this.idKyHoc = idKyHoc;
    }

    @Basic
    @Column(name = "idGiaoVien")
    public int getIdGiaoVien() {
        return idGiaoVien;
    }

    public void setIdGiaoVien(int idGiaoVien) {
        this.idGiaoVien = idGiaoVien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thoikhoabieu that = (Thoikhoabieu) o;

        if (id != that.id) return false;
        if (idMonHoc != that.idMonHoc) return false;
        if (idKyHoc != that.idKyHoc) return false;
        if (idGiaoVien != that.idGiaoVien) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idMonHoc;
        result = 31 * result + idKyHoc;
        result = 31 * result + idGiaoVien;
        return result;
    }
}
