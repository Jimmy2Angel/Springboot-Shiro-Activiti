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
<%@ page import="indi.baojie.demo.activiti.utils.ProcessDefinitionCache" %>
<%@page import="org.activiti.engine.RepositoryService" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
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
<%
    RepositoryService repositoryService = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext()).getBean(org.activiti.engine.RepositoryService.class);
    ProcessDefinitionCache.setRepositoryService(repositoryService);
%>
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
                    <li class="current"><a href="" title="领导批示督查">领导批示督查</a></li>
                </ul>
            </dd>
            <dt><i class="Hui-iconfont">&#xe60d;</i> 流程管理<i
                    class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd style="display: none;">
                <ul>
                    <li><a href="${ctx}/activiti/model/list">模型工作区</a></li>
                    <li><a href="${ctx}/workflow/process_list.do">流程定义及部署管理</a></li>
                    <li><a href="${ctx}/workflow/processinstance/running.do">运行中流程</a></li>
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
        <span class="c-gray en">&gt;</span> 领导批示件<a class="btn btn-success radius r"
                                                     style="line-height:1.6em;margin-top:3px"
                                                     href="javascript:location.reload();" title="刷新">
            <i class="Hui-iconfont">&#xe68f;</i></a>

    </nav>
    <div class="Hui-article">
        <article class="cl pd-20">

            <div class="text-c">

            </div>

            <div class="cl pd-5 bg-1 bk-gray mt-20">
                <span class="l"><a href="javascript:;"
                                   onclick="add('新增办件','${ctx}/add','','')"
                                   class="btn btn-primary "><i class="Hui-iconfont">&#xe600;</i> 新增办件</a>
                    <a href="javascript:;" onclick="datadel()" class="btn btn-danger "><i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a>
                </span>
                <span class="r">共有数据：<strong>${matters.size()}</strong> 条</span>
            </div>
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
                    <c:forEach items="${matters}" var="matter">
                        <c:set var="pdid" value="${matter.processInstance.processDefinitionId }"/>
                        <c:set var="activityId" value="${matter.processInstance.activityId }"/>
                        <tr class="text-c">
                            <td><input type="checkbox" value="${matter.id}" name="id"></td>
                            <td style="display:none;">${matter.id}</td>
                            <td>${matter.serviceCode}</td>
                            <td><a onclick="member_add('编辑','show_modify.do?id=${matter.id}','','')">${matter.title}</a></td>
                            <td>${matter.matterType.name}</td>
                            <td>${matter.matterCategory.name}</td>
                            <td>${matter.regTime}</td>
                            <td>${matter.deadline}</td>
                            <td><a class="trace" pid="${matter.processInstance.id }" pdid="${matter.processInstance.processDefinitionId}" title="点击查看流程图" >
                                ${matter.task.name}
                               <%-- <%=ProcessDefinitionCache.getActivityName(pageContext.getAttribute("pdid").toString(), org.apache.commons.lang3.ObjectUtils.toString(pageContext.getAttribute("activityId")))==null?"${matter.task.name}":"${matter.task.name}" %>--%>
                            </a></td>
                            <td><a class="btn btn-primary" onclick="member_add('编辑','show_modify.do?id=${matter.id}','','')">编辑</a> <a class="btn badge-success" onclick="edit_sub('${matter.id}','${matter.task.id}')">提交</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
    });

    /*新增办件页面显示*/
    function add(title, url, w, h) {
        layer_show(title, url, w, h);
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



    /*督查室提交至领导审核*/
    function edit_sub(id, taskId, deId) {
        /*if(!(remark==null||remark=='')){
         mes = '备注:'+remark+'<br/>确认要交办吗？';

         }else{

         }*/
        var mes = '确认要提交至领导审核吗？';
        layer.confirm(mes, function (index) {
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath }/edit_sub.do',
                data: {matterId: id, taskId: taskId},
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

  /*  下方是查看办理流程js*/
    var ctx = "/supervision";
    $(function () {


        $('#create').button({
            icons: {
                primary: 'ui-icon-plus'
            }
        }).click(function () {
            $('#createModelTemplate').modal("show");
        });

        // 跟踪
        $('.trace').click(graphTrace);
    });

    function subAddModel() {
        if (!$('#name').val()) {
            alert('请填写名称！');
            $('#name').focus();
            return;
        }
        setTimeout(function () {
            location.reload();
        }, 1000);
        $('#modelForm').submit();
    }


    function graphTrace(options) {

        var _defaults = {
            srcEle: this,
            pid: $(this).attr('pid'),
            pdid: $(this).attr('pdid')
        };
        var opts = $.extend(true, _defaults, options);

        // 处理使用js跟踪当前节点坐标错乱问题
        $('#changeImg').live('click', function () {
            $('#workflowTraceDialog').dialog('close');
            if ($('#imgDialog').length > 0) {
                $('#imgDialog').remove();
            }
            $('<div/>', {
                'id': 'imgDialog',
                title: '<button id="diagram-viewer"></button>',
                html: "<img src='" + ctx + '/workflow/process/trace/auto/' + opts.pid + "' />"
            }).appendTo('article').dialog({
                modal: true,
                resizable: false,
                dragable: false,
                width: document.documentElement.clientWidth * 0.95,
                height: document.documentElement.clientHeight * 0.95
            });
        });

        /*
         用官方开发的Diagram-Viewer跟踪
         */
        $('#diagram-viewer').live('click', function () {
            $('#workflowTraceDialog').dialog('close');

            if ($('#imgDialog').length > 0) {
                $('#imgDialog').remove();
            }

            var url = ctx + '/diagram-viewer/index.html?processDefinitionId=' + opts.pdid + '&processInstanceId=' + opts.pid;

            $('<div/>', {
                'id': 'imgDialog',
                title: '此对话框显示的图片是由引擎自动生成的，并用红色标记当前的节点',
                html: '<iframe src="' + url + '" width="100%" height="' + document.documentElement.clientHeight * 0.90 + '" />'
            }).appendTo('body').dialog({
                modal: true,
                resizable: false,
                dragable: false,
                width: document.documentElement.clientWidth * 0.95,
                height: document.documentElement.clientHeight * 0.95
            });
        });

        // 获取图片资源
        var imageUrl = ctx + "/workflow/resource/process_instance.do?pid=" + opts.pid + "&type=image";
        $.getJSON(ctx + '/workflow/process/trace.do?pid=' + opts.pid, function (infos) {

            var positionHtml = "";

            // 生成图片
            var varsArray = new Array();
            $.each(infos, function (i, v) {
                var $positionDiv = $('<div/>', {
                    'class': 'activity-attr'
                }).css({
                    position: 'absolute',
                    left: (v.x - 1),
                    top: (v.y - 1),
                    width: (v.width - 2),
                    height: (v.height - 2),
                    backgroundColor: 'black',
                    opacity: 0,
                    zIndex: $.fn.qtip.zindex - 1
                });

                // 节点边框
                var $border = $('<div/>', {
                    'class': 'activity-attr-border'
                }).css({
                    position: 'absolute',
                    left: (v.x - 1),
                    top: (v.y - 1),
                    width: (v.width - 4),
                    height: (v.height - 3),
                    zIndex: $.fn.qtip.zindex - 2
                });

                if (v.currentActiviti) {
                    $border.addClass('ui-corner-all-12').css({
                        border: '3px solid red'
                    });
                }


                positionHtml += $positionDiv.outerHTML() + $border.outerHTML();
                varsArray[varsArray.length] = v.vars;
            });

            if ($('#workflowTraceDialog').length == 0) {
                $('<div/>', {
                    id: 'workflowTraceDialog',
                    title: '<button id="changeImg"></button><button id="diagram-viewer"></button>',
                    html: "<div><img src='" + imageUrl + "' style='position:absolute; left:0px; top:0px;' />" +
                    "<div id='processImageBorder'>" +
                    positionHtml +
                    "</div>" +
                    "</div>"
                }).appendTo('article');
            } else {
                $('#workflowTraceDialog img').attr('src', imageUrl);
                $('#workflowTraceDialog #processImageBorder').html(positionHtml);
            }

            // 设置每个节点的data
            $('#workflowTraceDialog .activity-attr').each(function (i, v) {
                $(this).data('vars', varsArray[i]);
            });

            // 打开对话框
            $('#workflowTraceDialog').dialog({
                modal: false,
                resizable: false,
                dragable: false,
                open: function () {
                    $('#workflowTraceDialog').dialog('option', 'title', '<button id="changeImg" style="display:none;"></button><button id="diagram-viewer"></button>');
                    $('#workflowTraceDialog').css('padding', '0.2em');
                    $('#workflowTraceDialog .ui-accordion-content').css('padding', '0.2em').height($('#workflowTraceDialog').height() - 75);

                    // 此处用于显示每个节点的信息，如果不需要可以删除
                    $('.activity-attr').qtip({
                        content: function () {
                            var vars = $(this).data('vars');
                            var tipContent = "<table class='need-border'>";
                            $.each(vars, function (varKey, varValue) {
                                if (varValue) {
                                    tipContent += "<tr><td class='label'>" + varKey + "</td><td>" + varValue + "<td/></tr>";
                                }
                            });
                            tipContent += "</table>";
                            return tipContent;
                        },
                        position: {
                            at: 'bottom left',
                            adjust: {
                                x: 3
                            }
                        }
                    });
                    // end qtip
                },
                close: function () {
                    $('#workflowTraceDialog').remove();
                },
                width: document.documentElement.clientWidth * 0.95,
                height: document.documentElement.clientHeight * 0.95
            });

            /*layer.open({
             type: 1,
             shade: false,
             title: false, //不显示标题
             content: $('#workflowTraceDialog'), //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
             cancel: function(){
             layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', {time: 5000, icon:6});
             }
             });*/


            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['1600', '800'], //宽高
                content: $('#workflowTraceDialog') //iframe的url
            });

            $(".layui-layer-shade").hide();

        });

    }

    /*  上方是查看办理流程js*/


    /**
     * 签收
     * @param taskId
     */
    function assignee(taskId){
        $.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath }/assignee.do',
            data: 'taskId=' + taskId,
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
    }


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
