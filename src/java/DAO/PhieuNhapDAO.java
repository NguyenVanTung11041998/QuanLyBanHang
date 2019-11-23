package DAO;

import Corba_DAO.IPhieuNhapDAOPOA;
import DTO.PhieuNhap;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO extends IPhieuNhapDAOPOA{

    @Override
    public PhieuNhap[] LayDanhSach() {
        String query = "Select * From PhieuNhap";
        ArrayList<PhieuNhap> phieuNhaps = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetData(query);
            while (data.next()) {
                PhieuNhap x = new PhieuNhap(data.getInt("MaPN"), data.getString("NgayNhap"), data.getFloat("TongTienNhap"));
                phieuNhaps.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhaps.toArray(new PhieuNhap[phieuNhaps.size()]);
    }

    @Override
    public boolean Create(PhieuNhap x) {
        String query = "INSERT INTO PhieuNhap(NgayNhap, TongTienNhap) VALUES (?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(x.ngayNhap).getTime()));
            pre.setFloat(2, x.tongTienNhap);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(int id, String ngayNhap) {
        String query = "UPDATE dbo.PhieuNhap SET NgayNhap = ? WHERE MaPN = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(ngayNhap).getTime()));
            pre.setInt(2, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "DELETE dbo.PhieuNhap WHERE MaPN = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public PhieuNhap[] TimKiem(String date) {
        String query = "Select * From PhieuNhap Where NgayNhap = ?";
        ArrayList<PhieuNhap> phieuNhaps = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(date).getTime()));
            ResultSet data = pre.executeQuery();
            while(data.next())
            {
                PhieuNhap x = new PhieuNhap(data.getInt("MaPN"), data.getString("NgayNhap"), data.getFloat("TongTienNhap"));
                phieuNhaps.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhaps.toArray(new PhieuNhap[phieuNhaps.size()]);
    }
    
}
