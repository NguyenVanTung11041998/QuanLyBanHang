package DTO;


/**
* DTO/SanPham.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public final class SanPham implements org.omg.CORBA.portable.IDLEntity
{
  public int maSP = (int)0;
  public String tenSP = null;
  public float donGia = (float)0;
  public String ngayCapNhat = null;
  public String moTa = null;
  public String hinhAnh = null;
  public int soLuongTon = (int)0;
  public int maNCC = (int)0;
  public int maNSX = (int)0;
  public int maLoaiSP = (int)0;
  public boolean trangThai = false;

  public SanPham ()
  {
  } // ctor

  public SanPham (int _maSP, String _tenSP, float _donGia, String _ngayCapNhat, String _moTa, String _hinhAnh, int _soLuongTon, int _maNCC, int _maNSX, int _maLoaiSP, boolean _trangThai)
  {
    maSP = _maSP;
    tenSP = _tenSP;
    donGia = _donGia;
    ngayCapNhat = _ngayCapNhat;
    moTa = _moTa;
    hinhAnh = _hinhAnh;
    soLuongTon = _soLuongTon;
    maNCC = _maNCC;
    maNSX = _maNSX;
    maLoaiSP = _maLoaiSP;
    trangThai = _trangThai;
  } // ctor

} // class SanPham
