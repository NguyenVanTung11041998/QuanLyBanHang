package DTO;

/**
* DTO/PhieuNhapHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 2:33:34 PM ICT
*/

public final class PhieuNhapHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.PhieuNhap value = null;

  public PhieuNhapHolder ()
  {
  }

  public PhieuNhapHolder (DTO.PhieuNhap initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.PhieuNhapHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.PhieuNhapHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.PhieuNhapHelper.type ();
  }

}
