package Corba_DAO;

/**
* Corba_DAO/IHoaDonChiTietDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 4:26:39 PM ICT
*/

public final class IHoaDonChiTietDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IHoaDonChiTietDAO value = null;

  public IHoaDonChiTietDAOHolder ()
  {
  }

  public IHoaDonChiTietDAOHolder (Corba_DAO.IHoaDonChiTietDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IHoaDonChiTietDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IHoaDonChiTietDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IHoaDonChiTietDAOHelper.type ();
  }

}
