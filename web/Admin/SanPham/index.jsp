<%@page import="DTO.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách sản phẩm
            <a href="/QuanLyBanHang/them-san-pham" class="btn btn-success">Thêm mới</a>
        </h1>
        <div class="form-group row">
            <form action="" method="GET">
                <div class="col-sm-4">
                    <input type="text" id="search_text" class="form-control" placeholder="Search" name="search" /> 
                </div>
                <button type="button" id="search" class="btn btn-primary">Search</button>
            </form>
        </div>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/san-pham">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Sản phẩm<!--  -->
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
                        <th>Tên sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Ngày cập nhật</th>
                        <th>Hình ảnh</th>
                        <th>Số lượng tồn</th>
                        <th>Tình trạng</th>
                        <th>#</th>
                    </tr>
                </thead>
                <tbody>
                    <% SanPham[] sanPhams = (SanPham[]) request.getAttribute("data");
                        int i = 0;
                        for (SanPham item : sanPhams) {%>
                    <tr id="row_<%= item.maSP%>">
                        <td><%= ++i%></td>
                        <td><%= item.tenSP%></td>
                        <td><%= (int) item.donGia%> VNĐ</td>
                        <td><%= item.ngayCapNhat%></td>
                        <td><img src="Contents/Upload/<%= item.hinhAnh%>" style="width: 80px; height: 80px" alt=""></td>
                        <td><%= item.soLuongTon%></td>
                        <td><a href="#" class="btn btn-warning btnChangeStatus" data-id="<%= item.maSP%>"><i class="fa fa-air-freshener"></i><%= item.trangThai ? "Active" : "Block"%></a></td>
                        <td>
                            <a href="/QuanLyBanHang/sua-san-pham?id=<%= item.maSP%>" class="btn btn-success"><i class="fa fa-edit"></i>Sửa</a>
                            <a href="#" class="btn btn-danger btnDelete" data-id="<%= item.maSP%>"><i class="fa fa-times"></i>Xóa</a>
                        </td>
                    </tr>
                    <%}%> 
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/SanPhamServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/SanPhamServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/SanPhamServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/SanPhamServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/SanPhamServlet?page=1" aria-label="Next">
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
    $('.btnDelete').click(function (e) {
        e.preventDefault();
        if (confirm("Bạn có muốn xóa bản ghi này không?"))
        {
            var x = $(this);
            var id = x.data('id');
            $.ajax({
                url: '/QuanLyBanHang/SanPham_DeleteServlet',
                method: 'Post',
                data: {id: id},
                success: function (result) {
                    if (result === "true")
                    {
                        var rowDelete = x.parent().parent();
                        rowDelete.remove();
                        alert("Xóa bản ghi thành công!");
                    } else
                        alert("Không thể xóa bản ghi!! Bạn có thể block sản phẩm!");
                }
            });
        }
    });
    
    $(".btnChangeStatus").click(function (e) {
        e.preventDefault();
        var x = $(this);
        var id = x.data("id");
        $.ajax({
           url: "/QuanLyBanHang/SanPham_ChangeStatusServlet",
           method: "Post",
           data: { id:id },
           success: function(result) {
               if(result === "true")
                   x.text("Active");
               else
                   x.text("Block");
           }
        });
    });

    function LoadData(query) {
        $.ajax({
            url: "Admin/Controller/Product/fetch.php",
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