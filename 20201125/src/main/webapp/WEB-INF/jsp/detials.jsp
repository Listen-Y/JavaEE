<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/25
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工详细信息</title>
    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">


    <style>
        #body{
            background-image: url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606454884809&di=aec27cdf8431b3821de04c20ea2244a5&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fitbbs%2F1405%2F13%2Fc8%2F34166786_1399947992874.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
    </style>
    <script>
        function back(){
            $.ajax({
                url:"${pageContext.request.contextPath}/success",
                type: "POST",
                success:function (data) {
                        window.location.href = '${pageContext.request.contextPath}/success';
                }
            });
        }
    </script>


</head>
<body id="body">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1 style="font-family: Tahoma, Geneva, sans-serif;color: #050000;font-size: 18px;font-weight: bold;">
                员工信息
            </h1>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header"></div>
            <h1></h1>
        </div>
    </div>
    <div class="row clearfix">
        <form>
            <div class="input-group">
                <span class="input-group-addon">编号</span>
                <label id="id"  class="form-control"  aria-describedby="basic-addon1">${employee.id}</label>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >姓名</span>
                <label id="name"  class="form-control" aria-describedby="basic-addon1">${employee.name}</label>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >性别</span>
                <label id="sex"  class="form-control"  aria-describedby="basic-addon1"><c:if test="${employee.sex == 1}">
                    <c:out value="男"/>
                </c:if>
                    <c:if test="${employee.sex == 0}">
                        <c:out value="女"/>
                    </c:if></label>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >入职</span>
                <label id="entry"  class="form-control"  aria-describedby="basic-addon1">${employee.entry}</label>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >部门</span>
                <label id="depart"  class="form-control"  aria-describedby="basic-addon1">${employee.depart}</label>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >电话</span>
                <label id="phone"  class="form-control"  aria-describedby="basic-addon1">${employee.phone}</label>
            </div>
<%--            <div class="input-group">
                <input type="button" class="form-control" value="返回" onclick="back()" aria-describedby="basic-addon1">
            </div>--%>
            <div class="log-re">
                <button type="button" class="am-btn am-btn-default am-radius log-button" onclick="back()">返回</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
