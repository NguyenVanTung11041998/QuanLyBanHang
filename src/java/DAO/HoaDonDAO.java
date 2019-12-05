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
import org.omg.CORBA.ORB;

public class HoaDonDAO extends IHoaDonDAOPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }

    @Override
    public HoaDon[] LayDanhSach() {
        String query = "SELECT MaHD, NgayDat, IDKhachHang, TongTien, DaThanhToan, HoTen FROM dbo.HoaDon INNER JOIN dbo.KhachHang ON KhachHang.ID = HoaDon.IDKhachHang";
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetData(query);
            while (data.next()) {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"), data.getString("HoTen"));
                hoaDons.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDons.toArray(new HoaDon[hoaDons.size()]);
    }

    @Override
    public boolean Create(HoaDon x) {
        String query = "INSERT INTO HoaDon(NgayDat, IDKhachHang, TongTien, DaThanhToan) VALUES (GETDATE(), ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, x.idKhachHang);
            pre.setFloat(2, x.tongTien);
            pre.setBoolean(3, x.daThanhToan);
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
            while (data.next()) {
                return data.getBoolean("DaThanhToan");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public HoaDon[] TimKiem(String date) {
        String query = "SELECT MaHD, NgayDat, IDKhachHang, TongTien, DaThanhToan, HoTen FROM dbo.HoaDon INNER JOIN dbo.KhachHang ON KhachHang.ID = HoaDon.IDKhachHang Where NgayDat = ?";
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setDate(1, new java.sql.Date(new java.util.Date(date).getTime()));
            ResultSet data = pre.executeQuery();
            while (data.next()) {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"), data.getString("HoTen"));
                hoaDons.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDons.toArray(new HoaDon[hoaDons.size()]);
    }

    @Override
    public HoaDon GetHoaDonCuoiCungTheoKhachHang(int idKhachHang) {
        String query = "SELECT TOP 1 MaHD, NgayDat, IDKhachHang, TongTien, DaThanhToan, HoTen FROM dbo.HoaDon INNER JOIN dbo.KhachHang ON KhachHang.ID = HoaDon.IDKhachHang WHERE IdKhachHang = ? ORDER BY MaHD DESC";
        ResultSet data = DataProvider.getInstance().GetById(query, idKhachHang);
        try {
            while (data.next()) {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"), data.getString("HoTen"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public HoaDon GetById(int id) {
        String query = "SELECT MaHD, NgayDat, IDKhachHang, TongTien, DaThanhToan, HoTen FROM dbo.HoaDon INNER JOIN dbo.KhachHang ON KhachHang.ID = HoaDon.IDKhachHang Where MaHD = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while (data.next()) {
                HoaDon x = new HoaDon(data.getInt("MaHD"), data.getString("NgayDat"), data.getInt("IDKhachHang"), data.getFloat("TongTien"), data.getBoolean("DaThanhToan"), data.getString("HoTen"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void Pay(int id) {
        String query = "Update HoaDon Set DaThanhToan = ~DaThanhToan Where MaHD = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
