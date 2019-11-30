package Admin;

import DAO.DanhMucDAO;
import DAO.LoaiSanPhamDAO;
import DTO.DanhMuc;
import DTO.LoaiSanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/sua-loai-san-pham"})
public class LoaiSanPham_EditServlet extends HttpServlet {

    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DanhMuc[] danhMucs = danhMucDAO.LayDanhSach();
        request.setAttribute("data", danhMucs);
        int id = Integer.parseInt(request.getParameter("id"));
        LoaiSanPham x = loaiSanPhamDAO.GetById(id);
        if (x != null) {
            request.setAttribute("model", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/LoaiSanPham/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print("<script>alert(\"Không có loại sản phẩm cần sửa\"); location.href=\"/QuanLyBanHang/loai-san-pham\";</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenLoai = request.getParameter("txtTenLoaiSP");
        String maDanhMucString = request.getParameter("cmbMaDanhMuc");
        int maDanhMuc = Integer.parseInt(maDanhMucString);
        int id = Integer.parseInt(request.getParameter("id"));
        LoaiSanPham x = new LoaiSanPham(id, tenLoai, maDanhMuc, "");
        boolean result = loaiSanPhamDAO.Update(x);
        PrintWriter out = response.getWriter();
        if (result)
            out.print("<script>alert(\"Sửa thành công\"); location.href=\"/QuanLyBanHang/loai-san-pham\";</script>");
        else
            out.print("<script>alert(\"Sửa thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
