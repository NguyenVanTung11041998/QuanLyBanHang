package DTO;

/**
* DTO/HoaDonChiTietHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 4:26:39 PM ICT
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
