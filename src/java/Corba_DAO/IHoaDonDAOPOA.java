package Corba_DAO;


/**
* Corba_DAO/IHoaDonDAOPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Model.idl
* Thursday, November 28, 2019 5:56:13 PM ICT
*/

public abstract class IHoaDonDAOPOA extends org.omg.PortableServer.Servant
 implements Corba_DAO.IHoaDonDAOOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("LayDanhSach", new java.lang.Integer (0));
    _methods.put ("Create", new java.lang.Integer (1));
    _methods.put ("Update", new java.lang.Integer (2));
    _methods.put ("ThanhToan", new java.lang.Integer (3));
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
       case 0:  // Corba_DAO/IHoaDonDAO/LayDanhSach
       {
         DTO.HoaDon $result[] = null;
         $result = this.LayDanhSach ();
         out = $rh.createReply();
         Corba_DAO.HoaDonsHelper.write (out, $result);
         break;
       }

       case 1:  // Corba_DAO/IHoaDonDAO/Create
       {
         DTO.HoaDon x = DTO.HoaDonHelper.read (in);
         boolean $result = false;
         $result = this.Create (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // Corba_DAO/IHoaDonDAO/Update
       {
         DTO.HoaDon x = DTO.HoaDonHelper.read (in);
         boolean $result = false;
         $result = this.Update (x);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // Corba_DAO/IHoaDonDAO/ThanhToan
       {
         int id = in.read_long ();
         boolean $result = false;
         $result = this.ThanhToan (id);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // Corba_DAO/IHoaDonDAO/TimKiem
       {
         String date = in.read_string ();
         DTO.HoaDon $result[] = null;
         $result = this.TimKiem (date);
         out = $rh.createReply();
         Corba_DAO.HoaDonsHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Corba_DAO/IHoaDonDAO:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public IHoaDonDAO _this() 
  {
    return IHoaDonDAOHelper.narrow(
    super._this_object());
  }

  public IHoaDonDAO _this(org.omg.CORBA.ORB orb) 
  {
    return IHoaDonDAOHelper.narrow(
    super._this_object(orb));
  }


} // class IHoaDonDAOPOA
