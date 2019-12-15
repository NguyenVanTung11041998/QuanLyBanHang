package DAO;

import Corba_DAO.IKhachHangDAOPOA;
import DTO.KhachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class KhachHangDAO extends IKhachHangDAOPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

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
        return khachHangs.toArray(new KhachHang[khachHangs.size()]);
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
        String query = "Select * From KhachHang Where ID = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while (data.next()) {
                KhachHang x = new KhachHang(data.getInt("ID"), data.getString("Email"), data.getString("MatKhau"), data.getString("HoTen"), data.getString("DiaChi"), data.getString("SoDT"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public KhachHang Login(String email, String matKhau) {
        String query = "Select * From KhachHang Where Email = ? And MatKhau = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, email);
            pre.setString(2, matKhau);
            ResultSet data = pre.executeQuery();
            while (data.next()) {
                KhachHang x = new KhachHang(data.getInt("ID"), data.getString("Email"), data.getString("MatKhau"), data.getString("HoTen"), data.getString("DiaChi"), data.getString("SoDT"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean UpdateInfo(int id, String hoTen, String soDienThoai, String diaChi) {
        String query = "UPDATE dbo.KhachHang SET HoTen = ?, DiaChi = ?, SoDT = ? WHERE ID = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, hoTen);
            pre.setString(2, diaChi);
            pre.setString(3, soDienThoai);
            pre.setInt(4, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
