package Admin;

import DAO.LoaiSanPhamDAO;
import DAO.NhaCungCapDAO;
import DAO.NhaSanXuatDAO;
import DAO.SanPhamDAO;
import DTO.LoaiSanPham;
import DTO.NhaCungCap;
import DTO.NhaSanXuat;
import DTO.SanPham;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = { "/them-san-pham" })
@MultipartConfig
public class SanPham_CreateServlet extends HttpServlet {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    private NhaSanXuatDAO nhaSanXuatDAO = new NhaSanXuatDAO();
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        LoaiSanPham[] loaiSanPhams = loaiSanPhamDAO.LayDanhSach();
        NhaCungCap[] nhaCungCaps = nhaCungCapDAO.LayDanhSach();
        NhaSanXuat[] nhaSanXuats = nhaSanXuatDAO.LayDanhSach();
        request.setAttribute("dataLoaiSanPham", loaiSanPhams);
        request.setAttribute("dataNhaCungCap", nhaCungCaps);
        request.setAttribute("dataNhaSanXuat", nhaSanXuats);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/SanPham/create.jsp");
        dispatcher.forward( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String tenSanPham = request.getParameter("txtTenSP");
        String gia = request.getParameter("txtDonGia");
        
        if(gia.equals(""))
        {
            out.print("<script>alert(\"Đơn giá không được để trống\"); location.href=\"/QuanLyBanHang/them-san-pham\";</script>");
            return;
        }
        
        String maNCC = request.getParameter("cmbMaNCC");
        String maLoaiSP = request.getParameter("cmbMaLoaiSP");
        String maNSX = request.getParameter("cmbMaNSX");
        
        if(maNCC.equals("") || maLoaiSP.equals("") || maNSX.equals(""))
        {
            out.print("<script>alert(\"Bạn chưa chọn nhà cung cấp hoặc nhà sản xuất, hoặc loại sản phẩm!\"); location.href=\"/QuanLyBanHang/them-san-pham\";</script>");
            return;
        }
        
        int maNhaCungCap = Integer.parseInt(maNCC);
        int maLoaiSanPham = Integer.parseInt(maLoaiSP);
        int maNhaSanXuat = Integer.parseInt(maNSX); 
        float donGia = 0;
        try
        {
            donGia = Float.parseFloat(gia);
        }
        catch(Exception ex)
        {
            out.print("<script>alert(\"Đơn giá phải là số!\"); location.href=\"/QuanLyBanHang/them-san-pham\";</script>");
            return;
        }
        
        String moTa = request.getParameter("txtMoTa");
        String anh = request.getParameter("txtHinhAnh");
        Part filePart = request.getPart("txtHinhAnh");
        String fileName = "";
        if (anh == null || !anh.equals("")) {
            fileName = getFileName(filePart);

            ServletContext servletContext = getServletContext();
            String path = servletContext.getRealPath(File.separator) + "../../" + "web\\Contents\\Upload\\";

            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        SanPham x = new SanPham(0, tenSanPham, donGia, "", moTa, fileName, 0, maNhaCungCap, maNhaSanXuat, maLoaiSanPham, true);
        boolean result = sanPhamDAO.Create(x);
        
        if (result) {
            out.print("<script>alert(\"Thêm thành công\");  location.href=\"/QuanLyBanHang/san-pham\";</script>");
        } else {
            out.print("<script>alert(\"Thêm thất bại\")</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
