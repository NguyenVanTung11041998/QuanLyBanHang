package Admin;

import DAO.DanhMucDAO;
import DAO.LoaiSanPhamDAO;
import DTO.DanhMuc;
import DTO.LoaiSanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/loai-san-pham" })
public class LoaiSanPhamServlet extends HttpServlet {

    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        LoaiSanPham[] loaiSanPhams = loaiSanPhamDAO.LayDanhSach();
        request.setAttribute("data", loaiSanPhams);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/LoaiSanPham/index.jsp");
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
