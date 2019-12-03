package Controller;

import DAO.GioHangDAO;
import DTO.GioHang;
import DTO.KhachHang;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/gio-hang" })
public class GioHangServlet extends HttpServlet {

    private GioHangDAO gioHangDAO = new GioHangDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang)session.getAttribute("User");
        request.setAttribute("KhachHang", khachHang);
        String x = request.getParameter("id");
        int id = Integer.parseInt(x);
        GioHang[] gioHangs = gioHangDAO.LayDanhSach(id);
        request.setAttribute("data", gioHangs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/GioHang/index.jsp");
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
