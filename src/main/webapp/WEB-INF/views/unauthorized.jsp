<%--
  Created by IntelliJ IDEA.
  User: Lollipop
  Date: 2017/6/20
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>未授权页面</title>
    <style>
        *{ margin:0; padding:0; font-family:Microsoft YaHei; font-size:14px;}
        .red{ color:#F00;}
        .blue{ color:#03F;}
        .fw600{ font-weight:600;}
        .fs18{ font-size:18px;}
        .plr2{ padding:0 2px;}

        .errorW{ width:600px; height:500px; margin:0 auto;}
        .errorW .img{ width:200px; height:168px; margin:0 auto; padding:80px 0 20px;}
        .errorW h1{ width:600px; height:32px; line-height:32px; text-align:center; padding:10px 0; font-size:20px; color:#444; font-weight:600;}
        .errorW p{ width:600px; height:32px; line-height:32px; text-align:center; padding:5px 0;}
        .errorW .p_red a{ color:#f00; font-size:18px; font-weight:600; padding:0 2px; text-decoration:none;}
        .errorW .p_red a:hover{ color:#C00; font-size:18px; font-weight:600; padding:0 2px; text-decoration:none;}
        .errorW .p_blue a{ color:#09F; font-size:18px; font-weight:600; padding:0 2px; text-decoration:none;}
        .errorW .p_blue a:hover{ color:#00F; font-size:18px; font-weight:600; padding:0 2px; text-decoration:none;}
    </style>
</head>

<body>
<div class="errorW">
    <div class="img">
        <img src="${ctx}/H-ui/sj.gif" width="200" height="168" />
    </div>
    <h1>您没有权限访问该页面</h1>


</div>

</body>
</html>
