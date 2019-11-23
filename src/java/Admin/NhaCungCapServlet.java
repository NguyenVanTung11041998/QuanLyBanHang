package Admin;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCap;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/nha-cung-cap"})
public class NhaCungCapServlet extends HttpServlet {

    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        NhaCungCap[] nhaCungCaps = nhaCungCapDAO.LayDanhSach();
        request.setAttribute("data", nhaCungCaps);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaCungCap/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        NhaCungCap[] nhaCungCaps = nhaCungCapDAO.LayDanhSach();
        request.setAttribute("data", nhaCungCaps);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaCungCap/index.jsp");
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
