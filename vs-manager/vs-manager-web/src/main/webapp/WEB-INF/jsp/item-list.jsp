<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017-11-9 0009
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="toolbar">
    <div style="padding: 5px;background-color: #fff">
        <label>商品标题:</label>
        <input class="easyui-textbox" type="box" id="title">
        <label>商品状态:</label>
        <select id="status" class="easyui-combobox" style="width: 60px">
            <option value="0">全部</option>
            <option value="1">正常</option>
            <option value="2">下架</option>
        </select>
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
    </div>
</div>
<script>

    function searchForm() {
        $('#dg').datagrid('load',{
            title:$('#title').val(),
            status:$('#status').combobox('getValue')
        })
    }

    function add() {
       tab();
    }

    function edit() {
        console.log('edit');
    }

    function remove() {
        var selects = $('#dg').datagrid('getSelections');
        if (selects.length == 0) {
            $.messager.alert('提示', '请至少选择一条记录');
            return;
        }
        $.messager.confirm('提示', '确认删除？', function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selects.length; i++) {
                    ids.push(selects[i].id);
                }
            }
            $.post(
                'items/batch',
                {"ids[]": ids, "status": 3},
                function () {
                    $('#dg').datagrid('reload');
                },
                'json'
            );
        })
    }

    function down() {
        var selects = $('#dg').datagrid('getSelections');
        if (selects.length == 0) {
            $.messager.alert('提示', '请至少选择一条记录');
            return;
        }
        $.messager.confirm('提示', '确认下架？', function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selects.length; i++) {
                    ids.push(selects[i].id);
                }
                $.post(
                    'items/batch',
                    {"ids": ids, "status": 2},
                    function () {
                        $("#dg").datagrid('reload');
                    },
                    'json'
                )
            }
        })
    }

    function up() {
        var selects = $("#dg").datagrid('getSelections');
        if (selects.length == 0) {
            $.messager.alert('提示', '请至少选择一条记录');
            return;
        }
        $.messager.confirm('提示', '确认上架？', function (r) {
            if (r) {
                var ids = [];
                for (var i = 0; i < selects.length; i++) {
                    ids.push(selects[i].id);
                }
            }
            $.post(
                'items/batch',
                {"ids": ids, "status": 1},
                function () {
                    $('#dg').datagrid('reload');
                },
                'json'
            )
        })
    }
//    var toolbar = [{
//        iconCls: 'icon-add',
//        text: '新增',
//        handler: function () {
//            console.log('add');
//        }
//    }, {
//        iconCls: 'icon-remove',
//        text: '删除',
//        handler: function () {
//            var selects = $('#dg').datagrid('getSelections');
//            if (selects.length == 0) {
//                $.messager.alert('提示', '请至少选择一条记录');
//                return;
//            }
//            $.messager.confirm('提示', '确认删除？', function (r) {
//                if (r) {
//                    var ids = [];
//                    for (var i = 0; i < selects.length; i++) {
//                        ids.push(selects[i].id);
//                    }
//                }
//                $.post(
//                    'items/batch',
//                    {"ids[]": ids, "status": 3},
//                    function () {
//                        $('#dg').datagrid('reload');
//                    },
//                    'json'
//                );
//            })
//        }
//    }, {
//        iconCls: 'icon-edit',
//        text: '编辑',
//        handler: function () {
//            console.log('edit');
//        }
//    }, {
//        iconCls: 'icon-up',
//        text: '上架',
//        handler: function () {
//            var selects = $("#dg").datagrid('getSelections');
//            if (selects.length == 0) {
//                $.messager.alert('提示', '请至少选择一条记录');
//                return;
//            }
//            $.messager.confirm('提示', '确认上架？', function (r) {
//                if (r) {
//                    var ids = [];
//                    for (var i = 0; i < selects.length; i++) {
//                        ids.push(selects[i].id);
//                    }
//                }
//                $.post(
//                    'items/batch',
//                    {"ids": ids, "status": 1},
//                    function () {
//                        $('#dg').datagrid('reload');
//                    },
//                    'json'
//                )
//            })
//        }
//    }, {
//        iconCls: 'icon-down',
//        text: '下架',
//        handler: function () {
//            var selects = $('#dg').datagrid('getSelections');
//            if (selects.length == 0) {
//                $.messager.alert('提示', '请至少选择一条记录');
//                return;
//            }
//            $.messager.confirm('提示', '确认下架？', function (r) {
//                if (r) {
//                    var ids = [];
//                    for (var i = 0; i < selects.length; i++) {
//                        ids.push(selects[i].id);
//                    }
//                    $.post(
//                        'items/batch',
//                        {"ids": ids, "status": 2},
//                        function () {
//                            $("#dg").datagrid('reload');
//                        },
//                        'json'
//                    )
//                }
//            })
//        }
//    }]

</script>
<table id="dg"></table>
<script>
    $("#dg").datagrid({
        url: 'items',
        striped: true,
        fit: true,
        pagination: true,
        rownumbers: true,
        pageSize: 20,
        pageList: [20, 40, 80],
        toolbar: '#toolbar',
        multiSort:true,
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '商品ID', width: '100px', sortable: true},
            {field: 'title', title: '商品名称', width: '100px', sortable: true},
            {field: 'sellPoint', title: '卖点', width: '100px'},
            {field: 'priceView', title: '商品价格', width: '100px'},
            {field: 'num', title: '商品数量', width: '100px'},
            {field: 'barcode', title: '商品ID', width: '100px'},
            {field: 'catName', title: '商品分类', width: '100px'},
            {field: 'statusName', title: '商品状态', width: '100px'},
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

