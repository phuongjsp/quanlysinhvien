package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "sinhviencogiayto")
public class Sinhviencogiayto {
    private int id;
    private int idSv;
    private int idGiayTo;

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
    @Column(name = "idSv")
    public int getIdSv() {
        return idSv;
    }

    public void setIdSv(int idSv) {
        this.idSv = idSv;
    }

    @Basic
    @Column(name = "idGiayTo")
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
}
