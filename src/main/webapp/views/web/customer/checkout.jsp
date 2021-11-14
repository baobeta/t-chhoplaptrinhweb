<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>

<c:set var="totalAll" value="0"/>

<c:url value="/checkout" var="checkout"/>
<div class="main">
    <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
            <!-- BEGIN CONTENT -->
            <div class="col-md-12 col-sm-12">
                <h1>
                    <%--                    <fmt:message key="checkout" bundle="${lang}">--%>
                </h1>
                <form action="${checkout}" method="post">

                    <!-- BEGIN CHECKOUT PAGE -->
                    <div class="panel-group checkout-page accordion scrollable" id="checkout-page">
                        <!-- BEGIN SHIPPING ADDRESS -->
                        <div id="shipping-address" class="panel panel-default">
                            <div class="panel-heading">
                                <h2 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#checkout-page"
                                       href="#shipping-address-content" class="accordion-toggle">
                                        BƯỚC 1: NHẬP THÔNG TIN
                                    </a>
                                </h2>
                            </div>
                            <div id="shipping-address-content" class="panel-collapse collapse">
                                <div class="panel-body row">
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="telephone-dd">
                                                <fmt:message key="phone" bundle="${lang}"/>
                                            </label>
                                            <input type="text" id="telephone-dd"
                                                   name="pojo.phoneNumber"
                                                   class="form-control"
                                                   required>
                                        </div>
                                    </div>
                                    <div class="col-md-6 col-sm-6">
                                        <div class="form-group">
                                            <label for="address-dd">
                                                <fmt:message key="address" bundle="${lang}"/>
                                            </label>
                                            <input type="text" name="pojo.address" id="address-dd"
                                                   class="form-control"
                                                   required>
                                        </div>
                                    </div>
<%--                                    <div class="col-md-12">--%>
<%--                                        <button class="btn btn-primary  pull-right" type="submit"--%>
<%--                                                id="button-shipping-address" data-toggle="collapse"--%>
<%--                                                data-parent="#checkout-page"--%>
<%--                                                data-target="#shipping-method-content">--%>
<%--                                            <fmt:message key="continue" bundle="${lang}"/>--%>
<%--                                        </button>--%>
<%--                                    </div>--%>
                                </div>
                            </div>
                        </div>
                        <!-- END SHIPPING ADDRESS -->

                        <!-- BEGIN CONFIRM -->
                        <div id="confirm" class="panel panel-default">
                            <div class="panel-heading">
                                <h2 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#checkout-page"
                                       href="#confirm-content" class="accordion-toggle">
                                        BƯỚC 2: XÁC NHẬN ĐƠN HÀNG
                                    </a>
                                </h2>
                            </div>
                            <div id="confirm-content" class="panel-collapse collapse">
                                <div class="panel-body row">
                                    <div class="col-md-12 clearfix">
                                        <div class="table-wrapper-responsive">
                                            <table>
                                                <tr>
                                                    <th class="checkout-image">
                                                        <fmt:message key="image" bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-description">
                                                        <fmt:message key="description"
                                                                     bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-quantity">
                                                        <fmt:message key="quantity"
                                                                     bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-price">
                                                        <fmt:message key="price" bundle="${lang}"/>
                                                    </th>
                                                    <th class="checkout-total">
                                                        <fmt:message key="total" bundle="${lang}"/>
                                                    </th>
                                                </tr>
                                                <c:forEach items="${cartItems}" var="item">
                                                    <c:set var="total"
                                                           value="${item.productDTO.price*item.quantity}"/>
                                                    <c:set var="totalAll"
                                                           value="${totalAll +total}"/>
                                                    <tr>
                                                        <td class="checkout-image">
                                                            <a href="#"><img
                                                                    src="<c:url value='/static/assets/frontend/pages/img/products/model3.jpg'/>"
                                                                    alt="Berry Lace Dress"></a>
                                                        </td>
                                                        <td class="checkout-description">
                                                            <h3>
                                                                <a href="#">${item.productDTO.name}</a>
                                                            </h3>
                                                            <p><strong>Item 1</strong> - Color:
                                                                Green;
                                                                Size:
                                                                S</p>
                                                            <em>More info is here</em>
                                                        </td>
                                                        <td class="checkout-quantity">${item.quantity}</td>
                                                        <td class="checkout-price">
                                                            <fmt:setLocale value="fr_CA"/>
                                                            <strong>
                                                                <fmt:formatNumber
                                                                        value="${item.productDTO.price}"
                                                                        type="currency"
                                                                        maxFractionDigits="0"
                                                                        currencySymbol="VNĐ "/>
                                                            </strong>
                                                        </td>
                                                        <td class="checkout-total">
                                                            <fmt:setLocale value="fr_CA"/>
                                                            <strong>
                                                                <fmt:formatNumber value="${total}"
                                                                                  type="currency"
                                                                                  maxFractionDigits="0"
                                                                                  currencySymbol="VNĐ "/>
                                                            </strong>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                        </div>
                                        <div class="checkout-total-block">
                                            <ul>
                                                <li class="checkout-total-price">
                                                    <em><fmt:message key="total"
                                                                     bundle="${lang}"/> </em>
                                                    <fmt:setLocale value="fr_CA"/>
                                                    <strong class="price">
                                                        <fmt:formatNumber value="${totalAll}"
                                                                          type="currency"
                                                                          maxFractionDigits="0"
                                                                          currencySymbol="VNĐ "/>
                                                    </strong>
                                                </li>
                                            </ul>
                                        </div>
<%--                                        <input type="hidden" name="cartItems" value="${cartItems}"/>--%>
                                        <input type="hidden" name="total" value="${totalAll}"/>
                                        <input type="hidden" name="cusId" value="${sessionScope.loginedUser.userId}"/>
                                        <div class="clearfix"></div>
                                        <button class="btn btn-primary pull-right" type="submit"
                                                id="button-confirm">
                                            <fmt:message key="confirmOrder" bundle="${lang}"/>
                                        </button>
                                        <button type="button"
                                                class="btn btn-default pull-right margin-right-20">
                                            <fmt:message key="cancel" bundle="${lang}"/>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- END CONFIRM -->
                    </div>
                    <!-- END CHECKOUT PAGE -->
                </form>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>