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
    <title>添加员工</title>
    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function add(){
            $.ajax({
                url:"${pageContext.request.contextPath}/add",
                type: "POST",
                data:{"name":$("#name").val(),"sex":$("#sex").val(),"depart":$("#depart").val(),"phone":$("#phone").val()},
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
<body>
<div class="container">
    <div class="row clearfix">
        <div>
            <div class="input-group">
                <span class="input-group-addon" >姓名</span>
                <input id="name" type="text" class="form-control" name="name" placeholder="请输入姓名" minlength="2" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" >性别</span>
                <select id="sex" class="form-control" name="sex" aria-describedby="basic-addon1">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
            <div class="input-group">
                <span class="input-group-addon" >部门</span>
                <input id="depart" type="text" class="form-control" name="depart" placeholder="请输入所属部门" minlength="1" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon">电话</span>
                <input id="phone" type="text" class="form-control" name="phone" placeholder="请输入联系方式" minlength="11" maxlength="11" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <input type="button" class="form-control" value="提交" onclick="add()" aria-describedby="basic-addon1">
            </div>
        </div>
    </div>
</div>
</body>
</html>
