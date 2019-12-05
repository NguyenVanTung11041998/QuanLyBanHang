<%@page import="DAO.GioHangDAO"%>
<%@page import="DTO.LoaiSanPham"%>
<%@page import="DTO.DanhMuc"%>
<%@page import="DAO.LoaiSanPhamDAO"%>
<%@page import="DAO.DanhMucDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DTO.KhachHang"%>
<% KhachHang khachHang = (KhachHang) request.getAttribute("KhachHang"); %>
<%
    DanhMucDAO danhMucDAO = new DanhMucDAO();
    GioHangDAO gioHangDAO = new GioHangDAO();
    LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
    DanhMuc[] danhMucs = danhMucDAO.LayDanhSach();
%>
<!DOCTYPE html>
<html>
    <head>
        <title>New Store A Ecommerce Category Flat Bootstarp Resposive Website Template | Home :: w3layouts</title>

        <link href="Contents/Site/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="Contents/Site/js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="Contents/Site/css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="New Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
        <!-- start menu -->
        <link href="Contents/Site/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="Contents/Site/js/memenu.js"></script>
        <script>$(document).ready(function () {
                $(".memenu").memenu();
            });</script>
        <script src="Contents/Site/js/simpleCart.min.js"></script>
    </head>
    <body>
        <!--header-->
        <div class="header">
            <div class="header-top">
                <div class="container">
                    <div class="search">
                        <form action="/QuanLyBanHang/tim-kiem-san-pham">
                            <input type="text" value="Search " onfocus="this.value = '';" onblur="if (this.value == '') {
                                        this.value = 'Search';
                                    }">
                            <input type="submit" value="Go">
                        </form>
                    </div>
                    <div class="header-left">		
                        <ul>
                            <li ><a href="/QuanLyBanHang/khach-hang-dang-nhap"  >Đăng nhập</a></li>
                            <li><a  href="/QuanLyBanHang/dang-ky-tai-khoan"  >Đăng ký tài khoản</a></li>
                                <%if (khachHang != null) {%>
                            <li><a  href="/QuanLyBanHang/sua-tai-khoan?id=<%= khachHang.id%>"  >Sửa tài khoản</a></li>
                            <li><span style="color:white; margin-right: 10px; ">Xin chào: <%= khachHang.hoTen %></span></li>
                                <%}%>
                        </ul>
                        <div class="cart box_1">
                            
                            <a href="<% if(khachHang != null) { %>/QuanLyBanHang/gio-hang?id=<%= khachHang.id%> <%} else {%>#<%}%>">
                                <h3> <div class="total">
                                        <span ></span> <%= khachHang != null ? (int)gioHangDAO.GetTongTienSanPhamTrongGioTheoKhachHang(khachHang.id) : 0 %> VND 
                                        (<span id="simpleCart_quantity" class=""><%= khachHang != null ? gioHangDAO.GetSoLuongSanPhamTrongGioTheoKhachHang(khachHang.id) : 0 %></span> items)</div>
                                    <img src="Content/Site/images/cart.png" alt=""/></h3>
                            </a>
                            <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>

                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="clearfix"> </div>
                </div>
            </div>
            <div class="container">
                <div class="head-top">
                    <div class="logo">
                        <a href="/QuanLyBanHang/trang-chu"><img src="Contents/Site/images/logo.png" alt=""></a>	
                    </div>
                    <div class=" h_menu4">
                        <ul class="memenu skyblue">
                            <li class="active grid"><a class="color8" href="/QuanLyBanHang/trang-chu">Home</a></li>	
                                <% for (DanhMuc danhMuc : danhMucs) {
                                        LoaiSanPham[] loaiSanPhams = loaiSanPhamDAO.LayDanhSachTheoDanhMuc(danhMuc.maDanhMuc);
                                %>
                            <li><a class="color1" href="#"><%=danhMuc.tenDanhMuc%></a>
                                <div class="mepanel">
                                    <div class="row">
                                        <div class="col1">
                                            <div class="h_nav">
                                                <ul>
                                                <% for (LoaiSanPham item : loaiSanPhams) { %>
                                                    <li><a href="/QuanLyBanHang/danh-sach-san-pham?id=<%= item.maLoaiSP %>"><%= item.tenLoai %></a></li>
                                                <%}%>                                    
                                                </ul>	
                                            </div>							
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <%}%>
                            <li><a class="color4" href="#">Blog</a></li>				
                            <li><a class="color6" href="#">Conact</a></li>
                        </ul> 
                    </div>

                    <div class="clearfix"> </div>
                </div>
            </div>

        </div>