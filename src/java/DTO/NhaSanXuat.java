package DTO;


/**
* DTO/NhaSanXuat.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 23, 2019 9:17:11 AM ICT
*/

public final class NhaSanXuat implements org.omg.CORBA.portable.IDLEntity
{
  public int maNSX = (int)0;
  public String tenNSX = null;
  public String thongTin = null;
  public String logo = null;

  public NhaSanXuat ()
  {
  } // ctor

  public NhaSanXuat (int _maNSX, String _tenNSX, String _thongTin, String _logo)
  {
    maNSX = _maNSX;
    tenNSX = _tenNSX;
    thongTin = _thongTin;
    logo = _logo;
  } // ctor

} // class NhaSanXuat
