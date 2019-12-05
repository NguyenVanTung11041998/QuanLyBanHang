package DAO;

import Corba_DAO.INhaSanXuatDAOPOA;
import DTO.NhaSanXuat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class NhaSanXuatDAO extends INhaSanXuatDAOPOA {
    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    @Override
    public NhaSanXuat[] LayDanhSach() {
        ArrayList<NhaSanXuat> nhaSanXuats = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetData("Select * From NhaSanXuat");
        try {
            while (data.next()) {
                NhaSanXuat x = new NhaSanXuat(data.getInt("MaNSX"), data.getString("TenNSX"), data.getString("ThongTin"), data.getString("Logo"));
                nhaSanXuats.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhaSanXuats.toArray(new NhaSanXuat[nhaSanXuats.size()]);
    }

    @Override
    public boolean Create(NhaSanXuat x) {
        String query = "INSERT INTO NhaSanXuat(TenNSX, ThongTin, Logo) VALUES (?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenNSX);
            pre.setString(2, x.thongTin);
            pre.setString(3, x.logo);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(NhaSanXuat x) {
        String query = "UPDATE dbo.NhaSanXuat SET TenNSX = ?, ThongTin = ?, Logo = ? WHERE MaNSX = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenNSX);
            pre.setString(2, x.thongTin);
            pre.setString(3, x.logo);
            pre.setInt(4, x.maNSX);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "DELETE dbo.NhaSanXuat WHERE MaNSX = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public NhaSanXuat[] TimKiem(String search) {
        ArrayList<NhaSanXuat> nhaSanXuats = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select * From NhaSanXuat Where TenNSX LIKE ?", search);
        try {
            while (data.next()) {
                NhaSanXuat x = new NhaSanXuat(data.getInt("MaNSX"), data.getString("TenNSX"), data.getString("ThongTin"), data.getString("Logo"));
                nhaSanXuats.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (NhaSanXuat[]) nhaSanXuats.toArray();
    }

    @Override
    public NhaSanXuat GetById(int id) {
        String query = "Select * From NhaSanXuat Where MaNSX = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while(data.next())
            {
                NhaSanXuat x = new NhaSanXuat(data.getInt("MaNSX"), data.getString("TenNSX"), data.getString("ThongTin"), data.getString("Logo"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean UpdateInfo(int id, String tenNSX, String thongTin) {
        String query = "UPDATE dbo.NhaSanXuat SET TenNSX = ?, ThongTin = ? WHERE MaNSX = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, tenNSX);
            pre.setString(2, thongTin);
            pre.setInt(3, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaSanXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
