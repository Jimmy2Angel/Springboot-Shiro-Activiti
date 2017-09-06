var $, form, layer, table, laypage;
layui.use(['jquery','form','layer', 'laypage'], function () {
    $ = layui.$, form = layui.form, layer = layui.layer, table = layui.table, laypage = layui.laypage;

    $(function () {
        $("#user_item").bind('click', function(){
           layui.each($(".layui-nav-tree").find("li"), function () {
               this.remove();
           });
           var html = '<li class="layui-nav-item layui-this"><a id="user_list">用户列表</a></li>\n' +
                      '<li class="layui-nav-item"><a id="permission_manage">权限管理</a></li>';
           $(".layui-nav-tree").append(html);
           showUserList();
        });

        $("#process_item").bind('click', function(){
            layui.each($(".layui-nav-tree").find("li"), function () {
                this.remove();
            });
            var html = '<li class="layui-nav-item layui-this"><a href="">流程定义</a></li>\n' +
                '<li class="layui-nav-item"><a href="">流程部署</a></li>';
            $(".layui-nav-tree").append(html);
        });

        $("#user_list").bind('click', showUserList);
    });
});

//用户列表展示
function showUserList() {
    $(".layui-body").find("div").remove();
    var html = '<table class="layui-table" lay-data="{height:332, url:\'/demo/table/user/\', page:true, id:\'idTest\'}" lay-filter="demo">\n' +
        '  <thead>\n' +
        '    <tr>\n' +
        '      <th lay-data="{field:\'id\', width:80, sort: true, fixed: true}">ID</th>\n' +
        '      <th lay-data="{field:\'username\', width:80}">用户名</th>\n' +
        '      <th lay-data="{fixed: \'right\', width:160, align:\'center\', toolbar: \'#barDemo\'}"></th>\n' +
        '    </tr>\n' +
        '  </thead>\n' +
        '</table>'+
        '<script type="text/html" id="barDemo">\n' +
        '  <a class="layui-btn layui-btn-primary layui-btn-mini" lay-event="detail">查看</a>\n' +
        '  <a class="layui-btn layui-btn-mini" lay-event="edit">编辑</a>\n' +
        '  <a class="layui-btn layui-btn-danger layui-btn-mini" lay-event="del">删除</a>\n' +
        '</script>';
    $(".layui-body").append(html);
    // getUserByPage(initNum);
}

var initNum = '1';
//填充用户列表数据
function getUserByPage(pageNum){
    console.log("111");

    $.getJSON('${ctx}/user/getByPage', {
        pageNum: pageNum //向服务端传的参数
    }, function (res) {
        var data = res.data;
        console.log("111");
        initNum = pageNum;  //当前页码存到全局变量中
        // var myObject = JSON.parse(data);
        //自定义样式
        laypage.render({
            elem: 'page'
            , count: res.count
            , theme: '#1E9FFF'
            , curr: pageNum
            , jump: function (obj, first) {
                if (!first) {
                    getUserByPage(obj.curr);
                }
            }
        });

        table.render({
            elem: '.layui-table' //指定原始表格元素选择器（推荐id选择器）
            /*, height: 450 //容器高度
             ,width: 650*/
            , data: data
            , cols: [[
                {field: 'title', title: '消息标题', width: 180, sort: false}
                , {field: 'sendPersonName', title: '发送人', width: 170, sort: false}
                , {field: 'receivePersonName', title: '接收人', width: 170, sort: false}
                , {field: 'sendTime', title: '发送时间', width: 170, sort: false}
                , {field: 'state', title: '状态', width: 80, sort: false}
                , {fixed: 'right', title: '操作', width: 73, toolbar: '#barDemo'}
            ]] //设置表头
            //,…… //更多参数参考右侧目录：基本参数选项
        });
    });
}
