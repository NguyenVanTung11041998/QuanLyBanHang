package Admin;

import DAO.NhaSanXuatDAO;
import DTO.NhaSanXuat;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

@WebServlet(urlPatterns = {"/them-nha-san-xuat"})
@MultipartConfig
public class NhaSanXuat_CreateServlet extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/NhaSanXuat/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String tenNhaSanXuat = request.getParameter("txtTenNSX");
        String thongTin = request.getParameter("txtThongTin");
        String logo = request.getParameter("txtLogo");
        Part filePart = request.getPart("txtLogo");
        String fileName = "";
        if (logo == null || !logo.equals("")) {
            fileName = getFileName(filePart);

            ServletContext servletContext = getServletContext();
            String path = servletContext.getRealPath(File.separator) + "../../" + "web\\Contents\\Upload\\";

            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(path + fileName), StandardCopyOption.REPLACE_EXISTING);
        }
        NhaSanXuat x = new NhaSanXuat(0, tenNhaSanXuat, thongTin, fileName);
        boolean result = nhaSanXuatDAO.Create(x);
        PrintWriter out = response.getWriter();
        if (result) {
            out.print("<script>alert(\"Thêm thành công\");  location.href=\"/QuanLyBanHang/nha-san-xuat\";</script>");
        } else {
            out.print("<script>alert(\"Thêm thất bại\")</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
