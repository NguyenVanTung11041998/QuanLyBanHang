package DAO;

import Corba_DAO.IKhachHangDAOPOA;
import DTO.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO extends IKhachHangDAOPOA {

    @Override
    public KhachHang[] LayDanhSach() {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetData("Select * From KhachHang");
        try {
            while (data.next()) {
                KhachHang x = new KhachHang(data.getInt("ID"), data.getString("Email"), data.getString("MatKhau"), data.getString("HoTen"), data.getString("DiaChi"), data.getString("SoDT"));
                khachHangs.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (KhachHang[]) khachHangs.toArray();
    }

    @Override
    public boolean Create(KhachHang x) {
        String query = "INSERT INTO KhachHang(Email, MatKhau, HoTen, DiaChi, SoDT) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.email);
            pre.setString(2, x.matKhau);
            pre.setString(3, x.hoTen);
            pre.setString(4, x.diaChi);
            pre.setString(5, x.soDT);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(KhachHang x) {
        String query = "UPDATE dbo.KhachHang SET Email = ?, HoTen = ?, MatKhau = ?, DiaChi = ?, SoDT = ? WHERE ID = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.email);
            pre.setString(2, x.matKhau);
            pre.setString(3, x.hoTen);
            pre.setString(4, x.diaChi);
            pre.setString(5, x.soDT);
            pre.setInt(6, x.id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "Delete KhachHang Where ID = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);  
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public KhachHang[] TimKiem(String search) {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select * From KhachHang Where HoTen LIKE ?", search);
        try {
            while (data.next()) {
                KhachHang x = new KhachHang(data.getInt("ID"), data.getString("Email"), data.getString("MatKhau"), data.getString("HoTen"), data.getString("DiaChi"), data.getString("SoDT"));
                khachHangs.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (KhachHang[]) khachHangs.toArray();
    }

    @Override
    public KhachHang GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
