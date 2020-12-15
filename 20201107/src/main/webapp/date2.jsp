<%--
  Created by IntelliJ IDEA.
  User: Huawei
  Date: 2020/11/7
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步加载数据</title>

    <%--导包--%>
    <script src="https://s3.pstatp.com/cdn/expire-1-M/jquery/3.3.1/jquery.min.js"></script>

    <%--实现--%>
    <script>

        /*只要点击按钮就执行方法*/
        $(function () {
            $("#button").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/t3",
                    success: function (date) {
                        let html = "";
                        for (let i = 0; i <date.length; i++) {
                            html += "<tr>" +
                                "<td>" + date[i].id + "</td>" +
                                "<td>" + date[i].name + "</td>" +
                                "<td>" + date[i].password + "</td>"
                                + "<\tr>"
                        }
                        $("#body").html(html);
                    }
                })

            })
        })

    </script>

</head>
<body>


<input type="button" id="button" value="加载数据">
<table style="width: 80%">
    <thead>
    <th>编号</th>
    <th>名字</th>
    <th>密码</th>
    </thead>
    <tbody id="body">

    </tbody>
</table>

</body>
</html>
