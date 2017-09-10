var initNum = '1', currentType = "";
//用户列表展示
function showUserList() {
    getByPage('user', initNum);
    table.on('tool(table_tool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if (layEvent === 'open') { //查看
            user_show(data.id);
        }else if(layEvent === 'role_assigned'){
            role_assigned(data.id);
        }
    });
}
//角色列表展示
function showRoleList() {
    console.log("111");
    getByPage('role', initNum);
    table.on('tool(table_tool)', function (obj) { //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        if (layEvent === 'open') { //查看
            user_show(data.id);
        }else if(layEvent === 'permission_assigned'){
            role_assigned(data.id);
        }
    });
}
//权限列表展示
function showPermissionList() {
    getByPage('permission', initNum);
}


//填充列表数据
var barDemo = "", url ="", cols = [], html = "";
function getByPage(type,pageNum){
    if ($(".layui-body>div").length > 1) {
        $(".layui-body>div:eq(0)").remove();
        $(".lay_right")[0].innerHTML="";
        //TODO ...
        $("#barDemo").empty();
    }

    currentType = type;
    if ($("#barDemo>a").length == 0) {
        if (type == 'user') {
            url = ctx + '/user/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini  layui-btn" style="text-align: center;" lay-event="open">查看</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-normal" style="text-align: center;" lay-event="role_assigned">赋予角色</a>';
            cols.push([
                {field: 'id', title: 'ID', width: 300, sort: false}
                , {field: 'username', title: '用户名', width: 300, sort: false}
                , {field: 'password', title: '密码', width: 300, sort: false}
                , {fixed: 'right', title: '操作', width: 350, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="user_add()"><i class="layui-icon">&#xe611;</i>添加用户</a>\n' +
                '                        <span class="search-span" style="float: right;margin-right: 5px;margin-bottom: 10px;margin-top: 10px;">\n' +
                '                        按用户名搜索：\n' +
                '                            <div class="layui-inline">\n' +
                '                                <input type="text" class="layui-input" name="username" id="username">\n' +
                '                            </div>\n' +
                '                            <button class="layui-btn" data-type="reload" onclick="getByPage('+type+',\'1\')">搜索</button>\n' +
                '                    </span>\n' +
                '                    </div>';
        } else if (type == 'role') {
            url = ctx + '/user/role/getByPage';
            barDemo = '<a class="layui-btn layui-btn-mini  layui-btn" style="text-align: center;" lay-event="open">查看</a>\n' +
                '<a class="layui-btn layui-btn-mini  layui-btn-normal" style="text-align: center;" lay-event="permission_assigned">赋予权限</a>';
            cols.push([
                {field: 'id', title: 'ID', width: 400, sort: false}
                , {field: 'username', title: '角色名', width: 400, sort: false}
                , {fixed: 'right', title: '操作', width: 450, toolbar: '#barDemo'}
            ]);
            html = '<div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">\n' +
                '                        <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="role_add()"><i class="layui-icon">&#xe611;</i>添加角色</a>\n' +
                '                        <span class="search-span" style="float: right;margin-right: 5px;margin-bottom: 10px;margin-top: 10px;">\n' +
                '                        按角色名搜索：\n' +
                '                            <div class="layui-inline">\n' +
                '                                <input type="text" class="layui-input" name="name" id="name">\n' +
                '                            </div>\n' +
                '                            <button class="layui-btn" data-type="reload" onclick="getByPage('+type+',\'1\')">搜索</button>\n' +
                '                    </span>\n' +
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
        initNum = pageNum;  //当前页码存到全局变量中
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
        if ($(".layui-body>div").length == 1) {
            $(".layui-body").prepend(html);
        }
    });
}

function user_add() {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '200px'], //宽高
        content: ctx+'/user/add'
    });
}
function user_show(userId) {
    layer.open({
        type: 2,
        skin: 'layui-layer-rim', //加上边框
        area: ['600px', '200px'], //宽高
        content: ctx+'/user/'+userId,
        end: function() {
            getByPage(currentType, initNum);
        }
    });
}
function role_assigned(userId) {
    console.log(userId);
}