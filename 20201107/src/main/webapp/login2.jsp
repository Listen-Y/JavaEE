<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/7
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录验证</title>

    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <%--实现--%>
    <script>

        function a1() {
            $.ajax({
                url:"${pageContext.request.contextPath}/t4",
                data:{"username":$("#name").val()},
                success:function (data) {
                    alert(data)
                }
            })
        }

        function a2() {
            $.ajax({
                url:"${pageContext.request.contextPath}/t4",
                data:{"password":$("#pwd").val()},
                success:function (data) {
                    alert(data)
                }
            })
        }

    </script>

</head>
<body>
<p>
    用户名:<input type="text" id="name" onblur="a1()"/>
    <span id="userInfo"></span>
</p>
<p>
     密码:<input type="text" id="pwd" onblur="a2()"/>
    <span id="pwdInfo"></span>
</p>
</body>
</html>
