package DTO;


/**
* DTO/KhachHang.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public final class KhachHang implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String email = null;
  public String matKhau = null;
  public String hoTen = null;
  public String diaChi = null;
  public String soDT = null;

  public KhachHang ()
  {
  } // ctor

  public KhachHang (int _id, String _email, String _matKhau, String _hoTen, String _diaChi, String _soDT)
  {
    id = _id;
    email = _email;
    matKhau = _matKhau;
    hoTen = _hoTen;
    diaChi = _diaChi;
    soDT = _soDT;
  } // ctor

} // class KhachHang
