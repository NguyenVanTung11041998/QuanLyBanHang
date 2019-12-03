<%@page import="DTO.KhachHang"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    DAO.SanPhamDAO sanPhamDAO = new DAO.SanPhamDAO();
    DTO.SanPham sanPham = sanPhamDAO.GetById(id);
    DTO.SanPham[] sanPhams = sanPhamDAO.GetListSanPhamTheoLoaiSanPham(sanPham.maLoaiSP);
    KhachHang khachHang = (KhachHang)request.getAttribute("KhachHang");
%>
<jsp:include page="../SharedLayout/header.jsp"/>
<!--content-->
<!---->
<div class="product">
    <div class="container">
        <jsp:include page="../SharedLayout/menu_left.jsp"/>
        <div class="col-md-9 product-price1">
            <div class="col-md-5 single-top">	
                <div class="flexslider">
                    <ul class="slides">
                        <li data-thumb="Contents/Upload/<%= sanPham.hinhAnh%>" style="width: 304px; height: 356px;">
                            <img src="Contents/Upload/<%= sanPham.hinhAnh%>" style="width: 304px; height: 356px;"/>
                        </li>
                    </ul>
                </div>
                <!-- FlexSlider -->
                <script defer src="Contents/Site/js/jquery.flexslider.js"></script>
                <link rel="stylesheet" href="Contents/Site/css/flexslider.css" type="text/css" media="screen" />

                <script>
                    // Can also be used with $(document).ready()
                    $(window).load(function () {
                        $('.flexslider').flexslider({
                            animation: "slide",
                            controlNav: "thumbnails"
                        });
                    });
                </script>
            </div>	
            <div class="col-md-7 single-top-in simpleCart_shelfItem">
                <div class="single-para ">
                    <h4><%= sanPham.tenSP%></h4>
                    <div class="star-on">
                        <ul class="star-footer">
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                        </ul>
                        <div class="review">
                            <a href="#"> 1 customer review </a>

                        </div>
                        <div class="clearfix"> </div>
                    </div>

                    <h5 class="item_price"><%= (int) sanPham.donGia%> VND</h5>
                    <p><%= sanPham.moTa%></p>
                    <div class="available">
                        <ul>
                            <li>Color
                                <select>
                                    <option>Silver</option>
                                    <option>Black</option>
                                    <option>Dark Black</option>
                                    <option>Red</option>
                                </select></li>
                            <li class="size-in">Size<select>
                                    <option>Large</option>
                                    <option>Medium</option>
                                    <option>small</option>
                                    <option>Large</option>
                                    <option>small</option>
                                </select></li>
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                    <ul class="tag-men">
                        <li><span>TAG</span>
                            <span class="women1">: Women,</span></li>
                        <li><span>SKU</span>
                            <span class="women1">: CK09</span></li>
                    </ul>


                </div>
            </div>
            <div class="clearfix"> </div>
            <!---->
            <div class="cd-tabs">
                <nav>
                    <ul class="cd-tabs-navigation">
                        <li><a data-content="fashion"  href="#0">Mô tả</a></li>
                        <li><a data-content="cinema" href="#0" >Addtional Informatioan</a></li>
                        <li><a data-content="television" href="#0" class="selected ">Reviews (1)</a></li>
                        <li><a href="#" class="add-cart item_add btn btn-warning">Thêm vào giỏ</a></li>
                    </ul> 
                </nav>
                <ul class="cd-tabs-content">
                    <li data-content="fashion" >
                        <div class="facts">
                            <p > There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined </p>
                            <ul>
                                <li>Research</li>
                                <li>Design and Development</li>
                                <li>Porting and Optimization</li>
                                <li>System integration</li>
                                <li>Verification, Validation and Testing</li>
                                <li>Maintenance and Support</li>
                            </ul>         
                        </div>

                    </li>
                    <li data-content="cinema" >
                        <div class="facts1">

                            <div class="color"><p>Color</p>
                                <span >Blue, Black, Red</span>
                                <div class="clearfix"></div>
                            </div>
                            <div class="color">
                                <p>Size</p>
                                <span >S, M, L, XL</span>
                                <div class="clearfix"></div>
                            </div>

                        </div>

                    </li>
                    <li data-content="television" class="selected">
                        <div class="comments-top-top">
                            <div class="top-comment-left">
                                <img class="img-responsive" src="images/co.png" alt="">
                            </div>
                            <div class="top-comment-right">
                                <h6><a href="#">Hendri</a> - September 3, 2014</h6>
                                <ul class="star-footer">
                                    <li><a href="#"><i> </i></a></li>
                                    <li><a href="#"><i> </i></a></li>
                                    <li><a href="#"><i> </i></a></li>
                                    <li><a href="#"><i> </i></a></li>
                                    <li><a href="#"><i> </i></a></li>
                                </ul>
                                <p>Wow nice!</p>
                            </div>
                            <div class="clearfix"> </div>
                            <a class="add-re" href="#">ADD REVIEW</a>
                        </div>

                    </li>
                    <div class="clearfix"></div>
                </ul> 
            </div> 
            <div class=" bottom-product">
                <% for (DTO.SanPham item : sanPhams) {%>
                <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                    <div class="product-at ">
                        <a href="/QuanLyBanHang/chi-tiet-san-pham?id=<%= item.maSP%>"><img class="img-responsive" src="Contents/Upload/<%= item.hinhAnh%>" alt="" style="height: 342px; width: 245px;">
                            <div class="pro-grid">
                                <span class="buy-in">Buy Now</span>
                            </div>
                        </a>	
                    </div>
                    <p class="tun"><%= item.tenSP%></p>
                    <p class="tun"><%= item.moTa%></p>
                    <a href="#" data-id="<%= item.maSP%>" class="item_add btnAddSanPham"><p class="number item_price"><i> </i><%= (int) item.donGia%> VND</p></a>						
                </div>
                <%}%>
                <div class="clearfix"> </div>
            </div>
        </div>

        <div class="clearfix"> </div>
    </div>
</div>

<script>
    $("body").delegate(".btnAddSanPham", "click", function (e) {
        e.preventDefault();
        var btn = $(this);
        var id = btn.data("id");
        $.ajax({
            url: "/QuanLyBanHang/them-gio-hang",
            method: "Post",
            data: {id: id},
            success: function (result) {
                if (result === "true")
                {
                    alert("Đặt hàng thành công!");
                    location.href = "/QuanLyBanHang/gio-hang?id=" + <%= khachHang != null ? khachHang.id : 0%>;
                }
                else
                {
                    alert("Đặt hàng thất bại. Bạn phải đăng nhập trước khi đặt hàng!");
                }
            }
        });
    });
</script>

<jsp:include page="../SharedLayout/footer.jsp"/>