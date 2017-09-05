<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/5
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">

    <title>SSA－登录</title>
</head>
<body>

<script src="${ctx}/layui/layui.js"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>
</html>
