package hoang.phuong.server.model;

import javax.persistence.*;

@Entity
@Table(name = "nganhdaotao")
public class Nganhdaotao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenNganh;
    private String maNganh;
    private String khoa;
    private String ghiChu;

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
    @Column(name = "tenNganh", nullable = false, length = 50)
    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    @Basic
    @Column(name = "maNganh", nullable = false, length = 50)
    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    @Basic
    @Column(name = "khoa", nullable = false, length = 50)
    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    @Basic
    @Column(name = "ghiChu", nullable = true, length = 125)
    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nganhdaotao that = (Nganhdaotao) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (tenNganh != null ? !tenNganh.equals(that.tenNganh) : that.tenNganh != null) return false;
        if (maNganh != null ? !maNganh.equals(that.maNganh) : that.maNganh != null) return false;
        if (khoa != null ? !khoa.equals(that.khoa) : that.khoa != null) return false;
        if (ghiChu != null ? !ghiChu.equals(that.ghiChu) : that.ghiChu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tenNganh != null ? tenNganh.hashCode() : 0);
        result = 31 * result + (maNganh != null ? maNganh.hashCode() : 0);
        result = 31 * result + (khoa != null ? khoa.hashCode() : 0);
        result = 31 * result + (ghiChu != null ? ghiChu.hashCode() : 0);
        return result;
    }


}
