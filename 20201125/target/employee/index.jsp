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
    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>首页</title>



    <link rel="stylesheet" href="./assets/css/amazeui.min.css">
    <link rel="stylesheet" href="./assets/css/app.css">
    <script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
    <script src="./assets/js/amazeui.ie8polyfill.min.js"></script>
    <script src="./assets/js/amazeui.min.js"></script>
    <script src="./assets/js/app.js"></script>

    <script>
        function login(){
            $.ajax({
                url:"${pageContext.request.contextPath}/login",
                type: "POST",
                data:{"name":$("#name").val(),"password":$("#pwd").val()},
                success:function (data) {
                    if (data==="OK"){
                        window.location.href = '${pageContext.request.contextPath}/success';
                    } else {
                            alert(data.toString())
                    }
                }
            });
        }
        $(function () {

        })
    </script>

</head>
<body>
<header>
</header>

<div class="log">
    <div class="am-g">
        <div class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
            <h1 class="log-title am-animation-slide-top">管理员登录</h1>
            <br>
            <div class="am-form" id="log-form">
                <div class="am-input-group am-animation-slide-left log-animation-delay">
                    <input id="name" type="text" class="am-form-field am-radius log-input" placeholder="管理员账号" minlength="5" required>
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <div class="am-input-group am-animation-slide-left log-animation-delay">
                    <input id="pwd"  type="password" class="am-form-field am-radius log-input" placeholder="密码" minlength="6" required>
                    <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
                </div>
                <br>
                <button class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay" onclick="login()">登 录</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>