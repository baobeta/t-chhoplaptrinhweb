<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<c:url value="/home" var="home"/>
<c:set var="totalAll" value="0"/>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>Shopping cart</h1>
                <div class="goods-page">
                    <div class="goods-data clearfix">
                        <div class="table-wrapper-responsive">
                            <table summary="Shopping cart">
                                <tr>
                                    <th class="goods-page-image">Image</th>
                                    <th class="goods-page-description">Description</th>
                                    <th class="goods-page-ref-no">Ref No</th>
                                    <th class="goods-page-quantity">Quantity</th>
                                    <th class="goods-page-price">Unit price</th>
                                    <th class="goods-page-total" colspan="2">Total</th>
                                </tr>
                                <c:forEach var="item" items="${cartItems}">
                                    <c:set var="total" value="${item.productDTO.price*item.quantity}"/>
                                    ${totalAll=totalAll+total}
                                    <tr>
                                        <td class="goods-page-image">
                                            <a href="#"><img src="<c:url value ='/static/assets/frontend/pages/img/products/model3.jpg'/>" alt="Berry Lace Dress'/>"></a>
                                        </td>
                                        <td class="goods-page-description">
                                            <h3><a href="#">${item.productDTO.name}</a></h3>
                                            <p><strong>Item 1</strong> - Color: Green; Size: S</p>
                                            <em>More info is here</em>
                                        </td>
                                        <td class="goods-page-ref-no">
                                            javc2133
                                        </td>
                                        <td class="goods-page-quantity">
                                            <div class="product-quantity">
                                                <input id="product-quantity" type="text" value="${item.quantity}" readonly class="form-control input-sm">
                                            </div>
                                        </td>
                                        <td class="goods-page-price">
                                            <strong><fmt:formatNumber value="${item.productDTO.price}"
                                                                      type="currency"
                                                                      maxFractionDigits="0"
                                                                      currencySymbol="VNĐ "/></strong>
                                        </td>
                                        <td class="goods-page-total">
                                            <strong><fmt:formatNumber value="${total}"
                                                                      type="currency"
                                                                      maxFractionDigits="0"
                                                                      currencySymbol="VNĐ "/></strong>
                                        </td>
                                        <td class="del-goods-col">
                                            <a class="del-goods" href="#">&nbsp;</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </table>
                        </div>

                        <div class="shopping-total">
                            <ul>
                                <li>
                                    <em>Sub total</em>
                                    <strong class="price"><span>$</span>47.00</strong>
                                </li>
                                <li>
                                    <em>Shipping cost</em>
                                    <strong class="price"><span>$</span>3.00</strong>
                                </li>
                                <li class="shopping-total-price">
                                    <em>Total</em>
                                    <strong class="price"><fmt:formatNumber value="${totalAll}"
                                                                            type="currency"
                                                                            maxFractionDigits="0"
                                                                            currencySymbol="VNĐ "/></strong>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <button class="btn btn-default" type="submit">Continue shopping <i class="fa fa-shopping-cart"></i></button>
                    <button class="btn btn-primary" type="submit">Checkout <i class="fa fa-check"></i></button>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->

        <!-- BEGIN SIMILAR PRODUCTS -->
        <div class="row margin-bottom-40">
            <div class="col-md-12 col-sm-12">
                <h2>Most popular products</h2>
                <div class="owl-carousel owl-carousel4">
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k1.jpg'/>" class="img-responsive" alt="Berry Lace Dress'/>">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k1.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                            <div class="sticker sticker-new"></div>
                        </div>
                    </div>
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k2.jpg'/>" class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k2.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress2</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                    </div>
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k3.jpg'/>" class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k3.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress3</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                    </div>
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k4.jpg'/>" class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k4.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress4</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                            <div class="sticker sticker-sale"></div>
                        </div>
                    </div>
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k1.jpg'/>" class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k1.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress5</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                    </div>
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value ='/static/assets/frontend/pages/img/products/k2.jpg'/>" class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value ='/static/assets/frontend/pages/img/products/k2.jpg'/>" class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="#product-pop-up" class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress6</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- END SIMILAR PRODUCTS -->
    </div>
</div>