package Corba_DAO;


/**
* Corba_DAO/_ILoaiSanPhamDAOStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Sunday, December 1, 2019 6:05:05 PM ICT
*/

public class _ILoaiSanPhamDAOStub extends org.omg.CORBA.portable.ObjectImpl implements Corba_DAO.ILoaiSanPhamDAO
{

  public DTO.LoaiSanPham[] LayDanhSach ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("LayDanhSach", true);
                $in = _invoke ($out);
                DTO.LoaiSanPham $result[] = Corba_DAO.LoaiSanPhamsHelper.read ($in);
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

  public boolean Create (DTO.LoaiSanPham x)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Create", true);
                DTO.LoaiSanPhamHelper.write ($out, x);
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

  public boolean Update (DTO.LoaiSanPham x)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("Update", true);
                DTO.LoaiSanPhamHelper.write ($out, x);
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

  public DTO.LoaiSanPham[] TimKiem (String search)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("TimKiem", true);
                $out.write_string (search);
                $in = _invoke ($out);
                DTO.LoaiSanPham $result[] = Corba_DAO.LoaiSanPhamsHelper.read ($in);
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

  public DTO.LoaiSanPham GetById (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("GetById", true);
                $out.write_long (id);
                $in = _invoke ($out);
                DTO.LoaiSanPham $result = DTO.LoaiSanPhamHelper.read ($in);
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

  public DTO.LoaiSanPham[] LayDanhSachTheoDanhMuc (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("LayDanhSachTheoDanhMuc", true);
                $out.write_long (id);
                $in = _invoke ($out);
                DTO.LoaiSanPham $result[] = Corba_DAO.LoaiSanPhamsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return LayDanhSachTheoDanhMuc (id        );
            } finally {
                _releaseReply ($in);
            }
  } // LayDanhSachTheoDanhMuc

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/ILoaiSanPhamDAO:1.0"};

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
} // class _ILoaiSanPhamDAOStub
