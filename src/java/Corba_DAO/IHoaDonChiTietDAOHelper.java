package Corba_DAO;


/**
* Corba_DAO/IHoaDonChiTietDAOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 3:53:39 PM ICT
*/

abstract public class IHoaDonChiTietDAOHelper
{
  private static String  _id = "IDL:Corba_DAO/IHoaDonChiTietDAO:1.0";

  public static void insert (org.omg.CORBA.Any a, Corba_DAO.IHoaDonChiTietDAO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Corba_DAO.IHoaDonChiTietDAO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Corba_DAO.IHoaDonChiTietDAOHelper.id (), "IHoaDonChiTietDAO");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Corba_DAO.IHoaDonChiTietDAO read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IHoaDonChiTietDAOStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Corba_DAO.IHoaDonChiTietDAO value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Corba_DAO.IHoaDonChiTietDAO narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IHoaDonChiTietDAO)
      return (Corba_DAO.IHoaDonChiTietDAO)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IHoaDonChiTietDAOStub stub = new Corba_DAO._IHoaDonChiTietDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Corba_DAO.IHoaDonChiTietDAO unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IHoaDonChiTietDAO)
      return (Corba_DAO.IHoaDonChiTietDAO)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IHoaDonChiTietDAOStub stub = new Corba_DAO._IHoaDonChiTietDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
