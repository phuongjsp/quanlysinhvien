package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "sinhviencogiayto")
public class Sinhviencogiayto {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idSv;
    private int idGiayTo;
    @Column(name = "thongtin", columnDefinition = "longtext")
    private String thongtin;


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

    public int getIdGiayTo() {
        return idGiayTo;
    }

    public void setIdGiayTo(int idGiayTo) {
        this.idGiayTo = idGiayTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sinhviencogiayto that = (Sinhviencogiayto) o;

        if (id != that.id) return false;
        if (idSv != that.idSv) return false;
        if (idGiayTo != that.idGiayTo) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + idSv;
        result = 31 * result + idGiayTo;
        return result;
    }


    public String getThongtin() {
        return thongtin;
    }

    public void setThongtin(String thongtin) {
        this.thongtin = thongtin;
    }
}
