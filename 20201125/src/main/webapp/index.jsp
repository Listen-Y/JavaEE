<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/25
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript"></script>
    <style>
        #body{
            background-image: url("images/x.jpg");
            background-size:100% 100%;
            background-attachment: fixed;
        }
    </style>

    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>


    <script>
        function login(){
            $.ajax({
                url:"${pageContext.request.contextPath}/login",
                type: "POST",
                data:{"name":$("#user").val(),"password":$("#password").val()},
                success:function (data) {
                    if (data==="OK"){
                        window.location.href = '${pageContext.request.contextPath}/success';
                    } else {
                        $("#message").text(data.toString());
                        $("#user").val("");
                        $("#password").val("");
                    }
                }
            });
        }
        $(function () {

        })
    </script>

</head>
<body id="body">
<div class="container" style="width: 400px;margin-top: 110px;background-color: rgba(255,255,255,0.8)">
    <h3 style="text-align: center;">用户登录</h3>
    <div class="form-group" >
        <label for="user">用户名：</label>
        <input type="text" name="username" class="form-control" id="user" placeholder="请输入用户名"/>
    </div>

    <div class="form-group">
        <label for="password">密码：</label>
        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
    </div>

    <hr/>
    <div class="form-group" style="text-align: center;">
        <button style="width: 200px;height: 40px" id="submit" onclick="login()" class="btn btn btn-primary">登录</button>
    </div>
    <!-- 出错显示的信息框 -->
    <div class="alert alert-warning alert-dismissible" role="alert">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong id="message">您尚未登录, 请登录!</strong>
    </div>
</div>
</body>
</html>