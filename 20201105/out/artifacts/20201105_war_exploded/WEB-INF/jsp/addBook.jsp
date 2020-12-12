<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/5
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<form class="margin active" action="${pageContext.request.contextPath}/book/add/2/" method="post">
    <div class="input-group">
        <span class="input-group-addon" >书籍名称</span>
        <input type="text" class="form-control" name="bookName" placeholder="bookName" required>
    </div>
    <div class="input-group">
        <span class="input-group-addon">书籍数量</span>
        <input type="text" class="form-control" name="bookCounts" placeholder="bookCounts" required>
    </div>
    <div class="input-group">
        <span class="input-group-addon">书籍描述</span>
        <input type="text" class="form-control" name="detail" placeholder="detail" required>
    </div>
    <div class="input-group">
        <input type="submit" class="form-control" placeholder="提交">
    </div>


</form>

</body>
</html>
