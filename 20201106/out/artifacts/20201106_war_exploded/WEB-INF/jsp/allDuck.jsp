<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/6
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>黑天鹅</title>

    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1>
                <small>黑天鹅</small>
            </h1>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default">
                    <a href="${pageContext.request.contextPath}/duck/add/1" class="text-decoration: none">添加黑天鹅</a>
                </button>
            </div>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default">
                    <a href="${pageContext.request.contextPath}/duck/range/1" class="text-decoration: none">条件查找</a>
                </button>
            </div>
            <div class="col-lg-6">
                <form class="form-inline" action="${pageContext.request.contextPath}/duck/like" method="post">
                    <div class="form-group">
                        <label>
                            <input type="text" name="keyWords" class="form-control"  placeholder="输入要查询的名字">
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
                <th>编号</th>
                <th>名称</th>
                <th>入校日期</th>
                <th>身高</th>
                <th>体重</th>
                <th>饭量</th>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach var="duck" items="${list}">
                    <tr> <td>${duck.id}</td>
                        <td>${duck.name}</td>
                        <td>${duck.birthday}</td>
                        <td>${duck.height}</td>
                        <td>${duck.weight}</td>
                        <td>${duck.food}</td>
                        <td><a href="${pageContext.request.contextPath}/duck/update/${duck.id}/1"
                               class="btn btn-default">修改</a>
                            |
                            <a href="${pageContext.request.contextPath}/duck/delete?duckID=${duck.id}"
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
