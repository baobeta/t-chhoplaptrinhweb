<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="pDetail" value="/pDetail/"/>
<!-- BEGIN SLIDER -->
<div class="page-slider margin-bottom-35">
    <!-- LayerSlider start -->
    <div id="layerslider" style="width: 100%; height: 494px; margin: 0 auto;">

        <!-- slide one start -->
        <div class="ls-slide ls-slide1"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 24,25,27,28;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide1/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 96px; left: 35%; white-space: nowrap;" data-ls="
            fade: true;
            fadeout: true;
            durationin: 750;
            durationout: 750;
            easingin: easeOutQuint;
            rotatein: 90;
            rotateout: -90;
            scalein: .5;
            scaleout: .5;
            showuntil: 4000;
          "></div>

            <div class="ls-l ls-mini-text" style="top: 338px; left: 35%; white-space: nowrap;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          showuntil: 4000;
          ">
            </div>
        </div>
        <!-- slide one end -->

        <!-- slide two start -->
        <div class="ls-slide ls-slide2"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide2/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 40%; left: 21%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750; durationout: 109750;
          easingin: easeOutQuint;
          easingout: easeInOutQuint;
          delayin: 0;
          delayout: 0;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;
          ">
            </div>

            <div class="ls-l ls-price" style="top: 50%; left: 45%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationout: 109750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;">
            </div>

            <a href="#" class="ls-l ls-more"
               style="top: 72%; left: 21%; display: inline-block; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          easingout: easeInOutQuint;
          delayin: 0;
          delayout: 0;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;">
            </a>
        </div>
        <!-- slide two end -->

        <!-- slide three start -->
        <div class="ls-slide ls-slide3"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 92,93,105;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide3/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 83px; left: 33%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;
          ">
            </div>
            <div class="ls-l"
                 style="top: 333px; left: 33%; white-space: nowrap; font-size: 20px; font: 20px 'Open Sans Light', sans-serif;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;
          ">
            </div>
        </div>
        <!-- slide three end -->

        <!-- slide four start -->
        <div class="ls-slide ls-slide4"
             data-ls="offsetxin: right; slidedelay: 7000; transition2d: 110,111,112,113;">

            <img src="<c:url value='/static/assets/frontend/pages/img/layerslider/slide1/bg.jpg'/>"
                 class="ls-bg" alt="Slide background">

            <div class="ls-l ls-title" style="top: 35%; left: 60%; white-space: nowrap;" data-ls="
          fade: true;
          fadeout: true;
          durationin: 750;
          durationout: 750;
          easingin: easeOutQuint;
          rotatein: 90;
          rotateout: -90;
          scalein: .5;
          scaleout: .5;
          showuntil: 4000;">

            </div>

            <div class="ls-l ls-mini-text" style="top: 70%; left: 60%; white-space: nowrap;"
                 data-ls="
          fade: true;
          fadeout: true;
          durationout: 750;
          easingin: easeOutQuint;
          delayin: 300;
          scalein: .8;
          scaleout: .8;
          showuntil: 4000;">
            </div>

        </div>
        <!-- slide four end -->
    </div>
    <!-- LayerSlider end -->
</div>
<!-- END SLIDER -->

<div class="main">
    <div class="container">
        <!-- BEGIN SALE PRODUCT & NEW ARRIVALS -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SALE PRODUCT -->
            <div class="col-md-12 sale-product">
                <h2>New Arrivals</h2>
                <div class="owl-carousel owl-carousel5">
                    <!-----------------------------------------Code foreach---------------------------------------------------------------------->
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value='/static/assets/frontend/pages/img/products/model1.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value='/static/assets/frontend/pages/img/products/model1.jpg'/>"
                                       class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="${pDetail}"
                                       class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Acer Nitro 5</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                            <div class="sticker sticker-sale"></div>
                        </div>
                    </div>
                    <!--------------------------------------------Code foreach------------------------------------------------------------------->
                </div>
            </div>
            <!-- END SALE PRODUCT -->
        </div>
        <!-- END SALE PRODUCT & NEW ARRIVALS -->

        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40 ">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-4">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a> DANH MỤC</a></li>

                    <ul class="list-group margin-bottom-25 sidebar-menu">
                        <c:forEach items="${brandItems.listResult}" var="brandItem">
                        <li class="list-group-item clearfix"><a href="shop-product-list.html"><i
                                class="fa fa-angle-right"></i> ${brandItem.name}</a></li>
                        </c:forEach>
                    </ul>
                </ul>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-8">
                <h2>Three items</h2>
                <div class="owl-carousel owl-carousel3">

                  <c:forEach items="${productItems.listResult}" var="productItem">
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value='/static/assets/frontend/pages/img/products/k1.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value='/static/assets/frontend/pages/img/products/k1.jpg'/>"
                                       class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="${pDetail}"
                                       class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">${productItem.name}</a></h3>
                            <div class="pi-price">${productItem.price} VNĐ</div>
                            <a href="#" class="btn btn-default add2cart"> Add to cart</a>
                            <div class="sticker sticker-new"></div>
                        </div>
                    </div>
                  </c:forEach>
                    <!-----------------------------Code foreach-------------------------------------------------->
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->

        <!-- BEGIN TWO PRODUCTS & PROMO -->
        <div class="row margin-bottom-35 ">
            <!-- BEGIN TWO PRODUCTS -->
            <div class="col-md-6 two-items-bottom-items">
                <h2>Two items</h2>
                <div class="owl-carousel owl-carousel2">
                    <div>
                        <div class="product-item">
                            <div class="pi-img-wrapper">
                                <img src="<c:url value='/static/assets/frontend/pages/img/products/k4.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                                <div>
                                    <a href="<c:url value='/static/assets/frontend/pages/img/products/k4.jpg'/>"
                                       class="btn btn-default fancybox-button">Zoom</a>
                                    <a href="${pDetail}"
                                       class="btn btn-default fancybox-fast-view">View</a>
                                </div>
                            </div>
                            <h3><a href="shop-item.html">Berry Lace Dress</a></h3>
                            <div class="pi-price">$29.00</div>
                            <a href="#" class="btn btn-default add2cart">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END TWO PRODUCTS -->
            <!-- BEGIN PROMO -->
            <div class="col-md-6 shop-index-carousel">
                <div class="content-slider">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="<c:url value='/static/assets/frontend/pages/img/index-sliders/slide1.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                            <div class="item">
                                <img src="<c:url value='/static/assets/frontend/pages/img/index-sliders/slide2.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                            <div class="item">
                                <img src="<c:url value='/static/assets/frontend/pages/img/index-sliders/slide3.jpg'/>"
                                     class="img-responsive" alt="Berry Lace Dress">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- END PROMO -->
        </div>
        <!-- END TWO PRODUCTS & PROMO -->
    </div>
</div>

<script>
  // $( document ).ready(function() {
  //   const price = document.getElementById('p-price');
  //   price.value = 'VNĐ' + n.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
  // });
  // function formatCurrency(n) {
  //   n=3000
  //   var price = 'VNĐ' + n.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
  //   document.getElementsByClassName('pi-price').innerHTML = price;
  // }
  // function format2(n, currency) {
  //   return currency + n.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
  // }
</script>