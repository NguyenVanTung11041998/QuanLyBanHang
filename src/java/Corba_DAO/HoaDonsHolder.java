package Corba_DAO;


/**
* Corba_DAO/HoaDonsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class HoaDonsHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.HoaDon value[] = null;

  public HoaDonsHolder ()
  {
  }

  public HoaDonsHolder (DTO.HoaDon[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.HoaDonsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.HoaDonsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.HoaDonsHelper.type ();
  }

}