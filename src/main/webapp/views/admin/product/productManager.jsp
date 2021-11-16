<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Manage Products <small>product listing</small></h1>
            </div>
            <!-- END PAGE TITLE -->
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="#">Home</a><i class="fa fa-circle"></i>
                </li>
                <li>
                    <a href="ecommerce_products.html">Features</a>
                    <i class="fa fa-circle"></i>
                </li>
                <li class="active">
                    Manage Products
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <c:if test="${message != null}">
                <div class="alert alert-success text-center">
                    <c:out value="${message}"></c:out>
                </div>
            </c:if>
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <!-- Begin: life time stats -->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Products</span>
                                <span class="caption-helper">manage products...</span>
                            </div>
                            <div class="col-md-6">
                                <div class="btn-group">
                                    <a class="btn green"href="<c:url value='/admin/product/edit'/>">Thêm sản phẩm</a>
                                </div>
                            </div>
                        </div>
                        <div class="portlet-body">
                            <div class="table-container">
                                <table class="table table-striped table-bordered table-hover" id="datatable_products">
                                    <thead>
                                    <tr role="row" class="heading">
                                        <th width="10%">
                                            ID
                                        </th>
                                        <th width="15%">
                                            Product&nbsp;Name
                                        </th>
                                        <th width="15%">
                                            Category
                                        </th>
                                        <th width="10%">
                                            Brand
                                        </th>
                                        <th width="10%">
                                            Price
                                        </th>
                                        <th width="10%">
                                            Quantity
                                        </th>
                                        <th width="15%">
                                            Photo
                                        </th>
                                        <th width="10%">
                                            Actions
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="product" items="${products}">
                                        <tr>
                                            <td>${product.productId}</td>
                                            <td>${product.name}</td>
                                            <td>${product.categoryDTO.name}</td>
                                            <td>${product.brandDTO.name}</td>
                                            <td>${product.price}</td>
                                            <td>${product.quantity}</td>
                                            <td><img src="${product.photo}"  alt="" id="image" style="width:200px;height:300px;"></td>
                                            <td>
                                                <c:url value="/admin/product/edit" var="updateURL">
                                                    <c:param name="productId" value="${product.productId}"/>
                                                    <c:param name="page" value="1"/>
                                                </c:url>
                                                <a class="btn green" href="${updateURL}">Sửa</a>
                                                <form action="<c:url value="/admin/product/delete"/>" method="post">
                                                    <input type="hidden" name="idDelete" value="${product.productId}"/>
                                                    <button type="submit" class="btn btn-primary">Xóa</button>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End: life time stats -->
                </div>
            </div>
            <div style="text-align: center;">
                <nav aria-label="...">
                    <ul class="pagination justify-content-center=">

                        <li class="page-item ">
                            <c:url var="urlPageBegin" value="/admin/product">
                                <c:param name="page" value="${(pojo.page-1) < 1 ? 1 : (pojo.page-1) }"/>
                            </c:url>
                            <a class="page-link" href="${urlPageBegin}">Previous</a>
                        </li>
                        <c:forEach var = "i" begin = "1" end = "${pojo.totalItems}">
                            <c:if test="${i==pojo.page}">
                                <li class="page-item active">
                                    <a class="page-link" href="${i==pojo.page}" >${i} <span class="sr-only"></span></a>
                                </li>
                            </c:if>
                            <c:if test="${i!=pojo.page}">
                                <li class="page-item">
                                    <c:url var="urlPage" value="/admin/product">
                                        <c:param name="page" value="${i}"/>
                                    </c:url>
                                    <a class="page-link" href="${urlPage}">${i}</a>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li class="page-item">
                            <c:url var="urlPageEnd" value="/admin/product">
                                <c:param name="page" value="${(pojo.page+1)> pojo.totalItems ? pojo.totalItems : (pojo.page+1) }"/>
                            </c:url>
                            <a class="page-link" href="${urlPageEnd}">Next</a>
                        </li>

                    </ul>
                </nav>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->