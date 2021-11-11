<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <!-- BEGIN PAGE TITLE -->
            <div class="page-title">
                <h1>Product Edit <small>create & edit product</small></h1>
            </div>
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <ul class="page-breadcrumb breadcrumb">
                <li>
                    <a href="<c:url value="/admin"/>">Home</a><i class="fa fa-circle"></i>
                </li>
                <li class="active">
                    Product Edit
                </li>
            </ul>
            <!-- END PAGE BREADCRUMB -->
            <!-- BEGIN PAGE CONTENT INNER -->
            <div class="row">
                <div class="col-md-12">
                    <form class="form-horizontal form-row-seperated" action="javascript:;">
                        <div class="portlet light">
                            <div class="portlet-body">
                                <div class="tabbable">
                                    <div class="tab-content no-space">
                                        <div class="tab-pane active" id="tab_general">
                                            <div class="form-body">
                                                <form action="${addUser}" method="post" style="max-width: 800px; margin: 0 auto">
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Name:
                                                            <span class="required">* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <input type="text" class="form-control" name="product[name]" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Description: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <textarea class="form-control" name="product[description]"></textarea>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Price
                                                            <span class="required"> * </span></label>
                                                        <div class="col-md-10">
                                                            <input type="text" class="form-control" name="product[name]" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Quantity: <span class="required">* </span></label>
                                                        <div class="col-md-10">
                                                            <input type="text" class="form-control" name="product[name]" placeholder="">
                                                        </div>
                                                    </div>
                                                    <div class="form-group ">
                                                        <label class="col-md-2 control-label">Photo: </label>
                                                        <div class="col-md-10">
                                                            <div>
                                                                <input type="file" id="file" accept=".jpg, .png">
                                                                <progress id="progress_bar" value="0" max="100"></progress>
                                                            </div>
                                                            <div>
                                                                <img src=""  alt="" id="image" style="width:300px;height:400px;">
                                                                <input type="hidden" name="pojo.photos" id="pathImage" value=""/>
                                                                <script src="<c:url value='/static/uploadImageUserFirebase.js'/>" type="text/javascript"></script>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Category: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <select class="table-group-action-input form-control input-medium" name="product[tax_class]">
                                                                <option value="">Select...</option>
                                                                <option value="1">None</option>
                                                                <option value="0">Taxable Goods</option>
                                                                <option value="0">Shipping</option>
                                                                <option value="0">USA</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-md-2 control-label">Brand: <span class="required">
													* </span>
                                                        </label>
                                                        <div class="col-md-10">
                                                            <select class="table-group-action-input form-control input-medium" name="product[status]">
                                                                <option value="">Select...</option>
                                                                <option value="1">Published</option>
                                                                <option value="0">Not Published</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->