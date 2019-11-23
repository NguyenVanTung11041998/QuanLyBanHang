package DAO;

import Corba_DAO.IPhieuNhapChiTietDAOPOA;
import DTO.PhieuNhapChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapChiTietDAO extends IPhieuNhapChiTietDAOPOA{

    @Override
    public PhieuNhapChiTiet[] LayDanhSach(int idPhieuNhap) {
        String query = "Select * From PhieuNhapChiTiet Where MaPN = ?";
        ArrayList<PhieuNhapChiTiet> phieuNhapChiTiets = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, idPhieuNhap);
            ResultSet data = pre.executeQuery();
            while(data.next())
            {
                PhieuNhapChiTiet x = new PhieuNhapChiTiet(data.getInt("MaPN"), data.getInt("MaSP"), data.getInt("SoLuongNhap"), data.getFloat("DonGiaNhap"));
                phieuNhapChiTiets.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuNhapChiTiets.toArray(new PhieuNhapChiTiet[phieuNhapChiTiets.size()]);
    }

    @Override
    public boolean Create(PhieuNhapChiTiet x) {
        String query = "INSERT INTO PhieuNhapChiTiet(MaPN, MaSP, SoLuongNhap, DonGiaNhap) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.maPN);
            pre.setInt(2, x.maSP);
            pre.setInt(3, x.soLuongNhap);
            pre.setFloat(4, x.donGiaNhap);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(PhieuNhapChiTiet x) {
        String query = "UPDATE PhieuNhapChiTiet SET SoLuongNhap = ?, DonGiaNhap = ? WHERE MaPN = ? AND MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.soLuongNhap);
            pre.setFloat(2, x.donGiaNhap);
            pre.setInt(3, x.maPN);
            pre.setFloat(4, x.maSP);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int maPhieuNhap, int maSP) {
        String query = "DELETE PhieuNhapChiTiet WHERE MaPN = ? AND MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, maPhieuNhap);
            pre.setFloat(2, maSP);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public PhieuNhapChiTiet GetById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
