//角色列表展示
function showRoleList() {
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