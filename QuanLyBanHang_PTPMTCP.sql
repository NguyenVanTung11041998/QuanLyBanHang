CREATE DATABASE QuanLyBanHang_PTPMTCP
GO

USE QuanLyBanHang_PTPMTCP
GO

CREATE TABLE AccountAdmin
(
    ID INT IDENTITY PRIMARY KEY,
    TaiKhoan VARCHAR(50),
    MatKhau VARCHAR(50)
)

CREATE TABLE NhaSanXuat
(
    MaNSX INT IDENTITY PRIMARY KEY,
    TenNSX NVARCHAR(50),
    ThongTin NVARCHAR(200),
    Logo TEXT
)

CREATE TABLE NhaCungCap
(
    MaNCC INT IDENTITY PRIMARY KEY,
    TenNCC NVARCHAR(50),
    DiaChi NVARCHAR(50),
    SoDT VARCHAR(11),
    Email VARCHAR(50)
)

CREATE TABLE DanhMuc
(
    MaDanhMuc INT IDENTITY PRIMARY KEY,
    TenDanhMuc NVARCHAR(50)
)

CREATE TABLE LoaiSanPham
(
    MaLoaiSP INT IDENTITY PRIMARY KEY,
    TenLoai NVARCHAR(50),
    MaDanhMuc INT,
    CONSTRAINT FK_LoaiSanPham_DanhMuc FOREIGN KEY (MaDanhMuc) REFERENCES DanhMuc (MaDanhMuc)
)

CREATE TABLE SanPham
(
    MaSP INT IDENTITY PRIMARY KEY,
    TenSP NVARCHAR(50),
    DonGia FLOAT,
    NgayCapNhat DATE,
    MoTa NTEXT,
    HinhAnh TEXT,
    SoLuongTon INT,
    MaNCC INT,
    MaNSX INT,
    MaLoaiSP INT,
    TrangThai BIT,
    CONSTRAINT FK_SanPham_LoaiSP FOREIGN KEY (MaLoaiSP) REFERENCES LoaiSanPham (MaLoaiSP),
    CONSTRAINT FK_SanPham_NhaCungCap FOREIGN KEY (MaNCC) REFERENCES NhaCungCap (MaNCC),
    CONSTRAINT FK_SanPham_NhaSanXuat FOREIGN KEY (MaNSX) REFERENCES NhaSanXuat (MaNSX)
)

CREATE TABLE KhachHang
(
    ID INT IDENTITY PRIMARY KEY,
    Email NVARCHAR(50),
    MatKhau VARCHAR(50),
    HoTen NVARCHAR(50),
    DiaChi NVARCHAR(50),
    SoDT VARCHAR(11)
)

CREATE TABLE HoaDon
(
    MaHD INT IDENTITY PRIMARY KEY,
    NgayDat DATE,
    IDKhachHang INT,
    TongTien FLOAT DEFAULT 0,
    DaThanhToan BIT
    CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (IDKhachHang) REFERENCES KhachHang (ID)
)

CREATE TABLE HoaDonChiTiet
(
    MaHD INT,
    MaSP INT,
    SoLuongMua INT,
    DonGia FLOAT,
    CONSTRAINT FK_HoaDonChiTiet_HoaDon FOREIGN KEY (MaHD) REFERENCES HoaDon (MaHD),
    CONSTRAINT FK_HoaDonChiTiet_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP)
)

CREATE TABLE PhieuNhap
(
    MaPN INT IDENTITY PRIMARY KEY,
    NgayNhap DATE,
	TongTienNhap FLOAT
)

CREATE TABLE PhieuNhapChiTiet
(
    MaPN INT,
    MaSP INT,
    SoLuongNhap INT,
    DonGiaNhap FLOAT,
    CONSTRAINT FK_PhieuNhapChiTiet_PhieuNhap FOREIGN KEY (MaPN) REFERENCES PhieuNhap (MaPN),
    CONSTRAINT FK_PhieuNhapChiTiet_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP)
)

CREATE TABLE GioHang
(
    ID INT IDENTITY PRIMARY KEY,
    IDKhachHang INT,
    MaSP INT,
    SoLuongDat INT,
    TrangThai BIT,
    CONSTRAINT FK_GioHang_KhachHang FOREIGN KEY (IDKhachHang) REFERENCES KhachHang (ID),
    CONSTRAINT FK_GioHang_SanPham FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP)
)
GO

CREATE TRIGGER UTG_ThemPhieuNhapChiTiet ON PhieuNhapChiTiet FOR INSERT
AS BEGIN
	DECLARE @SoLuongNhap INT
	DECLARE @MaSP INT
	DECLARE @DonGiaNhap FLOAT
	DECLARE @MaPN INT
	SELECT @MaSP = MaSP, @MaPN = MaPN, @SoLuongNhap = SoLuongNhap, @DonGiaNhap = DonGiaNhap FROM Inserted
	UPDATE dbo.SanPham SET SoLuongTon += @SoLuongNhap WHERE dbo.SanPham.MaSP = @MaSP;
	UPDATE dbo.PhieuNhap SET TongTienNhap += @SoLuongNhap * @DonGiaNhap WHERE phieunhap.MaPN = @MaPN;
END
GO

CREATE TRIGGER UTG_ThemHoaDonChiTiet ON dbo.HoaDonChiTiet FOR INSERT
AS BEGIN
	DECLARE @SoLuongMua INT
	DECLARE @MaSP INT
	DECLARE @DonGia FLOAT
	DECLARE @MaHD INT
	SELECT @MaSP = MaSP, @MaHD = MaHD, @SoLuongMua = SoLuongMua, @DonGia = DonGia FROM Inserted
	UPDATE dbo.SanPham SET sanpham.SoLuongTon -= @SoLuongMua WHERE sanpham.MaSP = @MaSP
	UPDATE dbo.HoaDon SET hoadon.TongTien += @SoLuongMua * @DonGia WHERE hoadon.MaHD = @MaHD;
END
GO

INSERT INTO dbo.AccountAdmin (TaiKhoan, MatKhau ) VALUES ('tungktpm1@gmail.com', '123456')

SELECT * FROM dbo.AccountAdmin
SELECT * FROM dbo.NhaCungCap

--UPDATE dbo.HoaDon SET DaThanhToan = ~DaThanhToan WHERE MaHD = 1
SELECT * FROM dbo.DanhMuc