package Admin;

import DAO.SanPhamDAO;
import DTO.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/san-pham" })
public class SanPhamServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        SanPham[] sanPhams = sanPhamDAO.LayDanhSach();
        request.setAttribute("data", sanPhams);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/SanPham/index.jsp");
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
