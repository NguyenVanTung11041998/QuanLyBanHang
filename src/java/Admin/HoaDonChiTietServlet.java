package Admin;

import DAO.HoaDonChiTietDAO;
import DTO.HoaDonChiTiet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hoa-don-chi-tiet" })
public class HoaDonChiTietServlet extends HttpServlet {

    private HoaDonChiTietDAO hoaDonChiTietDAO = new HoaDonChiTietDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        HoaDonChiTiet[] hoaDonChiTiets = hoaDonChiTietDAO.LayDanhSachHoaDonChiTiet(id);
        request.setAttribute("data", hoaDonChiTiets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/HoaDonChiTiet/index.jsp");
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
