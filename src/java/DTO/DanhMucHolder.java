package DTO;

/**
* DTO/DanhMucHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public final class DanhMucHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.DanhMuc value = null;

  public DanhMucHolder ()
  {
  }

  public DanhMucHolder (DTO.DanhMuc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.DanhMucHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.DanhMucHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.DanhMucHelper.type ();
  }

}
