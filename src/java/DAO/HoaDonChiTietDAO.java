package DAO;

import Corba_DAO.IHoaDonChiTietDAOPOA;
import DTO.HoaDonChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonChiTietDAO extends IHoaDonChiTietDAOPOA{

    @Override
    public HoaDonChiTiet[] LayDanhSachHoaDonChiTiet(int idHoaDon) {
        String query = "SELECT MaHD, HoaDonChiTiet.MaSP, SoLuongMua, HoaDonChiTiet.DonGia, TenSP FROM dbo.HoaDonChiTiet INNER JOIN dbo.SanPham ON SanPham.MaSP = HoaDonChiTiet.MaSP Where MaHD = ?";
        ArrayList<HoaDonChiTiet> hoaDonChiTiets = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, idHoaDon);
            ResultSet data = pre.executeQuery();
            while(data.next())
            {
                HoaDonChiTiet x = new HoaDonChiTiet(data.getInt("MaHD"), data.getInt("MaSP"), data.getInt("SoLuongMua"), data.getFloat("DonGia"), data.getString("TenSP"));
                hoaDonChiTiets.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDonChiTiets.toArray(new HoaDonChiTiet[hoaDonChiTiets.size()]);
    }

    @Override
    public void Insert(HoaDonChiTiet x) {
        String query = "Insert into HoaDonChiTiet Values (?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.maHD);
            pre.setInt(2, x.maSP);
            pre.setInt(3, x.soLuongMua);
            pre.setFloat(4, x.donGia);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
