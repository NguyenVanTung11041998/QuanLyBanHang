package Corba_DAO;

/**
* Corba_DAO/IPhieuNhapDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class IPhieuNhapDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.IPhieuNhapDAO value = null;

  public IPhieuNhapDAOHolder ()
  {
  }

  public IPhieuNhapDAOHolder (Corba_DAO.IPhieuNhapDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.IPhieuNhapDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.IPhieuNhapDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.IPhieuNhapDAOHelper.type ();
  }

}