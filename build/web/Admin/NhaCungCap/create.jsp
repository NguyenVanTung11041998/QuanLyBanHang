<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Thêm mới nhà cung cấp
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/NhaCungCapServlet">Dashboard</a>
            </li>
            <li>
                <i class=""></i>  <a href="/QuanLyBanHang/NhaCungCapServlet">Nhà cung cấp</a>
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
        <form class="form-horizontal" action="/QuanLyBanHang/NhaCungCap_CreateServlet" method="POST" enctype="multipart/form-data">

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên nhà cung cấp</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Tên nhà cung cấp" name="txtTenNCC" />       
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Địa chỉ</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Địa chỉ" name="txtDiaChi">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Số điện thoại</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Số điện thoại" name="txtSoDT">
                   
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                <div class="col-sm-8">
                    <input type="email" class="form-control" id="" placeholder="Email" name="txtEmail"> 
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
<jsp:include page="../SharedLayout/footer.jsp"/>