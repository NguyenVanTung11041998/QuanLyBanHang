package Controller;

import DAO.GioHangDAO;
import DAO.SanPhamDAO;
import DTO.GioHang;
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

@WebServlet(urlPatterns = {"/them-gio-hang"})
public class GioHang_CreateServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private GioHangDAO gioHangDAO = new GioHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sanPham = sanPhamDAO.GetById(id);
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang) session.getAttribute("User");
        PrintWriter out = response.getWriter();
        if(khachHang == null)
        {
            out.print(false);
            return;
        }
        request.setAttribute("KhachHang", khachHang);
        int soLuongDat = 1;
        int idKhachHang = khachHang.id;
        GioHang gioHang = new GioHang(0, idKhachHang, id, soLuongDat, true, sanPham.tenSP);
        boolean result = gioHangDAO.Create(gioHang);
        out.print(result);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
