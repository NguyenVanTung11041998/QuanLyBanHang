package Controller;

import DAO.GioHangDAO;
import DTO.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/xoa-gio-hang"})
public class GioHang_DeleteServlet extends HttpServlet {

    private GioHangDAO gioHangDAO = new GioHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = gioHangDAO.Delete(id);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
