package Corba_DAO;


/**
* Corba_DAO/IPhieuNhapDAOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 6:05:05 PM ICT
*/

abstract public class IPhieuNhapDAOHelper
{
  private static String  _id = "IDL:Corba_DAO/IPhieuNhapDAO:1.0";

  public static void insert (org.omg.CORBA.Any a, Corba_DAO.IPhieuNhapDAO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Corba_DAO.IPhieuNhapDAO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Corba_DAO.IPhieuNhapDAOHelper.id (), "IPhieuNhapDAO");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Corba_DAO.IPhieuNhapDAO read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_IPhieuNhapDAOStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Corba_DAO.IPhieuNhapDAO value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Corba_DAO.IPhieuNhapDAO narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IPhieuNhapDAO)
      return (Corba_DAO.IPhieuNhapDAO)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IPhieuNhapDAOStub stub = new Corba_DAO._IPhieuNhapDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Corba_DAO.IPhieuNhapDAO unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Corba_DAO.IPhieuNhapDAO)
      return (Corba_DAO.IPhieuNhapDAO)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Corba_DAO._IPhieuNhapDAOStub stub = new Corba_DAO._IPhieuNhapDAOStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
