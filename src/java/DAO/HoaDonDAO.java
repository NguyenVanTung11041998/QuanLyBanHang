package DAO;

import Corba_DAO.IHoaDonDAOPOA;
import DTO.HoaDon;
import DTO.HoaDonChiTiet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO extends IHoaDonDAOPOA{

    @Override
    public HoaDon[] LayDanhSach() {
        String query = "Select * From HoaDon";
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetData(query);
            while (data.next()) {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"));
                hoaDons.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDons.toArray(new HoaDon[hoaDons.size()]);
    }

    @Override
    public boolean Create(HoaDon x) {
        String query = "INSERT INTO HoaDon(NgayDat, IDKhachHang, TongTien, DaThanhToan) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(x.ngayDat).getTime()));
            pre.setInt(2, x.idKhachHang);
            pre.setFloat(3, x.tongTien);
            pre.setBoolean(4, x.daThanhToan);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(HoaDon x) {
        String query = "UPDATE dbo.HoaDon SET NgayDat = ?, DaThanhToan = ? WHERE MaHD = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(x.ngayDat).getTime()));
            pre.setBoolean(2, x.daThanhToan);
            pre.setInt(3, x.maHD);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ThanhToan(int id) {
        String query = "UPDATE dbo.HoaDon SET DaThanhToan = ~DaThanhToan WHERE MaHD = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.executeUpdate();
            query = "SELECT DaThanhToan FROM dbo.HoaDon WHERE MaHD = ?";
            pre.setInt(1, id);
            ResultSet data = DataProvider.getInstance().GetData(query);
            while(data.next())
            {
                return data.getBoolean("DaThanhToan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public HoaDon[] TimKiem(String date) {
        String query = "Select * From HoaDon Where NgayDat = ?";
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(date).getTime()));
            ResultSet data = pre.executeQuery();
            while(data.next())
            {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"));
                hoaDons.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDons.toArray(new HoaDon[hoaDons.size()]);
    }
}
