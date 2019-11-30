package Corba_DAO;


/**
* Corba_DAO/ISanPhamDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Saturday, November 30, 2019 3:53:39 PM ICT
*/

public abstract class ISanPhamDAOPOA extends org.omg.PortableServer.Servant
 implements Corba_DAO.ISanPhamDAOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("LayDanhSach", new java.lang.Integer (0));
    _methods.put ("Create", new java.lang.Integer (1));
    _methods.put ("Update", new java.lang.Integer (2));
    _methods.put ("Delete", new java.lang.Integer (3));
    _methods.put ("TimKiem", new java.lang.Integer (4));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Corba_DAO/ISanPhamDAO/LayDanhSach
       {
         DTO.SanPham $result[] = null;
         $result = this.LayDanhSach ();
         out = $rh.createReply();
         Corba_DAO.SanPhamsHelper.write (out, $result);
         break;
       }

       case 1:  // Corba_DAO/ISanPhamDAO/Create
       {
         DTO.SanPham x = DTO.SanPhamHelper.read (in);
         boolean $result = false;
         $result = this.Create (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Corba_DAO/ISanPhamDAO/Update
       {
         DTO.SanPham x = DTO.SanPhamHelper.read (in);
         boolean $result = false;
         $result = this.Update (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Corba_DAO/ISanPhamDAO/Delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.Delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // Corba_DAO/ISanPhamDAO/TimKiem
       {
         String search = in.read_string ();
         DTO.SanPham $result[] = null;
         $result = this.TimKiem (search);
         out = $rh.createReply();
         Corba_DAO.SanPhamsHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/ISanPhamDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public ISanPhamDAO _this() 
  {
    return ISanPhamDAOHelper.narrow(
    super._this_object());
  }

  public ISanPhamDAO _this(org.omg.CORBA.ORB orb) 
  {
    return ISanPhamDAOHelper.narrow(
    super._this_object(orb));
  }


} // class ISanPhamDAOPOA
