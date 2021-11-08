<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <div class="note note-danger note-bordered">
                        <p>
                            NOTE: The below datatable is not connected to a real database so the filter and sorting is just simulated for demo purposes only.
                        </p>
                    </div>
                    <!-- Begin: life time stats -->
                    <div class="portlet light">
                        <div class="portlet-title">
                            <div class="caption">
                                <i class="fa fa-gift font-green-sharp"></i>
                                <span class="caption-subject font-green-sharp bold uppercase">Products</span>
                                <span class="caption-helper">manage products...</span>
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
                                            Status
                                        </th>
                                        <th width="10%">
                                            Actions
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="product" items="${products}">
                                            <td>${product.productId}</td>
                                            <td>${product.name}</td>
                                            <td>${product.categoryDTO.name}</td>
                                            <td>${product.brandDTO.name}</td>
                                            <td>${product.price}</td>
                                            <td>${product.quantity}</td>
                                            <td>${product.photo}</td>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <!-- End: life time stats -->
                </div>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->