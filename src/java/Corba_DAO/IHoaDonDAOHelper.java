package Corba_DAO;


/**
* Corba_DAO/IHoaDonDAOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 21, 2019 9:15:49 PM ICT
*/

abstract public class IHoaDonDAOHelper
{
  private static String  _id = "IDL:Corba_DAO/IHoaDonDAO:1.0";

  public static void insert (org.omg.CORBA.Any a, Corba_DAO.IHoaDonDAO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Corba_DAO.IHoaDonDAO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Corba_DAO.IHoaDonDAOHelper.id (), "IHoaDonDAO");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Corba_DAO.IHoaDonDAO read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IHoaDonDAOStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Corba_DAO.IHoaDonDAO value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Corba_DAO.IHoaDonDAO narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IHoaDonDAO)
      return (Corba_DAO.IHoaDonDAO)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IHoaDonDAOStub stub = new Corba_DAO._IHoaDonDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Corba_DAO.IHoaDonDAO unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IHoaDonDAO)
      return (Corba_DAO.IHoaDonDAO)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IHoaDonDAOStub stub = new Corba_DAO._IHoaDonDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
