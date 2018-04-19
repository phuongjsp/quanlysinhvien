package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "kyhoc")
public class Kyhoc {
    private int id;
    private String tenKyHoc;

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
    @Column(name = "TenKyHoc")
    public String getTenKyHoc() {
        return tenKyHoc;
    }

    public void setTenKyHoc(String tenKyHoc) {
        this.tenKyHoc = tenKyHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Kyhoc kyhoc = (Kyhoc) o;

        if (id != kyhoc.id) return false;
        if (tenKyHoc != null ? !tenKyHoc.equals(kyhoc.tenKyHoc) : kyhoc.tenKyHoc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenKyHoc != null ? tenKyHoc.hashCode() : 0);
        return result;
    }
}
