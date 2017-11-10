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
            {field: 'id', title: '商品ID', width: '50px'},
            {field: 'title', title: 'title', width: '100px'},
            {field: 'sellPoint', title: '商品卖点', width: '100px'},
            {field: 'price', title: '商品价格', width: '70px', align: 'right'},
            {field: 'num', title: '商品数量', width: '70px', align: 'right'},
            {field: 'barcode', title: '商品ID'},
            {field: 'cid', title: '商品ID'},
            {field: 'status', title: '商品ID'},
            {field: 'created', title: '商品ID'},
            {field: 'updated', title: '商品ID'}
        ]]
    });
</script>

