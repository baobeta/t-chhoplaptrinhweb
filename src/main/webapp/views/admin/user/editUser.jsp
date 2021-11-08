<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="addUser" value="/admin/user/edit"/>

<!-- BEGIN PAGE CONTAINER -->
<div class="page-container">
    <!-- BEGIN PAGE HEAD -->
    <div class="page-head">
        <div class="container">
            <div class="page-title">
                <h1>User Edit <small>create & edit user</small></h1>
            </div>
        </div>
    </div>
    <!-- END PAGE HEAD -->
    <!-- BEGIN PAGE CONTENT -->
    <div class="page-content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <c:if test="${user != null}">
                        <form action="${addUser}" method="post" style="max-width: 800px; margin: 0 auto">
                            <input type="hidden" value="${user.userId}" name="pojo.userId"/>
                            <div class="">
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">E-mail: </label>
                                    <div class="col-sm-8">
                                        <input type="email" class=" form-control" value="${user.email}" name="pojo.email" required minlength="8" maxlength="128"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">First name: </label>
                                    <div class="col-sm-8">
                                        <input type="text" class=" form-control" value="${user.firstName}" name="pojo.firstName" required minlength="2"
                                               maxlength="45"/>
                                    </div>
                                </div>
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Last name: </label>
                                    <div class="col-sm-8">
                                        <input type="text" class=" form-control" value="${user.lastName}" name="pojo.lastName"  required minlength="2"
                                               maxlength="45"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Password: </label>
                                    <div class="col-sm-8">
                                        <input  type="password" class="form-control" value="${user.password}"
                                                minlength="4" maxlenth="20" name="pojo.password"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label ">Roles</label>
                                    <div class="col-sm-8">
                                        <block>
                                            <c:forEach var="role" items="${roles}">
                                                <c:if test="${user.roleDTO.name.equals(role.name)}">
                                                    <input type="radio"
                                                           value="${role}"
                                                           name="role"
                                                           class="m-2"
                                                           checked
                                                    />
                                                </c:if>
                                                <c:if test="${!user.roleDTO.name.equals(role.name)}">
                                                    <input type="radio"
                                                           value="${role}"
                                                           name="role"
                                                           class="m-2"
                                                    />
                                                </c:if>
                                                <br/>
                                            </c:forEach>
                                        </block>
                                    </div>
                                </div>
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Photo: </label>
                                    <div class="col-sm-8">
                                        <input type="file" id="file" accept=".jpg, .png">
                                        <progress id="progress_bar" value="0" max="100"></progress>
                                        <img src="${user.photos}"  alt="" id="image" style="width:300px;height:400px;">
                                        <input type="hidden" name="pojo.photos" id="pathImage" value=""/>
                                        <script src="<c:url value='/static/uploadImageUserFirebase.js'/>" type="text/javascript"></script>

                                    </div>
                                </div>

                                <div class="text-center m-3">
                                    <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                    <input type="button" value="Cancel" class="btn btn-secondary" id="buttonCancel"/>
                                </div>
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${user == null}">
                        <form action="${addUser}" method="post" style="max-width: 800px; margin: 0 auto">
                            <div class="">
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">E-mail: </label>
                                    <div class="col-sm-8">
                                        <input type="email" class=" form-control" name="pojo.email" required minlength="8" maxlength="128"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">First name: </label>
                                    <div class="col-sm-8">
                                        <input type="text" class=" form-control" name="pojo.firstName" required minlength="2"
                                               maxlength="45"/>
                                    </div>
                                </div>
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Last name: </label>
                                    <div class="col-sm-8">
                                        <input type="text" class=" form-control" name="pojo.lastName"  required minlength="2"
                                               maxlength="45"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Password: </label>
                                    <div class="col-sm-8">
                                        <input  type="password" class="form-control"
                                                minlength="4" maxlenth="20" name="pojo.password"/>
                                    </div>
                                </div>

                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label ">Roles</label>
                                    <div class="col-sm-8">
                                        <block>
                                            <c:forEach var="role" items="${roles}">
                                                <input type="radio"
                                                       value="${role.name}"
                                                       name="role"
                                                       class="m-2"
                                                />
                                                <c:out value="${role.name}"></c:out>
                                                <br/>
                                            </c:forEach>
                                        </block>
                                    </div>
                                </div>
                                <div class="form-group row m-3">
                                    <label class="col-sm-4 col-form-label">Photo: </label>
                                    <div class="col-sm-8">
                                        <input type="file" id="file" accept=".jpg, .png">
                                        <progress id="progress_bar" value="0" max="100"></progress>
                                        <img src=""  alt="" id="image" style="width:300px;height:400px;">
                                        <input type="hidden" name="pojo.photos" id="pathImage" value=""/>
                                        <script src="<c:url value='/static/uploadImageUserFirebase.js'/>" type="text/javascript"></script>

                                    </div>
                                </div>

                                <div class="text-center m-3">
                                    <input type="submit" value="Save" class="btn btn-primary m-3"/>
                                    <input type="button" value="Cancel" class="btn btn-secondary" />
                                </div>
                            </div>
                        </form>

                    </c:if>

                </div>
            </div>
            <!-- END PAGE CONTENT INNER -->
        </div>
    </div>
    <!-- END PAGE CONTENT -->
</div>
<!-- END PAGE CONTAINER -->