<%@ page import="indi.baojie.demo.activiti.utils.ProcessDefinitionCache" %><%--
  Created by IntelliJ IDEA.
  User: 锐
  Date: 2017/4/1
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
            <dt class="selected"><i class="Hui-iconfont">&#xe60d;</i>我的办件<i
                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd style="display: block;">
                <ul>
                    <li class="current"><a href=""
                                           title="领导批示督查">领导批示督查</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i><%--<a href="${pageContext.request.contextPath }/admin/index.do">首页</a><span class="c-gray en">&gt;</span>--%> 督办登记
        <span class="c-gray en">&gt;</span> 领导批示办件<a class="btn btn-success radius r"
                                                     style="line-height:1.6em;margin-top:3px"
                                                     href="javascript:location.reload();" title="刷新"><i
                class="Hui-iconfont">&#xe68f;</i></a></nav>
    <div class="Hui-article">
        <article class="cl pd-20">

            <div class="text-c">

            </div>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <%-- <span class="l"><a href="javascript:;"
                                    onclick="member_add('新增办件','${pageContext.request.contextPath }/show_add.do','','')"
                                    class="btn btn-primary "><i
                         class="Hui-iconfont">&#xe600;</i> 新增办件</a>  <a href="javascript:;" onclick="datadel()" class="btn btn-danger "><i
                         class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>  &lt;%&ndash;<a href="javascript:;" onclick="exportPerson()" class="btn btn-secondary  "><i
                         class="Hui-iconfont">&#xe644;</i> 导出用户</a> <a href="javascript:;" onclick="importPerson()" class="btn btn-secondary  "><i
                         class="Hui-iconfont">&#xe645;</i> 导入用户</a> <a href="javascript:;" onclick="signList()" class="btn btn-success "><i
                         class="Hui-iconfont">&#xe667;</i> 批量签到</a>&ndash;%&gt;</span>--%>

            <div id="tab_demo" class="HuiTab">
                <div class="tabBar clearfix"><span>我的待办</span><span>我的已办</span></div>
                <!-- 我的待办 -->
                <div class="tabCon">
                    <div class="mt-20">
                        <table class="table table-border table-bordered table-hover table-bg table-sort">
                            <thead>
                            <tr class="text-c">
                                <th width="25"><input type="checkbox" name="" value=""></th>
                                <th style="display:none;" width="80">ID</th>
                                <th width="10%">编号</th>
                                <th width="10%">办件标题</th>
                                <th width="10%">类型</th>
                                <th width="10%">类别</th>
                                <th width="10%">创建时间</th>
                                <th width="10%">截止时间</th>
                                <th width="10%">当前节点</th>
                                <td width="10%">当前状态</td>
                                <th width="10%">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${departMatter}" var="matter">
                                <c:set var="pdid" value="${matter.processInstance.processDefinitionId }"/>
                                <c:set var="activityId" value="${matter.processInstance.activityId }"/>
                                <tr class="text-c">
                                    <td><input type="checkbox" value="${matter.id}" name="id"></td>
                                    <td style="display:none;">${matter.id}</td>
                                    <td>${matter.serviceCode}</td>
                                    <td><a onclick="detail('${matter.title}',${matter.id},${matter.task.id})">${matter.title}</a></td>
                                    <td>${matter.matterType.name}</td>
                                    <td>${matter.matterCategory.name}</td>
                                    <td>${matter.regTime}</td>
                                    <td>${matter.deadline}</td>
                                    <td><a class="trace" pid="${matter.processInstance.id }" pdid="${matter.processInstance.processDefinitionId}"  <%--onclick=getPic("${p.id}")--%>>
                                            ${matter.task.name}
                                    </a></td>
                                    <td><span
                                            class="label <c:if test="${matter.localState eq '已超期'}">label-danger</c:if>   <c:if test="${matter.localState eq '办理中'}">label-success </c:if>   <c:if test="${matter.localState eq '即将超期'}">label-warning</c:if> radius">${matter.localState}</span>
                                    </td>
                                    <td><a class="btn btn-primary" onclick="detail('${matter.title}',${matter.id},'${matter.task.id}')">上报</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- 我的已办 -->
                <div class="tabCon">
                    <div class="mt-20">
                        <table class="table table-border table-bordered table-hover table-bg table-sort">
                            <thead>
                            <tr class="text-c">
                                <th width="25"><input type="checkbox" name="" value=""></th>
                                <th style="display:none;" width="80">ID</th>
                                <th width="10%">编号</th>
                                <th width="10%">办件标题</th>
                                <th width="10%">类型</th>
                                <th width="10%">类别</th>
                                <th width="10%">创建时间</th>
                                <th width="10%">截止时间</th>
                                <th width="10%">当前节点</th>
                                <td width="10%">当前状态</td>
                                <th width="10%">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${hisMatterList}" var="matter">
                                <c:set var="pdid" value="${matter.processInstance.processDefinitionId }"/>
                                <c:set var="activityId" value="${matter.processInstance.activityId }"/>
                                <tr class="text-c">
                                    <td><input type="checkbox" value="${matter.id}" name="id"></td>
                                    <td style="display:none;">${matter.id}</td>
                                    <td>${matter.serviceCode}</td>
                                    <td><a onclick="detail('${matter.title}',${matter.id},'')">${matter.title}</a></td>
                                    <td>${matter.matterType.name}</td>
                                    <td>${matter.matterCategory.name}</td>
                                    <td>${matter.regTime}</td>
                                    <td>${matter.deadline}</td>
                                    <c:if test="${matter.typeId==1}">
                                    <td> 已上报</td>
                                    <td><span class="label  radius">已上报</span>
                                    </td>
                                    <td><a class="btn btn-default" onclick="detail('${matter.title}',${matter.id},'${matter.task.id}')">已上报</a></td>
                                    </c:if>
                                    <c:if test="${matter.typeId==2}">
                                        <td> 已签收</td>
                                        <td><span class="label  radius">已签收</span>
                                        </td>
                                        <td><a class="btn btn-default" onclick="detail('${matter.title}',${matter.id},'${matter.task.id}')">已签收</a></td>
                                    </c:if>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </article>
    </div>
