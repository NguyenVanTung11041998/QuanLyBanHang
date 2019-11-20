package Corba_DAO;


/**
* Corba_DAO/IAccountAdminDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Wednesday, November 20, 2019 12:59:50 PM ICT
*/

public abstract class IAccountAdminDAOPOA extends org.omg.PortableServer.Servant
 implements Corba_DAO.IAccountAdminDAOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("Login", new java.lang.Integer (0));
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
       case 0:  // Corba_DAO/IAccountAdminDAO/Login
       {
         String taiKhoan = in.read_string ();
         String matKhau = in.read_string ();
         DTO.AccountAdmin $result = null;
         $result = this.Login (taiKhoan, matKhau);
         out = $rh.createReply();
         DTO.AccountAdminHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/IAccountAdminDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IAccountAdminDAO _this() 
  {
    return IAccountAdminDAOHelper.narrow(
    super._this_object());
  }

  public IAccountAdminDAO _this(org.omg.CORBA.ORB orb) 
  {
    return IAccountAdminDAOHelper.narrow(
    super._this_object(orb));
  }


} // class IAccountAdminDAOPOA