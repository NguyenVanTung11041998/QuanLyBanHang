package Corba_DAO;


/**
* Corba_DAO/_IHoaDonChiTietDAOStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public class _IHoaDonChiTietDAOStub extends org.omg.CORBA.portable.ObjectImpl implements Corba_DAO.IHoaDonChiTietDAO
{

  public DTO.HoaDonChiTiet[] LayDanhSachHoaDonChiTiet (int idHoaDon)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("LayDanhSachHoaDonChiTiet", true);
                $out.write_long (idHoaDon);
                $in = _invoke ($out);
                DTO.HoaDonChiTiet $result[] = Corba_DAO.HoaDonChiTietsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return LayDanhSachHoaDonChiTiet (idHoaDon        );
            } finally {
                _releaseReply ($in);
            }
  } // LayDanhSachHoaDonChiTiet

  public void Insert (DTO.HoaDonChiTiet x)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Insert", true);
                DTO.HoaDonChiTietHelper.write ($out, x);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                Insert (x        );
            } finally {
                _releaseReply ($in);
            }
  } // Insert

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/IHoaDonChiTietDAO:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _IHoaDonChiTietDAOStub
