/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import DAO.PhieuNhapDAO;
import DTO.PhieuNhap;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/phieu-nhap" })
public class PhieuNhapServlet extends HttpServlet {
 private PhieuNhapDAO phieunhapDAO = new PhieuNhapDAO();
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
         PhieuNhap[] phieunhaps = phieunhapDAO.LayDanhSach();
        request.setAttribute("data", phieunhaps);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Admin/PhieuNhap/index.jsp");
        dispatcher.forward( request, response );
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
