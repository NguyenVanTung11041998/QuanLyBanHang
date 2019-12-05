package Admin;

import DAO.PhieuNhapChiTietDAO;
import DAO.PhieuNhapDAO;
import DAO.SanPhamDAO;
import DTO.PhieuNhap;
import DTO.PhieuNhapChiTiet;
import DTO.SanPham;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/them-phieu-nhap" })
public class PhieuNhap_CreateServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private PhieuNhapDAO phieuNhapDAO = new PhieuNhapDAO();
    private PhieuNhapChiTietDAO phieuNhapChiTietDAO = new PhieuNhapChiTietDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        SanPham[] sanPhams = sanPhamDAO.LayDanhSach();
        request.setAttribute("dataSanPham", sanPhams);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/PhieuNhap/create.jsp");
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ngayLap = request.getParameter("txtNgayNhap");
        Cookie[] cookies = request.getCookies();
        int soLuong = 0;
        for(Cookie item : cookies)
            if(item.getName().equals("RowCount"))
            {
                soLuong = Integer.parseInt(item.getValue());
                break;
            }
        PhieuNhap phieuNhap = new PhieuNhap(0, ngayLap, 0);
        phieuNhapDAO.Create(phieuNhap);
        phieuNhap = phieuNhapDAO.GetPhieuNhapCuoiCung();
        for(int i = 0; i < soLuong; i++)
        {
            int maSP = Integer.parseInt(request.getParameter("MaSP_" + i));
            int soLuongNhap = Integer.parseInt(request.getParameter("SoLuongNhap_" + i));
            float donGiaNhap = Float.parseFloat(request.getParameter("DonGiaNhap_" + i));
            PhieuNhapChiTiet phieuNhapChiTiet = new PhieuNhapChiTiet(phieuNhap.maPN, maSP, soLuongNhap, donGiaNhap, "");
            phieuNhapChiTietDAO.Create(phieuNhapChiTiet);
        }
        PrintWriter out = response.getWriter();
        out.print("<script>alert(\"Thêm thành công\"); location.href=\"/QuanLyBanHang/phieu-nhap\";</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
