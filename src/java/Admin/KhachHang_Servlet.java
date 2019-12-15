package Admin;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/khach-hang" })
public class KhachHang_Servlet extends HttpServlet {

    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        KhachHang[] khachHangs = khachHangDAO.LayDanhSach();
        request.setAttribute("data", khachHangs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/KhachHang/index.jsp");
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
