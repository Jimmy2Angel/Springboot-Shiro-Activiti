<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lollipop
  Date: 2017/6/23
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<script type="text/javascript">
    function changeMyselfPassword(title,url,id,w,h){
        layer_show(title,url,w,h);
    }
</script>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl">
            <a class="logo navbar-logo f-l mr-10 hidden-xs" href="${ctx}/index">督导督查系统</a>
            <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="${ctx}/index"></a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs"  href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <%--<li>督查部门</li>--%>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A">${username} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onClick="changeMyselfPassword('修改密码','${ctx}','10001','600','270')">密码修改</a></li>
                            <li>
                                <a href="${ctx}/logout">退出</a>
                            </li>
                        </ul>
                    </li>
                     <li id="Hui-msg">
                         <a href="#" title="消息">
                             <span class="badge badge-danger">1</span>
                             <i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a>
                     </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover">
                        <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li>
                                <a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
                            </li>
                            <li>
                                <a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
                            </li>
                            <li>
                                <a href="javascript:;" data-val="green" title="绿色">绿色</a>
                            </li>
                            <li>
                                <a href="javascript:;" data-val="red" title="红色">红色</a>
                            </li>
                            <li>
                                <a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
                            </li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
</body>
</html>
