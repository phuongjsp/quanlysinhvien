package hoang.phuong.server.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Dinhchisinhvien {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "idSv", nullable = false)
    private int idSv;

    @Basic
    @Column(name = "lyDo", nullable = true, length = 255)
    private String lyDo;

    @Basic
    @Column(name = "tuNgay", nullable = true)
    private Date tuNgay;

    @Basic
    @Column(name = "denNgay", nullable = true)
    private Date denNgay;


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

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dinhchisinhvien that = (Dinhchisinhvien) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (lyDo != null ? !lyDo.equals(that.lyDo) : that.lyDo != null) return false;
        if (tuNgay != null ? !tuNgay.equals(that.tuNgay) : that.tuNgay != null) return false;
        if (denNgay != null ? !denNgay.equals(that.denNgay) : that.denNgay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + (lyDo != null ? lyDo.hashCode() : 0);
        result = 31 * result + (tuNgay != null ? tuNgay.hashCode() : 0);
        result = 31 * result + (denNgay != null ? denNgay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dinhchisinhvien{" +
                "id=" + id +
                ", idSv=" + idSv +
                ", lyDo='" + lyDo + '\'' +
                ", tuNgay=" + tuNgay +
                ", denNgay=" + denNgay +
                '}';
    }
}
