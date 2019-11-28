<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.KhachHang"%>
<% KhachHang x = (KhachHang) request.getAttribute("data");%>
<jsp:include page="../SharedLayout/header.jsp"/>

<!--content-->
<div class=" container">
    <div class=" register">
        <h1>Update</h1>
        <form method="Post" action="/QuanLyBanHang/sua-tai-khoan?id=<%= x.id%>"> 
            <div class="col-md-6 register-top-grid">
                <h3>Thông tin khách hàng</h3>
                <div>
                    <span>Họ và tên</span>
                    <input type="text" name="txtName" value="<%= x.hoTen%>"> 
                </div>
                <div>
                    <span>Số điện thoại</span>
                    <input type="text" name="txtPhone" value="<%= x.soDT%>"> 
                </div>
                <div>
                    <span>Địa chỉ</span>
                    <input type="text" name="txtAddress" value="<%= x.diaChi%>"> 
                </div>
            </div>
            <div class="col-md-6 register-bottom-grid">
                <h3>Thông tin tài khoản</h3>
                <div>
                    <span>Email</span>
                    <input type="email" name="txtEmail" value="<%= x.email%>" readonly="readonly"> 
                </div>
                <div>
                    <span>Mật khẩu cũ</span>
                    <input type="password" name="txtPass">
                </div>
                <div>
                    <span>Mật khẩu mới</span>
                    <input type="password" name="txtNewPass">
                </div>
                <div>
                    <span>Nhập lại mât khẩu</span>
                    <input type="password" name="txtCfPass">
                </div>
                <input type="submit" value="Sửa tài khoản">
            </div>
            <div class="clearfix"> </div>
        </form>
    </div>
</div>
<!--//content-->
<jsp:include page="../SharedLayout/footer.jsp"/>