package DTO;


/**
* DTO/HoaDon.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public final class HoaDon implements org.omg.CORBA.portable.IDLEntity
{
  public int maHD = (int)0;
  public String ngayDat = null;
  public int idKhachHang = (int)0;
  public float tongTien = (float)0;
  public boolean daThanhToan = false;
  public String tenKhachHang = null;

  public HoaDon ()
  {
  } // ctor

  public HoaDon (int _maHD, String _ngayDat, int _idKhachHang, float _tongTien, boolean _daThanhToan, String _tenKhachHang)
  {
    maHD = _maHD;
    ngayDat = _ngayDat;
    idKhachHang = _idKhachHang;
    tongTien = _tongTien;
    daThanhToan = _daThanhToan;
    tenKhachHang = _tenKhachHang;
  } // ctor

} // class HoaDon
