<%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/4/5
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
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
    <script type="text/javascript" src="${ctx}/H-ui/lib/html5shiv.js"></script>
    <script type="text/javascript" src="${ctx}/H-ui/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/static/h-ui.admin/css/style.css"/>

    <link rel="stylesheet" type="text/css"
          href="${ctx}/H-ui/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css"/>
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title>新增办件</title>
</head>
<body>
<article class="cl pd-20">
    <form action="${ctx}/${url}" method="post" class="form form-horizontal" id="form-member-add" enctype="multipart/form-data">
        <input type="hidden" value="${matter.state}" id="state" name="state">
        <input type="hidden" value="${matter.id}" id="id" name="id">
        <input type="hidden" value="${matter.organizerIds}" id="organizerIds" name="organizerIds">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>办件编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${matter.serviceCode}" placeholder="" id="serviceCode" name="serviceCode" maxlength="255">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red"></span>标题：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${matter.title}" placeholder="" id="title" name="title" maxlength="255">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">内容概要：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="summary" id="summary" cols="" rows="" class="textarea" placeholder="" maxlength="4000" style="max-height: 300px;resize: none;" >${matter.summary}</textarea>
            </div>
        </div>

        <c:if test="${not empty event}">

            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3" style="color: red;"><strong>不通过原因：</strong></label>
                <div class="formControls col-xs-8 col-sm-9">
                    <textarea name="summary" id="reason" cols="" rows="" class="textarea" placeholder="" maxlength="4000" style="max-height: 300px;resize: none;" >${event.remark}</textarea>
                </div>
            </div>
        </c:if>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">承办单位：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <c:forEach var="unit" items="${units}">
                    <input name="unitIds" type="checkbox" value="${unit.unitId}"/>${unit.unitName}
                </c:forEach>
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">附件：</label>
            <div class="formControls col-xs-8 col-sm-9"> <span class="btn-upload form-group">
				<input class="input-text upload-url" type="text" name="uploadfile" id="uploadfile" readonly nullmsg="请添加附件！" style="width:200px">
				<a href="javascript:void();" class="btn btn-primary  upload-btn "><i class="Hui-iconfont">&#xe642;</i> 浏览文件</a>
				<input type="file" multiple name="file" class="input-file" value="">
				</span>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="remark" cols="" rows="" class="textarea" placeholder="" maxlength="4000" style="max-height: 300px;resize: none;">${matter.remark}</textarea>
            </div>
        </div>

        <div class="row cl">
            <a class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-success " id="save" type="button" onclick="sub('8');" value="&nbsp;&nbsp;保存&nbsp;&nbsp;">

                <%--<input class="btn btn-primary " type="button" onclick="sub('1');" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">--%>
                <%--<a class="btn btn-default radius"  href="${pageContext.request.contextPath }/download.do?id=${matter.id}">&nbsp;&nbsp;下载测试&nbsp;&nbsp;</a>--%>
                <input class="btn btn-default radius" type="button" onClick="closeIframe();" value="&nbsp;&nbsp;取消&nbsp;&nbsp;">
                </a>
        </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/H-ui/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery.validation/1.14.0/messages_zh.js"></script>


<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>

<script type="text/javascript" src="${ctx}/myStatic/js/common/autosize.min.js"></script>
<script type="text/javascript">

    autosize($("#summary"));

    jQuery(document).ready(function () {  //修改时定时自动提交
        $(function () {
            $("#form-member-add").validate({
                rules: {
                    title: {
                        required: true
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
                                parent.layer.msg('系统繁忙，请稍后再试!', {icon: 2, time: 3000});
                            }
                        }
                    });


                }
            });
        });
    });

    function sub(state) {
        $("#form-member-add").submit();
    }


    function closeIframe() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }


    var setting = {
        data:{//表示tree的数据格式
            simpleData:{
                enable:true,//表示使用简单数据模式
                idKey:"id",//设置之后id为在简单数据模式中的父子节点关联的桥梁
                pidKey:"pId",//设置之后pid为在简单数据模式中的父子节点关联的桥梁和id互相对应
                rootId:"null"//pid为null的表示根节点
            }
        },
        callback: {
            onCheck: zTreeOnClick,
            onAsyncSuccess: zTreeAsyncSuccess
        },
        view:{//表示tree的显示状态
            selectMulti:false//表示禁止多选
        },
        check:{//表示tree的节点在点击时的相关设置
            enable:true,//是否显示radio/checkbox
            chkStyle:"checkbox",//值为checkbox或者radio表示
            chkboxType: { "Y": "ps", "N": "ps" },//表示父子节点的联动效果
            radioType:"level"//设置tree的分组
        },
        async: {
            enable: true,
            type: "post",
            otherParam: ["matterId", "${matter.id}"],
            dataType:"json",
            url: "${ctx}/matter/tree"
        }

    }

    function initTree(){

        $.fn.zTree.init($("#des_school"),setting,null);
    }
    $(function(){
        initTree();

    });


    /**
     * 点击回调事件   -天
     * */
    function zTreeOnClick(event, treeId, treeNode) {

        var treeObj = $.fn.zTree.getZTreeObj("des_school");
        var nodes = treeObj.getCheckedNodes(true);

        var deps = '';
        var depIds ='';
        var b = nodes.length;
        for(var i=0;i<b;i++){
            var node = nodes[i];
            if (!node.isParent){
                deps = deps + "【"+node.name+"】 ";
                depIds = depIds + node.id+',';
            }
        }
        $("#organizerNames").val(deps);
        $("#organizerIds").val(depIds);
    };


    /**
     * 异步获取回调事件
     * @param event
     * @param treeId
     * @param treeNode
     */
    function zTreeAsyncSuccess(event, treeId, treeNode) {

        var treeObj = $.fn.zTree.getZTreeObj("des_school");
        var nodes = treeObj.getCheckedNodes(true);

        var deps = '';
        var depIds ='';
        var b = nodes.length;
        for(var i=0;i<b;i++){
            var node = nodes[i];
            if (!node.isParent){
                deps = deps + "【"+node.name+"】 ";
                depIds = depIds + node.id+',';
            }
            treeObj.checkNode(nodes[i], true, true); //选中子节点后级联勾选父节点
        }
        $("#organizerNames").val(deps);
        $("#organizerIds").val(depIds);
    };


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>