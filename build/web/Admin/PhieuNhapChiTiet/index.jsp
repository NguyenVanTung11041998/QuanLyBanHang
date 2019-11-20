<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Danh sách phiếu nhập chi tiết
        </h1>
        <ol class="breadcrumb">
            <li>
                <i class="fa fa-dashboard"></i>  <a href="/QuanLyBanHang/PhieuNhapServlet">Dashboard</a>
            </li>
            <li class="active">
                <i class="fa fa-file"></i> Phiếu nhập
            </li>
        </ol>
        <div class="clearfix"></div>
    </div>
</div>
<div class="row">
    <div class="col-lg-12">
        <div class="table-responsive">
            <table class="table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Số lượng nhập</th>
                        <th>Đơn giá nhập</th>
                    </tr>
                </thead>
                <tbody>

                    <tr>
                        <td>1</td>
                        <td>Áo dài</td>
                        <td>500</td>
                        <td>30000000 VND</td>
                    </tr>
 
                </tbody>
            </table>

            <div class="pull-right">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="/QuanLyBanHang/PhieuNhapChiTietServlet?id=1&page=1" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="/QuanLyBanHang/PhieuNhapChiTietServlet?id=1&page=1">1</a></li>
                        <li><a href="/QuanLyBanHang/PhieuNhapChiTietServlet?id=1&page=1">2</a></li>
                        <li><a href="/QuanLyBanHang/PhieuNhapChiTietServlet?id=1&page=1">3</a></li>
                        <li>
                            <a href="/QuanLyBanHang/PhieuNhapChiTietServlet?id=1&page=1" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>	
        </div>
    </div>
</div>

<jsp:include page="../SharedLayout/footer.jsp"/>