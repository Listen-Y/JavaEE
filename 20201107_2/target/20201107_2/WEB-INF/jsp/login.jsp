<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Title</title>
</head>

<h1>登录页面</h1>
<hr>

<body>
<form action="${pageContext.request.contextPath}/user/login/2" method="post">
    用户名：<label>
    <input type="text" name="username" required>${username}
</label> <br>
    密码：<label>
    <input type="password" name="password" required>${password}
</label> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>