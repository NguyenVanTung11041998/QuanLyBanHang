package Corba_DAO;


/**
* Corba_DAO/SanPhamsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

abstract public class SanPhamsHelper
{
  private static String  _id = "IDL:Corba_DAO/SanPhams:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.SanPham[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.SanPham[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = DTO.SanPhamHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Corba_DAO.SanPhamsHelper.id (), "SanPhams", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DTO.SanPham[] read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.SanPham value[] = null;
    int _len0 = istream.read_long ();
    value = new DTO.SanPham[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = DTO.SanPhamHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.SanPham[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      DTO.SanPhamHelper.write (ostream, value[_i0]);
  }

}
