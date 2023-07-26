

DROP DATABASE IF EXISTS qlkdangviet_kh;

CREATE DATABASE qlkdangviet_kh;

use qlkdangviet_kh;
go
/*==============================================================*/
/* Table: USER_ROLE                                             */
/*==============================================================*/

DROP TABLE IF EXISTS qlk_user_role;
CREATE TABLE qlk_user_role
(
	id_role INT PRIMARY KEY IDENTITY not null,
	role_name NVARCHAR(45) not null,
    role_type TINYINT not null,
    role_access BIT not null,
	
);
go
/*EXEC FK_USROLE_ADMIN qlk_admin*/

/*==============================================================*/
/* Table: ADMIN                                                 */
/*==============================================================*/
DROP TABLE IF exists qlk_admin;
CREATE TABLE qlk_admin
(
   id_admin                        INT IDENTITY not null,
   id_role                         INT not null,
   ho_admin                        NVARCHAR(25) not null,
   ten_admin                       NVARCHAR(25) not null,
   tenmaychu_admin                 VARCHAR(16) not null,
   userlog_admin                   VARCHAR(25) not null,
   pwlog_admin                     VARCHAR(15) not null,
   trangthai_admin                 BIT not null,
   id_congty					   int not null,
   PRIMARY KEY (id_admin),
   CONSTRAINT FK_USROLE_ADMIN foreign key (id_role) references qlk_user_role(id_role),
   
);
go
/*==============================================================*/
/* Table: CONGTY                                                 */
/*==============================================================*/
CREATE TABLE qlk_congty
(
	id_congty					INT IDENTITY not null,
	ten_congty					nvarchar(55)not null,
	diachi_congty				nvarchar(55) not null,
	sdt_congty					varchar(15) not null,
	email_congty				varchar(55) not null,
	id_admin					INT not null,
	primary key(id_congty),
	CONSTRAINT FK_ADMIN_CTY foreign key (id_admin) references qlk_admin(id_admin)
);
/*==============================================================*/
/* Table: DONVI                                                 */
/*==============================================================*/
CREATE TABLE qlk_donvi
(
	id_donvi					INT IDENTITY not null,
	id_congty					INT not null,
	bophan						nvarchar(55)not null, -- bo phan: kho, ke toan, ban hang
	chidinh						nvarchar(55) not null, -- chi dinh: nguoi van chuyen, ng mua hang
	primary key(id_donvi),
	CONSTRAINT FK_CTY_DV foreign key (id_congty) references qlk_congty(id_congty)
);
/*==============================================================*/
/* Table: DONVI                                                 */
/*==============================================================*/

/*==============================================================*/
/* Table: THONGBAO                                              */
/*==============================================================*/
DROP TABLE IF EXISTS qlk_thongbao;
CREATE TABLE qlk_thongbao(
	id_thongbao					   INT IDENTITY NOT NULL,
	noidung_thongbao			   nvarchar(100) not null,
	ngay_gio					   datetime NOT NULL,
	trangthai_taikhoan			   BIT not null,
	PRIMARY KEY (id_thongbao)
);
SELECT * FROM qlk_thongbao;
/*==============================================================*/
/* Table: USER                                                  */
/*==============================================================*/
DROP TABLE IF exists qlk_user;
CREATE TABLE qlk_user
(
   id_user                          INT IDENTITY not null,
   id_admin						    INT NOT NULL,
   id_role   						INT NOT NULL,
   ho_user							NVARCHAR(25) NOT NULL,
   ten_user							NVARCHAR(25) NOT NULL,
   diachi_user                      NVARCHAR(125) NOT NULL,
   sdt_user							CHAR(10) NOT NULL,
   tenmaychu_user                   CHAR(16) NOT NULL,
   userlog_user                     VARCHAR(25) NOT NULL,
   pwlogin_user                     VARCHAR(16) NOT NULL,
   trangthai_user                   BIT NOT NULL,
   PRIMARY KEY (id_user),
   CONSTRAINT FK_ADMIN_USER foreign key (id_admin) references qlk_admin(id_admin),
   CONSTRAINT FK_USER_ROLE foreign key (id_role) references qlk_user_role(id_role)
);

