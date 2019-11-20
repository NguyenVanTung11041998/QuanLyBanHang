<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="check">
        <div class="col-md-9 cart-items">
            <h3 class="title-main col-md-12" style="padding:0; margin:0 0 20px 0">
                <a href="javascript:void(0)">Giỏ hàng của tôi</a>
            </h3>
            <table class="table table-hover" id="cart_info">
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Hình ảnh</th>
                        <th>Số lượng</th>
                        <th>Giá</th>
                        <th>Tổng tiền</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <?php $stt=1; $sum = 0; foreach($_SESSION['cart'] as $key => $value):?>
                    <tr>
                        <td><?php echo $stt?></td>
                        <td><?php echo $value['name']?></td>
                        <td><img src="Upload/product/<?php echo $value['thumbar']?>" style="height:100px;" alt=""></td>
                        <td><input type="number" name="qty" id="qty" class="form-control qty" value="<?php echo $value['qty'] ?>" style="width:70px" min=0></td>
                        <td><?php echo FormatPrice($value['price'])?></td>
                        <td><?php echo FormatPrice($value['qty']*$value['price'])?></td>
                        <td>
                            <a class="btn btn-danger" href="?controller=cart&action=remore&id=<?php echo $key?>">Xóa</a>
                            <a class="btn btn-success updatecart" href="" data-key=<?php echo $key; ?>>Sửa</a>
                        </td>
                    </tr>
                    <?php $sum += $value['price'] * $value['qty']; $_SESSION['sotien'] = $sum; ?>
                    <?php $stt++; endforeach?>
                </tbody>
            </table>
        </div>  
        <div class="col-md-3 cart-total">
            <h3 class="continue" href="#">Thông tin giỏ hàng</h3>
            <div class="price-details"> 
                <h3>Chi tiết giá</h3>
                <span>Số tiền</span>
                <span class="total1"><?php echo FormatPrice($_SESSION['sotien'])?></span>
                <span>Thuế VAT</span>
                <span class="total1">10%</span>
                <div class="clearfix"></div>
            </div>
            <ul class="total_price">
                <li class="last_price">
                    <h4>Tổng tiền</h4>
                </li>
                <li class="last_price"><span><?php $_SESSION['tong'] = $_SESSION['sotien'] * 110/100; echo FormatPrice($_SESSION['tong'])?></span></li>

                <div class="clearfix"> </div>
            </ul>
            <ul class="">
                <li class="list-group-item clearfix">
                    <a href="?controller=category&action=cate_pro&id=1" class="btn btn-success">Mua hàng tiếp</a>
                    <a href="?controller=cart&action=pay" class="btn btn-success pay">Đặt hàng</a>
                </li>
            </ul>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
