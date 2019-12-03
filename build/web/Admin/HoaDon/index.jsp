<%@page import="DTO.HoaDon"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>

<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách hóa đơn
            <!-- <small>Subheading</small> -->
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/HoaDonChiTietServlet">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Hóa đơn<!--  -->
            </li>
        </ol>
        <div class="form-group row">
            <form action="" method="GET">
                <div class="col-sm-4">
                    <input id="datePicker" type="date" value="<?php echo date('Y-m-d'); ?>" style="height: 2.5em; width: 100%" /> 
                </div>
                <button type="button" id="search" class="btn btn-primary">Search</button>
            </form>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12" id="table_data">
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Ngày lập</th>
                        <th>Tên khách hàng</th>
                        <td>Tổng tiền</td>
                        <th>Trạng thái</th>
                        <th>Chi tiết hóa đơn</th>
                    </tr>
                </thead>
                <tbody>
                    <% HoaDon[] hoaDons = (HoaDon[]) request.getAttribute("data");
                        int i = 0;
                        for (HoaDon item : hoaDons) {%>
                    <tr>
                        <td><%= ++i%></td>
                        <td><%= item.ngayDat %></td>
                        <td><%= item.tenKhachHang %></td>
                        <td><%= (int)item.tongTien %> VND</td>
                        <td><a href="#" data-id="<%= item.maHD %>" class="btn btn-primary btnXuLy"><%= item.daThanhToan ? "Đã xử lý" : "Chưa xử lý" %></a></td>
                        <td>
                            <a href="/QuanLyBanHang/hoa-don-chi-tiet?id=<%= item.maHD %>" class="btn btn-success">Xem chi tiết</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/HoaDonServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/HoaDonServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/HoaDonServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/HoaDonServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/HoaDonServlet?page=1" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>	
        </div>
    </div>
</div>

<script type="text/javascript">
    function LoadData(query) {
        $.ajax({
            url: "Admin/Controller/Bill/fetch.php",
            method: "POST",
            data: {query: query},
            success: function (data) {
                $('#table_data').html(data);
            }
        });
    }

    $('#search').click(function () {
        var search = $('#datePicker').val();
        if (search != '')
            LoadData(search);
        else
            LoadData();
    });
    
    $("body").delegate(".btnXuLy", "click", function(e) {
        e.preventDefault();
        var btn = $(this);
        var id = btn.data("id");
        $.ajax({
            url: "/QuanLyBanHang/xu-ly-hoa-don",
            method: "Post",
            data: {id: id},
            success: function (result) {
                if (result === "true")
                {
                    alert("Thay đổi thành công!");
                    btn.text("Đã xử lý")
                }
                else
                {
                    btn.text("Chưa xử lý")
                }
            }
        });
    });
</script>

<jsp:include page="../SharedLayout/footer.jsp"/>
