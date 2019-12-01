<%@page import="DTO.NhaCungCap"%>
<%@page import="DTO.LoaiSanPham"%>
<%@page import="DTO.NhaSanXuat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Thêm mới sản phẩm
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/san-pham">Dashboard</a>
            </li>
            <li>
                <i class=""></i>  <a href="/QuanLyBanHang/san-pham">Sản phẩm</a>
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
        <form class="form-horizontal" action="/QuanLyBanHang/them-san-pham" method="POST" enctype="multipart/form-data">

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên sản phẩm</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Tên sản phẩm" name="txtTenSP" required="required">   
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Đơn giá</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" id="" placeholder="Đơn giá" name="txtDonGia" required="required">
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Mô tả</label>
                <div class="col-sm-8">
                    <textarea class="form-control" name="txtMoTa" required="required"></textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Hình ảnh</label>
                <div class="col-sm-3">
                    <input type="file" class="form-control" id="anh" name="txtHinhAnh">
                    <div class="show_file"></div>
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên nhà cung cấp</label>
                <div class="col-sm-8">
                    <select class="form-control col-md-8" name="cmbMaNCC">
                        <option value="">--------------------------</option>
                        <% NhaCungCap[] nhaCungCaps = (NhaCungCap[]) request.getAttribute("dataNhaCungCap");
                            for (NhaCungCap item : nhaCungCaps) {%>
                        <option value="<%=item.maNCC%>"><%= item.tenNCC%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên nhà sản xuất</label>
                <div class="col-sm-8">
                    <select class="form-control col-md-8" name="cmbMaNSX">                       
                        <option value="">--------------------------</option>
                        <% NhaSanXuat[] nhaSanXuats = (NhaSanXuat[]) request.getAttribute("dataNhaSanXuat");
                            for (NhaSanXuat item : nhaSanXuats) {%>
                        <option value="<%=item.maNSX%>"><%= item.tenNSX%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Tên loại sản phẩm</label>
                <div class="col-sm-8">
                    <select class="form-control col-md-8" name="cmbMaLoaiSP">
                        <option value="">--------------------------</option>
                        <% LoaiSanPham[] loaiSanPhams = (LoaiSanPham[]) request.getAttribute("dataLoaiSanPham");
                            for (LoaiSanPham item : loaiSanPhams) {%>
                        <option value="<%=item.maLoaiSP%>"><%= item.tenLoai%></option>
                        <%}%>
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

<script>
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $(".show_file").html('<img src="' + e.target.result + '">');
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#anh").change(function () {
        readURL(this);
    });
</script>
<jsp:include page="../SharedLayout/footer.jsp"/>
