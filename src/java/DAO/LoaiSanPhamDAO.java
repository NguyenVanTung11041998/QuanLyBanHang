package DAO;

import Corba_DAO.ILoaiSanPhamDAOPOA;
import DTO.LoaiSanPham;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CORBA.ORB;

public class LoaiSanPhamDAO extends ILoaiSanPhamDAOPOA {
    private ORB orb;

    public void setOrb(ORB orb) {
        this.orb = orb;
    }
    @Override
    public LoaiSanPham[] LayDanhSach() {
        String query = "Select MaLoaiSP, TenLoai, dbo.LoaiSanPham.MaDanhMuc, TenDanhMuc From LoaiSanPham Inner Join DanhMuc On LoaiSanPham.MaDanhMuc = DanhMuc.MaDanhMuc";
        ArrayList<LoaiSanPham> loaiSanPhams = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetData(query);
            while (data.next()) {
                LoaiSanPham x = new LoaiSanPham(data.getInt("MaLoaiSP"), data.getString("TenLoai"), data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                loaiSanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiSanPhams.toArray(new LoaiSanPham[loaiSanPhams.size()]);
    }

    @Override
    public boolean Create(LoaiSanPham x) {
        String query = "INSERT INTO LoaiSanPham(TenLoai, MaDanhMuc) VALUES (?, ?)";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenLoai);
            pre.setInt(2, x.maDanhMuc);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Update(LoaiSanPham x) {
        String query = "UPDATE LoaiSanPham SET TenLoai = ?, MaDanhMuc = ? WHERE MaLoaiSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setString(1, x.tenLoai);
            pre.setInt(2, x.maDanhMuc);
            pre.setInt(3, x.maLoaiSP);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean Delete(int id) {
        String query = "Delete LoaiSanPham Where MaLoaiSP = ?";
        try {
            PreparedStatement pre = DataProvider.getInstance().getConnection().prepareStatement(query);
            pre.setInt(1, id);
            int result = pre.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public LoaiSanPham[] TimKiem(String search) {
        ResultSet data = DataProvider.getInstance().GetDataSearch("Select * From LoaiSanPham Where TenLoai LIKE ?", search);
        ArrayList<LoaiSanPham> loaiSanPhams = new ArrayList<>();
        try {
            while (data.next()) {
                LoaiSanPham x = new LoaiSanPham(data.getInt("MaLoaiSP"), data.getString("TenLoai"), data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                loaiSanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiSanPhams.toArray(new LoaiSanPham[loaiSanPhams.size()]);
    }

    @Override
    public LoaiSanPham GetById(int id) {
        String query = "Select MaLoaiSP, TenLoai, dbo.LoaiSanPham.MaDanhMuc, TenDanhMuc From LoaiSanPham Inner Join DanhMuc On LoaiSanPham.MaDanhMuc = DanhMuc.MaDanhMuc Where MaLoaiSP = ?";
        ResultSet data = DataProvider.getInstance().GetById(query, id);
        try {
            while(data.next())
            {
                LoaiSanPham x = new LoaiSanPham(data.getInt("MaLoaiSP"), data.getString("TenLoai"), data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiSanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public LoaiSanPham[] LayDanhSachTheoDanhMuc(int id) {
        String query = "Select MaLoaiSP, TenLoai, dbo.LoaiSanPham.MaDanhMuc, TenDanhMuc From LoaiSanPham Inner Join DanhMuc On LoaiSanPham.MaDanhMuc = DanhMuc.MaDanhMuc Where DanhMuc.MaDanhMuc = ?";
        ArrayList<LoaiSanPham> loaiSanPhams = new ArrayList<>();
        try {
            ResultSet data = DataProvider.getInstance().GetById(query, id);
            while (data.next()) {
                LoaiSanPham x = new LoaiSanPham(data.getInt("MaLoaiSP"), data.getString("TenLoai"), data.getInt("MaDanhMuc"), data.getString("TenDanhMuc"));
                loaiSanPhams.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loaiSanPhams.toArray(new LoaiSanPham[loaiSanPhams.size()]);
    }

}
