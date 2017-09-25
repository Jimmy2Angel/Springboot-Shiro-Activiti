<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/20
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-body">
    <div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">
        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="permission_add()"><i class="layui-icon">&#xe654;</i>添加权限</a>
    </div>
    <!-- 内容主体区域 -->
    <div class="lay_right" style="text-align: center;">
        <table id="table" lay-filter="table_tool"></table>
        <div id="page"></div>
        <div id="index_content">

        </div>
    </div>
</div>