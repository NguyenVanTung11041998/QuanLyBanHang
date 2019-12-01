package DAO;

import Corba_DAO.IGioHangDAOPOA;
import DTO.GioHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GioHangDAO extends IGioHangDAOPOA {

    @Override
    public GioHang[] LayDanhSach(int idKhachHang) {
        String query = "SELECT ID, IDKhachHang, GioHang.MaSP, SoLuongDat, GioHang.TrangThai, TenSP FROM dbo.GioHang INNER JOIN dbo.SanPham ON SanPham.MaSP = GioHang.MaSP Where IDKhachHang = ?";
        ArrayList<GioHang> gioHangs = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, idKhachHang);
            ResultSet data = pre.executeQuery();
            while (data.next()) {
                GioHang x = new GioHang(data.getInt("ID"), data.getInt("IDKhachHang"), data.getInt("MaSP"), data.getInt("SoLuongDat"), data.getBoolean("TrangThai"), data.getString("TenSP"));
                gioHangs.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gioHangs.toArray(new GioHang[gioHangs.size()]);
    }

    @Override
    public boolean Create(GioHang x) {
        String query = "INSERT INTO GioHang(IDKhachHang, MaSP, SoLuongDat, TrangThai) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.idKhachHang);
            pre.setInt(2, x.maSP);
            pre.setInt(3, x.soLuongDat);
            pre.setBoolean(4, x.trangThai);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(GioHang x) {
        String query = "UPDATE dbo.GioHang SET SoLuongDat = ?, TrangThai = ? WHERE IDKhachHang = ? AND MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.soLuongDat);
            pre.setBoolean(2, x.trangThai);
            pre.setInt(3, x.idKhachHang);
            pre.setInt(4, x.maSP);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int idKhachHang, int maSP) {
        String query = "Delete GioHang Where IDKhachHang = ? AND MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, idKhachHang);  
            pre.setInt(2, maSP);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public int GetSoLuongSanPhamTrongGioTheoKhachHang(int id) {
        String query = "Select Count(*) From GioHang Where IdKhachHang = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while (data.next()) {
                return data.getInt(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public float GetTongTienSanPhamTrongGioTheoKhachHang(int id) {
        String query = "SELECT SUM(SoLuongDat * DonGia) FROM dbo.GioHang INNER JOIN dbo.SanPham ON SanPham.MaSP = GioHang.MaSP WHERE IDKhachHang = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while (data.next()) {
                return data.getFloat(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GioHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
