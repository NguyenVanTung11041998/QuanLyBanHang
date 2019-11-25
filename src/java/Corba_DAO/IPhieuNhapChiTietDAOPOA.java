package Corba_DAO;


/**
* Corba_DAO/IPhieuNhapChiTietDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Monday, November 25, 2019 9:02:18 AM ICT
*/

public abstract class IPhieuNhapChiTietDAOPOA extends org.omg.PortableServer.Servant
 implements Corba_DAO.IPhieuNhapChiTietDAOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("LayDanhSach", new java.lang.Integer (0));
    _methods.put ("Create", new java.lang.Integer (1));
    _methods.put ("Update", new java.lang.Integer (2));
    _methods.put ("Delete", new java.lang.Integer (3));
    _methods.put ("GetById", new java.lang.Integer (4));
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
       case 0:  // Corba_DAO/IPhieuNhapChiTietDAO/LayDanhSach
       {
         int idPhieuNhap = in.read_long ();
         DTO.PhieuNhapChiTiet $result[] = null;
         $result = this.LayDanhSach (idPhieuNhap);
         out = $rh.createReply();
         Corba_DAO.PhieuNhapChiTietsHelper.write (out, $result);
         break;
       }

       case 1:  // Corba_DAO/IPhieuNhapChiTietDAO/Create
       {
         DTO.PhieuNhapChiTiet x = DTO.PhieuNhapChiTietHelper.read (in);
         boolean $result = false;
         $result = this.Create (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Corba_DAO/IPhieuNhapChiTietDAO/Update
       {
         DTO.PhieuNhapChiTiet x = DTO.PhieuNhapChiTietHelper.read (in);
         boolean $result = false;
         $result = this.Update (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Corba_DAO/IPhieuNhapChiTietDAO/Delete
       {
         int maPhieuNhap = in.read_long ();
         int maSP = in.read_long ();
         boolean $result = false;
         $result = this.Delete (maPhieuNhap, maSP);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // Corba_DAO/IPhieuNhapChiTietDAO/GetById
       {
         int id = in.read_long ();
         DTO.PhieuNhapChiTiet $result = null;
         $result = this.GetById (id);
         out = $rh.createReply();
         DTO.PhieuNhapChiTietHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/IPhieuNhapChiTietDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IPhieuNhapChiTietDAO _this() 
  {
    return IPhieuNhapChiTietDAOHelper.narrow(
    super._this_object());
  }

  public IPhieuNhapChiTietDAO _this(org.omg.CORBA.ORB orb) 
  {
    return IPhieuNhapChiTietDAOHelper.narrow(
    super._this_object(orb));
  }


} // class IPhieuNhapChiTietDAOPOA
