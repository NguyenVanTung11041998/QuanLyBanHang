package Admin;

import DAO.SanPhamDAO;
import DTO.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SanPham_ChangeStatusServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        sanPhamDAO.UpdateStatus(id);
        SanPham x = sanPhamDAO.GetById(id);
        PrintWriter out = response.getWriter();
        out.print(x.trangThai);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
