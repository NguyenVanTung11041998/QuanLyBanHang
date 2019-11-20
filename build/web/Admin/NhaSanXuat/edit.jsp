<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Sửa nhà sản xuất
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/NhaSanXuatServlet">Dashboard</a>
            </li>
            <li>
                <i class=""></i>  <a href="/QuanLyBanHang/NhaSanXuatServlet">Nhà sản xuất</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Sửa thông tin
            </li>
        </ol>
        <div class="clearfix"></div>
        
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <form class="form-horizontal" action="/QuanLyBanHang/NhaSanXuat_EditServlet" method="POST" enctype="multipart/form-data">

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên nhà sản xuất</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Tên nhà sản xuất" name="txtTenNSX" required="required"  value="">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Thông tin</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Thông tin" name="txtThongTin" required="required"  value="">
                </div>
            </div>
            
            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Logo</label>
                <div class="col-sm-3">
                    <input type="file" class="form-control" id="logo" name="txtLogo">
                    <div class="show_file"><img src=""></div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success" name="btnSua">Sửa</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            
            reader.onload = function(e) {
                $(".show_file").html('<img src="' + e.target.result + '">');
            }
            
            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#logo").change(function() {
      readURL(this);
    });
</script>
<jsp:include page="../SharedLayout/footer.jsp"/>