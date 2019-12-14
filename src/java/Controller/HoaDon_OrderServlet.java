package Controller;

import DAO.GioHangDAO;
import DAO.HoaDonChiTietDAO;
import DAO.HoaDonDAO;
import DAO.SanPhamDAO;
import DTO.GioHang;
import DTO.HoaDon;
import DTO.HoaDonChiTiet;
import DTO.KhachHang;
import DTO.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/dat-hang" })
public class HoaDon_OrderServlet extends HttpServlet {

    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
    private GioHangDAO gioHangDAO = new GioHangDAO();
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("User");
        float tongTien = gioHangDAO.GetTongTienSanPhamTrongGioTheoKhachHang(khachHang.id);
        HoaDon x = new HoaDon(0, "", khachHang.id, tongTien, false, "");
        hoaDonDAO.Create(x);
        x = hoaDonDAO.GetHoaDonCuoiCungTheoKhachHang(khachHang.id);
        GioHang[] gioHangs = gioHangDAO.LayDanhSach(khachHang.id);
        PrintWriter out = response.getWriter();
        if(gioHangs.length == 0)
        {
            out.print("false");
            return;
        }
        for(GioHang item : gioHangs)
        {
            SanPham sanPham = sanPhamDAO.GetById(item.maSP);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet(x.maHD, item.maSP, item.soLuongDat, sanPham.donGia, "");
            hoaDonChiTietDAO.Insert(hoaDonChiTiet);
            gioHangDAO.Delete(item.id);
        }
        out.print("true");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
