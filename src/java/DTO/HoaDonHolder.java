package DTO;

/**
* DTO/HoaDonHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public final class HoaDonHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.HoaDon value = null;

  public HoaDonHolder ()
  {
  }

  public HoaDonHolder (DTO.HoaDon initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.HoaDonHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.HoaDonHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.HoaDonHelper.type ();
  }

}
