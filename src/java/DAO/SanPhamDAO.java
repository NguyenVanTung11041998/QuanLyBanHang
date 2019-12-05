package DAO;

import Corba_DAO.ISanPhamDAOPOA;
import DTO.SanPham;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class SanPhamDAO extends ISanPhamDAOPOA {

    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    @Override
    public SanPham[] LayDanhSach() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetData("Select * From SanPham");
        try {
            while (data.next()) {
                SanPham x = new SanPham(data.getInt("MaSP"), data.getString("TenSP"), data.getFloat("DonGia"), data.getString("NgayCapNhat"), data.getString("MoTa"), data.getString("HinhAnh"), data.getInt("SoLuongTon"), data.getInt("MaNCC"), data.getInt("MaNSX"), data.getInt("MaLoaiSP"), data.getBoolean("TrangThai"));
                sanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPhams.toArray(new SanPham[sanPhams.size()]);
    }

    @Override
    public boolean Create(SanPham x) {

        String query = "INSERT INTO dbo.SanPham (TenSP, DonGia, NgayCapNhat, MoTa, HinhAnh, SoLuongTon, MaNCC, MaNSX, MaLoaiSP, TrangThai) VALUES (?, ?, GetDATE(), ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenSP);
            pre.setFloat(2, x.donGia);
            pre.setString(3, x.moTa);
            pre.setString(4, x.hinhAnh);
            pre.setInt(5, x.soLuongTon);
            pre.setInt(6, x.maNCC);
            pre.setInt(7, x.maNSX);
            pre.setInt(8, x.maLoaiSP);
            pre.setBoolean(9, x.trangThai);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(SanPham x) {
        String query = "UPDATE dbo.SanPham SET TenSP = ?, DonGia = ?, NgayCapNhat = GetDATE(), MoTa = ?, HinhAnh = ?, SoLuongTon = ?, MaNCC = ?, MaNSX = ?, MaLoaiSP = ?, TrangThai = ? WHERE MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenSP);
            pre.setFloat(2, x.donGia);
            pre.setString(3, x.moTa);
            pre.setString(4, x.hinhAnh);
            pre.setInt(5, x.soLuongTon);
            pre.setInt(6, x.maNCC);
            pre.setInt(7, x.maNSX);
            pre.setInt(8, x.maLoaiSP);
            pre.setBoolean(9, x.trangThai);
            pre.setInt(10, x.maSP);    
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "Delete SanPham Where MaSP = ?";
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
    public SanPham[] TimKiem(String search) {
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select * From SanPham Where TenSP LIKE ?", search);
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        try {
            while (data.next()) {
                SanPham x = new SanPham(data.getInt("MaSP"), data.getString("TenSP"), data.getFloat("DonGia"), data.getString("NgayCapNhat"), data.getString("MoTa"), data.getString("HinhAnh"), data.getInt("SoLuongTon"), data.getInt("MaNCC"), data.getInt("MaNSX"), data.getInt("MaLoaiSP"), data.getBoolean("TrangThai"));
                sanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPhams.toArray(new SanPham[sanPhams.size()]);
    }

    @Override
    public SanPham GetById(int id) {
        String query = "Select * From SanPham Where MaSP = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while(data.next())
            {
                SanPham x = new SanPham(data.getInt("MaSP"), data.getString("TenSP"), data.getFloat("DonGia"), data.getString("NgayCapNhat"), data.getString("MoTa"), data.getString("HinhAnh"), data.getInt("SoLuongTon"), data.getInt("MaNCC"), data.getInt("MaNSX"), data.getInt("MaLoaiSP"), data.getBoolean("TrangThai"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void UpdateStatus(int id) {
        String query = "Update SanPham Set TrangThai = ~TrangThai Where MaSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SanPham[] GetListSanPhamMoiNhat() {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetData("Select Top 20 * From SanPham");
        try {
            while (data.next()) {
                SanPham x = new SanPham(data.getInt("MaSP"), data.getString("TenSP"), data.getFloat("DonGia"), data.getString("NgayCapNhat"), data.getString("MoTa"), data.getString("HinhAnh"), data.getInt("SoLuongTon"), data.getInt("MaNCC"), data.getInt("MaNSX"), data.getInt("MaLoaiSP"), data.getBoolean("TrangThai"));
                sanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPhams.toArray(new SanPham[sanPhams.size()]);
    }

    @Override
    public SanPham[] GetListSanPhamTimKiem(String search) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SanPham[] GetListSanPhamTheoLoaiSanPham(int id) {
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        ResultSet data = DataProvider.getInstance().GetById("Select * From SanPham Where MaLoaiSP = ?", id);
        try {
            while (data.next()) {
                SanPham x = new SanPham(data.getInt("MaSP"), data.getString("TenSP"), data.getFloat("DonGia"), data.getString("NgayCapNhat"), data.getString("MoTa"), data.getString("HinhAnh"), data.getInt("SoLuongTon"), data.getInt("MaNCC"), data.getInt("MaNSX"), data.getInt("MaLoaiSP"), data.getBoolean("TrangThai"));
                sanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPhams.toArray(new SanPham[sanPhams.size()]);
    }
}
