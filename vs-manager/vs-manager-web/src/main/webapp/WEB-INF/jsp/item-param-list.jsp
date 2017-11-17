<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/17
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="toolbar">
    <div>
        <button onclick="addParam()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="editParam()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑
        </button>
        <button onclick="deleteParam()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除
        </button>
    </div>
</div>
<table id="dgParam"/>
<script>
    $("#dgParam").datagrid({
        title: "商品规格参数列表",
        url: 'itemParams',
        striped: true,
        fit: true,
        pagination: true,
        rownumbers: true,
        pageSize: 20,
        pageList: [10, 20, 40],
        toolbar: '#toolbar',
        multiSort: true,
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: 'ID', width: '100px', sortable: true},
            {field: 'itemCatName', title: '商品类目', width: '100px'},
            {
                field: 'paramData', title: '规格(只显示分组名称)', width: '100px', formatter: function (value, rows, index) {
                    return value;
                }
            },

            {
                field: 'created', title: '创建时间', width: '100px', formatter: function (value, row, index) {
                return moment(value).format('LL');
                 }
            },
            {
                field: 'updated', title: '更新时间', width: '100px', formatter: function (value, row, index) {
                return moment(value).format('LL');
                 }
            }
        ]]
    });
</script>