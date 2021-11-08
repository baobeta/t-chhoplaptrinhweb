<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<c:url value="/home" var="home"/>

<%--<c:set var="cusId"--%>
<%--       value="${sessionScope.loginedUser.userId}"/>--%>

<%--<c:if test="${sessionScope.loginedUser.userId != null}">--%>
<%--    <c:set var="cusId"--%>
<%--           value="${sessionScope.loginedUser.userId}"/>--%>
<%--</c:if>--%>
<%--<c:if test="${sessionScope.loginedUser.userId == null}">--%>
<%--    <c:set var="cusId" value="0"/>--%>
<%--</c:if>--%>

<div class="main">
    <div class="container">
        <ul class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li><a href="${home}"> <fmt:message key="store" bundle="${lang}"/> </a></li>
            <li class="active">Cool green dress with red bell</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN SIDEBAR -->
            <div class="sidebar col-md-3 col-sm-4">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                    <li class="list-group-item clearfix"><a><fmt:message key="viewCategory"
                                                                         bundle="${lang}"/></a></li>
                    <c:forEach items="${cateItems.listResult}" var="category">
                        </li>
                        <li class="list-group-item clearfix dropdown">
                            <a href="shop-product-list.html">
                                <i class="fa fa-angle-right"></i>
                                    ${category.name}
                            </a>
                            <ul class="dropdown-menu">
                                <c:forEach items="${brandItems.listResult}" var="brand">
                                    <li><a href="shop-product-list.html"><i
                                            class="fa fa-angle-right"></i> ${brand.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <!-- END SIDEBAR -->

            <!-- BEGIN CONTENT -->
            <div class="col-md-9 col-sm-7">
                <div class="product-page">
                    <div class="row">
                        <div class="col-md-6 col-sm-6">
                            <div class="product-main-image">
                                <img src="<c:url value='/static/assets/frontend/pages/img/products/model7.jpg'/>"
                                     alt="Cool green dress with red bell" class="img-responsive"
                                     data-BigImgsrc="<c:url value='/static/assets/frontend/pages/img/products/model7.jpg'/>">
                            </div>
                            <div class="product-other-images">
                                <a href="<c:url value='/static/assets/frontend/pages/img/products/model3.jpg'/>"
                                   class="fancybox-button" rel="photos-lib"><img
                                        alt="Berry Lace Dress"
                                        src="<c:url value='/static/assets/frontend/pages/img/products/model3.jpg'/>"></a>
                                <a href="<c:url value='/static/assets/frontend/pages/img/products/model4.jpg'/>"
                                   class="fancybox-button" rel="photos-lib"><img
                                        alt="Berry Lace Dress"
                                        src="<c:url value='/static/assets/frontend/pages/img/products/model4.jpg'/>"></a>
                                <a href="<c:url value='/static/assets/frontend/pages/img/products/model5.jpg'/>"
                                   class="fancybox-button" rel="photos-lib"><img
                                        alt="Berry Lace Dress"
                                        src="<c:url value='/static/assets/frontend/pages/img/products/model5.jpg'/>"></a>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-6">
                            <h1>${product.name}</h1>
                            <div class="price-availability-block clearfix">
                                <div class="price">
                                    <strong>${product.price} VNĐ</strong>
                                    <%--                                    <em>$<span>62.00</span></em>--%>
                                </div>
                                <div class="availability">
                                    <fmt:message key="state" bundle="${lang}"/><strong>: <fmt:message
                                        key="available"
                                        bundle="${lang}"/></strong>
                                </div>
                            </div>
                            <div class="description">
                                <p>${product.description}</p>
                            </div>
                            <div class="product-page-cart">
                                <div class="product-quantity">
                                    <input id="product-quantity" type="text" value="1" readonly
                                           class="form-control input-sm">
                                </div>
                                <button class="btn btn-primary" type="submit" id="btnAddToCart">
                                    <fmt:message
                                            key="addToCart" bundle="${lang}"/>
                                    </button>
                            </div>
                            <div class="review">
                                <input type="range" value="4" step="0.25" id="backing4">
                                <div class="rateit" data-rateit-backingfld="#backing4"
                                     data-rateit-resetable="false" data-rateit-ispreset="true"
                                     data-rateit-min="0" data-rateit-max="5">
                                </div>
                                <a href="#">7 reviews</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">Write
                                a review</a>
                            </div>
                            <ul class="social-icons">
                                <li><a class="facebook" data-original-title="facebook" href="#"></a>
                                </li>
                                <li><a class="twitter" data-original-title="twitter" href="#"></a>
                                </li>
                                <li><a class="googleplus" data-original-title="googleplus"
                                       href="#"></a></li>
                                <li><a class="evernote" data-original-title="evernote" href="#"></a>
                                </li>
                                <li><a class="tumblr" data-original-title="tumblr" href="#"></a>
                                </li>
                            </ul>
                        </div>

                        <div class="product-page-content">
                            <ul id="myTab" class="nav nav-tabs">
                                <li><a href="#Description" data-toggle="tab">Description</a></li>
                                <li><a href="#Information" data-toggle="tab">Information</a></li>
                                <li class="active"><a href="#Reviews" data-toggle="tab">Reviews
                                    (2)</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <div class="tab-pane fade" id="Description">
                                    <p>Description </p>
                                </div>
                                <div class="tab-pane fade" id="Information">
                                    <table class="datasheet">
                                        <tr>
                                            <th colspan="2">Additional features</th>
                                        </tr>
                                        <tr>
                                            <td class="datasheet-features-type">Value 1</td>
                                            <td>21 cm</td>
                                        </tr>
                                        <tr>
                                            <td class="datasheet-features-type">Value 2</td>
                                            <td>700 gr.</td>
                                        </tr>
                                        <tr>
                                            <td class="datasheet-features-type">Value 3</td>
                                            <td>10 person</td>
                                        </tr>
                                        <tr>
                                            <td class="datasheet-features-type">Value 4</td>
                                            <td>14 cm</td>
                                        </tr>
                                        <tr>
                                            <td class="datasheet-features-type">Value 5</td>
                                            <td>plastic</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="tab-pane fade in active" id="Reviews">
                                    <p>There are no reviews for this product.</p>
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Bob</strong>
                                            <em>30/12/2013 - 07:37</em>
                                            <div class="rateit" data-rateit-value="5"
                                                 data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Comment</p>
                                        </div>
                                    </div>
                                    <div class="review-item clearfix">
                                        <div class="review-item-submitted">
                                            <strong>Mary</strong>
                                            <em>13/12/2013 - 17:49</em>
                                            <div class="rateit" data-rateit-value="2.5"
                                                 data-rateit-ispreset="true"
                                                 data-rateit-readonly="true"></div>
                                        </div>
                                        <div class="review-item-content">
                                            <p>Comment</p>
                                        </div>
                                    </div>

                                    <!-- BEGIN FORM-->
                                    <form action="#" class="reviews-form" role="form">
                                        <h2>Write a review</h2>
                                        <div class="form-group">
                                            <label for="name">Name <span
                                                    class="require">*</span></label>
                                            <input type="text" class="form-control" id="name">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email</label>
                                            <input type="text" class="form-control" id="email">
                                        </div>
                                        <div class="form-group">
                                            <label for="review">Review <span
                                                    class="require">*</span></label>
                                            <textarea class="form-control" rows="8"
                                                      id="review"></textarea>
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Rating</label>
                                            <input type="range" value="4" step="0.25" id="backing5">
                                            <div class="rateit" data-rateit-backingfld="#backing5"
                                                 data-rateit-resetable="false"
                                                 data-rateit-ispreset="true" data-rateit-min="0"
                                                 data-rateit-max="5">
                                            </div>
                                        </div>
                                        <div class="padding-top-20">
                                            <button type="submit" class="btn btn-primary">Send
                                            </button>
                                        </div>
                                    </form>
                                    <!-- END FORM-->
                                </div>
                            </div>
                        </div>

                        <div class="sticker sticker-sale"></div>
                    </div>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>