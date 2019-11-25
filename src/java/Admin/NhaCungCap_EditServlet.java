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

@WebServlet(urlPatterns = { "/sua-nha-cung-cap" })
public class NhaCungCap_EditServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NhaCungCap_EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NhaCungCap_EditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        NhaCungCap x = nhaCungCapDAO.GetById(id);
        if(x != null)
        {
            request.setAttribute("data", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaCungCap/edit.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.print("<script>alert(\"Không có nhà cung cấp cần sửa\"); location.href=\"/QuanLyBanHang/nha-cung-cap\";</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String tenNCC = request.getParameter("txtTenNCC");
        String diaChi = request.getParameter("txtDiaChi");
        String soDT = request.getParameter("txtSoDT");
        String email = request.getParameter("txtEmail");
        NhaCungCap x = new NhaCungCap(id, tenNCC, diaChi, soDT, email);
        boolean result = nhaCungCapDAO.Update(x);
        PrintWriter out = response.getWriter();
        if (result)
            out.print("<script>alert(\"Sửa thành công\");  location.href=\"/QuanLyBanHang/nha-cung-cap\";</script>");
        else
            out.print("<script>alert(\"Không có nhà cung cấp cần sửa\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}