</section>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"
        src="/user/assets/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="/user/assets/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="/user/assets/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="/user/assets/H-ui/static/h-ui.admin/js/H-ui.admin.page.js"></script>
<!--/_footer /作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript"
        src="/user/assets/H-ui/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="/user/assets/H-ui/lib/laypage/1.2/laypage.js"></script>
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
        $.Huitab("#tab_demo .tabBar span","#tab_demo .tabCon","current","click","0")
    });

    /*用户-添加*/
    function member_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*上报*/
    function department(title, url, w, h) {
        layer_show(title, 'matter_department.jsp', '1000', '800');
    }


    /*签收*/
    function signup(obj, id, remark) {
        /* var mes="";
         if(!(remark==null||remark=='')){
         mes = '备注:'+remark+'<br/>确认要签收吗？';

         }else{

         }*/
        var mes = '确认要签收吗？';
        layer.confirm(mes, function (index) {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/signup.do',
                data: 'matterId=' + id,
                dataType: 'json',
                success: function (data) {
                    if (data.success) {
                        location.reload();
                    } else {
                        layer.msg('系统繁忙，请稍后再试!', {icon: 2, time: 3000});
                    }

                },
                error: function (data) {
                    console.log(data.msg);
                }
            });
        });
    }

    /**
     * 上报页面
     * @param title
     * @param id
     */
    function detail(title, id,taskId) {
        //iframe层-父子操作
        layer.open({
            title: '<strong>' + title + '</strong>',
            type: 2,
            area: ['50%', '90%'], //宽高
            fixed: false, //不固定
            maxmin: true,
            content: 'department_show.do?id=' + id+"&taskId="+taskId
        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
