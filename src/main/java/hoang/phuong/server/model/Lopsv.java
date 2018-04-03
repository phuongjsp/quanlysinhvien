package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
public class Lopsv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maLop;
    private String tenLop;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "maLop", nullable = false, length = 50)
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Basic
    @Column(name = "tenLop", nullable = false, length = 125)
    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lopsv lopsv = (Lopsv) o;

        if (id != null ? !id.equals(lopsv.id) : lopsv.id != null) return false;
        if (maLop != null ? !maLop.equals(lopsv.maLop) : lopsv.maLop != null) return false;
        if (tenLop != null ? !tenLop.equals(lopsv.tenLop) : lopsv.tenLop != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (maLop != null ? maLop.hashCode() : 0);
        result = 31 * result + (tenLop != null ? tenLop.hashCode() : 0);
        return result;
    }


}
