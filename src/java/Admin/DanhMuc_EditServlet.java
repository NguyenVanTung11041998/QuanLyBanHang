package Admin;

import DAO.DanhMucDAO;
import DTO.DanhMuc;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DanhMuc_EditServlet extends HttpServlet {
    private DanhMucDAO danhMucDAO = new DanhMucDAO();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DanhMuc_EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhMuc_EditServlet at " + request.getContextPath() + "</h1>");
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
        DanhMuc x = danhMucDAO.GetById(id);
        if(x != null)
        {
            request.setAttribute("data", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/DanhMuc/edit.jsp");
            dispatcher.forward(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.print("<script>alert(\"Không có danh mục cần sửa\"); location.href=\"/QuanLyBanHang/DanhMucServlet\";</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String tenLoaiDanhMuc = request.getParameter("txtTenDanhMuc");
        DanhMuc x = new DanhMuc(id, tenLoaiDanhMuc);
        boolean result = danhMucDAO.Update(x);
        PrintWriter out = response.getWriter();
        if (result)
            out.print("<script>alert(\"Sửa thành công\"); location.href=\"/QuanLyBanHang/DanhMucServlet\";</script>");
        else
            out.print("<script>alert(\"Sửa thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
