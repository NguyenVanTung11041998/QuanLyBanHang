package Corba_DAO;


/**
* Corba_DAO/ILoaiSanPhamDAOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

abstract public class ILoaiSanPhamDAOHelper
{
  private static String  _id = "IDL:Corba_DAO/ILoaiSanPhamDAO:1.0";

  public static void insert (org.omg.CORBA.Any a, Corba_DAO.ILoaiSanPhamDAO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Corba_DAO.ILoaiSanPhamDAO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Corba_DAO.ILoaiSanPhamDAOHelper.id (), "ILoaiSanPhamDAO");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Corba_DAO.ILoaiSanPhamDAO read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_ILoaiSanPhamDAOStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Corba_DAO.ILoaiSanPhamDAO value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Corba_DAO.ILoaiSanPhamDAO narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.ILoaiSanPhamDAO)
      return (Corba_DAO.ILoaiSanPhamDAO)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._ILoaiSanPhamDAOStub stub = new Corba_DAO._ILoaiSanPhamDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Corba_DAO.ILoaiSanPhamDAO unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.ILoaiSanPhamDAO)
      return (Corba_DAO.ILoaiSanPhamDAO)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._ILoaiSanPhamDAOStub stub = new Corba_DAO._ILoaiSanPhamDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
