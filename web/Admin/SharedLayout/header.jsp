<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Trang Admin</title>
        <!-- Bootstrap Core CSS -->
        <link href="Contents/Admin/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <!-- Custom CSS -->
        <link href="Contents/Admin/css/sb-admin.css" rel="stylesheet">

        <!-- Custom Fonts -->
        <link href="Contents/Admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="Public/css/style.css">
        <!-- /#wrapper -->
        <!-- jQuery -->
        <script src="Contents/Admin/js/jquery.js"></script>
        <!-- <script type="text/javascript" src="Public/js/jquery.min.js"></script> -->
        <script type="text/javascript" src="Contents/Admin/js/jquery-3.2.1.min.js"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="Contents/Admin/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="Contents/Admin/Vendor/chart.js"></script>
        <script type="text/javascript">
            function confirmAction() {
                return confirm("Bạn có muốn xóa bản ghi này?");
            }
        </script>

        <script type="text/javascript">
            function confirmActionLogout() {
                return confirm("Bạn có muốn đăng xuất không?");
            }
        </script>

    </head>
    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Xin chào Admin</a>
                </div>
                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu message-dropdown">
                            <li class="message-preview">
                                <a href="#">
                                    <div class="media">
                                        <span class="pull-left">
                                            <img class="media-object" src="http://placehold.it/50x50" alt="">
                                        </span>
                                        <div class="media-body">
                                            <h5 class="media-heading">
                                                <strong>Admin</strong>
                                            </h5>
                                            <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                            <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                        </div>
                                    </div>
                                </a>
                            </li>
                            <li class="message-footer">
                                <a href="#">Read All New Messages</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                        <ul class="dropdown-menu alert-dropdown">
                            <li>
                                <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                            <li>
                                <a href="#">View All</a>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> 
                            Admin
                            <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                            </li>
                            <li>
                                <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="LoginServlet" onclick="return confirmActionLogout()"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="trang-chu-quan-ly"><i class="fa fa-fw fa-dashboard"></i> Trang chủ</a>
                        </li>
                        <li>
                            <a href="nha-cung-cap"><i class="fa fa-fw fa-dashboard"></i> Nhà cung cấp</a>
                        </li>
                        <li>
                            <a href="loai-san-pham"><i class="fa fa-list"></i> Loại sản phẩm</a>
                        </li>
                        <li>
                            <a href="san-pham"><i class="fa fa-database"></i> Sản phẩm</a> 
                        </li>
                        <li>
                            <a href="khach-hang"><i class="fa fa-database"></i> Khách hàng</a>
                        </li>
                        <li>
                            <a href="hoa-don"><i class="fa fa-database"></i> Quản lý đơn hàng</a>
                        </li>
                        <li>
                            <a href="nha-san-xuat"><i class="fa fa-fw fa-edit"></i> Nhà sản xuất</a>
                        </li>
                        <li>
                            <a href="phieu-nhap"><i class="fa fa-fw fa-desktop"></i> Quản lý nhập xuất</a>
                        </li>
                        <li>
                            <a href="danh-muc"><i class="fa fa-fw fa-wrench"></i> Quản lý danh mục</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
