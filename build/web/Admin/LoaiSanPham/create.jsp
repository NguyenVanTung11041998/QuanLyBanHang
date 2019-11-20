<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<!-- Page Heading -->
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Thêm mới loại sản phẩm
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="QuanLyBanHang/LoaiSanPhamServlet">Dashboard</a>
            </li>
            <li>
                <i class=""></i>  <a href="QuanLyBanHang/LoaiSanPhamServlet">Loại sản phẩm</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Thêm mới
            </li>
        </ol>
        <div class="clearfix"></div>

    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <form class="form-horizontal" action="QuanLyBanHang/LoaiSanPham_CreateServlet" method="POST" enctype="multipart/form-data">

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên loại sản phẩm</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Tên loại sản phẩm" name="txtTenLoaiSP">  
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên danh mục</label>
                <div class="col-sm-8">
                    <select class="form-control col-md-8" name="cmbMaDanhMuc">

                        <option value="">------------------</option>

                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success" name="btnThem">Thêm mới</button>
                </div>
            </div>
        </form>
    </div>
</div>
<!-- /.row -->
<jsp:include page="../SharedLayout/footer.jsp"/>
