package DAO;

import Corba_DAO.IDanhMucDAOPOA;
import DTO.DanhMuc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class DanhMucDAO extends IDanhMucDAOPOA {
    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    @Override
    public DanhMuc[] LayDanhSach() {
        String query = "Select * From DanhMuc";
        ArrayList<DanhMuc> danhMucs = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetData(query);
            while (data.next()) {
                DanhMuc x = new DanhMuc(data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                danhMucs.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMucs.toArray(new DanhMuc[danhMucs.size()]);
    }

    @Override
    public boolean Create(DanhMuc x) {
        String query = "INSERT INTO DanhMuc(TenDanhMuc) VALUES (?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenDanhMuc);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(DanhMuc x) {
        String query = "UPDATE DanhMuc SET TenDanhMuc = ? WHERE MaDanhMuc = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenDanhMuc);
            pre.setInt(2, x.maDanhMuc);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "Delete DanhMuc Where MaDanhMuc = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public DanhMuc[] TimKiem(String search) {
        ArrayList<DanhMuc> danhMucs = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select * From DanhMuc Where TenDanhMuc LIKE ?", search);
        try {
            while (data.next()) {
                DanhMuc x = new DanhMuc(data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                danhMucs.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhMucs.toArray(new DanhMuc[danhMucs.size()]);
    }

    @Override
    public DanhMuc GetById(int id) {
        String query = "Select * From DanhMuc Where MaDanhMuc = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while(data.next())
            {
                DanhMuc x = new DanhMuc(data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
