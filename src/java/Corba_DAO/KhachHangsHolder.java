package Corba_DAO;


/**
* Corba_DAO/KhachHangsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 3:53:39 PM ICT
*/

public final class KhachHangsHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.KhachHang value[] = null;

  public KhachHangsHolder ()
  {
  }

  public KhachHangsHolder (DTO.KhachHang[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.KhachHangsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.KhachHangsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.KhachHangsHelper.type ();
  }

}
