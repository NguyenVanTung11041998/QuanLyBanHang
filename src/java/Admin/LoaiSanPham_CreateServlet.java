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

@WebServlet(urlPatterns = { "/them-loai-san-pham" })
public class LoaiSanPham_CreateServlet extends HttpServlet {
    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    private DanhMucDAO danhMucDAO = new DanhMucDAO();

    public LoaiSanPham_CreateServlet() {
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        DanhMuc[] danhMucs = danhMucDAO.LayDanhSach();
        request.setAttribute("data", danhMucs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/LoaiSanPham/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenLoai = request.getParameter("txtTenLoaiSP");
        String maDanhMucString = request.getParameter("cmbMaDanhMuc");
        PrintWriter out = response.getWriter();
        if(maDanhMucString.equals(""))
        {
            out.print("<script>alert(\"Bạn chưa chọn danh mục\"); location.href=\"/QuanLyBanHang/them-loai-san-pham\";</script>");
            return;
        }
        int maDanhMuc = Integer.parseInt(maDanhMucString);
        LoaiSanPham x = new LoaiSanPham(0, tenLoai, maDanhMuc, "");
        boolean result = loaiSanPhamDAO.Create(x);
        
        if (result)
            out.print("<script>alert(\"Thêm thành công\"); location.href=\"/QuanLyBanHang/loai-san-pham\";</script>");
        else
            out.print("<script>alert(\"Thêm thất bại\")</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
