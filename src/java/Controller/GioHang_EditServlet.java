package Controller;

import DAO.GioHangDAO;
import DTO.GioHang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/sua-gio-hang" })
public class GioHang_EditServlet extends HttpServlet {

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
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        GioHang gioHang = new GioHang(id, 1, id, soLuong, true, "");
        boolean result = gioHangDAO.Update(gioHang);
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
