<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/25
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <label class="label label-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo"></label>
            <br>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <a href="${pageContext.request.contextPath}/addEmployee" class="btn btn-primary">添加员工</a>
            <a href="${pageContext.request.contextPath}/down" class="btn btn-primary">注销</a>
            <div class="col-lg-6">
                <form class="form-inline" action="${pageContext.request.contextPath}/findLike" method="post">
                    <div class="form-group">
                        <label>
                            <input type="text" name="keyWords" class="form-control"  placeholder="输入要查询的名字">
                        </label>
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="查找">
                    </div>
                    <span class="form-group" style="color: #ff0000; font-weight: bold">${ERROR}</span>
                </form>
            </div>
            <table class="table table-hover table-striped">
                <thead>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>入职时间</th>
                <th>所属部门</th>
                <th>联系方式</th>
                <th>操作</th>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${list}">
                    <tr> <td>${employee.id}</td>
                        <td>${employee.name}</td>
                        <%--<td>${employee.sex}</td>--%>
                        <td><c:if test="${employee.sex == 1}">
                            <c:out value="男"/>
                        </c:if>
                            <c:if test="${employee.sex == 0}">
                                <c:out value="女"/>
                            </c:if></td>
                        <td>${employee.entry}</td>
                        <td>${employee.depart}</td>
                        <td>${employee.phone}</td>
                        <td><a class="btn btn-primary" href="${pageContext.request.contextPath}/update/${employee.id}"
                               role="button">修改</a>
                            |
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/delete?employeeId=${employee.id}"
                               role="button">删除</a>
                            |
                            <a href="${pageContext.request.contextPath}/query?employeeId=${employee.id}" class="btn btn-primary">查看</a>
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
