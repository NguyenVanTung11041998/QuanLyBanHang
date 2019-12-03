package Admin;

import DAO.HoaDonDAO;
import DTO.HoaDon;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/xu-ly-hoa-don" })
public class HoaDon_PayServlet extends HttpServlet {

    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
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
        hoaDonDAO.Pay(id);
        HoaDon x = hoaDonDAO.GetById(id);
        PrintWriter out = response.getWriter();
        out.print(x.daThanhToan);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
