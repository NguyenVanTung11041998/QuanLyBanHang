package Admin;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuat;
import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/nha-san-xuat"})
public class NhaSanXuatServlet extends HttpServlet {

    private NhaSanXuatDAO nhaSanXuatDAO = new NhaSanXuatDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        NhaSanXuat[] nhaSanXuats = nhaSanXuatDAO.LayDanhSach();
        request.setAttribute("data", nhaSanXuats);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaSanXuat/index.jsp");
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
