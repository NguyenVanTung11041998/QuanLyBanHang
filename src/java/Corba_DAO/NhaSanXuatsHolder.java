package Corba_DAO;


/**
* Corba_DAO/NhaSanXuatsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class NhaSanXuatsHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.NhaSanXuat value[] = null;

  public NhaSanXuatsHolder ()
  {
  }

  public NhaSanXuatsHolder (DTO.NhaSanXuat[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.NhaSanXuatsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.NhaSanXuatsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.NhaSanXuatsHelper.type ();
  }

}
