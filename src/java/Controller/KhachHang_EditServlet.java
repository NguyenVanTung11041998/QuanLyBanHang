
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

@WebServlet(urlPatterns = { "/sua-tai-khoan" })
public class KhachHang_EditServlet extends HttpServlet {
      private KhachHangDAO khachhangDAO = new KhachHangDAO();
  
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();
          response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
         int id = Integer.parseInt(request.getParameter("id"));
        KhachHang x = khachhangDAO.GetById(id);
        if(x != null)
        {
            request.setAttribute("data", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Site/KhachHang/edit.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
           
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
        String Email = request.getParameter("txtEmail");
        String MatKhau = request.getParameter("txtPass");
        String HoTen = request.getParameter("txtName");
        String DiaChi = request.getParameter("txtAddress");
        String CfMatKhau = request.getParameter("txtCfPass");
        String SoDT = request.getParameter("txtPhone");
        if(! MatKhau.equals(CfMatKhau) ){
            {
                out.print("<script>alert(\"Mật khẩu không khớp\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script></script>");
            }
        }else{
              KhachHang x = new KhachHang(id, Email, MatKhau, HoTen, DiaChi, SoDT);
                boolean result = khachhangDAO.Update(x);
                  if (result)
            out.print("<script>alert(\"Cập nhật thành công\");  location.href=\"/QuanLyBanHang/trang-chu\";</script>");
                 else
            out.print("<script>alert(\"Cập nhật thất bại\"); location.href=\"/QuanLyBanHang/sua-tai-khoan\";</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
