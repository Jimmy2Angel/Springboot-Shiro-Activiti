<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/18
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="layui-header">
    <div class="layui-logo" id="index">S S A</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a href="${ctx}/user#user">用户管理</a></li>
        <li class="layui-nav-item"><a id="process_item">流程管理</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="${ctx}/img/2.png" class="layui-nav-img">
                ${currentUser.username}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${ctx}/logout">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
