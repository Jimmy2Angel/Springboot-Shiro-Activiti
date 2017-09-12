<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/8
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <title>添加用户</title>
</head>
<body>
<form class="layui-form layui-form-pane" style="padding: 5px;margin-left: 110px;" >
    <input type="hidden" name="id" value="${user.id}"/>
    <input type="hidden" name="password" value="${user.password}"/>
    <div class="layui-form-item">
        <label class="layui-form-label">登陆账号</label>
        <div class="layui-input-inline">
            <input type="text" name="username" lay-verify="username" value="${user.username}"   autocomplete="off" placeholder="请输入登陆账号" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">默认密码“111111”</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">复选框</label>
        <div class="layui-input-block">
            <c:forEach items="${roles}" var="role" varStatus="i">
                <input type="checkbox" name="name" title="${role.name}"
                    <c:forEach items="${user.roles}" var="userRole">
                        <c:if test="${userRole.id == role.id}">checked</c:if>
                    </c:forEach>
                >
                <c:if test="${i.count%2 == 0}"><br/></c:if>
            </c:forEach>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <c:if test="${user eq null}">
            <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="save">保存</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </c:if>
            <c:if test="${user ne null}">
                <button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="save">保存</button>
            </c:if>
        </div>
    </div>
</form>

<script src="${ctx}/layui/layui.js"></script>
<script>
    layui.use(['form','layer'], function(){
        var form = layui.form, layer = layui.layer, $ = layui.$;
        form.verify({
            username: function(value){
                if(value.length < 1){
                    return '用户名称不能为空';
                }
            }
        });

        //监听保存提交
        form.on('submit(save)', function(data){
            $.ajax({
                url:'${ctx}/user/add',
                data:data.field,
                type:'post',
                dataType:'json',
                success: function (res) {
                    if(res.success){
                        layer.msg(res.message);
                        setTimeout(function(){
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        },2000);
                    }else {
                        layer.alert(res.message);
                    }
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
