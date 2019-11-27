<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>

        <!--content-->
        <div class=" container">
            <div class=" register">
                <h1>Register</h1>
                <form method="Post" action="/QuanLyBanHang/dang-ky-tai-khoan"> 
                    <div class="col-md-6 register-top-grid  register-bottom-grid">
                        <h3>Personal infomation</h3>
                        <div>
                            <span>Name</span>
                            <input type="text" name="txtName"> 
                        </div>
                         <div>
                            <span>Phone</span>
                            <input type="text" name="txtPhone"> 
                        </div>
                        <div>
                            <span>Email Address</span>
                            <input type="text" name="txtEmail"> 
                        </div>
                         <div>
                            <span>Address</span>
                            <input type="text" name="txtAddress"> 
                        </div>
                         <div>
                            <span>Password</span>
                            <input type="password" name="txtPass">
                        </div>
                        <div>
                            <span>Confirm Password</span>
                            <input type="password" name="txtCfPass">
                        </div>
                        <input type="submit" value="submit">
                    </div>
                   
                    <div class="clearfix"> </div>
                </form>
            </div>
        </div>
        <!--//content-->
 <jsp:include page="../SharedLayout/footer.jsp"/>

