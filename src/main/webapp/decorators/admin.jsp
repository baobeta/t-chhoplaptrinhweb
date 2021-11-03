<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Metronic | Metronic | Admin Dashboard Template</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="" name="description">
    <meta content="" name="author">
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/font-awesome/css/font-awesome.min.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/simple-line-icons/simple-line-icons.min.css'/>"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/uniform/css/uniform.default.css'/>" rel="stylesheet"
          type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
    <link href="<c:url value='/static/assets/global/plugins/jqvmap/jqvmap/jqvmap.css'/>" rel="stylesheet"
          type="text/css">
    <link href="<c:url value='/static/assets/global/plugins/morris/morris.css'/>" rel="stylesheet" type="text/css">
    <!-- END PAGE LEVEL PLUGIN STYLES -->
    <!-- BEGIN PAGE STYLES -->
    <link href="<c:url value='/static/assets/admin/pages/css/tasks.css'/>" rel="stylesheet" type="text/css"/>
    <!-- END PAGE STYLES -->
    <!-- BEGIN THEME STYLES -->
    <!-- DOC: To use 'rounded corners' style just load 'components-rounded.css' stylesheet instead of 'components.css' in the below style tag -->
    <link href="<c:url value='/static/assets/global/css/components-rounded.css'/>" id="style_components"
          rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/global/css/plugins.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/admin/layout3/css/layout.css'/>" rel="stylesheet" type="text/css">
    <link href="<c:url value='/static/assets/admin/layout3/css/themes/default.css'/>" rel="stylesheet" type="text/css"
          id="style_color">
    <link href="<c:url value='/static/assets/admin/layout3/css/custom.css'/>" rel="stylesheet" type="text/css">
    <!-- END THEME STYLES -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- BEGIN GLOBAL MANDATORY STYLES -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css">
    <!-- END GLOBAL MANDATORY STYLES -->
    <!-- BEGIN PAGE LEVEL STYLES -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/global/plugins/select2/select2.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/static/assets/global/plugins/datatables/plugins/bootstrap/dataTables.bootstrap.css'/>"/>
    <!-- END PAGE LEVEL STYLES -->
    <link rel="shortcut icon" href="favicon.ico"/>
</head>
<body>
<!-- Header -->
<%@ include file="/common/admin/header.jsp" %>
<!-- End Header -->

<dec:body/>

<!-- Begin footer -->
<%@ include file="/common/admin/footer.jsp" %>
<!-- end footer -->

</body>
</html>
