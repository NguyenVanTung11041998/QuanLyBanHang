<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>

<!--content-->
<div class=" container">
    <div class=" register">
        <h1>Register</h1>
        <form method="Post" action="/QuanLyBanHang/dang-ky-tai-khoan"> 
            <div class="col-md-6 register-top-grid">
                <h3>Thông tin khách hàng</h3>
                <div>
                    <span>Họ và tên</span>
                    <input type="text" name="txtName"> 
                </div>
                <div>
                    <span>Số điện thoại</span>
                    <input type="text" name="txtPhone"> 
                </div>
                <div>
                    <span>Địa chỉ</span>
                    <input type="text" name="txtAddress"> 
                </div>
            </div>
            <div class="col-md-6 register-bottom-grid">
                <h3>Thông tin tài khoản</h3>
                <div>
                    <span>Email</span>
                    <input type="email" name="txtEmail"> 
                </div>
                <div>
                    <span>Mật khẩu</span>
                    <input type="password" name="txtPass">
                </div>
                <div>
                    <span>Nhập lại mât khẩu</span>
                    <input type="password" name="txtCfPass">
                </div>
                <input type="submit" value="Đăng ký tài khoản">
            </div>
            <div class="clearfix"> </div>
        </form>
    </div>
</div>
<!--//content-->
<jsp:include page="../SharedLayout/footer.jsp"/>