<%@page import="DTO.HoaDonChiTiet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Thông tin hóa đơn chi tiết
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/HoaDonServlet">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Hóa đơn
            </li>
        </ol>
        <div class="clearfix"></div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng mua</th>
                        <th>Đơn giá</th>
                    </tr>
                </thead>
                <tbody>
                    <% HoaDonChiTiet[] hoaDonChiTiets = (HoaDonChiTiet[]) request.getAttribute("data");
                        int i = 0;
                        for (HoaDonChiTiet item : hoaDonChiTiets) {%> 
                    <tr>
                        <td><%=++i%></td>
                        <td><%= item.tenSP%></td>
                        <td><%= item.soLuongMua%></td>
                        <td><%= (int) item.donGia%> VNĐ</td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/HoaDonChiTietServlet?id=1&page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/HoaDonChiTietServlet?id=1&page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/HoaDonChiTietServlet?id=1&page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/HoaDonChiTietServlet?id=1&page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/HoaDonChiTietServlet?id=1&page=1" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>	
        </div>
    </div>
</div>
<jsp:include page="../SharedLayout/footer.jsp"/>