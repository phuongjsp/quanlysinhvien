package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "giayto")
public class Giayto {
    private int id;
    private String tenGiayTo;
    private String maGiayTo;

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
    @Column(name = "tenGiayTo")
    public String getTenGiayTo() {
        return tenGiayTo;
    }

    public void setTenGiayTo(String tenGiayTo) {
        this.tenGiayTo = tenGiayTo;
    }

    @Basic
    @Column(name = "maGiayTo")
    public String getMaGiayTo() {
        return maGiayTo;
    }

    public void setMaGiayTo(String maGiayTo) {
        this.maGiayTo = maGiayTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Giayto giayto = (Giayto) o;

        if (id != giayto.id) return false;
        if (tenGiayTo != null ? !tenGiayTo.equals(giayto.tenGiayTo) : giayto.tenGiayTo != null) return false;
        if (maGiayTo != null ? !maGiayTo.equals(giayto.maGiayTo) : giayto.maGiayTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenGiayTo != null ? tenGiayTo.hashCode() : 0);
        result = 31 * result + (maGiayTo != null ? maGiayTo.hashCode() : 0);
        return result;
    }
}
