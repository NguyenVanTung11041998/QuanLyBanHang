package Admin;

import DAO.PhieuNhapChiTietDAO;
import DTO.PhieuNhapChiTiet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/phieu-nhap-chi-tiet" })
public class PhieuNhapChiTietServlet extends HttpServlet {

    private PhieuNhapChiTietDAO phieuNhapChiTietDAO = new PhieuNhapChiTietDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        PhieuNhapChiTiet[] phieuNhapChiTiets = phieuNhapChiTietDAO.LayDanhSach(id);
        request.setAttribute("data", phieuNhapChiTiets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/PhieuNhapChiTiet/index.jsp");
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
