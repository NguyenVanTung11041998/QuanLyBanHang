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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(PhieuNhapChiTiet x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
