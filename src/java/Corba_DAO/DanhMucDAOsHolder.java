package Corba_DAO;


/**
* Corba_DAO/DanhMucDAOsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 9:15:49 PM ICT
*/

public final class DanhMucDAOsHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.DanhMuc value[] = null;

  public DanhMucDAOsHolder ()
  {
  }

  public DanhMucDAOsHolder (DTO.DanhMuc[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.DanhMucDAOsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.DanhMucDAOsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.DanhMucDAOsHelper.type ();
  }

}
