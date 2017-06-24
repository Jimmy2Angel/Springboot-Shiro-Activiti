<%--
  Created by IntelliJ IDEA.
  User: Lollipop
  Date: 2017/6/24
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <dd style="display: none;">
                <ul>
                    <li class="current"><a href="${ctx}/index" title="领导批示督查">领导批示督查</a></li>
                </ul>
            </dd>
            <dt><i class="Hui-iconfont">&#xe60d;</i> 流程管理<i
                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd style="display: block;">
                <ul>
                    <li class="current"><a href="">模型工作区</a></li>
                    <li><a href="${ctx}/activiti/process/list">流程定义及部署管理</a></li>
                    <li><a href="${ctx}/activiti/processinstance/running">运行中流程</a></li>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<!--/_menu 作为公共模版分离出去-->

<section class="Hui-article-box">
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i>流程管理
        <span class="c-gray en">&gt;</span> 模型列表<a class="btn btn-success radius r"
                                                     style="line-height:1.6em;margin-top:3px"
                                                     href="javascript:location.reload();" title="刷新">
            <i class="Hui-iconfont">&#xe68f;</i></a>

    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">

            <div class="text-c">

            </div>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="l"><a  href="javascript:;"
                                    id="create" class="btn btn-primary "><i
                        class="Hui-iconfont">&#xe600;</i> 创建模型</a>  <a href="javascript:;" onclick="datadel()" class="btn btn-danger "><i
                        class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                </span> <span class="r">共有数据：<strong>${modelList.size()}</strong> 条</span>
            </div>
            <div class="mt-20">
                <table class="table table-border table-bordered table-hover table-bg table-sort">
                    <thead>
                    <tr class="text-c">
                        <th width="2%"><input type="checkbox" name="" value=""></th>
                        <th style="display:none;" width="80">ID</th>
                        <th width="10%">ID</th>
                        <th width="10%">KEY</th>
                        <th width="15%">Name</th>
                        <th width="5%">Version</th>
                        <th width="10%">创建时间</th>
                        <th width="10%">最后更新时间</th>
                        <th width="20%">元数据</th>
                        <th width="20%">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${modelList}" var="model">
                        <tr class="text-c">
                            <td><input type="checkbox" value="" name="id"></td>
                            <td style="display:none;">1</td>
                            <td>${model.id}</td>
                            <td>${model.key}</td>
                            <td>${model.name}</td>
                            <td>${model.version}</td>

                            <td><fmt:formatDate value="${model.createTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                            <td><fmt:formatDate value="${model.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm"/></td>
                            <td>${model.metaInfo}</td>
                            <td>
                                <a href="${ctx}/modeler.html?modelId=${model.id}" target="_blank">编辑</a>
                                <a href="${pageContext.request.contextPath }/workflow/model/deploy/${model.id}.do">部署</a>
                                导出(<a href="${pageContext.request.contextPath }/workflow/model/export/${model.id}/bpmn.do" target="_blank">BPMN</a>
                                |&nbsp;<a href="${pageContext.request.contextPath }/workflow/model/export/${model.id}/json.do" target="_blank">JSON</a>
                                |&nbsp;<a href="javascript:;" onclick='showSvgTip()'>SVG</a>)
                                <a href="${ctx}/activiti/model/delete/${model.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </article>
    </div>
</section>
<div id="createModelTemplate" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content radius">
            <div class="modal-header">
                创建模型
            </div>
            <div class="modal-body">
                <form id="modelForm" action="${ctx}/activiti/model/create" target="_blank" method="post">
                    <table>
                        <tr>
                            <td>名称：</td>
                            <td>
                                <input id="name" name="name" type="text" />
                            </td>
                        </tr>
                        <tr>
                            <td>KEY：</td>
                            <td>
                                <input id="key" name="key" type="text" />
                            </td>
                        </tr>
                        <tr>
                            <td>描述：</td>
                            <td>
                                <textarea id="description" name="description" style="width:300px;height: 50px;"></textarea>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" onclick="subAddModel()">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript"
        src="${ctx}/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/H-ui/static/h-ui/js/H-ui.js"></script>
<script type="text/javascript"
        src="${ctx}/H-ui/static/h-ui.admin/js/H-ui.admin.page.js"></script>

<!--/_footer /作为公共模版分离出去-->

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

        $('#create').button({
            icons: {
                primary: 'ui-icon-plus'
            }
        }).click(function() {
            $('#createModelTemplate').modal("show");
        });
    });

    function subAddModel(){
        if (!$('#name').val()) {
            alert('请填写名称！');
            $('#name').focus();
            return;
        }
        setTimeout(function() {
            location.reload();
        }, 1000);
        $('#modelForm').submit();
    }

    /*上报*/
    function department(title, url, w, h) {
        layer_show(title, 'matter_department.jsp', '1000', '800');
    }

    /*进度查询 */
    function schedule(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*批示*/
    function instruct(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*办件编辑*/
    function matter_edit(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*交办*/
    function handleOver(obj, id,remark) {
        /*if(!(remark==null||remark=='')){
         mes = '备注:'+remark+'<br/>确认要交办吗？';

         }else{

         }*/
        var mes = '确认要交办吗？';
        layer.confirm(mes, function (index) {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/handleOver.do',
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

    /*签收*/
    function signup(obj, id,remark) {
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

    function signList(){
        var obj = document.getElementsByName('id');  //选择所有name="'test'"的对象，返回数组
        //取到对象数组后，我们来循环检测它是不是被选中
        var ids = '';
        var leng = 0;
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                ids += obj[i].value + ',';
                leng = leng + 1;
            }  //如果选中，将value添加到变量s中

        }
        if (ids.length == 0) {
            layer.msg('尚未选择任何记录!', {icon: 3, time: 3000});
        } else {
            layer.confirm('确认要批量签到这' + leng + '条记录吗？', function (index) {
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath }/admin/person/signList.do',
                    data: 'ids=' + ids ,
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
    }

    /*用户-启用*/
    function member_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="Hui-iconfont">&#xe631;</i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6, time: 1000});
        });
    }
    /*用户-编辑*/
    function member_edit(title, url, w, h) {
        //iframe层-父子操作
        layer.open({
            title:'<strong>'+title+'</strong>',
            type: 2,
            area: ['1000', '800'],
            fixed: false, //不固定
            maxmin: true,
            content: 'matter_detail.jsp'
        });
        /* layer_show(title, url, w, h);*/
    }
    /*密码-修改*/
    function change_password(title, url, id, w, h) {
        layer_show(title, url, w, h);
    }

    /*批量删除*/
    function datadel() {
        var obj = document.getElementsByName('id');  //选择所有name="'test'"的对象，返回数组
        //取到对象数组后，我们来循环检测它是不是被选中
        var ids = '';
        var leng = 0;
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                ids += obj[i].value + ',';
                leng = leng + 1;
            }  //如果选中，将value添加到变量s中

        }
        if (ids.length == 0) {
            layer.msg('尚未选择任何记录!', {icon: 3, time: 3000});
        } else {
            layer.confirm('确认要删除这' + leng + '条记录吗？', function (index) {
                $.ajax({
                    type: 'POST',
                    url: '${pageContext.request.contextPath }/delete.do',
                    data: 'ids=' + ids,
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            layer.msg('删除成功!', {icon: 1, time: 1000});
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
    }



    /*导出*/
    function  exportPerson() {
        var obj = document.getElementsByName('id');  //选择所有name="'test'"的对象，返回数组
        //取到对象数组后，我们来循环检测它是不是被选中
        var ids = '';
        var leng = 0;
        for (var i = 0; i < obj.length; i++) {
            if (obj[i].checked) {
                ids += obj[i].value + ',';
                leng = leng + 1;
            }  //如果选中，将value添加到变量s中

        }
        location.href="${pageContext.request.contextPath }/admin/person/export.do?confId=${conf.id}&ids="+ids+"&confName=${conf.theme}";
    }

    /*导入*/
    function importPerson(){
        layer_show("批量导入", "${pageContext.request.contextPath }/admin/person/import_show.do?confId=${conf.id}","800" ,"200" );
    }



    /*用户-删除*/
    function member_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/admin/person/delete.do',
                data: 'ids=' + id,
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                    if (data.success) {

                        layer.msg('删除成功!', {icon: 1, time: 1000});
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
     * 重置表单
     */
    function  resetForm(){
        $("#activity").find("option[value='']").attr("selected",true);
        $("#hotel").find("option[value='']").attr("selected",true);
        $("#room").empty();
        $("#room").append("<option value=''>请选择</option>");
    }


    function detail(title,id){
        //iframe层-父子操作
        layer.open({
            title:'<strong>'+title+'</strong>',
            type: 2,
            area: ['700px', '530px'],
            fixed: false, //不固定
            maxmin: true,
            content: 'detail.do?id='+id
        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
