package Corba_DAO;


/**
* Corba_DAO/PhieuNhapChiTietsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public final class PhieuNhapChiTietsHolder implements org.omg.CORBA.portable.Streamable
{
  public DTO.PhieuNhapChiTiet value[] = null;

  public PhieuNhapChiTietsHolder ()
  {
  }

  public PhieuNhapChiTietsHolder (DTO.PhieuNhapChiTiet[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba_DAO.PhieuNhapChiTietsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba_DAO.PhieuNhapChiTietsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba_DAO.PhieuNhapChiTietsHelper.type ();
  }

}
