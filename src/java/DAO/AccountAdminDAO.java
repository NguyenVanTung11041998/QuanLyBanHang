package DAO;
import Corba_DAO.*;
import DTO.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class AccountAdminDAO extends IAccountAdminDAOPOA{
    private static AccountAdminDAO instance;
    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    
    public static AccountAdminDAO getInstance() {
        if(instance == null)
            instance = new AccountAdminDAO();
        return instance;
    }

    @Override
    public AccountAdmin Login(String taiKhoan, String matKhau) {
        ResultSet data = null;
        try {
            String query = "Select * From AccountAdmin Where TaiKhoan = ? And MatKhau = ?";
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, taiKhoan);
            pre.setString(2, matKhau);
            data = pre.executeQuery();
            while(data.next())
            {
                AccountAdmin accountAdmin = new AccountAdmin(data.getInt("ID"), data.getString("TaiKhoan"), data.getString("MatKhau"));
                return accountAdmin;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

    
}
