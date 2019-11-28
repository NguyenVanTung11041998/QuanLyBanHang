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

@WebServlet(urlPatterns = {"/sua-tai-khoan"})
public class KhachHang_EditServlet extends HttpServlet {

    private KhachHangDAO khachhangDAO = new KhachHangDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        KhachHang khachHang = (KhachHang)session.getAttribute("User");
        request.setAttribute("KhachHang", khachHang);
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang x = khachhangDAO.GetById(id);
        if (x != null) {
            request.setAttribute("data", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Site/KhachHang/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            out.print("<script>alert(\"Bạn chưa đăng nhập\"); location.href=\"/QuanLyBanHang/khach-hang-dang-nhap\";</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("txtEmail");
        String matKhauCu = request.getParameter("txtPass");
        String hoTen = request.getParameter("txtName");
        String diaChi = request.getParameter("txtAddress");
        String matKhauMoi = request.getParameter("txtNewPass");
        String cfMatKhau = request.getParameter("txtCfPass");
        String soDT = request.getParameter("txtPhone");

        if (matKhauMoi.equals("") && matKhauCu.equals("") && cfMatKhau.equals("")) {
            boolean result = khachhangDAO.UpdateInfo(id, hoTen, soDT, diaChi);
            if (result)
                out.print("<script>alert(\"Cập nhật thành công\");  location.href=\"/QuanLyBanHang/trang-chu\";</script>");
            else
                out.print("<script>alert(\"Cập nhật thất bại\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script>");
        } else {
            KhachHang oldKhachHang = khachhangDAO.GetById(id);
            if (matKhauCu.equals(oldKhachHang.matKhau)) {
                out.print("<script>alert(\"Mật khẩu cũ không khớp\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script></script>");
            } else if (!matKhauMoi.equals(cfMatKhau)) {
                out.print("<script>alert(\"Mật khẩu không khớp\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script></script>");
            } else {
                KhachHang x = new KhachHang(id, email, matKhauMoi, hoTen, diaChi, soDT);
                boolean result = khachhangDAO.Update(x);
                if (result)
                    out.print("<script>alert(\"Cập nhật thành công\");  location.href=\"/QuanLyBanHang/trang-chu\";</script>");
                else
                    out.print("<script>alert(\"Cập nhật thất bại\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script>");
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
