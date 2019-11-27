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

@WebServlet(urlPatterns = { "/them-nha-cung-cap" })
public class NhaCungCap_CreateServlet extends HttpServlet {
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();

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
        if (result)
            out.print("<script>alert(\"Thêm thành công\");  location.href=\"/QuanLyBanHang/nha-cung-cap\";</script>");
        else
            out.print("<script>alert(\"Thêm thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
