<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách loại sản phẩm
            <!-- <small>Subheading</small> -->
            <a href="/QuanLyBanHang/LoaiSanPham_CreateServlet" class="btn btn-success">Thêm mới</a>
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/LoaiSanPhamServlet">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Loại sản phẩm<!--  -->
            </li>
        </ol>
        <div class="form-group row">
            <form action="" method="GET">
                <div class="col-sm-4">
                    <input type="text" id="search_text" class="form-control" placeholder="Search" name="search" /> 
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
                        <th>Tên loại sản phẩm</th>
                        <th>Tên danh mục</th>
                        <th>#</th>
                    </tr>
                </thead>
                <tbody>
   
                    <tr>
                        <td>1</td>
                        <td>Áo</td>
                        <td>Đồ nam</td>
                        <td>
                            <a href="/QuanLyBanHang/LoaiSanPham_EditServlet?id=1" class="btn btn-success"><i class="fa fa-edit"></i>Sửa</a>
                            <a href="#" class="btn btn-danger" onClick="return confirmAction()"><i class="fa fa-times"></i>Xóa</a>
                        </td>
                    </tr>
     
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/LoaiSanPhamServlet?page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/LoaiSanPhamServlet?page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/LoaiSanPhamServlet?page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/LoaiSanPhamServlet?page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/LoaiSanPhamServlet?page=1" aria-label="Next">
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
            url: "Admin/Controller/CategoryProduct/fetch.php",
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