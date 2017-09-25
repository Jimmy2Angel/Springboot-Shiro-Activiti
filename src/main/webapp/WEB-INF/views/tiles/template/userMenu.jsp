<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/18
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="${ctx}/layui/css/layui.css">
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <nav>
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a id="user_a" href="${ctx}/user#role" onclick="">用户管理</a></li>
                <li class="layui-nav-item"><a id="role_a" onclick="showRoleList()">角色管理</a></li>
                <li class="layui-nav-item"><a id="permission_a" onclick="showPermissionList()">权限管理</a></li>
            </ul>
        </nav>
    </div>
</div>