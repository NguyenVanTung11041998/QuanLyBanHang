<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.PhieuNhap"%> 
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách phiếu nhập
            <!-- <small>Subheading</small> -->
            <a href="/QuanLyBanHang/PhieuNhap_CreateServlet" class="btn btn-success">Thêm phiếu nhập</a>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/PhieuNhapServlet">Phiếu Nhập</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Phiếu nhập<!--  -->
            </li>
        </ol>
        <div class="form-group row">
            <form action="" method="GET">
                <div class="col-sm-4">
                    <input id="datePicker" type="date" value="" style="height: 2.5em; width:100%" /> 
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
                        <th>Tổng tiền nhập</th>
                        <th>Chi tiết phiếu nhập</th>
                    </tr>
                </thead>
                <tbody>
                    <% PhieuNhap[] phieunhaps = (PhieuNhap[]) request.getAttribute("data");
                int i = 0;
                for (PhieuNhap item : phieunhaps) {%> 
                    <tr id="row_<%= item.maPN %>">
                        <td><%= ++i %></td>
                        <td><%= item.ngayNhap %></td>
                        <td><%= item.tongTienNhap %> VND</td>
                        <td>
                            <a href="/QuanLyBanHang/phieu-nhap-chi-tiet?id=<%= item.maPN %>" class="btn btn-success"><i class="fa fa-edit"></i>Xem chi tiết phiếu nhập</a>
                        </td>
                    </tr>

                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/PhieuNhapServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/PhieuNhapServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/PhieuNhapServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/PhieuNhapServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/PhieuNhapServlet?page=1" aria-label="Next">
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
            url: "Admin/Controller/ImportCoupon/fetch.php",
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
</script>

<jsp:include page="../SharedLayout/footer.jsp"/>