package Corba_DAO;


/**
* Corba_DAO/IPhieuNhapDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Tuesday, December 3, 2019 10:57:14 PM ICT
*/

public abstract class IPhieuNhapDAOPOA extends org.omg.PortableServer.Servant
 implements Corba_DAO.IPhieuNhapDAOOperations, org.omg.CORBA.portable.InvokeHandler
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
    _methods.put ("GetPhieuNhapCuoiCung", new java.lang.Integer (5));
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
       case 0:  // Corba_DAO/IPhieuNhapDAO/LayDanhSach
       {
         DTO.PhieuNhap $result[] = null;
         $result = this.LayDanhSach ();
         out = $rh.createReply();
         Corba_DAO.PhieuNhapsHelper.write (out, $result);
         break;
       }

       case 1:  // Corba_DAO/IPhieuNhapDAO/Create
       {
         DTO.PhieuNhap x = DTO.PhieuNhapHelper.read (in);
         boolean $result = false;
         $result = this.Create (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Corba_DAO/IPhieuNhapDAO/Update
       {
         int id = in.read_long ();
         String ngayNhap = in.read_string ();
         boolean $result = false;
         $result = this.Update (id, ngayNhap);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Corba_DAO/IPhieuNhapDAO/Delete
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.Delete (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // Corba_DAO/IPhieuNhapDAO/TimKiem
       {
         String date = in.read_string ();
         DTO.PhieuNhap $result[] = null;
         $result = this.TimKiem (date);
         out = $rh.createReply();
         Corba_DAO.PhieuNhapsHelper.write (out, $result);
         break;
       }

       case 5:  // Corba_DAO/IPhieuNhapDAO/GetPhieuNhapCuoiCung
       {
         DTO.PhieuNhap $result = null;
         $result = this.GetPhieuNhapCuoiCung ();
         out = $rh.createReply();
         DTO.PhieuNhapHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/IPhieuNhapDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IPhieuNhapDAO _this() 
  {
    return IPhieuNhapDAOHelper.narrow(
    super._this_object());
  }

  public IPhieuNhapDAO _this(org.omg.CORBA.ORB orb) 
  {
    return IPhieuNhapDAOHelper.narrow(
    super._this_object(orb));
  }


} // class IPhieuNhapDAOPOA
