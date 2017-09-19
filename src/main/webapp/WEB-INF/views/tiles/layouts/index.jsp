<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/6
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <title><tiles:insertAttribute name="title" /> </title>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header>

    <section id="sidemenu">
        <tiles:insertAttribute name="menu" />
    </section>

    <section id="site-content">
        <tiles:insertAttribute name="body" />
    </section>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div class="lay_right" style="text-align: center;">
            <table id="table" lay-filter="table_tool"></table>
            <div id="page"></div>
            <div id="index_content">
                <span style="font-size: 36px">SSA</span>
            </div>
        </div>
    </div>
</div>
</body>

<script src="${ctx}/layui/layui.js"></script>
<script src="${ctx}/js/index.js"></script>
<script src="${ctx}/js/user.js"></script>
<script src="${ctx}/js/process.js"></script>
<script type="text/html" id="barDemo">
</script>
</html>
