var $, form, layer, table, laypage;
layui.use(['jquery','form','layer', 'table', 'laypage'], function () {
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
    //展示已知数据
    table.render({
        elem: '#demo'
        ,data: [{
            "id": "10001"
            ,"username": "杜甫"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "116"
            ,"ip": "192.168.0.8"
            ,"logins": "108"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10002"
            ,"username": "李白"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "12"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
            ,"LAY_CHECKED": true
        }, {
            "id": "10003"
            ,"username": "王勃"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "65"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10004"
            ,"username": "贤心"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "666"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10005"
            ,"username": "贤心"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "86"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10006"
            ,"username": "贤心"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "12"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10007"
            ,"username": "贤心"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "16"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }, {
            "id": "10008"
            ,"username": "贤心"
            ,"email": "xianxin@layui.com"
            ,"sex": "男"
            ,"city": "浙江杭州"
            ,"sign": "人生恰似一场修行"
            ,"experience": "106"
            ,"ip": "192.168.0.8"
            ,"logins": "106"
            ,"joinTime": "2016-10-14"
        }]
        ,height: 272
        ,cols: [[ //标题栏
            {checkbox: true, LAY_CHECKED: true} //默认全选
            ,{field: 'id', title: 'ID', width: 80, sort: true}
            ,{field: 'username', title: '用户名', width: 120}
            ,{field: 'email', title: '邮箱', width: 150}
            ,{field: 'sign', title: '签名', width: 150}
            ,{field: 'sex', title: '性别', width: 80}
            ,{field: 'city', title: '城市', width: 100}
            ,{field: 'experience', title: '积分', width: 80, sort: true}
        ]]
        ,skin: 'row' //表格风格
        ,even: true
        ,page: true //是否显示分页
        ,limits: [5, 7, 10]
        ,limit: 5 //每页默认显示的数量
    });
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
