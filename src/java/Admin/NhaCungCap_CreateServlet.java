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

@WebServlet(urlPatterns = { "/Admin/NhaCungCap/Create" })
public class NhaCungCap_CreateServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NhaCungCap_CreateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NhaCungCap_CreateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaCungCap/create.jsp");
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenNCC = request.getParameter("txtTenNCC");
        String diaChi = request.getParameter("txtDiaChi");
        String soDT = request.getParameter("txtSoDT");
        String email = request.getParameter("txtEmail");
        NhaCungCap x = new NhaCungCap(0, tenNCC, diaChi, soDT, email);
        boolean result = nhaCungCapDAO.Create(x);
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("<script>alert(\"Thêm thành công\")</script>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaCungCap/index.jsp");
            dispatcher.forward(request, response);
        }
        else
            out.print("<script>alert(\"Thêm thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
