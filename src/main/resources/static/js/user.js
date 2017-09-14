var currentNum = localStorage.getItem("pageNum")==null?'1':localStorage.getItem("pageNum"), currentType = "";
//用户列表展示
function showUserList() {
    location.hash = "#user";
    selectThisTab('user');
    getByPage('user', currentNum);
    table.on('tool(table_tool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if (layEvent === 'edit') { //编辑
            user_show(data.id);
        }else if(layEvent === 'delete'){
            user_delete(data.id);
        }
    });
}
//角色列表展示
function showRoleList() {
    location.hash = "#role";
    selectThisTab('role');
    getByPage('role', currentNum);
    table.on('tool(table_tool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if (layEvent === 'edit') { //编辑
            role_show(data.id);
        }else if(layEvent === 'permission_assigned'){
            permission_assigned(data.id);
        }else if (layEvent == 'delete') {
            role_delete(data.id);
        }
    });
}
//权限列表展示
function showPermissionList() {
    location.hash = "#permission";
    getByPage('permission', currentNum);
}


//填充列表数据
function getByPage(type,pageNum){
    var barDemo = "", url ="", cols = [], html = "";
    if ($(".layui-body>div").length > 1) {
        $(".layui-body>div:eq(0)").remove();
        laypage.render({elem: 'page'});
        table.render({elem: '#table',data: null, cols: null});
        $("#barDemo").empty();
    }

    currentType = type;
    if ($("#barDemo>a").length == 0) {
        if (type == 'user') {
            url = ctx + '/user/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini" style="text-align: center;" lay-event="edit">修改</a>\n' +
                    '<a class="layui-btn layui-btn-mini  layui-btn-warm" style="text-align: center;" lay-event="delete">删除</a>';
            cols.push([
                {field: 'id', title: 'ID', width:250, sort: false}
                , {field: 'username', title: '用户名', width: 300, sort: false}
                , {field: 'password', title: '密码', width: 300, sort: false}
                , {fixed: 'right', title: '操作', width: 380, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="user_add()"><i class="layui-icon">&#xe654;</i>添加用户</a>\n' +
                '                    </div>';
        } else if (type == 'role') {
            url = ctx + '/user/role/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini" style="text-align: center;" lay-event="edit">修改</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-warm" style="text-align: center;" lay-event="delete">删除</a>';
            cols.push([
                {field: 'id', title: 'ID', width: 400, sort: false}
                , {field: 'name', title: '角色名', width: 400, sort: false}
                , {fixed: 'right', title: '操作', width: 435, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="role_add()"><i class="layui-icon">&#xe654;</i>添加角色</a>\n' +
                '                    </div>';

        } else if (type == 'permission') {
            url = ctx + '/user/permission/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini" style="text-align: center;" lay-event="edit">修改</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-warm" style="text-align: center;" lay-event="delete">删除</a>';
            cols.push([
                {field: 'id', title: 'ID', width:250, sort: false}
                , {field: 'name', title: '权限名', width: 300, sort: false}
                , {field: 'url', title: 'url', width: 300, sort: false}
                , {fixed: 'right', title: '操作', width: 380, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="permission_add()"><i class="layui-icon">&#xe654;</i>添加权限</a>\n' +
                '                    </div>';
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
            , jump: function (obj, first) {
                if (!first) {
                    getByPage(type,obj.curr);
                }
            }
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

function user_add() {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '400px'], //宽高
        content: ctx+'/user/add'
    });
}
function user_show(userId) {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '400px'], //宽高
        content: ctx+'/user/'+userId,
        end: function() {
            getByPage(currentType, currentNum);
        }
    });
}
//删除用户
function user_delete(userId) {
    layer.confirm('确认要删除该用户吗？',function(index){
        $.ajax({
            type: 'delete',
            dataType:'json',
            url: ctx + '/user/'+userId,
            success:function(data){
                var index = parent.layer.getFrameIndex(window.name);
                if (data.success) {
                    parent.layer.msg(data.message, {icon: 1, time: 2000});
                    setTimeout(function () {
                        parent.location.reload();
                    },2000);
                } else {
                    parent.layer.msg(data.message, {icon: 2, time: 2000});
                }
            },
            error:function(data){
                parent.layer.msg("删除失败，请与管理员联系！", {icon: 2, time: 2000});
            }
        });
    });
}

function role_add() {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '200px'], //宽高
        content: ctx+'/user/role/add'
    });
}
function role_show(roleId) {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '200px'], //宽高
        content: ctx+'/user/role/'+roleId,
        end: function() {
            getByPage(currentType, currentNum);
        }
    });
}

function selectThisTab(tab) {
    if ('user' == tab) {
        $("#user_a").parent().addClass("layui-this");
        $("#role_a").parent().removeClass("layui-this");
        $("#permission_a").parent().removeClass("layui-this");
    } else if ('role' == tab) {
        $("#user_a").parent().removeClass("layui-this");
        $("#role_a").parent().addClass("layui-this");
        $("#permission_a").parent().removeClass("layui-this");
    } else if ('permission' == tab) {
        $("#user_a").parent().removeClass("layui-this");
        $("#role_a").parent().removeClass("layui-this");
        $("#permission_a").parent().addClass("layui-this");
    }
}