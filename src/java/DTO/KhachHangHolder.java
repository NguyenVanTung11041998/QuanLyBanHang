package DTO;

/**
* DTO/KhachHangHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 9:15:49 PM ICT
*/

public final class KhachHangHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.KhachHang value = null;

  public KhachHangHolder ()
  {
  }

  public KhachHangHolder (DTO.KhachHang initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.KhachHangHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.KhachHangHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.KhachHangHelper.type ();
  }

}
