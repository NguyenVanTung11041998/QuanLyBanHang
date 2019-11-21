package DAO;

import Corba_DAO.INhaCungCapDAOPOA;
import DTO.NhaCungCap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO extends INhaCungCapDAOPOA{

    @Override
    public NhaCungCap[] LayDanhSach() {
        String query = "Select * From NhaCungCap";
        ResultSet data = DataProvider.getInstance().GetData(query);
        ArrayList<NhaCungCap> nhaCungCaps = new ArrayList<>();
        try {
            while(data.next())
            {
                NhaCungCap x = new NhaCungCap(data.getInt("MaNCC"), data.getString("TenNCC"), data.getString("DiaChi"), data.getString("SoDT"), data.getString("Email"));
                nhaCungCaps.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhaCungCaps.toArray(new NhaCungCap[nhaCungCaps.size()]);
    }

    @Override
    public boolean Create(NhaCungCap x) {
        String query = "INSERT INTO dbo.NhaCungCap (TenNCC, DiaChi, SoDT, Email ) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenNCC);
            pre.setString(2, x.diaChi);
            pre.setString(3, x.soDT);
            pre.setString(4, x.email);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(NhaCungCap x) {
        String query = "UPDATE dbo.NhaCungCap SET TenNCC = ?, DiaChi = ?, SoDT = ?, Email = ? WHERE MaNCC = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenNCC);
            pre.setString(2, x.diaChi);
            pre.setString(3, x.soDT);
            pre.setString(4, x.email);
            pre.setInt(5, x.maNCC);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "DELETE dbo.NhaCungCap WHERE MaNCC = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public NhaCungCap[] TimKiem(String search) {
        String query = "SELECT * FROM dbo.NhaCungCap WHERE TenNCC LIKE ?";
        ArrayList<NhaCungCap> nhaCungCaps = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetDataSearch(query, search);
        try {
            while(data.next())
            {
                NhaCungCap x = new NhaCungCap(data.getInt("MaNCC"), data.getString("TenNCC"), data.getString("DiaChi"), data.getString("SoDT"), data.getString("Email"));
                nhaCungCaps.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nhaCungCaps.toArray(new NhaCungCap[nhaCungCaps.size()]);
    }
    
}
