<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/6
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加黑天鹅</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <form action="${pageContext.request.contextPath}/duck/add/2" method="post">
            <div class="input-group">
                <span class="input-group-addon" >名称</span>
                <input type="text" class="form-control" name="name" placeholder="" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" >身高</span>
                <input type="text" class="form-control" name="height" placeholder="单位米" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" >体重</span>
                <input type="text" class="form-control" name="weight" placeholder="单位KG" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon">饭量</span>
                <input type="text" class="form-control" name="food" placeholder="单位KG" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <input type="submit" class="form-control" value="提交" aria-describedby="basic-addon1">
            </div>
        </form>
    </div>
</div>
</body>
</html>
