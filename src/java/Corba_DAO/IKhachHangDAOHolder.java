package Corba_DAO;

/**
* Corba_DAO/IKhachHangDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 2:33:34 PM ICT
*/

public final class IKhachHangDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IKhachHangDAO value = null;

  public IKhachHangDAOHolder ()
  {
  }

  public IKhachHangDAOHolder (Corba_DAO.IKhachHangDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IKhachHangDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IKhachHangDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IKhachHangDAOHelper.type ();
  }

}
