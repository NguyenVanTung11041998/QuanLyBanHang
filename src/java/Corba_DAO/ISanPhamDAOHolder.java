package Corba_DAO;

/**
* Corba_DAO/ISanPhamDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 28, 2019 5:56:13 PM ICT
*/

public final class ISanPhamDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.ISanPhamDAO value = null;

  public ISanPhamDAOHolder ()
  {
  }

  public ISanPhamDAOHolder (Corba_DAO.ISanPhamDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.ISanPhamDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.ISanPhamDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.ISanPhamDAOHelper.type ();
  }

}
