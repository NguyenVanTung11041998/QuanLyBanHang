<%@page import="DTO.KhachHang"%>
<%@page import="DAO.GioHangDAO"%>
<%@page import="DAO.SanPhamDAO"%>
<%@page import="DTO.SanPham"%>
<%@page import="DTO.GioHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    GioHang[] gioHangs = (GioHang[]) request.getAttribute("data");
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    GioHangDAO gioHangDAO = new GioHangDAO();
    KhachHang khachHang = (KhachHang) request.getAttribute("KhachHang");
    int tongTien = khachHang != null ? (int) gioHangDAO.GetTongTienSanPhamTrongGioTheoKhachHang(khachHang.id) : 0;
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
                        for (GioHang item : gioHangs) {
                            SanPham sanPham = sanPhamDAO.GetById(item.maSP);
                    %>
                    <tr class="row_<%=item.id %>">
                        <td><%=++i%></td>
                        <td><%= sanPham.tenSP%></td>
                        <td><img src="Contents/Upload/<%= sanPham.hinhAnh%>" style="height:100px;" alt=""></td>
                        <td><input type="number" name="qty" id="qty" class="form-control qty" value="<%= item.soLuongDat%>" style="width:70px" min=0></td>
                        <td><%= (int) sanPham.donGia%> VND</td>
                        <td><%= item.soLuongDat * (int) sanPham.donGia%> VND</td>
                        <td>
                            <a class="btn btn-danger btnDelete" data-id="<%= item.id %>" href="#">Xóa</a>
                            <a class="btn btn-success updatecart btnUpdate" href="#" data-id=<%= item.id%>>Sửa</a>
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
                <span class="total1"><%= tongTien%> VND</span>
                <span>Thuế VAT</span>
                <span class="total1">0%</span>
                <div class="clearfix"></div>
            </div>
            <ul class="total_price">
                <li class="last_price">
                    <h4>Tổng tiền</h4>
                </li>
                <li class="last_price"><span><%= (int) tongTien%> VND</span></li>

                <div class="clearfix"> </div>
            </ul>
            <ul class="">
                <li class="list-group-item clearfix">
                    <a href="/QuanLyBanHang/trang-chu" class="btn btn-success">Mua hàng tiếp</a>
                    <a href="#" class="btn btn-success pay btnDatHang">Đặt hàng</a>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<script>
    $("body").delegate(".btnDelete", "click", function(e) {
        e.preventDefault();
        var btn = $(this);
        var id = btn.data("id");
        $.ajax({
            url: "/QuanLyBanHang/xoa-gio-hang",
            method: "Post",
            data: {id: id},
            success: function (result) {
                if (result === "true")
                {
                    alert("Xóa thành công!");
                    location.href = "/QuanLyBanHang/gio-hang?id=" + <%= khachHang != null ? khachHang.id : 0%>;
                }
                else
                {
                    alert("Đặt hàng thất bại. Bạn phải đăng nhập trước khi đặt hàng!");
                }
            }
        });
    });
    
    $("body").delegate(".btnUpdate", "click", function(e) {
        e.preventDefault();
        var btn = $(this);
        var id = btn.data("id");
        var soLuong = $("#qty").val();
        $.ajax({
            url: "/QuanLyBanHang/sua-gio-hang",
            method: "Post",
            data: {id: id, soLuong: soLuong},
            success: function (result) {
                if (result === "true")
                {
                    alert("Sửa thành công!");
                    location.href = "/QuanLyBanHang/gio-hang?id=" + <%= khachHang != null ? khachHang.id : 0%>;
                }
                else
                {
                    alert("Đặt hàng thất bại. Bạn phải đăng nhập trước khi đặt hàng!");
                }
            }
        });
    });
    
    $("body").delegate(".btnDatHang", "click", function(e) {
        e.preventDefault();
        var btn = $(this);
        $.ajax({
            url: "/QuanLyBanHang/dat-hang",
            method: "Post",
            success: function (result) {
                if (result === "true")
                {
                    alert("Sửa thành công!");
                    location.href = "/QuanLyBanHang/gio-hang?id=" + <%= khachHang != null ? khachHang.id : 0%>;
                }
                else
                {
                    alert("Đặt hàng thất bại. Bạn phải đăng nhập trước khi đặt hàng!");
                }
            }
        });
    });
</script>
<jsp:include page="../SharedLayout/footer.jsp"/>
