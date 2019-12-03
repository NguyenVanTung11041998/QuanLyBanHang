package Corba_DAO;


/**
* Corba_DAO/DanhMucDAOsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

abstract public class DanhMucDAOsHelper
{
  private static String  _id = "IDL:Corba_DAO/DanhMucDAOs:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.DanhMuc[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.DanhMuc[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = DTO.DanhMucHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Corba_DAO.DanhMucDAOsHelper.id (), "DanhMucDAOs", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DTO.DanhMuc[] read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.DanhMuc value[] = null;
    int _len0 = istream.read_long ();
    value = new DTO.DanhMuc[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = DTO.DanhMucHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.DanhMuc[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      DTO.DanhMucHelper.write (ostream, value[_i0]);
  }

}
