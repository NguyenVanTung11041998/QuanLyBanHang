package Corba_DAO;

/**
* Corba_DAO/INhaSanXuatDAOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 23, 2019 9:17:11 AM ICT
*/

public final class INhaSanXuatDAOHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba_DAO.INhaSanXuatDAO value = null;

  public INhaSanXuatDAOHolder ()
  {
  }

  public INhaSanXuatDAOHolder (Corba_DAO.INhaSanXuatDAO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.INhaSanXuatDAOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.INhaSanXuatDAOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.INhaSanXuatDAOHelper.type ();
  }

}
