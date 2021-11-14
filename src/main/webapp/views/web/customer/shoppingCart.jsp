<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<c:url value="/home" var="home"/>
<c:url value="/checkout" var="checkout"/>

<c:set var="totalAll" value="0"/>
<%--<c:set var="pQuantity" value="0" scope="application"/>--%>
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
                                    <th class="goods-page-image"><fmt:message
                                            key="image" bundle="${lang}"/></th>
                                    <th class="goods-page-description"><fmt:message
                                            key="description" bundle="${lang}"/></th>
                                    <th class="goods-page-quantity"><fmt:message
                                            key="quantity" bundle="${lang}"/></th>
                                    <th class="goods-page-price"><fmt:message
                                            key="price" bundle="${lang}"/></th>
                                    <th class="goods-page-total" colspan="2"><fmt:message
                                            key="total" bundle="${lang}"/></th>
                                </tr>
                                <c:forEach var="item" items="${cartItems}">
                                    <c:set var="total"
                                           value="${item.productDTO.price*item.quantity}"/>
                                    <c:set var="totalAll" value="${totalAll +total}"/>
                                    <tr>
                                        <td class="goods-page-image">
                                            <a href="#"><img
                                                    src="<c:url value ='/static/assets/frontend/pages/img/products/model3.jpg'/>"
                                                    alt="Berry Lace Dress'/>"></a>
                                        </td>
                                        <td class="goods-page-description">
                                            <h3><a href="#">${item.productDTO.name}</a></h3>
                                            <p><strong>Item 1</strong> - Color: Green; Size: S</p>
                                            <em>More info is here</em>
                                        </td>
                                        <td class="goods-page-quantity">
                                            <div class="product-quantity">
                                                <input id="product-quantity" type="text"
                                                       value="${item.quantity}"
                                                       class="form-control input-sm">
                                            </div>
                                            <button class="btn btn-default" onclick="updateCart(${item.productDTO.productId})">
                                                <fmt:message key="update" bundle="${lang}"/> <i
                                                    class="fa fa-shopping-cart"></i></button>
                                        </td>
                                        <td class="goods-page-price">
                                            <fmt:setLocale value="fr_CA"/>
                                            <strong><fmt:formatNumber
                                                    value="${item.productDTO.price}"
                                                    type="currency"
                                                    maxFractionDigits="0"
                                                    currencySymbol="VNĐ "/></strong>
                                        </td>
                                        <td class="goods-page-total">
                                            <fmt:setLocale value="fr_CA"/>
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
                                <%--                                <li>--%>
                                <%--                                    <em>Sub total</em>--%>
                                <%--                                    <strong class="price"><span>$</span>47.00</strong>--%>
                                <%--                                </li>--%>
                                <%--                                <li>--%>
                                <%--                                    <em>Shipping cost</em>--%>
                                <%--                                    <strong class="price"><span>$</span>3.00</strong>--%>
                                <%--                                </li>--%>
                                <li class="shopping-total-price">
                                    <em>Total</em>
                                    <fmt:setLocale value="fr_CA"/>
                                    <strong class="price"><fmt:formatNumber value="${totalAll}"
                                                                            type="currency"
                                                                            maxFractionDigits="0"
                                                                            currencySymbol="VNĐ "/></strong>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <button class="btn btn-default" type="submit">Continue shopping <i
                            class="fa fa-shopping-cart"></i></button>
                    <a href="${checkout}" class="btn btn-primary" type="submit"><fmt:message
                            key="checkout" bundle="${lang}"/><i class="fa fa-check"></i></a>
                </div>
            </div>
            <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
    </div>
</div>