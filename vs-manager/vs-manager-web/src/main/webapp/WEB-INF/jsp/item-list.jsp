<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-11-9 0009
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    var toolbar = [{
        iconCls:'icon-add',
        text:'新增',
        handler:function () {
            console.log('add');
        }},{
        iconCls:'icon-remove',
        text:'删除',
        handler:function () {
            console.log('remove');
        }},{
        iconCls:'icon-edit',
        text:'编辑',
        handler:function () {
            console.log('edit');
        }},{
        iconCls:'icon-up',
        text:'上架',
        handler:function () {
            console.log('up');
        }},{
        iconCls:'icon-down',
        text:'下架',
        handler:function () {
            console.log('down');
        }
    }]
</script>
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
        toolbar:toolbar,
        columns: [[
            {field: 'ck', checkbox:true},
            {field: 'id', title: '商品ID', width: '100px'},
            {field: 'title', title: 'title', width: '100px'},
            {field: 'sellPoint', title: '卖点', width: '100px'},
            {field: 'price', title: '商品价格', width: '100px'},
            {field: 'num', title: '商品数量', width: '100px'},
            {field: 'barcode', title: '商品ID', width: '100px'},
            {field: 'catName', title: '商品分类', width: '100px'},
            {field: 'statusName', title: '商品状态', width: '100px'},
            {field: 'created', title: '创建时间', width: '100px'},
            {field: 'updated', title: '更新时间', width: '100px'}
        ]]
    });
</script>

