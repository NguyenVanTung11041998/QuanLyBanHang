package Corba_DAO;

/**
* Corba_DAO/IAccountAdminDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public final class IAccountAdminDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IAccountAdminDAO value = null;

  public IAccountAdminDAOHolder ()
  {
  }

  public IAccountAdminDAOHolder (Corba_DAO.IAccountAdminDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IAccountAdminDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IAccountAdminDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IAccountAdminDAOHelper.type ();
  }

}
