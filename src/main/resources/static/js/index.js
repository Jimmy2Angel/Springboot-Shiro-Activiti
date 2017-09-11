var path = document.location.pathname;
var ctx = path.substring(0,path.substr(1).indexOf("/")+1);

var $, laytpl, form, layer, table, laypage, element;
layui.use(['laytpl', 'form','layer', 'table', 'laypage', 'element'], function () {
    $ = layui.$, laytpl = layer.laytpl, form = layui.form, layer = layui.layer, table = layui.table, laypage = layui.laypage, element = layui.element;

    $(function () {
        $("#user_item").bind('click', function(){
            layui.each($(".layui-nav-tree").find("li"), function () {
               this.remove();
            });
            var html = '<li class="layui-nav-item"><a id="user_a" href="javascript:void(0);" onclick="showUserList()">用户管理</a></li>\n' +
                      '<li class="layui-nav-item"><a id="role_a" onclick="showRoleList()">角色管理</a></li>\n' +
                      '<li class="layui-nav-item"><a id="permission_a" onclick="showPermissionList()">权限管理</a></li>';
            $(".layui-nav-tree").append(html);

            var hash;
            hash=(!window.location.hash)?"#user":window.location.hash;
            window.location.hash=hash;
            //调整地址栏地址，使前进、后退按钮能使用
            switch(hash){
                case "#user":
                    showUserList();
                    break;
                case "#role":
                    showRoleList();
                    break;
                case "#permission":
                    showPermissionList()
                    break;
            }
        });

        $("#process_item").bind('click', function(){
            layui.each($(".layui-nav-tree").find("li"), function () {
                this.remove();
            });
            var html = '<li class="layui-nav-item layui-this"><a href="">流程定义</a></li>\n' +
                '<li class="layui-nav-item"><a href="">流程部署</a></li>';
            $(".layui-nav-tree").append(html);
        });

        var hash;
        hash=(!window.location.hash)?"#user":window.location.hash;
        window.location.hash=hash;
        //调整地址栏地址，使前进、后退按钮能使用
        switch(hash){
            case "#user":
                $("#user_item").click();
                break;
            case "#role":
                $("#user_item").click();
                //TODO 这里粗略处理，可能失败，理论上要确保上一个click方法执行完才执行这个click方法
                // setTimeout(function () {
                //     $("#role_a").click();
                // },5);
                break;
            case "#permission":
                $("#user_item").click();
                setTimeout(function () {
                    $("#permission_a").click();
                },5);
                break;
        }
    });

});