/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/
DROP TABLE IF EXISTS qlk_khachhang;
CREATE TABLE qlk_khachhang
(
   id_khachhang                     INT IDENTITY not null,
   maso_khachhang					VARCHAR(20) not null,
   ho_khachhang                     NVARCHAR(45) not null,
   ten_khachhang                    NVARCHAR(25) not null,
   diachi_khachhang				    NVARCHAR(125) not null,
   email_khachhang					VARCHAR(125) not null,
   tengiaodich			            CHAR(25) not null,
   sdt_khachhang                    CHAR(10) not null,
   stk_nganhang						CHAR(15) null,
   ten_nganhang						NVARCHAR(125) null,
   fax_khachhang                    CHAR(10),
   primary key (id_khachhang)
);
SELECT * FROM qlk_khachhang
/*==============================================================*/
/* Table: NHACUNGCAP                                            */
/*==============================================================*/
DROP TABLE IF EXISTS qlk_nhacungcap;
CREATE TABLE qlk_nhacungcap
(
   id_ncc                          INT IDENTITY not null,
   ten_ncc	                       NVARCHAR(55) not null,
   ten_daidien					   NVARCHAR(45) not null,
   diachi_ncc                      NVARCHAR(125) not null,
   sdt_ncc						   VARCHAR(10),
   fax_ncc						   VARCHAR(15),
   email_ncc					   varchar(100),
   primary key(id_ncc)
);

DROP TABLE IF EXISTS qlk_nhomhanghoa;
create table qlk_nhomhanghoa(
	id_nhomhh						int not null,
	ma_nhomhh						varchar(25) not null,
	ten_nhomhh						varchar(100) not null,
	soluong_nhomhh					int not null,-- so luong trong nhom hang hoa
	primary key (id_nhomhh)
)
/*==============================================================*/
/* Table: HANGHOA                                               */
/*==============================================================*/
DROP TABLE IF exists qlk_hanghoa;
CREATE TABLE qlk_hanghoa
(
   id_hanghoa                      INT IDENTITY  not null,
   ma_hanghoa					   varchar(55) not null,
   ten_hanghoa                     NVARCHAR(55) not null,
   ma_sanxuat					   CHAR(20) not null,
   donvitinh                       CHAR(10) not null,
   kich_thuoc					   decimal not null,
   dodai_hanghoa				   decimal not null,
   quy_cach_hanghoa				   decimal not null,
   dongia_banra 				   smallmoney not null,
   dongia_von					   smallmoney not null,
   id_nhomhh                       int not null,
   primary key (id_hanghoa),
   CONSTRAINT FK_NHOMHANG_HANGHOA foreign key(id_nhomhh) references qlk_nhomhanghoa(id_nhomhh)
);
/*==============================================================*/
/* Table: DONHANG                                               */
/*==============================================================*/
DROP TABLE IF exists qlk_donhang;
CREATE TABLE qlk_donhang
(
   id_donhang                   	INT IDENTITY NOT NULL,
   maso_donhang						CHAR(20) not null,
   ngaylap_donhang                  DATETIME NOT NULL,
   soluong  		                INT NOT NULL,
   thanhtien						money NOT NULL,
   phuongthuc_thanhtoan				VARCHAR(25) NOT NULL,
   ghichu_donhang                   NVARCHAR(100) NOT NULL,
   trangthai						bit,
   id_user							INT NOT NULL,
   id_khachhang                     INT NOT NULL,
   id_hanghoa						INT NOT NULL,
   primary key (id_donhang),
   CONSTRAINT FK_KH_DH foreign key(id_khachhang) references qlk_khachhang(id_khachhang)
);
/*==============================================================*/
/* Table: DONHANG                                               */
/*==============================================================*/
DROP TABLE IF exists qlk_chitiet_donhang;
CREATE TABLE qlk_chitiet_donhang
(
   id_chitiet_dh                   	INT IDENTITY NOT NULL,
   soluong  		                INT NOT NULL,
   tongtien 						money NOT NULL,
   phuongthuc_thanhtoan				VARCHAR(25) NOT NULL,
   ngaylap_donhang                  DATETIME NOT NULL,
   ghichu_donhang                   NVARCHAR(100) NOT NULL,
   id_donhang						INT NOT NULL,
   primary key (id_chitiet_dh),
   CONSTRAINT FK_KH_DH foreign key(id_donhang) references qlk_donhang(id_donhang)
);

