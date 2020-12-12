<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/5
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>

    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small>书籍列表----显示所有书籍</small>
            </h1>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default">
                    <a href="./add/1/" class="text-decoration: none">添加书籍</a>
                </button>
            </div>
                <div class="col-lg-6">
            <form class="form-inline" action="${pageContext.request.contextPath}/book/like" method="post">
                <div class="form-group">
                    <label>
                        <input type="text" name="keyWords" class="form-control"  placeholder="输入要查询名字">
                    </label>
                </div>
                <div class="form-group">
                    <input type="submit" class="form-control" value="查询">
                </div>
                <span class="form-group" style="color: red; font-weight: bold">${ERROR}</span>
            </form>
                </div>
            <table class="table table-hover table-striped">
                <thead>
                <th>书籍编号</th>
                <th>书籍名称</th>
                <th>书籍数量</th>
                <th>书籍描述</th>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach var="book" items="${msg}">
                    <tr> <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td><a href="${pageContext.request.contextPath}/book/update/${book.bookID}/1"
                               class="btn btn-default">修改</a>
                         |
                            <a href="${pageContext.request.contextPath}/book/delete?bookID=${book.bookID}"
                               class="btn btn-default">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
