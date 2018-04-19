-- we don't know how to generate schema quanlysinhvien (class Schema) :(
create table diachi
(
	id int auto_increment
		primary key,
	tinh varchar(50) null,
	quanHuyen varchar(50) null,
	xaPhuong varchar(50) null,
	thonXom varchar(50) null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table giaovien
(
	id int auto_increment
		primary key,
	maGV varchar(50) not null,
	TenGiaoVien varchar(125) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table giayto
(
	id int auto_increment
		primary key,
	tenGiayTo varchar(50) not null,
	maGiayTo varchar(50) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table khoa
(
	id int auto_increment
		primary key,
	tenKhoa varchar(50) not null,
	maKhoa varchar(11) not null,
	namHoc varchar(50) not null,
	ghiChu text null,
	constraint maKhoa
		unique (maKhoa)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table kyhoc
(
	id int auto_increment
		primary key,
	TenKyHoc varchar(50) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table lopsv
(
	id int auto_increment
		primary key,
	maLop varchar(50) not null,
	tenLop varchar(125) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table monhoc
(
	id int auto_increment
		primary key,
	tenMonHoc varchar(50) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table nganhdaotao
(
	id int auto_increment
		primary key,
	tenNganh varchar(50) not null,
	maNganh varchar(50) not null,
	khoa varchar(50) not null,
	ghiChu varchar(125) null,
	constraint maNganh
		unique (maNganh)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table thoikhoabieu
(
	id int auto_increment
		primary key,
	idMonHoc int not null,
	idKyHoc int not null,
	idGiaoVien int not null,
	constraint thoikhoabieu_ibfk_1
		foreign key (idMonHoc) references monhoc (id),
	constraint thoikhoabieu_ibfk_2
		foreign key (idKyHoc) references kyhoc (id),
	constraint thoikhoabieu_ibfk_3
		foreign key (idGiaoVien) references giaovien (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idGiaoVien
	on thoikhoabieu (idGiaoVien)
;

create index idKyHoc
	on thoikhoabieu (idKyHoc)
;

create index idMonHoc
	on thoikhoabieu (idMonHoc)
;

create table thongtinsinhvien
(
	id int auto_increment
		primary key,
	maSV varchar(50) not null,
	ho varchar(50) not null,
	ten varchar(50) not null,
	ngayVaoHoc date null,
	khoaHoc int not null,
	ngaySinh date null,
	nganhDK int not null,
	anhThe varchar(50) null,
	gioiTinh tinyint(1) default '0' not null,
	danToc varchar(50) not null,
	noiSinh int not null,
	hoKhauThuongChu int not null,
	Lop int not null,
	constraint maSV
		unique (maSV),
	constraint thongtinsinhvien_ibfk_1
		foreign key (khoaHoc) references khoa (id),
	constraint thongtinsinhvien_ibfk_2
		foreign key (nganhDK) references nganhdaotao (id),
	constraint thongtinsinhvien_ibfk_4
		foreign key (noiSinh) references diachi (id),
	constraint thongtinsinhvien_ibfk_3
		foreign key (hoKhauThuongChu) references diachi (id),
	constraint thongtinsinhvien_ibfk_5
		foreign key (Lop) references lopsv (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table lophocphan
(
	id int auto_increment
		primary key,
	idMonHoc int not null,
	idSV int not null,
	idKyHoc int not null,
	constraint lophocphan_ibfk_1
		foreign key (idMonHoc) references monhoc (id),
	constraint lophocphan_ibfk_2
		foreign key (idSV) references thongtinsinhvien (id),
	constraint lophocphan_ibfk_3
		foreign key (idKyHoc) references kyhoc (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idKyHoc
	on lophocphan (idKyHoc)
;

create index idMonHoc
	on lophocphan (idMonHoc)
;

create index idSV
	on lophocphan (idSV)
;

create table sinhviencogiayto
(
	id int auto_increment
		primary key,
	idSv int not null,
	idGiayTo int not null,
	constraint sinhviencogiayto_ibfk_1
		foreign key (idSv) references thongtinsinhvien (id),
	constraint sinhviencogiayto_ibfk_2
		foreign key (idGiayTo) references giayto (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idGiayTo
	on sinhviencogiayto (idGiayTo)
;

create index idSv
	on sinhviencogiayto (idSv)
;

create table thongtingiadinh
(
	id int auto_increment
		primary key,
	idSV int not null,
	quanHe varchar(50) not null,
	ten varchar(50) not null,
	sdt varchar(50) null,
	ngheNghiep varchar(50) null,
	constraint thongtingiadinh_ibfk_1
		foreign key (idSV) references thongtinsinhvien (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idSV
	on thongtingiadinh (idSV)
;

create index Lop
	on thongtinsinhvien (Lop)
;

create index hoKhauThuongChu
	on thongtinsinhvien (hoKhauThuongChu)
;

create index khoaHoc
	on thongtinsinhvien (khoaHoc)
;

create index nganhDK
	on thongtinsinhvien (nganhDK)
;

create index noiSinh
	on thongtinsinhvien (noiSinh)
;

create table thongtinthem
(
	id int auto_increment
		primary key,
	idSV int not null,
	tenThongTin varchar(50) not null,
	thongTin varchar(125) not null,
	constraint thongtinthem_ibfk_1
		foreign key (idSV) references thongtinsinhvien (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idSV
	on thongtinthem (idSV)
;

create table vanbang
(
	id int auto_increment
		primary key,
	maVanBang varchar(50) not null,
	tenVanBang varchar(125) not null
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create table svcovb
(
	id int auto_increment
		primary key,
	idSv int not null,
	loaiVb int not null,
	tenThuocTinh varchar(50) not null,
	thuocTinh varchar(125) not null,
	constraint svcovb_ibfk_1
		foreign key (idSV) references thongtinsinhvien (id),
	constraint svcovb_ibfk_2
		foreign key (loaiVb) references vanbang (id)
)
engine=InnoDB collate=utf8_vietnamese_ci
;

create index idSV
	on svcovb (idSv)
;

create index idVb
	on svcovb (loaiVb)
;

