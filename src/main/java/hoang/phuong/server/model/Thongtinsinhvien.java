package hoang.phuong.server.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "thongtinsinhvien")
public class Thongtinsinhvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String maSv;
    private String ho;
    private String ten;
    private Date ngayVaoHoc;
    private Integer khoaHoc;
    private Date ngaySinh;
    private Integer nganhDk;
    @Column(name = "anhThe", columnDefinition = "longtext")
    private String anhThe;
    private Integer gioiTinh;
    private String danToc;
    private Integer noiSinh;
    private Integer hoKhauThuongChu;
    private Integer lop;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "khoaHoc", referencedColumnName = "id", insertable = false, updatable = false)
    private Khoa khoaByKhoaHoc;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nganhDK", referencedColumnName = "id", insertable = false, updatable = false)
    private Nganhdaotao nganhdaotaoByNganhDk;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "noiSinh", referencedColumnName = "id", insertable = false, updatable = false)
    private Diachi diachiByNoiSinh;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hoKhauThuongChu", referencedColumnName = "id", insertable = false, updatable = false)
    private Diachi diachiByHoKhauThuongChu;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Lop", referencedColumnName = "id", insertable = false, updatable = false)
    private Lopsv lopsvByLop;

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayVaoHoc() {
        return ngayVaoHoc;
    }

    public void setNgayVaoHoc(Date ngayVaoHoc) {
        this.ngayVaoHoc = ngayVaoHoc;
    }

    public Integer getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(Integer khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Integer getNganhDk() {
        return nganhDk;
    }

    public void setNganhDk(Integer nganhDk) {
        this.nganhDk = nganhDk;
    }

    public String getAnhThe() {
        return anhThe;
    }

    public void setAnhThe(String anhThe) {
        this.anhThe = anhThe;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public Integer getNoiSinh() {
        return noiSinh;
    }

    public void setNoiSinh(Integer noiSinh) {
        this.noiSinh = noiSinh;
    }

    public Integer getHoKhauThuongChu() {
        return hoKhauThuongChu;
    }

    public void setHoKhauThuongChu(Integer hoKhauThuongChu) {
        this.hoKhauThuongChu = hoKhauThuongChu;
    }

    public Integer getLop() {
        return lop;
    }

    public void setLop(Integer lop) {
        this.lop = lop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thongtinsinhvien that = (Thongtinsinhvien) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (maSv != null ? !maSv.equals(that.maSv) : that.maSv != null) return false;
        if (ho != null ? !ho.equals(that.ho) : that.ho != null) return false;
        if (ten != null ? !ten.equals(that.ten) : that.ten != null) return false;
        if (ngayVaoHoc != null ? !ngayVaoHoc.equals(that.ngayVaoHoc) : that.ngayVaoHoc != null) return false;
        if (khoaHoc != null ? !khoaHoc.equals(that.khoaHoc) : that.khoaHoc != null) return false;
        if (ngaySinh != null ? !ngaySinh.equals(that.ngaySinh) : that.ngaySinh != null) return false;
        if (nganhDk != null ? !nganhDk.equals(that.nganhDk) : that.nganhDk != null) return false;
        if (anhThe != null ? !anhThe.equals(that.anhThe) : that.anhThe != null) return false;
        if (gioiTinh != null ? !gioiTinh.equals(that.gioiTinh) : that.gioiTinh != null) return false;
        if (danToc != null ? !danToc.equals(that.danToc) : that.danToc != null) return false;
        if (noiSinh != null ? !noiSinh.equals(that.noiSinh) : that.noiSinh != null) return false;
        if (hoKhauThuongChu != null ? !hoKhauThuongChu.equals(that.hoKhauThuongChu) : that.hoKhauThuongChu != null)
            return false;
        return lop != null ? lop.equals(that.lop) : that.lop == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (maSv != null ? maSv.hashCode() : 0);
        result = 31 * result + (ho != null ? ho.hashCode() : 0);
        result = 31 * result + (ten != null ? ten.hashCode() : 0);
        result = 31 * result + (ngayVaoHoc != null ? ngayVaoHoc.hashCode() : 0);
        result = 31 * result + (khoaHoc != null ? khoaHoc.hashCode() : 0);
        result = 31 * result + (ngaySinh != null ? ngaySinh.hashCode() : 0);
        result = 31 * result + (nganhDk != null ? nganhDk.hashCode() : 0);
        result = 31 * result + (anhThe != null ? anhThe.hashCode() : 0);
        result = 31 * result + (gioiTinh != null ? gioiTinh.hashCode() : 0);
        result = 31 * result + (danToc != null ? danToc.hashCode() : 0);
        result = 31 * result + (noiSinh != null ? noiSinh.hashCode() : 0);
        result = 31 * result + (hoKhauThuongChu != null ? hoKhauThuongChu.hashCode() : 0);
        result = 31 * result + (lop != null ? lop.hashCode() : 0);
        return result;
    }


    public Khoa getKhoaByKhoaHoc() {
        return khoaByKhoaHoc;
    }

    public void setKhoaByKhoaHoc(Khoa khoaByKhoaHoc) {
        this.khoaByKhoaHoc = khoaByKhoaHoc;
    }

    public Nganhdaotao getNganhdaotaoByNganhDk() {
        return nganhdaotaoByNganhDk;
    }

    public void setNganhdaotaoByNganhDk(Nganhdaotao nganhdaotaoByNganhDk) {
        this.nganhdaotaoByNganhDk = nganhdaotaoByNganhDk;
    }

    public Diachi getDiachiByNoiSinh() {
        return diachiByNoiSinh;
    }

    public void setDiachiByNoiSinh(Diachi diachiByNoiSinh) {
        this.diachiByNoiSinh = diachiByNoiSinh;
    }


    public Diachi getDiachiByHoKhauThuongChu() {
        return diachiByHoKhauThuongChu;
    }

    public void setDiachiByHoKhauThuongChu(Diachi diachiByHoKhauThuongChu) {
        this.diachiByHoKhauThuongChu = diachiByHoKhauThuongChu;
    }


    public Lopsv getLopsvByLop() {
        return lopsvByLop;
    }

    public void setLopsvByLop(Lopsv lopsvByLop) {
        this.lopsvByLop = lopsvByLop;
    }
}
