package DTO;


/**
* DTO/LoaiSanPhamHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 6:05:05 PM ICT
*/

abstract public class LoaiSanPhamHelper
{
  private static String  _id = "IDL:DTO/LoaiSanPham:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.LoaiSanPham that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.LoaiSanPham extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [4];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "maLoaiSP",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "tenLoai",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "maDanhMuc",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "tenDanhMuc",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (DTO.LoaiSanPhamHelper.id (), "LoaiSanPham", _members0);
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

  public static DTO.LoaiSanPham read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.LoaiSanPham value = new DTO.LoaiSanPham ();
    value.maLoaiSP = istream.read_long ();
    value.tenLoai = istream.read_string ();
    value.maDanhMuc = istream.read_long ();
    value.tenDanhMuc = istream.read_string ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.LoaiSanPham value)
  {
    ostream.write_long (value.maLoaiSP);
    ostream.write_string (value.tenLoai);
    ostream.write_long (value.maDanhMuc);
    ostream.write_string (value.tenDanhMuc);
  }

}
