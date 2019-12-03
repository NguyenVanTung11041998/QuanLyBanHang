package Corba_DAO;


/**
* Corba_DAO/_INhaSanXuatDAOStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public class _INhaSanXuatDAOStub extends org.omg.CORBA.portable.ObjectImpl implements Corba_DAO.INhaSanXuatDAO
{

  public DTO.NhaSanXuat[] LayDanhSach ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("LayDanhSach", true);
                $in = _invoke ($out);
                DTO.NhaSanXuat $result[] = Corba_DAO.NhaSanXuatsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return LayDanhSach (        );
            } finally {
                _releaseReply ($in);
            }
  } // LayDanhSach

  public boolean Create (DTO.NhaSanXuat x)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Create", true);
                DTO.NhaSanXuatHelper.write ($out, x);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Create (x        );
            } finally {
                _releaseReply ($in);
            }
  } // Create

  public boolean Update (DTO.NhaSanXuat x)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Update", true);
                DTO.NhaSanXuatHelper.write ($out, x);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Update (x        );
            } finally {
                _releaseReply ($in);
            }
  } // Update

  public boolean Delete (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Delete", true);
                $out.write_long (id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return Delete (id        );
            } finally {
                _releaseReply ($in);
            }
  } // Delete

  public boolean UpdateInfo (int id, String tenNSX, String thongTin)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("UpdateInfo", true);
                $out.write_long (id);
                $out.write_string (tenNSX);
                $out.write_string (thongTin);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return UpdateInfo (id, tenNSX, thongTin        );
            } finally {
                _releaseReply ($in);
            }
  } // UpdateInfo

  public DTO.NhaSanXuat[] TimKiem (String search)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("TimKiem", true);
                $out.write_string (search);
                $in = _invoke ($out);
                DTO.NhaSanXuat $result[] = Corba_DAO.NhaSanXuatsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return TimKiem (search        );
            } finally {
                _releaseReply ($in);
            }
  } // TimKiem

  public DTO.NhaSanXuat GetById (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetById", true);
                $out.write_long (id);
                $in = _invoke ($out);
                DTO.NhaSanXuat $result = DTO.NhaSanXuatHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return GetById (id        );
            } finally {
                _releaseReply ($in);
            }
  } // GetById

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/INhaSanXuatDAO:1.0"};

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
} // class _INhaSanXuatDAOStub
