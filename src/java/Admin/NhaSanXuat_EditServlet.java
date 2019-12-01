package Admin;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuat;
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

@WebServlet(urlPatterns = {"/sua-nha-san-xuat"})
@MultipartConfig
public class NhaSanXuat_EditServlet extends HttpServlet {

    private NhaSanXuatDAO nhaSanXuatDAO = new NhaSanXuatDAO();

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        NhaSanXuat x = nhaSanXuatDAO.GetById(id);
        if (x != null) {
            request.setAttribute("data", x);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaSanXuat/edit.jsp");
            dispatcher.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            out.print("<script>alert(\"Không có nhà sản xuất cần sửa\"); location.href=\"/QuanLyBanHang/nha-san-xuat\";</script>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String tenNhaSanXuat = request.getParameter("txtTenNSX");
        String thongTin = request.getParameter("txtThongTin");
        String logo = request.getParameter("txtLogo");
        Part filePart = request.getPart("txtLogo");
        boolean result = false;
        if (logo != null && logo.equals(""))
            result = nhaSanXuatDAO.UpdateInfo(id, tenNhaSanXuat, thongTin);
        else {
            String fileName = getFileName(filePart);

            ServletContext servletContext = getServletContext();
            String path = servletContext.getRealPath(File.separator) + "../../" + "web\\Contents\\Upload\\";

            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
            NhaSanXuat x = new NhaSanXuat(id, tenNhaSanXuat, thongTin, fileName);
            result = nhaSanXuatDAO.Update(x);
        }
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("<script>alert(\"Sửa thành công\"); location.href=\"/QuanLyBanHang/nha-san-xuat\";</script>");
        } else {
            out.print("<script>alert(\"Không có nhà sản xuất cần sửa\");</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
