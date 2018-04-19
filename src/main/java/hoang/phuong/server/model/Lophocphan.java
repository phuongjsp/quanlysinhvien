package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "lophocphan")
public class Lophocphan {
    private int id;
    private int idMonHoc;
    private int idSv;
    private int idKyHoc;

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
    @Column(name = "idSV")
    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    @Basic
    @Column(name = "idKyHoc")
    public int getIdKyHoc() {
        return idKyHoc;
    }

    public void setIdKyHoc(int idKyHoc) {
        this.idKyHoc = idKyHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lophocphan that = (Lophocphan) o;

        if (id != that.id) return false;
        if (idMonHoc != that.idMonHoc) return false;
        if (idSv != that.idSv) return false;
        if (idKyHoc != that.idKyHoc) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idMonHoc;
        result = 31 * result + idSv;
        result = 31 * result + idKyHoc;
        return result;
    }
}
