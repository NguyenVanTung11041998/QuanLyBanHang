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
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = { "/khach-hang-dang-nhap" })
public class KhachHang_LoginServlet extends HttpServlet {

    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang)session.getAttribute("User");
        request.setAttribute("KhachHang", khachHang);
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
        if (khachHangLogin != null) {
            out.print("<script>alert('Đăng nhập thành công!'); location.href=\"/QuanLyBanHang/trang-chu\";</script>");
            HttpSession session = request.getSession();
            session.setAttribute("User", khachHangLogin);
        } else {
            out.print("<script>alert('Sai tài khoản hoặc mật khẩu!'); location.href=\"/QuanLyBanHang/khach-hang-dang-nhap\";</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
