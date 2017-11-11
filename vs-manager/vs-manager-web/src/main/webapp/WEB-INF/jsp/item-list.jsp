<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-11-9 0009
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table id="dg"></table>
<script>
    $("#dg").datagrid({
        url: 'items',
        striped: true,
        fit: true,
        pagination: true,
        rownumbers:true,
        pageSize:20,
        pageList:[20,40,80],
        columns: [[
            {field: 'ck', checkbox:true},
            {field: 'id', title: '商品ID', width: '100px'},
            {field: 'title', title: 'title', width: '100px'},
            {field: 'sellPoint', title: '卖点', width: '100px'},
            {field: 'price', title: '商品价格', width: '100px'},
            {field: 'num', title: '商品数量', width: '100px'},
            {field: 'barcode', title: '商品ID', width: '100px'},
            {field: 'catName', title: '商品分类', width: '100px'},
            {field: 'status', title: '商品状态', width: '100px'},
            {field: 'created', title: '创建时间', width: '100px'},
            {field: 'updated', title: '更新时间', width: '100px'}
        ]]
    });
</script>

