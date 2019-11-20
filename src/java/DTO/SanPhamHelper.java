package DTO;


/**
* DTO/SanPhamHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

abstract public class SanPhamHelper
{
  private static String  _id = "IDL:DTO/SanPham:1.0";

  public static void insert (org.omg.CORBA.Any a, DTO.SanPham that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static DTO.SanPham extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [11];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "maSP",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "tenSP",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_float);
          _members0[2] = new org.omg.CORBA.StructMember (
            "donGia",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "ngayCapNhat",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "moTa",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "hinhAnh",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[6] = new org.omg.CORBA.StructMember (
            "soLuongTon",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[7] = new org.omg.CORBA.StructMember (
            "maNCC",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[8] = new org.omg.CORBA.StructMember (
            "maNSX",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[9] = new org.omg.CORBA.StructMember (
            "maLoaiSP",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_boolean);
          _members0[10] = new org.omg.CORBA.StructMember (
            "trangThai",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (DTO.SanPhamHelper.id (), "SanPham", _members0);
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

  public static DTO.SanPham read (org.omg.CORBA.portable.InputStream istream)
  {
    DTO.SanPham value = new DTO.SanPham ();
    value.maSP = istream.read_long ();
    value.tenSP = istream.read_string ();
    value.donGia = istream.read_float ();
    value.ngayCapNhat = istream.read_string ();
    value.moTa = istream.read_string ();
    value.hinhAnh = istream.read_string ();
    value.soLuongTon = istream.read_long ();
    value.maNCC = istream.read_long ();
    value.maNSX = istream.read_long ();
    value.maLoaiSP = istream.read_long ();
    value.trangThai = istream.read_boolean ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, DTO.SanPham value)
  {
    ostream.write_long (value.maSP);
    ostream.write_string (value.tenSP);
    ostream.write_float (value.donGia);
    ostream.write_string (value.ngayCapNhat);
    ostream.write_string (value.moTa);
    ostream.write_string (value.hinhAnh);
    ostream.write_long (value.soLuongTon);
    ostream.write_long (value.maNCC);
    ostream.write_long (value.maNSX);
    ostream.write_long (value.maLoaiSP);
    ostream.write_boolean (value.trangThai);
  }

}