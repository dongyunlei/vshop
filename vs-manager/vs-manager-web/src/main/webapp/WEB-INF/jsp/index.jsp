<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-11-9 0009
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--导入easyUI样式表--%>
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" href="js/jquery-easyui-1.5/themes/icon.css">
    <%--导入jQuery文件--%>
    <script type="text/javascript" src="js/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
<div style="height: 70px;padding-left: 10px" data-options="region:'north'">
    <h2>商城后台管理系统</h2>
</div>
<div title="系统菜单" style="width: 200px;" data-options="region:'west'">
    <div id="menu" class="easyui-accordion">
        <div title="商品管理" data-options="iconCls:'icon-tip'" style="padding: 10px 0;">
            <ul class="easyui-tree">
                <li data-options="attributes:{'href':'item-add'}">新增商品</li>
                <li data-options="attributes:{'href':'item-list'}">查询商品</li>
                <li data-options="attributes:{'href':'item-param'}">规格参数</li>
            </ul>
        </div>
        <div title="网站内容管理" data-options="iconCls:'icon-tip'" style="padding: 10px 0;">
            <ul class="easyui-tree">
                <li>内容分类管理</li>
                <li>内容管理</li>
            </ul>
        </div>
        <div title="索引库管理" data-options="iconCls:'icon-tip'" style="padding: 10px 0;">
            <ul class="easyui-tree">
                <li>solr索引库管理</li>
            </ul>
        </div>
    </div>
</div>
<div data-options="region:'center'" style="background:#eee;">
    <div id="tab" class="easyui-tabs" data-options="fit:true">
        <div title="欢迎页面" style="padding: 20px">
            <h1>欢迎光临后台管理系统</h1>
        </div>

    </div>
</div>
<div data-options="region:'south'" style="padding: 5px">系统版本:v2.0</div>

<script type="text/javascript" src="js/common.js"></script>
<script>
    vshop.registerMenuEvent();
</script>
</body>
</html>
