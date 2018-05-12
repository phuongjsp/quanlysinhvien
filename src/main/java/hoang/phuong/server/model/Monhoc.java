package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "monhoc")
public class Monhoc {
    private int id;
    private String tenMonHoc;
    private String maMh;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "maMH", nullable = false, length = 20)
    public String getMaMh() {
        return maMh;
    }

    public void setMaMh(String maMH) {
        this.maMh = maMH;
    }

    @Basic
    @Column(name = "tenMonHoc", nullable = false, length = 50)
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
        return tenMonHoc != null ? tenMonHoc.equals(monhoc.tenMonHoc) : monhoc.tenMonHoc == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tenMonHoc != null ? tenMonHoc.hashCode() : 0);
        return result;
    }
}
