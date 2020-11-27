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
    <title>修改员工</title>
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
        function add(){
            $.ajax({
                url:"${pageContext.request.contextPath}/update",
                type: "POST",
                data:{"id":$("#id").val(),"name":$("#name").val(),"sex":$("#sex").val(),"depart":$("#depart").val(),"phone":$("#phone").val()},
                success:function (data) {
                    if (data==="OK"){
                        window.location.href = '${pageContext.request.contextPath}/success';
                    } else {
                        alert(data.toString())
                    }
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
                修改员工信息
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
            <input type="hidden" id="id" name="id" value="${employee.id}">
            <div class="input-group">
                <span class="input-group-addon" >姓名</span>
                <input id="name" type="text" class="form-control" value="${employee.name}" name="name" placeholder="请输入姓名" minlength="2" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" >性别</span>
                <select id="sex" class="form-control" name="sex" aria-describedby="basic-addon1">
                    <option value="男">男</option>
                    <option value="女">女</option>
                    <option selected><c:if test="${employee.sex == 1}">
                        <c:out value="男"/>
                    </c:if>
                        <c:if test="${employee.sex == 0}">
                            <c:out value="女"/>
                        </c:if></option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >部门</span>
                <input id="depart" type="text" class="form-control" value="${employee.depart}" name="depart" placeholder="请输入所属部门" minlength="1" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon">电话</span>
                <input id="phone" type="text" class="form-control" value="${employee.phone}" name="phone" placeholder="请输入联系方式" minlength="11" maxlength="11" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <input type="button" class="form-control" value="提交" onclick="add()" aria-describedby="basic-addon1">
            </div>
        </form>
    </div>
</div>
</body>
</html>
