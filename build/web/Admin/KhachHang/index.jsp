<%@page import="DTO.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>

<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách khách hàng
            <!-- <small>Subheading</small> -->
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="QuanLyBanHang/KhachHangServlet">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Khách hàng
            </li>
        </ol>
        <div class="form-group row">
            <form action="" method="POST">
                <div class="col-sm-4">
                    <input type="text" id="search_text" class="form-control" placeholder="Search" /> 
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
                        <td>Họ tên</td>
                        <td>Email</td>
                        <td>Địa chỉ</td>
                        <td>Số điện thoại</td>
                    </tr>
                </thead>
                <tbody>
                    <% KhachHang[] khachHangs = (KhachHang[]) request.getAttribute("data");
                        int i = 0;
                        for (KhachHang item : khachHangs) {%> 
                    <tr>
                        <td><%=++i%></td>
                        <td><%= item.hoTen %></td>
                        <td><%= item.email %></td>
                        <td><%= item.diaChi %></td>
                        <td><%= item.soDT %></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/KhachHangServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/KhachHangServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/KhachHangServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/KhachHangServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/KhachHangServlet?page=1" aria-label="Next">
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
            url: "Admin/Controller/Customer/fetch.php",
            method: "POST",
            data: {query: query},
            success: function (data) {
                $('#table_data').html(data);
            }
        });
    }

    $('#search').click(function () {
        var search = $('#search_text').val();
        if (search != '')
            LoadData(search);
        else
            LoadData();
    });
</script>

<jsp:include page="../SharedLayout/footer.jsp"/>
