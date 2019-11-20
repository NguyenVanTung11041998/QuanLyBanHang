package DTO;


/**
* DTO/KhachHangHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

abstract public class KhachHangHelper
{
  private static String  _id = "IDL:DTO/KhachHang:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.KhachHang that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.KhachHang extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [6];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "email",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "matKhau",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "hoTen",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "diaChi",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "soDT",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (DTO.KhachHangHelper.id (), "KhachHang", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static DTO.KhachHang read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.KhachHang value = new DTO.KhachHang ();
    value.id = istream.read_long ();
    value.email = istream.read_string ();
    value.matKhau = istream.read_string ();
    value.hoTen = istream.read_string ();
    value.diaChi = istream.read_string ();
    value.soDT = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.KhachHang value)
  {
    ostream.write_long (value.id);
    ostream.write_string (value.email);
    ostream.write_string (value.matKhau);
    ostream.write_string (value.hoTen);
    ostream.write_string (value.diaChi);
    ostream.write_string (value.soDT);
  }

}
