package DTO;

/**
* DTO/LoaiSanPhamHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 3:53:39 PM ICT
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
