package DTO;

/**
* DTO/NhaCungCapHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 6:05:05 PM ICT
*/

public final class NhaCungCapHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.NhaCungCap value = null;

  public NhaCungCapHolder ()
  {
  }

  public NhaCungCapHolder (DTO.NhaCungCap initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DTO.NhaCungCapHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DTO.NhaCungCapHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DTO.NhaCungCapHelper.type ();
  }

}
