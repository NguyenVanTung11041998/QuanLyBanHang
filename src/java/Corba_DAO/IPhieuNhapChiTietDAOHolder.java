package Corba_DAO;

/**
* Corba_DAO/IPhieuNhapChiTietDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 5:29:00 PM ICT
*/

public final class IPhieuNhapChiTietDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IPhieuNhapChiTietDAO value = null;

  public IPhieuNhapChiTietDAOHolder ()
  {
  }

  public IPhieuNhapChiTietDAOHolder (Corba_DAO.IPhieuNhapChiTietDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IPhieuNhapChiTietDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IPhieuNhapChiTietDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IPhieuNhapChiTietDAOHelper.type ();
  }

}
