package DTO;


/**
* DTO/NhaCungCap.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public final class NhaCungCap implements org.omg.CORBA.portable.IDLEntity
{
  public int maNCC = (int)0;
  public String tenNCC = null;
  public String diaChi = null;
  public String soDT = null;
  public String email = null;

  public NhaCungCap ()
  {
  } // ctor

  public NhaCungCap (int _maNCC, String _tenNCC, String _diaChi, String _soDT, String _email)
  {
    maNCC = _maNCC;
    tenNCC = _tenNCC;
    diaChi = _diaChi;
    soDT = _soDT;
    email = _email;
  } // ctor

} // class NhaCungCap
