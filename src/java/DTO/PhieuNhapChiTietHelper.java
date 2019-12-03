package DTO;


/**
* DTO/PhieuNhapChiTietHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

abstract public class PhieuNhapChiTietHelper
{
  private static String  _id = "IDL:DTO/PhieuNhapChiTiet:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.PhieuNhapChiTiet that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.PhieuNhapChiTiet extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "maPN",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "maSP",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "soLuongNhap",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[3] = new org.omg.CORBA.StructMember (
            "donGiaNhap",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "tenSP",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (DTO.PhieuNhapChiTietHelper.id (), "PhieuNhapChiTiet", _members0);
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

  public static DTO.PhieuNhapChiTiet read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.PhieuNhapChiTiet value = new DTO.PhieuNhapChiTiet ();
    value.maPN = istream.read_long ();
    value.maSP = istream.read_long ();
    value.soLuongNhap = istream.read_long ();
    value.donGiaNhap = istream.read_float ();
    value.tenSP = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.PhieuNhapChiTiet value)
  {
    ostream.write_long (value.maPN);
    ostream.write_long (value.maSP);
    ostream.write_long (value.soLuongNhap);
    ostream.write_float (value.donGiaNhap);
    ostream.write_string (value.tenSP);
  }

}
