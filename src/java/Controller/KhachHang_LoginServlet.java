package Controller;

import DAO.KhachHangDAO;
import DTO.KhachHang;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/khach-hang-dang-nhap" })
public class KhachHang_LoginServlet extends HttpServlet {

    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet KhachHang_LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet KhachHang_LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/Login/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String email = request.getParameter("txtEmail");
        String matKhau = request.getParameter("txtMatKhau");
        
        KhachHang khachHangLogin = khachHangDAO.Login(email, matKhau);
        
        PrintWriter out = response.getWriter();
        if(khachHangLogin != null)
            out.print("<script>alert('Đăng nhập thành công!'); location.href=\"/QuanLyBanHang/trang-chu\";</script>");
        else
            out.print("<script>alert('Sai tài khoản hoặc mật khẩu!'); location.href=\"/QuanLyBanHang/khach-hang-dang-nhap\";</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
