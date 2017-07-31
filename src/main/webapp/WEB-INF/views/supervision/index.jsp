<%--
  Created by IntelliJ IDEA.
  User: Lollipop
  Date: 2017/6/23
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <!--[if IE 6]>
    <script type="text/javascript" src="http://lib.h-ui.net/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script><![endif]-->
    <!--/meta 作为公共模版分离出去-->

    <title></title>
</head>
<body>
<!--_header 作为公共模版分离出去-->
<jsp:include page="/head"/>
<!--/_header 作为公共模版分离出去-->

<!--_menu 作为公共模版分离出去-->
<aside class="Hui-aside">

    <div class="menu_dropdown bk_2">
        <dl id="menu-member">
            <dt class="selected"><i class="Hui-iconfont">&#xe60d;</i> 督办督查<i
                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd style="display: block;">
                <ul>
                    <li class="current"><a href="" title="重点工作督查">重点工作督查</a></li>
                </ul>
            </dd>
            <dt><i class="Hui-iconfont">&#xe60d;</i> 流程管理<i
                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd style="display: none;">
                <ul>
                    <li><a href="${ctx}/activiti/model/list">模型工作区</a></li>
                    <li><a href="${ctx}/workflow/process_list">流程定义及部署管理</a></li>
                    <li><a href="${ctx}/workflow/processinstance/running">运行中流程</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i>督办督查
        <span class="c-gray en">&gt;</span> 重点工作督查<a class="btn btn-success radius r"
                                                     style="line-height:1.6em;margin-top:3px"
                                                     href="javascript:location.reload();" title="刷新">
            <i class="Hui-iconfont">&#xe68f;</i></a>

    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">
            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="l"><a href="javascript:;"
                                   onclick="matter_add('新增报告','${ctx}/matter/add','','')"
                                   class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 新增报告</a>
                    <a href="javascript:;" onclick="datadel()" class="btn btn-danger "><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                        &nbsp</span>

                <div id="tab_demo" class="HuiTab">
                    <div class="tabBar clearfix"><span>我的待办</span><span>机构在办</span><span>已办办件</span><span>全部办件</span></div>
                    <!-- 我的待办 -->
                    <div class="tabCon">
                        <div class="mt-20">
                            <table class="table table-border table-bordered table-hover table-bg table-sort">
                                <thead>
                                <tr class="text-c">
                                    <th width="25"><input type="checkbox" name="" value=""></th>
                                    <th style="display:none;" width="80">ID</th>
                                    <th width="100">编号</th>
                                    <th width="200">办件标题</th>
                                    <th width="40">类型</th>
                                    <th width="90">类别</th>
                                    <th width="150">创建时间</th>
                                    <th width="150">截止时间</th>
                                    <th width="70">当前节点</th>
                                    <th width="70">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- 机构在办 -->
                    <div class="tabCon">
                        <div class="mt-20">
                            <table class="table table-border table-bordered table-hover table-bg table-sort">
                                <thead>
                                <tr class="text-c">
                                    <th width="25"><input type="checkbox" name="" value=""></th>
                                    <th style="display:none;" width="80">ID</th>
                                    <th width="100">编号</th>
                                    <th width="200">办件标题</th>
                                    <th width="40">类型</th>
                                    <th width="90">类别</th>
                                    <th width="150">创建时间</th>
                                    <th width="150">截止时间</th>
                                    <th width="70">当前节点</th>
                                    <th width="70">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- 已办办件 -->
                    <div class="tabCon">
                        <div class="mt-20">
                            <table class="table table-border table-bordered table-hover table-bg table-sort">
                                <thead>
                                <tr class="text-c">
                                    <th width="25"><input type="checkbox" name="" value=""></th>
                                    <th style="display:none;" width="80">ID</th>
                                    <th width="100">编号</th>
                                    <th width="200">办件标题</th>
                                    <th width="40">类型</th>
                                    <th width="90">类别</th>
                                    <th width="150">创建时间</th>
                                    <th width="150">截止时间</th>
                                    <th width="70">当前节点</th>
                                    <th width="70">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- 全部办件 -->
                    <div class="tabCon">
                        <div class="mt-20">
                            <table class="table table-border table-bordered table-hover table-bg table-sort">
                                <thead>
                                <tr class="text-c">
                                    <th width="25"><input type="checkbox" name="" value=""></th>
                                    <th style="display:none;" width="80">ID</th>
                                    <th width="100">编号</th>
                                    <th width="200">办件标题</th>
                                    <th width="40">类型</th>
                                    <th width="90">类别</th>
                                    <th width="150">创建时间</th>
                                    <th width="150">截止时间</th>
                                    <th width="70">当前状态</th>
                                    <th width="70">操作</th>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </article>
    </div>
</section>
<script src="${ctx}/myStatic/js/common/jquery-1.8.3.js" type="text/javascript"></script>
<script src="${ctx}/myStatic/js/common/plugins/jui/jquery-ui-1.9.2.min.js" type="text/javascript"></script>

<script src="${ctx}/myStatic/js/common/plugins/jui/extends/timepicker/jquery-ui-timepicker-addon.js" type="text/javascript"></script>
<script src="${ctx}/myStatic/js/common/plugins/jui/extends/i18n/jquery-ui-date_time-picker-zh-CN.js" type="text/javascript"></script>
<script src="${ctx}/myStatic/js/common/plugins/qtip/jquery.qtip.pack.js" type="text/javascript"></script>
<script src="${ctx}/myStatic/js/common/plugins/html/jquery.outerhtml.js" type="text/javascript"></script>


<script type="text/javascript" src="${ctx}/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="${ctx}/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    $(function () {
        $('.table-sort').dataTable({
            "aaSorting": [[2, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0, 5]}// 制定列不参与排序
            ]
        });
        $.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","0");
    });

    /*新增办件*/
    function matter_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
