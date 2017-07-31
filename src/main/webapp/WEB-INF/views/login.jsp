<%--
  Created by IntelliJ IDEA.
  User: Lollipop
  Date: 2017/6/19
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <![endif]-->
    <link href="${ctx}/H-ui/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/H-ui/static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/H-ui/static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <title>后台登录</title>
    <style type="text/css">
        label.error {
            display: block;
            position: static;
        }

    </style>
</head>
<body>
<div class="header"></div>
<div class="loginWraper">
    <div id="loginform" class="loginBox">
        <form class="form form-horizontal" id="loginform1">
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
                <div class="formControls col-xs-8">
                    <input id="username" name="username" type="text" placeholder="登录名" class="input-text size-L">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
                <div class="formControls col-xs-8">
                    <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
                </div>
            </div>
            <%--<div class="row cl">--%>
                <%--<div class="formControls col-xs-8 col-xs-offset-3">--%>
                    <%--<input class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">--%>
                    <%--<img src="images/VerifyCode.aspx.png">--%>
                    <%--<a id="kanbuq" href="javascript:;">看不清，换一张</a>--%>
                <%--</div>--%>
            <%--</div>--%>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <label for="online">
                        <input type="checkbox" name="rememberMe" id="online" value="true">
                        记住我</label>
                </div>
            </div>
            <div class="row cl">
                <div class="formControls col-xs-8 col-xs-offset-3">
                    <input name="" type="submit" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
                    <input name="" type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
                </div>
            </div>
        </form>


    </div>
</div>
<div class="footer"></div>

<script type="text/javascript" src="${ctx}/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script>
    $(function(){
        var message = "${message}";
        console.log(message);
        if(message!=""){
            alert(message);
           // layer.msg(message,{icon:1,time:1000});
        }

        $("#loginform1").validate({
            rules:{
                username:{
                    required:true,
                    minlength:2,
                    maxlength:16
                },
                password:{
                    required:true,
                },

            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                $(form).ajaxSubmit({
                    dataType: 'json',
                    type: 'post', // 提交方式 get/post
                    url: '${ctx}/${url}', // 需要提交的 url
                    data: {
                        'rememberMe' : $('#rememberMe').is(':checked')
                    },
                    success: function(res) { // data 保存提交后返回的数据，一般为 json 数据
                        // 此处可对 data 作相关处理
                        //var index = parent.layer.getFrameIndex(window.name);
                        //parent.$('#ref').click();
                        if(res.success){
                            top.location = "${ctx}/matter/index";
                        }else{
                            parent.layer.msg(res.message,{icon:2,time:3000});
                        }
                    }
                });
            }
        });
    });
</script>
</body>
</html>