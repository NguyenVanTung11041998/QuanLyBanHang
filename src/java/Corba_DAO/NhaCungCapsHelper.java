package Corba_DAO;


/**
* Corba_DAO/NhaCungCapsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 23, 2019 9:17:11 AM ICT
*/

abstract public class NhaCungCapsHelper
{
  private static String  _id = "IDL:Corba_DAO/NhaCungCaps:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.NhaCungCap[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.NhaCungCap[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = DTO.NhaCungCapHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (Corba_DAO.NhaCungCapsHelper.id (), "NhaCungCaps", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DTO.NhaCungCap[] read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.NhaCungCap value[] = null;
    int _len0 = istream.read_long ();
    value = new DTO.NhaCungCap[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = DTO.NhaCungCapHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.NhaCungCap[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      DTO.NhaCungCapHelper.write (ostream, value[_i0]);
  }

}
