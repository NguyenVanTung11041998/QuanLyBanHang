package Controller;

import DAO.DanhMucDAO;
import DAO.LoaiSanPhamDAO;
import DAO.SanPhamDAO;
import DTO.DanhMuc;
import DTO.KhachHang;
import DTO.LoaiSanPham;
import DTO.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/danh-sach-san-pham" })
public class SanPham_DanhSachServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();
    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang)session.getAttribute("User");
        request.setAttribute("KhachHang", khachHang);
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham[] sanPhams = sanPhamDAO.GetListSanPhamTheoLoaiSanPham(id);
        request.setAttribute("data", sanPhams);
        
        DanhMuc[] danhMucs = danhMucDAO.LayDanhSach();
        for(int i = 0; i < danhMucs.length; i++)
        {
            LoaiSanPham[] loaiSanPhams = loaiSanPhamDAO.LayDanhSachTheoDanhMuc(danhMucs[i].maDanhMuc);
            request.setAttribute("dataLoaiSP" + i, loaiSanPhams);
        }
        request.setAttribute("dataDanhMuc", danhMucs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/SanPham/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
