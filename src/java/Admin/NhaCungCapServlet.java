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

@WebServlet(urlPatterns = {"/Admin/NhaCungCap"})
public class NhaCungCapServlet extends HttpServlet {

    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NhaCungCapServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NhaCungCapServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
