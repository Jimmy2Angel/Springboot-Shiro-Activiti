

var currentNum2 = localStorage.getItem("pageNum2")==null?'1':localStorage.getItem("pageNum2"), currentType2 = "";
//模型列表展示
function showModelList() {
    location.hash = "#model";
    putData('model', currentNum2);
    table.on('tool(table_tool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'edit') { //编辑
            window.open(ctx + '/modeler.html?modelId='+data.id, "_blank");
        } else if (layEvent === 'deploy') {
            window.location.href = ctx + '/workflow/model/deploy/' + data.id;
        } else if (layEvent === 'delete') {
            window.location.href = ctx + '/workflow/model/delete/' + data.id;
        }
    });
}

function putData(type, pageNum) {
    var barDemo = "", url ="", cols = [], html = "";
    if ($(".layui-body>div").length > 1) {
        $(".layui-body>div:eq(0)").remove();
        laypage.render({elem: 'page'});
        table.render({elem: '#table',data: null, cols: null});
        $("#barDemo").empty();
    }

    currentType = type;
    if ($("#barDemo>a").length == 0) {
        if (type == 'model') {
            url = ctx + '/workflow/model/list';
            barDemo = '<a class="layui-btn layui-btn-mini  layui-btn" style="text-align: center;" lay-event="edit">编辑</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-normal" style="text-align: center;" lay-event="deploy">部署</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-warm" style="text-align: center;" lay-event="delete">删除</a>';
            cols.push([
                {field: 'id', title: 'ID', width:250, sort: false}
                , {field: 'key', title: 'KEY', width: 300, sort: false}
                , {field: 'name', title: 'NAME', width: 300, sort: false}
                , {field: 'version', title: 'VERSION', width: 300, sort: false}
                , {field: 'createTime', title: '创建时间', width: 300, sort: false}
                , {field: 'metaInfo', title: '元数据', width: 300, sort: false}
                , {fixed: 'right', title: '操作', width: 380, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="model_add()"><i class="layui-icon">&#xe611;</i>创建模型</a>\n' +
                '                    </div>';
        } else if (type == 'role') {
            url = ctx + '/user/role/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini  layui-btn" style="text-align: center;" lay-event="open">查看</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-normal" style="text-align: center;" lay-event="permission_assigned">赋予权限</a>';
            cols.push([
                {field: 'id', title: 'ID', width: 400, sort: false}
                , {field: 'name', title: '角色名', width: 400, sort: false}
                , {fixed: 'right', title: '操作', width: 435, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="role_add()"><i class="layui-icon">&#xe611;</i>添加角色</a>\n' +
                '                    </div>';

        } else if (type == 'permission') {
            url = ctx + '/user/permission/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini  layui-btn" style="text-align: center;" lay-event="open">查看</a>';
        }
        $("#barDemo").append(barDemo);
    }
    $.getJSON( url, {
        pageNum: pageNum //向服务端传的参数
    }, function (res) {
        var data = res.list;
        currentNum = pageNum;  //当前页码存到全局变量中
        localStorage.setItem("pageNum",pageNum);
        // var myObject = JSON.parse(data);
        //自定义样式
        laypage.render({
            elem: 'page'
            , count: res.total
            , theme: '#1E9FFF'
            , curr: res.pageNum
            , layout: [ 'prev', 'page', 'next', 'skip']
            , groups: 3 //连续显示分页数
        });

        table.render({
            elem: '#table' //指定原始表格元素选择器（推荐id选择器）
            /*, height: 450 //容器高度
             ,width: 650*/
            , data: data
            , cols: cols //设置表头
            //,…… //更多参数参考右侧目录：基本参数选项
        });
        $(".layui-body").prepend(html);
    });
}