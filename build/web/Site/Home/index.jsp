<%@page import="DAO.SanPhamDAO"%>
<%@page import="DTO.SanPham"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  SanPhamDAO sanPhamDAO = new SanPhamDAO();
    String search = request.getParameter("txtSearch");
    SanPham[] sanPhams = search == null ? sanPhamDAO.GetListSanPhamMoiNhat() : sanPhamDAO.TimKiem(search); %>
<jsp:include page="../SharedLayout/header.jsp"/>
<jsp:include page="../SharedLayout/banner.jsp"/>
<!--content-->
<div class="content">
    <div class="container">
        <div class="content-top">
            <h1>NEW RELEASED</h1>
            <div class="grid-in">
                <%
                    for (SanPham item : sanPhams) {%> 
                <div class="col-md-4 grid-top">
                    <a href="/QuanLyBanHang/chi-tiet-san-pham?id=<%= item.maSP%>" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" style="height: 355px; width: 355px;" src="Contents/Upload/<%= item.hinhAnh%>" alt="">
                        <div class="b-wrapper">
                            <h3 class="b-animate b-from-left b-delay03 ">
                                <span><%= item.tenSP%></span>	
                            </h3>
                        </div>
                    </a>
                    <p><a href="/QuanLyBanHang/chi-tiet-san-pham?id=<%= item.maSP%>"><%= item.tenSP%></a></p>
                </div>
                <%}%>
                <div class="clearfix"> </div>
            </div>

        </div>
        <!----->

        <div class="content-top-bottom">
            <h2>Featured Collections</h2>
            <div class="col-md-6 men">
                <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t1.jpg" alt="">
                    <div class="b-wrapper">
                        <h3 class="b-animate b-from-top top-in   b-delay03 ">
                            <span>Lorem</span>	
                        </h3>
                    </div>
                </a>


            </div>
            <div class="col-md-6">
                <div class="col-md1 ">
                    <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t2.jpg" alt="">
                        <div class="b-wrapper">
                            <h3 class="b-animate b-from-top top-in1   b-delay03 ">
                                <span>Lorem</span>	
                            </h3>
                        </div>
                    </a>

                </div>
                <div class="col-md2">
                    <div class="col-md-6 men1">
                        <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t3.jpg" alt="">
                            <div class="b-wrapper">
                                <h3 class="b-animate b-from-top top-in2   b-delay03 ">
                                    <span>Lorem</span>	
                                </h3>
                            </div>
                        </a>

                    </div>
                    <div class="col-md-6 men2">
                        <a href="single.html" class="b-link-stripe b-animate-go  thickbox"><img class="img-responsive" src="images/t4.jpg" alt="">
                            <div class="b-wrapper">
                                <h3 class="b-animate b-from-top top-in2   b-delay03 ">
                                    <span>Lorem</span>	
                                </h3>
                            </div>
                        </a>

                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <!---->
    <div class="content-bottom">
        <ul>
            <li><a href="#"><img class="img-responsive" src="images/lo.png" alt=""></a></li>
            <li><a href="#"><img class="img-responsive" src="images/lo1.png" alt=""></a></li>
            <li><a href="#"><img class="img-responsive" src="images/lo2.png" alt=""></a></li>
            <li><a href="#"><img class="img-responsive" src="images/lo3.png" alt=""></a></li>
            <li><a href="#"><img class="img-responsive" src="images/lo4.png" alt=""></a></li>
            <li><a href="#"><img class="img-responsive" src="images/lo5.png" alt=""></a></li>
            <div class="clearfix"> </div>
        </ul>
    </div>
</div>
<jsp:include page="../SharedLayout/footer.jsp"/>

