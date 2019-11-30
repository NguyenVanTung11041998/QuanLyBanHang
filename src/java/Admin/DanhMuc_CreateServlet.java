package Admin;

import DAO.DanhMucDAO;
import DTO.DanhMuc;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/them-danh-muc" })
public class DanhMuc_CreateServlet extends HttpServlet {

    private DanhMucDAO danhMucDAO = new DanhMucDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/DanhMuc/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenDanhMuc = request.getParameter("txtTenDanhMuc");
        DanhMuc x = new DanhMuc(0, tenDanhMuc);
        boolean result = danhMucDAO.Create(x);
        PrintWriter out = response.getWriter();
        if (result)
            out.print("<script>alert(\"Thêm thành công\"); location.href=\"/QuanLyBanHang/danh-muc\";</script>");
        else
            out.print("<script>alert(\"Thêm thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
