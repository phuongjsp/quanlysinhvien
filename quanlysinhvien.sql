create table quanlysinhvien.activeuser
(
  email        varchar(100) null,
  username     varchar(50)  null,
  userLastName varchar(50)  null,
  KeyCode      varchar(100) null,
  id_active    int auto_increment
  constraint `PRIMARY`
  primary key
);

create table quanlysinhvien.diachi
(
  id        int auto_increment
  constraint `PRIMARY`
  primary key,
  tinh      varchar(50) null,
  quanHuyen varchar(50) null,
  xaPhuong  varchar(50) null,
  thonXom   varchar(50) null,
  constraint diachi__Unique
  unique (tinh, xaPhuong, quanHuyen, thonXom)
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.giaovien
(
  id          int auto_increment
  constraint `PRIMARY`
  primary key,
  maGV        varchar(50)  not null,
  TenGiaoVien varchar(125) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.giayto
(
  id        int auto_increment
  constraint `PRIMARY`
  primary key,
  tenGiayTo varchar(50) not null,
  maGiayTo  varchar(50) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.hibernate_sequence
(
  next_val bigint null
);

create table quanlysinhvien.khoa
(
  id      int auto_increment
  constraint `PRIMARY`
  primary key,
  tenKhoa varchar(50)  not null,
  maKhoa  varchar(11)  not null,
  namHoc  varchar(50)  not null,
  ghiChu  varchar(100) null,
  constraint maKhoa
  unique (maKhoa)
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.kyhoc
(
  id       int auto_increment
  constraint `PRIMARY`
  primary key,
  TenKyHoc varchar(50) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.lopsv
(
  id     int auto_increment
  constraint `PRIMARY`
  primary key,
  maLop  varchar(50)  not null,
  tenLop varchar(125) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.monhoc
(
  id        int auto_increment
  constraint `PRIMARY`
  primary key,
  tenMonHoc varchar(50) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.nganhdaotao
(
  id       int auto_increment
  constraint `PRIMARY`
  primary key,
  tenNganh varchar(50)  not null,
  maNganh  varchar(50)  not null,
  khoa     varchar(50)  not null,
  ghiChu   varchar(125) null,
  constraint maNganh
  unique (maNganh)
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.thoikhoabieu
(
  id         int auto_increment
  constraint `PRIMARY`
  primary key,
  idMonHoc   int not null,
  idKyHoc    int not null,
  idGiaoVien int not null,
  constraint thoikhoabieu_ibfk_1
  foreign key (idMonHoc) references monhoc (id),
  constraint thoikhoabieu_ibfk_2
  foreign key (idKyHoc) references kyhoc (id),
  constraint thoikhoabieu_ibfk_3
  foreign key (idGiaoVien) references giaovien (id)
)
  collate = utf8_vietnamese_ci;

create index idGiaoVien
  on quanlysinhvien.thoikhoabieu (idGiaoVien);

create index idKyHoc
  on quanlysinhvien.thoikhoabieu (idKyHoc);

create index idMonHoc
  on quanlysinhvien.thoikhoabieu (idMonHoc);

create table quanlysinhvien.thongtinsinhvien
(
  id              int auto_increment
  constraint `PRIMARY`
  primary key,
  maSV            varchar(50)     not null,
  ho              varchar(50)     not null,
  ten             varchar(50)     not null,
  ngayVaoHoc      date            null,
  khoaHoc         int             null,
  ngaySinh        date            null,
  nganhDK         int             null,
  anhThe          longtext        null,
  gioiTinh        int default '0' not null,
  danToc          varchar(50)     null,
  noiSinh         int             null,
  hoKhauThuongChu int             null,
  Lop             int             null,
  constraint maSV
  unique (maSV),
  constraint FKrc36bj8kobrmv6alfmst4e3uo
  foreign key (khoaHoc) references khoa (id),
  constraint thongtinsinhvien_ibfk_1
  foreign key (khoaHoc) references khoa (id),
  constraint FKk410beqrpno69lu8arq8k0xpw
  foreign key (nganhDK) references nganhdaotao (id),
  constraint thongtinsinhvien_ibfk_2
  foreign key (nganhDK) references nganhdaotao (id),
  constraint FKbcokpr70i096skmsrjliv74du
  foreign key (noiSinh) references diachi (id),
  constraint thongtinsinhvien_ibfk_4
  foreign key (noiSinh) references diachi (id),
  constraint FKlfse5f5pv4mwxxxgdnnbcujk2
  foreign key (hoKhauThuongChu) references diachi (id),
  constraint thongtinsinhvien_ibfk_3
  foreign key (hoKhauThuongChu) references diachi (id),
  constraint FK841av6hecea6fq74aedjuxs30
  foreign key (Lop) references lopsv (id),
  constraint thongtinsinhvien_ibfk_5
  foreign key (Lop) references lopsv (id)
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.lophocphan
(
  id       int auto_increment
  constraint `PRIMARY`
  primary key,
  idMonHoc int not null,
  idSV     int not null,
  idKyHoc  int not null,
  constraint lophocphan_ibfk_1
  foreign key (idMonHoc) references monhoc (id),
  constraint lophocphan_ibfk_2
  foreign key (idSV) references thongtinsinhvien (id),
  constraint lophocphan_ibfk_3
  foreign key (idKyHoc) references kyhoc (id)
)
  collate = utf8_vietnamese_ci;

create index idKyHoc
  on quanlysinhvien.lophocphan (idKyHoc);

create index idMonHoc
  on quanlysinhvien.lophocphan (idMonHoc);

create index idSV
  on quanlysinhvien.lophocphan (idSV);

create table quanlysinhvien.sinhviencogiayto
(
  id       int auto_increment
  constraint `PRIMARY`
  primary key,
  idSv     int      not null,
  idGiayTo int      not null,
  thongtin longtext null,
  constraint sinhviencogiayto__Unique
  unique (idSv, idGiayTo),
  constraint sinhviencogiayto_ibfk_1
  foreign key (idSv) references thongtinsinhvien (id),
  constraint sinhviencogiayto_ibfk_2
  foreign key (idGiayTo) references giayto (id)
)
  collate = utf8_vietnamese_ci;

create index idGiayTo
  on quanlysinhvien.sinhviencogiayto (idGiayTo);

create index idSv
  on quanlysinhvien.sinhviencogiayto (idSv);

create table quanlysinhvien.thongtingiadinh
(
  id         int auto_increment
  constraint `PRIMARY`
  primary key,
  idSV       int         not null,
  quanHe     varchar(50) not null,
  ten        varchar(50) not null,
  sdt        varchar(50) null,
  ngheNghiep varchar(50) null,
  constraint thongtingiadinh_ibfk_1
  foreign key (idSV) references thongtinsinhvien (id)
)
  collate = utf8_vietnamese_ci;

create index idSV
  on quanlysinhvien.thongtingiadinh (idSV);

create index Lop
  on quanlysinhvien.thongtinsinhvien (Lop);

create index hoKhauThuongChu
  on quanlysinhvien.thongtinsinhvien (hoKhauThuongChu);

create index khoaHoc
  on quanlysinhvien.thongtinsinhvien (khoaHoc);

create index nganhDK
  on quanlysinhvien.thongtinsinhvien (nganhDK);

create index noiSinh
  on quanlysinhvien.thongtinsinhvien (noiSinh);

create table quanlysinhvien.thongtinthem
(
  id          int auto_increment
  constraint `PRIMARY`
  primary key,
  idSV        int          not null,
  tenThongTin varchar(50)  not null,
  thongTin    varchar(125) not null,
  constraint FKhmkk55finucara9xc0ia1oj9j
  foreign key (idSV) references thongtinsinhvien (id),
  constraint thongtinthem_ibfk_1
  foreign key (idSV) references thongtinsinhvien (id)
)
  collate = utf8_vietnamese_ci;

create index idSV
  on quanlysinhvien.thongtinthem (idSV);

create table quanlysinhvien.users
(
  user_id        int auto_increment
  constraint `PRIMARY`
  primary key,
  user_name      varchar(50)  null,
  user_last_name varchar(50)  null,
  password       varchar(100) null,
  email          varchar(50)  null,
  enabled        tinyint(1)   null,
  is_admin       tinyint(1)   null,
  registered     date         null,
  constraint users_email_uindex
  unique (email)
);

create table quanlysinhvien.user_roles
(
  id      int auto_increment
  constraint `PRIMARY`
  primary key,
  user_id int         null,
  role    varchar(50) null,
  constraint FKhfh9dx7w3ubf1co1vdev94g3f
  foreign key (user_id) references users (user_id)
);

create index FKhfh9dx7w3ubf1co1vdev94g3f
  on quanlysinhvien.user_roles (user_id);

create table quanlysinhvien.vanbang
(
  id         int auto_increment
  constraint `PRIMARY`
  primary key,
  maVanBang  varchar(50)  not null,
  tenVanBang varchar(125) not null
)
  collate = utf8_vietnamese_ci;

create table quanlysinhvien.svcovb
(
  id           int auto_increment
  constraint `PRIMARY`
  primary key,
  idSv         int          not null,
  loaiVb       int          not null,
  tenThuocTinh varchar(50)  not null,
  thuocTinh    varchar(125) not null,
  constraint svcovb_ibfk_1
  foreign key (idSV) references thongtinsinhvien (id),
  constraint svcovb_ibfk_2
  foreign key (loaiVb) references vanbang (id)
)
  collate = utf8_vietnamese_ci;

create index idSV
  on quanlysinhvien.svcovb (idSv);

create index idVb
  on quanlysinhvien.svcovb (loaiVb);

