package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "monhoc")
public class Monhoc {
    private int id;
    private String tenMonHoc;

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
    @Column(name = "tenMonHoc")
    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Monhoc monhoc = (Monhoc) o;

        if (id != monhoc.id) return false;
        if (tenMonHoc != null ? !tenMonHoc.equals(monhoc.tenMonHoc) : monhoc.tenMonHoc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenMonHoc != null ? tenMonHoc.hashCode() : 0);
        return result;
    }
}
