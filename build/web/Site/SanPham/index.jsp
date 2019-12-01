<%@page import="DTO.SanPham"%>
<% SanPham[] sanPhams = (SanPham[]) request.getAttribute("data"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../SharedLayout/header.jsp"/>
<div class="product">
    <div class="container">
        <jsp:include page="../SharedLayout/menu_left.jsp"/>

        <div class="col-md-9 product1">
            <div class=" bottom-product">
                <%for (SanPham item : sanPhams) { %>
                <div class="col-md-4 bottom-cd simpleCart_shelfItem">
                    <div class="product-at ">
                        <a href="/QuanLyBanHang/chi-tiet-san-pham?id=<%= item.maSP%>"><img class="img-responsive" src="Contents/Upload/<%= item.hinhAnh%>" style="width: 285px; height: 290px;" alt="">
                            <div class="pro-grid">
                                <span class="buy-in">Buy Now</span>
                            </div>
                        </a>	
                    </div>
                    <p class="tun"><%= item.tenSP%></p>
                    <p class="tun"><%= item.moTa%></p>
                    <a href="#" class="item_add"><p class="number item_price"><i> </i><%= (int)item.donGia %> VND</p></a>						
                </div> 
                <%}%>
                <div class="clearfix"> </div>
            </div>
        </div>

        <div class="clearfix"> </div>


        <nav class="in">
            <ul class="pagination">
                <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
                <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">2 <span class="sr-only"></span></a></li>
                <li><a href="#">3 <span class="sr-only"></span></a></li>
                <li><a href="#">4 <span class="sr-only"></span></a></li>
                <li><a href="#">5 <span class="sr-only"></span></a></li>
                <li> <a href="#" aria-label="Next"><span aria-hidden="true">»</span> </a> </li>
            </ul>
        </nav>
    </div>

</div>

<script>
    $(".hrefTag").click(function (e) {
        e.preventDefault();
    });
</script>

<jsp:include page="../SharedLayout/footer.jsp"/>
