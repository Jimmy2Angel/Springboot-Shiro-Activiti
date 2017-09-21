var path = document.location.pathname;
var ctx = path.substring(0,path.substr(1).indexOf("/")+1);

var $, laytpl, form, layer, table, laypage, element;
layui.use(['laytpl', 'form','layer', 'table', 'laypage', 'element'], function () {
    $ = layui.$, laytpl = layer.laytpl, form = layui.form, layer = layui.layer, table = layui.table, laypage = layui.laypage, element = layui.element;

    $(function () {
        $("#index").bind('click', function(){
            location.hash = "";
            location.href = ctx+'/index';
        });

        var hash;
        hash=(!window.location.hash)?"":window.location.hash;
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
                showPermissionList();
                break;
            case "model":
                showModelList();
                break;
        }
    });

});

