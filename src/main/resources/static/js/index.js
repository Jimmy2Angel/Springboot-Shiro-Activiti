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

        var navi = path.substring(path.lastIndexOf("/")+1)
        $("#"+navi+"_a").parent().addClass("layui-this");
        //调整地址栏地址，使前进、后退按钮能使用
        switch(navi){
            case "user":
                showUserList();
                break;
            case "role":
                showRoleList();
                break;
            case "permission":
                showPermissionList();
                break;
            case "model":
                showModelList();
                break;
        }
    });

});

