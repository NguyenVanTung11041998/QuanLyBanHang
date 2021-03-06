package Admin;

import DAO.*;
import DTO.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/admin-dang-nhap" })
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        response.sendRedirect("Admin/Login/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String taiKhoan = request.getParameter("txtTaiKhoan");
        String matKhau = request.getParameter("txtMatKhau");
        AccountAdmin accountAdmin = AccountAdminDAO.getInstance().Login(taiKhoan, matKhau);
        PrintWriter out = response.getWriter();
        if(accountAdmin != null)
            out.print("<script>alert('Đăng nhập thành công!'); location.href=\"/QuanLyBanHang/trang-chu-quan-ly\";</script>");
        else
            out.print("<script>alert('Sai tài khoản hoặc mật khẩu!'); location.href=\"/QuanLyBanHang/LoginServlet\";</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
