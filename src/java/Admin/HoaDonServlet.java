package Admin;

import DAO.HoaDonDAO;
import DTO.HoaDon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/hoa-don" })
public class HoaDonServlet extends HttpServlet {

    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HoaDon[] hoaDons = hoaDonDAO.LayDanhSach();
        request.setAttribute("data", hoaDons);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/HoaDon/index.jsp");
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
