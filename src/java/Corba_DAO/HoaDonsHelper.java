package Corba_DAO;


/**
* Corba_DAO/HoaDonsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 5:29:00 PM ICT
*/

abstract public class HoaDonsHelper
{
  private static String  _id = "IDL:Corba_DAO/HoaDons:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.HoaDon[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.HoaDon[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = DTO.HoaDonHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Corba_DAO.HoaDonsHelper.id (), "HoaDons", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DTO.HoaDon[] read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.HoaDon value[] = null;
    int _len0 = istream.read_long ();
    value = new DTO.HoaDon[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = DTO.HoaDonHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.HoaDon[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      DTO.HoaDonHelper.write (ostream, value[_i0]);
  }

}
