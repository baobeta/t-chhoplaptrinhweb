<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>


<c:url var="addUser" value="/user-form"/>
<html>
<head>
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-storage.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-database.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase.js"></script>
    <script src="https://www.gstatic.com/firebasejs/8.1.1/firebase-firestore.js"></script>
</head>
<body>

<div>
    <h2>Manage Users | </h2>
</div>

<c:if test="${user != null}">
    <form action="${addUser}" method="post" style="max-width: 800px; margin: 0 auto">
        <input type="hidden" value="${user.userId}" name="pojo.userId"/>
        <div class="border border-secondary rounded p-3">
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
        <div class="border border-secondary rounded p-3">
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
                                   value="${role}"
                                   name="role"
                                   class="m-2"
                            />
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

</body>
</html>
