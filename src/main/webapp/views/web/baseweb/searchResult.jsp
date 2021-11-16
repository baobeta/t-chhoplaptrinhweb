<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>

<fmt:setLocale value="vi_VN"/>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-4">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a><fmt:message key="viewCategory"
                                                                         bundle="${lang}"/></a></li>
                    <c:forEach items="${cateItems.brandInCate}" var="category">
                        </li>
                        <li class="list-group-item clearfix dropdown">
                            <a href="shop-product-list.html">
                                <i class="fa fa-angle-right"></i>
                                    ${category.key.name}
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${category.value}" var="brand">
                                    <c:url var="search" value="/search">
                                        <c:param name="brand.brandId" value="${brand.brandId}"/>
                                        <c:param name="category.categoryId"
                                                 value="${category.key.categoryId}"/>
                                    </c:url>
                                    <li><a href="${search}">${brand.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- END SIDEBAR -->
            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7">
                <div class="row list-view-sorting clearfix">
                    <div class="col-md-2 col-sm-2 list-view">
                        <a href="#"><i class="fa fa-th-large"></i></a>
                        <a href="#"><i class="fa fa-th-list"></i></a>
                    </div>
                    <div class="content-search margin-bottom-20">
                        <div class="row">
                            <div class="col-md-6">
                                <h1><fmt:message key="searchResult" bundle="${lang}"/>
                                    <em>${productItems.searchName}</em></h1>
                            </div>
                            <div class="col-md-6">
                                <form action="${searchInfilter}" method="get">
                                    <input type="hidden" name="brand.brandId"
                                           value="${productItems.brand.brandId}">
                                    <input type="hidden" name="category.categoryId"
                                           value="${productItems.category.categoryId}">
                                    <div class="input-group">
                                        <input type="text" placeholder="Tìm kiếm trong danh sách"
                                               name="searchName"
                                               value="${productItems.searchName}"
                                               class="form-control">
                                        <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit"><fmt:message key="search"
                                                                                   bundle="${lang}"/></button>
                      </span>
                                    </div>
                                    <div class="col-md-10 col-sm-10">
                                        <div class="pull-right">
                                            <label class="control-label">Sort&nbsp;By:</label>
                                            <select class="form-control input-sm" name="sort">
                                                <option value="name-ASC" selected="selected">
                                                    Name (A - Z)
                                                </option>
                                                <option value="name-DESC">
                                                    Name (Z - A)
                                                </option>
                                                <option value="price-ASC">
                                                    Price (Low &gt; High)
                                                </option>
                                                <option value="price-DESC">
                                                    Price (High &gt;Low)
                                                </option>
                                            </select>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>

                <!-- BEGIN PRODUCT LIST -->
                <div class="row product-list" id="product-list">

                    <div id="product-item">
                        <!-- PRODUCT ITEMS START -->
                        <c:forEach items="${productItems.listResult}" var="product">
                            <div class="col-md-4 col-sm-6 col-xs-12">
                                <div class="product-item">
                                    <div class="pi-img-wrapper">
                                        <img src="${product.photo}"
                                             style="height: 165px;margin-left: auto;margin-right: auto;"
                                             class="img-responsive" alt="Berry Lace Dress">
                                        <div>
                                            <a href="${product.photo}"
                                               class="btn btn-default fancybox-button">Zoom</a>
                                            <c:url var="pDetail" value="/pDetail">
                                                <c:param name="pojo.productId"
                                                         value="${product.productId}"/>
                                            </c:url>
                                            <a href="${pDetail}"
                                               class="btn btn-default fancybox-fast-view"><fmt:message
                                                    key="view" bundle="${lang}"/> </a>
                                        </div>
                                    </div>
                                    <h3><a href="shop-item.html">${product.name}</a></h3>

                                    <div class="pi-price"><fmt:formatNumber value="${product.price}"
                                                                            type="currency"
                                                                            maxFractionDigits="0"/>
                                    </div>
                                    <c:if test="${product.sale}">
                                        <div class="sticker sticker-sale"></div>
                                    </c:if>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- PRODUCT ITEMS END -->
                </div>
                <!-- END PRODUCT LIST -->
                <!-- BEGIN PAGINATOR -->
                <div class="row">
                    <div class="col-md-4 col-sm-4 items-info">Items 1 to 9 of 10 total</div>
                    <div class="col-md-8 col-sm-8">
                        <ul class="pagination pull-right">
                            <li class="paginationItem"><a href="#">&laquo;</a></li>
                            <c:forEach var="page" begin="1" end="${productItems.totalPages}">
                                <c:choose>
                                    <c:when test="${page == 1 }">
                                        <li class="paginationItem"><span><a
                                                href="#">${page}</a></span></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="paginationItem"><a href="#">${page}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <li class="paginationItem"><a href="#">&raquo;</a></li>
                        </ul>
                    </div>
                </div>
                <!-- END PAGINATOR -->
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>

<!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="<c:url value='/static/assets/global/plugins/respond.min.js'/>"></script>
<![endif]-->
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
        type="text/javascript"></script>
<!-- pop up -->
<script src="<c:url value='/static/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js'/>"
        type="text/javascript"></script>
<!-- slider for products -->
<script src="<c:url value='/static/assets/global/plugins/zoom/jquery.zoom.min.js'/>"
        type="text/javascript"></script>
<!-- product zoom -->
<script src="<c:url value='/static/assets/global/plugins/bootstrap-touchspin/bootstrap.touchspin.js'/>"
        type="text/javascript"></script>
<!-- Quantity -->
<script src="<c:url value='/static/assets/global/plugins/uniform/jquery.uniform.min.js'/>"
        type="text/javascript"></script>
<script src="<c:url value='/static/assets/global/plugins/rateit/src/jquery.rateit.js'/>"
        type="text/javascript"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js'/>" type="text/javascript"></script>
<!-- for slider-range -->

<script src="<c:url value='/static/assets/frontend/layout/scripts/layout.js'/>"
        type="text/javascript"></script>
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
<!-- END PAGE LEVEL JAVASCRIPTS -->