<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/18
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<div class="layui-header">
    <div class="layui-logo" id="index">S S A</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item"><a id="user_item" href="javascript:;">用户管理</a></li>
        <li class="layui-nav-item"><a id="process_item">流程管理</a></li>
    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item">
            <a href="javascript:;">
                <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                ${user.username}
            </a>
            <dl class="layui-nav-child">
                <dd><a href="${ctx}/logout">退出</a></dd>
            </dl>
        </li>
    </ul>
</div>
