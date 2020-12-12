<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/5
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<form action="${pageContext.request.contextPath}/book/update/0/2" method="post">
    <input type="hidden" name="bookID" value="${book.bookID}">
    <div class="input-group">
        <span class="input-group-addon" >书籍名称</span>
        <input type="text" class="form-control" name="bookName" value="${book.bookName}" required>
    </div>
    <div class="input-group">
        <span class="input-group-addon">书籍数量</span>
        <input type="text" class="form-control" name="bookCounts" value="${book.bookCounts}" required>
    </div>
    <div class="input-group">
        <span class="input-group-addon">书籍描述</span>
        <input type="text" class="form-control" name="detail" value="${book.detail}" required>
    </div>
    <div class="input-group">
        <input type="submit" class="form-control" placeholder="修改">
    </div>


</form>

</body>
</html>
