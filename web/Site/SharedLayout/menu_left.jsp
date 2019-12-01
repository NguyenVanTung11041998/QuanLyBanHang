<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% DTO.DanhMuc[] danhMucs = (DTO.DanhMuc[]) request.getAttribute("dataDanhMuc"); %>
<div class="col-md-3 product-price">

    <div class=" rsidebar span_1_of_left">
        <div class="of-left">
            <h3 class="cate">Danh mục</h3>
        </div>
        <ul class="menu">
            <%  int i = 0;
                for (DTO.DanhMuc danhMuc : danhMucs) {
                    DTO.LoaiSanPham[] loaiSanPhams = (DTO.LoaiSanPham[]) request.getAttribute("dataLoaiSP" + i);
                    i++;
            %>  
            <li class="item1"><a href="#"><%= danhMuc.tenDanhMuc%> </a>
                <ul class="cute">
                    <% for (DTO.LoaiSanPham item : loaiSanPhams) {%>
                    <li class="subitem1"><a href="/QuanLyBanHang//danh-sach-san-pham?id=<%= item.maLoaiSP%>"><%= item.tenLoai%></a></li>
                        <%}%>
                </ul>
            </li>
            <%}%>
        </ul>
    </div>
    <!--initiate accordion-->
    <script type="text/javascript">
        $(function () {
            var menu_ul = $('.menu > li > ul'),
                    menu_a = $('.menu > li > a');
            menu_ul.hide();
            menu_a.click(function (e) {
                e.preventDefault();
                if (!$(this).hasClass('active')) {
                    menu_a.removeClass('active');
                    menu_ul.filter(':visible').slideUp('normal');
                    $(this).addClass('active').next().stop(true, true).slideDown('normal');
                } else {
                    $(this).removeClass('active');
                    $(this).next().stop(true, true).slideUp('normal');
                }
            });

        });
    </script>

    <div class="sellers">
        <div class="of-left-in">
            <h3 class="tag">Tags</h3>
        </div>
        <div class="tags">
            <ul>
                <li><a class="hrefTag" href="#">design</a></li>
                <li><a class="hrefTag" href="#">fashion</a></li>
                <li><a class="hrefTag" href="#">lorem</a></li>
                <li><a class="hrefTag" href="#">dress</a></li>
                <li><a class="hrefTag" href="#">fashion</a></li>
                <li><a class="hrefTag" href="#">dress</a></li>
                <li><a class="hrefTag" href="#">design</a></li>
                <li><a class="hrefTag" href="#">dress</a></li>
                <li><a class="hrefTag" href="#">design</a></li>
                <li><a class="hrefTag" href="#">fashion</a></li>
                <li><a class="hrefTag" href="#">lorem</a></li>
                <li><a class="hrefTag" href="#">dress</a></li>

                <div class="clearfix"> </div>
            </ul>

        </div>

    </div>
    <!---->
    <div class="product-bottom">
        <div class="of-left-in">
            <h3 class="best">Best Sellers</h3>
        </div>
        <div class="product-go">
            <div class=" fashion-grid">
                <a href="single.html"><img class="img-responsive " src="Contents/Site/images/p1.jpg" alt=""></a>

            </div>
            <div class=" fashion-grid1">
                <h6 class="best2"><a href="single.html" >Lorem ipsum dolor sit
                        amet consectetuer  </a></h6>

                <span class=" price-in1"> $40.00</span>
            </div>

            <div class="clearfix"> </div>
        </div>
        <div class="product-go">
            <div class=" fashion-grid">
                <a href="single.html"><img class="img-responsive " src="Contents/Site/images/p2.jpg" alt=""></a>

            </div>
            <div class="fashion-grid1">
                <h6 class="best2"><a href="single.html" >Lorem ipsum dolor sit
                        amet consectetuer </a></h6>

                <span class=" price-in1"> $40.00</span>
            </div>

            <div class="clearfix"> </div>
        </div>

    </div>
</div> 
