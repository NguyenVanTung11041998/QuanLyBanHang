<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="account">
        <h1>Thanh toán đơn hàng</h1>
        <div class="account-pass">
            <div class="col-md-8 account-top">
                <form id="formLogin" method="POST">

                    <div> 	
                        <span>Tên đăng nhập</span>
                        <input type="text" name="username" readonly="" placeholder="" value="<?php echo $user['TenDangNhap']?>"/>
                    </div>
                    <div> 	
                        <span>Email</span>
                        <input type="text" name="email" readonly="" placeholder="" value="<?php echo $user['Email']?>"/>
                    </div>
                    <div> 	
                        <span>Số điện thoại</span>
                        <input type="text" name="phone" readonly="" placeholder="" value="<?php echo $user['SoDT']?>"/>
                    </div>
                    <div> 	
                        <span>Địa chỉ</span>
                        <input type="text" name="address" readonly="" placeholder="" value="<?php echo $user['DiaChi']?>"/>
                    </div>
                    <div> 
                        <span >Tổng tiền</span>
                        <input type="text" name="total" readonly="" placeholder="" value="<?php echo FormatPrice($_SESSION['tong'])?>" />
                    </div>
                    <div> 	
                        <span>Ghi chú</span>
                        <input type="text" name="note"  placeholder="" />
                    </div>
                    <input type="submit" value="Xác nhận"/>  
                </form>
            </div>
            <div class="col-md-4 left-account ">
                <a href="single.html"><img class="img-responsive " src="Upload/s1.jpg" alt=""></a>
                <div class="five">
                    <h2>25% </h2><span>discount</span>
                </div>
                <a href="index.php?controller=register" class="create">Create an account</a>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>

</div>
