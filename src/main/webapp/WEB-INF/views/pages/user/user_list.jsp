<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/20
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="user">
    <tiles:putAttribute name="body">
        <div class="layui-body">
            <div style="margin-top: 10px;margin-bottom: 10px; margin-left: 10px;">
                <a class="layui-btn layui-btn-normal" style="margin-top: 6px;" onclick="user_add()"><i class="layui-icon">&#xe654;</i>添加用户</a>
            </div>
            <!-- 内容主体区域 -->
            <div class="lay_right" style="text-align: center;">
                <table id="table" lay-filter="table_tool"></table>
                <div id="page"></div>
                <div id="index_content">

                </div>
            </div>
        </div>
    </tiles:putAttribute>
    <%--&lt;%&ndash;--%>
    <tiles:putAttribute name="tilesScriptJq">
        <script type="text/javascript">
            $(document).ready(function() {
                selectThisTab(hash);
            });
        </script>
    </tiles:putAttribute>
    <tiles:putAttribute name="tilesScript">
        <script src="${ctx}/js/user.js"></script>
    </tiles:putAttribute>
    <%--&ndash;%&gt;--%>
</tiles:insertDefinition>
<script type="text/html" id="barDemo">
</script>