package DTO;


/**
* DTO/GioHang.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 4:26:39 PM ICT
*/

public final class GioHang implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public int idKhachHang = (int)0;
  public int maSP = (int)0;
  public int soLuongDat = (int)0;
  public boolean trangThai = false;

  public GioHang ()
  {
  } // ctor

  public GioHang (int _id, int _idKhachHang, int _maSP, int _soLuongDat, boolean _trangThai)
  {
    id = _id;
    idKhachHang = _idKhachHang;
    maSP = _maSP;
    soLuongDat = _soLuongDat;
    trangThai = _trangThai;
  } // ctor

} // class GioHang
