<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<!--content-->
<div class="container">
    <div class="account">
        <h1>Account</h1>
        <div class="account-pass">
            <div class="col-md-8 account-top">
                <form method="POST" action="/QuanLyBanHang/khach-hang-dang-nhap">

                    <div> 	
                        <span>Email</span>
                        <input type="text" name="txtEmail"> 
                    </div>
                    <div> 
                        <span >Password</span>
                        <input type="password" name="txtMatKhau">
                    </div>				
                    <input type="submit" value="Đăng nhập"> 
                </form>
            </div>
            <div class="col-md-4 left-account ">
                <a href="single.html"><img class="img-responsive " src="Contents/Site/images/s1.jpg" alt=""></a>
                <div class="five">
                    <h2>25% </h2><span>discount</span>
                </div>
                <a href="/QuanLyBanHang/dang-ky-tai-khoan" class="create">Create an account</a>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

</div>
<jsp:include page="../SharedLayout/footer.jsp"/>