/*==============================================================*/
/* Table: PHIEU KIEM KE kHO                                     */
/*==============================================================*/
CREATE TABLE qlk_kk_kho
(
	id_kk_kho						INT IDENTITY not null,
	ngay_kk_kho						datetime not null,
	soluong_trongkho				int not null,
	id_hanghoa						int not null,
	id_user							int not null,
	primary key(id_kk_kho),
	CONSTRAINT FK_KHO_HH foreign key(id_hanghoa) references qlk_hanghoa(id_hanghoa)
);
/*==============================================================*/
/* Table: PHIEUXUATHANG                                         */
/*==============================================================*/
DROP TABLE IF exists qlk_phieuxuathang;
CREATE TABLE qlk_phieuxuathang
(
   id_phieuxuathang                 INT IDENTITY NOT NULL,
   ma_phieuxuathang					varchar(55) NOT NULL,
   tennguoi_nhan					varchar(55) NOT NULL,
   nguoi_van_chuyen					varchar(55) NOT NULL,
   xuattai_kho						varchar(55),
   soluong_sp						int not null, -- bang voi so luong cua don hang
   ngay_lap_phieu                   datetime NOT NULL,
   ngay_xuathang                    datetime NOT NULL,
   trangthai_pxh                    BIT,
   ghichu							varchar(255),
   id_donhang						INT NOT NULL,
   id_user							INT NOT NULL,
   primary key(id_phieuxuathang),
);
CREATE TABLE qlk_kk_phieuxuathang
(
	id_kk_pxh						int identity not null,
	soluong_sp						int not null,
	ngay_kk_pxh						datetime not null,
	id_phieuxuathang				int not null,
	primary key(id_kk_pxh)
);
/*==============================================================*/
/* Table: HANGTON                                               */
/*==============================================================*/
DROP TABLE IF EXISTS qlk_hangton;
CREATE TABLE qlk_hangton
(
   id_hangton                       INT IDENTITY NOT NULL,
   id_hanghoa                       INT NOT NULL,
   soluong_thucte					INT not null,
   nhap_hangton                     INT NOT NULL,
   dinhmuc_hangton					int, -- dung de so sanh ve soluong ton kho, neu nho hoac bang dinhmuc thi se canh bao
   primary key (id_hangton),
   CONSTRAINT FK_HH_HANGTON foreign key(id_hanghoa) references qlk_hanghoa(id_hanghoa)
);
/*==============================================================*/
/* Table: DONDATHANG                                            */
/*==============================================================*/
DROP TABLE IF exists qlk_donmuahang;
CREATE TABLE qlk_donmuahang
(
   id_donmuahang               		INT IDENTITY       not null,
   ma_phieumuahang					varchar(55) not null,
   ten_phieumuahang					varchar(55) not null,
   nguoimuahang 					NVARCHAR(25),
   ngay         	                DATETIME NOT NULL,
   soluong                          INT NOT NULL, -- tong so luong cac hang hoa
   tinhtrang_ddh					BIT,
   id_hanghoa                       INT NOT NULL,
   primary key (id_donmuahang),
   CONSTRAINT FK_HH_DDH foreign key(id_hanghoa) references qlk_hanghoa(id_hanghoa)
);

/*==============================================================*/
/* Table: PHIEUNHAPHANG                                         */
/*==============================================================*/
DROP TABLE IF exists qlk_phieunhaphang;
create table qlk_phieunhaphang
(
   id_phieunhaphang                          INT IDENTITY not null,
   id_ncc									 int not null,
   ngay_lap_pnh                              datetime not null,
   sotien_nhaphang                           float,
   diachi_kho                                nvarchar(125),
   primary key (id_phieunhaphang)
);
/*==============================================================*/
/* Table: TRANGTHAI                                            */
/*==============================================================*/
DROP TABLE IF exists qlk_trangthai;
CREATE TABLE qlk_trangthai
(
	id_trangthai					INT 		not null,
	ten_trangthai					VARCHAR(25) not null,
	kichhoat                        TINYINT not null, -- Moi, Dang Xu Ly, Hoan Thanh
   primary key (id_trangthai)
);
/*==============================================================*/
/* Table: USER_PHIEU                                            */
/*==============================================================*/
DROP TABLE IF exists qlk_phieu;
CREATE TABLE qlk_phieu
(
	id_phieu					INT 		not null,
	loai_phieu					VARCHAR	(25) not null,
   primary key (id_phieu)
);

/*==============================================================*/
/* Table: PHITHANHTOAN                                          */
/*==============================================================*/
DROP TABLE IF exists qlk_phithanhtoan;
CREATE TABLE qlk_phithanhtoan
(
   id_phithanhtoan                  INT IDENTITY not null,
   id_phieunhaphang                 INT not null,
   phi_thanh_toan                   FLOAT not null,
   ngay_thanhtoan                   DATETIME not null,
   han_thanhtoan                    DATETIME not null,
   ghichu_thanhtoan                 NVARCHAR(125) not null,
   primary key (id_phithanhtoan),
   CONSTRAINT FK_PNH_PTT foreign key(id_phieunhaphang) references qlk_phieunhaphang(id_phieunhaphang)
);

INSERT INTO qlk_user_role (role_name,role_type,role_access) VALUES('Admin',1,1);
INSERT INTO qlk_user_role (role_name,role_type,role_access) VALUES('User',2,1);

