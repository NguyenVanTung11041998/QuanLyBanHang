package Corba_DAO;

/**
* Corba_DAO/IHoaDonDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 3:53:39 PM ICT
*/

public final class IHoaDonDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IHoaDonDAO value = null;

  public IHoaDonDAOHolder ()
  {
  }

  public IHoaDonDAOHolder (Corba_DAO.IHoaDonDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IHoaDonDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IHoaDonDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IHoaDonDAOHelper.type ();
  }

}
