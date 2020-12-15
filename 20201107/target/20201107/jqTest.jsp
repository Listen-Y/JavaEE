<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/7
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <script>
        function a() {
            $.post({
                url:"./t2",
                data:{'name':$("#username").val()},
                success: function (data, status) {
                    alert(data + status)
                }
            })
        }
    </script>
</head>
<body>

<input type="text" id="username" value="" onblur="a()">


</body>
</html>
