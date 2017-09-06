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
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
    <link rel="stylesheet" href="${ctx}/css/login.css">

    <title>SSA－登录</title>
</head>
<body>

    <div class="loginWraper">
        <div class="loginBox">
            <form id="login_form" class="layui-form layui-form-pane loginForm">
                <div class="layui-form-item">
                    <label class="layui-form-label layui-col-md2">用户名</label>
                    <div class=" layui-col-md7">
                        <input type="text" name="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label layui-col-md2">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <div class="layui-col-md7">
                        <input type="password" name="password" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">登录</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<script src="${ctx}/layui/layui.js"></script>
<script>
    var form, $, layer;
    layui.use(['form', 'jquery', 'layer'], function(){
        form = layui.form, $ = layui.$, layer = layui.layer;

        //监听提交
        form.on('submit(formDemo)', function(data){
            if (!formValidate()) {
                return false;
            }
            $.ajax({
                data: data.field,
                url: '${ctx}/login',
                type: 'post',
                dataType: 'JSON',
                success: function(res) {
                    if (res.success) {
                        window.location.href = '${ctx}/index';
                    } else {
                        layer.msg(res.message,{area: ['auto', 'auto'],
                            offset: '100px'});
                        $("input[name='username']").select();
                    }
                },
                error: function(errorMsg) {
                    console.log(errorMsg);
                }
            });
            return false;
        });
    });
    
    function formValidate() {
        if ($("input[name='username']").val()=='') {
            layer.msg("用户名不能为空！",{area: ['auto', 'auto'],
                offset: '100px'});
            $("input[name='username']").focus();
            return false;
        }if ($("input[name='password']").val()=='') {
            layer.msg('密码不能为空！', {area: ['auto', 'auto'], offset: '100px'});
            $("input[name='password']").focus();
            return false;
        }
        return true;
    }
</script>
</body>
</html>
