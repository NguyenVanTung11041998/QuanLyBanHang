package DTO;

/**
* DTO/LoaiSanPhamHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class LoaiSanPhamHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.LoaiSanPham value = null;

  public LoaiSanPhamHolder ()
  {
  }

  public LoaiSanPhamHolder (DTO.LoaiSanPham initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.LoaiSanPhamHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.LoaiSanPhamHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.LoaiSanPhamHelper.type ();
  }

}