INSERT INTO qlk_phieu (id_phieu,loai_phieu) values(1,'Xuat');
INSERT INTO qlk_phieu (id_phieu,loai_phieu) values(2,'Nhap');
INSERT INTO qlk_phieu (id_phieu,loai_phieu) values(3,'Mua Hang');

INSERT INTO qlk_trangthai (id_trangthai,ten_trangthai,kichhoat) values(1,'Moi',1);
INSERT INTO qlk_trangthai (id_trangthai,ten_trangthai,kichhoat) values(2,'Dang Xu Ly',2);
INSERT INTO qlk_trangthai (id_trangthai,ten_trangthai,kichhoat) values(3,'Hoan Thanh',3);

INSERT INTO qlk_admin VALUES(1,'Huynh','Tuan Kiet','192.168.2.1','admin','admin',0);
INSERT INTO qlk_admin VALUES(1,'Huynh','Tuan Kiet','192.168.2.1','admin2','admin2',0);

INSERT INTO qlk_user VALUES(1,2,'Huynh','Tuan Kiet','82 Binh Long, Phu Thanh, Tan Phu, TP HCM','0967445591','IT','IT','192.168.2.2','user','user',0);
INSERT INTO qlk_user VALUES(2,2,'Huynh','Van B','83 Binh Long, Phu Thanh, Tan Phu, TP HCM','096744444','IT','IT','192.168.2.3','user2','user2',0);

INSERT INTO qlk_khachhang(maso_khachhang,ho_khachhang,ten_khachhang,diachi_khachhang,email_khachhang,tengiaodich,sdt_khachhang,stk_nganhang,ten_nganhang,fax_khachhang) 
VALUES('KH-002','Huynh Tuan','Kiet','82 Binh Long, Phu Thanh, Tan Phu, TP Ho Chi Minh','tuan.kiet9616@gmail.com','KH-CK','0967445591','18477567','ACB Bank',null);

select * from qlk_khachhang where qlk_khachhang.maso_khachhang = 'KH-002' or qlk_khachhang.ho_khachhang='KH-002' or qlk_khachhang.ten_khachhang = 'KH-002';

UPDATE qlk_khachhang
SET id_khachhang = 2 where maso_khachhang='KH-002';
select * from qlk_khachhang;
--UPDATE qlk_user
--SET id_role = 2;

SELECT * FROM qlk_admin where userlog_admin = 'admin1' AND pwlog_admin = 'admin1';

select * from qlk_admin,qlk_user_role where qlk_admin.id_role = 1;

SELECT * FROM qlk_user_role,qlk_admin,qlk_user where role_name = 'Admin'
INSERT INTO qlk_thongbao (noidung_thongbao,ngay_gio,trangthai_taikhoan) VALUES('DANG NHAP',CONVERT(datetime,'2023-06-06 03:43:49.049 PM'),1);
SELECT CONVERT(datetime,'2023-14-06 09:14:20',103);

SELECT ROW_NUMBER() OVER (ORDER BY ngay_gio) AS[STT],noidung_thongbao,ngay_gio,trangthai_taikhoan from qlk_thongbao;

select * from qlk_admin;
select * from qlk_user;
select * from qlk_thongbao;
select * from qlk_user_role;
DELETE FROM qlk_thongbao where qlk_thongbao.id_thongbao = 3;
insert into qlk_nhacungcap(id_ncc,ten_ncc,diachi_ncc) values();
insert into qlk_nhomHangHoa(idNhomHH,tenNhomHH,donvitinh_hanghoa) values();
insert into qlk_hanghoa(id_hanghoa,nhom_hanghoa,ten_hanghoa,ma_sanxuat,kich_thuoc,do_dai_hanghoa,quy_cach_hanghoa,giaban_hanghoa) values
--SELECT HOST_NAME() AS sa, SUSER_NAME() LoggedInUser

--SELECT SYSTEM_USER;

--SELECT USER_NAME();

--SELECT IS_SRVROLEMEMBER('public');

--SELECT IS_SRVROLEMEMBER('sysadmin');

--SELECT * FROM sys.servers ;
--SELECT * FROM sys.linked_logins;
--SELECT * FROM  sys.server_permissions;
--SELECT * FROM sys.dm_exec_requests;

--SELECT *
--FROM sys.dm_exec_connections;

--SELECT  
--   CONNECTIONPROPERTY('net_transport') AS net_transport,
--   CONNECTIONPROPERTY('protocol_type') AS protocol_type,
--   CONNECTIONPROPERTY('auth_scheme') AS auth_scheme,
--   CONNECTIONPROPERTY('local_net_address') AS local_net_address,
--   CONNECTIONPROPERTY('local_tcp_port') AS local_tcp_port,
--   CONNECTIONPROPERTY('client_net_address') AS client_net_address 

--   SELECT @@SERVERNAME;

