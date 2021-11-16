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

<!---PAGINATION--->
<script type="text/javascript">
  $("body").on("click", ".paginationItem", function () {
    var currentPage = $(this).text();
    var firstIndex = (currentPage - 1) *${productItems.maxPageItems};
    var sort = '${empty productItems.sort?'':productItems.sort}';
    var searchName = '${empty productItems.searchName?'':productItems.searchName}';
    var brandId = ${empty productItems.brand.brandId?0:productItems.brand.brandId};
    var categoryId = ${empty productItems.category.categoryId?0:productItems.category.categoryId};

    $.ajax({
      url: "/api/get-product-list",
      type: "GET",
      data: {
        firstIndex: firstIndex,
        brandId: brandId,
        categoryId: categoryId,
        searchName: searchName,
        sort: sort
      },
      success: function (value) {
        var productList = $("#product-list").find("#product-item");
        productList.empty();
        productList.append(value);
      }
    })
  })
</script>


<!---UPDATE CART QUANTITY--->
<script type="text/javascript">
   function updateCart(productId) {
    var cusId = ${sessionScope.loginedUser.userId};
    var quantity = document.getElementById('product-quantity').value;

    $.ajax({
      url: "/api/update-cart",
      type: "POST",
      data: {
        cusId: cusId,
        quantity: quantity,
        productId: productId
      },
      success: function () {
        alert('Cập nhật thành công');
      }
    });
  }

  function getProductId(productId){
    return productId;
  }
</script>

<!--ADD PRODUCT TO CART--->
<script>
  function setCookie(cname, cvalue, exdays) {
    const d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    let expires = "expires=" + d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/cart";
  }

  function addToCart() {
    var productId = ${product.productId};
    var cusId = ${empty sessionScope.loginedUser.userId ? -1: sessionScope.loginedUser.userId };
    $.ajax({
      url: "/api/add-to-cart",
      type: "POST",
      data: {
        cusId: cusId,
        productId: productId
      },
      success: function (value) {
        if (cusId == -1) {
          setCookie('productId' + productId, productId, 1);
        }
        document.getElementById('successful-add').innerHTML='THÊM THÀNH CÔNG';
      },
      error :function (value){
        document.getElementById('successful-add').innerHTML='THÊM THẤT BẠI';
      }
    })
  }
</script>


<!--CHECK PASSWORD--->
<script  type="text/javascript">
  $(document).ready(function () {
    $('#pass, #re_pass').on('keyup', function () {
      if ($('#pass').val() != '' && $('#re_pass').val() != '') {
        if ($('#pass').val() == $('#re_pass').val()) {
          $('#check_matching').html('OK').css('color', 'green');
          $('#signup').prop('disabled', false);
        } else {
          $('#check_matching').html('Không OK').css('color', 'red');
          $('#signup').prop('disabled', true);
        }
      } else {
        $('#check_matching').text('')
      }
    });
  });
</script>

<%--<script type="text/javascript">--%>

<%--  function sortFunction() {--%>
<%--    var selectBox = document.getElementById("sortBox");--%>
<%--    var selectedValue = selectBox.options[selectBox.selectedIndex].value;--%>
<%--    document.getElementById("sortInput").value=selectedValue;--%>
<%--  }--%>
<%--</script>--%>

<!-- END CORE PLUGINS -->
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
</html>
