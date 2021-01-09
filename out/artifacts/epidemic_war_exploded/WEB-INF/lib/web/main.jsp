<%--  Created by sibingmao  Date: 2020/2/25 11:46 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>疫情发布系统后台管理</title>
    <jsp:include page="template/bootstrap_common.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="template/top.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-3">
            <jsp:include page="template/menu.jsp"></jsp:include>
        </div>
        <div class="col-md-9">
            <ul class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
                <li>后台主页</li>
            </ul>
            这是主页的内容。。。
        </div>
    </div>
    <div class="row">第三行</div>
</div>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.11.2.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</body>
</html>
