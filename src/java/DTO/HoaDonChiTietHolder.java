package DTO;

/**
* DTO/HoaDonChiTietHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public final class HoaDonChiTietHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.HoaDonChiTiet value = null;

  public HoaDonChiTietHolder ()
  {
  }

  public HoaDonChiTietHolder (DTO.HoaDonChiTiet initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.HoaDonChiTietHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.HoaDonChiTietHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.HoaDonChiTietHelper.type ();
  }

}
