<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/5/9
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="javascript" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="favicon.ico">
    <link rel="Shortcut Icon" href="favicon.ico"/>

    <!--[if lt IE 9]>
    <script type="text/javascript" src="/user/assets/H-ui/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/user/assets/H-ui/lib/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" type="text/css"
          href="/user/assets/H-ui/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="/user/assets/H-ui/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="/user/assets/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href="/user/assets/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css"
          href="/user/assets/H-ui/static/h-ui.admin/css/style.css"/>

    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>编辑</title>
</head>
<body>
<div class="panel panel-default">
    <%--<div class="panel-header">测试办件</div>--%>
    <div class="panel-body text-l">
        <span><p><strong>编&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</strong>${matter.serviceCode}</p></span>
        <span><p><strong>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</strong>${matter.matterType.name}</p></span>
        <span><p><strong>类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</strong>${matter.matterCategory.name}</p></span>
        <span><p><strong>承办单位：</strong>${matter.organizerNames}</p></span>
        <span><p><strong>截止时间：</strong>${matter.deadline}</p></span>
        <span><strong>内容概要:</strong></span>
        <p>
            <textarea class="textarea" style="max-height: 300px;resize: none;" readonly> ${matter.summary}</textarea>
        </p>
        <c:if test="${not empty matter.matterAttachments}">
        <span><p><strong>附件：</strong>
            <%--<c:forEach items="${matter.matterAttachments}" var="matterAttachment">--%>
                <%--<a href="${pageContext.request.contextPath}/download.do?matterAttachmentId=${matterAttachment.id}&type=1">${matterAttachment.name}</a>--%>
            <%--</c:forEach>--%>

            <%--目前只显示最新的一个附件--%>
            <a href="${pageContext.request.contextPath}/download.do?matterAttachmentId=${matter.matterAttachments[0].id}&type=1">${matter.matterAttachments[0].name}</a>
        </p>
        </span>
        </c:if>
    </div>
</div>


<c:if test="${matter.typeId eq 1}">
    <div class="panel panel-default">
            <%--<div class="panel-header">测试办件</div>--%>
        <form action="${pageContext.request.contextPath}/${url}" enctype="multipart/form-data" method="post" id="handle">
            <input type="hidden" name="id" value="${transactionResult.id}">
            <input type="hidden" name="taskId" value="${taskId}">
            <input type="hidden" name="matterId" value="${matter.id}">
        <div class="panel-body text-l">
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3" style="width: 22%">上报结果：</label>
                <div class="formControls col-xs-8 col-sm-9" style="width: 78%;">
                    <textarea name="detail" id="detail"  class="textarea" placeholder="" maxlength="255">${transactionResult.detail}</textarea>
                </div>
            </div>
            <div class="row cl" style="padding-top: 10px;">
                <label class="form-label col-xs-4 col-sm-3" style="width: 22%">附件：</label>
                <%--<a href="${pageContext.request.contextPath}/download.do?resultAttachmentId=${resultAttachment.id}&type=2">${resultAttachment.name}</a>--%>
                <div class="formControls col-xs-8 col-sm-9">
                <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" value="${resultAttachment.name}" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary  upload-btn "><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" id="file" multiple name="file" class="input-file" value="">
				</span>
                    <a class="btn btn-primary " onclick="clearInputFile()"> 清空</a>
                </div>
            </div>


            <c:if test="${type ne '2'}">
            <div class="row cl" style="padding-top: 10px;">
            <span class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-success size-L" id="save" type="submit"  value="&nbsp;&nbsp;上报&nbsp;&nbsp;">
                <input class="btn btn-default  size-L" type="button" onClick="closeIframe();"value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
            </span>
            </div>
            </c:if>
        </form>
    </div>
</c:if>
<script type="text/javascript"
        src="/user/assets/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/user/assets/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/user/assets/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="/user/assets/H-ui/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<script type="text/javascript" src="$/user/assets/jquery-textarea/autosize.min.js"></script>

<script type="text/javascript"
        src="/user/assets/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
        src="/user/assets/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
        src="/user/assets/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/javascript">
    autosize(document.querySelectorAll('textarea'));
    $(function () {
        <c:if test="${type eq '2'}">

        $('textarea').attr("disabled",true);

        </c:if>


        $("#handle").validate({
            rules: {
                detail: {
                    required: true
                }

            },
            messages:{
                detail:{
                    required:"上报内容不能为空"
                }
            },
            onkeyup: false,
            focusCleanup: false,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    type: 'post', // 提交方式 get/post
                    dataType: 'json',
                    // url: 'your url', // 需要提交的 url
                    success: function (res) { // data 保存提交后返回的数据，一般为 json 数据
                        // 此处可对 data 作相关处理
                        var index = parent.layer.getFrameIndex(window.name);
                        if (res.success) {
                            // parent.layer.msg('编辑成功!', {icon: 1, time: 3000});
                            parent.location.reload();
                            parent.layer.close(index);
                        } else {
                            parent.layer.msg(res.message, {icon: 2, time: 3000});
                        }
                    },
                    error:function(data){
                        parent.layer.msg("附件太大，请修改后重试！", {icon: 2, time: 2000});
                    }

                });


            }
        });
    });


    function closeIframe() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }

    /**
     * 清空file
     */
    function  clearInputFile() {
        $("#uploadfile").val('');
        var file = $("#file");
        file.after(file.clone().val(""));
        file.remove();

    }

</script>
</body>
</html>
