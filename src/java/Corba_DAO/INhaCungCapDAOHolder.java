package Corba_DAO;

/**
* Corba_DAO/INhaCungCapDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class INhaCungCapDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.INhaCungCapDAO value = null;

  public INhaCungCapDAOHolder ()
  {
  }

  public INhaCungCapDAOHolder (Corba_DAO.INhaCungCapDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.INhaCungCapDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.INhaCungCapDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.INhaCungCapDAOHelper.type ();
  }

}