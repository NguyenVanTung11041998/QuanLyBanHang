<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.NhaCungCap"%> 

<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <div class="title_header clearfix">
            <h1 class="page-header">
                Danh sách nhà cung cấp
                <!-- <small>Subheading</small> -->
                <a href="/QuanLyBanHang/them-nha-cung-cap" class="btn btn-success">Thêm mới</a>
            </h1>
        </div>
        <div class="form-group row">
            <form action="" method="GET">
                <div class="col-sm-4">
                    <input type="text" id="search_text" class="form-control" placeholder="Search" name="search" /> 
                </div>
                <button type="button" id="search" class="btn btn-primary">Search</button>
            </form>
        </div>
        <div class="clearfix"></div>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/nha-cung-cap">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Nhà cung cấp
            </li>
        </ol>
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
                        <td>Tên nhà cung cấp</td>
                        <td>Địa chỉ</td>
                        <td>Số điện thoại</td>
                        <td>Email</td>
                        <td>#</td>
                    </tr>
                </thead>
                <tbody>
                <% NhaCungCap[] nhaCungCaps = (NhaCungCap[]) request.getAttribute("data");
                int i = 0;
                for (NhaCungCap item : nhaCungCaps) {%> 
                    <tr id="row_<%= item.maNCC %>">
                        <td><%= ++i %></td>
                        <td><%= item.tenNCC%></td> 
                        <td><%= item.diaChi%></td> 
                        <td><%= item.soDT%></td> 
                        <td><%= item.email %></td>
                        <td>
                            <a href="/QuanLyBanHang/sua-nha-cung-cap?id=<%= item.maNCC %>" class="btn btn-success"><i class="fa fa-edit"></i>Sửa</a>
                            <a href="#" class="delete btn btn-danger" data-id="<%= item.maNCC %>"><i class="fa fa-times"></i>Xóa</a>
                        </td>
                    </tr>
                <%}%> 
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/NhaCungCapServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/NhaCungCapServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/NhaCungCapServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/NhaCungCapServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/NhaCungCapServlet?page=1" aria-label="Next">
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
    $('.delete').click(function (e) {
        e.preventDefault();
        if (confirm("Bạn có muốn xóa bản ghi này không?"))
        {
            var x = $(this);
            var id = x.data('id');
            $.ajax({
                url: '/QuanLyBanHang/NhaCungCap_DeleteServlet',
                method: 'Post',
                data: {id: id},
                success: function (result) {
                    if (result)
                    {
                        var rowDelete = x.parent().parent();
                        rowDelete.remove();
                        alert("Xóa bản ghi thành công!");
                    } else
                        alert("Không thể xóa bản ghi! Vì đã tồn tại trong sản phẩm!");
                }
            });
        }
    });

    
    function LoadData(query) {
        $.ajax({
            url: "Admin/Controller/Supplier/fetch.php",
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