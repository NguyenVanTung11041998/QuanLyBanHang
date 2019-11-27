<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.KhachHang"%>
<% KhachHang x = (KhachHang)request.getAttribute("data"); %>
<jsp:include page="../SharedLayout/header.jsp"/>

        <!--content-->
        <div class=" container">
            <div class=" register">
                <h1>Update</h1>
                <form method="Post" action="/QuanLyBanHang/sua-tai-khoan?id=<%= x.id %>"> 
                    <div class="col-md-6 register-top-grid  register-bottom-grid">
                        <h3>Personal infomation</h3>
                        <div>
                            <span>Name</span>
                            <input type="text" name="txtName" value="<%= x.hoTen %>"> 
                        </div>
                         <div>
                            <span>Phone</span>
                            <input type="text" name="txtPhone" value="<%= x.soDT %>"> 
                        </div>
                        <div>
                            <span>Email Address</span>
                            <input type="text" name="txtEmail" value="<%= x.email %>"> 
                        </div>
                         <div>
                            <span>Address</span>
                            <input type="text" name="txtAddress" value="<%= x.diaChi %>"> 
                        </div>
                         <div>
                            <span>Password</span>
                            <input type="password" name="txtPass" value="<%= x.matKhau %>">
                        </div>
                        <div>
                            <span>Confirm Password</span>
                            <input type="password" name="txtCfPass" value="<%= x.matKhau %>">
                        </div>
                        <input type="submit" value="submit">
                    </div>
                   
                    <div class="clearfix"> </div>
                </form>
            </div>
        </div>
        <!--//content-->
 <jsp:include page="../SharedLayout/footer.jsp"/>

