package DTO;

/**
* DTO/SanPhamHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 5:29:00 PM ICT
*/

public final class SanPhamHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.SanPham value = null;

  public SanPhamHolder ()
  {
  }

  public SanPhamHolder (DTO.SanPham initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.SanPhamHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.SanPhamHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.SanPhamHelper.type ();
  }

}
