<%--
  Created by IntelliJ IDEA.
  User: lollipop
  Date: 17/9/18
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<link rel="stylesheet" href="${ctx}/layui/css/layui.css">
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <nav>
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item"><a id="model_a" onclick="showModelList()">模型工作区</a></li>
                <li class="layui-nav-item"><a id="process_d_a" onclick="">流程定义及部署</a></li>
                <li class="layui-nav-item"><a id="process_r_a" onclick="">运行中流程</a></li>
            </ul>
        </nav>
    </div>
</div>