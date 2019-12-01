<%@page import="DTO.KhachHang"%>
<%@page import="DAO.GioHangDAO"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="DTO.SanPham"%>
<%@page import="DTO.GioHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    GioHang[] gioHangs = (GioHang[])request.getAttribute("data");
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    GioHangDAO gioHangDAO = new GioHangDAO();
    KhachHang khachHang = (KhachHang)request.getAttribute("User");
    int tongTien = khachHang != null ? (int)gioHangDAO.GetTongTienSanPhamTrongGioTheoKhachHang(khachHang.id) : 0;
    int id = Integer.parseInt(request.getParameter("id"));
%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="container">
    <div class="check">
        <div class="col-md-9 cart-items">
            <h3 class="title-main col-md-12" style="padding:0; margin:0 0 20px 0">
                <a href="javascript:void(0)">Giỏ hàng của tôi</a>
            </h3>
            <table class="table table-hover" id="cart_info">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Hình ảnh</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Tổng tiền</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        int i = 0;
                        for(GioHang item : gioHangs) { 
                        SanPham sanPham = sanPhamDAO.GetById(item.maSP);
                    %>
                    <tr>
                        <td><%=++i%></td>
                        <td><%= sanPham.tenSP %></td>
                        <td><img src="Contents/Upload/<%= sanPham.hinhAnh %>" style="height:100px;" alt=""></td>
                        <td><input type="number" name="qty" id="qty" class="form-control qty" value="<%= item.soLuongDat %>" style="width:70px" min=0></td>
                        <td><%= (int)sanPham.donGia %></td>
                        <td><%= item.soLuongDat * (int)sanPham.donGia %></td>
                        <td>
                            <a class="btn btn-danger" href="#">Xóa</a>
                            <a class="btn btn-success updatecart" href="#" data-id=<%= item.id %>>Sửa</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>  
        <div class="col-md-3 cart-total">
            <h3 class="continue" href="#">Thông tin giỏ hàng</h3>
            <div class="price-details"> 
                <h3>Chi tiết giá</h3>
                <span>Số tiền</span>
                <span class="total1"><%= tongTien %> VND</span>
                <span>Thuế VAT</span>
                <span class="total1">10%</span>
                <div class="clearfix"></div>
            </div>
            <ul class="total_price">
                <li class="last_price">
                    <h4>Tổng tiền</h4>
                </li>
                <li class="last_price"><span><%= (int)(tongTien * 1.1) %> VND</span></li>

                <div class="clearfix"> </div>
            </ul>
            <ul class="">
                <li class="list-group-item clearfix">
                    <a href="/QuanLyBanHang/trang-chu" class="btn btn-success">Mua hàng tiếp</a>
                    <a href="/QuanLyBanHang/dat-hang?id=<%=id%>" class="btn btn-success pay">Đặt hàng</a>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<jsp:include page="../SharedLayout/footer.jsp"/>
