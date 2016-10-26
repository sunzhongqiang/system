//代码生成工具自动生成，请在此处填写 查询页面使用的js代码
    var dataGrid;
    var organizationTree;
    $(function() {
    
        dataGrid = $('#dataGrid').datagrid({
            url : '/operationLog/gridData',
            fit : true,
            fitColumns : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 50,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ 
                    {
                width : '80',
                title : '日志',
                field : 'id',
                align:'center'
            },
                    {
                width : '80',
                title : '用户id',
                field : 'userId',
            },
                    {
                width : '180',
                title : '用户名',
                field : 'username',
            },
                    {
                width : '80',
                title : '用户真实名称',
                field : 'realname',
            },
                    {
                width : '80',
                title : '角色编码',
                field : 'roleCode',
            },
                    {
                width : '80',
                title : '角色名称',
                field : 'roleName',
            },
                    {
                width : '180',
                title : '访问资源地址',
                field : 'functionUri',
            },
                    {
                width : '80',
                title : '资源名称',
                field : 'functionName',
            },
                    {
                width : '180',
                title : '访问日期',
                field : 'operationTime',
                formatter: formatDatebox
            },
                    {
                width : '80',
                title : '访问状态',
                field : 'status',
            },
                    {
                width : '180',
                title : '调用IP',
                field : 'ip',
            }] 
            ],
          
           
        });
    });
    
    function addFun() {
        parent.$.modalDialog({
            title : '添加',
            width : 500,
            height : 300,
            href : '/operationLog/add',
            buttons : [ {
                text : '添加',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } ]
        });
    }
    
    function deleteFun(id) {
        if (id == undefined) {//点击右键菜单才会触发这个
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {//点击操作里面的删除图标会触发这个
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.messager.confirm('询问', '您是否要删除系统操作日志？', function(b) {
            if (b) {
                progressLoad();
                    $.post('/operationLog/delete', {
                        id : id
                    }, function(result) {
                        if (result.success) {
                            parent.$.messager.alert('提示', result.msg, 'info');
                            dataGrid.datagrid('reload');
                        }
                        progressClose();
                    }, 'JSON');
                }
        });
    }
    
    function editFun(id) {
        if (id == undefined) {
            var rows = dataGrid.datagrid('getSelections');
            id = rows[0].id;
        } else {
            dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
        }
        parent.$.modalDialog({
            title : '编辑',
            width : 500,
            height : 300,
            href : '/operationLog/edit?id=' + id,
            buttons : [ {
                text : '编辑',
                handler : function() {
                    parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
                    var f = parent.$.modalDialog.handler.find('#modelForm');
                    f.submit();
                }
            } 
            ]
        });
    }
    
    function searchFun() {
        ////将searchForm表单内的元素序列为对象传递到后台
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        //找到form表单下的所有input标签并清空
        $('#searchForm input').val('');
        //重新加载数据，无填写数据，向后台传递值则为空
        dataGrid.datagrid('load', {});
    }
    