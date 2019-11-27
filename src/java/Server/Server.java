package Server;

import Corba_DAO.IAccountAdminDAO;
import Corba_DAO.IAccountAdminDAOHelper;
import DAO.AccountAdminDAO;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class Server {
    public static void main(String[] args) {
        try
        {
            ORB orb = ORB.init(args, null);
            POA rootPoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPoa.the_POAManager().activate();
            AccountAdminDAO accountDAO = new AccountAdminDAO();
            accountDAO.setOrb(orb);
            org.omg.CORBA.Object ref = rootPoa.servant_to_reference(accountDAO);
            IAccountAdminDAO accountObj = IAccountAdminDAOHelper.narrow(ref);
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent path[] = ncRef.to_name("ABC");
            ncRef.rebind(path, accountObj);
            System.out.println("Loading......");
            for( ; ; )
                orb.run();
        }
        catch(Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace(System.out);
        }
                
    }
}
