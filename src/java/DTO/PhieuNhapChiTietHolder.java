package DTO;

/**
* DTO/PhieuNhapChiTietHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 23, 2019 9:17:11 AM ICT
*/

public final class PhieuNhapChiTietHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.PhieuNhapChiTiet value = null;

  public PhieuNhapChiTietHolder ()
  {
  }

  public PhieuNhapChiTietHolder (DTO.PhieuNhapChiTiet initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.PhieuNhapChiTietHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.PhieuNhapChiTietHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.PhieuNhapChiTietHelper.type ();
  }

}
