<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
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
                                        <c:param name="category.categoryId" value="${category.key.categoryId}"/>
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
                                <h1><fmt:message key="searchResult" bundle="${lang}"/> <em>KET QUA</em></h1>
                            </div>
                            <div class="col-md-6">
                                <form action="#">
                                    <div class="input-group">
                                        <input type="text" placeholder="Search again" class="form-control">
                                        <span class="input-group-btn">
                        <button class="btn btn-primary" type="submit"><fmt:message key="search" bundle="${lang}"/></button>
                      </span>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-10 col-sm-10">
                        <div class="pull-right">
                            <label class="control-label">Show:</label>
                            <select class="form-control input-sm">
                                <option value="#?limit=24" selected="selected">24</option>
                                <option value="#?limit=25">25</option>
                                <option value="#?limit=50">50</option>
                                <option value="#?limit=75">75</option>
                                <option value="#?limit=100">100</option>
                            </select>
                        </div>
                        <div class="pull-right">
                            <label class="control-label">Sort&nbsp;By:</label>
                            <select class="form-control input-sm">
                                <option value="#?sort=p.sort_order&amp;order=ASC"
                                        selected="selected">Default
                                </option>
                                <option value="#?sort=pd.name&amp;order=ASC">Name (A - Z)</option>
                                <option value="#?sort=pd.name&amp;order=DESC">Name (Z - A)</option>
                                <option value="#?sort=p.price&amp;order=ASC">Price (Low &gt; High)
                                </option>
                                <option value="#?sort=p.price&amp;order=DESC">Price (High &gt;
                                    Low)
                                </option>
                                <option value="#?sort=rating&amp;order=DESC">Rating (Highest)
                                </option>
                                <option value="#?sort=rating&amp;order=ASC">Rating (Lowest)</option>
                                <option value="#?sort=p.model&amp;order=ASC">Model (A - Z)</option>
                                <option value="#?sort=p.model&amp;order=DESC">Model (Z - A)</option>
                            </select>
                        </div>
                    </div>
                </div>

                <!-- BEGIN PRODUCT LIST -->
                <div class="row product-list" id="product-list">

                    <div id="product-item">
                        <!-- PRODUCT ITEMS START -->
                        <c:forEach items="${productItems.listResult}" var="product">
                            <div class="col-md-4 col-sm-6 col-xs-12" >
                                <div class="product-item">
                                    <div class="pi-img-wrapper">
                                        <img src="<c:url value='/static/assets/frontend/pages/img/products/model1.jpg'/>"
                                             class="img-responsive" alt="Berry Lace Dress">
                                        <div>
                                            <a href="<c:url value='/static/assets/frontend/pages/img/products/model1.jpg'/>"
                                               class="btn btn-default fancybox-button">Zoom</a>
                                            <c:url var="pDetail" value="/pDetail">
                                                <c:param name="pojo.productId"
                                                         value="${product.productId}"/>
                                            </c:url>
                                            <a href="${pDetail}"
                                               class="btn btn-default fancybox-fast-view">View</a>
                                        </div>
                                    </div>
                                    <h3><a href="shop-item.html">${product.name}</a></h3>
                                    <fmt:setLocale value="fr_CA"/>
                                    <div class="pi-price"><fmt:formatNumber value="${product.price}"
                                                                            type="currency"
                                                                            maxFractionDigits="0"
                                                                            currencySymbol="VNĐ"/></div>
<%--                                    <a href="#" class="btn btn-default add2cart">Add to cart</a>--%>
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
                                        <li class="paginationItem"><span><a href="#">${page}</a></span></li>
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
