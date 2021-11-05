<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>TechShop</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link rel="shortcut icon" href="favicon.ico">

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
          rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
          rel="stylesheet" type="text/css"><!--- fonts for slider on the index page -->
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="<c:url value='/static/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>"
          rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/slider-layer-slider/css/layerslider.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/global/plugins/uniform/css/uniform.default.css'/>"
          rel="stylesheet" type="text/css">
    <link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet"
          type="text/css">
    <!-- for slider-range -->
    <link href="<c:url value='/static/assets/global/plugins/rateit/src/rateit.css'/>"
          rel="stylesheet" type="text/css">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="<c:url value='/static/assets/global/css/components.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style.css'/>" rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/pages/css/style-shop.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/frontend/pages/css/style-layer-slider.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/style-responsive.css'/>"
          rel="stylesheet">
    <link href="<c:url value='/static/assets/frontend/layout/css/themes/red.css'/>" rel="stylesheet"
          id="style-color">
    <link href="<c:url value='/static/assets/frontend/layout/css/custom.css'/>" rel="stylesheet">

</head>
<body class="ecommerce">
<!-- Header -->
<%@ include file="/common/web/header.jsp" %>
<!-- End Header -->

<!-- Begin body -->
<dec:body/>
<!-- End body -->

<!-- Begin footer -->
<%@ include file="/common/web/footer.jsp" %>
<!-- end footer -->
<script src="<c:url value='/static/assets/global/plugins/respond.min.js'/>"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-migrate.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/bootstrap/js/bootstrap.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/layout/scripts/back-to-top.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js'/>"
        type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="<c:url value='/static/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js'/>"
        type="text/javascript"></script><!-- pop up -->
<script src="<c:url value='/static/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js'/>"
        type="text/javascript"></script><!-- slider for products -->
<script src="<c:url value='/static/assets/global/plugins/zoom/jquery.zoom.min.js'/>"
        type="text/javascript"></script><!-- product zoom -->
<script src="<c:url value='/static/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js'/>"
        type="text/javascript"></script><!-- Quantity -->
<script src="<c:url value='/static/assets/global/plugins/uniform/jquery.uniform.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/rateit/src/jquery.rateit.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/frontend/pages/scripts/checkout.js'/>"
        type="text/javascript"></script>
<!-- BEGIN LayerSlider -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/greensock.js'/>"
        type="text/javascript"></script><!-- External libraries: GreenSock -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/layerslider.transitions.js'/>"
        type="text/javascript"></script><!-- LayerSlider script files -->
<script src="<c:url value='/static/assets/global/plugins/slider-layer-slider/js/layerslider.kreaturamedia.jquery.js'/>"
        type="text/javascript"></script><!-- LayerSlider script files -->
<script src="<c:url value='/static/assets/frontend/pages/scripts/layerslider-init.js'/>"
        type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js" type="text/javascript"></script>
<!-- for slider-range -->
<!-- END LayerSlider -->

<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    Layout.initTwitter();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initUniform();
    Checkout.init();
  });
</script>

<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    Layout.initTwitter();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initUniform();
    Layout.initSliderRange();
  });
</script>

<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    LayersliderInit.initLayerSlider();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initTwitter();
  });
</script>

<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initOWL();
    Layout.initTwitter();
    Layout.initImageZoom();
    Layout.initTouchspin();
    Layout.initUniform();
  });
</script>
<script type="text/javascript">
  jQuery(document).ready(function () {
    Layout.init();
    Layout.initTwitter();
  });
</script>

<script>
  $("body").on("click", ".paginationItem", function () {
    var page = $(this).text();
    var firstIndex = (page - 1)*${productItems.maxPageItems};



    $.ajax({
      url:"/api/get-product-list",
      type: "GET",
      data:{
        firstIndex: firstIndex
      },
      success: function(value){
        var productList = $("#product-list").find("#product-item");
        productList.empty();
        productList.append(value);
      }
    })
  })
</script>

<!-- END CORE PLUGINS -->
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
</html>
