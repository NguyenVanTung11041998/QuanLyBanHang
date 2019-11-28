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

@WebServlet(urlPatterns = {"/dang-ky-tai-khoan"})
public class KhachHang_RegisterServlet extends HttpServlet {

    private KhachHangDAO khachhangDAO = new KhachHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang)session.getAttribute("User");
        request.setAttribute("KhachHang", khachHang);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Site/KhachHang/register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("txtEmail");
        String matKhau = request.getParameter("txtPass");
        String hoTen = request.getParameter("txtName");
        String diaChi = request.getParameter("txtAddress");
        String cfMatKhau = request.getParameter("txtCfPass");
        String soDT = request.getParameter("txtPhone");
        if (!matKhau.equals(cfMatKhau))
                out.print("<script>alert(\"Mật khẩu không khớp\"); location.href=\"/QuanLyBanHang/dang-ky-tai-khoan\";</script></script>");
        else {
            KhachHang x = new KhachHang(0, email, matKhau, hoTen, diaChi, soDT);
            boolean result = khachhangDAO.Create(x);
            if (result)
                out.print("<script>alert(\"Đăng ký thành công\");  location.href=\"/QuanLyBanHang/khach-hang-dang-nhap\";</script>");
            else
                out.print("<script>alert(\"Đăng ký thất bại\"); location.href=\"/QuanLyBanHang/dang-ky-tai-khoan\";</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
