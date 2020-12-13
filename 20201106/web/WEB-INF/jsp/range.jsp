<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/6
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>条件查找</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row clearfix">
        <form action="${pageContext.request.contextPath}/duck/range/2" method="post">
        <div class="input-group">
            <span class="input-group-addon" >最小身高</span>
            <input type="text" class="form-control" name="minHeight" placeholder="minHeight" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >最大身高</span>
            <input type="text" class="form-control" name="maxHeight" placeholder="maxHeight" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
            <span class="input-group-addon" >最小体重</span>
            <input type="text" class="form-control" name="minWeight" placeholder="minWeight" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
            <span class="input-group-addon">最大体重</span>
            <input type="text" class="form-control" name="maxWeight" placeholder="maxWeight" aria-describedby="basic-addon1">
        </div>
        <div class="input-group">
            <input type="submit" class="form-control" value="查找" aria-describedby="basic-addon1">
        </div>
        </form>
    </div>
</div>
</body>
</html>
