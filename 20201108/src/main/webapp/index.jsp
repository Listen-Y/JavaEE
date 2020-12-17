<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/8
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传和下载</title>

    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <script>

        function show() {
            $.ajax({
                url:"${pageContext.request.contextPath}/f4",
                method:"POST",
                success:function (data) {
                    let html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "( " + data[i] + " )"
                    }

                    $("#sp").html(html)
                }
            });
        }

    </script>

</head>
<body>
<p>文件上传</p>
<form action="${pageContext.request.contextPath}/f3" enctype="multipart/form-data" method="post">
    <input type="file" name="file"/>
    <input type="submit" value="上传">
</form>
<p>==============================</p>
<p>文件下载</p>
<input type="button" name="but" value="文件名加载" onclick="show()"> <span id="sp"></span>
<form action="${pageContext.request.contextPath}/f5"  method="post">
<p></p>
    <span>请输入文件下载名字:</span><input type="text" name="filename"/>
    <input type="submit" value="下载">
</form>

</body>
</html>
